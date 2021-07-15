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

    //가운데 글자 가져오기 >> 블로그 O
    public static String solution3(String s) {
        if(s.length()%2==0) return s.substring((s.length()/2)-1,s.length()/2+1);
        else return s.substring(s.length()/2,s.length()/2+1);
    }

    public static long solution4(int a, int b) {
        if(a*b>=0) return (long) (a + b) *(Math.abs(a-b)+1)/2;
        else if(a<0) return (long) (a + b) *(Math.abs(b-a)+1)/2;
        else return (long) (a + b) *(Math.abs(a-b)+1)/2;
    }

    //수박수박수박수박수박수? >> 블로그 O
    public static String solution5(int n) {
        /*내 풀이
        String answer = "";
        for (int i=0;i<n/2;i++) answer=answer.concat("수박");
        if(n%2==1) answer=answer.concat("수");
        //return answer;*/
        //다른사람 풀이
        return new String(new char [n/2+1]).replace("\0", "수박").substring(0,n);
    }

    //문자열을 정수로 바꾸기 >> 블로그 O
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

    //약수의 합 >> 블로그 O
    public static int solution8(int n) {
        if(n==0||n==1) return n;
        int answer = n;
        for(int i=n-1;i>0;i--){
            if(n%i==0) answer+=i;
        }
        return answer;
    }

    //이상한 문자 만들기 >>블로그 O
    public static String toUpperAt(String str, int index) {
        StringBuilder sb =new StringBuilder(str);
        sb.setCharAt(index,Character.toUpperCase(str.charAt(index)));
        return sb.toString();
    }
    public static String toLowerAt(String str, int index) {
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
    public static String solution9_nam(String s) {
        String answer = "";
        int cnt = 0;
        String[] array = s.split("");

        for(String ss : array) {
            System.out.println(ss);
        }
        return "벱";
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
        if(count>500) answer14= -1;
        else if (num==1) answer14= count;
        else if (num%2==0) {count++;solution14_jg(num/=2);}
        else {count++; solution14_jg(num=num*3+1);}
        return (int)answer14;
    }
    public static int solution14(int num) {
        return (int)solution14_jg(num);
    }

    //하샤드 수 >> 블로그 O
    public static boolean solution15(int x) {
        return (x % (Integer.toString(x).chars().map(i->i-'0').sum()) == 0);
    }

    //핸드폰 번호 가리기 >> 블로그 O
    public static String solution16(String phone_number){
        return "********************".substring(0,phone_number.length()-4)+phone_number.substring(phone_number.length()-4);
    }

    //소수 만들기 >> 블로그 XX
    public static boolean primeCheck_18(int num){
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0) return false;
        }
        return true;
    }
    public static int solution18(int[] nums) {
        int answer=0;
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++)
                    if(primeCheck_18(nums[i]+nums[j]+nums[k])) answer++;
            }
        }
        return answer;
    }

    //크레인 인형뽑기 (level 1) >> 블로그 O +4
    public static int solution19(int[][] board, int[] moves){
        int next=0, cnt=0,current=-1,line=-1;
        boolean empty_line;
        int[] Stack= new int[moves.length];
        for(int i=0;i<moves.length;i++){
            line=moves[i]-1;
            empty_line=true;
            for(int checkDown=0;checkDown<board[0].length;checkDown++){
                if(board[checkDown][line]==0) {
                    continue;
                }
                else {
                    next=board[checkDown][line];
                    board[checkDown][line]=0;
                    empty_line=false;
                    break;
                }
            }
            if(!empty_line){
                if(current !=-1 && next == Stack[current]){
                    Stack[current--]=0;
                    cnt+=2;
                }
                else Stack[++current]=next;
            }
        }
         return cnt;
    }

    public static int[] solution20(int []arr) {


        arr.toString().replaceAll("[0]{2,}","0");

        return arr;
    }

    //K번째 수 >>블로그XX +2
    public static int[] solution21(int[] array, int[][] commands){
        int[] answer=new int[commands.length];
        String arrayS=Arrays.toString(array).replaceAll("\\[","");
        arrayS = arrayS.replaceAll(", ","");
        //arrayS.replaceAll(" ","");
        for(int idx=0;idx<commands.length;idx++){
            int[] tmp = Arrays.copyOfRange(array, commands[idx][0]-1, commands[idx][1]);
            Arrays.sort(tmp);

            answer[idx]=tmp[commands[idx][2]-1];
            System.out.println(tmp);
        }
        return answer;
    }

    //같은 숫자는 싫어 >>블로그XX +1 야박해!!
    public static int[] solution22(int[] arr){
        int index=1;
        for(int i=1;i<arr.length;i++)
            if(arr[index-1]!=arr[i]) arr[index++]=arr[i];
        return Arrays.copyOfRange(arr,0,index);
    }

    // 완주하지 못한 선수 >> 블로그 XX +4
    public static String solution23(String[] participant, String[] completion){
        Arrays.sort(participant);
        Arrays.sort(completion);
        for(int i=0;i<completion.length;i++){
            if(!completion[i].equals(participant[i]))// != 연산자로 쓰면 제대로 실행 X
                return participant[i];
        }
        return participant[participant.length-1];
    }

    //제일 작은 수 제거하기 >>블로그 XX +2
    public static int[] solution24(int[] arr) {
        if (arr.length == 1) {
            int[] answer_1 = new int[1];
            answer_1[0] = -1;
            return answer_1;
        } else {
            String tmp = Arrays.toString(arr);
            Arrays.sort(arr);
            String min = Integer.toString(arr[0]);
            tmp = tmp.replaceAll("]", ", ");
            tmp = tmp.replaceAll(", "+min+", ",", ");
            tmp = tmp.replaceAll("\\[", "");
            return Stream.of(tmp.split(", ")).mapToInt(Integer::parseInt).toArray();
        }
    }

    //여러줄 -tab : shift+tap
    public static void main(String[] args) {
        /*
        System.out.println(solution2(45));
        System.out.println(solution3("12345"));
        System.out.println(solution4(-5,0));
        System.out.println(solution5(3));
        System.out.println(solution6("89425"));
        int c[]={1,2,3,4};
        int d[]={-3,-1,0,2};
        System.out.println(solution7(c,d));
        System.out.println(solution8(12));
        System.out.println(solution9("  try  hello world   aVCde    a"));
        System.out.println(solution9_nam("  try  hello world   aVCde    a"));
        System.out.println(solution10(123));
        //System.out.println(solution11(1234));
        System.out.println(solution12(121));
        int[] arr ={1,2,3,4};
        System.out.println(solution13(arr));
        System.out.println(solution14(626331));
        System.out.println(solution15(13));
        System.out.println(solution16("4444"));

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        String answer = "*";
        for(int i=1;i<a;i++)
            answer+="*";
        for(int j=0;j<b;j++)
            System.out.println(answer);


        int[] nums={1,2,7,6,4};
        System.out.println(solution18(nums));

        int[][] board={{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println("19 "+solution19(board,moves));

        int[] array={1, 5, 2, 6, 3, 7, 4};
        int[][] commanders ={{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        System.out.println(Arrays.toString(solution21(array, commanders)));
        */
        int[] arr22 = {4,4,4,3,3};
        System.out.println("sol22: "+Arrays.toString(solution22(arr22)));

        String[] participant={"mislav", "stanko", "mislav", "ana"};
        String[] completion={"stanko", "ana", "mislav"};
        System.out.println("sol23: "+(solution23(participant,completion)));

        int[] arr = {-4};
        //System.out.println("흠"+('0'-(-1)));
        System.out.println("sol24: "+(Arrays.toString(solution24(arr))));


    }

}

