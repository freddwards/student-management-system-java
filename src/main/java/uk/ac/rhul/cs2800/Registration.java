package uk.ac.rhul.cs2800;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * A class that represents registration.
 */
@Entity
public class Registration {

  @Id
  @GeneratedValue
  private long id;

  @ManyToOne
  @JoinColumn(name = "module_code")
  private Module module;

  protected Registration() {}

  /**
   * Constructor for registration.
   *
   * @param module module for the student to be registered to
   */
  public Registration(Module module) {
    this.module = module;
  }



  public Module getModule() {
    return module;
  }

}
