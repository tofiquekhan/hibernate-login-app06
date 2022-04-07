package myproject.loginapp.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import myproject.loginapp.pojo.User;
import myproject.loginapp.util.HibernateUtil;

public class UserServiceImpl implements UserService {

	@Override
	public String checkLogin(String uname, String upwd) {
		String status = "";
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session  = sessionFactory.openSession();
			User user = (User) session.get(User.class, uname);
			if(user==null) {
				status = "failure";
			}else {
			if(user.getUpwd().equals(upwd)) {
				status = "success";
			}else {
				status = "failure";
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
