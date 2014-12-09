package org.lucassouza.tools;

/**
 *
 * @author Lucas Souza [sorackb@gmail.com]
 */
public class GeneralTool {

  public static <T> T nvl(T origin, T defaultValue) {
    return (origin == null) ? defaultValue : origin;
  }
}
