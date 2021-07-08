/**
 * 
 */
package com.example.demo.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.BlockedUsers;

/**
 * @author Markanto.v
 *
 */
public interface BlockedUsersRepository extends MongoRepository<BlockedUsers, Long> {

	Optional<BlockedUsers> findById(Long employeeId);
	
	List<BlockedUsers> findByIsBlocked(boolean isBlockedStatus);

}
