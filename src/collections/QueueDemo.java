package collections;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueDemo {

	
	private static void dequeTest() {
		System.out.println("Inside dequeTest...");
		
		//Queue - FIFO
		Deque<String> deque = new ArrayDeque<>();
		deque.add("walden");
		deque.add("harry potter");
		deque.add("Indiana Jones");
		
		System.out.println("\nPrinting deque...");
		System.out.println(deque.remove());
		System.out.println(deque.remove());
		System.out.println(deque.remove());
		
		//Stack - LIFO
		deque.push("walden");
		deque.push("harry potter");
		deque.push("Indiana Jhones");
		 
		System.out.println("\nPrinting stack...");
		System.out.println(deque.pop());
		System.out.println(deque.pop());
		System.out.println(deque.pop());
	}
	
	public static void main(String[] args) {
		dequeTest();

	}
}
