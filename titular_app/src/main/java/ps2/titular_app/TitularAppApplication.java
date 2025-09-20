package ps2.titular_app;

import java.util.List;

public class TitularAppApplication {
    public static void main(String[] args) {
        TitularDao dao = new TitularDao();
        int opcao = -1;

        do {
            ES.print("\n--- MENU ---");
            ES.print("(1) Listar todos os titulares");
            ES.print("(2) Buscar um titular específico pelo número");
            ES.print("(3) Criar um novo titular");
            ES.print("(4) Alterar os dados do titular");
            ES.print("(5) Apagar um titular");
            ES.print("(0) Sair");
            
            try {
                String entrada = ES.input("Opção: ");
                opcao = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                ES.print("Erro: Por favor, insira um número válido.");
                continue;
            }

            switch (opcao) {
                case 1 -> {
                    // Listar todos
                    List<Titular> todos = dao.listarTodos();
                    if (todos.isEmpty()) {
                        ES.print("Nenhum titular cadastrado.");
                    } else {
                        for (Titular t : todos) {
                            ES.print(t.toString());
                        }
                    }
                }

                case 2 -> {
                    // Buscar titular
                    try {
                        int numeroBusca = Integer.parseInt(ES.input("Número do titular: "));
                        Titular encontrado = dao.buscarPorNumero(numeroBusca);
                        if (encontrado != null) {
                            ES.print("Encontrado: " + encontrado);
                        } else {
                            ES.print("Titular não encontrado.");
                        }
                    } catch (NumberFormatException e) {
                        ES.print("Número inválido.");
                    }
                }

                case 3 -> {
                    // Criar
                    try {
                        int num = Integer.parseInt(ES.input("Número: "));
                        String nome = ES.input("Nome: ");
                        String email = ES.input("Email: ");
                        dao.criar(new Titular(num, nome, email));
                        ES.print("Titular criado com sucesso!");
                    } catch (NumberFormatException e) {
                        ES.print("Número inválido.");
                    }
                }

                case 4 -> {
                    // Alterar
                    try {
                        int numAlt = Integer.parseInt(ES.input("Número do titular a alterar: "));
                        if (dao.buscarPorNumero(numAlt) != null) {
                            String novoNome = ES.input("Novo nome: ");
                            String novoEmail = ES.input("Novo email: ");
                            dao.alterar(numAlt, new Titular(numAlt, novoNome, novoEmail));
                            ES.print("Titular atualizado.");
                        } else {
                            ES.print("Titular não encontrado.");
                        }
                    } catch (NumberFormatException e) {
                        ES.print("Número inválido.");
                    }
                }

                case 5 -> {
                    // Apagar
                    try {
                        int numRem = Integer.parseInt(ES.input("Número do titular a remover: "));
                        if (dao.buscarPorNumero(numRem) != null) {
                            dao.apagar(numRem);
                            ES.print("Titular removido.");
                        } else {
                            ES.print("Titular não encontrado.");
                        }
                    } catch (NumberFormatException e) {
                        ES.print("Número inválido.");
                    }
                }

                case 0 -> // Sair
                    ES.print("Saindo...");

                default -> ES.print("Opção inválida.");
            }
        } while (opcao != 0);
    }
}