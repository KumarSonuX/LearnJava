package learn;
//import LearnJava.class.code.User;
public class UserTest {

	public UserTest() {
		// TODO Auto-generated constructor stub
	}
	public void printUserType(User u) {
	    ((Staff) u).printUserType();
	}
	
	public void approveAReview(Staff s) {
		if (s instanceof Editor) {
			((Editor) s).approveAReview(); 
		}
		else {
        	System.out.println("Invalid object passed!!");
        }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		User user = new User();
		User staff= new Staff();
		User editor = new Editor();
		Editor edi = new Editor();
		
		((Staff) user).printUserType();
		((Staff) staff).printUserType();
		((Staff) editor).printUserType();
		editor.saveWebLink();
//		editor.postAReview();
		edi.approveAReview();
		UserTest ut = new UserTest();
		ut.approveAReview(new Staff());
		ut.approveAReview(new Editor());
		user.postAReview("");
		staff.postAReview("");
	//	((Staff)staff).printInfo();
//		staff.printInfo();
		System.out.println(staff.toString());
		User staff1 = new Staff(3);
	}

}