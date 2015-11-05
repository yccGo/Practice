package cn.edu.cust.TestOther;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TestSet {
	public static void showSet(HashSet set) {
		Iterator setIterator = set.iterator();
		while (setIterator.hasNext()) {
			int num = (int) setIterator.next();
			System.out.println(num);
		}
	}

	public void show() {
		int a = 5;
		int b = 7;
		a = a ^ b;
		b = b ^ a;
		a = a ^ b;
		System.out.println(a);
		System.out.println(b);
	}

	public static void showMapList(List<Map.Entry<String, Integer>> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
	}

	public static void showList(List<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + "\t");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// add remove size isEmpty clear contains clone iterator
		/*
		 * HashSet set = new HashSet(); set.add(1); set.add(2); set.add(3);
		 * System.out.println(set.size()); System.out.println(set.contains(4));
		 * System.out.println(set.contains(3)); showSet(set); set.remove(1);
		 * HashSet set2 = (HashSet) set.clone(); showSet(set2); showSet(set);
		 * set.clear(); showSet(set); System.out.println(set.isEmpty());
		 */

		/*
		 * TestSet t1 = new TestSet(); TestSet t2 = new TestSet();
		 * System.out.println(t1); System.out.println(t2); t1.show(); t2.show();
		 */
		/*
		 * int array[] = {3,4,5,3,5,4,6}; int j = 0; for(int i = 0;i <
		 * array.length;i++){ System.out.print(j + " ^ " + array[i] + " = "); j
		 * ^= array[i]; System.out.print(j); System.out.println(); }
		 * //System.out.println(j);
		 * System.out.println("----------------------------"); new
		 * TestSet().show();
		 */
		/*
		 * List<Integer> list = new ArrayList<Integer>(); list.add(2);
		 * list.add(4); list.add(1); list.add(5); list.add(3); showList(list);
		 * Collections.sort(list); showList(list); Collections.reverse(list);
		 * showList(list); Collections.shuffle(list); showList(list);
		 * Collections.shuffle(list); showList(list); int max =
		 * (int)Collections.max(list); int min = (int)Collections.min(list);
		 * System.out.println("max:" + max + "  " + "min:" + min);
		 * Collections.rotate(list, 3); showList(list);
		 */
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("hello", 3);
		map.put("world", 5);
		map.put("happy", 1);
		map.put("fuck", 4);
		map.put("shit", 2);
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o1.getKey().compareTo(o2.getKey());
			}
		});
		showMapList(list);
		System.out.println();
		Collections.sort(list,new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		showMapList(list);
		MyContainer container = new MyContainer();
		container.setListener("I love you", new MyListener() {
			
			@Override
			public void initName(String name) {
				System.out.print(name);
			}
		});
	}
}
