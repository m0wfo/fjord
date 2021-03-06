package fjord;

import static org.junit.Assert.*;
import org.junit.Test;

public class InteractiveTest {
  private Main.Environment env = new Main.Environment();

  @Test public void valueDefn() throws Exception {
    assertEval("let x = 1", "val x = 1\n");
  }

  @Test public void applicationExpr() throws Exception {
    assertEval("let x = 1 + 2", "val x = 3\n");
    assertEval("let x = 1 - 2", "val x = -1\n");
  }

  private void assertEval(String input, String output) throws Exception {
    assertEquals(input, output, Main.eval(env, input));
  }

  @Test public void quit() throws Exception {
    assertFalse(env.isHalted());
    String output = Main.eval(env, "#quit");
    assertTrue(env.isHalted());
    assertEquals("", output);
  }
}
