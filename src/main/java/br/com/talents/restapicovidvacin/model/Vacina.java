package br.com.talents.restapicovidvacin.model;

import br.com.talents.restapicovidvacin.model.dto.UsuarioDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Validated
@Entity
@Table(name = "VACINA")
public class Vacina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    @JsonIgnore
    private Long id;

    @NotEmpty(message = "Nome da vacina não informada")
    @Column(name = "NOME", length = 100, nullable = false)
    private String nomeVacina;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USUARIO_ID", nullable = false)
    @JsonIgnore
    private Usuario usuario;

    @Valid
    @Transient
    private UsuarioDTO usuarioDTO;

    @NotEmpty(message = "Data de realização da vacina não informada")
    @Column(name = "DATA_VACINA", nullable = false)
    private String dataRealizacaoVacina;

    public Long getId() {
        return id;
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDataRealizacaoVacina() {
        return dataRealizacaoVacina;
    }

    public void setDataRealizacaoVacina(String dataRealizacaoVacina) {
        this.dataRealizacaoVacina = dataRealizacaoVacina;
    }

    public UsuarioDTO getUsuarioDTO() {
        return usuarioDTO;
    }

    public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
        this.usuarioDTO = usuarioDTO;
    }

    @Override
    public String toString() {
        return "Vacina{" +
                "nomeVacina='" + nomeVacina + '\'' +
                ", dataRealizacaoVacina='" + dataRealizacaoVacina + '\'' +
                '}';
    }
}