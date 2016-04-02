package com.codemanship.becausemock;

import static org.junit.Assert.*;

import java.lang.reflect.Method;

import org.junit.Test;

public class StubsTests {

	@Test
	public void findsReturnValueForMatchingMethodInvocation() throws NoSuchMethodException, SecurityException {
		Object stubValue = 1;
		Stubs stubs = new Stubs(new ArrayMatcher(), new DefaultValueGenerator());
		Method fooMethod = this.getClass().getMethod("foo");
		stubs.add(new MethodInvocation(fooMethod, new Object[]{}));
		stubs.thenReturn(stubValue);
		assertEquals(stubValue, stubs.findReturnValue(fooMethod , new Object[]{}) );
	}
	
	@Test
	public void returnsDefaultValueIfNoMatchingStubFound() throws Exception {
		Stubs stubs = new Stubs(new ArrayMatcher(), new DefaultValueGenerator());
		Method fooMethod = this.getClass().getMethod("foo");
		assertEquals(0, stubs.findReturnValue(fooMethod , new Object[]{}) );
	}
	
	public int foo(){
		return -1;
	}

}
