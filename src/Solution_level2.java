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
    }

    public static String solutionL2_2(int n) {
        String[] fourToThree=(Integer.toString(n)).replaceAll("4","3").split("");
        int digit=fourToThree.length-1;
        System.out.println(digit);
        int answer =0;
        for(String s:fourToThree){
            answer += (int)(Math.pow(3,digit--)*Integer.parseInt(s));
        }

        return Integer.toString(answer);
    }

    public static void main(String[] args) {
        System.out.println(solutionL2_1(8,12));
        System.out.println(solutionL2_2(14));
    }
}
