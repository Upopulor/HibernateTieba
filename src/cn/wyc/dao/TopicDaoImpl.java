package cn.wyc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import cn.wyc.Utils.HibernateUtils;
import cn.wyc.bean.Topic;

public class TopicDaoImpl implements topicDao{

	@Override
	public void save(Topic t) {
		Session session = HibernateUtils.getCurrentSession();
		session.save(t);		
	}

	@Override
	public List<Topic> getAll(String key) {
		//1���session
		Session session = HibernateUtils.getCurrentSession();
		//2���query����
		Query query = session.createQuery("from Topic where title like :key");
		if(key != null && !("".equals(key.trim()))) {
			query.setString("key", "%"+key+"%");
		}else {
			query.setString("key", "%");//ÿ��������ѯ����
		}
		
		return query.list();
	}

}
