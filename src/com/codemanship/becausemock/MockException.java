package com.codemanship.becausemock;
import java.lang.reflect.Method;


public class MockException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MockException(Method method, Object[] args) {
		super("\nBecauseMock wanted but not invoked: " + method.getDeclaringClass().getSimpleName() +
				"." + method.getName() + "(" + formatArgs(args) + ")");
	}

	private static String formatArgs(Object[] args) {
		String formatted = "";
		if(args.length > 0){
			formatted = args[0].toString();
		}
		for (int i = 1; i < args.length; i++) {
			formatted += "," + args[i].toString();
		}

		return formatted;
	}

}
