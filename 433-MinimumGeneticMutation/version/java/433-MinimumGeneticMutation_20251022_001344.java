// Last updated: 22/10/2025, 00:13:44
class Solution {
    public int helper(String start,String end,HashSet<String> bankset ){
        Queue<String> q=new LinkedList<>();
        HashSet<String> visited=new HashSet<>();
        bankset.add(start);
        visited.add(start);
        char[] choice={'A','C','G','T'};
        int level=0;
        q.offer(start);

        while(!q.isEmpty()){
            int s=q.size();
            for(int i=0;i<s;i++){
                String temp=q.poll();
                if(temp.equals(end)) return level;
                char[] ch=temp.toCharArray();
                for(int j=0;j<ch.length;j++){
                    char original = ch[j];
                    for(int k=0;k<4;k++){
                        ch[j]=choice[k];
                         String neighbour = new String(ch);
                         if (!visited.contains(neighbour) && bankset.contains(neighbour)) {
                            visited.add(neighbour);
                            q.offer(neighbour);
                        }
                    }
                     ch[j] = original; 
                }
            }
            level++;
        }
        return -1;
    }
    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> bankset=new HashSet<>();
        for(int i=0;i<bank.length;i++){
            bankset.add(bank[i]);
        }
        if(!bankset.contains(endGene)) return -1;

        return helper(startGene,endGene,bankset);

    }
}