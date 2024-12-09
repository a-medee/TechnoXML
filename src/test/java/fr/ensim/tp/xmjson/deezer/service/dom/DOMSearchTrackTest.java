package fr.ensim.tp.xmjson.deezer.service.dom;

import fr.ensim.tp.xmjson.deezer.data.Track;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DOMSearchTrackTest {

  @Test
  void readTracks() throws Exception {
    InputStream in = getClass().
        getResourceAsStream("/data/album-99051592.xml");

    DOMSearchTrack domSearchTrack = new DOMSearchTrack();
    List<Track> trackList = domSearchTrack.readTracks(in);

    // Track list
    assertEquals(10, trackList.size());

    // 1er track
    assertEquals("Patience", trackList.get(0).getTitle());
    assertEquals("https://cdn-preview-1.dzcdn.net/stream/c-1fda8214feefd311083a47b7ed4aee68-3.mp3", trackList.get(0).getPreview());

    // dernier track
    assertEquals("In Love Again", trackList.get(trackList.size() - 1).getTitle());
    assertEquals("https://cdn-preview-a.dzcdn.net/stream/c-af1e54782fd5173e269eb9a8c87882ce-3.mp3", trackList.get(trackList.size() - 1).getPreview());
  }
}