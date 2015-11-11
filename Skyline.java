public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        int cur = 0, curX = -1, curH = -1, len = buildings.length;
        Queue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return b[1] - a[1];
                }
                return b[0] - a[0];
            }
        });
        while (cur != len || !q.isEmpty()) {
            // if either some new building is not processed or live building queue is not empty
            curX = q.isEmpty()? buildings[cur][0]:q.peek()[1]; // next timing point to process

            if(cur >= len || buildings[cur][0] > curX)
            { //first check if the current tallest building will end before the next timing point
                  // pop up the processed buildings, i.e. those  have height no larger than cur_H and end before the top one
                while(!q.isEmpty() && ( q.peek()[1] <= curX) ) q.poll();
            }
            else
            { // if the next new building starts before the top one ends, process the new building in the vector
                curX = buildings[cur][0];
                while(cur<len && buildings[cur][0]== curX)  // go through all the new buildings that starts at the same point
                {  // just push them in the queue
                    q.offer(new int[]{buildings[cur][2], buildings[cur][1]});
                    cur++;
                }
            }
            curH = q.isEmpty()?0:q.peek()[0]; // outut the top one
            if(res.isEmpty() || (res.get(res.size() - 1)[1] != curH) ) res.add(new int[]{curX, curH});
        }
        return res;
    }
}
