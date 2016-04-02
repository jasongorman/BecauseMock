package com.codemanship.becausemock;

import java.util.ArrayList;
import java.util.List;

public class InvocationList {

	protected final List<MethodInvocation> invocations = new ArrayList<MethodInvocation>();
	protected final ArrayMatcher arrayMatcher;

	public InvocationList(ArrayMatcher arrayMatcher) {
		this.arrayMatcher = arrayMatcher;
	}

	void add(MethodInvocation stub) {
		invocations.add(stub);
	}

	void remove(MethodInvocation stub) {
		invocations.remove(stub);
	}

	MethodInvocation getLast() {
		return invocations.get(invocations.size() - 1);
	}

}