package br.com.digital_wallet.app.login.handler;

import br.com.digital_wallet.app.common.exception.ExceptionResponse;
import br.com.digital_wallet.app.login.handler.exception.PasswordNotValidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;

public class LoginHandlerController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(PasswordNotValidException.class)
    public final ResponseEntity<ExceptionResponse> handlePasswordNotValidException(Exception exception, WebRequest webRequest){
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDate.now(), exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
