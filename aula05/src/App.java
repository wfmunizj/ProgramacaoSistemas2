import java.math.BigDecimal;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        ContaDao dao;
        String url = "jdbc:postgresql://aws-1-sa-east-1.pooler.supabase.com:6543/postgres?user=postgres.ftvqdprmoydxttvcqngu&password=Ann@w3ll05ANN@W3LL05";
        int opcao = 0;
        menu();
        dao = new ContaDao(ConnectionFactory.getConnection(url));

        switch (opcao) {
            case 1:
                List<Conta> contas = dao.lerTodas();
                System.out.println(contas);
            case 2:
                Conta c = dao.buscarPeloNumero(102);
                System.out.println(c);
                break;
            case 3:
                Conta novaConta = new Conta(103, new BigDecimal(1000));
                dao.criar(novaConta);
                break;
            case 4: 
                Conta c2 = dao.buscarPeloNumero(102);
                c2.setSaldo(new BigDecimal(5000));
                dao.atualizar(c2);
                break;
            case 5:
                Conta c3 = dao.buscarPeloNumero(102);
                dao.apagar(c3);
                break;
            default:
                throw new AssertionError();
        }
        
    }

    public static void menu() {
        System.out.println("(1) Listar todas as contas");
        System.out.println("(2) Buscar uma conta específica pelo número");
        System.out.println("(3) Criar uma nova conta");
        System.out.println("(4) Alterar o saldo de uma conta");
        System.out.println("(5) Apagar uma conta");
        System.out.println("(0) Sair");

    }
}
