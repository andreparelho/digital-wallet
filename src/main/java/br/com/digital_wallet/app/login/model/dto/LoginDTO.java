package br.com.digital_wallet.app.login.model.dto;

public record LoginDTO(String token, long expiresAt) {
}
