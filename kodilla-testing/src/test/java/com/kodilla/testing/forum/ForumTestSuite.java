package com.kodilla.testing.forum;

import com.kodilla.testing.user.SimpleUser;
import org.junit.jupiter.api.*;


@DisplayName("forum Test Suite")
class ForumTestSuite {
    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }
    @AfterEach
    public void after() {
        System.out.println("Test case: end");
    }
    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test case: begin");
    }
    @AfterAll
    public static void afterAll() {
        System.out.println("Test case: end");
    }


    @DisplayName(
            "When created SimpleUser with name, " +
            "then getUsername should return correct name"
    )
    @Test
    void testCaseRealName() {
        //Given
        SimpleUser simpleUser = new SimpleUser("theForumUser", "John Smith");
        //When
        String result = simpleUser.getRealName();
        System.out.println("Testing " + result);
        //Then
        Assertions.assertEquals("John Smith", result);
    }
    @Test
    void testCaseUsername() {
        //Given
        SimpleUser simpleUser = new SimpleUser("theForumUser", "jan Kowalski");
        //When
        String result = simpleUser.getUsername();
        String expectedResult = "theForumUser";

        //Then
        Assertions.assertEquals(expectedResult, result);
    }
}