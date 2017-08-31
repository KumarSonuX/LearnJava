package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GenericsDemo {

	public static void main(String[] args) {
		Container<String> stringStore = new Store<>();
		stringStore.set("java");
		System.out.println("stringStore: "+ stringStore.get());

		Container<Integer> intStore = new Store<>();
		intStore.set(10);
		System.out.println(intStore.get());
		
		Container<List<Integer>> listStore = new Store<>();
		listStore.set(Arrays.asList(1,2,3));
		System.out.println(listStore.get());
		
		//Container<int> intStore = new Store<>();
		List<Number> list = new ArrayList<>();
		list.add(new Integer(1));
		list.add(new Double(22.0));
		//list.add(new String("22.0"));
		
		List[] array = new List[2];
		array[0] = new ArrayList();
		array[1] = new LinkedList();
		
		//raw type test
		rawTypeTest();
		
		List<String> strList1 = Arrays.asList("a","b","c");
		List<String> strList2 = Arrays.asList("b","c","d");
		getCommonElementsCount(strList1,strList2);
		
		//wildcard
		getCommonElementsCountWithWildcard(strList1,strList2);
		
		Container<?> someStore = stringStore;
		Object object = someStore.get();
		System.out.println("Stores element: "+object);
		
		List<Integer> intList1 = Arrays.asList(1,2,3);
		List<Integer> intList2 = Arrays.asList(4,5,6);
		invalidAggreegate(intList1, intList2, new ArrayList());
	}

	private static void invalidAggreegate(List<?> l1,
			List<?> l2, ArrayList arrayList) {
		//l1.addAll(null);
		//l1.addAll(l2);
		
	}

	private static int getCommonElementsCountWithWildcard(
			List<?> strList1, List<?> strList2) {
		int count=0;
		for (Object element:strList1){
			if(strList2.contains(element)){
				count++;
			}
		}
		System.out.println("Common elements count: " +count);
		return count;
		
	}

	private static int getCommonElementsCount(List strList1,
			List strList2) {
		int count=0;
		for (Object element:strList1){
			if(strList2.contains(element)){
				count++;
			}
		}
		System.out.println("Common elements count: " +count);
		return count;
	}

	private static void rawTypeTest() {
		System.out.println("In raw type test...");
		int ISBN = 1505297729;
		List<Double> prices=new ArrayList<>();
		
		HalfIntegrator.getPrice(ISBN, prices);
		Double price = prices.get(0);
	}

}
class HalfIntegrator{
	public static void getPrice(int ISBN, List<Double> price){
		price.add(45.00);
	}
}
interface Container<T>{
	void set(T a);
	T get();
}
class Store<T> implements Container<T>{
	private T a;
	@Override
	public void set(T a) {
		this.a = a;
	}
	@Override
	public T get() {
		return a;
	}
	
}
