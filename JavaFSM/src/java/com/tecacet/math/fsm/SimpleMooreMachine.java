package com.tecacet.math.fsm;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Simple implementation of the Moore Machine as a DFA with an output mapping for each state.
 *
 * @param <S>
 * @param <CI>
 * @param <CO>
 */
public class SimpleMooreMachine<S, CI, CO> implements MooreMachine<S, CI, CO> {

    private final Alphabet<CO> outputAlphabet;
    private Map<S, CO> outputMap = new HashMap<S, CO>();
    private DeterministicFiniteAutomaton<S, CI> dfa;

    private SimpleMooreMachine(DeterministicFiniteAutomaton<S, CI> dfa, Alphabet<CO> outputAlphabet) {
        this.dfa = dfa;
        this.outputAlphabet = outputAlphabet;
    }

    @Override
    public Alphabet<CO> getOutputAlphabet() {
        return outputAlphabet;
    }

    @Override
    public CO getOutput(S s) {
        return outputMap.get(s);
    }

    public Alphabet<CI> getAlphabet() {
        return dfa.getAlphabet();
    }

    public boolean accepts(Word<CI> word) throws DFAException {
        return dfa.accepts(word);
    }

    public S getInitialState() {
        return dfa.getInitialState();
    }

    public S getNextState(S from, CI symbol) throws DFAException {
        return dfa.getNextState(from, symbol);
    }

    public S getNextState(S from, Word<CI> word) throws DFAException {
        return dfa.getNextState(from, word);
    }
}
