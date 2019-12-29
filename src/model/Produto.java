package model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import projetoweb2.TipoProduto;

/**
 *
 * @author Leandro
 */
@Entity
public class Produto {
    
    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private String preco;
    @Enumerated(EnumType.STRING)
    private TipoProduto tipo;

    Produto() {
        tipo = TipoProduto.GRAOS;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public TipoProduto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProduto tipo) {
        this.tipo = tipo;
    }

    public String toString(){
        return "Endereço: " + nome + " - " + preco + " - " + tipo;
    }
    
    
}