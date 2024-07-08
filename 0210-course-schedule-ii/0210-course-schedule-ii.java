class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> answer = new ArrayList<>();
        List[] courses = new List[numCourses];
        boolean[] isVisited = new boolean[numCourses];
        int[] inDegree = new int[numCourses];
        for(int i=0; i<numCourses; i++) {
            courses[i] = new ArrayList<Integer>();
        }
        for(int[] prerequisite : prerequisites) {
            courses[prerequisite[1]].add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<numCourses; i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
                isVisited[i] = true;
                answer.add(i);
            }
        }
        while(!queue.isEmpty()) {
            int course = queue.poll();
            for(int adjCourse : (List<Integer>)courses[course] ) {
                if(isVisited[adjCourse])
                    continue;
                inDegree[adjCourse]--;
                if(inDegree[adjCourse] == 0) {
                    isVisited[adjCourse] = true;
                    queue.add(adjCourse);
                    answer.add(adjCourse);
                }
            }
        }
        return answer.stream().mapToInt(Integer::valueOf).toArray();
    }
}