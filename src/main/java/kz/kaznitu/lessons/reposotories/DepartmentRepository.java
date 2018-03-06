package kz.kaznitu.lessons.reposotories;

import kz.kaznitu.lessons.models.Author;
import kz.kaznitu.lessons.models.Book;
import kz.kaznitu.lessons.models.Departments;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DepartmentRepository extends CrudRepository<Departments,Long> {
    Optional<Departments> findById(Long id);
}
