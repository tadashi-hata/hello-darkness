package tadashi.hata.br.hellodarkness.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tadashi.hata.br.hellodarkness.domain.ApiResponse;
import tadashi.hata.br.hellodarkness.domain.Song;
import tadashi.hata.br.hellodarkness.service.SongService;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@Validated
public class SongController {

    @Autowired
    private SongService songService;

    @GetMapping("/songs")
    public ResponseEntity<ApiResponse<List<Song>>> findSongs(
            @RequestParam(value = "song-name", required = false) @Min(3) @Max(60) String songName
    ) {
        List<Song> songs = songService.findSongs(songName);

        if(songs.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity(new ApiResponse(songs), HttpStatus.OK);
    }

    @GetMapping("/songs/trends")
    public ResponseEntity<ApiResponse<List<Song>>> findTrendSongs() {
        List<Song> songs = songService.findTrendsSongs();

        if(songs.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(new ApiResponse(songs), HttpStatus.OK);
    }
}
