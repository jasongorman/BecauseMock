package com.codemanship.becausemock;

import static org.junit.Assert.*;

import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

public class StubsTests {

	private Stubs stubs;
	private Method fooMethod;

	@Before
	public void createStub() throws NoSuchMethodException, SecurityException {
		stubs = new Stubs(new ArrayMatcher(), new DefaultValueGenerator());
		fooMethod = this.getClass().getMethod("foo");
	}
	
	@Test
	public void findsReturnValueForMatchingMethodInvocation() throws NoSuchMethodException, SecurityException {
		Object stubValue = 1;
		stubs.add(new MethodInvocation(fooMethod, new Object[]{}));
		stubs.thenReturn(stubValue);
		assertEquals(stubValue, stubs.findReturnValue(fooMethod , new Object[]{}) );
	}
	
	@Test
	public void returnsDefaultValueIfNoMatchingStubFound() throws NoSuchMethodException, SecurityException {
		assertEquals(0, stubs.findReturnValue(fooMethod , new Object[]{}) );
	}
	
	public int foo(){
		return -1;
	}

}
