package org.lucassouza.tools;

import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

/**
 *
 * @author Lucas Souza <sorackb@gmail.com>
 */
public class PropertyTool {

  private Properties properties;
  private String completePath;

  public void readPropertyFile(String completePath) throws IOException {
    FileTool fileTool = new FileTool();
    String fileContent = fileTool.fileToString(completePath);

    this.completePath = completePath;
    this.properties = new Properties();
    this.properties.load(new StringReader(fileContent.replace("\\", "\\\\")));
  }

  public void setProperty(String key, String value) {
    this.properties.setProperty(key, value);
  }

  public String getProperty(String key) {
    return this.properties.getProperty(key);
  }

  public String getProperty(String key, String defaultValue) {
    return this.properties.getProperty(key, defaultValue);
  }
}
