package com.srmri.plato.core.discussionforum.controller;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.srmri.plato.core.discussionforum.entity.DfAttachedFile;
import com.srmri.plato.core.discussionforum.entity.DfModeratorAssigned;
import com.srmri.plato.core.discussionforum.entity.DfThread;

import com.srmri.plato.core.discussionforum.entity.DfThreadReply;
import com.srmri.plato.core.discussionforum.entity.DfThreadReplyFileMap;
import com.srmri.plato.core.discussionforum.entity.DfTopic;
import com.srmri.plato.core.discussionforum.service.DfAttachedFileService;
import com.srmri.plato.core.discussionforum.service.DfModeratorAssignedService;
import com.srmri.plato.core.discussionforum.service.DfThreadFileMapService;
import com.srmri.plato.core.discussionforum.service.DfThreadReplyFileMapService;
import com.srmri.plato.core.discussionforum.service.DfThreadReplyService;
import com.srmri.plato.core.discussionforum.service.DfThreadService;
import com.srmri.plato.core.discussionforum.service.DfThreadSubscriptionService;
import com.srmri.plato.core.discussionforum.service.DfTopicService;
//import com.srmri.plato.core.rbac.entity.Role;
//import com.srmri.plato.core.rbac.entity.RoleAssignment;
//import com.srmri.plato.core.rbac.entity.RoleLevel;
//import com.srmri.plato.core.rbac.service.RoleAssignmentService;
//import com.srmri.plato.core.rbac.service.RoleLevelService;
//import com.srmri.plato.core.rbac.service.RolePermissionsMapService;
//import com.srmri.plato.core.rbac.service.RoleService;

//import main.java.com.srmri.plato.core.login.bean.UserBean;

@Controller
@SessionAttributes({"user"})
public class CommonController {
	
	@Autowired
	private MailSender mailSender;
	
	//@RequestMapping(value = "/mailsender")
	void sendUserMail(String message){
		String sender="srmtestingplato@gmail.com";//sender email id
		String receiver="7yadavrupesh@gmail.com";//receiver email id
		sendMail(sender,receiver,"Disapprove Topic",message);
		System.out.println("success");
	}
	
	public void sendMail(String from, String to, String subject, String msg) {
		 
		SimpleMailMessage message = new SimpleMailMessage();
 
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(msg);
		mailSender.send(message);	
	}
	//	@Autowired
	//	@Autowired
	//	private RoleService roleService;
	//	@Autowired
	//	private RoleAssignmentService roleAssignmentService;
	//	@Autowired RolePermissionsMapService rolePermissionsMapService;

	long loginUserId = 101L;
	int roleId;
	List<Long> admin = new ArrayList<Long>();
	Map<Long,String> usersListMap = new HashMap<Long,String>();

	public CommonController(){
		usersListMap.put(10L, "Rupesh");
		usersListMap.put(11L, "Hitesh");
		usersListMap.put(101L, "Bhupendra");
		usersListMap.put(102L, "Sagar");
		admin.add(101L);
		admin.add(102L);
	}

	Boolean checkAdmin(long userId, int roleId)
	{	
		//		System.out.println(userId);
		//		Role role = roleService.rbac_bl_getRole(roleId);
		//		RoleLevel roleLevel = roleLevelService.rbac_bl_getRoleLevel(role.getRoleLevelId());
		//		String rlName = roleLevel.getRoleLevelName();
		//		if(rlName.equals("Admin Level"))
		//			return true;
		//		return false;
		for(Long id : admin){
			if(id ==loginUserId)
				return true;
		}
		return false;
	}

	@Autowired
	private DfTopicService topicService;
	@Autowired
	private DfThreadReplyService threadReplyService;
	@Autowired
	private DfThreadService threadService;
	@Autowired
	private DfThreadSubscriptionService threadSubscriptionService;
	@Autowired
	private DfModeratorAssignedService moderatorAssignedService;
	@Autowired
	private DfAttachedFileService attachedFileService;
	@Autowired
	private DfThreadFileMapService threadFileMapService;
	@Autowired
	private DfThreadReplyFileMapService threadReplyFileMapService;

	@RequestMapping(value = "/discussionforumDashboard", method = RequestMethod.GET)
	public String discussionforumDashboard(Model model) {	         
		model.addAttribute("userId", loginUserId);
		model.addAttribute("threadApproveLeft", threadService.dfSGetAllUnApprovedThreadList().size());
		model.addAttribute("topicApproveLeft", topicService.dfSGetAllUnApprovedTopics().size());
		return"discussionforumDashboard";
	}

	@RequestMapping(value = "/listTopic", method = RequestMethod.GET)
	public String topicList(Model model, @RequestParam(value="userId", required=false) Long createdUserid){

		List<DfTopic> allTopicList = new ArrayList<DfTopic>();
		if(createdUserid != null)
			allTopicList = topicService.dfSGetTopicList(createdUserid);
		else
			allTopicList = topicService.dfSGetAllTopicList();

		Map<Long, Boolean> moderatorAllowMap = new HashMap<Long,Boolean>();
		Map<DfTopic, String> finalTopicList = new HashMap<DfTopic,String>();
		Map<Long, Integer> topicWiseThreadList = new HashMap<Long , Integer>();
		if(checkAdmin(this.loginUserId, this.roleId)){
			for(DfTopic topic: allTopicList){
				moderatorAllowMap.put(topic.getTopicId(), true);
			}
		}
		else{
			for(DfTopic topic: allTopicList){
				List<Long> assignedModeratorList = moderatorAssignedService.dfSGetModeratorList(topic.getTopicId());
				if(!assignedModeratorList.isEmpty()){
					for(Long moderator:assignedModeratorList){
						if(moderator == this.loginUserId){
							System.out.println("getting moderators");
							moderatorAllowMap.put(topic.getTopicId(), true);
						}
						else
							moderatorAllowMap.put(topic.getTopicId(), false);
					}
				}
				else if(checkAdmin(this.loginUserId, this.roleId)){
					moderatorAllowMap.put(topic.getTopicId(), true);
				}
				else{
					moderatorAllowMap.put(topic.getTopicId(), false);
				}
			}
		}
		// prepare extra list 
		for(DfTopic topic: allTopicList){
			finalTopicList.put(topic, usersListMap.get(topic.getCreatedUserid()));
			topicWiseThreadList.put(topic.getTopicId(), threadService.dfSGetTopicThreads(topic.getTopicId()).size());
		}
		model.addAttribute("moderatorAllowMap", moderatorAllowMap);
		model.addAttribute("topics",  finalTopicList);
		model.addAttribute("loginUserId",  loginUserId);
		model.addAttribute("topicWiseThreadList",  topicWiseThreadList);
		return"listTopic";
	}

	@RequestMapping(value = "/addTopic", method = RequestMethod.GET)
	public String addTopic(@ModelAttribute("topic") DfTopic topic, BindingResult result) {	         
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("topic",  topic);
		return"addTopic";
	}

	@RequestMapping(value = "/addTopic", method = RequestMethod.POST)
	public String saveTopic(@Validated @ModelAttribute("topic")  DfTopic topic, BindingResult result,Model model,RedirectAttributes redirectAttributes) {
		if(result.hasErrors()){
			model.addAttribute("alertMessage", "Add topic failed!");
			model.addAttribute("css", "danger");
			model.addAttribute("topic", topic);
			return"addTopic";
		}
		redirectAttributes.addFlashAttribute("alertMessage", "New topic inserted");
		redirectAttributes.addFlashAttribute("css", "success");
		java.sql.Timestamp curTime = new java.sql.Timestamp(new java.util.Date().getTime());
		topic.setCreatedTime(curTime);
		topic.setCreatedUserid(loginUserId);
		topic.setDeletedFlag(false);
		topic.setApprovedFlag(false);
		topicService.dfSInsertTopic(topic);

		return "redirect:listTopic.html";
	}

	@RequestMapping(value = "/editTopic", method = RequestMethod.GET)
	public String editTopic(Model model, @RequestParam Long topic_id) {
		model.addAttribute("topic",topicService.dfSGetTopic(topic_id));
		return "editTopic";
	}

	@RequestMapping(value = "/editTopic", method = RequestMethod.POST)
	public String saveEditTopic(@Validated @ModelAttribute("topic")  DfTopic topic, BindingResult result,Model model,RedirectAttributes redirectAttributes) {
		if(result.hasErrors()){
			model.addAttribute("alertMessage", "Edit topic failed!");
			model.addAttribute("css", "danger");
			model.addAttribute("topic", topic);
			return"editTopic";
		}
		DfTopic oldTopic = topicService.dfSGetTopic(topic.getTopicId());
		oldTopic.setTopicTitle(topic.getTopicTitle());
		oldTopic.setTopicDescription(topic.getTopicDescription());
		topicService.dfSInsertTopic(oldTopic);		
		redirectAttributes.addFlashAttribute("alertMessage", "Topic Updated");
		redirectAttributes.addFlashAttribute("css", "success");
		return "redirect:listTopic.html";
	}

	@RequestMapping(value = "/deleteTopic", method = RequestMethod.GET)
	public String deleteTopic(Model model, @RequestParam Long topic_id) {
		topicService.dfSDeleteTopic(topic_id);
		return "redirect:listTopic.html";
	}

	@RequestMapping(value = "/saveDeletedTopic", method = RequestMethod.GET)
	public String saveDeletedTopic(Model model, @RequestParam Long topic_id,RedirectAttributes redirectAttributes) {
		topicService.dfSUndoDeletedTopic(topic_id);
		model.addAttribute("deletedTopics",topicService.dfSGetDeletedTopic(loginUserId));
		redirectAttributes.addFlashAttribute("alertMessage", "Topic is open for discussion");
		redirectAttributes.addFlashAttribute("css", "success");
		return "redirect:deletedTopic.html";
	}

	@RequestMapping(value = "/deletedTopic", method = RequestMethod.GET)
	public String deletedTopic(Model model/*, @ModelAttribute("user") UserBean userBean*/) {

		/*long userId = userBean.getUserId();
		int roleId = userBean.getRoleId();*/

		model.addAttribute("deletedTopics",topicService.dfSGetDeletedTopic(loginUserId));
		List<DfTopic> allDeletedTopicList = topicService.dfSGetAllDeletedTopic();
		List<DfModeratorAssigned> moderatorAssignedFor = moderatorAssignedService.dfSGetTopicUserActModerator(loginUserId);
		List<DfTopic> deletedTopicsList = new ArrayList<DfTopic>();

		if(checkAdmin(this.loginUserId, roleId)){
			for(DfTopic deletedTopic: allDeletedTopicList){
				deletedTopicsList.add(deletedTopic);
			}
		}else{

			for(DfModeratorAssigned moderator: moderatorAssignedFor){
				for(DfTopic deletedTopic: allDeletedTopicList){
					if(moderator.getTopicId() == deletedTopic.getTopicId() || deletedTopic.getCreatedUserid() == loginUserId){
						deletedTopicsList.add(deletedTopic);
					}
				}
			}
		}
		model.addAttribute("deletedTopics",deletedTopicsList);
		return "deletedTopic";
	}

	@RequestMapping(value = "/approveTopic", method = RequestMethod.GET)
	public String approveTopic(Model model/*, @ModelAttribute("user") UserBean userBean*/) {

		/*long userId = userBean.getUserId();
		int roleId = userBean.getRoleId();*/
		Map<DfTopic, String> approveTopicList = new HashMap<DfTopic, String>();
		if(checkAdmin(loginUserId, roleId)){
			for(DfTopic topic: topicService.dfSGetAllUnApprovedTopics()){
				approveTopicList.put(topic, usersListMap.get(topic.getCreatedUserid()));
			}
			model.addAttribute("approveTopics",approveTopicList);
		}else{
			model.addAttribute("approveTopics",null);
		}
		return "approveTopic";
	}

	@RequestMapping(value = "/saveApproveTopic", method = RequestMethod.GET)
	public String saveApproveTopic(Model model, @RequestParam Long topic_id,RedirectAttributes redirectAttributes) {

		/*long userId = userBean.getUserId();
		int roleId = userBean.getRoleId();*/
		if(checkAdmin(loginUserId, roleId)){
			topicService.dfSApproveTopic(topic_id);
			DfTopic topicApproved = topicService.dfSGetTopic(topic_id);
			topicApproved.setApprovedBy(loginUserId);
			topicService.dfSInsertTopic(topicApproved);
			model.addAttribute("approveTopics",topicService.dfSGetAllUnApprovedTopics());
		}else{
			model.addAttribute("approveTopics",null);
		}
		redirectAttributes.addFlashAttribute("alertMessage", "Topic has been added to the topic list");
		redirectAttributes.addFlashAttribute("css", "success");
		return "redirect:approveTopic.html";
	}
	@RequestMapping(value = "/disApproveTopic", method = RequestMethod.GET)
	public String disApproveTopic(Model model, @RequestParam Long topic_id, @RequestParam String message) {
		// sendMail(message);
		sendUserMail(message);
		topicService.dfSDeleteTopic(topic_id);

		return "redirect:approveTopic.html";
	}
	@RequestMapping(value = "/approveTopicByUser", method = RequestMethod.GET)
	public String approveTopicByUser(Model model, HttpServletRequest request) {
		Long userId = Long.parseLong(request.getParameter("userId"));
		Map<DfTopic, String> approveTopicList = new HashMap<DfTopic, String>();

		if(checkAdmin(loginUserId, roleId)){
			List<DfTopic> topicsApprovedByUser = topicService.dfSGetAllTopicsApprovedByUser(userId);
			for(DfTopic topic: topicsApprovedByUser){
				approveTopicList.put(topic, usersListMap.get(topic.getCreatedUserid()));
			}
			model.addAttribute("approveTopics",approveTopicList);
		}else{
			model.addAttribute("approveTopics",null);
		}
		return "approveTopicByUser";
	}
	/************************************** THREAD **************************************************/

	@RequestMapping(value = "/listThread", method = RequestMethod.GET)
	public String listThread(Model model) {
		/*long userId = userBean.getUserId();
		int roleId = userBean.getRoleId();*/
		Map<Long,String> topics = new HashMap<Long,String>();
		List<DfThread>  threadList = new ArrayList<DfThread>();
		threadList = threadService.dfSGetAllThreadList();
		for(DfTopic topicIt: topicService.dfSGetAllDeletedNonDeletedTopicList()){
			topics.put(topicIt.getTopicId(), topicIt.getTopicTitle());
		}

		Map<Long, Boolean> moderatorAllowMap = new HashMap<Long,Boolean>();
		List<DfModeratorAssigned> allModerators =  moderatorAssignedService.dfSGetAllModerators();
		if(threadList != null){
			for(DfThread thread : threadList){

				if(checkAdmin(loginUserId, roleId)){
					moderatorAllowMap.put(thread.getThreadId(), true);
				}
				else if(loginUserId == thread.getCreatedUserid()){
					moderatorAllowMap.put(thread.getThreadId(), true);
				}
				else{
					if(allModerators != null){
						for(DfModeratorAssigned moderator:allModerators){
							if(moderator.getAssignedToUserid() == loginUserId){
								moderatorAllowMap.put(thread.getThreadId(), true);
							}
							else
								moderatorAllowMap.put(thread.getThreadId(), false);
						}
					}
					else{
						moderatorAllowMap.put(thread.getThreadId(), false);
					}
				}
			}
		}
		Map<DfThread, String> finalThredList = new HashMap<DfThread,String>();
		Map<Long, Integer> numberOfReplies = new HashMap<Long, Integer>();
		for(DfThread thread: threadList){
			finalThredList.put(thread, usersListMap.get(thread.getCreatedUserid()));
			numberOfReplies.put(thread.getThreadId(), threadReplyService.dfSGetThreadReplyList(thread.getThreadId()).size());
		}
		System.out.println(finalThredList.size());
		model.addAttribute("moderatorAllowMap", moderatorAllowMap);
		model.addAttribute("threads",  finalThredList);
		model.addAttribute("topics",topics);
		model.addAttribute("loginUserId",loginUserId);
		model.addAttribute("numberOfReplies", numberOfReplies);
		return "listThread";
	}
	@RequestMapping(value = "/increaseTopicCount", method = RequestMethod.GET)
	public String increaseTopicCount(Model model, @RequestParam Long topic_id){

		// increasing times view
		DfTopic topic =  topicService.dfSGetTopic(topic_id);
		topic.setNumberOfView(topic.getNumberOfView()+1);
		topicService.dfSInsertTopic(topic);
		return "redirect:index.jsp";
	}

	@RequestMapping(value = "/listThreadTopic", method = RequestMethod.GET)
	public String listThreadTopic(Model model, @RequestParam Long topic_id/*, @ModelAttribute("user") UserBean userBean*/) {

		Map<Long,String> topics = new HashMap<Long,String>();
		List<DfThread>  threadList = new ArrayList<DfThread>();
		threadList = threadService.dfSGetTopicThreads(topic_id);
		for(DfTopic topicIt: topicService.dfSGetAllDeletedNonDeletedTopicList()){
			topics.put(topicIt.getTopicId(), topicIt.getTopicTitle());
		}

		Map<Long, Boolean> moderatorAllowMap = new HashMap<Long,Boolean>();
		List<Long> assignedModeratorList = moderatorAssignedService.dfSGetModeratorList(topic_id);
		if(!threadList.isEmpty()){
			for(DfThread thread : threadList){

				if(checkAdmin(loginUserId, roleId)){
					moderatorAllowMap.put(thread.getThreadId(), true);
				}
				else if(loginUserId == thread.getCreatedUserid()){
					moderatorAllowMap.put(thread.getThreadId(), true);
				}
				else{
					if(!assignedModeratorList.isEmpty()){
						for(Long moderator:assignedModeratorList){
							if(moderator == loginUserId){
								moderatorAllowMap.put(thread.getThreadId(), true);
							}
							else
								moderatorAllowMap.put(thread.getThreadId(), false);
						}
					}
					else{
						moderatorAllowMap.put(thread.getThreadId(), false);
					}
				}
			}
		}
		Map<DfThread, String> finalThredList = new HashMap<DfThread,String>();
		Map<Long, Integer> numberOfReplies = new HashMap<Long, Integer>();
		for(DfThread thread: threadList){
			finalThredList.put(thread, usersListMap.get(thread.getCreatedUserid()));
			numberOfReplies.put(thread.getThreadId(), threadReplyService.dfSGetThreadReplyList(thread.getThreadId()).size());
		}
		model.addAttribute("moderatorAllowMap", moderatorAllowMap);
		model.addAttribute("threads",  finalThredList);
		model.addAttribute("topics",topics);
		model.addAttribute("loginUserId",loginUserId);
		model.addAttribute("numberOfReplies", numberOfReplies);
		return "listThread";
	}
	@RequestMapping(value = "/listThreadUser", method = RequestMethod.GET)
	public String listThreadUser(Model model, @RequestParam Long userId/*, @ModelAttribute("user") UserBean userBean*/) {
		/*long userId = userBean.getUserId();
		int roleId = userBean.getRoleId();*/
		Map<Long,String> topics = new HashMap<Long,String>();
		List<DfThread>  threadList = new ArrayList<DfThread>();
		List<Long> assignedModeratorList =  new ArrayList<Long>();
		//	List<DfTopic> topicList = topicService.df_s_getTopicList(userId);
		threadList = threadService.dfSGetAllThreadListUser(userId);;

		for(DfTopic topicIt: topicService.dfSGetAllDeletedNonDeletedTopicList()){
			topics.put(topicIt.getTopicId(), topicIt.getTopicTitle());
		}

		Map<Long, Boolean> moderatorAllowMap = new HashMap<Long,Boolean>();

		if(!threadList.isEmpty()){
			for(DfThread thread : threadList){
				moderatorAllowMap.put(thread.getThreadId(), true);
			}
		}
		Map<DfThread, String> finalThredList = new HashMap<DfThread,String>();
		Map<Long, Integer> numberOfReplies = new HashMap<Long, Integer>();
		for(DfThread thread: threadList){
			finalThredList.put(thread, usersListMap.get(thread.getCreatedUserid()));
			numberOfReplies.put(thread.getThreadId(), threadReplyService.dfSGetThreadReplyList(thread.getThreadId()).size());
		}
		model.addAttribute("moderatorAllowMap", moderatorAllowMap);
		model.addAttribute("threads",  finalThredList);
		model.addAttribute("topics",topics);
		model.addAttribute("loginUserId",loginUserId);
		model.addAttribute("numberOfReplies", numberOfReplies);
		return "listThread";
	}

	@RequestMapping(value = "/addThread", method = RequestMethod.GET)
	public String addThread(@ModelAttribute("thread") DfThread thread,@RequestParam(value="topic_id", required=false) Long topic_id, Model model) {	    

		model = prepareAddThreadModel(model, thread,topic_id);
		return "addThread";
	}

	Model prepareAddThreadModel(Model model, DfThread thread,Long topic_id ){
		Map<Long,String> topics = new HashMap<Long,String>();

		for(DfTopic topic: topicService.dfSGetAllTopicList()){
			topics.put(topic.getTopicId(), topic.getTopicTitle());
		}
		if(topic_id != null){
			model.addAttribute("selectedTopic", topic_id);
		}
		model.addAttribute("thread", thread);
		model.addAttribute("topics", topics);
		return model;
	}

	@RequestMapping(value = "/addThread", method = RequestMethod.POST)
	public String saveAddThread(@Validated @ModelAttribute("thread") DfThread thread, BindingResult result,@RequestParam(value = "file", required=false) List<MultipartFile> files,Model model,RedirectAttributes redirectAttributes) {

		if(result.hasErrors()){
			model.addAttribute("alertMessage", "Add thread failed!");
			model.addAttribute("css", "danger");
			model = prepareAddThreadModel(model, thread,thread.getTopicId());
			return "addThread";
		}
		redirectAttributes.addFlashAttribute("alertMessage", "New thread inserted");
		redirectAttributes.addFlashAttribute("css", "success");
		java.sql.Timestamp curTime = new java.sql.Timestamp(System.currentTimeMillis());
		thread.setCreatedTime(curTime);
		thread.setModifiedTime(curTime);
		thread.setCreatedUserid(loginUserId);
		thread.setDeletedFlag(false);
		thread.setApproved(false);
		threadService.dfSAddThread(thread);
		threadSubscriptionService.dfSAddThreadSubscription(thread.getThreadId(), loginUserId);

		File serverFile = null;
		Long UploadedFileId = 0L;

		if(files !=null){
			for(MultipartFile file : files){
				if (!file.isEmpty()) {
					try {
						byte[] bytes = file.getBytes();
						// Creating the directory to store file
						String rootPath = System.getProperty("catalina.home");
						// storePath Format: /plato/discussion_forum/thread/<threadId>/<loginUserId> 
						String storePath = File.separator + "plato"+File.separator+"discussion_forum"+File.separator+"thread"+File.separator+thread.getThreadId()+
								File.separator+loginUserId;
						File dir = new File(rootPath + storePath);
						if (!dir.exists())
							dir.mkdirs();

						// Create the file on server
						serverFile = new File(dir.getAbsolutePath()	+ File.separator + file.getOriginalFilename());
						BufferedOutputStream stream = new BufferedOutputStream(	new FileOutputStream(serverFile));
						stream.write(bytes);
						stream.close();
						DfAttachedFile fileToSaveInDB = new DfAttachedFile();
						fileToSaveInDB.setFileLocation(serverFile.getAbsolutePath());
						fileToSaveInDB.setFileName(file.getOriginalFilename());
						fileToSaveInDB.setFileSize(file.getSize());
						UploadedFileId = attachedFileService.dfSAddAttachedFile(fileToSaveInDB);

						threadFileMapService.dfSAddThreadFileMap(thread.getThreadId(), UploadedFileId);
						System.out.println("Server File Location="	+ serverFile.getAbsolutePath());

					} catch (Exception e) {
						return "You failed to upload " + file.getOriginalFilename() + " => " + e.getMessage();
					}
				}	
			}
		}
		return "redirect:listThreadTopic.html?topic_id="+thread.getTopicId();
	}

	Model prepareEditThreadModel(Model model, DfThread thread){
		List<Long> attachedFileIdList = threadFileMapService.dfSGetFileList(thread.getThreadId());
		Map<Long, String> finalFileListMap = new HashMap<Long,String>();
		if(!attachedFileIdList.isEmpty()){
			for(Long fileId : attachedFileIdList){
				String filePath = attachedFileService.dfSGetAttachedFile(fileId).getFileLocation();
				File file = new File(filePath);
				if(file.exists())
					finalFileListMap.put(fileId, attachedFileService.dfSGetAttachedFile(fileId).getFileName());
			}
		}

		model.addAttribute("finalFileListMap",finalFileListMap);
		model.addAttribute("thread",thread);
		return model;
	}

	@RequestMapping(value = "/editThread", method = RequestMethod.GET)
	public String editThread(Model model, @RequestParam Long thread_id,HttpServletRequest request) {
		model = prepareEditThreadModel(model, threadService.dfSGetThread(thread_id));
		return "editThread";
	}

	@RequestMapping(value = "/editThread", method = RequestMethod.POST)
	public String saveEditThread( @ModelAttribute("thread") @Validated DfThread thread, BindingResult result,HttpServletRequest request,
			@RequestParam(value = "file", required=false) List<MultipartFile> files,@RequestParam(value="checkBoxFile", required=false) List<Long> checkBox, Model model,RedirectAttributes redirectAttributes) {	
		if(result.hasErrors()){
			model.addAttribute("alertMessage", "Update thread failed!");
			model.addAttribute("css", "danger");
			model = prepareEditThreadModel(model, thread);
			return "editThread";
		}
		redirectAttributes.addFlashAttribute("alertMessage", "Thread updated");
		redirectAttributes.addFlashAttribute("css", "success");
		File serverFile = null;
		Long UploadedFileId = 0L;

		// Delete Files Start
		if(checkBox != null)
		{
			for(Long c:checkBox){
				System.out.println(c);
				threadFileMapService.dfSRemoveThreadFileMap(c);
			}
		}
		// Delete Files Start		


		if(files !=null){
			for(MultipartFile file : files){
				if (!file.isEmpty()) {
					try {
						byte[] bytes = file.getBytes();
						// Creating the directory to store file
						String rootPath = System.getProperty("catalina.home");
						// storePath Format: /plato/discussion_forum/thread/<threadId>/<loginUserId> 
						String storePath = File.separator + "plato"+File.separator+"discussion_forum"+File.separator+"thread"+File.separator+thread.getThreadId()+
								File.separator+loginUserId;
						File dir = new File(rootPath + storePath);
						if (!dir.exists())
							dir.mkdirs();

						// Create the file on server
						serverFile = new File(dir.getAbsolutePath()	+ File.separator + file.getOriginalFilename());
						BufferedOutputStream stream = new BufferedOutputStream(	new FileOutputStream(serverFile));
						stream.write(bytes);
						stream.close();
						DfAttachedFile fileToSaveInDB = new DfAttachedFile();
						fileToSaveInDB.setFileLocation(serverFile.getAbsolutePath());
						fileToSaveInDB.setFileName(file.getOriginalFilename());
						fileToSaveInDB.setFileSize(file.getSize());
						UploadedFileId = attachedFileService.dfSAddAttachedFile(fileToSaveInDB);

						threadFileMapService.dfSAddThreadFileMap(thread.getThreadId(), UploadedFileId);
						System.out.println("Server File Location="	+ serverFile.getAbsolutePath());

					} catch (Exception e) {
						return "You failed to upload " + file.getOriginalFilename() + " => " + e.getMessage();
					}
				}	
			}
		}

		Timestamp time = Timestamp.valueOf(threadService.dfSGetThread(thread.getThreadId()).getCreatedTime());
		thread.setCreatedTime(time);
		thread.setModifiedTime(time);
		thread.setCreatedUserid(loginUserId);
		thread.setDeletedFlag(false);
		thread.setApproved(true);
		threadService.dfSAddThread(thread);

		String sourcePage = request.getParameter("edit");
		if(sourcePage == "approveThread")
			return "redirect:approveThread.html";
		if(sourcePage == "viewThread")
			return "redirect:viewThread.html?thread_id="+thread.getThreadId();
		else
			return "redirect:listThreadTopic.html?topic_id="+thread.getTopicId();
	}
	Model prepareViewThread(Model model,DfThreadReply threadReply, Long thread_id/*, @ModelAttribute("user") UserBean userBean*/){

		/*long userId = userBean.getUserId();
		int roleId = userBean.getRoleId();*/
		List<Long> threadFileList = threadFileMapService.dfSGetFileList(thread_id);
		Map<Long,String> finalThreadFileListMap = new HashMap<Long,String>();

		if(!threadFileList.isEmpty())
		{
			for(Long attachedFileId: threadFileList){
				String filePath = attachedFileService.dfSGetAttachedFile(attachedFileId).getFileLocation();
				File file = new File(filePath);
				if(file.exists())
					finalThreadFileListMap.put(attachedFileId,file.getName());
			}
		}

		model.addAttribute("finalThreadFileListMap", finalThreadFileListMap);
		List<DfThreadReply> threadReplysList = threadReplyService.dfSGetThreadReplyList(thread_id);
		Map<DfThreadReply,Map<Long,String>> finalThreadReplyList = new HashMap<DfThreadReply,Map<Long,String>>();
		DfThread thread = threadService.dfSGetThread(thread_id);
		Boolean threadEditAllowed = false;
		List<Long> assignedModeratorList = moderatorAssignedService.dfSGetModeratorList(thread.getTopicId());

		// Role check Start
		if(checkAdmin(loginUserId, roleId)){
			threadEditAllowed =  true;
		}
		else if(loginUserId == thread.getCreatedUserid()){
			threadEditAllowed =  true;
		}
		else if(loginUserId == topicService.dfSGetTopic(thread.getTopicId()).getCreatedUserid())
		{
			threadEditAllowed =  true;
		}
		else{
			if(!assignedModeratorList.isEmpty()){
				for(Long moderator:assignedModeratorList){
					if(moderator == loginUserId){
						threadEditAllowed =  true;
					}
				}
			}
		}

		if(checkAdmin(loginUserId, roleId)){
			model.addAttribute("admin", true);
		}
		else
			model.addAttribute("admin", false);
		// Role check End

		if(!threadReplysList.isEmpty()){
			for(DfThreadReply reply: threadReplysList){
				List<Long> attachedFilesList  = threadReplyFileMapService.dfSGetFileList(reply.getReplyId());

				if(attachedFilesList.isEmpty())
				{
					finalThreadReplyList.put(reply, null);
					continue;
				}else{
					Map<Long,String> fileList = new HashMap<Long,String>();
					for(Long attachedFileId: attachedFilesList){
						String filePath = attachedFileService.dfSGetAttachedFile(attachedFileId).getFileLocation();
						File file = new File(filePath);
						if(file.exists()){
							fileList.put(attachedFileId,file.getName());
						}
					}
					finalThreadReplyList.put(reply, fileList);
				}				
			}
		}

		model.addAttribute("threadEditAllowed", threadEditAllowed);
		model.addAttribute("thread",  threadService.dfSGetThread(thread_id));
		model.addAttribute("threadReplys",finalThreadReplyList);
		model.addAttribute("threadReply", threadReply);
		model.addAttribute("loginUserId",loginUserId);
		model.addAttribute("topicUserId",topicService.dfSGetTopic(threadService.dfSGetThread(thread_id).getTopicId()).getCreatedUserid());
		model.addAttribute("checkSubscribe", threadSubscriptionService.dfSIsSubscribed(thread_id,loginUserId));
		return model;
	}

	@RequestMapping(value = "/increaseThreadCount", method = RequestMethod.GET)
	public String increaseThreadCount(Model model, @RequestParam Long thread_id) {
		// increase number of views
		DfThread newThread = threadService.dfSGetThread(thread_id);
		newThread.setNumberOfView(newThread.getNumberOfView()+1);
		threadService.dfSAddThread(newThread);

		return "redirect:index.jsp";
	}
	@RequestMapping(value = "/viewThread", method = RequestMethod.GET)
	public String viewThread(Model model, @RequestParam Long thread_id) {


		List<Long> threadFileList = threadFileMapService.dfSGetFileList(thread_id);
		Map<Long,String> finalThreadFileListMap = new HashMap<Long,String>();

		if(!threadFileList.isEmpty())
		{
			for(Long attachedFileId: threadFileList){
				String filePath = attachedFileService.dfSGetAttachedFile(attachedFileId).getFileLocation();
				File file = new File(filePath);
				if(file.exists())
					finalThreadFileListMap.put(attachedFileId,file.getName());
			}
		}

		model.addAttribute("finalThreadFileListMap", finalThreadFileListMap);
		List<DfThreadReply> threadReplysList = threadReplyService.dfSGetThreadReplyList(thread_id);
		Map<DfThreadReply,Map<Long,String>> finalThreadReplyList = new HashMap<DfThreadReply,Map<Long,String>>();
		DfThread thread = threadService.dfSGetThread(thread_id);
		Boolean threadEditAllowed = false;
		List<Long> assignedModeratorList = moderatorAssignedService.dfSGetModeratorList(thread.getTopicId());

		// Role check Start
		if(checkAdmin(loginUserId, roleId)){
			threadEditAllowed =  true;
		}
		else if(loginUserId == thread.getCreatedUserid()){
			threadEditAllowed =  true;
		}
		else if(loginUserId == topicService.dfSGetTopic(thread.getTopicId()).getCreatedUserid())
		{
			threadEditAllowed =  true;
		}
		else{
			if(!assignedModeratorList.isEmpty()){
				for(Long moderator:assignedModeratorList){
					if(moderator == loginUserId){
						threadEditAllowed =  true;
					}
				}
			}
		}

		if(checkAdmin(loginUserId, roleId)){
			model.addAttribute("admin", true);
		}
		else
			model.addAttribute("admin", false);
		// Role check End

		if(!threadReplysList.isEmpty()){
			for(DfThreadReply reply: threadReplysList){
				List<Long> attachedFilesList  = threadReplyFileMapService.dfSGetFileList(reply.getReplyId());

				if(attachedFilesList.isEmpty())
				{
					finalThreadReplyList.put(reply, null);
					continue;
				}else{
					Map<Long,String> fileList = new HashMap<Long,String>();
					for(Long attachedFileId: attachedFilesList){
						String filePath = attachedFileService.dfSGetAttachedFile(attachedFileId).getFileLocation();
						File file = new File(filePath);
						if(file.exists()){
							fileList.put(attachedFileId,file.getName());
						}
					}
					finalThreadReplyList.put(reply, fileList);
				}				
			}
		}

		model.addAttribute("threadEditAllowed", threadEditAllowed);
		model.addAttribute("thread",  threadService.dfSGetThread(thread_id));
		model.addAttribute("threadReplys",finalThreadReplyList);
		if(!model.containsAttribute("threadReply")){
			model.addAttribute("threadReply", new DfThreadReply());
		}
		model.addAttribute("loginUserId",loginUserId);
		model.addAttribute("topicUserId",topicService.dfSGetTopic(threadService.dfSGetThread(thread_id).getTopicId()).getCreatedUserid());
		model.addAttribute("checkSubscribe", threadSubscriptionService.dfSIsSubscribed(thread_id,loginUserId));
		return "viewThread";
	}

	public static String makeUrl(HttpServletRequest request)
	{
		return request.getRequestURL().toString() + "?" + request.getQueryString();
	}

	@RequestMapping(value = "/deleteThread", method = RequestMethod.GET)
	public String deleteThread(Model model, @RequestParam Long thread_id,@RequestParam(value="message", required =false) String message, HttpServletRequest request) {
		if(message != null){
			// send mail for delete 
		}
		Long topic_id = threadService.dfSGetThread(thread_id).getTopicId();
		threadService.dfSDeleteThread(thread_id);
		return "listThread";
	}

	@RequestMapping(value = "/saveApproveThread", method = RequestMethod.GET)
	public String saveApproveThread(Model model, @RequestParam Long thread_id,RedirectAttributes redirectAttributes) {
		threadService.dfSApproveThread(thread_id, true);
		redirectAttributes.addFlashAttribute("alertMessage", "Thread has been added to the thread list");
		redirectAttributes.addFlashAttribute("css", "success");
		return "redirect:approveThread.html";
	}

	@RequestMapping(value = "/approveThread", method = RequestMethod.GET)
	public String approveThread(Model model) {

		Map<Long,String> topics = new HashMap<Long,String>();

		for(DfTopic topic: topicService.dfSGetAllDeletedNonDeletedTopicList()){
			topics.put(topic.getTopicId(), topic.getTopicTitle());
		}
		List<DfThread> approvalList = new ArrayList<DfThread>();
		List<DfThread> threadListForApproval = threadService.dfSGetAllUnApprovedThreadList();
		List<DfTopic> topicList = topicService.dfSGetTopicList(loginUserId);
		List<DfModeratorAssigned> moderatorFor = moderatorAssignedService.dfSGetTopicUserActModerator(loginUserId);

		// if admin give all threads for approval
		// else check user is moderator for that threads topic?
		if(checkAdmin(loginUserId, roleId)){
			for(DfThread thread:threadListForApproval){
				approvalList.add(thread);
			}
		}else{

			if(!moderatorFor.isEmpty()){
				for(DfModeratorAssigned moderator: moderatorFor){
					topicList.add(topicService.dfSGetTopic(moderator.getTopicId()));
				}
			}
			for(DfThread thread:threadListForApproval){
				for(DfTopic top: topicList){
					if(top.getTopicId() == thread.getTopicId())
						approvalList.add(thread);	
				}
			}
		}

		Map<DfThread, String> finalApprovalList = new HashMap<DfThread,String>();
		for(DfThread thread: approvalList){
			finalApprovalList.put(thread, usersListMap.get(thread.getCreatedUserid()));
		}
		model.addAttribute("topics",topics);
		model.addAttribute("deletedThreads",finalApprovalList);
		return "approveThread";
	}

	@RequestMapping(value = "/approvedThreadByUser", method = RequestMethod.GET)
	public String approvedThreadByUser(Model model, HttpServletRequest request) {

		Map<Long,String> topics = new HashMap<Long,String>();
		Long userId = Long.parseLong(request.getParameter("userId"));
		for(DfTopic topic: topicService.dfSGetAllDeletedNonDeletedTopicList()){
			topics.put(topic.getTopicId(), topic.getTopicTitle());
		}
		List<DfThread> approvalList = new ArrayList<DfThread>();
		List<DfThread> threadListForApproval = threadService.dfSGetAllThreadApprovedByUser(userId);
		//List<DfTopic> topicList = topicService.df_s_getTopicList(loginUserId);
		//List<DfModeratorAssigned> moderatorFor = moderatorAssignedService.df_s_getTopicUserActModerator(loginUserId);

		// if admin give all threads for approval
		// else check user is moderator for that threads topic?
		if(checkAdmin(loginUserId, roleId)){
			for(DfThread thread:threadListForApproval){
				approvalList.add(thread);
			}
		}/*else{

			if(!moderatorFor.isEmpty()){
				for(DfModeratorAssigned moderator: moderatorFor){
					topicList.add(topicService.df_s_getTopic(moderator.getTopicId()));
				}
			}
			for(DfThread thread:threadListForApproval){
				for(DfTopic top: topicList){
					if(top.getTopicId() == thread.getTopicId())
						approvalList.add(thread);	
				}
			}
		}
		 */
		Map<DfThread, String> finalApprovalList = new HashMap<DfThread,String>();
		for(DfThread thread: approvalList){
			finalApprovalList.put(thread, usersListMap.get(thread.getCreatedUserid()));
		}
		model.addAttribute("topics",topics);
		model.addAttribute("deletedThreads",finalApprovalList);
		return "approveThreadByUser";
	}
	@RequestMapping(value = "/saveUndoDeletedThread", method = RequestMethod.GET)
	public String saveUndoDeletedThread(Model model, @RequestParam Long thread_id) {
		threadService.dfSUndoDeletedThread(thread_id);
		Map<Long,String> topics = new HashMap<Long,String>();

		for(DfTopic topic: topicService.dfSGetAllTopicList()){
			topics.put(topic.getTopicId(), topic.getTopicTitle());
		}
		System.out.println("topics size"+topics.size());
		model.addAttribute("topics",topics);
		model.addAttribute("deletedThreads",threadService.dfSGetDeletedThreadList(loginUserId));
		return "redirect:deletedThreadList.html";
	}

	@RequestMapping(value = "/deletedThreadList", method = RequestMethod.GET)
	public String deletedThreadList(Model model/*, @ModelAttribute("user") UserBean userBean*/) {
		/*long userId = userBean.getUserId();
		int roleId = userBean.getRoleId();*/
		Map<Long,String> topics = new HashMap<Long,String>();
		List<DfTopic> allDeletedNonDeletedTopicList = topicService.dfSGetAllDeletedNonDeletedTopicList();
		for(DfTopic topic: allDeletedNonDeletedTopicList ){
			topics.put(topic.getTopicId(), topic.getTopicTitle());
		}

		List<DfThread> allDeletedThreadList = threadService.dfSGetAllDeletedThreadList();
		List<DfThread> finalDeletedThreadList = new ArrayList<DfThread>();
		List<DfTopic> topicListUserActAsModerator = topicService.dfSGetTopicList(loginUserId);
		List<DfModeratorAssigned> moderatorFor = moderatorAssignedService.dfSGetTopicUserActModerator(loginUserId);

		// if admin give all threads for approval
		// else check user is moderator for that threads topic?
		if(checkAdmin(loginUserId, roleId)){
			for(DfThread thread:allDeletedThreadList){
				finalDeletedThreadList.add(thread);
			}
		}else{
			if(!moderatorFor.isEmpty()){
				for(DfModeratorAssigned moderator: moderatorFor){
					topicListUserActAsModerator.add(topicService.dfSGetTopic(moderator.getTopicId()));
				}
			}

			for(DfThread thread:allDeletedThreadList){
				for(DfTopic top: topicListUserActAsModerator){
					if(top.getTopicId() == thread.getTopicId() || thread.getCreatedUserid() == loginUserId){
						finalDeletedThreadList.add(thread);
						break;
					}
				}
			}
		}
		model.addAttribute("topics",topics);
		model.addAttribute("deletedThreads",finalDeletedThreadList);
		return "deletedThreadList";
	}

	/******************************************* Thread Reply *************************************************/	

	Model prepareThreadReply(Model model, DfThreadReply reply){

		Map<Long,String> finalFileList = new HashMap<Long,String>();
		List<DfThreadReplyFileMap> fileList = threadReplyFileMapService.dfSGetThreadReplyFileMapList(reply.getReplyId());

		for(DfThreadReplyFileMap fileObj : fileList){
			String filePath = attachedFileService.dfSGetAttachedFile(fileObj.getFileId()).getFileLocation();
			File file = new File(filePath);
			if(file.exists())
				finalFileList.put(fileObj.getFileId(), attachedFileService.dfSGetAttachedFile(fileObj.getFileId()).getFileName());
		}
		model.addAttribute("newThreadReply",reply);
		model.addAttribute("threadReply",reply);
		model.addAttribute("fileList", finalFileList);
		return model;
	}
	@RequestMapping(value = "/editThreadReply", method = RequestMethod.GET)
	public String editReply(Model model, @RequestParam(value = "reply_id", required=false) Long reply_id) {
		if(reply_id == null)
			return "redirect:listTopic.html";
		model = prepareThreadReply(model, threadReplyService.dfSGetThreadReply(reply_id));
		return "editThreadReply";
	}

	@RequestMapping(value = "/editThreadReply", method = RequestMethod.POST)
	public String saveEditThreadReply(Model model, @ModelAttribute("threadReply")  @Validated DfThreadReply newThreadReply, 
			BindingResult result, @RequestParam(value = "file", required=false) List<MultipartFile> files,@RequestParam(value="checkBoxFile", required=false) List<Long> checkBox,RedirectAttributes redirectAttributes) {
		if(result.hasErrors()){
			model.addAttribute("alertMessage", "Reply update failed!");
			model.addAttribute("css", "danger");
			model = prepareThreadReply(model, newThreadReply);
			return "editThreadReply";
		}
		redirectAttributes.addFlashAttribute("alertMessage", "Reply updated");
		redirectAttributes.addFlashAttribute("css", "success");
		newThreadReply.setDeleteFlag(false);
		newThreadReply.setSubmittedTime(new java.sql.Timestamp(System.currentTimeMillis()));
		newThreadReply.setSubmittedUserid(loginUserId);
		newThreadReply.setThreadId(newThreadReply.getThreadId());
		threadReplyService.dfSAddThreadReply(newThreadReply);

		// Delete Files Start
		if(checkBox != null)
		{
			for(Long fileId:checkBox){
				System.out.println(fileId);
				threadReplyFileMapService.dfSRemoveThreadReplyFileMapList(fileId);
				//attachedFileService.df_s_removeAttachedFile(c);
			}
		}
		// Delete Files Start		

		File serverFile = null;
		Long UploadedFileId = 0L;

		if(files !=null){
			for(MultipartFile file : files){
				if (!file.isEmpty()) {
					try {
						byte[] bytes = file.getBytes();
						// Creating the directory to store file
						String rootPath = System.getProperty("catalina.home");
						// storePath Format: /plato/discussion_forum/thread_reply/<threadReplyId>/<loginUserId> 
						String storePath = File.separator + "plato"+File.separator+"discussion_forum"+File.separator+"thread_reply"+
								File.separator+newThreadReply.getReplyId()+File.separator+loginUserId;
						File dir = new File(rootPath + storePath);
						if (!dir.exists())
							dir.mkdirs();

						// Create the file on server
						serverFile = new File(dir.getAbsolutePath()	+ File.separator + file.getOriginalFilename());
						BufferedOutputStream stream = new BufferedOutputStream(	new FileOutputStream(serverFile));
						stream.write(bytes);
						stream.close();
						DfAttachedFile fileToSaveInDB = new DfAttachedFile();
						fileToSaveInDB.setFileLocation(serverFile.getAbsolutePath());
						fileToSaveInDB.setFileName(file.getOriginalFilename());
						fileToSaveInDB.setFileSize(file.getSize());
						UploadedFileId = attachedFileService.dfSAddAttachedFile(fileToSaveInDB);

						threadReplyFileMapService.dfSSetThreadReplyFileMapList( newThreadReply.getReplyId(), UploadedFileId );
						System.out.println("Server File Location="	+ serverFile.getAbsolutePath());

					} catch (Exception e) {
						return "You failed to upload " + file.getOriginalFilename() + " => " + e.getMessage();
					}
				}	
			}
		}

		List<DfThreadReply> trl =  threadReplyService.dfSGetThreadReplyList(newThreadReply.getThreadId());
		model.addAttribute("thread",  threadService.dfSGetThread(newThreadReply.getThreadId()));
		model.addAttribute("threadReplys",trl);
		model.addAttribute("newThreadReply", new DfThreadReply());		

		return "redirect:viewThread.html?thread_id="+newThreadReply.getThreadId();
	}

	@RequestMapping(value = "/deleteThreadReply", method = RequestMethod.GET)
	public String deleteThreadReply(Model model, @RequestParam Long reply_id) {
		Map<Long,String> topics = new HashMap<Long,String>();
		Long threadId = threadReplyService.dfSGetThreadReply(reply_id).getThreadId();
		threadReplyService.dfSDeleteThreadReply(reply_id);
		for(DfTopic topic: topicService.dfSGetAllTopicList()){
			topics.put(topic.getTopicId(), topic.getTopicTitle());
		}
		return "redirect:viewThread.html?thread_id="+threadId;
	}

	@RequestMapping(value = "/addThreadReply", method = RequestMethod.GET)
	public String addThreadReply(Model model, @ModelAttribute("threadReply") DfThreadReply threadReply){
		model = prepareViewThread(model, threadReply, threadReply.getThreadId());
		return "viewThread";
	}
	@RequestMapping(value = "/addThreadReply", method = RequestMethod.POST)
	public String saveThreadReply(Model model,@Valid @ModelAttribute("threadReply") DfThreadReply threadReply, 
			final BindingResult result, @RequestParam(value = "file", required=false) List<MultipartFile> files,RedirectAttributes redirectAttributes) {

		if(result.hasErrors()){
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.threadReply", result);
			redirectAttributes.addFlashAttribute("threadReply", threadReply);
			return "redirect:viewThread.html?thread_id="+threadReply.getThreadId();
		}
		redirectAttributes.addFlashAttribute("alertMessage", "New reply inserted");
		redirectAttributes.addFlashAttribute("css", "success");
		threadReply.setDeleteFlag(false);
		threadReply.setSubmittedTime(new java.sql.Timestamp(System.currentTimeMillis()));
		threadReply.setSubmittedUserid(loginUserId);
		threadReply.setThreadId(threadReply.getThreadId());
		threadReplyService.dfSAddThreadReply(threadReply);

		File serverFile = null;
		Long UploadedFileId = 0L;

		if(files !=null){
			for(MultipartFile file : files){
				if (!file.isEmpty()) {
					try {
						byte[] bytes = file.getBytes();

						// Creating the directory to store file
						String rootPath = System.getProperty("catalina.home");
						// storePath Format: /plato/discussion_forum/thread_reply/<threadReplyId>/<loginUserId> 
						String storePath = File.separator + "plato"+File.separator+"discussion_forum"+File.separator+"thread_reply"+
								File.separator+threadReply.getReplyId()+File.separator+loginUserId;
						File dir = new File(rootPath + storePath);
						if (!dir.exists())
							dir.mkdirs();

						// Create the file on server
						serverFile = new File(dir.getAbsolutePath()	+ File.separator + file.getOriginalFilename());
						BufferedOutputStream stream = new BufferedOutputStream(	new FileOutputStream(serverFile));
						stream.write(bytes);
						stream.close();
						DfAttachedFile fileToSaveInDB = new DfAttachedFile();
						fileToSaveInDB.setFileLocation(serverFile.getAbsolutePath());
						fileToSaveInDB.setFileName(file.getOriginalFilename());
						fileToSaveInDB.setFileSize(file.getSize());
						UploadedFileId = attachedFileService.dfSAddAttachedFile(fileToSaveInDB);

						threadReplyFileMapService.dfSSetThreadReplyFileMapList( threadReply.getReplyId(), UploadedFileId );
						System.out.println("Server File Location="	+ serverFile.getAbsolutePath());

					} catch (Exception e) {
						return "You failed to upload " + file.getOriginalFilename() + " => " + e.getMessage();
					}
				}	
			}
		}

		List<DfThreadReply> trl =  threadReplyService.dfSGetThreadReplyList(threadReply.getThreadId());
		model.addAttribute("thread",  threadService.dfSGetThread(threadReply.getThreadId()));
		model.addAttribute("threadReplys",trl);
		//model.addAttribute("newThreadReply", new DfThreadReply());		

		return "redirect:viewThread.html?thread_id="+threadReply.getThreadId();
	}

	/******************************************* Subscription *************************************************/

	@RequestMapping(value = "/subscribeThread", method = RequestMethod.GET)
	public String subscribeThread(Model model,@RequestParam Long thread_id, RedirectAttributes redirectAttributes) {
		threadSubscriptionService.dfSAddThreadSubscription(thread_id, loginUserId);
		redirectAttributes.addFlashAttribute("alertMessage", "Subscription successful");
		redirectAttributes.addFlashAttribute("css", "success");
		return "redirect:viewThread.html?thread_id="+thread_id;
	}

	@RequestMapping(value = "/unSubscribeThread", method = RequestMethod.GET)
	public String unSubscribeThread(Model model,@RequestParam Long thread_id,RedirectAttributes redirectAttributes) {
		threadSubscriptionService.dfSRemoveThreadSubscription(thread_id, loginUserId);
		redirectAttributes.addFlashAttribute("alertMessage", "UnSubscription successful");
		redirectAttributes.addFlashAttribute("css", "success");
		return "redirect:viewThread.html?thread_id="+thread_id;
	}

	/****************************************** Moderator *****************************************************/

	Model prepareAddModeratorModel(Model model, DfModeratorAssigned moderator){
		List<DfTopic> topicListUserActAsModerator = new ArrayList<DfTopic>();

		if(checkAdmin(loginUserId, roleId)){
			topicListUserActAsModerator = topicService.dfSGetAllTopicList();
		}else{
			topicListUserActAsModerator = topicService.dfSGetTopicList(loginUserId);	
			List<DfModeratorAssigned> moderatorFor = moderatorAssignedService.dfSGetTopicUserActModerator(loginUserId);

			if(!moderatorFor.isEmpty()){
				for(DfModeratorAssigned mod: moderatorFor){
					topicListUserActAsModerator.add(topicService.dfSGetTopic(mod.getTopicId()));
				}
			}
		}

		Map<Long,String> topicListMap = new HashMap<Long,String>();
		if(!topicListUserActAsModerator.isEmpty()){
			for(DfTopic topic: topicListUserActAsModerator){
				topicListMap.put(topic.getTopicId(), topic.getTopicTitle());
			}
		}
		model.addAttribute("moderator", moderator);
		model.addAttribute("usersList",usersListMap);
		model.addAttribute("topics", topicListMap);
		return model;
	}
	@RequestMapping(value = "/addModerator", method = RequestMethod.GET)
	public String addModerator(Model model) {
		model = prepareAddModeratorModel(model, new DfModeratorAssigned());
		return "addModerator";
	}

	@RequestMapping(value = "/addModerator", method = RequestMethod.POST)
	public String saveModerator(@Validated @ModelAttribute("moderator") DfModeratorAssigned moderator, BindingResult result,Model model,RedirectAttributes redirectAttributes) {	
		if(result.hasErrors()){
			model.addAttribute("alertMessage", "Add moderator failed!");
			model.addAttribute("css", "danger");
			model = prepareAddModeratorModel(model, moderator);
			return "addModerator";
		}
		// check already moderator
		if(moderatorAssignedService.dfSGetModerator(moderator.getAssignedToUserid(), moderator.getTopicId()) != null)
		{
			model.addAttribute("alertMessage", "Reassign is not allowed");
			model.addAttribute("css", "danger");
			model = prepareAddModeratorModel(model, moderator);
			return "addModerator";
		}

		redirectAttributes.addFlashAttribute("alertMessage", "New moderator assigned!");
		redirectAttributes.addFlashAttribute("css", "success");
		model.addAttribute("alert", "success");
		moderator.setAssignedByUserid(loginUserId);
		java.sql.Timestamp curTime = new java.sql.Timestamp(System.currentTimeMillis());
		moderator.setAssignedTime(curTime);

		moderatorAssignedService.dfSAddModerator(moderator);
		return "redirect:addModerator.html";
	}

	Model prepareRemoveModeratorModel(Model model, DfModeratorAssigned moderator){
		List<DfTopic> topicListUserActAsModerator = new ArrayList<DfTopic>();

		if(checkAdmin(loginUserId, roleId)){
			topicListUserActAsModerator = topicService.dfSGetAllTopicList();
		}else{
			topicListUserActAsModerator = topicService.dfSGetTopicList(loginUserId);
			List<DfModeratorAssigned> moderatorFor = moderatorAssignedService.dfSGetTopicUserActModerator(loginUserId);
			if(!moderatorFor.isEmpty()){
				for(DfModeratorAssigned mod: moderatorFor){
					topicListUserActAsModerator.add(topicService.dfSGetTopic(mod.getTopicId()));
				}
			}
		}
		Map<Long,String> topicListMap = new HashMap<Long,String>();
		if(!topicListUserActAsModerator.isEmpty()){
			for(DfTopic topic: topicListUserActAsModerator){
				topicListMap.put(topic.getTopicId(), topic.getTopicTitle());
			}
		}
		model.addAttribute("moderator", moderator);
		model.addAttribute("topics", topicListMap);
		return model;
	}

	@RequestMapping(value = "/removeModerator", method = RequestMethod.GET)
	public String removeModerator(Model model) {
		model = prepareRemoveModeratorModel(model, new DfModeratorAssigned());
		return "removeModerator";
	}

	@RequestMapping(value = "/removeModerator", method = RequestMethod.POST)
	public String saveRemoveModerator(@Validated @ModelAttribute("moderator") DfModeratorAssigned moderator, BindingResult result,Model model,RedirectAttributes redirectAttributes) {	

		if(result.hasErrors()){
			model.addAttribute("alertMessage", "Remove moderator failed!");
			model.addAttribute("css", "danger");
			model = prepareRemoveModeratorModel(model, moderator);
			return "removeModerator";
		}
		redirectAttributes.addFlashAttribute("alertMessage", "Moderator removed successfully!");
		redirectAttributes.addFlashAttribute("css", "success");
		model.addAttribute("alert", "success");

		DfModeratorAssigned moderatorToDelete = moderatorAssignedService.dfSGetModerator(moderator.getAssignedToUserid(),moderator.getTopicId());
		moderatorAssignedService.dfSRemoveModerator(moderatorToDelete);
		return "redirect:removeModerator.html";
	}
	@RequestMapping(value = "/getModeratorListToRemove", method = RequestMethod.GET)
	public String getModeratorListToRemove(@RequestParam Long topicId, Model model,RedirectAttributes redirectAttributes) {	
		List<DfModeratorAssigned> moderatorList = moderatorAssignedService.dfSGetModeratorObjList(topicId);
		Map<Long, String> usersList = new HashMap<Long, String>(); 
		// add moderators form moderator table
		if(moderatorList!=null){
			for(DfModeratorAssigned moderator : moderatorList){
				usersList.put(moderator.getAssignedToUserid(),moderator.getAssignedToUserid().toString());
			}
		}

		model.addAttribute("usersList", usersList);
		model.addAttribute("moderator", new DfModeratorAssigned());
		return "getModeratorListToRemove";
	}
	@RequestMapping(value = "/getModeratorListToRemove", method = RequestMethod.POST)
	public String getModeratorToRemove(@RequestParam Long topicId) {	
		return "redirect:getModeratorListToRemove.html?topicId="+topicId;
	}
	@RequestMapping(value = "downloadFile", method = RequestMethod.GET)
	public String doDownload(HttpServletRequest request, HttpServletResponse response, @RequestParam("file_id") Long file_id, 
			@RequestParam("thread_id") Long thread_id) throws IOException {
		final int BUFFER_SIZE = 4096;
		//String filePath = "/downloads/SpringProject.zip";

		DfAttachedFile fileAttched = attachedFileService.dfSGetAttachedFile(file_id);
		String filePath = fileAttched.getFileLocation();
		// get absolute path of the application
		ServletContext context = request.getServletContext();
		String appPath = context.getRealPath("");
		System.out.println("appPath = " + appPath);

		// construct the complete absolute path of the file
		//String fullPath = appPath + filePath;
		String fullPath =  filePath;
		File downloadFile = new File(fullPath);
		FileInputStream inputStream = new FileInputStream(downloadFile);

		// get MIME type of the file
		String mimeType = context.getMimeType(fullPath);
		if (mimeType == null) {
			// set to binary type if MIME mapping not found
			mimeType = "application/octet-stream";
		}
		System.out.println("MIME type: " + mimeType);

		// set content attributes for the response
		response.setContentType(mimeType);
		response.setContentLength((int) downloadFile.length());

		// set headers for the response
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"",
				downloadFile.getName());
		response.setHeader(headerKey, headerValue);

		// get output stream of the response
		OutputStream outStream = response.getOutputStream();

		byte[] buffer = new byte[BUFFER_SIZE];
		int bytesRead = -1;

		// write bytes read from the input stream into the output stream
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}

		inputStream.close();
		outStream.close();
		return "redirect:viewThread.html?thread_id="+thread_id;
	}
}