package com.ritesh.InstagramBackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignUpOutput {

    private Boolean signUpStatus;
    private String signUpMessage;

}
