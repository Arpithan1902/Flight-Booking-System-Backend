package com.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.user.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query("select c from User c where c.userName= :userName and c.password= :passwd and c.userRole= :userRole")
	User login(@Param("userName")String userName, @Param("passwd") String password,@Param("userRole") String userRole);

	Optional<User> findByUserName(String userName);
	List<User> findByUserRole(String userRole);
	

	
	
}
