package tadashi.hata.br.hellodarkness.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import tadashi.hata.br.hellodarkness.domain.ApiResponse;
import tadashi.hata.br.hellodarkness.domain.Genre;
import tadashi.hata.br.hellodarkness.domain.Song;
import tadashi.hata.br.hellodarkness.service.SongService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SongsControllerTest {

    @InjectMocks
    private SongController controller;

    @Mock
    private SongService service;

    private List<Song> songs;

    @BeforeEach
    public void before() {
        songs = new ArrayList<>();
        songs.add(new Song(1001L, "The sound of Silence", "", Arrays.asList(Genre.POP), 1964));
    }

    @Test
    @DisplayName("find songs without parameters is working")
    public void findSongsTest(){
        // Arrange
        when(service.findSongs(any(String.class))).thenReturn(songs);

        // Act
        ResponseEntity<ApiResponse<List<Song>>> response = controller.findSongs("");

        // Assert
        assertEquals(200, response.getStatusCode().value());
        assertEquals(1, response.getBody().getData().size());
    }

    @Test
    @DisplayName("No Content Status is working")
    public void findSongsNoContent(){
        when(service.findSongs(any(String.class))).thenReturn(new ArrayList<>());

        ResponseEntity<ApiResponse<List<Song>>> response =controller.findSongs("");

        assertEquals(204, response.getStatusCode().value());
    }

    @Test
    @DisplayName("Song Name parameter with 3 char is valid.")
    public void findSongsSongName3Char(){
        when(service.findSongs(any(String.class))).thenReturn(songs);
        ResponseEntity<ApiResponse<List<Song>>> response =controller.findSongs("kkk");

        assertEquals(200, response.getStatusCode().value());
    }

    @Test
    @DisplayName("Song Name parameter with 60 char is valid")
    public void findSongsSongName60Char(){
        when(service.findSongs(any(String.class))).thenReturn(songs);
        ResponseEntity<ApiResponse<List<Song>>> response =controller.findSongs("kkkkk12345kkkkk12345kkkkk12345kkkkk12345kkkkk12345kkkkk12345");

        assertEquals(200, response.getStatusCode().value());
    }

    @Test
    @DisplayName("Song name parameter with less than 3 char is invalid")
    public void findSongsBadRequestSongNameLessThan3Char(){
        ResponseEntity<ApiResponse<List<Song>>> response =controller.findSongs("kk");

        assertEquals(400, response.getStatusCode().value());
    }

    @Test
    @DisplayName("Song name parameter with more than 60 char is invalid")
    public void findSongsBadRequestSongNameMoreThan60Char(){
        ResponseEntity<ApiResponse<List<Song>>> response =controller.findSongs("kkkkk12345kkkkk12345kkkkk12345kkkkk12345kkkkk12345kkkkk12345k");

        assertEquals(400, response.getStatusCode().value());
    }
}