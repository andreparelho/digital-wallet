package br.com.digital_wallet.app.user.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;

    public UserEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }

    protected UserEntity() {
        this.id = null;
        this.username = null;
        this.password = null;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void createUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void updateUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void updateUsername(String username) {
        this.username = username;
    }

    public void updatePassword(String password) {
        this.password = password;
    }
}
