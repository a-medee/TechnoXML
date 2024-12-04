package fr.ensim.tp.xmjson.deezer.service.sax;

import fr.ensim.tp.xmjson.deezer.data.Album;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SAXSearchAlbumsTest {

  @Test
  void readAlbums() throws ParserConfigurationException, IOException, SAXException {

    InputStream in = getClass().getResourceAsStream("/data/list-album-mannequinpussy.xml");

    SAXSearchAlbums sax = new SAXSearchAlbums();
    List<Album> albumList = sax.readAlbums(in);

    assertNotNull(albumList);
    assertEquals(25, albumList.size());

    // 1er album
    assertEquals("I Got Heaven", albumList.get(0).getTitle());
    assertEquals("https://api.deezer.com/2.0/album/489984705/image", albumList.get(0).getCover());
    assertEquals("489984705", albumList.get(0).getId());
  }
}
