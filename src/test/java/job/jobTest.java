package job;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.joda.time.DateTime;

import redis.clients.jedis.Jedis;

public class jobTest {
	public static int getAllUnreadMessage(String userId){
		int badge = 0;
		/*final String UNREAD_ZAN_REMOVE_REGEX = "\\S+from\\S+";
		final String UNREAD_COMMENT_PATTERN_USERID = "mq_comment_paste_to_%s";
		final String UNREAD_FRIENDSHIP_PATTERN_USERID = "mq_friendship_to_%s_sort_set";
		final String UNREAD_ZAN_PATTERN_USERID = "mq_zan_paste_to_%s*";
		
		Jedis jedis = RedisUtils.getJedis();
		List<String> unreadZanList = RedisUtils.scan(jedis,String.format(UNREAD_ZAN_PATTERN_USERID, userId),UNREAD_ZAN_REMOVE_REGEX);
		List<String> unreadCommentList = RedisUtils.scan(jedis, String.format(UNREAD_COMMENT_PATTERN_USERID, userId));
		List<String> unreadFriendshipList = RedisUtils.scan(jedis,String.format(UNREAD_FRIENDSHIP_PATTERN_USERID, userId));
		for(String friend : unreadFriendshipList){
			Set<FriendshipMessage> currentUnreadSet = RedisUtils.zrevrange(jedis,friend);
			badge += currentUnreadSet.size();
		}//System.out.println("friend:"+badge);
		for(String zan : unreadZanList){
			Set<ZanMessage> currentUnreadSet = RedisUtils.zrevrange(jedis,zan);
			badge += currentUnreadSet.size();
		}//System.out.println("friend+zan:"+badge);
		for(String comment : unreadCommentList){
			Set<CommentMessage> currentUnreadSet = RedisUtils.zrevrange(jedis,comment);
			badge += currentUnreadSet.size();
		}//System.out.println("friend+zan+comment:"+badge);
		//System.out.println(badge);*/
		return badge;
	}
	public static void main(String args[]){
		
//		Map<Integer,Integer> map = new HashMap();
//		map.put(12345, 111);
//		map.put(54321, 222);
//		for(Integer userid : map.keySet()){
//			Integer i = map.get(userid);
//			System.out.println(i);
//		}
		test12();
	}
	public void test11(){
		List<String> listS = new ArrayList<String>();
	}
	public static void test12(){
		DateTime dateTime = new DateTime(2016,5,26,0,0,0);
		DateTime dateTime2 = dateTime.minusDays(30);
		System.out.println(dateTime+"####"+dateTime2);
	}
}
