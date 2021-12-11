package kalva.learnings.ads.companies.thoughtspot;

import java.util.*;

/**
 * https://cheonhyangzhang.gitbooks.io/leetcode-solutions/content/127_word_ladder__medium.html
 */
public class WordLadder {

    public static void main(String[] args) {

        List<String> dict = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(bfs("hit", "cog", dict));

        System.out.println("============================");
        dict = Arrays.asList("bat", "cot", "cog", "cow", "rat", "but", "cut", "web", "dog");
        System.out.println(bfs("cat", "dog", dict));

        dict = new ArrayList(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println("============================");
        dfs("hit", "cog", dict);
        System.out.println(res);
    }

    public static int bfs(String beginWord, String endWord, List<String> wordList) {

        Set<String> dict = new HashSet<>(wordList);
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        int len = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int k = 0; k < size; k++) {

                String curWord = queue.poll();
                System.out.print(curWord + " ==> ");
                if (endWord.equals(curWord)) {
                    return len;
                }
                findSimilarWords(dict, queue, curWord);
                System.out.print(queue + "\n");
            }
            len++;
        }
        return 0;
    }

    static void findSimilarWords(Set<String> dict, Queue<String> queue, String curWord) {
        char[] arr = curWord.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char temp = arr[i];
            for (char letter = 'a'; letter <= 'z'; letter++) {
                arr[i] = letter;
                String newWord = String.valueOf(arr);
                if (dict.contains(newWord)) {
                    queue.add(newWord);
                    dict.remove(newWord);
                }
            }
            arr[i] = temp;
        }
    }

    private static void dfs(String beginWord, String endWord, List<String> ladder) {


    }


    private static HashMap<String, HashSet<String>> graph = new HashMap<>();
    private static List<List<String>> res = new ArrayList<>();
}
