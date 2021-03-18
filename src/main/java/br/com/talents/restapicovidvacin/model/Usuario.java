package br.com.talents.restapicovidvacin.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Validated
@Entity
@Table(name = "USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    @JsonIgnore
    private Long id;

    @NotEmpty(message = "Nome do usuário não informado")
    @Column(name = "NOME", length = 100, nullable = false)
    private String nome;

    @Email(message = "Email informado inválido")
    @Column(name = "EMAIL", length = 100, nullable = false)
    private String email;

    @NotEmpty(message = "CPF do usuário não informado")
    @Column(name = "CPF", length = 11, nullable = false)
    private String cpf;

    @NotEmpty(message = "Data de nascimento do usuário não informado")
    @Column(name = "DATA_NASCIMENTO", nullable = false)
    private String dataNascimento;

    @JsonIgnore
    @OneToOne(mappedBy = "usuario")
    private Vacina vacina;

    public Long getId() {
        return id;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Vacina getVacina() {
        return vacina;
    }

    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                '}';
    }
}