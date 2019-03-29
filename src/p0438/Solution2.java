package p0438;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Wang Yunfei
 * Date: 2019/3/29 下午9:55
 * Description:
 */


public class Solution2 {

    // 滑动窗口思路只要控制窗口和 p 串长度一致即可
    public List<Integer> findAnagrams(String s, String p) {
        int left = 0;
        int right = 0;
        int[] dict = new int[256];
        List<Integer> list = new ArrayList<Integer>();
        int count = 0;
        int cCount = 0;
        int min = p.length();
        for (char c : p.toCharArray()) {
            dict[c]++;
        }

        for (char c = 0; c < 256; c++) {
            if (dict[c] > 0) {
                cCount++;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            right = i;
            char c = s.charAt(i);
            dict[c]--;
            if (dict[c] == 0) {
                count++;
            }

            if (count < cCount) {
                continue;
            }

            while (count >= cCount) {
                if (right - left + 1 == min) {
                    list.add(left);
                }
                char cl = s.charAt(left);
                dict[cl]++;
                if (dict[cl] > 0) {
                    count--;
                }
                left++;
            }

        }
        return list;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        String s = "abab";
        String p = "ab";
        List list;
        list = solution1.findAnagrams(s, p);
        System.out.println(list);
    }
}