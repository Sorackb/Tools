package org.lucassouza.tools;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

/**
 *
 * @author sarxos[https://github.com/sarxos/secure-tokens/blob/master/src/main/java/com/github/sarxos/securetoken/impl/Hardware4Win.java]
 * Fullt copied from https://github.com/sarxos/secure-tokens/blob/master/src/main/java/com/github/sarxos/securetoken/impl/Hardware4Win.java
 */
public class Hardware4Win {

  private static String serialNumber = null;

  public static void main(String[] args) {
    System.out.println(getSerialNumber());
  }

  public static final String getSerialNumber() {
    OutputStream os;
    InputStream is;
    Runtime runtime;
    Process process;
    Scanner sc;

    if (serialNumber != null) {
      return serialNumber;
    }

    try {
      runtime = Runtime.getRuntime();
      process = null;
      process = runtime.exec(new String[]{"wmic", "bios", "get", "serialnumber"});
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    os = process.getOutputStream();
    is = process.getInputStream();

    try {
      os.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    sc = new Scanner(is);

    try {
      while (sc.hasNext()) {
        String next = sc.next();
        if ("SerialNumber".equals(next)) {
          serialNumber = sc.next().trim();
          break;
        }
      }
    } finally {
      try {
        is.close();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    if (serialNumber == null) {
      throw new RuntimeException("Cannot find computer SN");
    }

    return serialNumber;
  }
}
