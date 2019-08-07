package tadashi.hata.br.hellodarkness.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Artist   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("genre")
  private List<Genre> genre = null;

  @JsonProperty("members")
  private List<Member> members = null;

  @JsonProperty("albums")
  private Album albums = null;

}

