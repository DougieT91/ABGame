package abgame;

import java.util.Scanner;

/**
 * Created by tmuringani on 7/11/17.
 */
class ABBADiv1 {

    String s;

    public static void main(String args[]) throws Exception{
        ABBADiv1 A = new ABBADiv1();
        Scanner sc = new Scanner(System.in);
        System.out.println(A.canObtain(sc.next(), sc.next()));
        sc.close();
    }

    public String canObtain(String initial, String target) {
        s = initial;
        return go(new StringBuilder(target)) ? "Possible" : "Impossible";
    }

    public boolean go(StringBuilder t){
        int n = s.length();
        int m = t.length();
        if(m < n)
            return false;
        if(m == n)
            return t.toString().equals(s);
        if(t.charAt(0) == 'A'){
            for(int i=0;i<n;i++)
                if(s.charAt(i) != t.charAt(i))
                    return false;
            for(int i=n;i<m;i++)
                if(t.charAt(i) != 'A')
                    return false;
            return true;
        }
        else{
            boolean isNow = true;
            for(int i=0;i<n;i++)
                if(s.charAt(i) != t.charAt(i))
                    isNow = false;
            for(int i=n;i<m;i++)
                if(t.charAt(i) != 'A')
                    isNow = false;
            if(isNow)
                return true;
            t.deleteCharAt(0);
            t.reverse();
            boolean ans = go(t);
            while(!ans && t.length() > n && t.charAt(0) == 'A'){
                t.deleteCharAt(0);
                ans |= go(t);
            }
            return ans;
        }
    }

}