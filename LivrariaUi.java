package AtividadeB.Livraria;

import java.util.List;
import java.util.Scanner;

public class LivrariaUi {
    private LivrariaService livrariaService;
    private Scanner scannerNumero;
    private Scanner scannerTexto;

    public LivrariaUi() {
        this.livrariaService = new LivrariaService();
        this.scannerNumero = new Scanner(System.in);
        this.scannerTexto = new Scanner(System.in);
    }

    public void iniciar() {
        boolean rodando = true;

        while (rodando) {
            exibirMenu();
            String entrada = scannerTexto.nextLine();

            try {
                int opcao = Integer.parseInt(entrada);

                switch (opcao) {
                    case 1 -> fluxoAdicionarLivro();
                    case 2 -> fluxoExibirLivros();
                    case 3 -> fluxoBuscarLivro();
                    case 4 -> fluxoEditarLivro();
                    case 5 -> {
                        System.out.println("\n -> Encerrando o sistema. Até logo!");
                        rodando = false;
                    }
                    default -> System.out.println(" ->ERRO: Opção inválida! Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println(" ->ERRO: Por Favor, digite um número válido.");
            }
        }
    }

        private void exibirMenu(){
            String menu = """
                    
                    =================================================
                    📚            SISTEMA DE LIVRARIA              📚
                    =================================================
                    [1] -> Cadastrar novo livro
                    [2] -> Exibir acervo completo
                    [3] -> Buscar livro (Título ou Autor)
                    [4] -> Atualizar dados de um livro
                    [5] -> Sair
                    =================================================
                    -> Escolha uma opção:
                    """;
            System.out.println(menu);
        }

        private void fluxoAdicionarLivro() {
            System.out.println("\n--- NOVO CADASTRO ---");
            System.out.println("Título: ");
            String titulo = scannerTexto.nextLine();

            System.out.println("Autor: ");
            String autor = scannerTexto.nextLine();

            System.out.println("Preço: R$ ");
            double preco = Double.parseDouble(scannerNumero.nextLine());

            System.out.println("Quantidade inicial em estoque: ");
            int qtd = Integer.parseInt(scannerNumero.nextLine());

            Livro novoLivro = new Livro(titulo, autor, preco, qtd);
            livrariaService.cadastrarLivro(novoLivro);

            System.out.println(" -> Livro cadastrado com sucesso!");
        }

        private void fluxoExibirLivros(){
            System.out.println("\n--- ACERVO COMPLETO ---");
            List<Livro> todosOsLivros = livrariaService.listarTodos();

            if (todosOsLivros.isEmpty()) {
                System.out.println(" -> O acervo está vazio.");
                return;
            }

            for (Livro livro : todosOsLivros) {
                System.out.println(livro);
            }
        }

        private void fluxoBuscarLivro() {
            System.out.println("\n -> Digite o termo de busca: ");
            String termo = scannerTexto.nextLine();

            List<Livro> resultados = livrariaService.burcarPorTermo(termo);

            if (resultados.isEmpty()) {
                System.out.println(" -> Nenhum livro encontrado.");
            } else {
                System.out.println("Encontrados:");
                for (Livro livro : resultados) {
                    System.out.println(" - " + livro);
                }
            }
        }

        private void fluxoEditarLivro() {
            System.out.println("\n -> Digite o título EXATO do livro que deseja editar: ");
            String titulo = scannerTexto.nextLine();

            Livro livroEncontrado = livrariaService.buscarPorTituloExato(titulo);

            if (livroEncontrado == null) {
                System.out.println(" -> Livro não encontrado no acervo.");
                return;
            }

            System.out.println("Livro atual: " + livroEncontrado);

            System.out.println("Novo Preço (ou digite -1 para manter o atual): R$ ");
            double novoPreco = Double.parseDouble(scannerTexto.nextLine());
            if (novoPreco != -1) {
                livroEncontrado.setPreco(novoPreco);
            }

            System.out.println("Nova quantidade em estoque (ou digite -1 para manter a atual): ");
            int novaQtd = Integer.parseInt(scannerTexto.nextLine());
            if (novoPreco != -1) {
                livroEncontrado.setPreco(novoPreco);
            }

            System.out.println(" -> Cadastro atualizado com sucesso!");
        }
    }
