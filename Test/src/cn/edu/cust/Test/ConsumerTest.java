package cn.edu.cust.Test;

import java.util.Properties;

import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.message.MessageAndMetadata;

public class ConsumerTest implements Runnable {
	private KafkaStream m_stream;
	private int m_threadNumber;

	public ConsumerTest(KafkaStream a_stream, int a_threadNumber) {
		m_stream = a_stream;
		m_threadNumber = a_threadNumber;
	}

	@Override
	public void run() {
		ConsumerIterator<byte[], byte[]> it = m_stream.iterator();
		while (it.hasNext()) {
			MessageAndMetadata<byte[], byte[]> metadata = it.next();
			System.out.println("Thread " + m_threadNumber + " " + metadata.message());
		}
		System.out.println("Shutting down the thread" + m_threadNumber);
	}

	private static ConsumerConfig createConsumerConfig(String a_zookeeper, String a_groupId) {
		Properties props = new Properties();
		props.put("zookeeper.connect", a_zookeeper);
		props.put("group.id", a_groupId);
		props.put("zookeeper.session.timeout.ms", "400");
		props.put("zookeeper.sync.time.ms", "200");
		props.put("auto.commit.interval.ms", "1000");
		return new ConsumerConfig(props);
	}
}
