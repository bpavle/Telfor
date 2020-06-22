package com.etf.telfor.activity;

import android.app.SearchManager;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.etf.telfor.R;
import com.etf.telfor.data.Paper;
import com.etf.telfor.data.SampleSQLiteDBHelper;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

import static android.content.Intent.FLAG_ACTIVITY_NO_ANIMATION;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        handleIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {

        super.onNewIntent(intent);
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {



            String query = intent.getStringExtra(SearchManager.QUERY);
            System.out.println("QUERY ZA PRETRAGU JE: "+query);
            searchPapersForKeyword(query);








        }
    }

public void searchPapersForKeyword(String keywords){

    ArrayList<Paper> list = new ArrayList<>();
    String[] keywordsArray = keywords.split(",");
    System.out.println("KEYWORDSARRAY "+keywordsArray);

    SQLiteDatabase database = new SampleSQLiteDBHelper(this).getReadableDatabase();

   keywords = "\"%";

    for(String s:keywordsArray){
        keywords+= s+"%";
    }
    keywords+="\"";
    System.out.println("KEYWORDS "+keywords);

    Cursor cursor = database.rawQuery("SELECT * " +
                    "from paper " +
                    "WHERE keywords LIKE "+keywords,
                    new String[]{});

    System.out.println("SELECT * " +
            "from paper " +
            "WHERE keywords LIKE "+keywords);
    while (cursor.moveToNext()){
        Paper paper = new Paper(cursor.getInt(cursor.getColumnIndex(SampleSQLiteDBHelper.PAPER_COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(SampleSQLiteDBHelper.PAPER_COLUMN_TITLE)),
                cursor.getString(cursor.getColumnIndex(SampleSQLiteDBHelper.PAPER_COLUMN_ABSTRACT)),
                cursor.getString(cursor.getColumnIndex(SampleSQLiteDBHelper.PAPER_COLUMN_KEYWORDS)),
                cursor.getString(cursor.getColumnIndex(SampleSQLiteDBHelper.PAPER_COLUMN_INDEX)));
        list.add(paper);
    }
    Intent intent = new Intent(SearchActivity.this, PapersActivity.class);
    intent.putExtra("list", list);
    intent.putExtra("id", "SearchActivity");
    intent.setFlags(FLAG_ACTIVITY_NO_ANIMATION);
    System.out.println("LISTA KOJU SALJEMO NA PAPERSACTIVITY JE: "+list);
    startActivity(intent);

}

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));
        return true;
    }*/
}
