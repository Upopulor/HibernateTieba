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
		//1获得session
		Session session = HibernateUtils.getCurrentSession();
		//2获得query对象
		Query query = session.createQuery("from Topic where title like :key");
		if(key != null && !("".equals(key.trim()))) {
			query.setString("key", "%"+key+"%");
		}else {
			query.setString("key", "%");//每传条件查询所有
		}
		
		return query.list();
	}

}
