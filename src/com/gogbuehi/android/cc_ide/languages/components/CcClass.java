/**
 * 
 */
package com.gogbuehi.android.cc_ide.languages.components;

import java.io.File;

/**
 * Created December 4, 2011
 * @author Goodwin Ogbuehi
 * 
 * This class manages the things the IDE can do in constructing or managing a class
 * definition file. Initially, this will work exclusively with Java class files, but
 * will eventually abstract out the nuances of Java, so that other languages
 * can use this basic class concept.
 * 
 * This needs to handle:
 *  - Member Variables
 *  - The Constructor (a special type of Method)
 *  - Methods
 *
 */
public class CcClass {
	protected String mName;
	protected CcKeyword[] mKeywords;
	protected CcMemberVariable[] mMemberVariables;
	protected CcMethod[] mConstructors;
	protected CcMethod[] mMethods;
	
	public CcClass(String name) {
		mName = name;
	}
	
	public CcClass(File sourceFile) {
		mName = sourceFile.getName();
		String rawCode = ""; //FIXME: Get the actual raw stuff
		//Process the file to figure out Keywords, MemberVariables, Constructors, and Methods
		
		
	}
	
	//Deconstructing Text File
	public void deconstruct(String sourceText) {
		
		
		
	}
	
	//Identify Quotes
	
	
	//Identify Comments
	
	
	
	

}
