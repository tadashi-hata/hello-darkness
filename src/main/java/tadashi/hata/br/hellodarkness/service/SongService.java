package tadashi.hata.br.hellodarkness.service;

import tadashi.hata.br.hellodarkness.domain.Song;

import java.util.List;

public interface SongService {
    List<Song> findSongs(String songName);
    List<Song> findTrendsSongs();
}
