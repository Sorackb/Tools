package org.lucassouza.tools;

/**
 *
 * @author Lucas Souza [sorackb@gmail.com]
 */
public class GeneralTool {

  /**
   * Compare several parameters and return the first "not null"
   *
   * @param <T> Object class
   * @param values values to compare
   *
   * @return The first not null value passed
   */
  public static <T> T nvl(T... values) {
    for (T value : values) {
      if (value != null) {
        return value;
      }
    }

    return null;
  }
}
