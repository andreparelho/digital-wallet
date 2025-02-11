package br.com.digital_wallet.app.user.model.dto;

public record User(String id, String username, String password) {

    public static User createUser(String id, String username, String password) {
        return new User(id, username, password);
    }

    public static User updateUser(String id, String username, String password) {
        return new User(id, username, password);
    }
}
