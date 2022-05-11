public class BackspaceCompare {
    public boolean backspaceCompare(String s, String t) {
        return (getString(s).equals(getString(t)));
    }

    private String getString(String s) {
        StringBuilder str = new StringBuilder();
        int slowIndex = 0;//快慢指针
        for (int fastIndex = 0; fastIndex < s.length(); fastIndex++) {
            if (s.charAt(fastIndex) != '#') {
                str.append(s.charAt(fastIndex));
            } else if (str.length() > 0) {
                str.deleteCharAt(str.length() - 1);
            }
        }
        return str.toString();
    }


    public static void main(String[] args) {
        String s = "a#c";
        String t = "b#";
        BackspaceCompare backspaceCompare = new BackspaceCompare();
        System.out.println(backspaceCompare.backspaceCompare(s, t));
    }

}