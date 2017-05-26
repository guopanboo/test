package club.janna.mq.rabbit;

import java.io.IOException;

public class Test {
	
	public static void main(String[] args) {
		Producer producer = new Producer("test");
		Consumer consumer1 = new Consumer("test");
		
		new Thread(consumer1).start();
		
		for(int i = 0;i < 100;i ++) {
			Money money = new Money(String.valueOf(i), String.valueOf(i));
			producer.sendMessage(money);
		}
		
		try {
			producer.close();
			consumer1.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
