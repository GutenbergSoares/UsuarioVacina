package br.com.talents.restapicovidvacin.service;

import br.com.talents.restapicovidvacin.exception.BadRequestException;
import br.com.talents.restapicovidvacin.model.Usuario;
import br.com.talents.restapicovidvacin.model.Vacina;
import br.com.talents.restapicovidvacin.repository.VacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class VacinaService {

    private static final Logger LOGGER = Logger.getLogger(VacinaService.class.getName());

    private VacinaRepository repository;

    private UsuarioService usuarioService;

    @Autowired
    public VacinaService(VacinaRepository repository, UsuarioService usuarioService) {
        this.repository = repository;
        this.usuarioService = usuarioService;
    }

    public void aplicarVacina(Vacina vacina) {

        final String email = vacina.getUsuarioDTO().getEmail();

        LOGGER.log(Level.INFO, String.format("Verificando existência de usuario com email %s", email));
        Usuario usuario = usuarioService.pesquisarUsuarioPorEmail(email);

        if(usuario!=null){
            // Relaciona usuário com email informado a vacina a ser aplicada
            vacina.setUsuario(usuario);

            LOGGER.log(Level.INFO, String.format("Aplicando vacina %s para usuario %s", vacina.getNomeVacina(), usuario.getNome()));
            repository.save(vacina);
        } else {
            LOGGER.log(Level.WARNING, String.format("Nenhum usuário com email %s encontrado", email));
            throw new BadRequestException(String.format("Nenhum usuário com email %s encontrado", email));
        }
    }
}