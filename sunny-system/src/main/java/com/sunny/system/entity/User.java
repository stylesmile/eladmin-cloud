package com.sunny.system.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 用户实体
 *
 * @author chenye
 * 2020-0313
 * 使用JPA注解配置映射关系
 * Entity 告诉JPA这是一个实体类（和数据表映射的类）
 * Table @Table来指定和哪个数据表对应;如果省略默认表名就是user
 * DynamicInsert  EntityListeners 动态修改
 * GenericGenerator 生成uuid
 */
@Entity
@Table(name = "sys_user")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)

@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class User implements Serializable {

    /**
     * 自增主键
     */
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "id", length = 100)
    private String id;

    @Column(name = "name", length = 50)
    private String name;
    /**
     * 省略默认列名就是属性名
     */
    @Column(length = 50)
    private String password;

    @Column(length = 100)
    private String email;

}