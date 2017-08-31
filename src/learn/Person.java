package learn;
public class Person {

	private String name;
	private String friends;
	
	public Person (String aName){	//Constructor
		name = aName;
		friends = "";
	}
	public Person (String aName, String pictureName, int x, int y)
	{
		name = aName;
		friends = "";
	}
	public void addFriend(Person friend){
		friends = friends + friend.name + " ";
	}
	public void unFriend(Person friend){
		friends = friends.replace(friend.name + " ", "");
	}
	public String getFriends(){
		return friends;
	}
/*	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person maria = new Person("Maria");
		Person jamesha = new Person("Jamesha");
		Person tj = new Person("TJ");
		
		maria.addFriend(jamesha);
		maria.addFriend(tj);
		maria.unFriend(jamesha);
		
		System.out.println(maria.getFriends());
		System.out.println("Expected: TJ");

	}*/
	    public static void main(String[] args)
    {
        Person sara = new Person("Sara", "sara.jpg", 10, 200);
        Person chenghan = new Person("Cheng-Han", "cheng-han.png", 300, 0);
        Person cay = new Person("Cay", "cay.gif", 250, 180);
        
        sara.addFriend(cay);
        sara.addFriend(chenghan);
    }

}
