package com.codemanship.becausemock;

import org.junit.Test;

import static com.codemanship.becausemock.BecauseMock.mock;
import static com.codemanship.becausemock.BecauseMock.verify;
import static org.junit.Assert.*;

public class BecauseMockTests {

	@Test
	public void methodInvokedAllowsTestToPass() {
		MyInterface mock = mock(MyInterface.class);
		mock.doFoo();
		verify(mock).doFoo();
	}
	
	@Test(expected=MockException.class)
	public void methodNotInvokedCausesMockException() throws Exception {
		MyInterface mock = mock(MyInterface.class);
		verify(mock).doFoo();
	}
	
	@Test(expected=MockException.class)
	public void whenNotAllParamValuesMatchExpectedExceptionIsThrown() throws Exception {
		MyInterface mock = mock(MyInterface.class);
		mock.newFoo(0, 2);
		verify(mock ).newFoo(1,2);
	}
	
	@Test
	public void whenAllParamsMatchExpectedNoExceptionThrown() throws Exception {
		MyInterface mock = mock(MyInterface.class);
		mock.newFoo(1,2);
		verify(mock).newFoo(1,2);
	}
	
	@Test
	public void returnsSpecifiedStubValuesForMethodCalls() throws Exception {
		MyInterface stub = mock(MyInterface.class);
		BecauseMock.when(stub.getFoo()).thenReturn(1);
		assertEquals(1, stub.getFoo());
	}
	
	@Test
	public void twoStubsReturnCorrectValues() throws Exception {
		MyInterface mock1 = mock(MyInterface.class);
		MyInterface mock2 = mock(MyInterface.class);
		BecauseMock.when(mock1.fooBoolean()).thenReturn(true);
		BecauseMock.when(mock2.fooInt()).thenReturn(1);
		assertEquals(true, mock1.fooBoolean());
		assertEquals(1, mock2.fooInt());
	}

}
