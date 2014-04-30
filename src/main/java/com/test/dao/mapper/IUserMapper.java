package com.test.dao.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.test.domain.Article;
import com.test.domain.User;

@Component
public interface IUserMapper {
	User getUserById(int Id);
	
	List<User> getUsers(String name);
	
	int addUser(User user);
	
	int updateUser(User user); 
	
	int deleteUser(int id);
	
	List<Article> getArticlesByUserId(int id); 

}
