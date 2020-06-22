package com.etf.telfor.activity;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;

import com.etf.telfor.R;
import com.etf.telfor.api.ApiClient;
import com.etf.telfor.api.ApiInterface;
import com.etf.telfor.data.Author;
import com.etf.telfor.data.Paper;
import com.etf.telfor.data.SampleSQLiteDBHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.net.HttpURLConnection;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Intent.FLAG_ACTIVITY_NO_ANIMATION;

public class PapersActivity extends AppCompatActivity {

    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_papers);

        apiInterface = ApiClient.getClient(ApiInterface.class);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_logo_round);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setTitle(R.string.papersLabel);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavView);
        bottomNavigationView.getMenu().getItem(1).setChecked(true);
        Intent intent = getIntent();


       if(intent.getStringExtra("id")!=null && intent.getStringExtra("id").equals("AuthorsActivity")){
            packPapers((ArrayList<Paper>) intent.getSerializableExtra("list"));

        }
       else if(intent.getStringExtra("id")!=null && intent.getStringExtra("id").equals("SearchActivity")){
           packPapers((ArrayList<Paper>) intent.getSerializableExtra("list"));
       }
       else packPapers(getPapers());







        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ic_authors:
                        Intent intent1 = new Intent(PapersActivity.this, AuthorsActivity.class);
                        intent1.setFlags(FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent1);
                        break;
                    case R.id.ic_papers:
                        /*Intent intent2 = new Intent(MainActivity.this,PapersActivity.class);
                        intent2.setFlags(FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent2);*/
                        break;
                    case R.id.ic_sections:
                        Intent intent3 = new Intent(PapersActivity.this, SectionsActivity.class);
                        intent3.setFlags(FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent3);
                        break;
                    case R.id.ic_chairpersons:
                        Intent intent4 = new Intent(PapersActivity.this, ChairpersonsActivity.class);
                        intent4.setFlags(FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent4);
                        break;
                    case R.id.ic_home:
                        Intent intent0 = new Intent(PapersActivity.this, MainActivity.class);
                        intent0.setFlags(FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent0);
                        break;

                }

                return false;
            }
        });
    }

    @Override
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
        searchView.onActionViewExpanded();
        return true;
    }


    public ArrayList<Paper> getPapers() {
  /*      final ArrayList<Paper>[] list = new ArrayList[]{new ArrayList<>()};
        Call<ArrayList<Paper>> callLanguage = apiInterface.getAllPapers();
        callLanguage.enqueue(new Callback<ArrayList<Paper>>() {
            @Override
            public void onResponse(Call<ArrayList<Paper>> call, Response<ArrayList<Paper>> response) {
                if (response.code() == HttpURLConnection.HTTP_OK && response.body() != null) {
                    list[0] = response.body();
                    packPapers(list[0]);
                    System.out.println("USPESNO DOBIJENA LISTA: " + list[0].toString());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Paper>> call, Throwable t) {
                System.out.println("FAIL!!!!!!!!!!!!!!!!!!!!!");
            }


        });*/

        SQLiteDatabase database = new SampleSQLiteDBHelper(this).getReadableDatabase();
        String[] projection = {
                SampleSQLiteDBHelper.PAPER_COLUMN_ID,
                SampleSQLiteDBHelper.PAPER_COLUMN_TITLE,
                SampleSQLiteDBHelper.PAPER_COLUMN_ABSTRACT,
                SampleSQLiteDBHelper.PAPER_COLUMN_KEYWORDS,
                SampleSQLiteDBHelper.PAPER_COLUMN_INDEX,

        };

        Cursor cursor = database.query(
                SampleSQLiteDBHelper.PAPER_TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null,
                null
        );
        ArrayList<Paper> list = new ArrayList<>();

        while (cursor.moveToNext()){
            Paper paper = new Paper(cursor.getInt(cursor.getColumnIndex(SampleSQLiteDBHelper.PAPER_COLUMN_ID)),
                    cursor.getString(cursor.getColumnIndex(SampleSQLiteDBHelper.PAPER_COLUMN_TITLE)),
                    cursor.getString(cursor.getColumnIndex(SampleSQLiteDBHelper.PAPER_COLUMN_ABSTRACT)),
                    cursor.getString(cursor.getColumnIndex(SampleSQLiteDBHelper.PAPER_COLUMN_KEYWORDS)),
                    cursor.getString(cursor.getColumnIndex(SampleSQLiteDBHelper.PAPER_COLUMN_INDEX)));
            list.add(paper);
        }
        return list;
    }


    public void packPapers(ArrayList<Paper> paperList) {
        //ArrayList<Paper> list = FakeApi.getPapers();
        LinearLayout paperScrolView = (LinearLayout) findViewById(R.id.paperScrollView);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        for (final Paper p : paperList) {

            final ConstraintLayout cl = (ConstraintLayout) inflater.inflate(R.layout.paper_view, null);
            ConstraintLayout line = (ConstraintLayout) inflater.inflate(R.layout.line, null);

            ((TextView) cl.findViewById(R.id.paperTitle)).setText(p.getTitle());

            Call<ArrayList<Author>> callLanguage = apiInterface.getAuthorsByPaper(p.getPaperId());
            callLanguage.enqueue(new Callback<ArrayList<Author>>() {
                @Override
                public void onResponse(Call<ArrayList<Author>> call, Response<ArrayList<Author>> response) {
                    if (response.code() == HttpURLConnection.HTTP_OK && response.body() != null) {
                        for(Author a:response.body())
                        ((TextView) cl.findViewById(R.id.authorList)).append(a.getFirstName()+" "+a.getLastName()+" ");

                    }
                }

                @Override
                public void onFailure(Call<ArrayList<Author>> call, Throwable t) {
                    System.out.println("FAIL!!!!!!!!!!!!!!!!!!!!!");
                }


            });



            ((TextView) cl.findViewById(R.id.paperAbstract)).append(p.getPaperAbstract());
            ((TextView) cl.findViewById(R.id.paperSection)).append("1. Computers");
            ((TextView) cl.findViewById(R.id.paperTime)).append("12:00");


            paperScrolView.addView(cl);
            paperScrolView.addView(line);


        }
    }

}
