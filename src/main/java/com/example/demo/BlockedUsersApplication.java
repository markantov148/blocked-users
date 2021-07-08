package com.example.demo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.BlockedUsers;
import com.example.demo.repos.BlockedUsersRepository;

@SpringBootApplication
public class BlockedUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlockedUsersApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner runner() {
		
		return new CommandLineRunner() {
			
			@Autowired
			BlockedUsersRepository repo;
				
			@Override
			public void run(String... args) throws Exception {
				
				repo.save(new BlockedUsers(111,"ABC","JAVA",LocalDate.now(),true));
				repo.save(new BlockedUsers(222,"XYZ","DEV",LocalDate.now(),true));
				repo.save(new BlockedUsers(333,"LMN","CLOUD",LocalDate.now(),true));
				repo.save(new BlockedUsers(444,"EFG","DS",LocalDate.now(),false));
				
			}
		};
	}

}
