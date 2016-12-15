package org.lucassouza.tools;

import java.text.Normalizer;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

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

  public static LinkedHashMap<String, String> extract(Map<String, String> source, String... fields) {
    LinkedHashMap<String, String> group = new LinkedHashMap<>();

    Arrays.asList(fields)
            .stream()
            .filter(field -> source.containsKey(field))
            .forEach(key -> {
              group.put(key, source.get(key));
            });

    return group;
  }

  public static String stripAccents(String text) {
    text = Normalizer.normalize(text, Normalizer.Form.NFD);
    text = text.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
    return text;
  }
}
