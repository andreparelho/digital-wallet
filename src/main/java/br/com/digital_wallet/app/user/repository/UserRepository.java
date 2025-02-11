package br.com.digital_wallet.app.user.repository;

import br.com.digital_wallet.app.user.model.dto.User;
import br.com.digital_wallet.app.user.model.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserRepository {

    private final Map<String, UserEntity> userDatabase;

    public UserRepository(Map<String, UserEntity> userDatabase) {
        this.userDatabase = userDatabase;
    }

    public UserEntity createUser(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.id());
        userEntity.setUsername(user.username());
        userEntity.setPassword(user.password());

        userDatabase.put(userEntity.getId(), userEntity);

        return userEntity;
    }

    public UserEntity getUser(User user) {
        return userDatabase.get(user.id());
    }
}
