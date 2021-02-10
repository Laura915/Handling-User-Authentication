package com.hcl.loginproject2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class AuthenticationTests {
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private UserRepository userRepo;
	
	
	 @Test
	    public void whenFindByName_thenReturnUser() {
	        // User
	        User dummyUser = new User();
	        dummyUser.setName("Dummy");
	        dummyUser.setUsername("d");
	        dummyUser.setPassword("password");
	        entityManager.persist(dummyUser);
	        //flushes the buffered output bytes to write out to the underlying output stream
	        entityManager.flush();
	    
	        // when
	        User found = userRepo.findByName(dummyUser.getName());

	        // then

	        assertEquals(found.getName(), dummyUser.getName());

	    }
	
}