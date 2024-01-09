package com.movieapp.authentication.model;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Schema(description = "Creating model class for user response")
public class AuthenticationResponse {

  
    @Schema(description = "Username of the user doing login")
    private String userName;

    @Schema(description = "Password of the user doing login" )
    private String password;
}
