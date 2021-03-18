package br.com.talents.restapicovidvacin.model.dto;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;

@Validated
public class UsuarioDTO {

    @Email(message = "Email do usuário que vai aplicar a vacina é inválido")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
