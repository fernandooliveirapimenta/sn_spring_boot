package br.com.fernando.relatorio.repository;

import br.com.fernando.relatorio.model.Estate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstateRepository extends CrudRepository<Estate, Long> {
}
