package tadashi.hata.br.hellodarkness.web;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import tadashi.hata.br.hellodarkness.domain.ApiResponse;
import tadashi.hata.br.hellodarkness.domain.Genre;
import tadashi.hata.br.hellodarkness.domain.Song;
import tadashi.hata.br.hellodarkness.service.SongService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
public class SongsControllerTest {

    @InjectMocks
    private SongController controller;

    @Mock
    private SongService service;

    private List<Song> songs;

    @Before
    public void before() {
        songs = new ArrayList<>();
        songs.add(new Song(1001L, "The sound of Silence", "", Arrays.asList(Genre.POP), 1964));
    }

    @Test
    public void findSongsTest(){
        when(service.findSongs(any(String.class))).thenReturn(songs);

        ResponseEntity<ApiResponse<List<Song>>> response = controller.findSongs("");

        Assert.assertEquals(200, response.getStatusCode().value());
        Assert.assertEquals(1, response.getBody().getData().size());
    }

    @Test
    public void findSongsNoContentTest(){
        // Arrange
        when(service.findSongs(any(String.class))).thenReturn(new ArrayList<>());

        // Act
        ResponseEntity<ApiResponse<List<Song>>> response =controller.findSongs("");

        // Assert
        Assert.assertEquals(204, response.getStatusCode().value());
    }

}