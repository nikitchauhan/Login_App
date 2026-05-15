package com.login.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="address")
public class AddressDetails {



    @Id
    @Column(name = "user_id")
    private int userId;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "pin_code")
    private String pinCode;

    @Column(name = "street_name")
    private String streetName;


    @OneToOne
    @JsonBackReference
    @JoinColumn(name = "user_id")
    private UserDetails user;



}
