package br.com.digital_wallet.app.user.service;

import br.com.digital_wallet.app.user.handler.exceptions.UserAlreadyExistsException;
import br.com.digital_wallet.app.user.model.entity.UserEntity;
import br.com.digital_wallet.app.user.model.request.RequestCreateUser;
import br.com.digital_wallet.app.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    public static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(RequestCreateUser request) throws Exception {
        try {
            UserEntity user = new UserEntity(request.username(), request.password());

            userRepository.save(user);

            logger.info("User with username: {} saved successfully", user.getUsername());
        } catch (Exception exception) {
            logger.error(exception.getMessage());

            throw new UserAlreadyExistsException("User already exists");
        }
    }
}
