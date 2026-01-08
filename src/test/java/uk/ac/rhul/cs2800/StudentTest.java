package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import uk.ac.rhul.cs2800.exception.NoGradeAvailableException;
import uk.ac.rhul.cs2800.exception.NoRegistrationException;

/**
 * A class to test student.
 */
public class StudentTest {

  // Test for computing average score

  @Test
  void computeAverageTest() throws NoGradeAvailableException, NoRegistrationException {
    // Test 1
    Student student = new Student();
    Module module1 = new Module("CS2801", "not best module 1", false);
    Module module2 = new Module("CS2802", "not best module 2", true);
    student.registerModule(module1);
    student.registerModule(module2);
    Grade grade1 = new Grade(5, module1, student);
    Grade grade2 = new Grade(3, module2, student);
    student.addGrade(grade1);
    student.addGrade(grade2);
    assertEquals(4.0, student.computeAverage());


  }

  // Test for computing average score 2

  @Test
  void computeAverageTest2() throws NoGradeAvailableException, NoRegistrationException {
    // Test 2
    Student student = new Student();
    Module module1 = new Module("CS2801", "not best module 1", false);
    Module module2 = new Module("CS2802", "not best module 2", true);
    Module module3 = new Module("CS2803", "not best module 2", true);
    student.registerModule(module1);
    student.registerModule(module2);
    student.registerModule(module3);
    Grade grade1 = new Grade(2, module1, student);
    Grade grade2 = new Grade(4, module2, student);
    Grade grade3 = new Grade(3, module3, student);
    student.addGrade(grade1);
    student.addGrade(grade2);
    student.addGrade(grade3);
    assertEquals(3.0, student.computeAverage());


  }

  // Test for computing average score with one grade

  @Test
  void computeAverageWithOneGrade() throws NoGradeAvailableException, NoRegistrationException {
    // Test 3
    Student student = new Student();
    Module module = new Module("CS2804", "one grade module", false);
    student.registerModule(module);
    Grade grade = new Grade(10, module, student);
    student.addGrade(grade);
    assertEquals(10.0, student.computeAverage());
  }

  // Test for computing average score without a grade

  @Test
  void computeAverageWithoutAnyGrade() {
    // Test 4
    assertThrows(NoGradeAvailableException.class, () -> {
      Student student = new Student();
      student.computeAverage();

    });


  }

  // Test for student not being registered

  @Test
  void getGradeThrowsWhenNotRegistered() {
    // Test 5
    Student student = new Student();
    Module module = new Module("CS2805", "Unregistered module", false);
    assertThrows(NoRegistrationException.class, () -> {
      student.getGrade(module);

    });
    

  }

  // Test for getters and setters

  @Test
  void gettersAndSettersWork() {
    // Test 6
    Student student = new Student();
    student.setFirstName("fred");
    student.setLastName("edwards");
    student.setUsername("znac381");
    student.setEmail("fe@example.com");
    student.setId(381);

    assertEquals("fred", student.getFirstName());
    assertEquals("edwards", student.getLastName());
    assertEquals("znac381", student.getUsername());
    assertEquals("fe@example.com", student.getEmail());
    assertEquals(381, student.getId());

  }

  // Test for registered but there is no grade


  @Test
  void getGradeThrowsWhenRegisteredButNoGrade() {
    // Test 7
    Student student = new Student();
    Module module = new Module("CS2806", "No grade", false);
    student.registerModule(module);
    assertThrows(NoGradeAvailableException.class, () -> student.getGrade(module));

  }

  // Test for getGrade

  @Test
  void getGradeReturnsCorrectGrade() throws Exception {
    // Test 8
    Student student = new Student();
    Module module = new Module("CS2807", "Normal case", true);
    student.registerModule(module);
    Grade grade = new Grade(75, module, student);
    student.addGrade(grade);
    assertEquals(grade, student.getGrade(module));
  }


}
