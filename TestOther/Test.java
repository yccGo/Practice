package cn.edu.cust.TestOther;

import java.util.Timer;
import java.util.TimerTask;

public class Test {
	public static void main(String[] args) {
		Timer timer = new Timer();
		long delay = 3000;
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("aaa");
			}
		}, delay);
		long period = 5000;
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("bbb");
			}
		}, delay, period);
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("ddd");
			}
		}, delay);
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("eee");
			}
		}, delay);
	}
}
