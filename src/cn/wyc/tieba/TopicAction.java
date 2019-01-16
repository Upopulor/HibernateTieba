package cn.wyc.tieba;

import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.wyc.bean.Topic;
import cn.wyc.dao.TopicDaoImpl;
import cn.wyc.dao.topicDao;

public class TopicAction extends ActionSupport{
	private Topic topic;
	private String key;
	private topicDao td = new TopicDaoImpl();
	public String list() {
		List<Topic> list = td.getAll(key);
		ActionContext.getContext().put("list", list);
		return "list";
	}
	public String add() {
		//ip
		topic.setIpAddr(ServletActionContext.getRequest().getRemoteAddr());
		//创建回帖时间
		topic.setCreateDate(new Date());
		topic.setLastReplyDate(topic.getCreateDate());
		td.save(topic);
		return "tolist";
	}
	
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
}
