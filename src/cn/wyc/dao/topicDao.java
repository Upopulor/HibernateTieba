package cn.wyc.dao;

import java.util.List;

import cn.wyc.bean.Topic;

public interface topicDao {
	//��������
	void save(Topic t);
	//����������ѯ�����б�
	List<Topic> getAll(String key);
}
