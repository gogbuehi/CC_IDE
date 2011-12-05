package com.gogbuehi.android.cc_ide.utilities;

import com.gogbuehi.android.cc_ide.exceptions.MarkerException;

public class SourcePlaceholder {
	public void identifyMarkerPositions() {
		int textLength = mText.length();
		int textLengthShift = textLength;
		
		//First deal with quotes
		String fixedText = mText.toString();
		
		//Find escaped quotes and sort them out
		int fromIndex = 0;
		fixedText = fixedText.replaceAll("\\\"", "");
		
		
	}
	
	public static final String[][] PLACEHOLDERS = {
		{"~", "Á", "ª", "£", "¢", "°", "¤", "¦", "¥", "»", "­"},
		{"Ï~","·Á","«ª","¨£"," ¢","´°","¬¤","ö¦","¿¥","¹¼","Ò­"}
	};
	
	protected int[] mAvailablePlaceholders = {0,0}; //Bitmasks
	protected int[] mUsedPlaceholders = {0,0}; //Bitmasks
	
	protected String mText;
	
	public void establishAvailablePlaceholders() {
		for (int i = 0; i < PLACEHOLDERS.length; i++) {
			for (int j = 0; j < PLACEHOLDERS[i].length; j++) {
				if (mText.indexOf(PLACEHOLDERS[i][j]) ==-1) {
					mAvailablePlaceholders[i] |= (int)Math.pow(2,i);
				}
			}
		}
	}
	/**
	 * Replaces the provided string in the master text
	 * with a placeholder that won't conflict with text
	 * that is already in the text and that hasn't
	 * been used before
	 * @param replace
	 * @return The Bitwise value that indicates with placeholder
	 * 			was used for this text;
	 * 			-1 if the master text doesn't have the replace
	 * 			String in it
	 * @throws MarkerException
	 */
	public int placehold(String replace) throws MarkerException {
		if (mText.indexOf(replace) == -1) {
			return -1;
		}
		int placeholderLength = replace.length();
		int placeholderIndex = placeholderLength - 1;
		if ((placeholderLength > mAvailablePlaceholders.length || mAvailablePlaceholders[placeholderLength-1] == 0) || mAvailablePlaceholders[placeholderLength-1] == mUsedPlaceholders[placeholderLength-1]) {
			throw new MarkerException(MarkerException.MESSAGE_NO_PLACEHOLDER_AVAILABLE);
		}
		String currentPlaceholder = ""; //This will get a value, as we've already made sure a placeholder is available
		int val;
		int bitVal=0;
		for (int i = 0; i < PLACEHOLDERS[placeholderIndex].length; i++) {
			bitVal = (int)Math.pow(2, i);
			val = (bitVal & mAvailablePlaceholders[placeholderIndex]) & ~mUsedPlaceholders[placeholderIndex];
			if (val == bitVal) {
				//Placeholder is both AVAILABLE and NOT USED already
				currentPlaceholder = PLACEHOLDERS[placeholderIndex][i];
				//bitVal contains the Bitmask to set now
				break;
			}
		}
		
			mText = mText.replaceAll(replace, currentPlaceholder);
			mUsedPlaceholders[placeholderIndex] |= bitVal;
			return bitVal;
	}
}
