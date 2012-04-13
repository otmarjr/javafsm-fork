package com.tecacet.math.fsm;

public interface MooreMachine<S, CI, CO> extends DeterministicFiniteAutomaton<S, CI> {

    Alphabet<CO> getOutputAlphabet();

    CO getOutput(S s);

}
