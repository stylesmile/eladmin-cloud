package com.sunny.entity;

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