package com.srmri.plato.core.discussionforum.controller;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

@Controller
public class CommonController {

	static Long loginUserId = 100L;	
	static List<Long> admin = new ArrayList<Long>();
	public CommonController(){
		admin.add(100L);
		admin.add(200L);
	}
	Boolean checkAdmin(Long userId){
		for(Long id : admin){
			if(id ==userId)
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

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model){
		return "index";
	}

	@RequestMapping(value = "/listTopic", method = RequestMethod.GET)
	public String topicList(Model model){

		List<DfTopic> allTopicList = topicService.df_s_getAllTopicList();
		Map<Long, Boolean> moderatorAllowMap = new HashMap<Long,Boolean>();

		if(checkAdmin(loginUserId)){
			for(DfTopic topic: allTopicList){
				moderatorAllowMap.put(topic.getTopicId(), true);
			}
		}
		else{
			for(DfTopic topic: allTopicList){
				List<Long> assignedModeratorList = moderatorAssignedService.df_s_getModeratorList(topic.getTopicId());
				if(!assignedModeratorList.isEmpty()){
					for(Long moderator:assignedModeratorList){
						if(moderator == loginUserId){
							System.out.println("getting moderators");
							moderatorAllowMap.put(topic.getTopicId(), true);
						}
						else
							moderatorAllowMap.put(topic.getTopicId(), false);
					}
				}
				else if(checkAdmin(loginUserId)){
					moderatorAllowMap.put(topic.getTopicId(), true);
				}
				else{
					moderatorAllowMap.put(topic.getTopicId(), false);
				}
			}
		}
		model.addAttribute("moderatorAllowMap", moderatorAllowMap);
		model.addAttribute("topics",  allTopicList);
		model.addAttribute("loginUserId",  loginUserId);
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
		java.sql.Timestamp curTime = new java.sql.Timestamp(System.currentTimeMillis());
		topic.setCreatedTime(curTime);
		topic.setCreatedUserid(loginUserId);
		topic.setDeletedFlag(false);
		topicService.df_s_insertTopic(topic);

		return "redirect:listTopic.html";
	}

	@RequestMapping(value = "/editTopic", method = RequestMethod.GET)
	public String editTopic(Model model, @RequestParam Long topic_id) {
		model.addAttribute("topic",topicService.df_s_getTopic(topic_id));
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
		redirectAttributes.addFlashAttribute("alertMessage", "Topic Updated");
		redirectAttributes.addFlashAttribute("css", "success");
		java.sql.Timestamp curTime = new java.sql.Timestamp(System.currentTimeMillis());
		topic.setCreatedTime(curTime);
		topic.setCreatedUserid(loginUserId);
		topic.setDeletedFlag(false);
		topicService.df_s_insertTopic(topic);

		return "redirect:listTopic.html";
	}

	@RequestMapping(value = "/deleteTopic", method = RequestMethod.GET)
	public String deleteTopic(Model model, @RequestParam Long topic_id) {
		topicService.df_s_deleteTopic(topic_id);
		return "redirect:listTopic.html";
	}

	@RequestMapping(value = "/saveDeletedTopic", method = RequestMethod.GET)
	public String saveApproveTopic(Model model, @RequestParam Long topic_id) {
		topicService.df_s_approveTopic(topic_id);
		model.addAttribute("deletedTopics",topicService.df_s_getDeletedTopic(loginUserId));
		return "redirect:deletedTopic.html";
	}

	@RequestMapping(value = "/deletedTopic", method = RequestMethod.GET)
	public String approveTopic(Model model) {
		model.addAttribute("deletedTopics",topicService.df_s_getDeletedTopic(loginUserId));
		List<DfTopic> allDeletedTopicList = topicService.df_s_getAllDeletedTopic();
		List<DfModeratorAssigned> moderatorAssignedFor = moderatorAssignedService.df_s_getTopicUserActModerator(loginUserId);
		List<DfTopic> deletedTopicsList = new ArrayList<DfTopic>();

		if(checkAdmin(loginUserId)){
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
	/************************************** THREAD **************************************************/

	@RequestMapping(value = "/listThreadTopic", method = RequestMethod.GET)
	public String listThread(Model model, @RequestParam Long topic_id) {

		Map<Long,String> topics = new HashMap<Long,String>();
		List<DfThread>  finalThredList = new ArrayList<DfThread>();
		finalThredList = threadService.df_s_getTopicThreads(topic_id);
		for(DfTopic topicIt: topicService.df_s_getAllTopicList()){
			topics.put(topicIt.getTopicId(), topicIt.getTopicTitle());
		}

		Map<Long, Boolean> moderatorAllowMap = new HashMap<Long,Boolean>();
		List<Long> assignedModeratorList = moderatorAssignedService.df_s_getModeratorList(topic_id);
		if(!finalThredList.isEmpty()){
			for(DfThread thread : finalThredList){

				if(checkAdmin(loginUserId)){
					moderatorAllowMap.put(thread.getThreadId(), true);
				}
				else if(loginUserId == thread.getCreatedUserid()){
					moderatorAllowMap.put(thread.getThreadId(), true);
				}
				else if(loginUserId == topicService.df_s_getTopic(topic_id).getCreatedUserid())
				{
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

		model.addAttribute("moderatorAllowMap", moderatorAllowMap);
		model.addAttribute("threads",  finalThredList);
		model.addAttribute("topics",topics);
		model.addAttribute("loginUserId",loginUserId);
		return "listThread";
	}

	@RequestMapping(value = "/addThread", method = RequestMethod.GET)
	public String addThread(@ModelAttribute("thread") DfThread thread, Model model) {	    

		model = prepareAddThreadModel(model, thread);
		return "addThread";
	}

	Model prepareAddThreadModel(Model model, DfThread thread ){
		Map<Long,String> topics = new HashMap<Long,String>();

		for(DfTopic topic: topicService.df_s_getAllTopicList()){
			topics.put(topic.getTopicId(), topic.getTopicTitle());
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
			model = prepareAddThreadModel(model, thread);
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
		threadService.df_s_addThread(thread);
		threadSubscriptionService.df_s_addThreadSubscription(thread.getThreadId(), loginUserId);

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
						UploadedFileId = attachedFileService.df_s_addAttachedFile(fileToSaveInDB);

						threadFileMapService.df_s_addThreadFileMap(thread.getThreadId(), UploadedFileId);
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
		List<Long> attachedFileIdList = threadFileMapService.df_s_getFileList(thread.getThreadId());
		Map<Long, String> finalFileListMap = new HashMap<Long,String>();
		if(!attachedFileIdList.isEmpty()){
			for(Long fileId : attachedFileIdList){
				String filePath = attachedFileService.df_s_getAttachedFile(fileId).getFileLocation();
				File file = new File(filePath);
				if(file.exists())
					finalFileListMap.put(fileId, attachedFileService.df_s_getAttachedFile(fileId).getFileName());
			}
		}

		model.addAttribute("finalFileListMap",finalFileListMap);
		model.addAttribute("thread",thread);
		return model;
	}

	@RequestMapping(value = "/editThread", method = RequestMethod.GET)
	public String editThread(Model model, @RequestParam Long thread_id,HttpServletRequest request) {
		model = prepareEditThreadModel(model, threadService.df_s_getThread(thread_id));
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
				threadFileMapService.df_s_removeThreadFileMap(c);
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
						UploadedFileId = attachedFileService.df_s_addAttachedFile(fileToSaveInDB);

						threadFileMapService.df_s_addThreadFileMap(thread.getThreadId(), UploadedFileId);
						System.out.println("Server File Location="	+ serverFile.getAbsolutePath());

					} catch (Exception e) {
						return "You failed to upload " + file.getOriginalFilename() + " => " + e.getMessage();
					}
				}	
			}
		}


		System.out.println(thread.getThreadTitle()+thread.getThreadId());
		java.sql.Timestamp curTime = new java.sql.Timestamp(System.currentTimeMillis());
		thread.setCreatedTime(threadService.df_s_getThread(thread.getThreadId()).getCreatedTime());
		thread.setModifiedTime(curTime);
		thread.setCreatedUserid(loginUserId);
		thread.setDeletedFlag(false);
		thread.setApproved(true);
		threadService.df_s_addThread(thread);

		String sourcePage = request.getParameter("edit");
		if(sourcePage == "approveThread")
			return "redirect:approveThread.html";
		if(sourcePage == "viewThread")
			return "redirect:viewThread.html?thread_id="+thread.getThreadId();
		else
			return "redirect:listThreadTopic.html?topic_id="+thread.getTopicId();
	}
	Model prepareViewThread(Model model,DfThreadReply threadReply, Long thread_id){
		List<Long> threadFileList = threadFileMapService.df_s_getFileList(thread_id);
		Map<Long,String> finalThreadFileListMap = new HashMap<Long,String>();

		if(!threadFileList.isEmpty())
		{
			for(Long attachedFileId: threadFileList){
				String filePath = attachedFileService.df_s_getAttachedFile(attachedFileId).getFileLocation();
				File file = new File(filePath);
				if(file.exists())
					finalThreadFileListMap.put(attachedFileId,file.getName());
			}
		}

		model.addAttribute("finalThreadFileListMap", finalThreadFileListMap);
		List<DfThreadReply> threadReplysList = threadReplyService.df_s_getThreadReplyList(thread_id);
		Map<DfThreadReply,Map<Long,String>> finalThreadReplyList = new HashMap<DfThreadReply,Map<Long,String>>();
		DfThread thread = threadService.df_s_getThread(thread_id);
		Boolean threadEditAllowed = false;
		List<Long> assignedModeratorList = moderatorAssignedService.df_s_getModeratorList(thread.getTopicId());

		// Role check Start
		if(checkAdmin(loginUserId)){
			threadEditAllowed =  true;
		}
		else if(loginUserId == thread.getCreatedUserid()){
			threadEditAllowed =  true;
		}
		else if(loginUserId == topicService.df_s_getTopic(thread.getTopicId()).getCreatedUserid())
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

		if(checkAdmin(loginUserId)){
			model.addAttribute("admin", true);
		}
		else
			model.addAttribute("admin", false);
		// Role check End

		if(!threadReplysList.isEmpty()){
			for(DfThreadReply reply: threadReplysList){
				List<Long> attachedFilesList  = threadReplyFileMapService.df_s_getFileList(reply.getReplyId());

				if(attachedFilesList.isEmpty())
				{
					finalThreadReplyList.put(reply, null);
					continue;
				}else{
					Map<Long,String> fileList = new HashMap<Long,String>();
					for(Long attachedFileId: attachedFilesList){
						String filePath = attachedFileService.df_s_getAttachedFile(attachedFileId).getFileLocation();
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
		model.addAttribute("thread",  threadService.df_s_getThread(thread_id));
		model.addAttribute("threadReplys",finalThreadReplyList);
		model.addAttribute("threadReply", threadReply);
		model.addAttribute("loginUserId",loginUserId);
		model.addAttribute("topicUserId",topicService.df_s_getTopic(threadService.df_s_getThread(thread_id).getTopicId()).getCreatedUserid());
		model.addAttribute("checkSubscribe", threadSubscriptionService.df_s_isSubscribed(thread_id,loginUserId));
		return model;
	}
	@RequestMapping(value = "/viewThread", method = RequestMethod.GET)
	public String viewThread(Model model, @RequestParam Long thread_id) {
		//model = prepareViewThread(model,threadReply,thread_id);
		List<Long> threadFileList = threadFileMapService.df_s_getFileList(thread_id);
		Map<Long,String> finalThreadFileListMap = new HashMap<Long,String>();

		if(!threadFileList.isEmpty())
		{
			for(Long attachedFileId: threadFileList){
				String filePath = attachedFileService.df_s_getAttachedFile(attachedFileId).getFileLocation();
				File file = new File(filePath);
				if(file.exists())
					finalThreadFileListMap.put(attachedFileId,file.getName());
			}
		}

		model.addAttribute("finalThreadFileListMap", finalThreadFileListMap);
		List<DfThreadReply> threadReplysList = threadReplyService.df_s_getThreadReplyList(thread_id);
		Map<DfThreadReply,Map<Long,String>> finalThreadReplyList = new HashMap<DfThreadReply,Map<Long,String>>();
		DfThread thread = threadService.df_s_getThread(thread_id);
		Boolean threadEditAllowed = false;
		List<Long> assignedModeratorList = moderatorAssignedService.df_s_getModeratorList(thread.getTopicId());

		// Role check Start
		if(checkAdmin(loginUserId)){
			threadEditAllowed =  true;
		}
		else if(loginUserId == thread.getCreatedUserid()){
			threadEditAllowed =  true;
		}
		else if(loginUserId == topicService.df_s_getTopic(thread.getTopicId()).getCreatedUserid())
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

		if(checkAdmin(loginUserId)){
			model.addAttribute("admin", true);
		}
		else
			model.addAttribute("admin", false);
		// Role check End

		if(!threadReplysList.isEmpty()){
			for(DfThreadReply reply: threadReplysList){
				List<Long> attachedFilesList  = threadReplyFileMapService.df_s_getFileList(reply.getReplyId());

				if(attachedFilesList.isEmpty())
				{
					finalThreadReplyList.put(reply, null);
					continue;
				}else{
					Map<Long,String> fileList = new HashMap<Long,String>();
					for(Long attachedFileId: attachedFilesList){
						String filePath = attachedFileService.df_s_getAttachedFile(attachedFileId).getFileLocation();
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
		model.addAttribute("thread",  threadService.df_s_getThread(thread_id));
		model.addAttribute("threadReplys",finalThreadReplyList);
		if(!model.containsAttribute("threadReply")){
			model.addAttribute("threadReply", new DfThreadReply());
		}
		model.addAttribute("loginUserId",loginUserId);
		model.addAttribute("topicUserId",topicService.df_s_getTopic(threadService.df_s_getThread(thread_id).getTopicId()).getCreatedUserid());
		model.addAttribute("checkSubscribe", threadSubscriptionService.df_s_isSubscribed(thread_id,loginUserId));
		return "viewThread";
	}

	@RequestMapping(value = "/deleteThread", method = RequestMethod.GET)
	public String deleteThread(Model model, @RequestParam Long thread_id,@RequestParam(value="frmAprThr") int flag) {

		Long topic_id = threadService.df_s_getThread(thread_id).getTopicId();
		threadService.df_s_deleteThread(thread_id);

		if(flag == 1)
			return "redirect:approveThread.html";
		else
			return "redirect:listThreadTopic.html?topic_id="+topic_id;
	}

	@RequestMapping(value = "/saveApproveThread", method = RequestMethod.GET)
	public String saveApproveThread(Model model, @RequestParam Long thread_id) {
		threadService.df_s_approveThread(thread_id, true);
		return "redirect:approveThread.html";
	}

	@RequestMapping(value = "/approveThread", method = RequestMethod.GET)
	public String approveThread(Model model) {
		Map<Long,String> topics = new HashMap<Long,String>();

		for(DfTopic topic: topicService.df_s_getAllTopicList()){
			topics.put(topic.getTopicId(), topic.getTopicTitle());
		}
		List<DfThread> finalApprovalList = new ArrayList<DfThread>();
		List<DfThread> threadListForApproval = threadService.df_s_getAllUnApprovedThreadList();
		List<DfTopic> topicList = topicService.df_s_getTopicList(loginUserId);
		List<DfModeratorAssigned> moderatorFor = moderatorAssignedService.df_s_getTopicUserActModerator(loginUserId);

		// if admin give all threads for approval
		// else check user is moderator for that threads topic?
		if(checkAdmin(loginUserId)){
			for(DfThread thread:threadListForApproval){
				finalApprovalList.add(thread);	
			}
		}else{

			if(!moderatorFor.isEmpty()){
				for(DfModeratorAssigned moderator: moderatorFor){
					topicList.add(topicService.df_s_getTopic(moderator.getTopicId()));
				}
			}
			for(DfThread thread:threadListForApproval){
				for(DfTopic top: topicList){
					if(top.getTopicId() == thread.getTopicId())
						finalApprovalList.add(thread);	
				}
			}
		}
		model.addAttribute("topics",topics);
		model.addAttribute("deletedThreads",finalApprovalList);
		return "approveThread";
	}

	@RequestMapping(value = "/saveUndoDeletedThread", method = RequestMethod.GET)
	public String saveUndoDeletedThread(Model model, @RequestParam Long thread_id) {
		threadService.df_s_undoDeletedThread(thread_id);
		Map<Long,String> topics = new HashMap<Long,String>();

		for(DfTopic topic: topicService.df_s_getAllTopicList()){
			topics.put(topic.getTopicId(), topic.getTopicTitle());
		}
		System.out.println("topics size"+topics.size());
		model.addAttribute("topics",topics);
		model.addAttribute("deletedThreads",threadService.df_s_getDeletedThreadList(loginUserId));
		return "redirect:deletedThreadList.html";
	}

	@RequestMapping(value = "/deletedThreadList", method = RequestMethod.GET)
	public String deletedThreadList(Model model) {
		Map<Long,String> topics = new HashMap<Long,String>();
		List<DfTopic> allDeletedNonDeletedTopicList = topicService.df_s_getAllDeletedNonDeletedTopicList();
		for(DfTopic topic: allDeletedNonDeletedTopicList ){
			topics.put(topic.getTopicId(), topic.getTopicTitle());
		}

		List<DfThread> allDeletedThreadList = threadService.df_s_getAllDeletedThreadList();
		List<DfThread> finalDeletedThreadList = new ArrayList<DfThread>();
		List<DfTopic> topicListUserActAsModerator = topicService.df_s_getTopicList(loginUserId);
		List<DfModeratorAssigned> moderatorFor = moderatorAssignedService.df_s_getTopicUserActModerator(loginUserId);

		// if admin give all threads for approval
		// else check user is moderator for that threads topic?
		if(checkAdmin(loginUserId)){
			for(DfThread thread:allDeletedThreadList){
				finalDeletedThreadList.add(thread);
			}
		}else{
			if(!moderatorFor.isEmpty()){
				for(DfModeratorAssigned moderator: moderatorFor){
					topicListUserActAsModerator.add(topicService.df_s_getTopic(moderator.getTopicId()));
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
		List<DfThreadReplyFileMap> fileList = threadReplyFileMapService.df_s_getThreadReplyFileMapList(reply.getReplyId());

		for(DfThreadReplyFileMap fileObj : fileList){
			String filePath = attachedFileService.df_s_getAttachedFile(fileObj.getFileId()).getFileLocation();
			File file = new File(filePath);
			if(file.exists())
				finalFileList.put(fileObj.getFileId(), attachedFileService.df_s_getAttachedFile(fileObj.getFileId()).getFileName());
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
		model = prepareThreadReply(model, threadReplyService.df_s_getThreadReply(reply_id));
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
		threadReplyService.df_s_addThreadReply(newThreadReply);

		// Delete Files Start
		if(checkBox != null)
		{
			for(Long fileId:checkBox){
				System.out.println(fileId);
				threadReplyFileMapService.df_s_removeThreadReplyFileMapList(fileId);
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
						UploadedFileId = attachedFileService.df_s_addAttachedFile(fileToSaveInDB);

						threadReplyFileMapService.df_s_setThreadReplyFileMapList( newThreadReply.getReplyId(), UploadedFileId );
						System.out.println("Server File Location="	+ serverFile.getAbsolutePath());

					} catch (Exception e) {
						return "You failed to upload " + file.getOriginalFilename() + " => " + e.getMessage();
					}
				}	
			}
		}

		List<DfThreadReply> trl =  threadReplyService.df_s_getThreadReplyList(newThreadReply.getThreadId());
		model.addAttribute("thread",  threadService.df_s_getThread(newThreadReply.getThreadId()));
		model.addAttribute("threadReplys",trl);
		model.addAttribute("newThreadReply", new DfThreadReply());		

		return "redirect:viewThread.html?thread_id="+newThreadReply.getThreadId();
	}

	@RequestMapping(value = "/deleteThreadReply", method = RequestMethod.GET)
	public String deleteThreadReply(Model model, @RequestParam Long reply_id) {
		Map<Long,String> topics = new HashMap<Long,String>();
		Long threadId = threadReplyService.df_s_getThreadReply(reply_id).getThreadId();
		threadReplyService.df_s_deleteThreadReply(reply_id);
		for(DfTopic topic: topicService.df_s_getAllTopicList()){
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
		threadReplyService.df_s_addThreadReply(threadReply);

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
						UploadedFileId = attachedFileService.df_s_addAttachedFile(fileToSaveInDB);

						threadReplyFileMapService.df_s_setThreadReplyFileMapList( threadReply.getReplyId(), UploadedFileId );
						System.out.println("Server File Location="	+ serverFile.getAbsolutePath());

					} catch (Exception e) {
						return "You failed to upload " + file.getOriginalFilename() + " => " + e.getMessage();
					}
				}	
			}
		}

		List<DfThreadReply> trl =  threadReplyService.df_s_getThreadReplyList(threadReply.getThreadId());
		model.addAttribute("thread",  threadService.df_s_getThread(threadReply.getThreadId()));
		model.addAttribute("threadReplys",trl);
		//model.addAttribute("newThreadReply", new DfThreadReply());		

		return "redirect:viewThread.html?thread_id="+threadReply.getThreadId();
	}

	/******************************************* Subscription *************************************************/

	@RequestMapping(value = "/subscribeThread", method = RequestMethod.GET)
	public String subscribeThread(Model model,@RequestParam Long thread_id, RedirectAttributes redirectAttributes) {
		threadSubscriptionService.df_s_addThreadSubscription(thread_id, loginUserId);
		redirectAttributes.addFlashAttribute("alertMessage", "Subscription successful");
		redirectAttributes.addFlashAttribute("css", "success");
		return "redirect:viewThread.html?thread_id="+thread_id;
	}

	@RequestMapping(value = "/unSubscribeThread", method = RequestMethod.GET)
	public String unSubscribeThread(Model model,@RequestParam Long thread_id,RedirectAttributes redirectAttributes) {
		threadSubscriptionService.df_s_removeThreadSubscription(thread_id, loginUserId);
		redirectAttributes.addFlashAttribute("alertMessage", "UnSubscription successful");
		redirectAttributes.addFlashAttribute("css", "success");
		return "redirect:viewThread.html?thread_id="+thread_id;
	}

	/****************************************** Moderator *****************************************************/

	Model prepareAddModeratorModel(Model model, DfModeratorAssigned moderator){
		List<DfTopic> topicListUserActAsModerator = topicService.df_s_getTopicList(loginUserId);

		if(topicListUserActAsModerator.isEmpty()){
			List<DfModeratorAssigned> moderatorFor = moderatorAssignedService.df_s_getTopicUserActModerator(loginUserId);

			if(!moderatorFor.isEmpty()){
				for(DfModeratorAssigned mod: moderatorFor){
					topicListUserActAsModerator.add(topicService.df_s_getTopic(mod.getTopicId()));
				}
			}
		}

		Map<Long,String> usersListMap = new HashMap<Long,String>();
		usersListMap.put(11L, "Rupesh");
		usersListMap.put(15L, "Hitesh");
		usersListMap.put(16L, "Bhupendra");
		usersListMap.put(17L, "Sagar");
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
		redirectAttributes.addFlashAttribute("alertMessage", "New moderator assigned!");
		redirectAttributes.addFlashAttribute("css", "success");
		model.addAttribute("alert", "success");
		moderator.setAssignedByUserid(loginUserId);
		System.out.println("assigned by"+ moderator.getAssignedByUserid());
		System.out.println("assigned to "+ moderator.getAssignedToUserid());
		java.sql.Timestamp curTime = new java.sql.Timestamp(System.currentTimeMillis());
		moderator.setAssignedTime(curTime);

		moderatorAssignedService.df_s_addModerator(moderator);
		return "redirect:addModerator.html";
	}

	@RequestMapping(value = "downloadFile", method = RequestMethod.GET)
	public String doDownload(HttpServletRequest request, HttpServletResponse response, @RequestParam("file_id") Long file_id, 
			@RequestParam("thread_id") Long thread_id) throws IOException {
		final int BUFFER_SIZE = 4096;
		//String filePath = "/downloads/SpringProject.zip";

		DfAttachedFile fileAttched = attachedFileService.df_s_getAttachedFile(file_id);
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