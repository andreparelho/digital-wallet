package br.com.digital_wallet.app.login.model.response;

import java.time.Instant;

public record LoginResponse(String token, Instant expiredAt) {
}
