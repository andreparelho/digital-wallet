package br.com.digital_wallet.app.login.controller;


import br.com.digital_wallet.app.login.model.response.LoginResponse;
import br.com.digital_wallet.app.login.model.request.LoginRequest;
import br.com.digital_wallet.app.login.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.com.digital_wallet.app.login.constants.LoginConstants.LOGIN_ENDPOINT;

@RestController
@RequestMapping(LOGIN_ENDPOINT)
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        LoginResponse response = this.loginService.login(loginRequest);

        return ResponseEntity.ok(response);
    }

}
