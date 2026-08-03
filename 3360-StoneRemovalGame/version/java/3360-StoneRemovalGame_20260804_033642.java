// Last updated: 04/08/2026, 03:36:42
1class Solution {
2    public boolean canAliceWin(int n) {
3     
4        int stonesToRemove = 10;
5        boolean aliceTurn = true;
6
7        // Keep playing as long as there are enough stones for the current turn
8        while (n >= stonesToRemove) {
9            n -= stonesToRemove;
10            stonesToRemove--;       // Next turn requires 1 fewer stone
11            aliceTurn = !aliceTurn; // Alternate turns between Alice and Bob
12        }
13
14        // If the game stops on Alice's turn, she couldn't move and lost (false).
15        // If it stops on Bob's turn, Bob couldn't move and Alice won (true).
16        return !aliceTurn;
17    }
18}
19    