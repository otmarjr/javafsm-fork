package com.tecacet.math.fsm;

/**
 * A Deterministic Finite Automaton consists of: 1. An Alphabet A 2. A set of States S 3. A function delta: SxA -> S 4.
 * An initial state s0 in S
 * 
 * @param S
 *            parametrizes the set of states
 * @param C
 *            parametrizes the set of alphabet symbols
 */
public interface DeterministicFiniteAutomaton<S, C> extends FiniteAutomaton<C>, StateTransitionDiagram<S, C> {

    S getInitialState();

    S getNextState(S from, Word<C> word) throws DFAException;

}
