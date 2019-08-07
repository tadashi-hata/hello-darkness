package tadashi.hata.br.hellodarkness.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Album   {
  @JsonProperty("artist")
  private Artist artist = null;

  @JsonProperty("songs")
  private List<Song> songs = null;

  @JsonProperty("released")
  private Long released = null;

}

