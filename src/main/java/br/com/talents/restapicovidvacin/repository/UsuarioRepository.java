package br.com.talents.restapicovidvacin.repository;

import br.com.talents.restapicovidvacin.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    @Query("select u from Usuario u where u.email = ?1")
    Usuario pesquisarUsuarioPorEmail(String email);

    @Query("select u from Usuario u where u.cpf = ?1")
    Usuario pesquisarUsuarioPorCpf(String cpf);
}