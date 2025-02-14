package br.com.digital_wallet.app.user.model.dto;

import br.com.digital_wallet.app.user.model.entity.UserEntity;

public record User(String id, String username, String email, String password) {

    public static User getUser(UserEntity userEntity) {
        return new User(userEntity.getId().toString(), userEntity.getUsername(), userEntity.getEmail(), userEntity.getPassword());
    }
}
