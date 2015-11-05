package cn.edu.cust.TestOther;

public class TestThread extends Thread {

	public String name;

	public TestThread(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(name + " i:" + i);
		}
	}

	public static void main(String[] args) {
		TestThread thread1 = new TestThread("线程A");
		TestThread thread2 = new TestThread("线程B");
		/*thread1.run();
		thread2.run();*/
		thread1.start();
		thread2.start();
	}
}
