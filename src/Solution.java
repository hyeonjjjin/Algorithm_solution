import org.w3c.dom.ranges.Range;

import java.util.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.TreeSet;

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
        //String answer = "";
        //return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution2(45));
        System.out.println(solution3("12345"));


    }
}

