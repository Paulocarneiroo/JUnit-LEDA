public class Busca implements Busca_IF{

    @Override
    public boolean checaVetorOrdenado(Filme[] filmes) {
        for (int i = 1; i < filmes.length; i++)
            if (filmes[i - 1].compareTo(filmes[i]) > 0)
                return false;
        return true;
    }

    @Override
    public Filme buscaLinear_iterativa(Filme[] filmes, int nota) throws Exception {
        if (nota < 0 || nota > 5)
            throw new Exception("Nota fora do intervalo permitido.");

        for (Filme filme : filmes)
            if (filme.getNota() == nota)
                return filme;
        return null;
    }

    @Override
    public Filme buscaLinear_recursiva(Filme[] filmes, int nota) throws Exception {
        if (nota < 0 || nota > 5)
            throw new Exception("Nota fora do intervalo permitido.");

        return buscaLinear_recursivaAux(filmes, nota, 0);
    }

    private Filme buscaLinear_recursivaAux(Filme[] filmes, int nota, int index) throws Exception {
        if (index >= filmes.length)
            return null;

        if (filmes[index].getNota() == nota)
            return filmes[index];

        return buscaLinear_recursivaAux(filmes, nota, index + 1);
    }

    @Override
    public Filme buscaBinaria_iterativa(Filme[] filmes, int nota) throws Exception {
        if (nota < 0 || nota > 5)
            throw new Exception("Nota fora do intervalo permitido.");

        int esquerda = 0;
        int direita = filmes.length - 1;

        while (esquerda <= direita) {
            int meio = (esquerda + direita) / 2;

            if (filmes[meio].getNota() == nota) {
                return filmes[meio];
            } else if (filmes[meio].getNota() > nota) {
                direita = meio - 1;
            } else {
                esquerda = meio + 1;
            }
        }
        return null;
    }

    @Override
    public Filme buscaBinaria_recursiva(Filme[] filmes, int nota) throws Exception {
        if (nota < 0 || nota > 5)
            throw new Exception("Nota fora do intervalo permitido.");

        return buscaBinaria_recursivaAux(filmes, nota, 0, filmes.length - 1);
    }
    private Filme buscaBinaria_recursivaAux(Filme[] filmes, int nota, int esquerda, int direita) throws Exception {
        if (esquerda > direita)
            return null;

        int meio = (esquerda + direita) / 2;

        if (filmes[meio].getNota() == nota)
            return filmes[meio];
        else if (filmes[meio].getNota() > nota)
            return buscaBinaria_recursivaAux(filmes, nota, esquerda, meio - 1);
        else
            return buscaBinaria_recursivaAux(filmes, nota, meio + 1, direita);
    }

    //OPTIONAL
    @Override
    public Filme buscaLinear_iterativa_duasPontas(Filme[] filmes, int nota) throws Exception {
        return null;
    }
}
