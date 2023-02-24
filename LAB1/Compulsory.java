package LAB1;

public class Compulsory {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        for (int i = 0; i < languages.length; i++) {
            System.out.print(languages[i] + " ");
        }

        int n = (int) (Math.random() * 1_000_000);
        System.out.println(n);

        n = n * 3;
        n = n + Integer.parseInt("10101", 2);
        n = n + Integer.parseInt("FF", 16);
        n = n * 6;
        System.out.println(n);

        int s = 0;
        int result = 0;
        do {
            while(n != 0) {
                s = s + n % 10;
                n = n / 10;
            }
            n = s;
            result = s;
            s = 0;
        }while(result >= 10);

        n = result;
        System.out.println(n);

        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);
    }
}

