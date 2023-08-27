class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int left = 0;
        int right = people.length-1;
        Arrays.sort(people);
        int result = 0;
        while(left<=right){
            if(left==right){
                result++;
                break;
            }else if(people[left]+people[right]==limit){
                result++;
                left++;
                right--;
            }else{
                int next = getNext(people,left,right,limit);
                if(next>left){
                    result += (right - next + 1);
                    left++;
                    right = next-1;
                }else if(next == -1){
                    result += (right - left + 1);
                    break;
                }
            }
        }
        return result;
    }
    
    public int getNext(int[] people, int left, int right, int limit){
        int l = left;
        int r = right;
        int result = -1;
        while(l<=r){
            int mid  = (l+r)/2;
            if(people[left]+people[mid]<=limit){
                if(mid!=left){
                    result = mid;
                }
                l = mid+1;
            }else if(people[left]+people[mid]>limit){
                r = mid-1;
            }
        }
        return result;
    }
}