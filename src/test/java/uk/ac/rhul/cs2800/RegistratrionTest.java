package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import uk.ac.rhul.cs2800.exception.NoGradeAvailableException;

/**
 * A class to test Registration.
 */
public class RegistratrionTest {

  @Test
  void registrationConstructorTest() {
    // Test 1
    Student student = new Student();
    Module module = new Module("CS28001", "Software development", false);
    Registration registration = new Registration(module);
    assertEquals(module, registration.getModule());
  }

  @Test
  void registerModuleAddsRegistration() throws Exception {
    // Test 2
    Student student = new Student();
    Module module = new Module("CS2808", "Register test", false);
    student.registerModule(module);
    assertThrows(NoGradeAvailableException.class, () -> student.getGrade(module));
  }

}
