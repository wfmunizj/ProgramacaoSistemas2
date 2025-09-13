import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ContaDao implements IContaDao {
    private PreparedStatement pstmCreate;
    private PreparedStatement pstmRead;
    private PreparedStatement pstmReadByNumber;
    private PreparedStatement pstmUpdate;
    private PreparedStatement pstmDelete;

    public ContaDao(Connection c) throws Exception {
        pstmCreate = c.prepareStatement("INSERT INTO CONTAS VALUES (?, ?)");
        pstmRead = c.prepareStatement("SELECT * FROM CONTAS");
        pstmReadByNumber = c.prepareStatement("SELECT * FROM CONTAS WHERE NRO_CONTA = ?");
        pstmUpdate = c.prepareStatement("UPDATE CONTAS SET SALDO = ? WHERE NRO_CONTA = ?");
        pstmDelete = c.prepareStatement("DELETE FROM CONTAS WHERE NRO_CONTA = ?");
    }
    

    @Override
    public boolean criar(Conta c){
        try {
            pstmCreate.setLong(1, c.getNumero());
            pstmCreate.setBigDecimal(2, c.getSaldo());
            pstmCreate.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Conta> lerTodas() throws Exception {
        List<Conta> contas = new ArrayList<>();
        ResultSet resultados; 
        resultados = pstmRead.executeQuery();
        while(resultados.next()){
            long n = resultados.getLong("nro_conta");
            BigDecimal s = resultados.getBigDecimal("saldo");
            Conta c = new Conta(n,s);
            contas.add(c);
        }
        return contas;
    }
    
    @Override
    public Conta buscarPeloNumero(long id) throws Exception{
        Conta c = null; 
        pstmReadByNumber.setLong(1, id);
        ResultSet resultado = pstmReadByNumber.executeQuery();
        if (resultado.next()) {
            long n = resultado.getLong("nro_conta");
            BigDecimal s = resultado.getBigDecimal("saldo");
            c = new Conta(n,s);
        }
        return c;
    }

    @Override
    public boolean atualizar(Conta c) {
        try {
            pstmUpdate.setBigDecimal(1, c.getSaldo());
            pstmUpdate.setLong(2, c.getNumero());
            pstmUpdate.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean apagar(Conta c) {
        try {
            pstmDelete.setLong(1, c.getNumero());
            pstmDelete.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
