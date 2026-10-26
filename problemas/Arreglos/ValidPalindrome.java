
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ValidPalindrome {

    String s;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    FastReader reader = new FastReader();

    static class FastReader {
        // BufferedReader to read input
        BufferedReader b;
        // StringTokenizer to tokenize input
        StringTokenizer s; 

        // Constructor to initialize BufferedReader
        public FastReader() {
            b = new BufferedReader(new InputStreamReader(System.in));
        }

        // Method to read the next token as a string
        String next() {
            while (s == null || !s.hasMoreElements()) {
                try {
                    s = new StringTokenizer(b.readLine());
                } catch (IOException e) {
                    e.printStackTrace(); 
                }
            }
            return s.nextToken();
        }

        // Method to read the next token as an integer
        int nextInt() { 
                return Integer.parseInt(next()); 
        }

        // Method to read Char
        char nextChar() {
            return next().charAt(0);
        }

        // Method to read the next token as a long
        long nextLong() { 
            return Long.parseLong(next()); 
        }

        // Method to read the next token as a double
        double nextDouble() { 
            return Double.parseDouble(next()); 
        }

        // Method to read the next line as a string
        String nextLine() {
            String str = "";
            try {
                if (s.hasMoreTokens()) {
                    str = s.nextToken("\n");
                } else {
                    str = b.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace(); 
            }
            return str;
        }
    }
    public void leerDatos() {
        try {
            s = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void resuelve() {
        if (s == null) return;
        int left = 0;
        int right = s.length() - 1;
        boolean esPalindromo = true;

        while (left < right) {
            char cLeft = s.charAt(left);
            char cRight = s.charAt(right);

            if (!Character.isLetterOrDigit(cLeft)) {
                left++;
            } else if (!Character.isLetterOrDigit(cRight)) {
                right--;
            } else {
                if (Character.toLowerCase(cLeft) != Character.toLowerCase(cRight)) {
                    esPalindromo = false;
                    break;
                }
                left++;
                right--;
            }
        }

        System.out.println(esPalindromo ? "true" : "false");
    }

    public static void main(String[] args) {
        ValidPalindrome app = new ValidPalindrome();
        app.leerDatos();
        app.resuelve();
    }
}