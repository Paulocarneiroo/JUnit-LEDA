import java.util.Random;

public class Main {
    private static final Random random = new Random();
    public static void main(String[] args) {
        Filme[] filmes1000 = createArray(1000);
        Filme[] filmes10000 = createArray(10000);
        Filme[] filmes100000 = createArray(1000000);

        for (Filme f : filmes1000) {
            System.out.println(f);
        }
    }
    private static Filme[] createArray(int n){
        Filme[] filmes = new Filme[n];
        for (int i = 0; i < filmes.length; i++) {
            String nome = generateRandomString(random, 8);  // Gera um nome aleatório com 8 caracteres
            int nota = random.nextInt(6);  // Gera uma nota entre 0 e 5
            int ano = random.nextInt(2023 - 1980 + 1) + 1980;  // Gera um ano entre 1980 e 2023
            filmes[i] = new Filme(nome, nota, ano);
        }
        return filmes;
    }
    private static String generateRandomString(Random random, int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
    }
}
