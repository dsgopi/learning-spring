package com.test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TestJavaClass2 {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String str = "https://jsonplaceholder.typicode.com/posts";
//		String str = "Hi Hello";
//		char[] vowels = {'a','e','i','o'};
//		List<char[]> charsToCheck = Arrays.asList(vowels); 
//		char[] chars = str.toCharArray();
////		Arrays.asList(chars).stream().noneMatch(achar->achar!='e').
//		
//		System.out.println(str.trim());
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
							.GET()
							.header("accept", "application/json")
							.uri(URI.create(str))
							.build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		//System.out.println("Response is "+response.body());
		int sum=0;
		Pattern pattern = Pattern.compile("(\"userId\"\\:\\s)([0-9])([.\\s])+(\"id\"\\:\\s)([0-9])");
//		Pattern pattern = Pattern.compile("userId:\\s ");
		Matcher matcher = pattern.matcher(response.body());
		
		while(matcher.find()) {
			
			System.out.println("user id is "+matcher.group(3));
			
			if(!matcher.group(3).isEmpty())
				sum=sum+Integer.parseInt(matcher.group(3));
		}
		System.out.println("Int is "+sum);
	}

}
