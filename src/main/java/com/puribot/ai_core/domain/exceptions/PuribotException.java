package com.puribot.ai_core.domain.exceptions;

public abstract class PuribotException extends RuntimeException {
    protected PuribotException(String message) {
        super(message);
    }
}
