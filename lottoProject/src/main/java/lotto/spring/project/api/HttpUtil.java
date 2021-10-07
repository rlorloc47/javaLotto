package lotto.spring.project.api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.simple.parser.JSONParser;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.fasterxml.jackson.core.io.JsonEOFException;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class HttpUtil {
	 
    //public static void callApi(JsonObject params, String type){
	public static String callApi(JsonObject params, String type){
        System.out.println("나는야 시작1");
        HttpURLConnection conn = null;
        JsonObject responseJson = null;
        System.out.println("나는야 시작2");
        String response = "";
        try {
        	System.out.println("나는야 시작3");
            //URL 설정
            //URL url = new URL("http://localhost:8080/apiRest");
        	//URL url = new URL("http://localhost:8080/test/api/action");
        	URL url = new URL("http://localhost:8080/apiAjax");
 
            conn = (HttpURLConnection) url.openConnection();
            System.out.println("나는야 시작4");
            
            // type의 경우 POST, GET, PUT, DELETE 가능
            conn.setRequestMethod(type);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Transfer-Encoding", "chunked");
            conn.setRequestProperty("Connection", "keep-alive");
            conn.setDoInput(true);
            //conn.setDoOutput(true);
            System.out.println("나는야 시작5");
            
            
            /*BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            // JSON 형식의 데이터 셋팅
            JsonObject commands = new JsonObject();
            JsonArray jsonArray = new JsonArray();
            
            params.addProperty("key", 1);
            params.addProperty("age", 20);
            params.addProperty("userNm", "홍길동");
 
            commands.add("userInfo", params);
             // JSON 형식의 데이터 셋팅 끝
            System.out.println("나는야 시작6");
            
            // 데이터를 STRING으로 변경
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonOutput = gson.toJson(commands);
                 
            bw.write(commands.toString());
            bw.flush();
            bw.close();
            

            // 보내고 결과값 받기
            int responseCode = conn.getResponseCode();

            System.out.println("나는야 시작7 :: "+responseCode);
            if (responseCode == 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line = "";
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                //responseJson = new JsonObjec(sb.toString());
                JSONParser parser = new JSONParser();
                Object obj = parser.parse(sb.toString());
                responseJson = (JsonObject) obj;
                
                // 응답 데이터
                System.out.println("responseJson :: " + responseJson);
            } */
            Charset charset = Charset.forName("UTF-8");
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));
			
			String inputLine;			
			StringBuffer sb = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				sb.append(inputLine);
			}
			br.close();
			
			response = sb.toString();
			
			JsonParser parser = new JsonParser();
            Object obj = parser.parse(sb.toString());
            responseJson = (JsonObject) obj;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception  e) {
            System.out.println("not JSON Format response");
            e.printStackTrace();
        }
        return response;
    }
}
