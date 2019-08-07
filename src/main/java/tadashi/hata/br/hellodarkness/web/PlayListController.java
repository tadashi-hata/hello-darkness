package tadashi.hata.br.hellodarkness.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tadashi.hata.br.hellodarkness.domain.ApiResponse;
import tadashi.hata.br.hellodarkness.domain.Playlist;
import tadashi.hata.br.hellodarkness.service.impl.PlayListServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PlayListController {

    @Autowired
    private PlayListServiceImpl service;

    @PostMapping("/playlists")
    public ResponseEntity<ApiResponse<Playlist>> createANewPlaylist(
            @Valid @RequestBody Playlist body) {
        return new ResponseEntity<ApiResponse<Playlist>>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("/playlists")
    public ResponseEntity<ApiResponse<List<Playlist>>> findPlaylist() {
        return new ResponseEntity<ApiResponse<List<Playlist>>>(HttpStatus.NOT_IMPLEMENTED);
    }
}
