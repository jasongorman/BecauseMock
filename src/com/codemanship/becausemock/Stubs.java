package com.codemanship.becausemock;

import java.lang.reflect.Method;

class Stubs extends InvocationList {

	private final DefaultValueGenerator defaultValueGenerator;

	Stubs(ArrayMatcher arrayMatcher, DefaultValueGenerator defaultValueGenerator) {
		super(arrayMatcher);
		this.defaultValueGenerator = defaultValueGenerator;
	}

	Object findReturnValue(Method method, Object[] args) {
		Object returnValue = defaultValueGenerator.getDefaultFor(method);
		for (MethodInvocation stub : invocations) {
			if(stub.getMethod() == method && arrayMatcher.match(args, stub.getArgs())){
				returnValue = stub.getReturnValue();
				invocations.remove(stub);
				break;
			}
		}
		return returnValue;
	}

	void thenReturn(Object value) {
		MethodInvocation invocation = getLast();
		invocation.setReturnValue(value);
	}

}