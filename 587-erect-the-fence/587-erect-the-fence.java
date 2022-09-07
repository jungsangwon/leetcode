class Solution {
    public int[][] outerTrees(int[][] trees) {
        if(trees.length<2){
            return trees;
        }
        Stack<int[]> stack = new Stack<>();
        int[] root = new int[2];
        root[0] = Integer.MAX_VALUE;
        root[1] = Integer.MAX_VALUE;
        for(int i=0; i<trees.length; i++){
            if(trees[i][1]<root[1]){
                root[0] = trees[i][0];
                root[1] = trees[i][1];
            }else if(trees[i][1]==root[1] && trees[i][0]<root[0]){
                root[0] = trees[i][0];
            }
        }
        Arrays.sort(trees,new Comparator<>(){
            @Override
            public int compare(int[] a, int[] b){
                int t = ccw(root,a,b);
                if(t>0){
                    return -1;
                }else if(t<0){
                    return 1;
                }else{
                    long distance1 = dist(root, a);
                    long distance2 = dist(root, b);
                    if (distance1 > distance2) {
                        return 1;
                    }else{
                        return -1;
                    }
                }
            }
        });
        int i=trees.length-2;
        for(; i>=0; i--){
            if(ccw(trees[i], trees[trees.length-1], root)!=0){
                break;
            }
        }
        int l = ++i;
        int h = trees.length-1;
        while(l<h){
            int[] temp = trees[l];
            trees[l++] = trees[h];
            trees[h--] = temp;
        }
        stack.push(trees[0]);
        for(i=1; i<trees.length; i++){
            while(stack.size()>1 && ccw(stack.get(stack.size()-2),stack.get(stack.size()-1),trees[i])<0){
                stack.pop();
            }
            stack.push(trees[i]);
        }
        int[][] result = new int[stack.size()][2];
        for(i=0; i<result.length; i++){
            result[i] = stack.pop();
        }
        return result;
    }
    
    public int ccw(int[] a, int[] b, int[] c){
        return a[0]*(b[1]-c[1]) + b[0]*(c[1]-a[1]) + c[0]*(a[1]-b[1]);
    }
    
    static long dist(int[] a, int[] b) {
        return (b[0] - a[0]) * (b[0] - a[0]) + (b[1] - a[1]) * (b[1] - a[1]);
    }
}

