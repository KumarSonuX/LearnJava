package collections;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SetDemo {

	private static void hashSetDemo() {
		Set<String> set1 =new HashSet<>();
		set1.add("a");
		set1.add("b");
		set1.add("a");
		System.out.println("set1: "+set1);
		
		Book book1=new Book("Walden","Henry Throne",1854);
		Book book2=new Book("Walden","Henry Throne",1854);
		Set<Book> set2 = new HashSet<>();
		set2.add(book1);
		set2.add(book2);
		System.out.println("Set2: "+ set2);
	}
	
	private static void linkedHasSetDemo() {
		Set<String> hashSet = new HashSet<>();
		hashSet.add("John");
		hashSet.add("Raj");
		hashSet.add("Anita");
		System.out.println("HashSet:"+hashSet);
		
		Set<String> linkedHashSet = new LinkedHashSet<>();
		linkedHashSet.add("Raj");
		linkedHashSet.add("john");
		linkedHashSet.add("Anita");
		System.out.println("LinkedHashSet:"+linkedHashSet);
	}

	private static void treeSetDemo() {
		Book book1 = new Book("Harry Potter", "J.K.Rowling",1997);
		Book book2 = new Book("Harry Potter","J.K.Rowling",1997);
		Book book3 = new Book("Walden", "Henery David", 1854);
		Book book4 = new Book("Effective Java", "Joshua Bloch", 2008);
		
		Set<Book> book = new TreeSet<>();
		book.add(book1);
		book.add(book2);
		book.add(book3);
		book.add(book4);
		
		for (Book book5 : book) {
			System.out.println(book5);
		}
	}
	private static void treeSetDemo2() {
		NavigableSet<Integer> set = new TreeSet<>();
		set.add(5);
		set.add(23);
		set.add(74);
		set.add(89);
		
		System.out.println("lower: "+ set.lower(74));
		System.out.println("higher: "+ set.higher(74));
		System.out.println("ceiling: "+ set.ceiling(75));
		System.out.println("floor: "+ set.floor(75));
		System.out.println("set: "+set);
		
		NavigableSet<Integer> desendingSet = set.descendingSet();
		System.out.println("Desending Set: "+ desendingSet);
		
		NavigableSet<Integer> headSet = set.headSet(74, true);
		System.out.println("headSet: " + headSet);
		
		headSet.add(6);
		System.out.println("headSet: " + headSet);
		System.out.println("set: " + set);
		headSet.add(4);
		//headSet.add(75); // throws IllegalArgumentException
		System.out.println("set: " + set);
		
		SortedSet<Integer> subSet = set.subSet(5, 74);
		//subSet.add(2); // throws IllegalArgumentException
		
		// Adding element in backed set (original set) and 
		// see it getting reflected in subSet
		set.add(25);
		System.out.println("subSet: " + subSet);
	}	
	public static void main(String[] args) {
		//hashSetDemo();
		//linkedHasSetDemo();
		//treeSetDemo();
		treeSetDemo2();
	}
}
class Book implements Comparable{
	private String title;
	private String author;
	private int year;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Book(String title, String author, int year) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
	}
/*	public int hashCode(){
		return title.hashCode();
	}
	public boolean equals(Object o){
		return (year==(((Book)o).getYear())) && (author.equals((((Book)o).getAuthor())));
	}*/
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", year=" + year
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + year;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	@Override
	public int compareTo(Object book) {
		return getTitle().compareTo(((Book)book).getTitle());
	}
}
class TitleComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return ((Book)o1).getTitle().compareTo(((Book)o2).getTitle());
	}
	
}
