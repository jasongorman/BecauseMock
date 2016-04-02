package com.codemanship.becausemock;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Method;

import org.junit.Test;

public class MockExceptionTests {

	@Test
	public void mockExceptionMessageDetailsMethodNotInvokedCorrectly() throws NoSuchMethodException, SecurityException{
		Method method = MyInterface.class.getMethod("newFoo", int.class, int.class);
		Exception exception = new MockException(method , new Object[]{1,2});
		assertEquals("\nBecauseMock wanted but not invoked: MyInterface.newFoo(1,2)", exception.getMessage());
	}

}