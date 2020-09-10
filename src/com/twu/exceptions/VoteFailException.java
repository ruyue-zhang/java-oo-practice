package com.twu.exceptions;

public class VoteFailException extends RuntimeException {
    public VoteFailException(String message) {
        super(message);
    }
}
