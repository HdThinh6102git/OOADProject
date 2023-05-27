package com.hcmute.edu.vn.OronProject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthenticationRequestDTO {
    private String userName;
    private String password;
}
