package com.sunny.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author chenye
 */
@Entity
@Table(name = "sys_role")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@Data
public class Role implements Serializable {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String userId;

    @Column(name = "name", length = 50)
    private String name;

    private Role(Builder builder) {
        setUserId(builder.userId);
        setName(builder.name);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(Role copy) {
        Builder builder = new Builder();
        builder.userId = copy.getUserId();
        builder.name = copy.getName();
        return builder;
    }


    public static final class Builder {
        private String userId;
        private String name;

        private Builder() {
        }

        public Builder userId(String val) {
            userId = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Role build() {
            return new Role(this);
        }
    }
}