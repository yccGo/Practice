package cn.edu.cust.TestOther;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UserComparator implements Comparator<User> {

	@Override
	public int compare(User user1, User user2) {
		return user1.name.compareTo(user2.name);
	}
	public static void main(String[] args) {
		
	}
}
