import org.w3c.dom.ranges.Range;

import java.util.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.List;
import java.lang.Math;
import java.util.stream.Stream;

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
    public static String toUpperAt(String str, int index)
    {
        StringBuilder sb =new StringBuilder(str);
        sb.setCharAt(index,Character.toUpperCase(str.charAt(index)));
        return sb.toString();
    }
    public static String toLowerAt(String str, int index)
    {
        StringBuilder sb =new StringBuilder(str);
        sb.setCharAt(index,Character.toLowerCase(str.charAt(index)));
        return sb.toString();
    }

    public static String solution9(String s) {
        int k;
        for(int i=0;i<s.length();i++){
            if (s.charAt(i)==' ') {continue; }
            for(k=i;k<s.length();k++) {
                if(s.charAt(k)==' ') break;
                if((k-i)%2==0) s=toUpperAt(s,k);
                else s = toLowerAt(s,k);
            }
            i=k;
        }
        return s;
    }

    public static int solution10(int n){
        return Integer.toString(n).chars().map(i->i-'0').sum();
        // 123 -> "123" -> '1' '2' '3' -> 1 2 3 -> sum
        //chars() 함수는 string 형태로 바꾼 n을 스트림으로 만드는거야
        //스트림이니까 map 함수는 순서대로 람다식 적용할 수 있지 그래서 i->i-'0' 가능쓰, Character::getNumbericValue 도 가능해
        //그리고 다 더하는거

    }
    public static int[] solution11(long n){
        StringBuffer stb = new StringBuffer();
        String[] s = stb.append(n).reverse().toString().split("");//StringBuffer 변수로 뒤집고 String[]로 변환
        int[] answer = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();//stream 으로 Integer>int, int[]로 변환
        return answer;
    }


    public static long solution12(long n){
        if(Math.sqrt(n) == (int)(Math.sqrt(n))) return (long) Math.pow(Math.sqrt(n)+1,2);
        else return -1;
    }
    public static double solution13(int[] arr) {
        return Arrays.stream(arr).sum()/(double)arr.length;
    }

    public static int count=0;
    public static int answer14;

    public static long solution14_jg(long num){
        System.out.println(num+" "+count);
        if(count>500) answer14= -1;
        else if (num==1) answer14= count;
        else if (num%2==0) {
            System.out.println("짝수네");
            count++;solution14_jg(num/=2);}
        else {
            System.out.println("홀수네");
            count++; solution14_jg(num=num*3+1);}
        return (int)answer14;
    }
    public static int solution14(int num) {
        return (int)solution14_jg(num);
    }

    public static boolean solution15(int x) {
        return (x % (Integer.toString(x).chars().map(i->i-'0').sum()) == 0);
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
        System.out.println(solution9("  try  hello world   aVCde    a"));
        System.out.println(solution10(123));
        //System.out.println(solution11(1234));
        System.out.println(solution12(121));
        int[] arr ={1,2,3,4};
        System.out.println(solution13(arr));
        System.out.println(solution14(626331));
        System.out.println(solution15(13));

        }

}

