package AtividadeB.Livraria;

public class Livro {
    private String titulo;
    private String autor;
    private double preco;
    private int qtdEstoque;

    public Livro() {
    }

    public Livro(String tituloLivro, String nomeDoAutor, Double preco, Integer qtdEstoque) {
        this.titulo = tituloLivro;
        this.autor = nomeDoAutor;
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
    }

    @Override
    public String toString() {
        return String.format("Título: %-13s | Autor: %-13s | Preço: R$ %6.2f | Estoque: %3d un.",
                titulo, autor, preco, qtdEstoque);
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Double getPreco() {
        return preco;
    }
    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQtdEstoque() {
        return qtdEstoque;
    }
    public void setQtdEstoque(Integer qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public void exibirDetalhes(){
        System.out.printf("Título: %s | Autor: %s | Preço: R$ %.2f | Estoque: %d un.%n", this.titulo, this.autor, this.preco, this.qtdEstoque);
    }
}
