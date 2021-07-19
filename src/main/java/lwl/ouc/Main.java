package lwl.ouc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        System.out.println(sum());
    }
    public static int sum() {
        int sum = 0;
        int m = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            m = scanner.nextInt();
            TreeSet<Integer> inputs = new TreeSet<>();
            int i = 0;
            int n = 0;
            while (scanner.hasNext()) {
                if (i == m) {
                    n = scanner.nextInt();
                    break;
                } else {
                    inputs.add(scanner.nextInt());
                }
                i++;
            }
            
            if (inputs.last() > 1000) {
                return -1;
            }
            
            List<Integer> inputs2 = new ArrayList<>(inputs);
            
            if (0 < n) {
                List<Integer> mins = inputs2.subList(0, n);
                List<Integer> maxs = inputs2.subList(inputs.size() - n, inputs.size());

                boolean hasOverRide = false;
                for (Integer minInt : mins) {
                    if (maxs.contains(minInt)) {
                        hasOverRide = true;
                        break;
                    }
                }
                for (Integer manxInt : maxs) {
                    if (mins.contains(manxInt)) {
                        hasOverRide = true;
                        break;
                    }
                }
                if (hasOverRide) {
                    return -1;
                }

                int minSum = 0;
                for (Integer integer : mins) {
                    minSum += integer;
                }
                int maxSum = 0;
                for (Integer integer : maxs) {
                    maxSum += integer;
                }
                sum = minSum + maxSum;
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
        return sum;
    }
    
    public static void sort(){
        Scanner scanner = new Scanner(System.in);
        try {
            String inputStr = "";
            while (scanner.hasNext()) {
                inputStr = scanner.next();
                break;
            }
            Arrays.sort(inputStr.toCharArray());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
