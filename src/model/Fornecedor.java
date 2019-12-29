package model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Leandro
 */
@Entity
public class Fornecedor {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String email;
    @Temporal(TemporalType.DATE)
    private Date dataEntrega;
    private String telefone;
    @OneToOne(cascade = CascadeType.ALL)
    private Produto produto;
    
    public Fornecedor(){
        produto = new Produto();
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public String toString(){
        return id + " - " + nome + " - " + email + " - " + dataEntrega + " - " + telefone + " - " + produto;
    }
    
}
