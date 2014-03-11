/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

  public void readPropertieFile(String completePath) throws IOException {
    FileTool fileTool = new FileTool();
    properties = new Properties();

    String fileContent = fileTool.fileToString(completePath);
    properties.load(new StringReader(fileContent.replace("\\", "\\\\")));
  }

  public String getProperty(String propertieKey) {
    return properties.getProperty(propertieKey);
  }

  public String getProperty(String propertieKey, String defaultValue) {
    return properties.getProperty(propertieKey, defaultValue);
  }
}
