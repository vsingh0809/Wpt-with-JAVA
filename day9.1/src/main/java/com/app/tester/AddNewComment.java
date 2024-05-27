package com.app.tester;

import static com.app.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.app.dao.CategoryDao;
import com.app.dao.CategoryDaoImpl;
import com.app.dao.CommentDao;
import com.app.dao.CommentDaoImpl2;
import com.app.entities.Category;
import com.app.entities.Comment;

public class AddNewComment {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			// create category dao instance
		CommentDao dao= new CommentDaoImpl2() ;
		dao.addNewComment(new Comment(sc.next(),sc.nextInt()), sc.nextLong(), sc.nextLong());
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
