package com.dao;

import java.util.List;

import com.model.BlogComment;
import com.model.BlogPost;
import com.model.PROJ2_USER;

public interface BlogDao {
	List<BlogPost> getBlogPosts();
	BlogPost getBlogPost(int id);
	BlogPost addBlogPost(PROJ2_USER user,BlogPost blogPost);
	List<BlogComment> getComments(int blogId);
	BlogPost addBlogComment(PROJ2_USER user,BlogComment Comment);
	
	BlogPost updateBlog(int id,BlogPost blogPost);
	void deleteBlog(int id);
}
