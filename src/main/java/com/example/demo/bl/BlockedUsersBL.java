/**
 * 
 */
package com.example.demo.bl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dl.BlockedUsersDL;
import com.example.demo.entity.BlockedUsers;

/**
 * @author Markanto.v
 *
 */
@Component
public class BlockedUsersBL {

	@Autowired
	private BlockedUsersDL blockedUsersDL;
	
	//This method is used to get the blocked users details//
	public List<BlockedUsers> getAllBlockedUsersDetails(){			
	
		return this.blockedUsersDL.findAllBlockedUsersDetails();		
	}	
	//End of get all blocked users details//
	
	//This method is used to get the blocked users whose isBlockedStatus are true//
	public List<BlockedUsers> findByIsBlocked(boolean isBlockedStatus) {
		// TODO Auto-generated method stub
		return this.blockedUsersDL.findByIsBlocked(isBlockedStatus);
	}
	//End of isBlocked method
	
	//This method is used to unblock the users in the blocked users list
	public BlockedUsers unblockUser(Long employeeId) {
		// TODO Auto-generated method stub
		return this.blockedUsersDL.unBlockUser(employeeId);
	}
	//End of unblock method
}
