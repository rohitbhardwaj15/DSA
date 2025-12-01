class Twitter {

    private static int timeStamp = 0;

   
    private Map<Integer, Set<Integer>> followMap;

    private Map<Integer, List<int[]>> tweetMap;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new int[]{tweetId, timeStamp++});
    }

    public List<Integer> getNewsFeed(int userId) {
        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        if (tweetMap.containsKey(userId)) {
            for (int[] t : tweetMap.get(userId)) {
                maxHeap.offer(t);
            }
        }

        
        if (followMap.containsKey(userId)) {
            for (int followee : followMap.get(userId)) {
                if (tweetMap.containsKey(followee)) {
                    for (int[] t : tweetMap.get(followee)) {
                        maxHeap.offer(t);
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        int count = 0;

        
        while (!maxHeap.isEmpty() && count < 10) {
            result.add(maxHeap.poll()[0]); 
            count++;
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;

        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
