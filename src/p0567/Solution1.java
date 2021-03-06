package p0567;

/**
 * Created with IntelliJ IDEA.
 * User: Wang Yunfei
 * Date: 2019/3/30 上午11:02
 * Description:
 * <p>
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 */


public class Solution1 {

    public boolean checkInclusion(String s1, String s2) {
        int left = 0;
        int right = 0;
        int s2Length = s2.length();
        int[] dict = new int[256];
        int count = 0;
        int cCount = 0;
        boolean flag = false;
        for (char c : s1.toCharArray()) {
            dict[c]++;
        }

        for (char c = 0; c < 256; c++) {
            if (dict[c] > 0) {
                cCount++;
            }
        }
        for (int i = 0; i < s2Length; i++) {
            right = i;
            char c = s2.charAt(right);
            dict[c]--;
            if (dict[c] == 0) {
                count++;
            }

            if (count < cCount) {
                continue;
            }

            while (count >= cCount) {
                if (right - left + 1 == s1.length()) {
                    flag = true;
                    break;
                }
                char cl = s2.charAt(left);
                dict[cl]++;
                if (dict[cl] > 0) {
                    count--;
                }
                left++;
            }
            if (flag) {
                break;
            }
        }
        return flag;
    }


    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        Solution1 solution1 = new Solution1();
        boolean flag = solution1.checkInclusion(s1, s2);
        System.out.println(flag);
    }

}