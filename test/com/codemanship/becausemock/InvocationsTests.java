package com.codemanship.becausemock;

import static org.junit.Assert.*;

import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

public class InvocationsTests {

	private Invocations invocations;
	private Method fooMethod;

	@Before
	public void setUp() throws NoSuchMethodException, SecurityException {
		invocations = new Invocations(new ArrayMatcher());
		fooMethod = this.getClass().getMethod("foo");
	}

	@Test
	public void findsNoMatchWhenMethodNotInvoked() throws NoSuchMethodException, SecurityException {
		assertFalse(invocations.matchFound(fooMethod, new Object[]{}  ) );
	}
	
	@Test
	public void findsMatchWhenMethodInvoked() throws NoSuchMethodException, SecurityException {
		invocations.add(new MethodInvocation(fooMethod, new Object[]{}));
		assertTrue(invocations.matchFound(fooMethod, new Object[]{}  ) );
	}
	
	public void foo(){}

}
