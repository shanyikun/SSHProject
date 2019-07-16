package com.ssh.syk.dao;


import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.ssh.syk.entity.UserEntity;

@Repository("userDao")
public class UserDao {
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
	@SuppressWarnings({ "rawtypes" })
	public String register(String name, String password) {
		Session session = sessionFactory.openSession();
		Object isExit;
		String hql = "from UserrEntity where name=:name";
		Query query = session.createQuery(hql);
		query.setParameter("name", name);
		isExit = query.uniqueResult();
		if(isExit==null) {
			UserEntity userEntity = new UserEntity(name, password);
			Integer id = (Integer) session.save(userEntity);
			return "register success! id is "+id;
		}
		else {
			return "user has exits!";
		}
	}
}
