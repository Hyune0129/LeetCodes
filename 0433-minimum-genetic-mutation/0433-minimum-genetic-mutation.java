class Solution {
    final char[] GENES = { 'A', 'C', 'G', 'T' };

    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<String>(Arrays.asList(bank));
        Queue<String> queue = new LinkedList<>();
        Queue<Integer> countQueue = new LinkedList<>();
        int answer = -1;
        queue.add(startGene);
        countQueue.add(0);
        while (!queue.isEmpty()) {
            StringBuilder sb = new StringBuilder(queue.poll());
            int count = countQueue.poll();
            for (int i = 0; i < sb.length(); i++) {
                char temp = sb.charAt(i);
                for (int g = 0; g < GENES.length; g++) {
                    if(GENES[g] == temp) {
                        continue;
                    }
                    sb.setCharAt(i, GENES[g]);
                    String adjGene = sb.toString();
                    if(bankSet.contains(adjGene)) {
                        if(endGene.equals(adjGene)) {
                            answer = count + 1;
                        }
                        bankSet.remove(adjGene);
                        countQueue.add(count + 1);
                        queue.add(adjGene);
                    }
                    sb.setCharAt(i, temp);
                }
            }
        }
        return answer;
    }
}