package tadashi.hata.br.hellodarkness.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tadashi.hata.br.hellodarkness.domain.ApiResponse;
import tadashi.hata.br.hellodarkness.domain.Artist;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ArtistController {

    @GetMapping("/artists")
    public ResponseEntity<ApiResponse<List<Artist>>> findArtist(
            @Valid @RequestParam(value = "name", required = true) String name) {
        return new ResponseEntity<ApiResponse<List<Artist>>>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("/artists/{artist-id}")
    public ResponseEntity<ApiResponse<List<Artist>>> getArtistById(
            @PathVariable("artist-id") Long artistId) {
        return new ResponseEntity<ApiResponse<List<Artist>>>(HttpStatus.NOT_IMPLEMENTED);
    }
}