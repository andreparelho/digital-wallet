package br.com.digital_wallet.app.user.controller;


import br.com.digital_wallet.app.user.model.request.RequestCreateUser;
import br.com.digital_wallet.app.user.service.CreateUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private static final String USER_ENDPOINT = "user";

    private final CreateUserService createUserService;

    public UserController(CreateUserService createUserService) {
        this.createUserService = createUserService;
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody RequestCreateUser requestCreateUser) {
        createUserService.createUser(requestCreateUser);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
