package uk.ac.rhul.cs2800.repository;

import org.springframework.data.repository.CrudRepository;
import uk.ac.rhul.cs2800.Module;

/**
 * Repository interface for Module entities.
 */
public interface ModuleRepository extends CrudRepository<Module, String> {
}
