package cn.wyc.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Topic {
private Integer tid;
	
	private String title;			//����
	private String topicContent;	//����
	private String ipAddr;			//ip��ַ�����ߣ�
	private Date lastReplyDate;		//���ظ�ʱ��
	private Date createDate;		//����ʱ�䣨����ʱ�䣩
	
	
	//һ�Զࣺ һ������ ����ӵ�� ������ظ���
	private Set<Reply> replySet = new HashSet<Reply>();


	public Integer getTid() {
		return tid;
	}


	public void setTid(Integer tid) {
		this.tid = tid;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getIpAddr() {
		return ipAddr;
	}


	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}


	public Date getLastReplyDate() {
		return lastReplyDate;
	}


	public void setLastReplyDate(Date lastReplyDate) {
		this.lastReplyDate = lastReplyDate;
	}


	public String getTopicContent() {
		return topicContent;
	}


	public void setTopicContent(String topicContent) {
		this.topicContent = topicContent;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public Set<Reply> getReplySet() {
		return replySet;
	}


	public void setReplySet(Set<Reply> replySet) {
		this.replySet = replySet;
	}

	
}
