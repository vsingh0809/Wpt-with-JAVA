package com.app.dao;

import static com.app.utils.HibernateUtils.getFactory;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entities.Post;

public class postDaoImp implements postDao {

	@Override
	public String CreatePost(Post post) {
		String msg="post creation failed";
		Session session = getFactory().getCurrentSession();
		 
	     Transaction tx=session.beginTransaction();
	     System.out.println("session is open " + session.isOpen() + " is conncted " + session.isConnected());
	     try {
	    	 System.out.println("hhhhhh");
	    	 Serializable postId = session.save(post);
	    	 System.out.println("Id class " + postId.getClass());
			tx.commit();
			msg = "User registered successfully , with ID =  " + postId;
		} catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		
		
		
		return msg;
	}

}
