# BecauseMock
A simple mocking framework done for SC2016

A limited mock objects framework, in the style of Mockito, to test how long it might take for SC2016

See the mini-project page at http://codemanship.co.uk/parlezuml/blog/?postid=1355

Supplied with no warranty - use at your peril!

To create and use a mock object (based on an interface - though it may work with concrete classes, haven't checked yet):

```java
import static com.codemanship.becausemock.BecauseMock.*;

class MyTests {

  @Test
  public void myInteractionTest() {
    MyInterface myMock = mock(MyInterface.class);
    new MyClassUnderTest(mock).methodThatCallsFoo();
    verify(myMock).foo(1,2);
  }
}
```

If foo() isn't invoked with args 1,2 then a MockException will be thrown and the test will fail.

To create a stub that returns a specified test data value (can be any primative or object):

```java
import static com.codemanship.becausemock.BecauseMock.*;

class MyTests {

  @Test
  public void myInteractionTest() {
    MyInterface myMock = mock(MyInterface.class);
    when(myMock.getFoo()).thenReturn(2);
    MyClassUnderTest myObject = new MyClassUnderTest(mock);
    assertEquals(4, myObject.fooSquared(), 0);
  }
  
}
```
