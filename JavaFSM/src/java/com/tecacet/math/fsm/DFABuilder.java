package com.tecacet.math.fsm;

/**
 * 
 * Builder for a Deterministic Finite Automaton.
 * For the automaton to be complete it must have an initial state and at east one final state.
 *
 * @param <S>
 * @param <C>
 */
interface DFABuilder<S,C> {

    DFABuilder<S,C> setInitialState(S initialState) throws DFABuilderException;

    DFABuilder<S,C> addFinalState(S state) throws DFABuilderException;

    DFABuilder<S,C> addTransition(S from, S to, C c) throws DFABuilderException;

    DeterministicFiniteAutomaton<S,C> build() throws DFABuilderException;

}