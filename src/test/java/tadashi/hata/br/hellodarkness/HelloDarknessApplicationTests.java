package tadashi.hata.br.hellodarkness;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloDarknessApplicationTests {

	@LocalServerPort
	private int port;

	private final String HOST = "http://localhost:";

	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();

	// There is no data yet. The service is always returning 204.
	@Disabled
	public void testGetSongs200() {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/v1/songs"), HttpMethod.GET, entity, String.class);

		assertEquals(200, response.getStatusCode().value());
	}

	@Test
	public void testGetSongs204() {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/v1/songs?song-name=there-is-no-song-name-like-this"), HttpMethod.GET, entity, String.class);

		assertEquals(204, response.getStatusCode().value());
	}

	@Test
	public void testGetSongs204SongNameWith3Char() {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/v1/songs?song-name=kkk"), HttpMethod.GET, entity, String.class);

		assertEquals(204, response.getStatusCode().value());
	}

	@Test
	public void testGetSongs400SongNameLessThan3Char() {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/v1/songs?song-name=kk"), HttpMethod.GET, entity, String.class);

		assertEquals(400, response.getStatusCode().value());
	}

	@Test
	public void testGetSongs400SongNameAbove60Char() {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/v1/songs?song-name=kkkkkkkkkk0123456789kkkkkkkkkk0123456789kkkkkkkkkk0123456789k"), HttpMethod.GET, entity, String.class);

		assertEquals(400, response.getStatusCode().value());
	}

	private String createURLWithPort(String uri) {
		return HOST + port + uri;
	}

}
