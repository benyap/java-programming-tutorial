package adt.demo;

public class Demo {
	public static void main(String[] args) {
		//demoLinkedIntegerList();
		demoGenericList();
	}
	
	
	public static void demoLinkedIntegerList() {
		LinkedIntegerList list = new LinkedIntegerList();
		
		list.add(10);
		list.add(9);
		list.add(4);
		list.add(1);
		list.add(1);
		list.add(9);
		list.add(1);
		list.add(8);
		list.add(1);
		list.add(9);
		list.add(1);
		list.add(1);
		list.add(9);
		list.add(1);
		list.add(1);
		list.add(9);
		list.add(1);
		System.out.println(list);
		System.out.println("Item @ index 4: " + list.get(4));
		list.remove(1);
		//list.insert(0, 0);
		//list.remove(9);
		System.out.println(list);
		System.out.println("Size: " + list.size());
		System.out.println("Item @ index 4: " + list.get(4));
		//System.out.println(list.contains(10));
	}
	
	
	public static void demoGenericList() {
		ListInterface<String> list = new GenericArrayList<String>();
		
		list.add("Bob");
		list.add("Jane");
		list.add("Brian");
		list.add("Mary");
		list.add("James");
		System.out.println(list);
		
		list.remove("Bob");
		System.out.println(list);
		
		list.insert("Matthew", 3);
		System.out.println(list);
		
	}
}
