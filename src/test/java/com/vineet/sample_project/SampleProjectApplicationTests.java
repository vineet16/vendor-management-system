package com.vineet.sample_project;

import com.vineet.sample_project.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SampleProjectApplicationTests {

	@Autowired
	private UserRepository userRepo;
	@Test
	void contextLoads() {
	}

	@Test
	public void repoTest() {
		String name = this.userRepo.getClass().getName();
		System.out.println(name);
		String packName = this.userRepo.getClass().getPackageName();
		System.out.println(packName);
	}

}
