package AtividadeB.Livraria;

import java.util.ArrayList;
import java.util.List;

public class LivrariaService {
    private List<Livro> acervo = new ArrayList<>();

    public void cadastrarLivro(Livro livro) {
        acervo.add(livro);
    }

    public List<Livro> listarTodos() {
        return acervo;
    }

    public List<Livro> burcarPorTermo(String termo) {
        List<Livro> resultados = new ArrayList<>();
        String termoMinusculo = termo.toLowerCase();

        for (Livro livro : acervo) {
            if (livro.getTitulo().toLowerCase().contains(termoMinusculo) || livro.getAutor().toLowerCase().contains(termoMinusculo)) {
                resultados.add(livro);
            }
        }
        return resultados;
    }

    public Livro buscarPorTituloExato(String titulo) {
        for (Livro livro : acervo) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }
}
