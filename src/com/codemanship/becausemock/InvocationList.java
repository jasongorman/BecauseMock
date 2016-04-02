package com.codemanship.becausemock;

import java.util.ArrayList;
import java.util.List;

public class InvocationList {

	protected List<MethodInvocation> invocations = new ArrayList<MethodInvocation>();
	protected final ArrayMatcher arrayMatcher;

	public InvocationList(ArrayMatcher arrayMatcher2) {
		this.arrayMatcher = arrayMatcher2;
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