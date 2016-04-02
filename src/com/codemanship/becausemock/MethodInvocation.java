package com.codemanship.becausemock;
import java.lang.reflect.Method;


public class MethodInvocation {

	private final Method method;
	private final Object[] args;
	private Object value;

	public MethodInvocation(Method method, Object[] args) {
		this.args = args;
		this.method = method;
	}

	public Method getMethod() {
		return method;
	}

	public Object[] getArgs() {
		return args;
	}

	public void setReturnValue(Object value) {
		this.value = value;		
	}

	public Object getReturnValue() {
		return value;
	}

	protected boolean matches(Method methodToVerify, Object[] args, ArrayMatcher arrayMatcher) {
		if(method.equals(methodToVerify)){
			return arrayMatcher.match(args, getArgs());
		}
		return false;
	}

}
