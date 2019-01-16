package cn.wyc.tieba;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.hibernate.Session;

import cn.wyc.Utils.HibernateUtils;

/**
 * Servlet Filter implementation class TransFilter
 */
public class TransFilter implements Filter {
    public TransFilter() {
        // TODO Auto-generated constructor stub
    }
	public void destroy() {
		// TODO Auto-generated method stub
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		Session session = HibernateUtils.getCurrentSession();
		
		try {
			session.beginTransaction();
			chain.doFilter(request, response);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			if(session!=null && session.isOpen()) {
				session.getTransaction().rollback();
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
