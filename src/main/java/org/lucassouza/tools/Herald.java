package org.lucassouza.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 *
 * @author Lucas Souza [sorackb@gmail.com]
 */
public class Herald {

  private static final List<Watcher> OBSERVERS;

  static {
    OBSERVERS = new ArrayList<>();
  }

  public static void observe(Watcher observer) {
    OBSERVERS.add(observer);
  }

  public static void unobserve(Watcher observer) {
    OBSERVERS.remove(observer);
  }

  public static void notify(MessageType type, String message) {
    System.out.println(type + ": " + message);

    OBSERVERS.forEach(observer -> {
      observer.notify(type, message);
    });
  }
}
