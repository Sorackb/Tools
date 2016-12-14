package org.lucassouza.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Lucas Souza [sorackb@gmail.com]
 */
public class CMD {
  public static String execute(String... commands) {
    StringBuilder output = new StringBuilder();
    BufferedReader reader;
    ProcessBuilder processes;
    Process process;
    String line;

    try {
      processes = new ProcessBuilder("cmd.exe", "/c", String.join(" && ", commands));
      process = processes.start();
      process.waitFor();
      reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

      while ((line = reader.readLine()) != null) {
        output.append(line).append(System.lineSeparator());
      }
    } catch (IOException | InterruptedException ex) {
      return ex.getMessage();
    }

    return output.toString();
  }
}
