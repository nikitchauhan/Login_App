package com.login.Entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@Data
@Entity


@JsonPropertyOrder({"userId", "firstName", "lastName","password"})
@Table(name = "userdetails")
public class UserDetails {


    @Id
    @Column(name="userid")
    private int userId;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name="password")
    private String password;


    //mapping
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private AddressDetails address;
}
