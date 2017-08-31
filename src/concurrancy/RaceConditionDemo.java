package concurrancy;

public class RaceConditionDemo {

	public static void main(String[] args) {
		BankAccount task = new BankAccount();
		task.setBalance(100);
		
		Thread john = new Thread(task);
		Thread Anita = new Thread(task);
		john.setName("John");
		Anita.setName("Anita");
		
		john.start();
		Anita.start();
	}

}
class BankAccount implements Runnable{
	private int balance;
	 public void setBalance(int bal){
		 this.balance= bal;
	 }
	@Override
	public void run() {
		makeWithdrawl(75);
		if(balance < 0){
			System.out.println("Money Overdrawn by "+Thread.currentThread().getName());
		}
		
	}
	public synchronized void makeWithdrawl(int amount){
		if (balance >= amount){
			System.out.println(Thread.currentThread().getName() + " is about to withdraw...");
			balance -= amount;
			System.out.println(Thread.currentThread().getName() + " has withdrawn " + amount);
		}else
			System.out.println("Sorry, not enough cash for "+ Thread.currentThread().getName());
		
	}
}