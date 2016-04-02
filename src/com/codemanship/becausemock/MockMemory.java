package com.codemanship.becausemock;
import java.lang.reflect.Method;

import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.This;


public class MockMemory {
	
	private boolean verifying = false;
	private final Stubs stubs;
	private final Invocations invocations;
	
	public MockMemory(Stubs stubs, Invocations invocations) {
		this.stubs = stubs;
		this.invocations = invocations;
	}

	@RuntimeType
	public Object invoked(@This Mock mock, @AllArguments Object[] args, @Origin Method method ){
		BecauseMock.activeMock = mock;
		Object returnValue = null;
		if(!verifying) {
			returnValue = recordInvocation(args, method, returnValue);
		} else {
			verifyInvocation(method, args);
		}
		return returnValue;
	}	

	void verify(){
		verifying = true;
	}

	void when() {
		MethodInvocation invocation = invocations.getLast();
		invocations.remove(invocation);
		stubs.add(invocation);
	}

	void thenReturn(Object value) {
		stubs.thenReturn(value);
	}

	private void verifyInvocation(Method method, Object[] args) {
		if(!invocations.matchFound(method, args)){
			throw new MockException(method, args);
		}
	}

	private Object recordInvocation(Object[] args, Method method, Object returnValue) {
		invocations.add(new MethodInvocation(method, args));
		returnValue = stubs.findReturnValue(method, args);
		return returnValue;
	}
}
