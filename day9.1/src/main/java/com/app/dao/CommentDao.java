package com.app.dao;

import com.app.entities.Category;
import com.app.entities.Comment;

public interface CommentDao {
	String addNewComment(Comment comment,Long CommenterId,Long postId);
	/*
	 * String deleteCategoryDetails(Long nextLong); Category
	 * getCategoryDetails(String categoryName); Category
	 * getCategoryAndPostDetails(String categoryName);
	 */
}
