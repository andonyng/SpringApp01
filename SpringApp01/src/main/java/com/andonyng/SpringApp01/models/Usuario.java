package com.andonyng.SpringApp01.models;

import javax.persistence.*;

//Modelo de datos "Usuario
//Con @Entity indicamos que es una entidad
//Con @Table indicamos la tabla a la que equivale la entidad en la base de datos
@Entity
@Table(name = "usuarios")
public class Usuario {

    //Con @Id indicamos el campo que sirve como Id
    //Con @GeneratedValue indicamos que es un campo que se genera automáticamente (En este caso el id es AutoIncrement)
    //Con @Column vamos indicando a que columna equivale cada atributo en la tabla de la base de datos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private long id;
    @Column (name = "username")
    private String username;
    @Column (name = "telephone")
    private String telephone;
    @Column (name = "email")
    private String email;
    @Column (name = "password")
    private String password;

    public Usuario(){}

    public Usuario(String username, String telephone, String email, String password) {
        this.username = username;
        this.telephone = telephone;
        this.email = email;
        this.password = password;
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
