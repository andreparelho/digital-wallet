package br.com.digital_wallet.app.user.service;

import br.com.digital_wallet.app.user.model.dto.User;
import br.com.digital_wallet.app.user.model.request.RequestCreateUser;
import br.com.digital_wallet.app.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateUserService {

    private final UserRepository userRepository;

    public CreateUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(RequestCreateUser request) {
        User user = User.createUser(UUID.randomUUID().toString(), request.username(), request.password());

        userRepository.createUser(user);
    }
}
