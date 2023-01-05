class Solution {
    String answer = "123450";
    public int slidingPuzzle(int[][] board) {
        HashSet<String> visit = new HashSet<>();
        String first = getKey(board);
        visit.add(first);
        int result = 0;
        Queue<String> qu = new LinkedList<>();
        qu.add(first);
        while(!qu.isEmpty()){
            int size = qu.size();
            for(int i=0; i<size; i++){
                String tmp = qu.poll();
                if(tmp.equals(answer)){
                    return result;
                }
                int x = 0;
                int y = 0;
                for(int j=0; j<tmp.length(); j++){
                    if(tmp.charAt(j)=='0'){
                        x = j/3;
                        y = j%3;
                        break;
                    }
                }
                char[] word = tmp.toCharArray();
                char c = word[y];
                word[y] = word[y+3];
                word[y+3] = c;
                String next = String.valueOf(word);
                if(!visit.contains(next)){
                    qu.add(next);
                    visit.add(next);
                }
                if(y!=0){
                    word = tmp.toCharArray();
                    c = word[3*x+y];
                    word[3*x+y] = word[3*x+y-1];
                    word[3*x+y-1] = c;
                    next = String.valueOf(word);
                    if(!visit.contains(next)){
                        qu.add(next);
                        visit.add(next);
                    }
                }
                if(y!=2){
                    word = tmp.toCharArray();
                    c = word[3*x+y];
                    word[3*x+y] = word[3*x+y+1];
                    word[3*x+y+1] = c;
                    next = String.valueOf(word);
                    if(!visit.contains(next)){
                        qu.add(next);
                        visit.add(next);
                    }
                }
            }
            result++;
        }
        
        return -1;
    }
    
    public String getKey(int[][] board){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<board.length; i++){
            for(int j=0;j<board[i].length; j++){
                sb.append(board[i][j]);
            }
        }
        return sb.toString();
    }
}