package learn;

public interface InterFaceC extends InterFaceA{  //An interface extending another interface
	void foobar();
	default void go() {
		      System.out.println("C: go");
			  staticMethod();
		   }
		   static void staticMethod() {
		      System.out.println("C: staticMethod");
		   }
}
