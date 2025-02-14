package br.com.digital_wallet.app.user.service;

import br.com.digital_wallet.app.user.handler.exception.UserAlreadyExistsException;
import br.com.digital_wallet.app.user.handler.exception.UserNotFoundException;
import br.com.digital_wallet.app.user.model.dto.User;
import br.com.digital_wallet.app.user.model.entity.UserEntity;
import br.com.digital_wallet.app.user.model.request.RequestCreateUser;
import br.com.digital_wallet.app.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {
    public static final Logger logger = LoggerFactory.getLogger(UserService.class);
    public static final String CLASS_NAME = UserService.class.getName();
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Transactional(rollbackFor = Exception.class)
    public void createUser(RequestCreateUser request) throws Exception {
        try {
            String cryptPassword = bCryptPasswordEncoder.encode(request.password());
            UserEntity user = new UserEntity(request.username(), cryptPassword, request.email());

            userRepository.save(user);

            logger.atInfo()
                    .addKeyValue("CLASS_NAME", CLASS_NAME)
                    .addKeyValue("METHOD", "createUser")
                    .log("User with username: {} saved successfully", user.getUsername());

        } catch (Exception exception) {
            logger.error(exception.getMessage());

            throw new UserAlreadyExistsException("User already exists");
        }
    }

    public User getLoggedUser(String username) {
        try {
            Optional<UserEntity> userEntity = this.userRepository.findByUsername(username);

            if (userEntity.isEmpty()) {
                throw new UserNotFoundException("User not found");
            }

            return User.getUser(userEntity.get());
        } catch (Exception exception) {
            throw new UserNotFoundException("User not found");
        }
    }
}
