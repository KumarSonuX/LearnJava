package learn;

public class Staff extends User {

	public int id =2;
//	public String user="Staff";
	
	public Staff() {
		// TODO Auto-generated constructor stub
		user="Staff";
		System.out.println("Staff: Constructor 1");
	}
	public Staff(int id){
		this();
		this.id = id;
		System.out.println("Staff: COnstructor 2");
		
	}
	public void printUserType(){
		System.out.println("Staff");
	}
/*	public void printInfo(){
		System.out.println("i: "+id);
		System.out.println("User: "+user);
	}*/
	public Review postAReview(String reviewText){
		System.out.println("Staff: post a review");
		Review review = super.postAReview(reviewText);
		review.setApproved(true);
		return review;
	}
}
