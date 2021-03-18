package br.com.talents.restapicovidvacin.repository;

import br.com.talents.restapicovidvacin.model.Vacina;
import org.springframework.data.repository.CrudRepository;

public interface VacinaRepository extends CrudRepository<Vacina, Long> {
}