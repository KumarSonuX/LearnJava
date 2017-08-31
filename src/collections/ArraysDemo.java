package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

public class ArraysDemo {

	private static void sequential() {
		String[] strArray = new String[]{"Raj", "Anita"};
		List<String> strings = Arrays.asList(strArray);
		System.out.println("Strings: "+strings);
		//System.out.println("Array Strings: "+strArray.toString());
		//strings.remove(0);
		strings.set(0,"John");
		System.out.println("Updated string: "+Arrays.toString(strArray));
		
		//create modifiyable ArrayList from an Array
		strings = new ArrayList(Arrays.asList(strArray));
		strings = Arrays.asList("Raj","Anita");
		List<String> fixedList = Arrays.asList(new String[3]);
		//System.out.println("Fixed listL "+fixedList);
		List<int[]> fixedList2 = Arrays.asList(new int[2]);
		//System.out.println("Fixed list-2 "+fixedList2.size());
		Arrays.sort(strArray);
		System.out.println("Sorted: "+ Arrays.toString(strArray) );
		
		int[] newArray = {23,4,50};
		Arrays.sort(newArray);
		System.out.println("Sorted: "+Arrays.toString(newArray));
		System.out.println("Binary search: "+ Arrays.binarySearch(newArray, 23));
		
		int[] newArray1 = Arrays.copyOf(newArray, 6);
		System.out.println("New Array: "+ Arrays.toString(newArray1));
		Arrays.fill(newArray1,12);
		System.out.println("Fill: "+Arrays.toString(newArray1));
		System.out.println("Equal: "+ Arrays.equals(newArray, newArray1));
		
		Object[] objArray = new int[][][]{{{1,2,3}}};
		int[][] ia= (int[][])objArray[0];
		System.out.println(ia[0][2]);
	}
	private static void parallel() {
		int[] iArray={2,4,1};
		Arrays.parallelSort(iArray);
		System.out.println("Parallel Sort: "+ Arrays.toString(iArray));

		IntBinaryOperatorImpl IntBinaryOperatorImpl = new IntBinaryOperatorImpl();
		Arrays.parallelPrefix(iArray, IntBinaryOperatorImpl);
		System.out.println("Parallel Prefix: " + Arrays.toString(iArray));
		
		IntUnaryOperatorImpl intUnaryOperatorImpl = new IntUnaryOperatorImpl();
		intUnaryOperatorImpl.setArray(iArray);
		Arrays.parallelSetAll(iArray, intUnaryOperatorImpl);
		System.out.println("Parallel Set All: " + Arrays.toString(iArray));		
	}
	public static void main(String[] args) {
		//sequential();
		parallel();

	}
}

class IntBinaryOperatorImpl implements IntBinaryOperator {
	@Override
	public int applyAsInt(int left, int right) {
		return left + right;
	}	
}

class IntUnaryOperatorImpl implements IntUnaryOperator {
	int[] iArray;
	
	public void setArray(int[] iArray) {
		this.iArray = iArray;
	}

	@Override
	public int applyAsInt(int i) {
		if (iArray != null) {
			return iArray[i]+5;
		} else {
			return i;
		}		
	}
	
}