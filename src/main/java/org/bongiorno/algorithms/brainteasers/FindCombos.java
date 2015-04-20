package org.bongiorno.algorithms.brainteasers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author chribong
 */
public class FindCombos {


    static List<Integer> permuteSum(List<Integer> numbers, int target, List<Integer> partial) {

        int s = partial.stream().reduce(0, (a, b) -> a + b);

        if (s == target)
            return partial;
        if (s >= target)
            return Collections.emptyList();

        for (int i = 0; i < numbers.size(); i++) {

            int n = numbers.get(i);
            List<Integer> remaining = numbers.subList(i+1,numbers.size());

            partial.add(n);
            List<Integer> integers = permuteSum(remaining, target, partial);
            if(integers != null && integers.size() > 0)
                System.out.println(integers);

            partial.remove(partial.size() - 1);
        }
        return null;
    }

    public static void main(String args[]) {
        Integer[] numbers = {3, 9, 8, 4, 5, 7, 10};
        int target = 15;
        permuteSum(Arrays.asList(numbers), target, new ArrayList<>());
    }


}
