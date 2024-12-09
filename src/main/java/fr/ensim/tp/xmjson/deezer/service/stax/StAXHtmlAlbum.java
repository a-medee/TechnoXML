package fr.ensim.tp.xmjson.deezer.service.stax;

import fr.ensim.tp.xmjson.deezer.data.Album;
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

    XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();

    try {
      XMLStreamWriter writer = xmlOutputFactory.createXMLStreamWriter(outputStream);
      writer.writeStartElement("html");
      writer.writeStartElement("body");
      writer.writeStartElement("p");
      writer.writeCharacters("This is the body of the html page");
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
