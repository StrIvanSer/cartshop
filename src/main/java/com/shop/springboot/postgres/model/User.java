package com.shop.springboot.postgres.model;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;

/**
 * Таблица пользователи
 *
 * @author Streltsov Ivan
 * @version 1.0
 */

@Entity
@Setter
@Getter
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 5, message = "Не менее 5 знаков")
    private String username;

    @Size(min = 7, message = "Не менее 7 знаков")
    private String email;

    @Size(min = 2, message = "Не менее 5 знаков")
    private String password;

    @Transient
    private String passwordConfirm;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    public User() {
    }


//    @Override
//    public String getUsername() {
//        return username;
//    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getPassword() {
        return password;
    }

//    public String getPasswordConfirm() {
//        return passwordConfirm;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public void setPasswordConfirm(String passwordConfirm) {
//        this.passwordConfirm = passwordConfirm;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public Set<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
//    }

}
