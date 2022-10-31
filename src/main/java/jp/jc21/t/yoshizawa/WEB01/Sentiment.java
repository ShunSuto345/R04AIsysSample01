package jp.jc21.t.yoshizawa.WEB01;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class Sentiment {

	public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
		Language1 message = getLanguage("It's incredibly sunny outside!");
		if (message != null) {
			System.out.println("positiveの確率:"+message.documents[0].confidenceScores.positive);
			System.out.println("neutralの確率:"+message.documents[0].confidenceScores.neutral);
			System.out.println("negativeの確率:"+message.documents[0].confidenceScores.negative);
		}
	}

	static Language1 getLanguage(String s) throws IOException, URISyntaxException, InterruptedException {
		Gson gson = new Gson();
		String Anser="";
		try {
			
			Language result=Json05.getLanguage(s);
			Anser = result.documents[0].detectedLanguage.iso6391Name;
		}catch(Exception e) {
			e.printStackTrace();
		}

		String url = "https://r04jk3a15-text.cognitiveservices.azure.com/" + "text/analytics/v3.0/sentiment";
		Map<String, String> map = new HashMap<>();
		map.put("Ocp-Apim-Subscription-Key", "6b554f9bb30b428f8acec04c5aa55fe6");
		
		Docs1 doc = new Docs1();
		//rang入る
		doc.language=Anser;
		doc.id = "1";
		doc.text = s;

		Source1 src = new Source1();
		src.documents = new Docs1[1];
		src.documents[0] = doc;

		String jsonData = new Gson().toJson(src);

		//InetSocketAddress proxy = new InetSocketAddress("172.17.0.2", 80);

		JsonReader reader = WebApiConnector.postJsonReader(url,  map, jsonData);
		Language1 message = null;
		if (reader != null) {
			message = gson.fromJson(reader, Language1.class);
			reader.close();
		}
		return message;
	}

}

class Language1 {
	Documents1[] documents;
	String[] errors;
	String modelVersion;
}

class Documents1 {
	String sentiment;
	ConfidenceScores confidenceScores;
}

class  ConfidenceScores{
	float positive;
	float neutral;
	float negative;
}

class Source1 {
	Docs1[] documents;
}

class Docs1 {
	String language;
	String id;
	String text;
}
