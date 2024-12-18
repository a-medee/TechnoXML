package fr.ensim.tp.xmjson.deezer.service.json;

import fr.ensim.tp.xmjson.deezer.data.Album;
import fr.ensim.tp.xmjson.deezer.service.AbstractSearchAlbum;
import fr.ensim.tp.xmjson.deezer.service.Output;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class JSONSearchAlbums extends AbstractSearchAlbum {
	private static Logger log = LogManager.getLogger();

	@Override
	public Output format() {
		return Output.JSON;
	}

	@Override
	public List<Album> readAlbums(InputStream in) throws IOException, JSONException {

		//TODO: to be continued
		JSONObject root = new JSONObject(new JSONTokener(in));
		System.out.println(root.getJSONArray("albums"));
		return null;
	}

}
