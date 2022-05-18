class Solution {
    public List<String> removeInvalidParentheses(String s) {
        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(s);
        
        List<String> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            
            String curr = q.poll();
            if (this.valid(curr)) {
                ans.add(curr);
            }
            
            for (int i = 0; i < curr.length(); i++) {
                char ichar = curr.charAt(i);
                if (ichar != '(' && ichar != ')') {
                    continue;
                }
                String part1 = curr.substring(0, i);
                String part2 = curr.substring(i + 1);
                String next = part1 + part2;
                if (!visited.contains(next)) {
                    if (ans.isEmpty() || ans.get(ans.size() - 1).length() < next.length()) {
                        visited.add(next);
                        q.add(next);
                    }
                }
            }
        }
        
        return ans;
    }
    
   public boolean valid(String str) {
        int n = 0;
        for (int i = 0; i < str.length(); i++) {
            char ichar = str.charAt(i);
            if (ichar == '(') {
                n++;
            }
            else if (ichar == ')') {
                if (n == 0) {
                    return false;
                }
                n--;
            }
        }
        
        return n == 0;
    }
}