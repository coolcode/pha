package com.meecat.doctorapp.restcontroller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.meecat.doctorapp.domain.*;
import com.meecat.doctorapp.service.*;

@RestController()
@Transactional
@RequestMapping("/api/forum")
public class ForumRestController {

	@Autowired
	private UserService userService;

	@Autowired
	private ForumService forumService;
	
	@GetMapping("/posts")
	public List<Post> getPosts() {
		return forumService.listPosts();
	}

	@PostMapping("/post")
	public Post savePost(@RequestBody Post post) {
		post.setCreateUser(userService.getCurrentUser());
		forumService.savePost(post);
		return post;
	}

	@DeleteMapping("/post/{id}")
	public void deletePost(@PathVariable("id") int id) {
		forumService.deletePost(id); 
	}	


	@GetMapping("/post/{postId}/comments")
	public List<Comment> getComments(@PathVariable("postId") int postId) {
		return forumService.listComments(postId);
	}
	
	@PostMapping("/post/{postId}/comment")
	public Comment saveComment(@PathVariable("postId") int postId, @RequestBody Comment comment) {
		comment.setPost(forumService.getPost(postId));
		comment.setCreateUser(userService.getCurrentUser());
		forumService.saveComment(comment);
		
		return comment;
	}	

	@DeleteMapping("/comment/{id}")
	public void deleteComment(@PathVariable("id") int id) {
		forumService.deleteComment(id); 
	}	
	

	@GetMapping("/post/top/{n}")
	public List<Post> getPosts(@PathVariable("n") int n) {
		return forumService.listPosts(n);
	}
}
