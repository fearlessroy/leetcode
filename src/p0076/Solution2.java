package p0076;

/**
 * Created with IntelliJ IDEA.
 * User: Wang Yunfei
 * Date: 2019/3/28 下午7:30
 * Description:
 */
public class Solution2 {


    public String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        int min = s.length();
        String ans = "";
        int count = 0;
        int cCount = 0;
        int[] dict = new int[256];
        for (char c : t.toCharArray()) {
            dict[c]++;
        }


        for (char c = 0; c < 256; c++) {
            if (dict[c] > 0) {
                cCount++;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            right = i;
            char c = s.charAt(right);
            dict[c]--;
            if (dict[c] == 0) {
                count++;
            }

            if (count < cCount) {
                continue;
            }

            while (count >= cCount) {
                if (right - left + 1 <= min) {
                    String fit = s.substring(left, right + 1);
                    ans = fit;
                    min = right - left + 1;
                }
                char cl = s.charAt(left);
                left++;
                dict[cl]++;
                if (dict[cl] > 0) {
                        count--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        Solution2 s2 = new Solution2();
        String ans = s2.minWindow(s,t);
        System.out.println(ans);
    }
}