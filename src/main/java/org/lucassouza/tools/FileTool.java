package org.lucassouza.tools;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author Lucas Souza [sorackb@gmail.com]
 */
public class FileTool {

  public String fileToString(String completePath) throws IOException {
    File file = new File(completePath);
    DataInputStream inputData;
    String result;

    if (!file.isFile()) {
      file.createNewFile();
    }

    byte[] buffer = new byte[(int) file.length()];
    inputData = new DataInputStream(new FileInputStream(file));
    inputData.readFully(buffer);
    result = new String(buffer);
    inputData.close();

    return result;
  }
}
