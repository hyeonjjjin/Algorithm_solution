import java.util.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.TreeSet;

class Solution {
        public int[] solution(int[] numbers) {
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
}

