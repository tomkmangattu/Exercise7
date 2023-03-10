package exercisepart2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class BrowserHistory {
	HashMap<String, ArrayList<String>> urlHistoryHashMap;
	LinkedHashMap<String, ArrayList<String>> urlHistoryLinkedHashMap;
	
	public BrowserHistory() {
		urlHistoryHashMap = new HashMap<>();
		urlHistoryLinkedHashMap = new LinkedHashMap<>();
	}
	
	void visit(String urlString) {
		String[] urlParts = urlString.split("\\.");
		String extension = urlParts[urlParts.length - 1];
		
		// hash map
		if(urlHistoryHashMap.containsKey(extension)) {
			ArrayList<String> value = urlHistoryHashMap.get(extension);
			value.add(urlString);
			urlHistoryHashMap.put(extension, value);
		}else {
			urlHistoryHashMap.put(extension, new ArrayList<>(Arrays.asList(urlString)));
		}
		
		// linked hash map
		if(urlHistoryLinkedHashMap.containsKey(extension)) {
			ArrayList<String> value = urlHistoryLinkedHashMap.get(extension);
			value.add(urlString);
			urlHistoryLinkedHashMap.put(extension, value);
		}else {
			urlHistoryLinkedHashMap.put(extension, new ArrayList<>(Arrays.asList(urlString)));
		}
		
	}
	
	void fetch(String extension) {
		
		// hash map
		try {
			ArrayList<String> valueArrayList = urlHistoryHashMap.get(extension);
			System.out.println(valueArrayList.toString());
		}catch (NullPointerException e) {
			System.out.println("Unable to find urls corresponding to extension " + extension);
		}
		
		// linked hash map
		try {
			ArrayList<String> valueArrayList = urlHistoryLinkedHashMap.get(extension);
			System.out.println(valueArrayList.toString());
		}catch (NullPointerException e) {
			System.out.println("Unable to find urls corresponding to extension " + extension);
		}
	
	}
	
	void delete(String extension) {
		
		// hash map
		if(urlHistoryHashMap.containsKey(extension)) {
			urlHistoryHashMap.remove(extension);
		}else {
			System.out.println("Not able to find urls corresponding to extension " + extension);
		}
		
		// linked hash map
		if(urlHistoryLinkedHashMap.containsKey(extension)) {
			urlHistoryLinkedHashMap.remove(extension);
		}else {
			System.out.println("Not able to find urls corresponding to extension " + extension);
		}
	}
	
	void getSize(String extension) {
		
		// hash map
		try {
			int size = urlHistoryHashMap.get(extension).size();
			System.out.println("Number of urls with extension " + extension + " is :" + size);
		}catch (NullPointerException e) {
			System.out.println("Unable to find urls corresponding to extension " + extension);
		}
		
		// linked hash map
		try {
			int size = urlHistoryLinkedHashMap.get(extension).size();
			System.out.println("Number of urls with extension " + extension + " is :" + size);
		}catch (NullPointerException e) {
			System.out.println("Unable to find urls corresponding to extension " + extension);
		}
	
	}
	
	void search(String searchWord) {
		ArrayList<String> searchResult = new ArrayList<>();
		
		// hash map
		try {
			Set<String> keys = urlHistoryHashMap.keySet();
			ArrayList<String> urls = new ArrayList<>();
			for(String key : keys) {
				
				urls = urlHistoryHashMap.get(key);
				for(String url : urls) {
					if(url.contains(searchWord)) {
						searchResult.add(url);
					}
				}
			}
			if(searchResult.isEmpty()) {
				System.out.println("No url found for search word : " + searchWord);
			}else {
				System.out.println("Search results are :");
				System.out.println(searchResult.toString());
			}
		}catch (NullPointerException e) {
			System.out.println("No urls to search");
		}
		
		// linked hash map

		
		searchResult.clear();
		for(Map.Entry<String, ArrayList<String>> mapEntry : urlHistoryLinkedHashMap.entrySet()) {
			ArrayList<String> urlList = mapEntry.getValue();
			
			for(String urlString : urlList) {
				if(urlString.contains(searchWord)) {
					searchResult.add(urlString);
				}
			}
		}
		if(searchResult.isEmpty()) {
			System.out.println("No url found for search word : " + searchWord);
		}else {
			System.out.println("Search results are :");
			System.out.println(searchResult.toString());
		}
		
	}
}
