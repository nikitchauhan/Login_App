package com.login.domain;


import lombok.*;
import org.springframework.stereotype.Service;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {

    private String userId ;
    private String firstName ;
    private String LastName ;


}
