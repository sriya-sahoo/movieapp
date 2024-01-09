package com.movieapp.userservice.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Send the details to authentication service")
public class AuthenticationRequest {
	@Schema(description = "Username of the user doing login")
    private String userName;

    @Schema(description = "Password of the user doing login" )
    private String password;

}
