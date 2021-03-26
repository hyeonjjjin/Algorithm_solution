import java.lang.Math;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList; //import
import java.util.Queue; //import

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
    public static int[] solutionL2_3(int[] prices){
        int[] answer ={};
        //System.out.println("prices max: "+Integer.parseInt(Arrays.stream(prices).max()));



        return answer;
    }

    //올바른 괄호 >> 블로그 XX +7
    public static boolean solutionL2_4(String s) {
        int check=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') check++;
            else check--;
            if(check<0) return false;
        }
        if(check==0) return true;
        else return false;
    }

    //최솟값 만들기 >> 블로그 XX +4
    public static int solutionL2_5(int []A, int []B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        //Integer[] B_Integer = Arrays.stream(B).boxed().toArray(Integer[]::new);
        //Arrays.sort(B_Integer,Collections.reverseOrder());
        int len = A.length;
        for(int i=0;i<len;i++)
           answer += A[i]*B[len-i-1];
        return answer;
        //sum은 더 오래 걸림
    }

    //카펫 >> 블로그 XX +4
    public static boolean CheckBrown(int x, int y, int brown){
        return ((2*(x+y)+4) == brown);
    }
    public static int[] solutionL2_6(int brown, int yellow) {
        int[] answer = new int[2];
        for(int x=1;x<=(int)Math.sqrt(yellow);x++) {
            if (((yellow / x) == (double) yellow / x) && CheckBrown(x, yellow / x, brown)) {
                answer[0] = yellow / x+2; answer[1] = x+2;
                break;
            }
        }
       return answer;
    }


    public int solutionL2_7(int[] priorities, int location) {
        Queue<Integer> queue = new LinkedList<>(); //int형 queue 선언, linkedlist 이용

        int temp=0, max=0, rest=priorities.length, times=0, location_now=location;
        int[] temp_priorities = priorities;
        Arrays.sort(temp_priorities);
        max=temp_priorities[rest-1];
        //주어진 자료 큐에 저장
        for (int i=0;i<priorities.length;i++) queue.add(priorities[i]);
        temp = queue.poll();

        //location_now -=1;
        //꺼내보니 우선순위 1등이다? 그러면 얘가 목표했던 앤지 확인해야지
        if(temp==max) {
            if(location_now == 0)
                return times;
            else{
                location_now -=1;
                times+=1;
                rest-=1;
            }
        }
        //꺼냈는데 우선순위 1등이 아니면 다시 뒤에 넣어야지
        else {
            queue.add(temp);

        }

        int answer = 0;
        return answer;
    }


    public static void main(String[] args) {
        System.out.println(solutionL2_1(8,12));
        System.out.println(solutionL2_2(10));
        System.out.println(solutionL2_2_reverse(14));
        int[] prices = {1,2,3,2,3};
        System.out.println(solutionL2_3(prices));
        int[] A = {1,2};
        int[] B = {3,4};
        System.out.println(solutionL2_5(A,B));
        System.out.println(solutionL2_6(24,24));

    }
}
