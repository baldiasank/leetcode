package org.example;

public class RotateString {

    public static void main(String[] args) {
        /*System.out.println(new RotateString().rotateString("abcde","cdeab"));
        System.out.println(new RotateString().rotateString("abcde","abced"));
        System.out.println(new RotateString().rotateString("bbbacddceeb","ceebbbbacdd"));*/
        System.out.println(new RotateString().rotateString("defdefdefabcabc","defdefabcabcdef"));
    }

    // 1st will find last character in s with goal
    // 2nd compare char in reverse order
    // This Solution is not working for 3rd usecase
    public boolean rotateStringWithLastChar(String s, String goal) {
        if (s.length() != goal.length()) return false;
        if (s.equals(goal)) return true;
        int i = 0;
        int gi = goal.length()-1;
        while (s.charAt(i) != goal.charAt(gi)){
            i++;
        }
        for (int j = i; j >= 0; j--) {
            if(s.charAt(j) != goal.charAt(gi--)) {
                return false;
            }
        }
        for(int j = s.length() - 1; j > i; j--){
            if(s.charAt(j) != goal.charAt(gi--)) {
                return false;
            }
        }
        return true;
    }

    // This Solution is not working for 4th usecase
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;

        int gi = 0;
        for (int i=0; i < s.length(); i++){
            if (s.charAt(i) == goal.charAt(gi)){
                gi++;
            } else {
                gi = 0;
            }
        }
        if (gi == 0) return false;
        int gil = gi;
        for(int i = 0; i < gi - s.length(); i++){
            if (s.charAt(i) != goal.charAt(gil++)) {
                return false;
            }
        }
        return true;
    }


}
