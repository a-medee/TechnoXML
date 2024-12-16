package fr.ensim.tp.xmjson.deezer.service.stax;

import fr.ensim.tp.xmjson.deezer.data.Album;
import fr.ensim.tp.xmjson.deezer.data.Track;
import fr.ensim.tp.xmjson.deezer.service.IHtmlAlbum;
import fr.ensim.tp.xmjson.deezer.service.dom.DOMSearchTrack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.sql.rowset.spi.XmlWriter;
import javax.swing.text.html.HTMLWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @author Denis Apparicio
 * 
 */
public class StAXHtmlAlbum implements IHtmlAlbum {
  private static Logger log = LogManager.getLogger();

  /**
   * Ecriture de la page HTML avec StaX.
   * 
   * @param album
   * @throws XMLStreamException
   * @throws IOException
   */
  @Override
  public void write(Album album, OutputStream outputStream) throws Exception {
    log.debug(">>write");
    List<Track> tracks = album.getTracks();
    XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();

    try {
      XMLStreamWriter writer = xmlOutputFactory.createXMLStreamWriter(outputStream);
      writer.writeStartElement("html");
      writer.writeStartElement("body");
      writer.writeStartElement("img");
      writer.writeAttribute("src", album.getCover());
      writer.writeAttribute("alt", album.getId());
      writer.writeStartElement("figcaption");
      writer.writeCharacters(album.getArtist().getName());
      writer.writeStartElement("br");
      for(Track track : tracks) {

        writer.writeStartElement("div");

        writer.writeStartElement("p");
        writer.writeAttribute("style", "display:inline;margin:12px;");
        writer.writeCharacters(track.getTitle().toLowerCase());
        writer.writeEndElement();
        writer.writeStartElement("audio");
        writer.writeAttribute("controls", "true");
        writer.writeAttribute("src", track.getPreview());

        writer.writeEndElement();
        writer.writeEndElement();
        writer.writeStartElement("br");
        writer.writeEndElement();

      }

      writer.writeEndElement();
      writer.writeEndElement();
      writer.writeEndElement();
      writer.writeEndElement();
      writer.writeEndElement();

      writer.flush();
    } finally {
      outputStream.close();
    }
    

    log.debug("<<write");
  }
}
