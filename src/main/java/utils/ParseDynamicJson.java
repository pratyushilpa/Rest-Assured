package utils;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

public class ParseDynamicJson {
	public static void parseObject(JSONObject json , String key) {
		System.out.println(json.has(key));
		System.out.println(json.get(key));
	}
	
	public static void getKey(JSONObject json, String key) {
		 boolean exists = json.has(key);
		 Iterator<?> keys;
		 String nextKeys;
		 if(!exists) {
			 keys=json.keys();
			 while(keys.hasNext()) {
				 nextKeys = (String) keys.next();
				 try {
					 if(json.get(nextKeys) instanceof JSONObject) {
						 if(exists==false) {
							 getKey(json.getJSONObject(nextKeys),key);
						 }
					 }
					 else if(json.get(nextKeys) instanceof JSONArray) {
						 JSONArray jsonArray = json.getJSONArray(nextKeys);
						 for(int i=0;i<jsonArray.length();i++) {
							 String jsonArrayString = jsonArray.get(i).toString();
							 JSONObject innerJson = new JSONObject(jsonArrayString);
							 if(exists==false) {
								 getKey(innerJson, key);
							 }
						 }
					 }
				 }
			 
				 catch(Exception e) {
					 
				 }
			 }
		 }
		 
		 else {
			 parseObject(json,key);
		 }
	}
public static void main(String[] args) {
	String inputJson = "{\r\n" + 
			"              \"name\": \"Copy Configs\",\r\n" + 
			"              \"commandUnitType\": \"COPY_CONFIGS\",\r\n" + 
			"              \"commandExecutionStatus\": \"QUEUED\",\r\n" + 
			"              \"artifactNeeded\": false,\r\n" + 
			"              \"deploymentType\": \"SSH\",\r\n" + 
			"              \"variables\": [],\r\n" + 
			"              \"destinationParentPath\": \"$WINGS_RUNTIME_PATH\"\r\n" + 
			"            }";
	JSONObject inputJSONObject = new JSONObject(inputJson);  
	getKey(inputJSONObject,"commandUnitType");
	    
}
}
