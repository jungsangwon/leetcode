class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<>(){
           @Override
            public int compare(int[] a, int[] b){
                return a[1]==b[1] ? a[0]-b[0] : a[1]-b[1];
            }
        });
        for(int i=1; i<people.length;i++){
            if(people[i][1]==people[i-1][1]){
                continue;
            }else{
                int count = 0;
                for(int j=0;j<i;j++){
                    if(people[i][0]<=people[j][0]){
                        count++;
                    }
                }
                int dif = count - people[i][1];
                int idx = i;
                for(int k=0; k<dif; k++){
                    int[] tmp = people[idx];
                    people[idx] = people[idx-1];
                    people[idx-1] = tmp;
                    idx--;
                }
            }
        }
        return people;
    }
}