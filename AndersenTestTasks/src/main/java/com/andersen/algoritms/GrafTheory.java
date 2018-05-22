package com.andersen.algoritms;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class GrafTheory {

	static Deque<ArrayList<Friend>> friends = new LinkedList<>();
	static ArrayList<Friend> alexFriends = new ArrayList<>();
	static ArrayList<Friend> johnFriends = new ArrayList<>();
	static ArrayList<Friend> maggyFriends = new ArrayList<>();

	private class Friend {
		String name;
		boolean isMangoSeller;

		public Friend(String name, boolean isMangoSeller) {
			this.name = name;
			this.isMangoSeller = isMangoSeller;
		}
	}

	private void addFriends() {

		try {
			FileReader fileReader = new FileReader("src/com/andersen/files/names");
			BufferedReader bufReader = new BufferedReader(fileReader);
			String name;
			ArrayList<Friend> friendsList = alexFriends;
			while ((name = bufReader.readLine()) != null) {
				Friend randomFriend = this.new Friend(name, false);
				if (randomFriend.name.equals("Abigail")) {
					randomFriend.isMangoSeller = true;
				}

				friendsList.add(randomFriend);
				if (friendsList.size() > 10 && friendsList.size() < 20) {
					friendsList = johnFriends;
				} else if (friendsList.size() > 20) {
					friendsList = maggyFriends;
				}
			}
			bufReader.close();
			friends.push(alexFriends);
			friends.push(johnFriends);
			friends.push(maggyFriends);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void checkIfMangoSeller(Deque<ArrayList<Friend>> deque) {

		Set<String> checkedNames = new HashSet<>();
		while (!deque.isEmpty()) {
			ArrayList<Friend> friendsList = deque.pop();
			for (Iterator iterator = friendsList.iterator(); iterator.hasNext();) {
				Friend friend = (Friend) iterator.next();
				if (checkedNames.contains(friend.name)) {
					System.out.println(friend.name + " already checked!");
					continue;
				} else if (friend.isMangoSeller == true) {
					System.err.println("Mango Seller is " + friend.name);
				} else {
					checkedNames.add(friend.name);
					System.out.println(friend.name + "  is not a mango seller!");
				}
			}
		}
	}

	public static void main(String[] args) {
		GrafTheory theory = new GrafTheory();
		theory.addFriends();
		theory.checkIfMangoSeller(friends);
	
	}
}
