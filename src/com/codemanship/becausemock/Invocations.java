package com.codemanship.becausemock;

import java.lang.reflect.Method;

class Invocations extends InvocationList {

	Invocations(ArrayMatcher arrayMatcher) {
		super(arrayMatcher);
	}

	boolean matchFound(Method method, Object[] args) {
		for (MethodInvocation invocation : invocations) {
			if(invocation.matches(method, args, arrayMatcher))
				return true;
		}
		return false;
	}

}