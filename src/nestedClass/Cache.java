package nestedClass;

import java.util.Arrays;
import java.util.Comparator;

interface CacheIterator{
	boolean hasNext();
	Bookmark next();
}

public class Cache {
	private Bookmark[] items;
	private int next = 0;
	
	public Cache(int size){
		items = new Bookmark[size];
	}
	public void add(Bookmark item){
		if (next < items.length)
			items[next++]=item;
	}
	public CacheIterator iterator(){
		return new MyCacheIterator();
	}
	
	private class MyCacheIterator implements CacheIterator{
		private int i=0;
		@Override
		public boolean hasNext() {
			return i<items.length;
		}

		@Override
		public Bookmark next() {
			return items[i++];
		}
		
	}
	public static void main(String[] args) {
		Cache recommendedItems = new Cache(2);
		
		Bookmark item1 = new Bookmark();
		item1.setId(1000);
		item1.setTitle("Harry Potter");
		item1.setRating(1.0);
		
		Bookmark item2 = new Bookmark();
		item2.setId(2000);
		item2.setTitle("WonderWomen");
		item2.setRating(2.0);
		
		recommendedItems.add(item1);
		recommendedItems.add(item2);

		CacheIterator iterator = recommendedItems.iterator();
		
		while(iterator.hasNext()){
			System.out.println(iterator.next().getTitle());
		}
		Arrays.sort(recommendedItems.items, Bookmark.RATING_COMPARATOR);
		System.out.println("Sorted by rating...");
		iterator = recommendedItems.iterator();
		
		while(iterator.hasNext()){
			System.out.println(iterator.next().getTitle());
		}
		Arrays.sort(recommendedItems.items, new Bookmark.ComparatorList.StringLenghtComparator());
		System.out.println("Sorted by string length...");
		iterator = recommendedItems.iterator();
		
		while(iterator.hasNext()){
			System.out.println(iterator.next().getTitle());
		}
	}
}
