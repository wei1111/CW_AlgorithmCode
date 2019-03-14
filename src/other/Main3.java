package other;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int[][] arr = new int[n][2];
        TreeMap<Integer, Integer> map2 = new TreeMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            min = Math.min(min, arr[i][0]);
            max = Math.min(max, arr[i][0]);
            map2.put(arr[i][0], arr[i][1]);
        }
        int m = max - min;
        if (m < d) {
            System.out.println(0);
        } else {
            max = Integer.MIN_VALUE;
            Set<Integer> set = map2.keySet();
            Object[] objects = set.toArray();
            for (int j = 0; j < n; j++) {
                for (int i = j + 1; i < n; i++) {
                    if ((Integer) objects[i] - (Integer) objects[j] >= d) {
                        max = Math.max(max, map2.get((Integer) objects[i]) + map2.get((Integer)
                                objects[j]));
                    }
                }
            }
            System.out.println(max);
        }

    }
}
