package ps2.titular_app;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Titular {
    @Id @GeneratedValue
    private long id;
    private int numero;
    private String nome;
    private String email;

    public Titular() {}

    public Titular(int numero, String nome, String email) {
        this.numero = numero;
        this.nome = nome;
        this.email = email;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Titular [numero=" + numero + ", nome=" + nome + ", email=" + email + "]";
    }
}