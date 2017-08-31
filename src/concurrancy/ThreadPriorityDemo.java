package concurrancy;

public class ThreadPriorityDemo {

	public static void main(String[] args) {
		 System.out.println(Thread.currentThread());
		 
		 Thread t1 = new Thread(new EmailCampaign());
		 Thread t2 = new Thread(new DataAggregator());
		 
		 t1.setName("Email Campaign");
		 t2.setName("Data Aggregator");
		 
		 t1.setPriority(Thread.MAX_PRIORITY);
		 t2.setPriority(Thread.MIN_PRIORITY);
		 
		 t1.start();
		 t2.start();
		 try {
			t2.join(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 System.out.println("Inside main...");
	}
}
class EmailCampaign implements Runnable {

	@Override
	public void run() {
		for(int i=1; i<=10; i++){
			System.out.println(Thread.currentThread().getName());
			if (i==5)
				Thread.currentThread().yield();
		}
		
	}	
}
class DataAggregator implements Runnable{

	@Override
	public void run() {
		for(int i=1; i<=10; i++)
			System.out.println(Thread.currentThread().getName());
		
	}
	
}