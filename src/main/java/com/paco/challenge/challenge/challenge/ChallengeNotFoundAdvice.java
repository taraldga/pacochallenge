package com.paco.challenge.challenge.challenge;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ChallengeNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ChallengeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String challengeNotFoundHanler(ChallengeNotFoundException ex) {
        return ex.getMessage();
    }
}
