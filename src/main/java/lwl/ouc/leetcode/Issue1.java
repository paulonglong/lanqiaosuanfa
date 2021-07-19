package lwl.ouc.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class Issue1 {
    public static void main(String[] args) {
        int[] datas = {3,4,5,6,7,8,9,19};
        int[] res = twoSum(datas, 10);
        System.out.println(Arrays.toString(res));
        int[] res2 = twoSum2(datas, 10);
        System.out.println(Arrays.toString(res2));
    }

    // 从第一个元素开始取得满足和为target的两个数
    public static int[] twoSum(int[] datas, int target){
        int[] res = new int[2];
        
        HashMap<Integer, Integer> elmIndexMap = new HashMap<Integer, Integer>();
        for (int i=0; i<datas.length; i++) {
            elmIndexMap.put(datas[i], i);
        }
        for (int i=0; i<datas.length; i++) {
            int left = target - datas[i];
            if (elmIndexMap.containsKey(left) && elmIndexMap.get(left) != i) {
                res[0] = i;
                res[1] = elmIndexMap.get(left);
                break;
            }
        }
        
        return res;
    }
    
    // 取得最早出现满足和为target的两个数
    public static int[] twoSum2(int[] datas, int target){
        int[] res = new int[2];
        
        HashMap<Integer, Integer> elmIndexMap = new HashMap<Integer, Integer>();
        for (int i=0; i<datas.length; i++) {
            int left = target - datas[i];
            if (elmIndexMap.containsKey(left)) {
                res[0] = elmIndexMap.get(left);
                res[1] = i;
                break;
            }
            elmIndexMap.put(datas[i], i);
        }
        
        return res;
    }
}
