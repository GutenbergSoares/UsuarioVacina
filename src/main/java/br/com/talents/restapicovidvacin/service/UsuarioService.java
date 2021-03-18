package br.com.talents.restapicovidvacin.service;

import br.com.talents.restapicovidvacin.exception.BadRequestException;
import br.com.talents.restapicovidvacin.model.Usuario;
import br.com.talents.restapicovidvacin.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class UsuarioService {

    private static final Logger LOGGER = Logger.getLogger(UsuarioService.class.getName());

    private UsuarioRepository repository;

    @Autowired
    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void salvarUsuario(Usuario usuario) {
        LOGGER.log(Level.INFO, String.format("Salvando usuario %s", usuario.toString()));

        boolean cpfExistente = (this.pesquisarUsuarioPorCpf(usuario.getCpf())!=null);

        boolean emailExistente = (this.pesquisarUsuarioPorEmail(usuario.getEmail())!=null);

        if(cpfExistente){
            throw new BadRequestException(String.format("Usuário com cpf %s já existe", usuario.getCpf()));
        }

        if(emailExistente){
            throw new BadRequestException(String.format("Usuário com email %s já existe", usuario.getEmail()));
        }

        repository.save(usuario);
    }

    public Usuario pesquisarUsuarioPorEmail(String email){

        if(email.isEmpty()){
            LOGGER.log(Level.WARNING, String.format("Email %s informado é inválido", email));
            throw new BadRequestException(String.format("Email %s informado é inválido", email));
        }

        return repository.pesquisarUsuarioPorEmail(email);
    }

    public Usuario pesquisarUsuarioPorCpf(String cpf){

        if(cpf.isEmpty()){
            LOGGER.log(Level.WARNING, String.format("CPF %s informado é inválido", cpf));
            throw new BadRequestException(String.format("CPF %s informado é inválido", cpf));
        }

        return repository.pesquisarUsuarioPorCpf(cpf);
    }
}