package com.sprhib.model;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Integer id;

    @Column(name = "name", updatable = false)
    private String name;

    @Column(name = "age", updatable = false)
    private Integer age;

    @Type(type="boolean")
    @Column(name = "isAdmin", updatable = false)
    private Boolean isAdmin;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdDate", updatable = false)
    private Date createdDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public Date  getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate =  createdDate;
    }
}
