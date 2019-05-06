/**
 * 
 */
package com.hht.api.feeder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hht.api.feeder.model.User;

/**
 * @author Jorge De Los Santos
 * @Version 1.1
 * @Since May 5, 2019 
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

	public User findByUserId(String userId);
}
