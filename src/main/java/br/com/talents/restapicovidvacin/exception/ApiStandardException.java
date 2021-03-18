package br.com.talents.restapicovidvacin.exception;

import org.springframework.http.HttpStatus;

public interface ApiStandardException {
    HttpStatus getHttpStatus();
    String getMessage();
}
