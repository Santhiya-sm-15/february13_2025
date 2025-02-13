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
