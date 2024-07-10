class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Integer> sequences = new LinkedList<>();
        HashSet<String> wordSet = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        sequences.add(1);
        while (!queue.isEmpty()) {
            StringBuilder word = new StringBuilder(queue.poll());
            int sequence = sequences.poll();
            for (int i = 0; i < word.length(); i++) {
                char temp = word.charAt(i);
                for (char c = 'a'; c <= 'z'; c++) {
                    if (temp == c) {
                        continue;
                    }
                    word.setCharAt(i, c);
                    String nextWord = word.toString();
                    if (wordSet.contains(nextWord)) {
                        if (nextWord.equals(endWord)) {
                            return sequence + 1;
                        }
                        queue.add(nextWord);
                        sequences.add(sequence + 1);
                        wordSet.remove(nextWord);
                    }
                    word.setCharAt(i, temp);
                }
            }
        }

        return 0;
    }
}