import java.lang.Math;
import java.math.BigInteger;
import java.sql.SQLOutput;

public class Solution_level2 {

    //멀쩡한 사각형 >> 블로그 XX +12
    public static long solutionL2_1(int w, int h) {
        BigInteger bi1 = new BigInteger(Integer.toString(w));
        BigInteger bi2 = new BigInteger(Integer.toString(h));
        int gcd=Integer.parseInt("" + bi1.gcd(bi2));
        return (long) w*h - (long) ((w / gcd) + (h / gcd) - 1)*gcd;

//        double ratio = (w>h)? ((double)w)/h : ((double)h)/w;
  //      int n = (int)Math.ceil(ratio);
   //     answer = (long) n *(Math.min(w, h));
//
        //ratio=4/5;
  //      System.out.println(ratio+" "+n);

    //    return answer;
    }
    public static void main(String[] args) {
        System.out.println(solutionL2_1(8,12));
    }
}
