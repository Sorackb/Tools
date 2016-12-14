package org.lucassouza.tools;

/**
 *
 * @author Lucas Souza [sorackb@gmail.com]
 */
public class Hardware4Win {

  public enum WMICType {
    BIOS("bios", "serialnumber"),
    BASEBOARD("baseboard", "serialnumber"),
    HD("diskdrive", "serialnumber"),
    OS("os", "serialnumber");

    private final String type;
    private final String information;

    private WMICType(String command, String information) {
      this.type = command;
      this.information = information;
    }

    public String getType() {
      return this.type;
    }

    public String getInformation() {
      return this.information;
    }
  }

  private static String serialNumber = null;

  public static String getSerialNumber(WMICType wmicType) {
    String[] lines;

    if (serialNumber != null) {
      return serialNumber;
    }

    lines = CMD.execute("wmic " + wmicType.getType() + " get " + wmicType.getInformation()).split("\n");

    for (String line : lines) {
      line = line.trim();

      if (!line.isEmpty()) {
        serialNumber = line.trim();
      }
    }

    if (serialNumber == null) {
      throw new RuntimeException("Cannot find computer SN");
    }

    return serialNumber;
  }
}
