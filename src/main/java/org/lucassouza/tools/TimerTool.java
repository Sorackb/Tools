package org.lucassouza.tools;

import java.util.LinkedHashMap;

/**
 *
 * @author Lucas Souza <sorackb@gmail.com>
 */
public class TimerTool {
  private final LinkedHashMap<Object, Long> starts;
  
  public enum TimeUnit {

    MILLISECOND(1000000L),
    SECOND(1000000000L),
    MINUTE(60000000000L),
    HOUR(3600000000000L);
    private final Long proportionNano;

    TimeUnit(Long aProportionNano) {
      proportionNano = aProportionNano;
    }

    public Long getProportionNano() {
      return proportionNano;
    }
  }
  
  public TimerTool() {
    this.starts = new LinkedHashMap<>();
  }
  
  public void start(Object key) {
    this.starts.put(key, System.nanoTime());
  }
  
  public String calculateElapsedTime(String chave) {
    Long startTime = this.starts.get(chave);
    Long elapsedTime = System.nanoTime() - startTime;
    Long hourMod;
    Long minuteMod;
    Long secondMod;
    String elapsedTimeHour;
    String elapsedTimeMinute;
    String elapsedTimeSecond;
    String elapsedTimeMillisecond;
    String result;

    // Math of HOUR
    elapsedTimeHour = String.format("%02d", elapsedTime / TimeUnit.HOUR.getProportionNano());
    hourMod = elapsedTime % TimeUnit.HOUR.getProportionNano();
    // Math of MINUTE
    elapsedTimeMinute = String.format("%02d", hourMod / TimeUnit.MINUTE.getProportionNano());
    minuteMod = hourMod % TimeUnit.MINUTE.getProportionNano();
    // Math of SECOND
    elapsedTimeSecond = String.format("%02d", minuteMod / TimeUnit.SECOND.getProportionNano());
    secondMod = minuteMod % TimeUnit.SECOND.getProportionNano();
    // Math of MILLISECOND
    elapsedTimeMillisecond = String.format("%03d", secondMod / TimeUnit.MILLISECOND.getProportionNano());

    result = elapsedTimeHour + ":" + elapsedTimeMinute + ":" + elapsedTimeSecond + ":" + elapsedTimeMillisecond;

    return result;
  }
}
