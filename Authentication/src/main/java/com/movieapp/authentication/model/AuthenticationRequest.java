package com.movieapp.authentication.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Schema(description = "Creating model class for user logging in")
@Table(name="AuthenticationRequest")
public class AuthenticationRequest {

    @Id
    @Schema(description = "Username of the user doing login")
    private String userName;

    @Schema(description = "Password of the user doing login" )
    private String password;


}
