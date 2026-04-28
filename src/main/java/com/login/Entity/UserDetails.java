package com.login.Entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "userdetails")
public class UserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userid")
    private int userId;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;
}
