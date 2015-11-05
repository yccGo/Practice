package cn.edu.cust.TestOther;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MyComparatorForMap {
	public static Map<String, Integer> sortMap(Map<String, Integer> map) {
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
		int length = list.size();
		for (int i = 0; i < length - 1; i++) {
			Map.Entry<String, Integer> outerEntry = list.get(i);
			int maxVal = outerEntry.getValue();
			int maxIdx = i;
			for (int j = i + 1; j < length; j++) {
				Map.Entry<String, Integer> tmpComparedEntry = list.get(j);
				int tmpVal = tmpComparedEntry.getValue();
				if (maxVal < tmpVal) {
					maxIdx = j;
					maxVal = tmpVal;
				}
			}
			System.out.println("maxIdx:" + maxIdx + " maxVal:" + maxVal + " i:" + i);
			if (maxIdx != i) {
				Map.Entry<String, Integer> maxEntry = list.get(maxIdx);
				list.set(maxIdx, outerEntry);
				System.out.println("第一次换：" + list);
				list.set(i, maxEntry);
				System.out.println("第二次换：" + list);
			}
			System.out.println(list);
			System.out.println("----------------------------------------------------------");
		}
		Map<String, Integer> newMap = new LinkedHashMap<String, Integer>();
		Iterator<Entry<String, Integer>> it = list.iterator();
		while (it.hasNext()) {
			Map.Entry<String, Integer> entry = it.next();
			newMap.put(entry.getKey(), entry.getValue());
		}
		return newMap;
	}

	public static void main(String[] arg) {
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
		System.out.println();
		Map<String, Integer> newMap = MyComparatorForMap.sortMap(map);
		System.out.println(newMap);
	}
}
