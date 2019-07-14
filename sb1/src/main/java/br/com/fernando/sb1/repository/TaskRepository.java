package br.com.fernando.sb1.repository;

import br.com.fernando.sb1.model.Task;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {
}
