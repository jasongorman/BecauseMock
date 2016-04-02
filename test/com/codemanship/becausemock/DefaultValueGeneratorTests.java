package com.codemanship.becausemock;
import static com.codemanship.becausemock.BecauseMock.mock;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class DefaultValueGeneratorTests {

	@Test
	public void defaultReturnValuesAreJavaDefaultsForReturnTypes() {
		MyInterface mock = mock(MyInterface.class);
		assertEquals(0, mock.fooInt());
		assertEquals(0, mock.fooShort());
		assertEquals(0, mock.fooByte());
		assertEquals(0L, mock.fooLong());
		assertEquals(0.0f, mock.fooFloat(), 0);
		assertEquals(0.0d, mock.fooDouble(), 0);
		assertFalse(mock.fooBoolean());
		assertEquals( '\u0000', mock.fooChar());
		assertNull(mock.fooString());
		assertNull(mock.fooObject());
	}

}