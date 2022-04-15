package test.logic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dkeep.logic.User;

class UserTest {

	@Test
	void insertUserDeletUserTest() {
		User.Insert_User("dummy", "dummy", "dummy", "dummy", "dummy", "dummy", "dumy");
		assertEquals("4",User.Query_user_info("dummy")[0]);
		assertEquals("dummy",User.Query_user_info("dummy")[1]);
		assertEquals("dummy",User.Query_user_info("dummy")[2]);
		assertEquals("dumy",User.Query_user_info("dummy")[3]);
		User.Delete(4);
		assertNull(User.Query_user_info("dummy"));		
	}
	
	@Test
	void queryLoginTestAdmin() {
		assertEquals(3, User.Query_login("admin", "admin"));
	}

	
	@Test
	void queryLoginTestSuccess() {
		assertEquals(4, User.Query_login("abel", "abel"));
	}

	@Test
	void queryLoginTestWrongPassword() {
		assertEquals(2, User.Query_login("abel", "abelo"));
	}
	
	@Test
	void queryLoginTestWrongUsername() {
		assertEquals(1, User.Query_login("abelo", "abel"));
	}
	
	@Test
	void forgotPassword1TestNoUserFound() {
		assertNull(User.Query_forgot_password_1("abelo"));
	}
	
	@Test
	void forgotPassword1TestUserFound() {
		assertEquals("abel",User.Query_forgot_password_1("abel")[0]);
		assertEquals("Which city were you born in?",User.Query_forgot_password_1("abel")[1]);
	}
	
	@Test
	void forgotPassword2TestWrongAnswer() {
		assertNull(User.Query_forgot_password_2("abel", "Which city were you born in?","Porto"));
	}
	
	@Test
	void forgotPassword2TestRightAnswer() {
		assertEquals("abel",User.Query_forgot_password_2("abel", "Which city were you born in?","Lisbon"));
	}
	
	@Test
	void queryUserInfoTestSuccess() {
		assertEquals("2",User.Query_user_info("abel")[0]);
		assertEquals("abel@gmail.com",User.Query_user_info("abel")[1]);
		assertEquals("911111111",User.Query_user_info("abel")[2]);
		assertEquals("14511111",User.Query_user_info("abel")[3]);
	}
	
	@Test
	void queryUserInfoTestWrongUser() {
		assertNull(User.Query_user_info("abelo"));
	}
}
