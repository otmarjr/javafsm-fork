package com.tecacet.math.fsm;

@SuppressWarnings("serial")
public class InvalidTransitionException extends DFAException {

    public InvalidTransitionException(String message) {
        super(message);
    }

}
