import java.lang.Math;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList; //import
import java.util.Queue; //import
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution_level2{

    //멀쩡한 사각형 >> 블로그 O +12
    public static long solutionL2_1(int w, int h) {
        BigInteger bi1 = new BigInteger(Integer.toString(w));
        BigInteger bi2 = new BigInteger(Integer.toString(h));
        int gcd = Integer.parseInt("" + bi1.gcd(bi2));
        return (long) w * h - (long) ((w / gcd) + (h / gcd) - 1) * gcd;
    }

    //124 나라의 숫자 >> 블로그 O +8
    public static String solutionL2_2(int n) {
        StringBuffer answer = new StringBuffer();
        while (Math.ceil((double) n / 3) > 0) {
            if (n % 3 == 0) {
                answer.append(Integer.toString(4));
                n = n / 3 - 1;
            } else {
                answer.append(Integer.toString(n % 3));
                n /= 3;
            }
        }
        return answer.reverse().toString().replaceAll("3", "4");
    }

    public static String solutionL2_2_reverse(int n) {
        String[] fourToThree = (Integer.toString(n)).replaceAll("4", "3").split("");
        int digit = fourToThree.length - 1;
        int answer = 0;
        for (String s : fourToThree) {
            answer += (int) (Math.pow(3, digit--) * Integer.parseInt(s));
        }
        return Integer.toString(answer);
    }

    //주식 가격 >> 블로그 XX
    public static int[] solutionL2_3(int[] prices) {
        int[] answer = {};
        return answer;
    }

    //올바른 괄호 >> 블로그 O +7
    public static boolean solutionL2_4(String s) {
        int check = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') check++;
            else check--;
            if (check < 0) return false;
        }
        if (check == 0) return true;
        else return false;
    }

    //최솟값 만들기 >> 블로그 XX +4
    public static int solutionL2_5(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int len = A.length;
        for (int i = 0; i < len; i++)
            answer += A[i] * B[len - i - 1];
        return answer;
    }

    //카펫 >> 블로그 XX +4
    public static boolean CheckBrown(int x, int y, int brown) {
        return ((2 * (x + y) + 4) == brown);
    }
    public static int[] solutionL2_6(int brown, int yellow) {
        int[] answer = new int[2];
        for (int x = 1; x <= (int) Math.sqrt(yellow); x++) {
            if (((yellow / x) == (double) yellow / x) && CheckBrown(x, yellow / x, brown)) {
                answer[0] = yellow / x + 2;
                answer[1] = x + 2;
                break;
            }
        }
        return answer;
    }

    // 프린터 >> 블로그 XX +6
    public static int solutionL2_7(int[] priorities, int location) {
        Queue<Integer> queue = new LinkedList<>(); //int형 queue 선언, linkedlist 이용
        int temp = 0, max = 0, rest = priorities.length, times = 0, location_now = location;

        // 그대로 넣는건 얕은복사(Shallow Copy) 한 쪽 값이 바뀔 때 같이 바뀜.
        //clone 함수를 이용하는건 깊은복사(Deep Copy) 두 값이 서로 영향 X
        int[] temp_priorities = priorities.clone();
        //최댓값 찾기 위함
        Arrays.sort(temp_priorities);
        max = temp_priorities[rest - 1];

        //주어진 자료 큐에 저장
        for (int i = 0; i < priorities.length; i++) queue.add(priorities[i]);

        while (rest > 0) {
            temp = queue.poll();
            //꺼내보니 우선순위 1등이다? 그러면 얘가 목표했던 앤지 확인해야지
            if (temp == max) {
                times++;
                if (location_now == 0) return times;

                location_now--;
                rest--;
                if (rest - 1 >= 0) max = temp_priorities[rest - 1];
            }
            //꺼냈는데 우선순위 1등이 아니면 다시 뒤에 넣어야지 근데 내가 목표했던 애면 location_now 재설정
            else {
                if (location_now == 0) location_now = rest - 1;
                else location_now--;
                queue.add(temp);
            }
        }
        return 0;
    }

    //피보나치 수 >> 블로그 XX +10
    public static int fibonacci(int fn_1, int fn_2, int n) {
        if (fn_1 + fn_2 >= 9999999) {
            fn_1 %= 1234567;
            fn_2 %= 1234567;
        }
        if (n <= 2) return fn_1 + fn_2;
        else return fibonacci(fn_2, fn_1 + fn_2, n - 1);
    }

    public static int solutionL2_8(int n) {
        return fibonacci(0, 1, n);
    }

    //최댓값과 최솟값 >> 블로그 XX +2
    public static String solutionL2_9(String s) {
        String[] ss = s.split(" ");
        int temp, max = Integer.parseInt(ss[0]), min = Integer.parseInt(ss[0]);
        for (String n : ss) {
            temp = Integer.parseInt(n);
            max = Math.max(temp, max);
            min = Math.min(min, temp);
        }
        return min + " " + max;
    }

    // 숫자의 표현 >> 블로그 XX +7
    public static int ContinuousNum(int sum, int end, int n) {
        if ((sum + end) < n) return ContinuousNum(sum + end, end + 1, n);
        else if ((sum + end) == n) return 1;
        else return 0;
    }
    public static int solutionL2_10(int n) {
        int answer = 1;
        //시작 지점은 n/2까지 왜냐면 그이상은 더하면 n보다 크니까
        for (int start = 1; start <= n / 2; start++) {
            answer += ContinuousNum(start, start + 1, n);
        }
        return answer;
    }

    //행렬의 곱셈 >> 블로그 XX  devide & conquer 라는 알고리즘이 있다고..? 재ㅣ시도..
    public static int[][] solutionL2_15(int[][] arr1, int[][] arr2){
        /*
        int[][] answer= new int[arr1.length][arr1[0].length];

        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr1[0].length ;j++){
                answer[i][j]=arr1[i][0]*arr2[0][j];
                for(int k=1;(k)<arr1[0].length;k++){
                    answer[i][j]+=arr1[i][k]*arr2[k][j];
                }
            }
        }
        */
        int[][] answer = new int[0][];
        return answer;
    }

    //영어 끝말잇기 >> 블로그 XX +5
    public static int[] solutionL2_16(int n, String[] words) {
        int[] answer = new int[2];
        ArrayList<String> check = new ArrayList<>();
        char last=' ';
        int index=0;
        for(String word: words){
            if(((index!=0)&&(last != word.charAt(0)))||check.contains(word) || word.length()==1){
                answer[0]= index%n+1;
                answer[1]= index/n+1;
                return answer;
            }
            check.add(word);
            last = word.charAt(word.length()-1);
            index++;
        }
        answer[0]=0; answer[1]=0;
        return answer;
    }

    //가장 큰 정사각형 찾기 >> 블로그 XX
    public int solutionL2_17(int[][] board){
        //정사각형이라..
        //가로로 한개~max 각각 정사각형이 되는지 확인?
        //만약 가로 5개짜리 정사각형을 확인한다면 아래로 5줄 각각 1이 연속 5개 있으며 start 지점이 같은지 확인
        //max~1 순서대로 확인하는게 빠르겠지.. 세로 남은 길이가 가로 길이보다 작으면 그 가로길이는 체크 없이 포기

        return 0;
    }


    public static boolean solutionL2_18(String[] phone_book) {
        String numAll = Arrays.toString(phone_book).replace("[", ", ");
        for(String phoneNum:phone_book){
            Pattern pattern = Pattern.compile(", "+phoneNum);
            Matcher matcher = pattern.matcher(numAll);
            if( matcher.results().count()>1) return false;
        }
        return true;
    }

    //짝지어 제거하기 >> 블로그XX
    public static int solutionL2_19(String s) {
        //baabaa cacaa 같은 알파벳이 두 개 , 사이에 지울 수 있다면 ???? 그냥 앞-끝 확인하는게 맞지 않나... stack?
        // stack에 넣고 겹치면 pop , stack에 담긴건 다시 앞에 붙이고? 이건 별로..
        // 반복되는걸 확인할 함수는 없나..
        int flag = 1;
        while (s.length() > 0 && flag>0) {
            flag=0;
            char last = s.charAt(0);
            int start = 0;
            boolean canRemove = false;
            for (int i = 1; i < s.length(); i++) {
                System.out.println(s);
                if (last != s.charAt(i)) {
                    if (canRemove) {
                        s = s.substring(0, start) + s.substring(i);
                        i = s.length();
                        flag=1;
                    } else start = i;
                    //
                } else if (last == s.charAt(i)) canRemove = true;
                if (i != s.length()) last = s.charAt(i);
                if (i == (s.length() - 1) && canRemove) {
                    s = s.substring(0, start) + s.substring(i+1);
                }
            }
            System.out.println(s);
        }
        if(s.length()==0) return 1;
        else return 0;
    }

    public static void main(String[] args) {

    String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
    System.out.println("16: "+Arrays.toString(solutionL2_16(2, words)));

    String[] phone_book = {"0"};
    System.out.println("18: "+solutionL2_18(phone_book));

    System.out.println("19:"+ solutionL2_19("cdcd"));
    }
}
