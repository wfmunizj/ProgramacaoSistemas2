public class CriterioDescricao implements CriterioBusca {
    @Override
    public boolean testar(Produto p, String valor) {
        return p.getDescricao().contains(valor);
    }
}