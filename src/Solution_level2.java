import java.lang.Math;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList; //import
import java.util.Queue; //import

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

    public static int MCT_April_1(int[] absolutes, boolean[] signs){
        int answer=0;
        for(int i=0;i<absolutes.length;i++){
            if(signs[i]) answer+=absolutes[i];
            else answer-= absolutes[i];
        }
        return answer;
    }

    public static boolean CheckCorrect(String s){
        int small=0, mid=0, big=0;
        char tmp=' ';
        for(int i=0;i<s.length();i++){
            tmp=s.charAt(i);
            switch (tmp){
                case '(': small+=1;break;
                case ')': small-=1;if (small < 0) return false; break;
                case '{': mid +=1;break;
                case '}': mid -=1;if (mid < 0) return false;break;
                case '[': big +=1;break;
                case ']': big -=1;if (big < 0) return false;break;
            }
        }
        if((small ==0) && ((mid ==0) && (big==0))) return true;
        else return false;
    }

    public static int MCT_April_2(String s) {
        int answer =0;
        for(int i=0;i<s.length();i++){
            if(CheckCorrect(s)) answer+=1 ;
            if(i < s.length()-1)
                s = s.substring(1,s.length())+ s.charAt(0);
        }

        return answer;
    }

    public static long MCT_April_3(int[] a, int[][] edges) {
        long answer=0;
        if(Arrays.stream(a).sum()!=0) return -1;
        int u=0, v=0;
        boolean after_u =false, after_v =false;
        for(int i=0;i<edges.length;i++){
            u=edges[i][0];v=edges[i][1];
            for (int j = i + 1; j < edges.length; j++) {

                if (u == edges[j][0] || u == edges[j][1]) {
                    after_u = true;
                    break;
                }
                if (v == edges[j][0] || v == edges[j][1]) {
                    after_v = true;
                    break;
                }
            }
            if (after_u) {
                a[u] += a[v];
                answer+=a[v];
                a[v] = 0;

            }
            else if(after_v) {
                a[v] += a[u];
                answer+=a[u];
                a[u] = 0;
            }
            after_u=after_v=false;
        }
        answer += Math.abs(a[u]);
        return answer;
    }


        public static void main(String[] args) {
//        System.out.println(solutionL2_1(8, 12));
//        System.out.println(solutionL2_2(10));
//        System.out.println(solutionL2_2_reverse(14));
//        int[] prices = {1, 2, 3, 2, 3};
//        System.out.println(solutionL2_3(prices));
//        int[] A = {1, 2};
//        int[] B = {3, 4};
//        System.out.println(solutionL2_5(A, B));
//        System.out.println(solutionL2_6(24, 24));
//        int[] priorities = {9, 7, 1, 2, 1, 5};
//        System.out.println("7: " + solutionL2_7(priorities, 5));
//        System.out.println(solutionL2_8(88));
//        String s = "-1 -2 -3 -4";
//        System.out.println(solutionL2_9(s));
//        System.out.println(solutionL2_10(15));
//        System.out.println(new SolutionL2_11("()()()))((").solve());
//        int[] numbers = {6,10,2};
//        System.out.println(new SolutionL2_12(numbers).BigNum());
        int[] absolutes = {1,2,3};
        boolean[] signs = {false, false, true};
        System.out.println(MCT_April_1(absolutes, signs));

        String s = "}}}";
        System.out.println(MCT_April_2(s));

        int[] a = {-5,0,2,1,2};
        int[][] edges = {{0,1},{3,4},{2,3},{0,3}};
        System.out.println(MCT_April_3(a,edges));
        }
}
