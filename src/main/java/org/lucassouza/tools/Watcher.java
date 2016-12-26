package org.lucassouza.tools;

import java.util.logging.Level;

/**
 *
 * @author lucas.souza
 */
public interface Watcher {

  void notify(Level level, String message);
}
