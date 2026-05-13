package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForumStatisticsTestSuite {

    private Statistics  statisticsMock;
    private ForumStatistics forumStatistics;

    @BeforeEach
    public void setup() {
        statisticsMock = mock(Statistics.class);
        forumStatistics = new ForumStatistics();
    }

    private List<String> generateUsers(int quantity) {
        List<String> users = new ArrayList<>();
        for (int i = 1; i <= quantity; i++) {
            users.add("User" + i);
        }
        return users;
    }

    @Test
    void testPostsCountEqualsZero() {

        // Given
        when(statisticsMock.usersNames()).thenReturn(generateUsers(10));
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(5);

        // When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        // Then
        assertEquals(0, forumStatistics.getPostsCount());
        assertEquals(0.0, forumStatistics.getAveragePostsPerUser());
    }

    @Test
    void testPostsCountEqualsThousand() {

        // Given
        when(statisticsMock.usersNames()).thenReturn(generateUsers(10));
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(500);

        // When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        // Then
        assertEquals(1000, forumStatistics.getPostsCount());
        assertEquals(100.0, forumStatistics.getAveragePostsPerUser());
    }

    @Test
    void testCommentsCountEqualsZero() {

        // Given
        when(statisticsMock.usersNames()).thenReturn(generateUsers(10));
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(0);

        // When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        // Then
        assertEquals(0, forumStatistics.getCommentsCount());
        assertEquals(0.0, forumStatistics.getAverageCommentsPerUser());
        assertEquals(0.0, forumStatistics.getAverageCommentsPerPost());
    }

    @Test
    void testCommentsLessThanPosts() {

        // Given
        when(statisticsMock.usersNames()).thenReturn(generateUsers(20));
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(50);

        // When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        // Then
        assertEquals(0.5, forumStatistics.getAverageCommentsPerPost());
    }

    @Test
    void testCommentsGreaterThanPosts() {

        // Given
        when(statisticsMock.usersNames()).thenReturn(generateUsers(20));
        when(statisticsMock.postsCount()).thenReturn(50);
        when(statisticsMock.commentsCount()).thenReturn(200);

        // When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        // Then
        assertEquals(4.0, forumStatistics.getAverageCommentsPerPost());
    }

    @Test
    void testUsersCountEqualsZero() {

        // Given
        when(statisticsMock.usersNames()).thenReturn(new ArrayList<>());
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(200);

        // When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        // Then
        assertEquals(0, forumStatistics.getUsersCount());
        assertEquals(0.0, forumStatistics.getAveragePostsPerUser());
        assertEquals(0.0, forumStatistics.getAverageCommentsPerUser());
    }

    @Test
    void testUsersCountEqualsHunred() {

        // Given
        when(statisticsMock.usersNames()).thenReturn(generateUsers(100));
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(5000);

        // When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        // Then
        assertEquals(100, forumStatistics.getUsersCount());
        assertEquals(10.0, forumStatistics.getAveragePostsPerUser());
        assertEquals(50.0, forumStatistics.getAverageCommentsPerUser());
    }

}
