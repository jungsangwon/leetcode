class Twitter {
    Map<Integer, Integer> tweetMap;
    Map<Integer, User> userMap;
    int key;

    public Twitter() {
        key = 0;
        userMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        User user;
        if(userMap.containsKey(userId)){
            user = userMap.get(userId);
        }else{
            user = new User(userId);
            userMap.put(userId,user);
        }
        user.post(tweetId);
        tweetMap.put(tweetId,key++);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        // System.out.println("getNewsFeed : "+userId);
        List<Integer> feedList = new ArrayList<>();
        User user = userMap.getOrDefault(userId,new User(userId));
        userMap.put(userId,user);
        feedList.addAll(user.feed);
        for(User u : user.follow){
            if(u.feed!=null){
                feedList.addAll(u.feed);
            }
        }
        Collections.sort(feedList,new Comparator<>(){
           @Override
            public int compare(Integer a, Integer b){
                return tweetMap.get(b) - tweetMap.get(a);
            }
        });
        List<Integer> result = new ArrayList<>();
        int limit = Math.min(10,feedList.size());
        for(int i=0; i<limit; i++){
            result.add(feedList.get(i));
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        User follower = userMap.getOrDefault(followerId,new User(followerId));
        User followee = userMap.getOrDefault(followeeId,new User(followeeId));
        userMap.put(followerId,follower);
        userMap.put(followeeId,followee);
        follower.follow.add(followee);
    }
    
    public void unfollow(int followerId, int followeeId) {
        User follower = userMap.getOrDefault(followerId,new User(followerId));
        User followee = userMap.getOrDefault(followeeId,new User(followeeId));
        userMap.put(followerId,follower);
        userMap.put(followeeId,followee);
        follower.follow.remove(followee);
    }
}

class User{
    int userId;
    List<Integer> feed;
    HashSet<User> follow;
    
    public User(int userId){
        this.userId = userId;
        this.feed = new ArrayList<>();
        this.follow = new HashSet<>();
    }
    
    public void post(int tweetId){
        feed.add(tweetId);
        if(feed.size()>10){
            feed.remove(0);
        }
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