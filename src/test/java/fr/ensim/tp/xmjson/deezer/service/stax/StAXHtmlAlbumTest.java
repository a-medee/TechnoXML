package fr.ensim.tp.xmjson.deezer.service.stax;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StAXHtmlAlbumTest {

    @Test
    void write() throws Exception {
         new StAXHtmlAlbum().write(null, null);
    }
}