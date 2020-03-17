package com.sunny.system.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author chenye
 * @date 2020-0314
 */
@Builder
@Entity
@Table(name = "sys_role")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@Data
@AllArgsConstructor
public class Role implements Serializable {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String id;

    @Column(name = "name", length = 50)
    private String userName;

}