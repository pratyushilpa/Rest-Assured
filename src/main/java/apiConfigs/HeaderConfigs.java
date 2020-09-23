package apiConfigs;

import java.util.HashMap;
import java.util.Map;

public class HeaderConfigs {
	public Map<String , String> defaultHeaders(){
		Map<String , String> default_Headers = new HashMap<String,String> ();
		default_Headers.put("Content-Type", "application/json");
		
		return default_Headers;
	}
	// we can create difft-difft HashMAP based on requirement
	public Map<String,String> headersWithToken(){
		Map<String, String> headers_with_token = new HashMap<String, String>();
		headers_with_token.put("Content-Type", "application/json");
		headers_with_token.put("Access-Token", "ajdsjaflksafajsfasfagsfjaskgasjfsagf");
		//headers_with_token.put("JWT-Token", "ajdsjaflksafajsfasfagsfjaskgasjfsagfadjhhafh");
		//headers_with_token.put("Tenet_user", "ajdsjaflksafajsfasfagsfjaskgasjfsagfllklkhajkkjs");
		return headers_with_token;
	}
/*public static void main(String[] args) {
	HeaderConfigs header = new HeaderConfigs();
	System.out.println(header.headersWithToken());
}*/
}
