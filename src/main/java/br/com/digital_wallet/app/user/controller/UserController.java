package br.com.digital_wallet.app.user.controller;


import br.com.digital_wallet.app.user.model.entity.UserEntity;
import br.com.digital_wallet.app.user.model.request.RequestCreateUser;
import br.com.digital_wallet.app.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static br.com.digital_wallet.app.user.util.UserConstants.USER_ENDPOINT;

@RestController
@RequestMapping(USER_ENDPOINT)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody RequestCreateUser requestCreateUser) throws Exception {
        userService.createUser(requestCreateUser);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
