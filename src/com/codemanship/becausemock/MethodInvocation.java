package com.codemanship.becausemock;
import java.lang.reflect.Method;


class MethodInvocation {

	private final Method method;
	private final Object[] args;
	private Object value;

	MethodInvocation(Method method, Object[] args) {
		this.args = args;
		this.method = method;
	}

	void setReturnValue(Object value) {
		this.value = value;		
	}

	Object getReturnValue() {
		return value;
	}

	boolean matches(Method methodToVerify, Object[] argsToVerify, ArrayMatcher arrayMatcher) {
		if(method.equals(methodToVerify)){
			return arrayMatcher.match(argsToVerify, args);
		}
		return false;
	}

}
