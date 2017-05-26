package club.janna.mq.rabbit;

import java.io.IOException;
import java.io.Serializable;


public class Producer extends RabbitMQProvider {

	public Producer(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public void sendMessage(Serializable obj) {
		if(obj == null)
			return;
		try {
			channel.basicPublish("",name, null, SerializeUtil.serialize(obj));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
