class Solution {
    public int maximumSum(int[] nums) {
        int n=nums.length,i,j;
        Map<Integer,PriorityQueue<Integer>> m=new HashMap<>();
        for(i=0;i<n;i++)
        {
            int k=nums[i];
            int tot=0;
            while(k>0)
            {
                tot+=k%10;
                k/=10;
            }
            if(!m.containsKey(tot))
                m.put(tot,new PriorityQueue<>(Collections.reverseOrder()));
            m.get(tot).add(nums[i]);
        }
        int max=-1;
        for(Map.Entry<Integer,PriorityQueue<Integer>> x:m.entrySet())    
        {
            int a=x.getKey();
            PriorityQueue<Integer> pq=x.getValue();
            if(pq.size()>=2)
            {
                int c=pq.poll();
                int d=pq.poll();
                max=Math.max(max,c+d);
            }
        }
        return max;
    }
}