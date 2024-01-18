package Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Divisor {
    public static void main(String[] args) {
        int number = 15;
        System.out.println(countDivisors(number));
        System.out.println(listOfDivisors(number));
    }

    private static int countDivisors(int number) {
        int count = 0;
        for (int i = 1; i * i <= number; i++) {
            if (i * i == number) {
                count++;
            } else if (number % i == 0) {
                count += 2;
            }
        }
        return count;
    }

    private static List<Integer> listOfDivisors(int number) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i * i <= number; i++) {
            if (i * i == number) {
                list.add(i);
            } else if (number % i == 0) {
                list.add(i);
                list.add(number / i);
            }
        }
        Collections.sort(list);
        return list;
    }
}
