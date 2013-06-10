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
import java.util.HashMap;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONUtilities;

public class HTTP_URL_JSON_Test {
	HTTP_URL_JSON_Test(String NotWOrking){
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
				//JSONInputStream jsonIn = new JSONInputStream(c.getInputStream());

				File aFile = new File ("/Users/Jason/Documents/GitHub/CIT_312/Java Source/JSON test file.txt");
				//JSONInputStream jsonIn = new JSONInputStream(new InputStream(c.));
				//ObjectInputStream objectin = new ObjectInputStream(jsonIn); 

				//GasStation gases = (GasStation)objectin.readObject();
				//BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
				//StringBuilder sb = new StringBuilder();
				//String line;
				//while ((line = br.readLine()) != null) {
				//    sb.append(line+"\n");
				//}
				//br.close();
				//json = sb.toString();
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
		/*catch (ClassNotFoundException e){
			System.out.println("Class not found");
			e.printStackTrace();
		}*/


		System.out.println(json);
	}

	/*
	 * This is the code that I found on the internet basically
	 */
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

			String country = (String)aMap.get("country");
			String zip = (String)aMap.get("zip");
			float price = (float)aMap.get("price");
			String date = (String)aMap.get("date");
			String address = (String)aMap.get("address");
			String diesel = (String)aMap.get("diesel");
			int id = (int)aMap.get("id");
			float lat = (float)aMap.get("lat");
			float lng = (float)aMap.get("lng");
			String station = (String)aMap.get("station");
			String region = (String)aMap.get("region");
			String city = (String)aMap.get("city");
			String distance = (String)aMap.get("distance");

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
