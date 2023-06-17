class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        Person[] person = new Person[quiet.length];
        int[] result = new int[quiet.length];
        for(int i=0; i<quiet.length; i++){
            person[i] = new Person(i,quiet[i]);
        }
        for(int i=0; i<richer.length; i++){
            person[richer[i][1]].addPerson(person[richer[i][0]]);
        }
        for(int i=0;i<result.length;i++){
            int tmp = i;
            int min = Integer.MAX_VALUE;
            boolean[] visit = new boolean[quiet.length];
            visit[i] = true;
            Queue<Person> qu = new LinkedList<>();
            qu.add(person[i]);
            while(!qu.isEmpty()){
                Person now = qu.poll();
                if(min>now.quiet){
                    min = now.quiet;
                    tmp = now.n;
                }
                for(Person next : now.list){
                    if(!visit[next.n]){
                        visit[next.n] = true;
                        qu.add(next);
                    }
                }
            }
            result[i] = tmp;
        }
        return result;
    }
}

class Person{
    int n;
    int quiet;
    List<Person> list;
    public Person(int n, int quiet){
        this.n = n;
        this.quiet = quiet;
        list = new ArrayList<>();
    }
    public void addPerson(Person a){
        list.add(a);
    }
}