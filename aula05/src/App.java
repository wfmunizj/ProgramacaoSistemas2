import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        ContaDao dao;
        String url = "jdbc:postgresql://aws-1-sa-east-1.pooler.supabase.com:6543/postgres?user=postgres.ftvqdprmoydxttvcqngu&password=Ann@w3ll05ANN@W3LL05";
        // String url = "jdbc:postgresql://db.ftvqdprmoydxttvcqngu.supabase.co:5432/postgres?user=postgres&password=Ann@w3ll05ANN@W3LL05";
        dao = new ContaDao(ConnectionFactory.getConnection(url));
        List<Conta> contas;
        contas = dao.lerTodas();
        System.out.println(contas);
    }
}
