// Last updated: 12/09/2025, 15:03:08

        class Solution {
    public boolean isArraySpecial(int[] a) {

            if (a.length < 2) {
            return true;
            }
            for (int i = 0; i < a.length - 1; i++) {

                if (a[i] % 2 == a[i + 1] % 2) {
                    return false;
                }
            }


            return true;
        }
    }


    

    