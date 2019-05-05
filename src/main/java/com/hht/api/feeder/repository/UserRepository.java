/**
 * 
 */
package com.hht.api.feeder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hht.api.feeder.model.User;

/**
 * @author Jorge De Los Santos
 * @Version 1.1
 * @Since May 5, 2019 
 */
public interface UserRepository extends JpaRepository<User, String> {

}
