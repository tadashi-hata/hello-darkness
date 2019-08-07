package tadashi.hata.br.hellodarkness.service.impl;

import org.springframework.stereotype.Service;
import tadashi.hata.br.hellodarkness.domain.Artist;
import tadashi.hata.br.hellodarkness.domain.Song;
import tadashi.hata.br.hellodarkness.service.PlayListService;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayListServiceImpl implements PlayListService {

    public List<Song> findRecomendedSongs(){
        return new ArrayList<>();
    }

    public List<Artist> findRecomendedSinger(){
        return  new ArrayList<>();
    }

    public List<Song> findPlaylist(){
        return  new ArrayList<>();
    }

    public List<Song> findPlaylist(String genre){
        return  new ArrayList<>();
    }
}
