package br.com.elo7.sonda.candidato.usecases.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProbeNotFoundException extends RuntimeException {
    public ProbeNotFoundException(String message) {
        super(message);
    }
}
