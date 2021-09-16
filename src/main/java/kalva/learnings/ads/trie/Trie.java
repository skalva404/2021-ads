package kalva.learnings.ads.trie;

import kalva.learnings.ads.TrieNode;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String key) {
//        System.out.println("Inserting \"" + key + "\"");
        TrieNode curr = root;
        for (char c : key.toCharArray()) {
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
        }
        curr.actualString = key;
        curr.isLeaf = true;
    }

    public boolean search(String key) {
//        System.out.print("Searching \"" + key + "\" : ");
        TrieNode curr = root;
        for (char c : key.toCharArray()) {
            curr = curr.children.get(c);
            if (curr == null) {
                return false;
            }
        }
        return curr.isLeaf;
    }

    public String findLCP(List<String> dict) {
        for (String s : dict) {
            insert(s);
        }
        StringBuilder lcp = new StringBuilder();
        TrieNode curr = root;
        while (curr != null && !curr.isLeaf && 1 == curr.children.size()) {
            Map.Entry<Character, TrieNode> entry = curr.children.entrySet().iterator().next();
            lcp.append(entry.getKey());
            curr = entry.getValue();
        }
        return lcp.toString();
    }

    public void preOrder(TrieNode curr, String data) {
        if (null == curr) {
            return;
        }

        for (Map.Entry<Character, TrieNode> next : curr.children.entrySet()) {
            if (next.getValue().isLeaf) {
                System.out.println(data + next.getKey());
//                System.out.println(next.getValue().actualString);
            }
            preOrder(next.getValue(), data + next.getKey());
        }
    }

    public static void testPreOrder() {
        String s = "lexicographic sorting of a set of keys can be accomplished with " +
                "a simple trie based algorithm we insert all keys in a trie output " +
                "all keys in the trie by means of preorder traversal which results " +
                "in output that is in lexicographically increasing order preorder " +
                "traversal is a kind of depth first traversal";

        // split the given string to set of keys
        String[] dict = s.split(" ");
        Trie head = new Trie();
        for (String word : dict) {
            head.insert(word);
        }
        head.preOrder(head.root, "");
    }

    public static void main(String[] args) {

        Trie trie = new Trie();

//        List<String> dict = Arrays.asList(
//                "code", "coder", "coding", "codable", "codec", "codecs", "coded",
//                "codeless", "codependence", "codependency", "codependent",
//                "codependents", "codes", "codesign", "codesigned", "codeveloped",
//                "codeveloper", "codex", "codify", "codiscovered", "codrive"
//        );
//        List<String> dict = Arrays.asList("code", "coder", "coding", "codable");
//        System.out.println("The longest common prefix is " + trie.findLCP(dict));

        trie.insert("dabba");
        System.out.println(trie.search("dabba"));
        testPreOrder();

//        trie.insert("cat");
//        boolean isPresent = trie.search("cat");
//        System.out.println(isPresent);
//
//        trie.insert("ca");
//        isPresent = trie.search("ca");
//        System.out.println(isPresent);
//
//        isPresent = trie.search("cat");
//        System.out.println(isPresent);

//        trie.insert("dog");
//        isPresent = trie.startsWith("pen");
//        System.out.println(isPresent);
//
//        trie.insert("pick");
//
//        trie.insert("pickle");
//        isPresent = trie.search("picky");
//        System.out.println(isPresent);
    }
}
