// This uses an approach where we first gather the number with max frequency and iterate through both tops and bottoms array to get count 
// based on unequal number to this value. Minium of either will be the minimum rotations we require
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int maxNum=0, maxVal=0;
        Map<Integer, Integer> map = new HashMap();

        for(int i=0;i<tops.length;i++) {
            map.put(tops[i], map.getOrDefault(tops[i], 0)+1);
            map.put(bottoms[i], map.getOrDefault(bottoms[i], 0)+1);

            if(map.get(tops[i])>maxVal) {
                maxNum=tops[i];
                maxVal=map.get(tops[i]);
            } 
            if(map.get(bottoms[i])>maxVal) {
                maxNum=bottoms[i];
                maxVal=map.get(bottoms[i]);
            } 
        }

        return minRotations(tops, bottoms, maxNum);
    }

    private int minRotations(int[] tops, int[] bottoms, int val) {

        int topMin = 0, bottomMin = 0;
        for(int i=0;i<tops.length;i++) {
            if(tops[i]!=val && bottoms[i]!=val) return -1;
            if(tops[i]!=val) {
                topMin++;
            }
            if(bottoms[i]!=val) {
                bottomMin++;
            }
        }

        return Math.min(topMin, bottomMin);
    }
}
