package com.kodilla.testing.forum.statistics;

public class ForumStatistics {
    private int usersCount;
    private int postsCount;
    private int commentsCount;

    private double averagePostsPerUser;
    private double averageCommentsPerUser;
    private double averageCommentsPerPost;

    public void calculateAdvStatistics(Statistics statistics) {

        usersCount = statistics.usersNames().size();
        postsCount = statistics.postsCount();
        commentsCount = statistics.commentsCount();

        if (usersCount != 0) {
            averagePostsPerUser = (double) postsCount / usersCount;

            averageCommentsPerUser = (double) commentsCount / usersCount;
        } else {
            averagePostsPerUser = 0;
            averageCommentsPerUser = 0;
        }

        if (postsCount != 0) {
            averageCommentsPerPost = (double) commentsCount / postsCount;
        } else {
            averageCommentsPerPost = 0;
        }
    }

    public int getUsersCount() {
        return usersCount;
    }

    public int getPostsCount() {
        return postsCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public double getAveragePostsPerUser() {
        return averagePostsPerUser;
    }

    public double getAverageCommentsPerUser() {
        return averageCommentsPerUser;
    }

    public double getAverageCommentsPerPost() {
        return averageCommentsPerPost;
    }

}
