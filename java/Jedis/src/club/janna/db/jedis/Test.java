package club.janna.db.jedis;

import redis.clients.jedis.Jedis;

public class Test {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("localhost");
		System.out.println("connect to redis success!");
		System.out.println(jedis.ping());
		System.out.println(jedis.get("mykey"));
		
		jedis.set("yzy", "杨正欲是个sd!");
		
		System.out.println(jedis.get("yzy"));
		
		jedis.del("yzy");
		
		System.out.println(jedis.get("yzy"));
		
		jedis.close();
	}
}
