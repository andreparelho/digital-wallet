package br.com.digital_wallet.app.user.handler;

import java.io.Serializable;
import java.time.LocalDate;

public record ExceptionResponse(LocalDate timestamp,
                                String message,
                                String details) implements Serializable {
    private static final long serialVersionUID = 1L;

    public static ExceptionResponse createException(LocalDate timestamp, String message, String details) {
        return new ExceptionResponse(timestamp, message, details);
    }
}
