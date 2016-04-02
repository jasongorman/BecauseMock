package com.codemanship.becausemock;

import java.lang.reflect.Method;

class Stubs extends InvocationList {

	private final DefaultValueGenerator defaultValueGenerator;

	Stubs(ArrayMatcher arrayMatcher, DefaultValueGenerator defaultValueGenerator) {
		super(arrayMatcher);
		this.defaultValueGenerator = defaultValueGenerator;
	}

	Object findReturnValue(Method method, Object[] args) {
		for (MethodInvocation stub : invocations) {
			if(stub.matches(method, args, arrayMatcher)){
				invocations.remove(stub);
				return stub.getReturnValue();
			}
		}
		return defaultValueGenerator.getDefaultFor(method);
	}

	void thenReturn(Object value) {
		MethodInvocation invocation = getLast();
		invocation.setReturnValue(value);
	}

}