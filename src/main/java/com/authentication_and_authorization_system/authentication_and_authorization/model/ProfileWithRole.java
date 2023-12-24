package com.authentication_and_authorization_system.authentication_and_authorization.model;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
//import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="ProfileWithRole")
public class ProfileWithRole{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    @Column(nullable = false)
    private Profiles user;

    @ManyToOne
    @JoinColumn(name = "role_id")
    @Column(nullable = false)
    private Roles role;

    public ProfileWithRole(){

    }


    public ProfileWithRole(Profiles user, Roles role) {
        super();
        this.user = user;
        this.role = role;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Profiles getProfile() {
        return user;
    }
    public void setProfile(Profiles user) {
        this.user = user;
    }
    public Roles getRole() {
        return role;
    }
    public void setRole(Roles role) {
        this.role = role;
    }
}