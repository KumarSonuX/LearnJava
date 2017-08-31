package learn;

public class TestInterFace {

	   public static int getVal() {
	       return 42;
	   }
	 	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterFaceC c = new X();
	/*	c.foo();
		c.bar();
		c.foobar();*/
		
/*		InterFaceC clone=((X)c).clone();
		if(clone != c){
			System.out.println("Clone Created");
		}*/
		
		//c.go();
		//InterFaceC.staticMethod();
		((X)c).inheritanceTest();
	}
	 	

}
 