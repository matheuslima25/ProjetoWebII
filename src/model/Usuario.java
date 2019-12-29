package model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import projetoweb2.TipoUsuario;

/**
 *
 * @author Matheus
 */
@Entity
public class Usuario {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String email;
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    private String telefone;
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipo;
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
    
    public Usuario(){
        endereco = new Endereco();
        tipo = TipoUsuario.CLIENTE;
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefones() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    public String toString(){
        return id + " - " + nome + " - " + email + " - " + tipo + " - " + telefone + " - " + endereco;
    }
    
}
