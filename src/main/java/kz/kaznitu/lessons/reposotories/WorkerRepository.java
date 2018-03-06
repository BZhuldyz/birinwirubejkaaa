package kz.kaznitu.lessons.reposotories;

import kz.kaznitu.lessons.models.Author;
import kz.kaznitu.lessons.models.Book;
import kz.kaznitu.lessons.models.Workers;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface WorkerRepository extends CrudRepository<Workers,Long> {
    Optional<Workers> findById(Long id);
}
