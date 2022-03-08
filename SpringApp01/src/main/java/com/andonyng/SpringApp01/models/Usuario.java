package com.andonyng.SpringApp01.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @Column (name = "username")
    private String username;
    @Column (name = "telephone")
    private String telephone;
    @Column (name = "email")
    private String email;
    @Column (name = "password")
    private String password;
    @Column (name = "id")
    private long id;

    public Usuario(){}

    public Usuario(String username, String telephone, String email, String password, long id) {
        this.username = username;
        this.telephone = telephone;
        this.email = email;
        this.password = password;
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
