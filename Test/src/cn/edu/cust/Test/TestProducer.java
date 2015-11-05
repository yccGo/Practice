package cn.edu.cust.Test;

import java.util.Date;
import java.util.Properties;
import java.util.Random;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

public class TestProducer {
	public static void main(String[] args) {
		long events = Long.parseLong("5");
		Random rnd = new Random();

		Properties props = new Properties();
		props.setProperty("metadata.broker.list", "localhost:9092,localhost:9093,localhost:9094");
		props.setProperty("serializer.class", "kafka.serializer.StringEncoder");
		//props.put("partitioner.class", "cn.edu.cust.Test.SimplePartitioner");
		props.put("request.required.acks", "1");
		/*
		 * props.put("metadata.broker.list", "broker1:9092,broker2:9093 ");
		 * props.put("serializer.class", "kafka.serializer.StringEncoder");
		 * props.put("partitioner.class", "example.producer.SimplePartitioner");
		 * props.put("request.required.acks", "1");
		 */

		ProducerConfig config = new ProducerConfig(props);

		Producer<String, String> producer = new Producer<String, String>(config);
		/*int i = 0;
		long startTime = System.currentTimeMillis();
		while(i < 100){
			i++;
			System.out.println(i);
			long runtime = System.currentTimeMillis();
			KeyedMessage<String, String> data = new KeyedMessage<String, String>("page_visits", i + " hello ycc");
			producer.send(data);
		}
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total Time : " + totalTime + "ms");*/
		
		for (long nEvents = 0; nEvents < 100; nEvents++) {
			long runtime = new Date().getTime();
			String ip = nEvents + "";
			String msg = runtime + ",www.cust.edu.cn," + ip;
			KeyedMessage<String, String> data = new KeyedMessage<String, String>("page_visits", ip, msg);
			System.err.println(data);
			producer.send(data);
		}
		
		producer.close();
	}
}