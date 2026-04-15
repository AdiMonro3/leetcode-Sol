// Last updated: 15/04/2026, 12:23:12
1class RandomizedCollection {
2    ArrayList<Integer> list;
3    HashMap<Integer,Set<Integer>> map;
4    
5    public RandomizedCollection() {
6        map=new HashMap<>();
7        list=new ArrayList<>();
8    }
9    
10    public boolean insert(int val) {
11        boolean b=true;
12        list.add(val);
13        if(map.containsKey(val)){
14            map.get(val).add(list.size()-1);
15            b=false;
16        }
17        else{
18            map.putIfAbsent(val, new HashSet<>());
19            map.get(val).add(list.size()-1);
20        }
21        return b;
22    }
23    
24    public boolean remove(int val) {
25        if(!map.containsKey(val)) return false;
26
27        int idx=map.get(val).iterator().next();
28        int lastIdx=list.size()-1;
29        int lastVal = list.get(lastIdx);
30
31        map.get(val).remove(idx);
32        
33        if (idx != lastIdx) {
34            list.set(idx, lastVal);
35
36            
37            map.get(lastVal).remove(lastIdx);
38            map.get(lastVal).add(idx);
39        }
40
41        list.remove(lastIdx);
42
43    
44        if (map.get(val).isEmpty()) {
45            map.remove(val);
46        }
47
48        return true;
49
50    }
51    
52    public int getRandom() {
53        Random rand = new Random();
54
55        int randomIndex = rand.nextInt(list.size());
56        return list.get(randomIndex);
57    }
58}
59
60
61/**
62 * Your RandomizedCollection object will be instantiated and called as such:
63 * RandomizedCollection obj = new RandomizedCollection();
64 * boolean param_1 = obj.insert(val);
65 * boolean param_2 = obj.remove(val);
66 * int param_3 = obj.getRandom();
67 */