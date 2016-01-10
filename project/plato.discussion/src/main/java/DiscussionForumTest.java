import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srmri.plato.core.discussionforum.entity.DfAttachedFile;
import com.srmri.plato.core.discussionforum.entity.DfThreadReply;
import com.srmri.plato.core.discussionforum.service.DfAttachedFileService;
import com.srmri.plato.core.discussionforum.service.DfThreadReplyService;

public class DiscussionForumTest {
	public static void main(String args[]){

		@SuppressWarnings("resource")
		ApplicationContext ctx = 
		new ClassPathXmlApplicationContext("config/applicationContext.xml");
		//Interface class name
		/*		DfTopicService topicService = 
		        (DfTopicService) ctx.getBean("topicService");		
		discussionForumTest(topicService);*/

		//DfTopicService topicService = 	(DfTopicService) ctx.getBean("topicService");
		DfAttachedFileService threadReplyService = 	(DfAttachedFileService)ctx.getBean("attachedFileService");
		discussionForumTest(threadReplyService);
		System.out.println("done");
	}

	/*
	 * Test function for testing role level data services
	 */
	public static void discussionForumTest(DfAttachedFileService threadReplyService){

		DfThreadReply newThreadReply = new DfThreadReply();
		newThreadReply.setReplyText("this is reply text");
		newThreadReply.setThreadId(73L);
		newThreadReply.setDeleteFlag(false);
		newThreadReply.setSubmittedTime(new java.sql.Timestamp(System.currentTimeMillis()));
		newThreadReply.setSubmittedUserid(11L);
		
		threadReplyService.df_s_removeAttachedFile(90L);

/*		// Rupesh Impl
//		DfTopic topic = new DfTopic();
//		java.util.Date curDate = new java.util.Date();
//		java.sql.Timestamp curTime = new java.sql.Timestamp(System.currentTimeMillis());
//		
//		String dateString = curTime.toLocalDateTime().toString();
		//java.sql.Timestamp curTime1 = new java.sql.Timestamp(System.currentTimeMillis());
		//dateString = dateString.replace('T', ' ');
//		System.out.println("string "+curTime.getDate());
//		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
//		java.sql.Date dob = new java.sql.Date(formatter.parse(dateString).getTime());

		//topic.setTopicId(12L);
//		topic.setTopicTitle("Topic Title 21111");
//		topic.setDeletedFlag(false);
//		topic.setCreatedUserid(11L);
//		topic.setCreatedTime(curTime);
//		topicService.df_s_insertTopic(topic);
*/

		//java.sql.Date dob = new java.sql.Date(formatter.parse("").getTime());
		//		//List
		//		System.out.println("List");
		//		List<DfTopic> list = topicService.df_s_getAllTopicList();
		//		
		//		Iterator<DfTopic> topicIt = list.iterator();
		//		while(topicIt.hasNext()){
		//			System.out.println(topicIt.next());
		//		}
		//		

		//BigInteger val =BigInteger.valueOf(11);
		//topicService.df_s_deleteTopic(val);
		//		for (int i = 0; i < list.size(); i++) {
		//			System.out.println(list.get(i).getTopicTitle());
		//		}
		//		

		//		DfAttachedFile file = new DfAttachedFile();
		//		file.setFileLocation("Location");
		//		file.setFileName("file Name");
		//		file.setFileSize(123L);
	}
}
