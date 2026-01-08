package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * A class to test module.
 */
public class ModuleTest {

  // Testing module constructor

  @Test
  void moduleConstructorTest() {
    // Test 1
    Module module = new Module("CS2800", "software development", true);
    assertEquals("CS2800", module.getCode());
    assertEquals("software development", module.getName());
    assertEquals(true, module.isMnc());
  }

  // Testing module setters and getters

  @Test
  void multipleSettersAndGettersTest() {
    // Test 3
    Module module = new Module("CS2800", "Best module", true);
    module.setCode("CS2801");
    module.setName("No longer best module");
    module.setMnc(false);

    assertEquals("CS2801", module.getCode());
    assertEquals("No longer best module", module.getName());
    assertEquals(false, module.isMnc());
  }

}
