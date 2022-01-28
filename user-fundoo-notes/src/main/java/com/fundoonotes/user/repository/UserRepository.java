package com.fundoonotes.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fundoonotes.user.dto.RequestDto;
import com.fundoonotes.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("select u from User u where u.mobileNumber=:number and u.password=:pass")
	Optional<User> getDetails(@Param("number") String mobileNumber, @Param("pass") String password);

	User save(User user);

	//Optional<User> getDetails(String mobileNumber, String password);

}
