package com.tecacet.math.fsm;

public interface MealyMachine<S,CI,CO> extends DeterministicFiniteAutomaton<S,CI> {

    Alphabet<CO> getOutputAlphabet();

    CO getOutput(S q, CI c);

}
