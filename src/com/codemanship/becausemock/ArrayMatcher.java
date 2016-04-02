package com.codemanship.becausemock;

class ArrayMatcher {

	boolean match(Object[] expected, Object[] actual) {
		boolean match = true;
		for (int i = 0; i < expected.length; i++) {
			match = match && (actual[i] == expected[i]);
		}
		return match;
	}

}
