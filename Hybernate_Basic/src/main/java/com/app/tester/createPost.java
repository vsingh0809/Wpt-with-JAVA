package com.app.tester;

import static com.app.utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.app.dao.UserDao;
import com.app.dao.UserDaoImpl;
import com.app.dao.postDao;
import com.app.dao.postDaoImp;
import com.app.entities.Post;
import com.app.entities.Role;
import com.app.entities.User;
import static java.time.LocalDate.parse;
import static com.app.entities.Role.valueOf;

public class createPost {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory();
				Scanner sc = new Scanner(System.in)) {
			//create user dao instance
			postDao PostDao=new postDaoImp();
			System.out
					.println("Enter user details - String content, String description, String imagePath, String title");
			Post transientPost = new Post(sc.next(), sc.next(), sc.next(), sc.next());
		PostDao.CreatePost(transientPost);
		} // JVM sf.close() => cleaning up of DBCP
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
