package fr.ensim.tp.xmjson.deezer.service.sax;

import fr.ensim.tp.xmjson.deezer.data.Album;
import fr.ensim.tp.xmjson.deezer.data.Artist;
import fr.ensim.tp.xmjson.deezer.data.Track;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Denis Apparicio
 */
class SAXSearchAlbumsHandler extends DefaultHandler {
  private static final Logger log = LogManager.getLogger();

  private List<Album> listAlbum = new ArrayList<Album>();
  boolean isId, isTitle, isArtist, isTrack, isCover, isArtistId, isName, isPicture, isLink;

  int currentPosition = 0;
    /**
   * Restitue la liste des albums.
   *
   * @return
   */
  public List<Album> getListAlbum() {
    return listAlbum;
  }

  /*
   * (non-Javadoc)
   *
   * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String,
   * java.lang.String, java.lang.String, org.xml.sax.Attributes)
   */
  @Override
  public void startElement(String uri,
                           String localName,
                           String qName,
                           Attributes attributes) throws SAXException {

    if (log.isDebugEnabled()) {
      StringBuilder st = new StringBuilder();
      st.append('<');
      st.append(localName);
      // Attributs
      for (int i = 0; i < attributes.getLength(); i++) {
        st.append(' ');
        st.append(attributes.getLocalName(i));
        st.append('=');
        st.append(attributes.getValue(i));
      }
      st.append('>');
      log.debug(st);
    }

    if (localName.equals("album"))
    {
      listAlbum.add(new Album());
    }

    if (localName.equals("id"))
    {
      isArtistId = true;
    }
    if (localName.equals("title"))
    {
      isTitle = true;
    }
    if (localName.equals("cover")) {
      isCover = true;
    }
    if (localName.equals("artist"))
    {
      isArtist = true;
      listAlbum.get(listAlbum.size() - 1).setArtist(new Artist());
    }
    if (localName.equals("id") && !isArtist)
    {
      isId = true;
    }
    if (localName.equals("name")) {
      isName = true;
    }
    if (localName.equals("picture")) {
      isPicture = true;
    }
    if  (localName.equals("link")) {
      isLink = true;
    }
    if (localName.equals("name"))
    {
      isName = true;
    }

  }

  /*
   * (non-Javadoc) BufferedReader
   *
   * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String,
   * java.lang.String, java.lang.String)
   */
  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {
    if (log.isDebugEnabled()) {
      StringBuilder st = new StringBuilder();
      st.append("</");
      st.append(localName);
      st.append('>');
      log.debug(st);
    }

    if (localName.equals("title"))
    {
      isTitle = false;
    }
    if (localName.equals("artist"))
    {
      isArtist = false;
    }
    if (localName.equals("id") && !isArtist)
    {
      isId = false;
    }
    if (localName.equals("id"))
    {
      isArtistId = false;
    }
    if (localName.equals("cover")) {
      isCover = false;
    }
    if (localName.equals("link"))
    {
      isLink = false;
      }
    if (localName.equals("name"))
    {
      isName = false;
    }
    if (localName.equals("picture"))
    {
      isPicture = false;
    }
    if (localName.equals("tracklist"))
    {
      isTrack = false;
    }
  }

  /*
   * (non-Javadoc)
   *
   * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
   */
  @Override
  public void characters(char[] ch, int start, int length) throws SAXException
  {
    String s = new String(ch, start, length);
    if (s.trim().isEmpty()) return;

    if (isTitle)
    {
      listAlbum.get(listAlbum.size() - 1).setTitle(s);
    }
    if (isCover)
    {
      listAlbum.get(listAlbum.size() - 1).setCover(s);
    }
    if (isArtist && isArtistId)
    {
      listAlbum.get(listAlbum.size() - 1).getArtist().setId(s);
    }
    if (isId)
    {
      listAlbum.get(listAlbum.size() - 1).setId(s);
    }
    if (isLink && isArtist)
    {
      listAlbum.get(listAlbum.size() - 1).getArtist().setLink(s);
    }
    if (isName)
    {
      listAlbum.get(listAlbum.size() - 1).getArtist().setName(s);
    }
    if (isPicture)
    {
      listAlbum.get(listAlbum.size() - 1).getArtist().setPicture(s);
    }
  }

}
