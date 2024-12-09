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
    assertEquals("489984705", albumList.get(0).getId());
    assertEquals("https://api.deezer.com/2.0/album/489984705/image", albumList.get(0).getCover());

    // 1er Artist du premier album
    assertEquals("6568023", albumList.get(0).getArtist().getId());
    assertEquals("https://www.deezer.com/artist/6568023", albumList.get(0).getArtist().getLink());
    assertEquals("Mannequin Pussy", albumList.get(0).getArtist().getName());
    assertEquals("https://api.deezer.com/2.0/artist/6568023/image", albumList.get(0).getArtist().getPicture());

    // dernier album
    assertEquals("So Much Fun (Deluxe)", albumList.get(albumList.size() - 1).getTitle());
    assertEquals("123857402", albumList.get(albumList.size() - 1).getId());
    assertEquals("https://api.deezer.com/2.0/album/123857402/image", albumList.get(albumList.size() - 1).getCover());

    // Artist du dernier album
    assertEquals("1590752", albumList.get(albumList.size() - 1).getArtist().getId());
    assertEquals("https://www.deezer.com/artist/1590752", albumList.get(albumList.size() - 1).getArtist().getLink());
    assertEquals("Young Thug", albumList.get(albumList.size() - 1).getArtist().getName());
    assertEquals("https://api.deezer.com/2.0/artist/1590752/image", albumList.get(albumList.size() - 1).getArtist().getPicture());

  }
}
