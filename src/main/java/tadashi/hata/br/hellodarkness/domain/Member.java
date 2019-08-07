package tadashi.hata.br.hellodarkness.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Member   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("first-name")
  private String firstName = null;

  @JsonProperty("last-name")
  private String lastName = null;

  @JsonProperty("birth-date")
  private LocalDate birthDate = null;

  @JsonProperty("website")
  private String website = null;

}

