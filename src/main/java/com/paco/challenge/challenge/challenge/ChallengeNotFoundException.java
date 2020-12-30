package com.paco.challenge.challenge.challenge;

public class ChallengeNotFoundException extends RuntimeException{
    ChallengeNotFoundException(Long id) {
        super(String.format("Could not find challenge %d", id));
    }
}
