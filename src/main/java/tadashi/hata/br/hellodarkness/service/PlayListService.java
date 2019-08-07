package tadashi.hata.br.hellodarkness.service;

import tadashi.hata.br.hellodarkness.domain.Artist;
import tadashi.hata.br.hellodarkness.domain.Song;

import java.util.List;

public interface PlayListService {
    List<Song> findRecomendedSongs();

    List<Artist> findRecomendedSinger();

    List<Song> findPlaylist();

    List<Song> findPlaylist(String genre);
}
