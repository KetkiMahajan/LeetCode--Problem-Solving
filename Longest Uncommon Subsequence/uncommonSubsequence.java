public class uncommonSubsequence {

    public static void main(String[] args) {
        String a = "abc";
        String b = "abcr";
        int ans = findLUSlength(a, b);
        System.out.println(ans);
        String c = reverseString(a);
        System.out.println(c);
    }

    public static int findLUSlength(String a, String b) {

        if (a.equals(b))
            return -1;
        else {
            if (a.length() > b.length())
                return a.length();
            else
                return b.length();
        }

    }

    public static String reverseString(String ss) {
        char[] leters = ss.toCharArray();
        int i = 0;
        int j = ss.length() - 1;
        while (i < j) {
            char temp = leters[i];
            leters[i] = leters[j];
            leters[j] = temp;
            i++;
            j--;
        }
        ss = new String(leters);
        return ss;
    }
}
