# february13_2025
The problems that I solved today

1.You are given a 0-indexed integer array nums, and an integer k. In one operation, you will: Take the two smallest integers x and y in nums. Remove x and y from nums. Add min(x, y) * 2 + max(x, y) anywhere in the array.
Note that you can only apply the described operation if nums contains at least two elements. Return the minimum number of operations needed so that all elements of the array are greater than or equal to k.

Code:
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

2.Given start, end and an array arr of n numbers. At each step, start is multiplied with any number in the array and then mod operation with 100000 is done to get the new start. Your task is to find the minimum steps in which end can be achieved starting from start. If it is not possible to reach end, then return -1.

Code:
class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        Queue<int[]> q=new LinkedList<>();
        int[] vis=new int[100000];
        q.add(new int[]{0,start});
        vis[start]=1;
        while(!q.isEmpty())
        {
            int[] x=q.poll();
            int steps=x[0];
            int u=x[1];
            if(u==end)
                return steps;
            for(int a:arr)
            {
                int v=(u*a)%100000;
                if(vis[v]!=1)
                {
                    q.add(new int[]{steps+1,v});
                    vis[v]=1;
                }
            }
        }
        return -1;
    }
}

3.You are given a 0-indexed array nums consisting of positive integers. You can choose two indices i and j, such that i != j, and the sum of digits of the number nums[i] is equal to that of nums[j]. Return the maximum value of nums[i] + nums[j] that you can obtain over all possible indices i and j that satisfy the conditions.

Code:
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
