package com.codemanship.becausemock;
import static net.bytebuddy.matcher.ElementMatchers.isDeclaredBy;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.MethodDelegation;

public class BecauseMock {
	
	static Mock activeMock;

	public static <T> T verify(T mock){
		((Mock)mock).verify();
		return mock;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T mock(Class<T> typeToMock){
			try {
				MockMemory memory = createMemory();
				Mock mock = (Mock)new ByteBuddy()
				  .subclass(Mock.class)
				  .implement(typeToMock)
				  .name("becausemock.Mock" + typeToMock.getSimpleName())
				  .method(isDeclaredBy(typeToMock)).intercept(MethodDelegation.to(memory))
				  .make()
				  .load(BecauseMock.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER)
				  .getLoaded()
				  .newInstance();
				mock.setMemory(memory);
				return (T)mock;
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
			return null;
	}

	public static Mock when(Object methodCall) {
		activeMock.when();
		return activeMock;		
	}

	private static MockMemory createMemory() {
		ArrayMatcher arrayMatcher = new ArrayMatcher();
		MockMemory memory = new MockMemory(new Stubs(arrayMatcher, new DefaultValueGenerator()), new Invocations(arrayMatcher));
		return memory;
	}
}
