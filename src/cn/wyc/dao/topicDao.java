package cn.wyc.dao;

import java.util.List;

import cn.wyc.bean.Topic;

public interface topicDao {
	//保存帖子
	void save(Topic t);
	//根据条件查询帖子列表
	List<Topic> getAll(String key);
}
