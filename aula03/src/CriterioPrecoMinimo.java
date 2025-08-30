public class CriterioPrecoMinimo implements CriterioBusca{
    @Override
    public boolean testar(Produto p, String valor) {
        return p.getPreco() >= Double.parseDouble(valor);
    }
}
