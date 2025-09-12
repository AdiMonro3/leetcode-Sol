// Last updated: 13/09/2025, 01:48:28
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives=0;
        int tens=0;
        int twentys=0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                fives++;
            }
            else if(bills[i]==10){
                if(fives>=1){
                    fives--;
                }
                else return false;
                
                tens++;
                }
            else {
                if(fives>=1 && tens>=1){
                    fives--;
                    tens--;
                }
                else if(fives>=3){
                    fives-=3;
                }
                else return false;
                twentys++;}

        }
        return true;
    }
}