package com.codemanship.becausemock;
import static org.junit.Assert.*;

import org.junit.Test;

import com.codemanship.becausemock.ArrayMatcher;


public class ArrayMatcherTests {

	@Test
	public void differingArraysDontMatch() {
		assertFalse(match(new Object[]{1}, new Object[]{0}));
	}
	
	@Test
	public void identicalArraysMatch() {
		assertTrue(match(new Object[]{1}, new Object[]{1}));
	}

	private boolean match(Object[] array1, Object[] array2) {
		return new ArrayMatcher().match(array1, array2);
	}
}
