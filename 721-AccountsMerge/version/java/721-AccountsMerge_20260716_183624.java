// Last updated: 16/07/2026, 18:36:24
1class Solution {
2    
3    public void dfs(HashMap<String,Set<String>> map, String node,HashSet<String> visited,List<String> component){
4        visited.add(node);
5        component.add(node);
6
7        for(String st:map.get(node)){
8            if(visited.contains(st)) continue;
9
10            dfs(map,st,visited,component);
11        }
12    }
13    public List<List<String>> accountsMerge(List<List<String>> accounts) {
14        HashMap<String,Set<String>> map=new HashMap<>();
15        HashMap<String, String> emailToName = new HashMap<>();
16
17        for(int i=0;i<accounts.size();i++){
18            String name = accounts.get(i).get(0);
19            String u = accounts.get(i).get(1);
20
21            map.computeIfAbsent(u, k -> new HashSet<>());
22
23           for(int j=1;j<accounts.get(i).size();j++){
24                String v=accounts.get(i).get(j);
25                emailToName.put(v, name);
26
27                if(u.equals(v)){
28                    continue; 
29                }
30                map.computeIfAbsent(u,k -> new HashSet<>()).add(v);
31                map.computeIfAbsent(v,k -> new HashSet<>()).add(u);
32           }
33        }
34
35        HashSet<String> visited=new HashSet<>();
36        List<List<String>> result=new ArrayList<>();
37
38        for(String st : map.keySet()){
39            if(!visited.contains(st)){
40                List<String> component = new ArrayList<>();
41                dfs(map,st,visited,component);
42                Collections.sort(component);
43                component.add(0,emailToName.get(st)); 
44                result.add(component);
45            }
46        }
47
48        return result;
49    }
50}