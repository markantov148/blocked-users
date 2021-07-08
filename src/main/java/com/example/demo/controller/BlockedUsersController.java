/**
 * 
 */
package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bl.BlockedUsersBL;
import com.example.demo.dl.BlockedUsersDL;
import com.example.demo.entity.BlockedUsers;
import com.example.demo.repos.BlockedUsersRepository;

/**
 * @author Markanto.v
 *
 */
@RestController
@RequestMapping(path="/admin/blockedusers")
public class BlockedUsersController {

	@Autowired
	private BlockedUsersBL blockedUsersBL;
	
	@Autowired
	private BlockedUsersDL blockedUsersDL;
	
	@Autowired
	private BlockedUsersRepository repo;
	
	//This method is used to get all blocked users details
	@GetMapping(path = "/list")
	public ResponseEntity<List<BlockedUsers>> getAllBlockedUsersDetails() {
		
		List<BlockedUsers> blockedList = this.blockedUsersBL.findByIsBlocked(true);
		return ResponseEntity.status(HttpStatus.OK).body(blockedList);
	}
	//End of get all blocked users details method
	
	//This method is used to unblock the user of specific employee id
	@PutMapping(path = "/action/unblock/yes/{employeeId}")
	public ResponseEntity<BlockedUsers> unBlockUser(@PathVariable("employeeId") Long employeeId){
					
		BlockedUsers details = this.blockedUsersBL.unblockUser(employeeId);
		return ResponseEntity.status(HttpStatus.OK).body(details);
			
	}
	//End of unblock method
		
}
