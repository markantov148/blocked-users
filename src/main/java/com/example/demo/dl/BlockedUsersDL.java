/**
 * 
 */
package com.example.demo.dl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BlockedUsers;
import com.example.demo.repos.BlockedUsersRepository;

/**
 * @author Markanto.v
 *
 */
@Service
public class BlockedUsersDL {

	@Autowired
	private BlockedUsersRepository repo;
	
	public List<BlockedUsers> findAllBlockedUsersDetails() {
		// TODO Auto-generated method stub
		return this.repo.findAll();
	}
	
	public List<BlockedUsers> findByIsBlocked(boolean isBlockedStatus) {
		// TODO Auto-generated method stub
		return this.repo.findByIsBlocked(isBlockedStatus);
	}

	//This method is used to unblock the user with respect to the employee id passed as parameter
	public BlockedUsers unBlockUser(Long employeeId) {
			
		Optional<BlockedUsers> user = this.repo.findById(employeeId);
		BlockedUsers unblockedUser = user.get();
		unblockedUser.setBlocked(false);
		return this.repo.save(unblockedUser);		
	}
	//End of unblock method//

	
}
