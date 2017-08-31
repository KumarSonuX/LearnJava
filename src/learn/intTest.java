package learn;
public class intTest {

	public intTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double unitPrice = 4.35;
		int totalPrice =(int)Math.round(100 * unitPrice);
		int x = 3;
		int y = 4;
		int xy = 11;
		int cos = 5;
		
		System.out.println("Total Price =" + totalPrice);
		
		double a = ((x+1 * 4)) * (2+y);
		double b = x+ y/2 + xy;
		double c = (4+cos) /2;
		
		System.out.println("a="+a);
		System.out.println("b="+b);
		System.out.println("c="+c);
	}

}
