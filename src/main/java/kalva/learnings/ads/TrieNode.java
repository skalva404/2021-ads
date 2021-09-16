package kalva.learnings.ads;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    public boolean isLeaf;
    public String actualString;
    public Map<Character, TrieNode> children;

    public TrieNode() {
        isLeaf = false;
        children = new HashMap<>();
    }
}
