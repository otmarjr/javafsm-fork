package com.tecacet.math.fsm;

public interface NFABuilder<S,C> extends FABuilder<S, C> {

	NonDeterministicFiniteAutomaton<S, C> build() throws FABuilderException;
}
