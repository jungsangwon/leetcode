class Solution {
    Node root;
    public List<List<Integer>> palindromePairs(String[] words) {
        root = buildTrie(words);
        List<List<Integer>> result = new ArrayList();
        for(int i=0; i<words.length; i++) {
            List<Integer> list = findPlandroms(words[i]);
            for(int index: list) {
                if(index == i) {
                    continue;
                }
                result.add(Arrays.asList(i, index));  
            }
        }
        return result;
    }
    
    private List<Integer> findPlandroms(String word) {
        List<Integer> result = new ArrayList();
        char[] arr = word.toCharArray();
        int i=0;
        Node curr = root;
        //word's rightSide
        while(curr != null && i<arr.length) {
            if(curr.isWord && isPalindromString(word, i, word.length()-1)) {
                result.add(curr.index);
            }
            curr = curr.childs[arr[i]-'a'];
            i++;
        }
        if (curr == null) {
            return result;
        }
        //word = leftSide
        result.addAll(findWords(curr, ""));
        return result;
    }
    
    private List<Integer> findWords(Node curr, String prefix) {
        List<Integer> result = new ArrayList();
        if (curr.isWord) {
            if (isPalindromString(prefix, 0, prefix.length()-1)) {
                result.add(curr.index);
            }
        }
        
        for(int i=0; i<curr.childs.length; i++) {
            if(curr.childs[i] != null) {
                result.addAll(findWords(curr.childs[i], prefix + ((char)(i+'a'))));
            }
        }
        return result;
    }
    
    private boolean isPalindromString(String word, int l, int r) {
        char[] arr = word.toCharArray();
        int i=l;
        int j = r;
        while(i<=j) {
            if(arr[i] != arr[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
    private Node buildTrie(String[] words) {
        Node root = new Node();
        int index = 0;
        for(String word: words) {
            char[] arr = word.toCharArray();
            int i = arr.length -1;
            Node curr = root;
            while(i >= 0) {
                if (curr.childs[arr[i]-'a'] == null) {
                    curr.childs[arr[i]-'a'] = new Node();
                }
                curr = curr.childs[arr[i]-'a'];
                i--;
            }
            curr.isWord = true;
            curr.index = index;
            index++;
        }
        return root;
    }
    
    static class Node {
        Node[] childs = new Node[26];
        boolean isWord;
        int index;
    }
}