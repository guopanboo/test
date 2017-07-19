package club.janna.mq.rabbit;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public abstract class RabbitMQProvider {
	
	protected Channel channel;
	protected Connection connection;
    protected String name;

    public RabbitMQProvider(String name) {
    		this.name = name;
    		
    		//Create a connection factory
        ConnectionFactory factory = new ConnectionFactory();
    
        //hostname of your rabbitmq server
        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setUsername("guopanbo");
        factory.setPassword("guopanbo"); 
	
        try {
        		//getting a connection
			connection = factory.newConnection();
			 //creating a channel
			channel = connection.createChannel();
			//declaring a queue for this channel. If queue does not exist,
	        //it will be created on the server.
			channel.queueDeclare(name, true, false, false, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void close() {
    		if(channel != null)
	        try {
				this.channel.close();
			} catch (TimeoutException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		if(connection != null)
			try {
				this.connection.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
}
