package club.janna.mq.rabbit;

import java.io.IOException;

public class Test {
	
	public static void main(String[] args) {
		Producer producer = new Producer("test");
		Consumer consumer1 = new Consumer("test", "consumer1");
		Consumer consumer2 = new Consumer("test", "consumer2");
		Consumer consumer3 = new Consumer("test", "consumer3");
		
		new Thread(consumer1).start();
		new Thread(consumer2).start();
		new Thread(consumer3).start();
		
		for(int i = 0;i < 100;i ++) {
			Money money = new Money(String.valueOf(i), String.valueOf(i));
			producer.sendMessage(money);
		}
		
		try {
			producer.close();
			consumer1.close();
			consumer2.close();
			consumer3.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
