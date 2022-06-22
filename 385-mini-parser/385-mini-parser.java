/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    private int idx = 0;
    public NestedInteger deserialize(String s) {
        if(s.charAt(0)!='['){
            return new NestedInteger(Integer.parseInt(s));
        }else{
            return dfsDeserialize(s.toCharArray()).getList().get(0);
        }
    }
    
    public NestedInteger dfsDeserialize(char[] c){
        NestedInteger root = new NestedInteger();
        boolean minus = false;
        boolean check = false;
        int tmp=0;
        for(;idx<c.length;idx++){
            if(c[idx]=='['){
                idx++;
                root.add(dfsDeserialize(c));
            }else if(c[idx]==']'){
                if(check){
                    root.add(new NestedInteger(tmp));
                }
                return root;
            }else if(c[idx]==','){
                if(check){
                    root.add(new NestedInteger(tmp));
                }
                tmp=0;
                minus=false;
                check = false;
            }else if(c[idx]=='-'){
                minus=true;
            }else{
                check = true;
                tmp = tmp*10;
                if(minus){
                    tmp -= (c[idx]-'0');
                }else{
                    tmp += (c[idx]-'0');
                }
            }
        }
        return root;
    }
}