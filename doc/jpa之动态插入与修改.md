https://blog.csdn.net/qq_34874784/article/details/104846923
1.动态插入

package com.example.springbootjpa.entity;
 
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
 
import javax.persistence.*;
 
/**
 * @author chenye
 * 2020-0313
 */
//使用JPA注解配置映射关系
@Entity //告诉JPA这是一个实体类（和数据表映射的类）
@Table(name = "sys_user") //@Table来指定和哪个数据表对应;如果省略默认表名就是user；
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
public class User {
 
    /**
     * 自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
 
    @Column(name = "name", length = 50)
    private String name;
    /**
     * 省略默认列名就是属性名
     */
    @Column(length = 50)
    private String email;
 
}
关键注解：

@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
2.重写save（修改）：

package com.example.springbootjpa.repository;
 
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.util.StringUtils;
 
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;
 
@SuppressWarnings(value = "all")
public class JpaRepositoryReBuild<T, ID> extends SimpleJpaRepository<T, ID> {
 
    private final JpaEntityInformation<T, ?> entityInformation;
    private final EntityManager em;
 
    @Autowired
    public JpaRepositoryReBuild(
            JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityInformation = entityInformation;
        this.em = entityManager;
    }
 
    /**
     * 通用save方法 ：新增/选择性更新
     */
    @Override
    @Transactional
    public <S extends T> S save(S entity) {
 
        // 获取ID
        ID entityId = (ID) this.entityInformation.getId(entity);
        T managedEntity;
        T mergedEntity;
        if (entityId == null) {
            em.persist(entity);
            mergedEntity = entity;
        } else {
            managedEntity = this.findById(entityId).get();
            if (managedEntity == null) {
                em.persist(entity);
                mergedEntity = entity;
            } else {
                BeanUtils.copyProperties(entity, managedEntity, getNullProperties(entity));
                em.merge(managedEntity);
                mergedEntity = managedEntity;
            }
        }
        return entity;
    }
 
    /**
     * 获取对象的空属性
     */
    private static String[] getNullProperties(Object src) {
        // 1.获取Bean
        BeanWrapper srcBean = new BeanWrapperImpl(src);
        // 2.获取Bean的属性描述
        PropertyDescriptor[] pds = srcBean.getPropertyDescriptors();
        // 3.获取Bean的空属性
        Set<String> properties = new HashSet<>();
        for (PropertyDescriptor propertyDescriptor : pds) {
            String propertyName = propertyDescriptor.getName();
            Object propertyValue = srcBean.getPropertyValue(propertyName);
            if (StringUtils.isEmpty(propertyValue)) {
                srcBean.setPropertyValue(propertyName, null);
                properties.add(propertyName);
            }
        }
        return properties.toArray(new String[0]);
    }
}
3.启动类

package com.example.springbootjpa;
 
import JpaRepositoryReBuild;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
 
/**
 * 启动类
 *
 * @author chenye
 * @date 2020-0313
 */
@EnableJpaAuditing
@SpringBootApplication
@EnableJpaRepositories(
        value = {"com.example.springbootjpa.repository"},
        repositoryBaseClass = JpaRepositoryReBuild.class)//最好添加
@EntityScan(basePackages = {"com.example.springbootjpa.entity"})//最好添加
public class SpringbootJpaApplication {
 
    public static void main(String[] args) {
        SpringApplication.run(SpringbootJpaApplication.class, args);
    }
 
}
关键注释：

EnableJpaRepositories 扫描的repository包
repositoryBaseClass 重写的save类
EnableJpaAuditing 使@EntityListeners(AuditingEntityListener.class) 生效