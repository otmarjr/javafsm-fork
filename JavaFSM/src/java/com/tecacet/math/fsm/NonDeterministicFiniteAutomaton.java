package com.tecacet.math.fsm;

public interface NonDeterministicFiniteAutomaton<S> extends FiniteAutomaton<S> {
    
    S[] getNextStates(S q, char c); // transition function delta

    S[] getStates(S q, String s); // The extended transition function delta

}
