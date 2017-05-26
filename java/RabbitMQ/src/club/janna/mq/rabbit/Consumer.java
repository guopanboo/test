package club.janna.mq.rabbit;

import java.io.IOException;
import java.io.Serializable;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;

public class Consumer extends RabbitMQProvider implements Runnable, com.rabbitmq.client.Consumer {

	private String cname;
	
	public Consumer(String name, String cname) {
		super(name);
		this.cname = cname;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handleCancel(String arg0) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleCancelOk(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleConsumeOk(String arg0) {
		// TODO Auto-generated method stub
		System.out.println("Consumer[" + arg0 + "] registered!");
	}

	@Override
	public void handleDelivery(String arg0, Envelope arg1, BasicProperties arg2, byte[] arg3) throws IOException {
		// TODO Auto-generated method stub
		Serializable serlz = SerializeUtil.deserialize(arg3);
		if(serlz != null && serlz instanceof Money) {
			Money money = (Money)serlz;
			if(money != null)
				System.out.println(cname + " | id: " + money.getId() + " | value: " + money.getValue());
		}
	}

	@Override
	public void handleRecoverOk(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleShutdownSignal(String arg0, ShutdownSignalException arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//start consuming messages. Auto acknowledge messages.
		try {
			channel.basicConsume(name, true,this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
