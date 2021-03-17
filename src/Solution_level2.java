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

    //124 나라의 숫자 >> 블로그 XX +8
    public static String solutionL2_2(int n) {
        StringBuffer answer = new StringBuffer();
        while(Math.ceil((double) n / 3) > 0){
            if(n%3==0){
                answer.append(Integer.toString(4));
                n=n/3-1;
            }
            else{
                answer.append(Integer.toString(n % 3));
                n/=3;
            }
        }
        //System.out.println("143");
        //String ss = answer.toString().replaceAll("^[0]","");
        return answer.reverse().toString().replaceAll("3","4");
    }
    public static String solutionL2_2_reverse(int n) {
        String[] fourToThree=(Integer.toString(n)).replaceAll("4","3").split("");
        int digit=fourToThree.length-1;
        System.out.println(digit);
        int answer =0;
        for(String s:fourToThree){
            answer += (int)(Math.pow(3,digit--)*Integer.parseInt(s));
        }
        return Integer.toString(answer);
    }

    //주식 가격 >> 블로그 XX
    public static int[] solution2_3(int[] prices){
        int[] answer ={};


        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solutionL2_1(8,12));
        System.out.println(solutionL2_2(10));
        System.out.println(solutionL2_2_reverse(14));
    }
}
