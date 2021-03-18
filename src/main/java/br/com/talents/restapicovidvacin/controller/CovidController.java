package br.com.talents.restapicovidvacin.controller;

import br.com.talents.restapicovidvacin.exception.ApiException;
import br.com.talents.restapicovidvacin.exception.InternalServerErrorException;
import br.com.talents.restapicovidvacin.model.Usuario;
import br.com.talents.restapicovidvacin.model.Vacina;
import br.com.talents.restapicovidvacin.service.UsuarioService;
import br.com.talents.restapicovidvacin.service.VacinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class CovidController {

    private static final Logger LOGGER = Logger.getLogger(CovidController.class.getName());

    UsuarioService usuarioService;

    VacinaService vacinaService;

    @Autowired
    public CovidController(UsuarioService usuarioService, VacinaService vacinaService) {
        this.vacinaService = vacinaService;
        this.usuarioService = usuarioService;
    }

    @PostMapping("/usuario")
    public ResponseEntity<String> salvarUsuario(@Valid @RequestBody Usuario usuario) {
        try {
            usuarioService.salvarUsuario(usuario);
            return ResponseEntity.ok("Usuário cadastrado com sucesso!");
        } catch(ApiException ex){
            throw ex;
        } catch(Exception ex){
            LOGGER.log(Level.SEVERE, "Erro não esperado");
            ex.printStackTrace();
            throw new InternalServerErrorException("Erro não esperado");
        }
    }

    @PostMapping("/vacina")
    public ResponseEntity<String> aplicarVacina(@Valid @RequestBody Vacina vacina) {

        try{
            vacinaService.aplicarVacina(vacina);
            return ResponseEntity.ok("Vacina aplicada com sucesso!");
        } catch(ApiException ex){
            throw ex;
        } catch(Exception ex){
            LOGGER.log(Level.SEVERE, "Erro não esperado");
            ex.printStackTrace();
            throw new InternalServerErrorException("Erro não esperado");
        }
    }
}