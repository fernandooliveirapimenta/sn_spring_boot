package br.com.fernando.sb1.repository;

import br.com.fernando.sb1.model.Task;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {

    Task findByNameIgnoreCase(String name);
    Task findByNameLike(String name);
    Task findByNameLikeOrId(String name, Long id);
    List<Task> findAllByOrderByName();
}
