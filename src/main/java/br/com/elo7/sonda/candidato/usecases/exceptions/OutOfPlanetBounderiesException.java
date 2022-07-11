package br.com.elo7.sonda.candidato.usecases.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class OutOfPlanetBounderiesException extends RuntimeException {
    public OutOfPlanetBounderiesException(String message) {
        super(message);
    }
}
