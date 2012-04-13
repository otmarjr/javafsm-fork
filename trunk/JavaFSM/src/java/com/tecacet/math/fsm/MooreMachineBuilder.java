package com.tecacet.math.fsm;

public interface MooreMachineBuilder<S,CI, CO> extends DFABuilder<S, CI>{

    void addOutput(S state, CO output);
}
