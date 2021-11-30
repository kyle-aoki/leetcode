class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (str1.length() == str2.length()) {
            for (int i = 0; i < str1.length(); i++) {
                if (str1.charAt(i) != str2.charAt(i)) return "";
            }
            return str1;
        }
        
        String larger = str1.length() > str2.length() ? str1 : str2;
        String smaller = str1.length() < str2.length() ? str1 : str2;
        
        StringBuilder sb = new StringBuilder(smaller);
        
        for (int i = 0; i < smaller.length(); i++) {
            if (check(larger, sb.toString()) && check(smaller, sb.toString())) {
                return sb.toString();
            }
            sb.setLength(sb.length() - 1);
        }
        
        return "";
    }
    boolean check(String larger, String smaller) {
        if (larger.length() % smaller.length() != 0) return false;
        for (int i = 0; i < larger.length(); i++) {
            int rem = i % smaller.length();
            if (larger.charAt(i) != smaller.charAt(rem)) return false;
        }
        return true;
    }
}
