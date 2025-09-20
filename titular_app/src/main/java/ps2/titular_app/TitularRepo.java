package ps2.titular_app;

import java.util.ArrayList;
import java.util.List;

public class TitularRepo {
    private List<Titular> titulares;

    public TitularRepo() {
        titulares = new ArrayList<>();
    }

    public List<Titular> getTodos() {
        return new ArrayList<>(titulares);
    }

    public Titular getPorNumero(int numero) {
        for (Titular t : titulares) {
            if (t.getNumero() == numero) {
                return t;
            }
        }
        return null;
    }

    public void adicionar(Titular titular) {
        titulares.add(titular);
    }

    public void atualizar(int numero, Titular novosDados) {
        Titular existente = getPorNumero(numero);
        if (existente != null) {
            existente.setNome(novosDados.getNome());
            existente.setEmail(novosDados.getEmail());
        }
    }

    public void remover(int numero) {
        Titular existente = getPorNumero(numero);
        if (existente != null) {
            titulares.remove(existente);
        }
    }
}