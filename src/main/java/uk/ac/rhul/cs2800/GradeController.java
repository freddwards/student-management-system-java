package uk.ac.rhul.cs2800;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import java.util.Map;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.rhul.cs2800.repository.GradeRepository;
import uk.ac.rhul.cs2800.repository.ModuleRepository;
import uk.ac.rhul.cs2800.repository.StudentRepository;

/**
 * REST controller for handling Grade-related requests.
 */
@RestController
public class GradeController {

  private final GradeRepository gradeRepository;
  private final StudentRepository studentRepository;
  private final ModuleRepository moduleRepository;

  /**
   * Constructor injection.
   *
   * @param gradeRepository repository for grades
   * @param studentRepository repository for students
   * @param moduleRepository repository for modules
   */
  public GradeController(GradeRepository gradeRepository, StudentRepository studentRepository,
      ModuleRepository moduleRepository) {
    this.gradeRepository = gradeRepository;
    this.studentRepository = studentRepository;
    this.moduleRepository = moduleRepository;
  }

  /**
   * Adds a grade for a student.
   *
   * @param params request parameters containing student_id, module_code, and score
   * @return the saved Grade object
   */
  @PostMapping(value = "/grades/addGrade")
  public ResponseEntity<Grade> addGrade(@RequestBody Map<String, String> params) {

    int studentId = Integer.parseInt(params.get("student_id"));
    String moduleCode = params.get("module_code");
    int score = Integer.parseInt(params.get("score"));

    Optional<Student> studentOpt = studentRepository.findById(studentId);
    Optional<Module> moduleOpt = moduleRepository.findById(moduleCode);

    Student student = studentOpt.get();
    Module module = moduleOpt.get();

    Grade grade = new Grade(score, module, student);
    Grade savedGrade = gradeRepository.save(grade);

    return ResponseEntity.ok(savedGrade);
  }
}
