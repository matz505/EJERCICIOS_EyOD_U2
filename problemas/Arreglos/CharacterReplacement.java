import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class CharacterReplacement {
    String s;
    int k;
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
            // Leemos una línea que contenga la cadena y k separados por espacio, por ejemplo: ABAB 2
            String line = br.readLine();
            if (line != null && !line.trim().isEmpty()) {
                StringTokenizer st = new StringTokenizer(line);
                s = st.nextToken();
                k = Integer.parseInt(st.nextToken());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void resuelve() {
    if (s == null) return;
        
        int[] count = new int[26]; // Frecuencia de letras de la 'A' a la 'Z'
        int left = 0;
        int maxLen = 0;
        int maxCount = 0; // Frecuencia del carácter más repetido en la ventana actual
        
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            count[c - 'A']++;
            
            // Actualizamos el carácter más frecuente en la ventana
            maxCount = Math.max(maxCount, count[c - 'A']);
            
            // Si el tamaño de la ventana menos el carácter más frecuente es mayor que k, 
            // la ventana es inválida y debemos encogerla por la izquierda.
            int windowSize = right - left + 1;
            if (windowSize - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            
            // Actualizamos la longitud máxima encontrada
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        System.out.println(maxLen);
    }

    public static void main(String[] args) {
        CharacterReplacement id  = new CharacterReplacement();

        id.leerDatos();
        id.resuelve();
    }   
}
