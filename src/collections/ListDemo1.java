package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;

public class ListDemo1 {

	public static List<Integer> arrayListDemo() {

		List<Integer> list1 = new LinkedList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(3);
		list1.add(null);
		System.out.println("List1: " + list1);

		list1.remove(3);
		System.out.println("List1: " + list1);

		list1.remove(3);
		System.out.println("List1: " + list1);

		list1.add(0, 10);
		System.out.println("List1: " + list1);

		list1.add(0, 9);
		System.out.println("List1: " + list1);

		Collection<Integer> list2 = new ArrayList<>();
		list2.add(9);
		list2.add(3);
		System.out.println("List2: " + list2);

		list1.removeAll(list2);
		System.out.println("List1: " + list1);

		list2.add(1);
		System.out.println("List2: " + list2);
		list1.retainAll(list2);
		System.out.println("List1: " + list1);
		list1.add(9);
		list1.add(3);
		System.out.println("List1: " + list1);
		System.out.println("List1.set(1,2): " + list1.set(1, 2));
		list1.add(1);
		System.out.println("List1: " + list1);

		// Search
		System.out.println("list1.contains(1): " + list1.contains(1));
		System.out.println("list1.indexOf(1): " + list1.indexOf(1));
		System.out.println("list1.lastIndexOf(1): " + list1.lastIndexOf(1));
		System.out.println("list1: " + list1);

		// Range-view: subList (new list is backed by original)
		List<Integer> list3 = list1.subList(2, 3);
		System.out.println("list3: " + list3);
		list3.set(0, 6);
		System.out.println("list1: " + list1);
		list3.add(0, 7);
		System.out.println("list3: " + list3);
		System.out.println("list1: " + list1);
		list1.set(2, 8);
		System.out.println("list3: " + list3);
		list1.add(0, 8);
		// System.out.println("list3: " + list3);
		System.out.println("list1: " + list1);
		list1.set(2, 9);
		/*
		 * for (int element : list1) { System.out.println("element: " +
		 * element);
		 * 
		 * // // Generates ConcurrentModificationException // if (element == 9)
		 * { // list1.remove(Integer.valueOf(element)); // valueOf is used due
		 * to its caching // } }
		 */
		return list1;
	}

	private static void iteratorDemo(List<Integer> list1){
		System.out.println("\nInside iteratorDemo...");
		System.out.println("Elemets: "+list1);
		
		Iterator<Integer> iterator = list1.iterator();
		while(iterator.hasNext()){
			int element = iterator.next();
			System.out.println("Element: "+ element);
			if (element == 9){
				iterator.remove();
				iterator.forEachRemaining(Filter::add);
			}
		}
	}

	private static void listIteratorDemo() {
		System.out.println("Inside listIteratorDemo...");
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		
		System.out.println("\nDisplaying current elements...");
		
		for(ListIterator iterator = list.listIterator(); iterator.hasNext(); ){
			System.out.println("iterator.nexIndex: "+ iterator.nextIndex() + ",iterator.next: "+iterator.next());
			if (iterator.nextIndex() == 1){
				System.out.println("...Adding test at index 1");
				iterator.add("test");
				System.out.println("iterator.nexIndex: "+ iterator.nextIndex() + ",iterator.next: "+iterator.next());
				
				System.out.println("removing test that was added at index 1");
				iterator.previous();
				iterator.previous();
				iterator.remove();
				System.out.println("iterator.nexIndex: "+ iterator.nextIndex() + ",iterator.next: "+iterator.next());
				System.out.println("Setting element at index 1 as best");
				iterator.set("best");
				iterator.set("best1");
				System.out.println("iterator.nexIndex: "+ iterator.nextIndex() + ",iterator.next: "+iterator.next());
				
//				System.out.println("iterator.nexIndex: "+ iterator.nextIndex() + ",iterator.next: "+iterator.next());
				
			}
		}
	      System.out.println("\nDisplaying current elements ... ");
	      for (ListIterator iterator = list.listIterator(); iterator.hasNext();) {
	          System.out.println("iterator.nextIndex: " + iterator.nextIndex() + ", iterator.next: " + iterator.next());	  
	      }
		
	}
	
	public static void main(String[] args) {

		List<Integer> list1 = arrayListDemo();
		//iteratorDemo(list1);
		// arrayListDemo();
		//listIteratorDemo();

	}

	static class Filter implements Consumer<Object>{
		static void filter(Integer i){
			if (i==1)
				System.out.println(i);
		}
		public void accept(Object i){
			if((int)i ==1)
				System.out.println(i);
		}
		static void add(Integer i){
			System.out.println(i+7);
		}
		
	}
}

