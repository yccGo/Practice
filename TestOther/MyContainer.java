package cn.edu.cust.TestOther;

public class MyContainer {
	public String name;

	public void setListener(String name, MyListener listener) {
		listener.initName(name);
	}
}
