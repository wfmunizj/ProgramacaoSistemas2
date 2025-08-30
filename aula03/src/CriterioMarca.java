public class CriterioMarca implements CriterioBusca {
    @Override
    public boolean testar(Produto p, String valor) {
        return p.getMarca().equals(valor);
    }
}