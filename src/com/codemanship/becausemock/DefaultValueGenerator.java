package com.codemanship.becausemock;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

class DefaultValueGenerator {

	private final Map<Class<?>, Object> defaults = new HashMap<Class<?>,Object>();
	
	DefaultValueGenerator(){
		defaults.put(int.class, 0);
		defaults.put(byte.class, (byte)0);
		defaults.put(short.class, (short)0);
		defaults.put(long.class, 0L);
		defaults.put(float.class, 0.0f);
		defaults.put(double.class, 0.0d);
		defaults.put(boolean.class, false);
		defaults.put(char.class, '\u0000');
	}

	Object getDefaultFor(Method method) {
		return defaults.get(method.getReturnType());
	}

}