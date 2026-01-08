package uk.ac.rhul.cs2800;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * A class that represents a grade.
 */
@Entity
public class Grade {

  @Id
  @GeneratedValue
  private long id;

  private int score;

  @ManyToOne
  @JoinColumn(name = "module_code")
  private Module module;

  @ManyToOne
  @JoinColumn(name = "student_id")
  private Student student;

  protected Grade() {}

  /**
   * Constructor for Grade.
   *
   * @param score for grade score
   * @param module for module associated with grade
   */
  public Grade(int score, Module module, Student student) {
    this.score = score;
    this.module = module;
    this.student = student;
  }


  public long getId() {
    return id;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public Module getModule() {
    return module;
  }

  public void setModule(Module module) {
    this.module = module;
  }

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }


}
