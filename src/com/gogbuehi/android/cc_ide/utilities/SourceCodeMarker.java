package com.gogbuehi.android.cc_ide.utilities;

public class SourceCodeMarker {
	public static int TYPE_COMMENT=1;
	public static int TYPE_QUOTE=2;
	public static int TYPE_CLASS=3;
	public static int TYPE_STATEMENT=4; //Ends with semicolon or close bracket
	
	public static String MARKER_SIGNATURE_NEWLINE="\n";
	public static String MARKER_SIGNATURE_COMMENT_START="/*";
	public static String MARKER_SIGNATURE_COMMENT_END="*/";
	public static String MARKER_SIGNATURE_COMMENT_SINGLE_START="//";
	public static String MARKER_SIGNATURE_COMMENT_SINGLE_END=MARKER_SIGNATURE_NEWLINE;
	public static String MARKER_SIGNATURE_STATEMENT_START="{";
	public static String MARKER_SIGNATURE_STATEMENT_END="}";
	public static String MARKER_SIGNATURE_QUOTE_START="\"";
	public static String MARKER_SIGNATURE_QUOTE_END="\"";
	
	protected int type;
	public int position;
	public String contents; //Includes marker start and close
	
	public SourceCodeMarker(int type, int position, String contents) {
		this.type = type;
		this.position = position;
		this.contents = contents;
	}
	
	
	
}
