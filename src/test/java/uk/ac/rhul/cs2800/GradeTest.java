package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * A class to test grade.
 */
public class GradeTest {

  // Testing grade constructor

  @Test
  void gradeConstructorTest() {
    // Test 1
    Module module = new Module("CS2800", "Software development", true);
    Student student = new Student();
    Grade grade = new Grade(90, module, student);
    assertEquals(90, grade.getScore());
    assertEquals(module, grade.getModule());
  }

  // Testing grade setters and getter

  @Test
  void gradeSettersAndGettersTest() {
    // Test 2
    Module module1 = new Module("CS2801", "not best module 1", false);
    Module module2 = new Module("CS2802", "not best module 2", true);
    Student student = new Student();
    Grade grade = new Grade(80, module1, student);
    grade.setScore(95);
    grade.setModule(module2);
    assertEquals(95, grade.getScore());
    assertEquals(module2, grade.getModule());
  }

}
