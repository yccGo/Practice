package cn.edu.cust.TestOther;

public class TestRunnable implements Runnable{
	public String name;
	public static int i = 1;
	public int count =0;
	public TestRunnable(String name){
		this.name = name;
	}
	@Override
	public void run() {
		for(;i <= 10000;i++){
			System.out.println(name + " i = " + i);
			count++;
			if(count == 10000){
				System.out.println("-----------------------------------");
				System.out.println(name + "抢票完毕" + " 共抢到 " + count + " 张票");
				System.out.println("-----------------------------------");
			}
			if(i > 10000){
				System.out.println("-----------------------------------");
				System.out.println(name + "抢票完毕" + " 共抢到 " + count + " 张票");
				System.out.println("-----------------------------------");
			}
		}
	}
	public static void main(String[] args){
		TestRunnable tr1 = new TestRunnable("线程A");
		TestRunnable tr2 = new TestRunnable("线程B");
		new Thread(tr1).start();
		new Thread(tr2).start();
	}
}
