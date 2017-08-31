package learn;

/* This class extends an abstrac class and implements three interfaces*/

public class X extends AbstractF implements InterFaceA, InterFaceB, InterFaceC,
		Cloneable {
	public void foobar() {
		System.out.println("X: foobar");
		System.out.println("VAL" + InterFaceB.VAL);
	}

	public void foo() {
		System.out.println("X:foo");
	}

	public InterFaceC clone() {
		try {
			return (InterFaceC) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void inheritanceTest() {
		go();
		//staticMethod();
		
	}
}
