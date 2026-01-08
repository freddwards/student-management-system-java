package uk.ac.rhul.cs2800;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import uk.ac.rhul.cs2800.exception.NoGradeAvailableException;
import uk.ac.rhul.cs2800.exception.NoRegistrationException;

/**
 * A class that represents a student. A student can register for modules and receive grades.
 * 
 */
@Entity
public class Student {

  @Id
  private int id;
  private String firstName;
  private String lastName;
  private String username;
  private String email;

  @OneToMany(mappedBy = "student")
  private List<Grade> grades;
  @OneToMany
  private List<Registration> registrations;

  /**
   * Default constructor initialising grades list.
   */
  public Student() {
    this.grades = new ArrayList<>();
    this.registrations = new ArrayList<>();
  }

  /**
   * It computes average grades.
   *
   * @return average grades in float
   * @throws NoGradeAvailableException if there are no grades
   */
  public float computeAverage() throws NoGradeAvailableException {
    if (grades.size() < 1) {
      throw new NoGradeAvailableException();
    }
    float average = (float) this.grades.stream().mapToInt(g -> g.getScore()).average().orElse(0);

    return average;
  }

  /**
   * You can add a grade by using this method.
   *
   * @param grade a grade value to be added to grade list
   * @throws NoRegistrationException if the student is not registered to the module
   */
  public void addGrade(Grade grade) throws NoRegistrationException {
    boolean registered = false;

    for (Registration r : registrations) {
      if (r.getModule().equals(grade.getModule())) {
        registered = true;
        break;
      }
    }

    if (!registered) {
      throw new NoRegistrationException();
    }


    this.grades.add(grade);

  }

  /**
   * Used to register student to a module.
   *
   * @param module to register student to
   */
  public void registerModule(Module module) {
    registrations.add(new Registration(module));

  }


  /**
   * Returns the score of a given module.
   *
   * @param module to return the score of
   * @return the score
   * @throws NoGradeAvailableException if there are no grades
   * @throws NoRegistrationException if there are no registrations
   */
  public Grade getGrade(Module module) throws NoGradeAvailableException, NoRegistrationException {

    boolean isRegistered = false;

    for (Registration reg : registrations) {
      if (reg.getModule().equals(module)) {
        isRegistered = true;
        break;
      }
    }

    if (!isRegistered) {
      throw new NoRegistrationException();
    }

    for (Grade grade : grades) {
      if (grade.getModule().equals(module)) {
        return grade;
      }
    }

    throw new NoGradeAvailableException();
  }

  // Getters and Setters.

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

}
