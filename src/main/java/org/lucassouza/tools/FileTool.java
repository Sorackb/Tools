package org.lucassouza.tools;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 *
 * @author Lucas Souza [sorackb@gmail.com]
 */
public class FileTool {

  public String fileToString(String completePath) throws IOException {
    File file = new File(completePath);
    String result;

    if (!file.isFile()) {
      file.createNewFile();
    }

    result = new String(Files.readAllBytes(file.toPath()));

    return result;
  }
}
