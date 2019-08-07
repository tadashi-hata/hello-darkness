package tadashi.hata.br.hellodarkness.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Genre {
  
  POP("pop"),
  
  ROCK("rock"),
  
  HEAVY_METAL("heavy-metal"),
  
  OTHERS("others");

  private String value;

  Genre(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static Genre fromValue(String text) {
    for (Genre b : Genre.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}

