/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Employee> map = new HashMap<>();
        for(Employee e : employees){
            map.put(e.id,e);
        }
        return getImportance(map,id);
    }
    
    public int getImportance(HashMap<Integer,Employee> map, int id){
        int result = map.get(id).importance;
        for(int subId : map.get(id).subordinates){
            result += getImportance(map,subId);
        }
        return result;
    }
}