package cn.wyc.Utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	// 会话工厂，整个程序只有一份。
	private static SessionFactory sf;

	static{
		//1 加载配置
		Configuration config = new Configuration().configure();
		
		//2 获得工厂
		sf = config.buildSessionFactory();
	}
	/**
	 * 获得一个新的session
	 * @return
	 */
	public static Session openSession(){
		return sf.openSession();
	}
	
	/**
	 * 获得当前线程中绑定session
	 * * 注意：必须配置
	 * @return
	 */
	public static Session getCurrentSession(){
		return sf.getCurrentSession();
	}
	public static void main(String[] args) {
		System.out.println(openSession());
	}
	
}
