package com.app.dao;

import static com.app.utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entities.BlogPost;
import com.app.entities.Category;
import com.app.entities.Comment;
import com.app.entities.User;

public  class CommentDaoImpl2 implements CommentDao {

	public String addNewComment(Comment comment,Long CommenterId,Long postId){
	 {
		String mesg = "adding category failed";
		// 1. get session from SF (getCurrentSession)
		Session session = getFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			User user = session.get(User.class, CommenterId);
			// 2 . get author from it's id
			 BlogPost  post= session.get(BlogPost.class, postId);
			 if(user !=null&&post!=null)
			 {
			comment.setCommenter(user);
			comment.setPost(post);
session.persist(comment);				 
			 }
			
			tx.commit();
		
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exc to the caller
			throw e;
		}
		return mesg;
	
	 }}}
	 