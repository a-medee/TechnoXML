package fr.ensim.tp.xmjson.deezer.service.dom;

import fr.ensim.tp.xmjson.deezer.data.Track;
import fr.ensim.tp.xmjson.deezer.service.AbstractSearchTrack;
import fr.ensim.tp.xmjson.deezer.service.Output;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.List;

public class DOMSearchTrack extends AbstractSearchTrack {
  private static Logger log = LogManager.getLogger();

  @Override
  public Output format() {
    return Output.XML;
  }

  @Override
  public List<Track> readTracks(InputStream in) throws Exception {
    log.debug(">>readTracks");


    // recuperation d'un parser DOM
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    dbFactory.setNamespaceAware(true);
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse(in);
    doc.normalize();

    // parsing
    NodeList nodeList = doc.getElementsByTagName("track");
    for (int i = 0; i < nodeList.getLength(); i++) {
      Element elTrack = (Element) nodeList.item(i);
      elTrack.getElementsByTagName("title").item(0).getTextContent();
    }
    log.debug("<<readTracks");
    return null;
  }
}
