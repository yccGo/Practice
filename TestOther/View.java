package cn.edu.cust.TestOther;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class View {
	public static void showUsers(List<User> users) {
		Iterator<User> it = users.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().getName());
		}
	}

	public static void main(String[] args) {
		/*
		 * User user1 = new User("Tom"); User user2 = new User("Allen"); User
		 * user3 = new User("Yao"); User user4 = new User("Yi"); User user5 =
		 * new User("Jordan"); User user6 = new User("Curry"); User user7 = new
		 * User("James"); User user8 = new User("Eric"); User user9 = new
		 * User("Wang"); List<User> users = new ArrayList<User>();
		 * users.add(user1); users.add(user2); users.add(user3);
		 * users.add(user4); users.add(user5); users.add(user6);
		 * users.add(user7); users.add(user8); users.add(user9);
		 * Collections.sort(users,new UserComparator()); showUsers(users);
		 */
		/*
		 * List<Integer> list = new ArrayList<Integer>(); list.add(1);
		 * list.add(2); list.add(3); list.set(1, list.get(2)); for(int i = 0 ;i
		 * < list.size();i++){ System.out.println(list.get(i)); }
		 */
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("hello", 92);
		map.put("world", 100);
		map.put("love", 10);
		map.put("happy", 44);
		map.put("hate", 90);
		map.put("shit", 88);
		map.put("fuck", 50);
		map.put("cook", 44);
		map.put("computer", 33);
		System.out.println(map);
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
}
