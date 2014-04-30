package com.tester;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.test.dao.mapper.IUserMapper;
import com.test.domain.Article;

public class Test {
	private static SqlSessionFactory sqlSessionFactory;  
    
    private static Reader reader;
	public static void main(String[] args){
		try {  
            reader = Resources.getResourceAsReader("mybatis-config.xml");  
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);  
        } catch (IOException e) {  
        	System.out.println(e);
        } finally {  
            if (reader != null) {  
                try {  
                    reader.close();  
                } catch (IOException e) {  
                	System.out.println(e);
                }  
            }  
        }
		SqlSession session = sqlSessionFactory.openSession();  
        //User user = (User)session.selectOne("com.john.hbatis.model.UserMapper.getUserById", 1);  
        //System.out.println(user.getAge());
        
        IUserMapper mapper = session.getMapper(IUserMapper.class);
        
        
        
        List<Article> articles = mapper.getArticlesByUserId(1);  
        for (Article article : articles) {  
        	System.out.println(article.getId() );
        	System.out.println(article.getUser().getAddress() );      	
        	
        }  
        
	}
}

