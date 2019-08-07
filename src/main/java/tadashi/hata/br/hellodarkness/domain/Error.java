package tadashi.hata.br.hellodarkness.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Error   {
  @JsonProperty("code")
  private String code = null;

  @JsonProperty("description")
  private String description = null;

}

