package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapDemo {

	private static void hashMapDemo() {
		System.out.println("Inside hashMapDemo..." );
		Map<String, Integer> map1 = new HashMap<>();
		map1.put("John", 23);
		map1.put("Raj", 29);
		map1.put("Anita", 30);
		
		System.out.println("Map1: "+ map1);
		System.out.println("Contain's John? "+ map1.containsKey("John"));
		System.out.println("John's age: "+ map1.get("John"));
		
		System.out.println("Iterate using keyset...");
		Set<String> names= map1.keySet();
		for (String name : names){
			System.out.println("Name: "+name +" Age: "+map1.get(name));
		}
		
		System.out.println("Iterate using entrySet...");
		Set<Map.Entry<String,Integer>> mapping=map1.entrySet();
		for (Map.Entry<String, Integer> mapp: mapping){
			System.out.println("Name: "+mapp.getKey()+" Age: "+mapp.getValue());
		}
		names.remove("Anita");
		System.out.println("Map1: "+map1);
		
		Map<String, Map<String,Object>> userProfile = new HashMap<>();
		
		Map<String, Object> profile = new HashMap<>();
		profile.put("age", 20);
		profile.put("Dept", "CS");
		profile.put("City", "New York");
		
		userProfile.put("Raj", profile);
		System.out.println("User Profile: "+userProfile);
		
		profile = new HashMap<>();
		userProfile.put("John",profile);
		profile.put("age", 25);
		profile.put("Dept", "CS");
		profile.put("City", "New York");
		System.out.println("User Profile: "+userProfile);
		
		Map<String, Object> profile1 = userProfile.get("John");
		int age = (Integer) profile1.get("age");
		System.out.println("John's age: "+age);
	}
	private static void immutableKeysDemo() {
		System.out.println("\n\nInside immutableKeysDemo ...");
		List<Integer> list = new ArrayList<>();
		list.add(1);
		
		Map<List<Integer>, Integer> map = new HashMap<>();
		map.put(list, 1);
		
		list.add(2);
		System.out.println(map.get(list));
		
		Student s = new Student(1, null);
		Map<Student, Integer> map2 = new HashMap<>();
		map2.put(s, 1);
		
		s.setName("John");
		System.out.println(map2.get(s));
	}	
	public static void main(String[] args) {
		//hashMapDemo();
		immutableKeysDemo();

	}
}
class Student{
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}