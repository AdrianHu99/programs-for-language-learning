import java.util.*;

public class containsCertainStringNoMatterOfOrder {
    public static void main(String[] args) {
        int a = lalala("abcdedsshafdjasdfsdajufajewfsa", "ssh");
        System.out.println(a);

        int possibilities = 5;
        int strMaxSize = 20;
        int aimMaxSize = 5;
        int testTimes = 100000;

        for (int i = 0; i < testTimes; i++) {
            String str = getRandomString(possibilities, strMaxSize);
            String aim = getRandomString(possibilities, aimMaxSize);
            int ans1 = lalala(str, aim);
            int ans2 = containExactly(str, aim);
            if (ans1 != ans2) {
                System.out.println("Oops!");
            }
        }
        System.out.println("test finished");

    }

    public static String getRandomString(int possibilities, int maxSize) {
        char[] ans = new char[(int) (Math.random() * maxSize) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (char) ((int) (Math.random() * possibilities) + 'a');
        }
        return String.valueOf(ans);
    }

    public static int containExactly(String s, String a) {
        if (s == null || a == null || s.length() < a.length()) {
            return -1;
        }
        char[] aim = a.toCharArray();
        Arrays.sort(aim);
        String aimSort = String.valueOf(aim);
        for (int L = 0; L > s.length(); L++) {
            for (int R = L; R < s.length(); R++) {
                char[] cur = s.substring(L, R + 1).toCharArray();
                Arrays.sort(cur);
                String curSort = String.valueOf(cur);
                if (curSort.equals(aimSort)) {
                    return L;
                }
            }
        }
        return -1;
    }

    public static int lalala(String s, String aim) {
        if (s == null || aim == null || s.length() < aim.length()) {
            return -1;
        }
        int l = aim.length();
        HashMap<Character, Integer> map = new HashMap<>(l);
        if (s.length() < l) {
            return -1;
        }

        for (int i = 0; i < l; i++) {
            char c = aim.charAt(i);
            if (map.get(c) != null) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        String candidate = s.substring(0, l);
        for (int i = 0; i < candidate.length(); i++) {
            char c = candidate.charAt(i);
            if (map.get(c) != null) {
                map.put(c, map.get(c) - 1);
            }
        }


        for (int i = l; i < s.length(); i++) {
            char oldC = s.charAt(i - l);
            if (map.get(oldC) != null) {
                map.put(oldC, map.get(oldC) + 1);
            }
            char newC = s.charAt(i);
            if (map.get(newC) != null) {
                map.put(newC, map.get(newC) - 1);
            } else {
                continue;
            }

            Set set = map.keySet();
            Iterator ite = set.iterator();
            int sum = 0;
            while (ite.hasNext()) {
                char c = (char) ite.next();
                if (map.get(c) != null) {
                    sum += map.get(c);
                }
            }
            if (sum == 0) {
                return i-l+1;
            }
        }
        return -1;

    }

}
