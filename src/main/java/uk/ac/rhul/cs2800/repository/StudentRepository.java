package uk.ac.rhul.cs2800.repository;

import org.springframework.data.repository.CrudRepository;
import uk.ac.rhul.cs2800.Student;

/**
 * Repository interface for Student entities.
 */
public interface StudentRepository extends CrudRepository<Student, Integer> {
}
