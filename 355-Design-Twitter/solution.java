public class Twitter {
    private static int timestamp;
    private class Tweet {
        int time;
        int tweetId;
        Tweet(int tweetId) {
            this.tweetId = tweetId;
            this.time = timestamp++;
        }
    }
    
    private class User {
        int userId;
        List<Tweet> tweets;
        Set<User> followers;
        User(int userId) {
            this.userId = userId;
            tweets = new ArrayList<Tweet>();
            followers = new HashSet<User>();
        }
    }
    
    Map<Integer, User> users;

    /** Initialize your data structure here. */
    public Twitter() {
        users = new HashMap<Integer, User>();
        timestamp = 0;
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!users.containsKey(userId)) {
            users.put(userId, new User(userId));
        }
        
        users.get(userId).tweets.add(new Tweet(tweetId));
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<Integer>();
        if (!users.containsKey(userId)) {
            return res;
        }
        
        Comparator<Tweet> comp = new Comparator<Tweet>() {
            @Override
            public int compare(Tweet a, Tweet b) {
                return a.time - b.time;
            }
        };
        
        PriorityQueue<Tweet> pq = new PriorityQueue<Tweet>(10, comp);
        constructFeedList(pq, users.get(userId));
        Set<User> followers = users.get(userId).followers;
        for(User user: followers) {
            constructFeedList(pq, user);
        }
        
        while(!pq.isEmpty()) {
            res.add(pq.poll().tweetId);
        }
        
        Collections.reverse(res);
        
        return res;
    }
    
    private void constructFeedList(PriorityQueue<Tweet> pq, User user) {
        int size = user.tweets.size();
        if (size == 0) {
            return;
        }
        
        for(int i = size - 1; i >= Math.max(0, size - 10); i--) {
            if (pq.size() < 10) {
                pq.offer(user.tweets.get(i));
            }
            else if (user.tweets.get(i).time > pq.peek().time) {
                pq.poll();
                pq.offer(user.tweets.get(i));
            }
            else {
                break;
            }
        }
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        
        if (!users.containsKey(followerId)) {
            users.put(followerId, new User(followerId));
        } 
        
        if (!users.containsKey(followeeId)) {
            users.put(followeeId, new User(followeeId));
        }
        
        users.get(followerId).followers.add(users.get(followeeId));
        
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        
        if (!users.containsKey(followerId)) {
            users.put(followerId, new User(followerId));
        } 
        
        if (!users.containsKey(followeeId)) {
            users.put(followeeId, new User(followeeId));
        }
        
        users.get(followerId).followers.remove(users.get(followeeId));
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */