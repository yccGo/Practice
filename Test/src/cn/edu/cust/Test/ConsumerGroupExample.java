package cn.edu.cust.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.message.MessageAndMetadata;

public class ConsumerGroupExample {
	private final ConsumerConnector consumer;
	private final String topic;
	private ExecutorService executor;

	public ConsumerGroupExample(String a_zookeeper, String a_groupId, String a_topic) {
		consumer = kafka.consumer.Consumer.createJavaConsumerConnector(createConsumerConfig(a_zookeeper, a_groupId));
		this.topic = a_topic;
	}

	public void shutdown() {
		if (consumer != null)
			consumer.shutdown();
		if (executor != null)
			executor.shutdown();
		try {
			if (!executor.awaitTermination(5000, TimeUnit.MILLISECONDS)) {
				System.out.println("Timed out waiting for consumer threads to shut down, exiting uncleanly");
			}
		} catch (InterruptedException e) {
			System.out.println("Interrupted during shutdown, exiting uncleanly");
		}
	}

	public void run(int a_numThreads) {
		System.out.println("--------run----begin-------");
		Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
		topicCountMap.put(topic, 1);
		Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer.createMessageStreams(topicCountMap);
		KafkaStream<byte[], byte[]> streams = consumerMap.get(topic).get(0);
		System.out.println("---------topic:" + topic + "------------------");		
		ConsumerIterator<byte[], byte[]> it = streams.iterator();
		//System.out.println("-------it.hasNext() ----val:" + it.hasNext() + "-----------");
		while (it.hasNext()) {
			MessageAndMetadata<byte[],byte[]> metadata = it.next();
			System.out.println("(msg:" + new String(metadata.message()) + ") (partition:" + metadata.partition() + ") (offset:" + metadata.offset() + ") (topic:" + metadata.topic() + ")");
			//consumer.commitOffsets();
		}

		// now launch all the threads
		//
		//executor = Executors.newFixedThreadPool(a_numThreads);

		// now create an object to consume the messages
		//
		/*int threadNumber = 0;
		for (final KafkaStream stream : streams) {
			executor.submit(new ConsumerTest(stream, threadNumber));
			// System.out.println("size:" + stream.size());
			threadNumber++;
		}*/
	}

	private static ConsumerConfig createConsumerConfig(String a_zookeeper, String a_groupId) {
		Properties props = new Properties();
		props.put("zookeeper.connect", a_zookeeper);
		//props.setProperty("metadata.broker.list", "localhost:9092,localhost:9093,localhost:9094");
		props.put("group.id", a_groupId);
		props.put("zookeeper.session.timeout.ms", "400");
		props.put("zookeeper.sync.time.ms", "200");
		props.put("auto.commit.interval.ms", "1000");

		return new ConsumerConfig(props);
	}

	public static void main(String[] args) {
		String zooKeeper = "localhost:2181";
		String groupId = "12138";
		String topic = "page_visits";
		int threads = Integer.parseInt("1");

		ConsumerGroupExample example = new ConsumerGroupExample(zooKeeper, groupId, topic);
		example.run(threads);

		try {
			Thread.sleep(10000);
		} catch (InterruptedException ie) {

		}
		example.shutdown();
	}
}
