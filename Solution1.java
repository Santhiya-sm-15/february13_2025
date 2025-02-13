class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq=new PriorityQueue<>();
        for(int a:nums)
            pq.add((long)a);
        int cnt=0;
        while(pq.size()>=2 && pq.peek()<k)
        {
            long x=pq.poll();
            long y=pq.poll();
            pq.add(x*2+y);
            cnt++;
        }
        return cnt;
    }
}