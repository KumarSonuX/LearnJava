//Test again
package learn;
public class mathTest {

	final static int MAX_RED = 255;
		public mathTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int value= (int)Math.pow(10,3);		
		System.out.println("Value:"+value);
		System.out.println(Math.sqrt(4));
		System.out.println(Math.abs(3-5));
		System.out.println(Math.min(300,MAX_RED));
		System.out.println(Math.max(0,-1));

		String s = "Welcome";
		String tail = s.substring(s.indexOf("c"), s.length());
		
		System.out.println(tail);
		
		String s1 = "2";
		String t = s1 + s1;
		System.out.println(t);
		
	}

}
