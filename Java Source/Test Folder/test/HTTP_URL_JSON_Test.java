package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONUtilities;

public class HTTP_URL_JSON_Test {
	
	HTTP_URL_JSON_Test(){
		
		String lattitude = "43.8261";
		String longitude = "-111.7889";
		String gastype = "reg";
		String sortType = "price";
		String api = "rfej9napna";
		String url = "http://devapi.mygasfeed.com/stations/radius/"+ lattitude +"/"+longitude+"/10/"+gastype+"/"+sortType+"/"+api+".json";
		
		String json = new String();

		int timeout = 500;
		int status;

		try {
			URL u = new URL(url);
			HttpURLConnection c = (HttpURLConnection) u.openConnection();
			c.setRequestMethod("GET");
			c.setRequestProperty("Content-length", "0");
			c.setUseCaches(false);
			c.setAllowUserInteraction(false);
			c.setConnectTimeout(timeout);
			c.connect();
			status = c.getResponseCode();

			switch (status){
			case 200:
			case 201:
				BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
				StringBuilder sb = new StringBuilder();
				String line;
				while ((line = br.readLine()) != null) {
					sb.append(line+"\n");
				}
				br.close();
				json = sb.toString();
			}
		} 
		catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println("Bad URL");
			e.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IOException");
			e.printStackTrace();

		}
		System.out.println(url);
		System.out.println(json);

		try {
			HashMap aMap = (HashMap) JSONUtilities.parse(json);
			ArrayList list = (ArrayList) aMap.get("stations");
			HashMap firstStation = (HashMap)list.get(0);
			System.out.println("The region is "+firstStation.get("region") + " and the distance is "+ firstStation.get("distance"));

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
