import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<Character, Integer> ori = new HashMap<Character, Integer>();
    Map<Character, Integer> cnt = new HashMap<Character, Integer>();

    public String minWindow(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        int l = 0, r = -1, count = tLen;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        while (r < sLen) {
            r++;
            if (r < sLen && count != 0 && ori.containsKey(s.charAt(r))) {
                if (cnt.getOrDefault(s.charAt(r), 0) < ori.get(s.charAt(r))) {
                    count--;
                }
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            if (count == 0 && r < sLen) {
                while (true) {
                    if (cnt.getOrDefault(s.charAt(l), 0) == 0) {
                        l++;
                    } else if (cnt.get(s.charAt(l)) > ori.get(s.charAt(l))) {
                        cnt.put(s.charAt(l), cnt.get(s.charAt(l)) - 1);
                        l++;
                    } else {
                        break;
                    }
                }
                cnt.put(s.charAt(l), cnt.get(s.charAt(l)) - 1);
                count++;
                if (r - l < len) {
                    len = r - l;
                    ansL = l;
                    ansR = r+1;
                }
                l++;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }
}