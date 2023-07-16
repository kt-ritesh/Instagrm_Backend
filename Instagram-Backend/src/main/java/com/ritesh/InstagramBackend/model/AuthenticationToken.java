package com.ritesh.InstagramBackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AuthenticationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tokenId;
    private String tokenValue;
    private LocalDateTime tokenCreationDateTime;

    //mapping
    @OneToOne
    @JoinColumn(name = "fk_user_Id")
    User user;


    public AuthenticationToken(User user){
        this.tokenCreationDateTime = LocalDateTime.now();
        this.tokenValue = UUID.randomUUID().toString();
        this.user = user;
    }
}
