import org.w3c.dom.ranges.Range;

import java.util.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.List;

class Solution {
    public int[] solution1(int[] numbers) {//2021.02.02
        Arrays.sort(numbers);
        List<Integer> totalList = new ArrayList<>();
        int isSame=numbers[0];
        for(int i=0;i<numbers.length;i++){
            if(i==0 || isSame != numbers[i]) {
                for(int j=i+1;j<numbers.length;j++)
                    totalList.add(numbers[i]+numbers[j]);
            } isSame=numbers[i];
        }
        TreeSet<Integer> arrTemp1 = new TreeSet<Integer>(totalList);
        ArrayList<Integer>arrTemp2 = new ArrayList<Integer>(arrTemp1);
        int[] answer = arrTemp2.stream().mapToInt(i->i).toArray();
        return answer;
    }

    public static int solution2(int n) {//2021.02.06
        String third = Integer.toString(n, 3);
        StringBuffer sb = new StringBuffer(third);
        String reversed = sb.reverse().toString();

        return Integer.parseInt(reversed,3);
    }

    public static String solution3(String s) {
        if(s.length()%2==0) return s.substring((s.length()/2)-1,s.length()/2+1);
        else return s.substring(s.length()/2,s.length()/2+1);
    }
    public static long solution4(int a, int b) {
        if(a*b>=0) return (a+b)*(Math.abs(a-b)+1)/2;
        else if(a<0) return (a+b)*(Math.abs(b-a)+1)/2;
        else return (a+b)*(Math.abs(a-b)+1)/2;
    }
    public static String solution5(int n) {
        /*내 풀이
        String answer = "";
        for (int i=0;i<n/2;i++) answer=answer.concat("수박");
        if(n%2==1) answer=answer.concat("수");
        //return answer;*/
        //다른사람 풀이
        return new String(new char [n/2+1]).replace("\0", "수박").substring(0,n);
    }
    public static int solution6(String s) {
        return Integer.parseInt(s);
    }

    //이거는 풀었다 하기도 민망한디,,
    public static int solution7(int[] a, int[] b){
        int answer = 0;
        for(int i=0;i<a.length;i++)
            answer+=a[i]*b[i];
        return answer;
    }
    public static int solution8(int n) {
        if(n==0||n==1) return n;
        int answer = n;
        for(int i=n-1;i>0;i--){
            if(n%i==0) answer+=i;
        }
        return answer;
    }
    public static String solution9(String s) {
        String answer = "";
        String[] s_tmps = s.split(" ");
        System.out.println(s_tmps.length);
        for(int i=0;i<s_tmps.length;i++){
            for(int k=1;k<=s_tmps[i].length();k++) {
                if(k%2==1) answer = answer.concat(s_tmps[i].toUpperCase().substring(k-1,k));
                else answer = answer.concat(s_tmps[i].substring(k-1,k));

            }
            System.out.println(answer+" "+answer.length());
            answer = answer.concat(" ");
        }

        return answer.substring(0,answer.length());


        //return answer;
    }

        public static void main(String[] args) {
        System.out.println(solution2(45));
        System.out.println(solution3("12345"));
        System.out.println(solution4(-5,0));
        System.out.println(solution5(3));
        System.out.println(solution6("89425"));
        int a[]={1,2,3,4};
        int b[]={-3,-1,0,2};
        System.out.println(solution7(a,b));
        System.out.println(solution8(12));
        System.out.println(solution9("try hello world"));

        }

}

