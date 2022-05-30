class Solution {
    public String removeDuplicateLetters(String s) {
	int[] count = new int[26];

	for (char ch : s.toCharArray()) {
		count[ch-'a']++;
	}

	Stack<Character> stk = new Stack<>();
	boolean[] visited = new boolean[26];

	for (char ch : s.toCharArray()) {
		count[ch-'a']--;
		if (visited[ch-'a']) {
			continue;
		}
		while (!stk.isEmpty() && stk.peek() > ch && count[stk.peek()-'a'] > 0) {
			visited[stk.pop()-'a'] = false;
		}
		stk.push(ch);
		visited[ch-'a'] = true;
	}

	StringBuilder sb = new StringBuilder();
	while (!stk.isEmpty()) {
		sb.append(stk.pop());
	}
	return sb.reverse().toString();
    }
}

// class Solution {
//     boolean[] dp = new boolean[26];        
//     public String removeDuplicateLetters(String s) {
//         String result = "";
//         int[] start = new int[26];
//         int[] end = new int[26];
//         Arrays.fill(start,-1);
        
//         for(int i=0; i<s.length(); i++){
//             int idx = s.charAt(i)-'a';
//             if(dp[idx]){
//                 continue;
//             }
//             if(start[idx]==-1){
//                 start[idx]=i;
//                 end[idx]=i;
//             }else{
//                 end[idx]=i;
//             }
//         }
//         for(int i=0; i<26; i++){
//             if(start[i]!=-1){
//                 boolean check = true;
//                 for(int j=i+1;j<26;j++){
//                     if(start[j]!=-1 && start[i]>end[j]){
//                         check = false;
//                         break;
//                     }
//                 }
//                 if(check){
//                     dp[i] = true;
//                     char now = (char)('a' + i);
//                     String next = s.substring(start[i]+1);
//                     result = now + removeDuplicateLetters(next);
//                     break;
//                 }
//             }
//         }
//         return result;
//     }
// }