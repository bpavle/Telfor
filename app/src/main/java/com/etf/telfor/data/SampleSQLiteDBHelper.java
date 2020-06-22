package com.etf.telfor.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SampleSQLiteDBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 3;
    public static final String DATABASE_NAME = "telfordb";
    public static final String AUTHOR_TABLE_NAME = "author";
    public static final String AUTHOR_COLUMN_ID = "author_id";
    public static final String AUTHOR_COLUMN_FIRST_NAME = "firstName";
    public static final String AUTHOR_COLUMN_LAST_NAME = "lastName";
    public static final String AUTHOR_COLUMN_USERNAME = "username";
    public static final String AUTHOR_COLUMN_COUNTRY = "country";
    public static final String AUTHOR_COLUMN_INSTITUTION = "institution";
    public static final String PAPER_TABLE_NAME = "paper";
    public static final String PAPER_COLUMN_ID = "paper_id";
    public static final String PAPER_COLUMN_TITLE = "title";
    public static final String PAPER_COLUMN_ABSTRACT = "abstract";
    public static final String PAPER_COLUMN_KEYWORDS = "keywords";
    public static final String PAPER_COLUMN_INDEX = "paper_index";
    public static final String CHAIRPERSON_TABLE_NAME = "chairperson";
    public static final String CHAIRPERSON_COLUMN_ID = "chairperson_id";
    public static final String CHAIRPERSON_COLUMN_FIRST_NAME = "firstName";
    public static final String CHAIRPERSON_COLUMN_LAST_NAME = "lastName";
    public static final String SECTION_TABLE_NAME = "section";
    public static final String SECTION_COLUMN_ID = "section_id";
    public static final String SECTION_COLUMN_TITLE = "title";
    public static final String AUTHOR_PAPER_TABLE_NAME = "author_paper";
    public static final String AUTHOR_PAPER_COLUMN_ID = "author_paper_id";
    public static final String AUTHOR_PAPER_COLUMN_AUTHOR_ID = "author_id";
    public static final String AUTHOR_PAPER_COLUMN_PAPER_ID = "paper_id";
    public static final String SESSION_TABLE_NAME = "session";
    public static final String SESSION_COLUMN_ID = "session_id";
    public static final String SESSION_COLUMN_ROOM = "room";
    public static final String SESSION_COLUMN_DATE_TIME = "datetime";
    public static final String SESSION_COLUMN_SECTION_ID = "section_id";
    public static final String SESSION_COLUMN_PAPER_ID = "paper_id";
    public static final String SESSION_COLUMN_CHAIRPERSON_ID = "chairperson_id";
    public SampleSQLiteDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS 'author' ( "+
        "'author_id' int(10)  NOT NULL,"+
        "'firstName' varchar(45) NOT NULL,"+
        "'lastName' varchar(45) NOT NULL,"+
        "'username' varchar(45) NOT NULL,"+
        "'country' varchar(45) NOT NULL,"+
        "'institution' varchar(128) NOT NULL,"+
        "PRIMARY KEY ('author_id'))");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `paper` ("+
        "`paper_id` int(10)  NOT NULL ,"+
        "`title` varchar(256) NOT NULL,"+
        "`abstract` text NOT NULL,"+
        "`keywords` text,"+
        "'paper_index' varchar(5) NOT NULL,"+
         "PRIMARY KEY (`paper_id`))");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `section` (\n" +
                "  'section_id' int(10)  NOT NULL ,\n" +
                "  `title` varchar(128) DEFAULT NULL,\n" +
                "  PRIMARY KEY (`section_id`))");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `chairperson` (\n" +
                "  `chairperson_id` int(10) NOT NULL ,\n" +
                "  `firstName` varchar(45) NOT NULL,\n" +
                "  `lastName` varchar(45) NOT NULL,\n" +
                "  PRIMARY KEY (`chairperson_id`))");
        sqLiteDatabase.execSQL(" CREATE TABLE IF NOT EXISTS `author_paper` (`author_paper_id` int(10) NOT NULL ,\n" +
                "  `author_id` int(10)  NOT NULL,\n" +
                "  `paper_id` int(10) NOT NULL,\n" +
                "  PRIMARY KEY (`author_paper_id`))");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `session` (\n" +
                "  `session_id` int(10)  NOT NULL ,\n" +
                "  `room` varchar(20) NOT NULL,\n" +
                "  `dateTime` datetime NOT NULL,\n" +
                "  `section_id` int(10)  NOT NULL,\n" +
                "  `chairperson_id` int(10)  NOT NULL,\n" +
                "  `paper_id` int(10)  NOT NULL,\n" +
                "  PRIMARY KEY (`session_id`))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS 'author'");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS 'paper'");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS 'session'");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS 'section'");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS 'chairperson'");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS 'author_paper'");
        onCreate(sqLiteDatabase);
    }
}