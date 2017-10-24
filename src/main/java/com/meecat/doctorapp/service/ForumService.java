package com.meecat.doctorapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meecat.doctorapp.dao.*;
import com.meecat.doctorapp.domain.*;

@Service 
public class ForumService { 

	@Autowired
	private PostDao postDao;	

	@Autowired
	private CommentDao commentDao;

	public List<Post> listPosts() { 
		return postDao.list();
	}
	
	public Post savePost(Post post) {
		postDao.save(post);
		return post;
	}

	public Post getPost(int postId) {
		return postDao.get(postId); 
	}
	
	public void deletePost(int postId) {
		postDao.delete(postId); 
	}

	public List<Comment> listComments(int postId) { 
		return commentDao.list(postId);
	}
	
	public Comment saveComment(Comment comment) {
		commentDao.save(comment);
		return comment;
	}

	public void deleteComment(int commentId) {
		commentDao.delete(commentId); 
	}

	public List<Post> listPosts(int n) { 
		return postDao.list(n);
	}
	
}