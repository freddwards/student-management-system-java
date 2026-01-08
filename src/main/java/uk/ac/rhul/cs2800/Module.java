package uk.ac.rhul.cs2800;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * A class that represents a module.
 */
@Entity
public class Module {

  @Id
  private String code;

  private String name;
  private boolean mnc;

  protected Module() {}

  /**
   * Constructor for module.
   *
   * @param code for the module
   * @param name for the module
   * @param mnc for the module
   */
  public Module(String code, String name, boolean mnc) {
    this.code = code;
    this.name = name;
    this.mnc = mnc;
  }

  // Getters and Setters.

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public boolean isMnc() {
    return mnc;
  }

  public void setMnc(boolean mnc) {
    this.mnc = mnc;
  }

}
