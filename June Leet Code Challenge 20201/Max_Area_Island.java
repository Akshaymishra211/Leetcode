class Solution {
    public static void shuffleArray(int[] array) {
        int index, temp;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        shuffleArray(horizontalCuts);
        Arrays.sort(horizontalCuts);
        shuffleArray(verticalCuts);
        Arrays.sort(verticalCuts);
        int n=horizontalCuts.length,m=verticalCuts.length;
        int max_height=horizontalCuts[0],max_width=verticalCuts[0];
        for(int i=1;i<n;i++){
            max_height=Math.max(max_height,horizontalCuts[i]-horizontalCuts[i-1]);
        }
        max_height=Math.max(max_height,h-horizontalCuts[n-1]);
        for(int i=1;i<m;i++){
            max_width=Math.max(max_width,verticalCuts[i]-verticalCuts[i-1]);
        }
        max_width=Math.max(max_width,w-verticalCuts[m-1]);
        return (int)((max_height*1L*max_width)%1000000007);
    }
}
