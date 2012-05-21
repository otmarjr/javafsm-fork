package com.tecacet.math.fsm;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class DFA<S, C> implements DeterministicFiniteAutomaton<S, C> {
    private final Alphabet<C> alphabet;
    private S initialState = null;
    private StateTransitionTable<S, C> transitionTable = new StateTransitionTable<S, C>();
    private Set<S> states = new LinkedHashSet<S>();
    private Set<S> finalStates = new HashSet<S>();

    private class PrivateDFABuilder implements DFABuilder<S, C> {

        @Override
        public DFABuilder<S, C> setInitialState(S initialState) throws DFABuilderException {
            if (null != DFA.this.initialState) {
                throw new DFABuilderException("Initial state already set");
            }
            DFA.this.initialState = initialState;
            states.add(initialState);
            return this;
        }

        @Override
        public DFABuilder<S, C> addFinalState(S state) throws DFABuilderException {
            DFA.this.addFinalState(state);
            return this;
        }

        @Override
        public DFABuilder<S, C> addTransition(S from, S to, C c) throws DFABuilderException {
            DFA.this.addTransition(from, to, c);
            return this;
        }

        @Override
        public DeterministicFiniteAutomaton<S, C> build() throws DFABuilderException {
            if (DFA.this.getInitialState() == null) {
                throw new DFABuilderException("Initial state is not specficied");
            }
            if (DFA.this.finalStates.isEmpty()) {
                throw new DFABuilderException("There must be at least one final state");
            }
            return DFA.this;
        }
    }

    private DFA(Alphabet<C> a) {
        this.alphabet = a;
    }

    @Override
    public Alphabet<C> getAlphabet() {
        return alphabet;
    }

    private void addFinalState(S state) {
        states.add(state);
        finalStates.add(state);
    }

    protected boolean containsState(S state) {
        return (states != null && states.contains(state));
    }

    private void addTransition(S from, S to, C c) throws DFABuilderException {
        if (!containsState(from)) {
            throw new DFABuilderException(String.format("State %s does not exist", from));
        }
        if (!alphabet.contains(c)) {
            throw new DFABuilderException(String.format("%s is not a valid alphabet symbol.", c));
        }
        states.add(to);
        transitionTable.addTransition(from, c, to);
    }

    @Override
    public S getNextState(S from, C c) throws DFAException {
        if (!containsState(from)) {
            throw new InvalidStateException(String.format("State %s does not exist", from));
        }
        return delta(from, c);
    }

    @Override
    public S getNextState(S from, Word<C> word) throws InvalidTransitionException {
        return delta_bar(from, word);
    }

    @Override
    public boolean accepts(Word<C> word) throws InvalidTransitionException {
        return isFinal(delta_bar(initialState, word));
    }

    /* Internal transition function */
    protected S delta(S from, C symbol) throws InvalidTransitionException {
        return transitionTable.getNextState(from, symbol);
    }

    private S delta_bar(S from, Word<C> word) throws InvalidTransitionException {
        if (word.length() == 0) {
            return from;
        }
        if (word.length() == 1) {
            return delta(from, word.symbolAt(0));
        } else {
            return delta_bar(delta(from, word.symbolAt(0)), word.substring(1));
        }
    }

    protected boolean isFinal(S zState) {
        return finalStates.contains(zState);
    }

    public String showTransitionDiagram() throws DFAException {
        StringBuilder sb = new StringBuilder();
        sb.append(" | ");
        for (S state : states) {
            sb.append(state + " | ");
        }
        sb.append("\n");

        // create rows 
        Collection<C> symbols = alphabet.getSymbolSet();
        for (C symbol : symbols) {
            sb.append(symbol + "| ");
            for (S state : states) {
                S nextState = getNextState(state, symbol);
                sb.append(nextState + " | ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public S getInitialState() {
        return initialState;
    }

    private DFABuilder<S, C> buidler = new PrivateDFABuilder();

    public static <S, C> DFABuilder<S, C> newDFA(Alphabet<C> alphabet) {
        return new DFA<S, C>(alphabet).buidler;
    }
}
