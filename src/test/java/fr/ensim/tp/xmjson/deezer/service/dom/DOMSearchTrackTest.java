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
    assertEquals(13, trackList.size());
  }
}