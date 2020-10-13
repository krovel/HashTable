package com.cg;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyLinkedHashMapTest {
	@Test
	public void givenASentence_WhenWordsAreAddedToList_ShouldReturnWordFrequency() {
		MyLinkedHashMap<String, Integer> myLinkedHashMap = new MyLinkedHashMap<>();
		String paragraph = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";
		String[] words = paragraph.toLowerCase().split(" ");
		
		for (String word : words) {
			Integer value = myLinkedHashMap.get(word);
			if (value == null)
				value = 1;
			else
				value++;
			myLinkedHashMap.add(word, value);
		}
		System.out.println(myLinkedHashMap.toString());
		assertEquals(3, (int)myLinkedHashMap.get("paranoid"));
	}

}