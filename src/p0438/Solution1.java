package p0438;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Wang Yunfei
 * Date: 2019/3/29 下午9:31
 * Description:
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * 输入：s: "cbaebabacd" p: "abc"
 * 输出：[0, 6]
 */


public class Solution1 {

    // 固定窗口
    public List<Integer> findAnagrams(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();
        List<Integer> list = new ArrayList<Integer>();

        if (pLength > sLength) {
            return list;
        }

        int count = 0;
        int pCount = 0;


        int[] dict = new int[256];

        for (int i = 0; i < pLength; i++) {
            char c = p.charAt(i);
            dict[c]++;
        }

        for (char c = 0; c < 256; c++) {
            if (dict[c] > 0) {
                pCount++;
            }
        }

        // 固定窗口前 pLength - 1 个元素进行处理，与下面的循环对应
        for (int i = 0; i < pLength - 1; i++) {
            char cr = s.charAt(i);
            dict[cr]--;
            if (dict[cr] == 0) {
                count++;
            }
        }

        int i = 0;
        // i 为固定窗口 左指针
        for (i = 0; i < sLength - pLength + 1; i++) {
            // right 直接跳过前 pLength - 1，与上面的循环对应
            int right = i + pLength - 1;
            char cr = s.charAt(right);
            dict[cr]--;
            if (dict[cr] == 0) {
                count++;
            }

            if (count == pCount) {
                list.add(i);
            }

            char cl = s.charAt(i);
            dict[cl]++;
            if (dict[cl] == 1) {
                count--;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        String s = "cbaebabacd";
        String p = "abc";
        List list;
        list = solution1.findAnagrams(s, p);
        System.out.println(list);

        s = "aaaaaaaaaaa";
        p = "aaaaaaaaaaaaaa";
        list = solution1.findAnagrams(s, p);
        System.out.println(list);
    }
}