/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
       HashMap<Integer, Employee> hm = new HashMap<>();
       for (Employee e : employees) 
       {
            hm.put(e.id, e);
        }
        return getImportanceHelper(hm, id);
    }
    
    //Implementation of Simple DFS
    private int getImportanceHelper(HashMap<Integer, Employee> hm, int id) 
    {
        Employee e = hm.get(id);
        int TotalImportance = e.importance;
        
        //Subordiantes List acts as Adjecency list of nodes here
        for (int j : e.subordinates) {
            TotalImportance += getImportanceHelper(hm, j);
        }
        
        return TotalImportance;
    }
    
}
