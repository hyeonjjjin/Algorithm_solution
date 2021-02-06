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
        List<Integer> num = new ArrayList<>();
        int answer = 0;
        while(n/3>=1) {
            num.add(n % 3);
            n/=3;
        }
        num.add(n);
        for (int i=0;i<num.size();i++){
            answer+=(num.get(i))*Math.pow(3, num.size()-i-1);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution2(45));
    }
}

