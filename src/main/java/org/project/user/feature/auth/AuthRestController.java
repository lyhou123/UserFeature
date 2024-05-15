package org.project.user.feature.auth;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.project.user.feature.auth.dto.AuthRequest;
import org.project.user.feature.auth.dto.AuthRespone;
import org.project.user.feature.auth.dto.RefresTokenRequest;
import org.project.user.feature.user.dto.UserRequest;
import org.project.user.feature.user.dto.UserResponse;
import org.project.user.feature.user.service.UserService;
import org.project.user.utils.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
@SecurityRequirements(value = {})
public class AuthRestController {

    private final AuthServiceImpl authService;

    private final UserService userService;

    @PostMapping("/login")
    public BaseResponse<AuthRespone> login(@RequestBody AuthRequest authRequest)
    {
        return BaseResponse.<AuthRespone>readSuccess()
                .setPayload(authService.login(authRequest));
    }

   @PostMapping("/signup")
    public String signup()
    {
        return "signup";
    }

    @PostMapping("/refresh")
    public BaseResponse<AuthRespone> refreshToken(@RequestBody RefresTokenRequest refresTokenRequest)
    {
        return BaseResponse.<AuthRespone>readSuccess()
                .setPayload(authService.refreshToken(refresTokenRequest));
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Register new user"
            , requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            content = @Content(schema = @Schema(implementation = UserRequest.class),
                    examples = @ExampleObject(value = """
                {
                    "firstName": "lyhou",
                    "lastName": "phiv",
                    "gender" : "male",
                    "email": "lyhou123@gmail.com",
                    "phoneNumber": "0123456789",
                    "password": "123456",
                    "avatar": "https://www.google.com",
                    "isActive": true,
                    "isDisable": false,
                    "createdDate": "2021-09-09"
                }
            """)

            )
    )
    )
    public BaseResponse<UserResponse> registerUser(
            @Valid @RequestBody UserRequest userRequest) {
        return BaseResponse.<UserResponse>createSuccess()
                .setPayload(userService.createUser(userRequest));
    }
}
