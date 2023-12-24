package com.authentication_and_authorization_system.authentication_and_authorization.model;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
//import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Profiles")
public class Profiles{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="phone")
    private String phone;
    @Column(name="email")
    private String email;

    public Profiles() {

    }

    public Profiles(String name, String phone, String email) {
        super();
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}