package com.codemanship.becausemock;

import org.junit.Before;
import org.junit.Test;

import static com.codemanship.becausemock.BecauseMock.mock;
import static com.codemanship.becausemock.BecauseMock.verify;
import static org.junit.Assert.*;

public class BecauseMockTests {

	private MyInterface mock;

	@Test
	public void methodInvokedAllowsTestToPass() {
		mock.doFoo();
		verify(mock).doFoo();
	}

	@Before
	public void createMock() {
		mock = mock(MyInterface.class);
	}
	
	@Test(expected=MockException.class)
	public void methodNotInvokedCausesMockException() {
		verify(mock).doFoo();
	}
	
	@Test(expected=MockException.class)
	public void whenNotAllParamValuesMatchExpectedExceptionIsThrown() {
		mock.newFoo(0, 2);
		verify(mock ).newFoo(1,2);
	}
	
	@Test
	public void whenAllParamsMatchExpectedNoExceptionThrown() {
		mock.newFoo(1,2);
		verify(mock).newFoo(1,2);
	}
	
	@Test
	public void returnsSpecifiedStubValuesForMethodCalls() {
		BecauseMock.when(mock.getFoo()).thenReturn(1);
		assertEquals(1, mock.getFoo());
	}

}
