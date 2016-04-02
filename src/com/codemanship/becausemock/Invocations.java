package com.codemanship.becausemock;

import java.lang.reflect.Method;

class Invocations extends InvocationList {

	public Invocations(ArrayMatcher arrayMatcher) {
		super(arrayMatcher);
	}

	boolean matchFound(Method method, Object[] args) {
		boolean wasInvoked = false;
		for (MethodInvocation invocation : invocations) {
			if(invocation.getMethod().equals(method)){
				wasInvoked  = arrayMatcher.match(args, invocation.getArgs());
				break;
			}
		}
		return wasInvoked;
	}

}