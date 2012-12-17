package com.tecacet.math.fsm;

/* A State-symbol pair identifies a unique transition */
class Pair<S,C> {
	S state;
	C symbol;

	Pair(S state, C c) {
		this.state = state;
		this.symbol = c;
	}

	@SuppressWarnings("unchecked")
	public boolean equals(Object object) {
		Pair<S,C> pair = (Pair<S,C>) object;
		return (state.equals(pair.state) && symbol == pair.symbol);
	}

	public int hashCode() {
		// TODO better hash code
		return (state.hashCode() + (31 ^ state.toString().length())
				* symbol.hashCode());
	}
} 