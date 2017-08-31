package learn;

public class Review {

	private String reviewText;
	private boolean approved;
	
	public Review(String reviewText) {
		// TODO Auto-generated constructor stub
		this.reviewText = reviewText;
	}

	public boolean isApproved(){
		return approved;
	}
	public void setApproved(boolean approved){
		this.approved = approved;
	}
}
