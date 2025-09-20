package ps2.titular_app;

import java.util.List;

public class TitularDao {
    private TitularRepo repo;

    public TitularDao() {
        this.repo = new TitularRepo();
    }

    public List<Titular> listarTodos() {
        return repo.getTodos();
    }

    public Titular buscarPorNumero(int numero) {
        return repo.getPorNumero(numero);
    }

    public void criar(Titular titular) {
        repo.adicionar(titular);
    }

    public void alterar(int numero, Titular novosDados) {
        repo.atualizar(numero, novosDados);
    }

    public void apagar(int numero) {
        repo.remover(numero);
    }
}