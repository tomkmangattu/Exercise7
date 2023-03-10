package exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeSet;


public class BrowserHistory {
	ArrayList<String> historyArrayList;
	LinkedList<String> historyLinkedList;
	HashSet<String> historyHashSet;
	LinkedHashSet<String> historyLinkedHashSet;
	TreeSet<String> historyTreeSet;
	
	BrowserHistory(){
		historyArrayList = new ArrayList<>();
		historyLinkedList = new LinkedList<>();
		
		historyHashSet = new HashSet<>();
		historyLinkedHashSet = new LinkedHashSet<>();
		historyTreeSet = new TreeSet<>();
		
	}
	
	void visit(String url) {
		historyArrayList.add(url);
		historyLinkedList.add(url);
		
		historyHashSet.add(url);
		historyLinkedHashSet.add(url);
		historyTreeSet.add(url);
	}
	
	void sort() {
		Collections.sort(historyArrayList);
		Collections.sort(historyLinkedList);
		
		ArrayList<String> hashSetList = new ArrayList<>(historyHashSet);
		Collections.sort(hashSetList);
		ArrayList<String> linkedHashSetList = new ArrayList<>(historyLinkedHashSet);
		Collections.sort(linkedHashSetList);
		
		historyHashSet = new HashSet<>(hashSetList);
		historyLinkedHashSet = new LinkedHashSet<>(linkedHashSetList);
		// display
		
		displayHistory();
	}
	
	void getSize() {
		System.out.println("Size of history arrarList : "+ historyArrayList.size());
		System.out.println("Size of history linked list :" + historyLinkedList.size());
		System.out.println("Size of history hash set :" +  historyHashSet.size());
		System.out.println("Size of history linked hash set :" + historyLinkedHashSet.size());
	}
	
	void displaySearchResult(ArrayList<String> urlsWithExtension, String extension, String listName) {
		System.out.println("\tUrls with extension " + extension + " in " + listName);
		for(String urlString : urlsWithExtension) {
			System.out.println(urlString);
		}
	}
	
	void updateHistory(int index, String correctedUrl) {
		index -= 1;
		
		String oldUrl = historyArrayList.get(index);
		historyArrayList.set(index, correctedUrl);
		
		// linked list
		
		for(int idx = 0; idx < historyLinkedList.size(); idx ++) {
			if(oldUrl.equals(historyLinkedList.get(idx))) {
				historyLinkedList.set(idx, correctedUrl);
			}
		}
		
		// hash set
		
		historyHashSet.remove(oldUrl);
		historyHashSet.add(correctedUrl);
		
		// linked hash set
		
		historyLinkedHashSet.remove(oldUrl);
		historyLinkedHashSet.add(correctedUrl);
		
	}
	
	void search(String extension) {
		
		ArrayList<String> urlsWithExtension = new ArrayList<>();
		
		for(String urlString : historyArrayList) {
			if(urlString.endsWith(extension)) {
				urlsWithExtension.add(urlString);
			}
		}
		if(! urlsWithExtension.isEmpty()) {
			displaySearchResult(urlsWithExtension, extension, "array list");
		}
		urlsWithExtension.clear();
		
		for(String urlString : historyLinkedList) {
			if(urlString.endsWith(extension)) {
				urlsWithExtension.add(urlString);
			}		
		}
		if(! urlsWithExtension.isEmpty()) {
			displaySearchResult(urlsWithExtension, extension, "linked list");
		}
		urlsWithExtension.clear();
		
		for(String urlString : historyHashSet) {
			if(urlString.endsWith(extension)) {
				urlsWithExtension.add(urlString);
			}	
		}
		if(! urlsWithExtension.isEmpty()) {
			displaySearchResult(urlsWithExtension, extension, "hash set");
		}
		urlsWithExtension.clear();
		
		
		for(String urlString : historyLinkedHashSet) {
			if(urlString.endsWith(extension)) {
				urlsWithExtension.add(urlString);
			}
		}
		if(! urlsWithExtension.isEmpty()) {
			displaySearchResult(urlsWithExtension, extension, "linked hash set");
		}
		urlsWithExtension.clear();
	}
	
	void displayHistory() {
		System.out.println("\tHistory form ArrayList");
		for(int index = 0; index < historyArrayList.size(); index++) {
			System.out.println((index + 1) + ". " + historyArrayList.get(index));
		}
		
		System.out.println("\tHistory form LinkedList");
		for(int index = 0; index < historyLinkedList.size(); index++) {
			System.out.println((index + 1) + ". " + historyLinkedList.get(index));
		}
		
		System.out.println("\tHistory form HashSet");
		Iterator<String> iterator = historyHashSet.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		

		System.out.println("\tHistory form LinkedHashSet");
		iterator = historyLinkedHashSet.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
	
	void deleteHistory(int index) {
		index -= 1;
		String url = historyArrayList.get(index);
		historyArrayList.remove(index);
		
		historyLinkedList.remove(url);
		historyHashSet.remove(url);
		historyLinkedHashSet.remove(url);
		
	}
	
	void deleteHistory(String url) {
		historyArrayList.remove(url);
		
		historyLinkedList.remove(url);
		historyHashSet.remove(url);
		historyLinkedHashSet.remove(url);
	}
	
	
}
