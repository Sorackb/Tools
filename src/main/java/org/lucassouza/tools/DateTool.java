package org.lucassouza.tools;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;

/**
 *
 * @author Lucas Souza [sorackb@gmail.com]
 */
public class DateTool {

  // Based in http://stackoverflow.com/a/24362679/3388148
  public static int monthAsNumber(String description, Locale locale) {
    for (Month month : Month.values()) {
      ArrayList<String> names = new ArrayList<>();

      names.add(month.getDisplayName(TextStyle.SHORT_STANDALONE, locale).toUpperCase());
      names.add(month.getDisplayName(TextStyle.SHORT, locale).toUpperCase());
      names.add(month.getDisplayName(TextStyle.FULL_STANDALONE, locale).toUpperCase());
      names.add(month.getDisplayName(TextStyle.FULL, locale).toUpperCase());

      if (names.contains(description.toUpperCase())) {
        return month.getValue();
      }
    }

    return -1; // no match
  }
}
