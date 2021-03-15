import java.lang.Math;

public class Solution_level2 {
    public static long solutionL2_1(int w, int h) {
        long answer = 1;
        double ratio = (w>h)? ((double)w)/h : ((double)h)/w;
        int n = (int)Math.ceil(ratio);
        answer = (long) n *(Math.min(w, h));

        //ratio=4/5;
        System.out.println(ratio+" "+n);

        return answer;
    }
    public static void main(String[] args) {
        solutionL2_1(3,4);
    }
}
