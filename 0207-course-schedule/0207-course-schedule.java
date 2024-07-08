class Solution {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // topological 
        int[] inDegree = new int[numCourses];
        List[] courses = new List[numCourses];
        for(int i=0; i<numCourses; i++) {
            courses[i] = new ArrayList<Integer>();
        }
        for(int[] prerequisite : prerequisites) {
            courses[prerequisite[0]].add(prerequisite[1]);
            inDegree[prerequisite[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[numCourses];;
        for(int i=0; i<numCourses; i++) {
            if(inDegree[i] == 0) {
                isVisited[i] = true;
                queue.add(i);
            }
        }
        int course;
        while(!queue.isEmpty()) {
            course = queue.poll();
            for(int adjCourse : (List<Integer>)courses[course]) {
                inDegree[adjCourse]--;
                if(inDegree[adjCourse] == 0) {
                    isVisited[adjCourse] = true;
                    queue.add(adjCourse);
                }
            }
        }
        for(int i=0; i<numCourses; i++) {
            if(isVisited[i] == false) {
                return false;
            }
        }
        return true;
    }

    
}