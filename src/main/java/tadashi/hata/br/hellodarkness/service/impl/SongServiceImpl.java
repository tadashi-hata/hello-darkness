package tadashi.hata.br.hellodarkness.service.impl;

import org.springframework.stereotype.Service;
import tadashi.hata.br.hellodarkness.domain.Song;
import tadashi.hata.br.hellodarkness.service.SongService;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    public List<Song> findSongs(String songName){
        return new ArrayList<>();
    }

    public List<Song> findTrendsSongs() {
        return new ArrayList<>();
    }
}
