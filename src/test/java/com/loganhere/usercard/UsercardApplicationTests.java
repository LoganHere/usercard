package com.loganhere.usercard;

import com.loganhere.usercard.repository.UserRepository;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UsercardApplicationTests {
	private UserRepository userRepository;

//	@BeforeEach
//	void setUp() {
//		userRepository = new UserRepository();
//	}
//
//	@Test
//	void testUniqueEmail() {
//		User user1 = new User(1, "Maksim", "Maksim@gmail.com");
//		User user2 = new User(2, "FakeMaksim", "Maksim@gmail.com");
//		userRepository.save(user1);
//		assertThrows(IllegalArgumentException.class, () -> userRepository.save(user2));
//
//		assertEquals(1, userRepository.storage.size());
//	}

}
