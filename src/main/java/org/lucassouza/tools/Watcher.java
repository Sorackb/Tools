package org.lucassouza.tools;

/**
 *
 * @author lucas.souza
 */
public interface Watcher {

  void notify(MessageType type, String message);
}
