package com.adesh.client_server_connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;



/**
 * Hello world!
 *
 */
public class App 
{
    private static final String TOKEN_REQUEST_URL = "http://localhost:9192/authenticate";
    private static String username = "user1";
    private static String password = "pwd1";
    
    private final String FILENAME = null;
    static Socket socket;
    static BufferedReader read;
    static PrintWriter output;

    
    public static void serverConnect() throws IOException {
    	//OutputStream os;
    	URL url = new URL (TOKEN_REQUEST_URL);
    	HttpURLConnection con = (HttpURLConnection)url.openConnection();
    	con.setRequestMethod("POST");
    	con.setRequestProperty("Content-Type", "application/json");
    	con.setRequestProperty("Accept", "application/json");
    	con.setDoOutput(true);
    	//OutputStream os;
    	String jsonInputString = "{\"userName\": \"user1\", \"password\": \"pwd1\"}";
    	try {
    		OutputStream os = con.getOutputStream();
    	    byte[] input = jsonInputString.getBytes("utf-8");
    	    os.write(input, 0, input.length);			
    	}
    	catch (Exception e) {
			// TODO: handle exception
    		System.out.println(e);
		}
    	
    	try {
    		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
		    StringBuilder response = new StringBuilder();
		    String responseLine = null;
		    while ((responseLine = br.readLine()) != null) {
		        response.append(responseLine.trim());
		    }
		    System.out.println(response.toString());
    	}
    	catch (Exception e) {
			// TODO: handle exception
    		System.out.println(e);
		}
    }

	public static void main( String[] args )
    {
    	try {
    		App.serverConnect();
    	}catch (Exception e) {
			// TODO: handle exception
    		System.out.println(e);
		}
    }
}
