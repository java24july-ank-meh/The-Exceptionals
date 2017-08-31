package com.revature.application.slackapi;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.revature.application.model.Apartment;
import com.revature.application.model.ApartmentComplex;

@Component
public class Slack {
	
	public String updateApartmentName(Apartment apt, Apartment oldApartment) {
String channelId = null;
		Apartment apartment = apt;
		try {
			String requestUrl = "https://slack.com/api/channels.list?token=" +
			"xoxp-229600595489-230131963906-233829842706-5845cfcf77a37f8ac146986f84c4f460";
			URL url = new URL(requestUrl);
			HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
			httpCon.setDoOutput(true);
			httpCon.setRequestMethod("GET");
			
			ApartmentComplex complex = oldApartment.getComplex();
			//slack channel naming must be 21 characters or less
			String shortenedComplexName;
			if(complex.getName().length() > 17) {
				shortenedComplexName =complex.getName().replaceAll("\\s","").substring(0, 17);
			} else {
				shortenedComplexName = complex.getName().replaceAll("\\s","");
			}
			
			String shortenedComplexName2;
			if(apartment.getComplex().getName().length() > 17) {
				shortenedComplexName2 =apartment.getComplex().getName().replaceAll("\\s","").substring(0, 17);
			} else {
				shortenedComplexName2 = apartment.getComplex().getName().replaceAll("\\s","");
			}
			String channelName = shortenedComplexName+ new Integer(oldApartment.getApartmentNumber()).toString(); 
			String newChannelName = shortenedComplexName2 + new Integer(apartment.getApartmentNumber()).toString(); 
			
			BufferedReader br = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
			JsonObject jobj = new Gson().fromJson(br.readLine(), JsonObject.class);
			JsonArray jarray = jobj.get("channels").getAsJsonArray();
			for(int i = 0; i < jarray.size(); ++i) {
				if(channelName.toLowerCase().equals(jarray.get(i).getAsJsonObject().get("name").getAsString())) {
					channelId = jarray.get(i).getAsJsonObject().get("id").getAsString();
				}
			}
			System.out.println("channelname: " + channelName + " id:"+channelId);
			
			requestUrl = "https://slack.com/api/channels.rename?token=" +
			"xoxp-229600595489-230131963906-233829842706-5845cfcf77a37f8ac146986f84c4f460&channel=" +channelId+
			"&name="+newChannelName;
			url = new URL(requestUrl);
			httpCon = (HttpURLConnection) url.openConnection();
			httpCon.setDoOutput(true);
			httpCon.setRequestMethod("GET");
			
			br = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
			return br.readLine();
			
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "channel failed to update";
	}
	
	
	public String deleteApartment(Apartment apartment) {
		String channelId = null;
		try {
			String requestUrl = "https://slack.com/api/channels.list?token=" +
			"xoxp-229600595489-230131963906-233829842706-5845cfcf77a37f8ac146986f84c4f460";
			URL url = new URL(requestUrl);
			HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
			httpCon.setDoOutput(true);
			httpCon.setRequestMethod("GET");
			
			ApartmentComplex complex = apartment.getComplex();
			//slack channel naming must be 21 characters or less
			String shortenedComplexName;
			if(complex.getName().length() > 17) {
				shortenedComplexName =complex.getName().replaceAll("\\s","").substring(0, 17);
			} else {
				shortenedComplexName = complex.getName().replaceAll("\\s","");
			}
			String channelName = shortenedComplexName+ new Integer(apartment.getApartmentNumber()).toString(); 
			
			
			BufferedReader br = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
			JsonObject jobj = new Gson().fromJson(br.readLine(), JsonObject.class);
			JsonArray jarray = jobj.get("channels").getAsJsonArray();
			for(int i = 0; i < jarray.size(); ++i) {
				if(channelName.toLowerCase().equals(jarray.get(i).getAsJsonObject().get("name").getAsString())) {
					channelId = jarray.get(i).getAsJsonObject().get("id").getAsString();
				}
			}
			System.out.println("channelname: " + channelName + " id:"+channelId);
			
			requestUrl = "https://slack.com/api/channels.archive?token=" +
			"xoxp-229600595489-230131963906-233829842706-5845cfcf77a37f8ac146986f84c4f460&channel=" +channelId;
			url = new URL(requestUrl);
			httpCon = (HttpURLConnection) url.openConnection();
			httpCon.setDoOutput(true);
			httpCon.setRequestMethod("GET");
			
			br = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
			return br.readLine();
			
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Failed to delete slack channel";
	}
	
	public String sendApartmentComplexMessage(ApartmentComplex complex, String message) {
		
String channelId = null;
		
		String shortenedComplexName;
		if(complex.getName().length() > 17) {
			shortenedComplexName =complex.getName().replaceAll("\\s","").substring(0, 17);
		} else {
			shortenedComplexName = complex.getName().replaceAll("\\s","");
		}
		
		try {
			String requestUrl = "https://slack.com/api/channels.list?token=" +
			"xoxp-229600595489-230131963906-233829842706-5845cfcf77a37f8ac146986f84c4f460";
			URL url = new URL(requestUrl);
			HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
			httpCon.setDoOutput(true);
			httpCon.setRequestMethod("GET");
			
			//slack channel naming must be 21 characters or less
			String channelName = shortenedComplexName; 
			
			
			BufferedReader br = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
			JsonObject jobj = new Gson().fromJson(br.readLine(), JsonObject.class);
			JsonArray jarray = jobj.get("channels").getAsJsonArray();
			for(int i = 0; i < jarray.size(); ++i) {
				if(channelName.toLowerCase().equals(jarray.get(i).getAsJsonObject().get("name").getAsString())) {
					channelId = jarray.get(i).getAsJsonObject().get("id").getAsString();
				}
			}
			
			requestUrl = "https://slack.com/api/chat.postMessage";
			url = new URL(requestUrl);
			
			String urlParameters  = "token=xoxp-229600595489-230131963906-233829842706-5845cfcf77a37f8ac146986f84c4f460" +
					 "&channel="+ channelId+"&text=" + message;
			byte[] postData       = urlParameters.getBytes( StandardCharsets.UTF_8 );
			int    postDataLength = postData.length;
			String request        = "http://example.com/index.php";
			httpCon = (HttpURLConnection) url.openConnection();
			httpCon.setDoOutput(true);
			httpCon.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded"); 
			httpCon.setRequestProperty( "charset", "utf-8");
			httpCon.setRequestProperty( "Content-Length", Integer.toString( postDataLength ));
			try( DataOutputStream wr = new DataOutputStream( httpCon.getOutputStream())) {
				   wr.write( postData );
				}
			br = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
			System.out.println(br.readLine());
		} catch(Exception e) {
			e.printStackTrace();
		}
			
		
		return null;
	}

	public String sendApartmentMessage(Apartment apartment, String message) {

		String channelId = null;
		try {
			String requestUrl = "https://slack.com/api/channels.list?token="
					+ "xoxp-229600595489-230131963906-233829842706-5845cfcf77a37f8ac146986f84c4f460";
			URL url = new URL(requestUrl);
			HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
			httpCon.setDoOutput(true);
			httpCon.setRequestMethod("GET");

			ApartmentComplex complex = apartment.getComplex();
			// slack channel naming must be 21 characters or less
			String shortenedComplexName;
			if (complex.getName().length() > 17) {
				shortenedComplexName = complex.getName().replaceAll("\\s", "").substring(0, 17);
			} else {
				shortenedComplexName = complex.getName().replaceAll("\\s", "");
			}
			String channelName = shortenedComplexName + new Integer(apartment.getApartmentNumber()).toString();

			BufferedReader br = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
			JsonObject jobj = new Gson().fromJson(br.readLine(), JsonObject.class);
			JsonArray jarray = jobj.get("channels").getAsJsonArray();
			for (int i = 0; i < jarray.size(); ++i) {
				if (channelName.toLowerCase().equals(jarray.get(i).getAsJsonObject().get("name").getAsString())) {
					channelId = jarray.get(i).getAsJsonObject().get("id").getAsString();
				}
			}
			System.out.println("channelname: " + channelName + " id:" + channelId);

			requestUrl = "https://slack.com/api/channels.archive";
			url = new URL(requestUrl);

			httpCon = (HttpURLConnection) url.openConnection();
			httpCon.setDoOutput(true);
			httpCon.setRequestMethod("POST");

			httpCon.setRequestProperty("token",
					"xoxp-229600595489-230131963906-233829842706-5845cfcf77a37f8ac146986f84c4f460");
			httpCon.setRequestProperty("channel", channelId);
			httpCon.setRequestProperty("text", message);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
