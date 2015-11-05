package cn.edu.cust.Test;

import kafka.producer.Partitioner;

public class TestPartitioner implements Partitioner {

	@Override
	public int partition(Object arg0, int arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

}
