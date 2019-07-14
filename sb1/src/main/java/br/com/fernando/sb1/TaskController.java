package br.com.fernando.sb1;

import br.com.fernando.sb1.model.Task;
import br.com.fernando.sb1.repository.TaskRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskRepository taskRepository;
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping
    public Iterable<Task> all() {
      return taskRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Task id(@PathVariable Long id) {
        return taskRepository.findOne(id);
    }

    @PostMapping
    public Task save(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @PutMapping
    public Task update(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
       taskRepository.delete(taskRepository.findOne(id));
    }
}
