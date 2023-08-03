class Trie {
    static final int N = 26;
    Trie[] characters = new Trie[N];
    // flag indicates it is end of word
    boolean flag = false;
    public Trie() {
        for(int i = 0;i<N;i++)
        {
            characters[i] = null;
        }
    }
    
    public void insert(String word) {
        Trie root = this;
        for(int i = 0;i<word.length();i++)
        {
            int curr = (int)(word.charAt(i)- 'a');
            if(root.characters[curr] == null)
                root.characters[curr] = new Trie();           
            root = root.characters[curr];
        }
        // to distinguish between app and apple, we mark last char's flag = true
        // if app exists p.flag = true and for apple e.flag = true;
        root.flag = true;
    }
    
    public boolean search(String word) {
        Trie root = this;
        for(int i = 0;i<word.length();i++)
        {
            int curr = (int)(word.charAt(i)- 'a');
            if(root.characters[curr] == null)
                return false;           
            root = root.characters[curr];
        }
        return root.flag;
    }
    
    public boolean startsWith(String prefix) {
        Trie root = this;
        for(int i = 0;i<prefix.length();i++)
        {
            int curr = (int)(prefix.charAt(i)- 'a');
            if(root.characters[curr] == null)
                return false;          
            root = root.characters[curr];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */