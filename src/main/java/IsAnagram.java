import java.util.HashMap;
import java.util.Map;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> s_map = new HashMap<>();
        HashMap<Character, Integer> t_map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!s_map.containsKey(ch)) {
                s_map.put(ch, 1);
            } else {
                s_map.put(ch, s_map.get(ch) + 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (!t_map.containsKey(ch)) {
                t_map.put(ch, 1);
            } else {
                t_map.put(ch, t_map.get(ch) + 1);
            }
        }

        if (s_map.size() != t_map.size()) {
            return false;
        }

        for (Map.Entry<Character, Integer> entry : s_map.entrySet()) {
            if (!t_map.containsKey(entry.getKey())) {
                return false;
            } else if (!t_map.get(entry.getKey()).equals(entry.getValue())) {
                return false;
            }
        }
        return true;
    }
}