package com.etf.telfor.activity;

import android.app.SearchManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.SearchView;

import com.etf.telfor.R;
import com.etf.telfor.api.ApiClient;
import com.etf.telfor.api.ApiInterface;
import com.etf.telfor.data.Author;
import com.etf.telfor.data.AuthorPaper;
import com.etf.telfor.data.Chairperson;
import com.etf.telfor.data.Paper;
import com.etf.telfor.data.SampleSQLiteDBHelper;
import com.etf.telfor.data.Section;
import com.etf.telfor.data.Session;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.net.HttpURLConnection;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Intent.FLAG_ACTIVITY_NO_ANIMATION;

public class MainActivity extends AppCompatActivity {
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiInterface = ApiClient.getClient(ApiInterface.class);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_logo_round);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setTitle(R.string.homeLabel);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        WebView webView = findViewById(R.id.webView);
        webView.loadUrl("http://www.telfor.rs/");
        webView.findAllAsync("TELFOR 2019");
        webView.findNext(true);
        webView.clearMatches();


        Call<ArrayList<Paper>> callPapers = apiInterface.getAllPapers();
        callPapers.enqueue(new Callback<ArrayList<Paper>>() {
            @Override
            public void onResponse(Call<ArrayList<Paper>> call, Response<ArrayList<Paper>> response) {
                if (response.code() == HttpURLConnection.HTTP_OK && response.body() != null) {


                    ArrayList<Paper> list = response.body();
                    SQLiteDatabase database = new SampleSQLiteDBHelper(MainActivity.this).getWritableDatabase();
                    ContentValues values = new ContentValues();
                    for (Paper p : list) {
                        values.put(SampleSQLiteDBHelper.PAPER_COLUMN_ID, p.getPaperId());
                        values.put(SampleSQLiteDBHelper.PAPER_COLUMN_TITLE, p.getTitle());
                        values.put(SampleSQLiteDBHelper.PAPER_COLUMN_ABSTRACT, p.getPaperAbstract());
                        values.put(SampleSQLiteDBHelper.PAPER_COLUMN_KEYWORDS, p.getKeywords());
                        values.put(SampleSQLiteDBHelper.PAPER_COLUMN_INDEX, p.getIndex());


                        long newRowId = database.insert(SampleSQLiteDBHelper.PAPER_TABLE_NAME, null, values);
                    }

                }
            }

            @Override
            public void onFailure(Call<ArrayList<Paper>> call, Throwable t) {
                System.out.println("FAIL!!!!!!!!!!!!!!!!!!!!!");
            }


        });


        Call<ArrayList<Author>> callAuthors = apiInterface.getAllAuthors();
        callAuthors.enqueue(new Callback<ArrayList<Author>>() {
            @Override
            public void onResponse(Call<ArrayList<Author>> call, Response<ArrayList<Author>> response) {
                if (response.code() == HttpURLConnection.HTTP_OK && response.body() != null) {
                    ArrayList<Author> list = response.body();

                    SQLiteDatabase database = new SampleSQLiteDBHelper(MainActivity.this).getWritableDatabase();

                    ContentValues values = new ContentValues();

                    for (Author a : list) {


                        values.put(SampleSQLiteDBHelper.AUTHOR_COLUMN_ID, a.getAuthorId());
                        values.put(SampleSQLiteDBHelper.AUTHOR_COLUMN_FIRST_NAME, a.getFirstName());
                        values.put(SampleSQLiteDBHelper.AUTHOR_COLUMN_LAST_NAME, a.getLastName());
                        values.put(SampleSQLiteDBHelper.AUTHOR_COLUMN_USERNAME, a.getUsername());
                        values.put(SampleSQLiteDBHelper.AUTHOR_COLUMN_COUNTRY, a.getCountry());
                        values.put(SampleSQLiteDBHelper.AUTHOR_COLUMN_INSTITUTION, a.getInstitution());
                        long newRowId = database.insert(SampleSQLiteDBHelper.AUTHOR_TABLE_NAME, null, values);

                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Author>> call, Throwable t) {
                System.out.println("FAIL!!!!!!!!!!!!!!!!!!!!!");
            }


        });


        Call<ArrayList<Chairperson>> callChairpersons = apiInterface.getAllChairpersons();
        callChairpersons.enqueue(new Callback<ArrayList<Chairperson>>() {
            @Override
            public void onResponse(Call<ArrayList<Chairperson>> call, Response<ArrayList<Chairperson>> response) {
                if (response.code() == HttpURLConnection.HTTP_OK && response.body() != null) {
                    ArrayList<Chairperson> list = response.body();

                    SQLiteDatabase database = new SampleSQLiteDBHelper(MainActivity.this).getWritableDatabase();

                    ContentValues values = new ContentValues();

                    for (Chairperson a : list) {


                        values.put(SampleSQLiteDBHelper.CHAIRPERSON_COLUMN_ID, a.getChairpersonId());
                        values.put(SampleSQLiteDBHelper.CHAIRPERSON_COLUMN_FIRST_NAME, a.getFirstName());
                        values.put(SampleSQLiteDBHelper.CHAIRPERSON_COLUMN_LAST_NAME, a.getLastName());

                        long newRowId = database.insert(SampleSQLiteDBHelper.CHAIRPERSON_TABLE_NAME, null, values);


                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Chairperson>> call, Throwable t) {
                System.out.println("FAIL!!!!!!!!!!!!!!!!!!!!!");
            }


        });


        {

            Call<ArrayList<Section>> callLanguage = apiInterface.getAllSections();
            callLanguage.enqueue(new Callback<ArrayList<Section>>() {
                @Override
                public void onResponse(Call<ArrayList<Section>> call, Response<ArrayList<Section>> response) {
                    if (response.code() == HttpURLConnection.HTTP_OK && response.body() != null) {
                        ArrayList<Section> list = response.body();
                        SQLiteDatabase database = new SampleSQLiteDBHelper(MainActivity.this).getWritableDatabase();

                        ContentValues values = new ContentValues();

                        for (Section a : list) {


                            values.put(SampleSQLiteDBHelper.SECTION_COLUMN_ID, a.getSectionId());
                            values.put(SampleSQLiteDBHelper.SECTION_COLUMN_TITLE, a.getTitle());
                            long newRowId = database.insert(SampleSQLiteDBHelper.SECTION_TABLE_NAME, null, values);

                        }
                    }
                }

                @Override
                public void onFailure(Call<ArrayList<Section>> call, Throwable t) {
                    System.out.println("FAIL!!!!!!!!!!!!!!!!!!!!!");
                }


            });

        }


        {

            Call<ArrayList<Session>> callLanguage = apiInterface.getAllSessions();
            callLanguage.enqueue(new Callback<ArrayList<Session>>() {
                @Override
                public void onResponse(Call<ArrayList<Session>> call, Response<ArrayList<Session>> response) {
                    if (response.code() == HttpURLConnection.HTTP_OK && response.body() != null) {
                        ArrayList<Session> list = response.body();
                        SQLiteDatabase database = new SampleSQLiteDBHelper(MainActivity.this).getWritableDatabase();

                        ContentValues values = new ContentValues();

                        for (Session a : list) {


                            values.put(SampleSQLiteDBHelper.SESSION_COLUMN_ID, a.getSessionId());
                            values.put(SampleSQLiteDBHelper.SESSION_COLUMN_ROOM, a.getRoom());
                            values.put(SampleSQLiteDBHelper.SESSION_COLUMN_DATE_TIME, a.getDate());
                            values.put(SampleSQLiteDBHelper.SESSION_COLUMN_CHAIRPERSON_ID, a.getChairperson().getChairpersonId());
                            values.put(SampleSQLiteDBHelper.SESSION_COLUMN_PAPER_ID, a.getPaper().getPaperId());
                            values.put(SampleSQLiteDBHelper.SESSION_COLUMN_SECTION_ID, a.getSection().getSectionId());
                            long newRowId = database.insert(SampleSQLiteDBHelper.SESSION_TABLE_NAME, null, values);

                        }
                    }
                }

                @Override
                public void onFailure(Call<ArrayList<Session>> call, Throwable t) {
                    System.out.println("FAIL!!!!!!!!!!!!!!!!!!!!!");
                }


            });

        }

        {
            final ArrayList<AuthorPaper>[] list = new ArrayList[]{new ArrayList<>()};
            Call<ArrayList<AuthorPaper>> callLanguage = apiInterface.getAllAuthorPapers();
            callLanguage.enqueue(new Callback<ArrayList<AuthorPaper>>() {
                @Override
                public void onResponse(Call<ArrayList<AuthorPaper>> call, Response<ArrayList<AuthorPaper>> response) {
                    if (response.code() == HttpURLConnection.HTTP_OK && response.body() != null) {
                        ArrayList<AuthorPaper> list = response.body();

                        SQLiteDatabase database = new SampleSQLiteDBHelper(MainActivity.this).getWritableDatabase();

                        ContentValues values = new ContentValues();

                        for (AuthorPaper a : list) {


                            values.put(SampleSQLiteDBHelper.AUTHOR_PAPER_COLUMN_ID, a.getAuthorPaperId());
                            values.put(SampleSQLiteDBHelper.AUTHOR_PAPER_COLUMN_AUTHOR_ID, a.getAuthor().getAuthorId());
                            values.put(SampleSQLiteDBHelper.AUTHOR_PAPER_COLUMN_PAPER_ID, a.getPaper().getPaperId());

                            long newRowId = database.insert(SampleSQLiteDBHelper.AUTHOR_PAPER_TABLE_NAME, null, values);

                        }
                    }
                }

                @Override
                public void onFailure(Call<ArrayList<AuthorPaper>> call, Throwable t) {
                    System.out.println("FAIL!!!!!!!!!!!!!!!!!!!!!");
                }


            });

        }


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavView);
        bottomNavigationView.getMenu().getItem(4).setChecked(true);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ic_authors:
                        Intent intent1 = new Intent(MainActivity.this, AuthorsActivity.class);
                        intent1.setFlags(FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent1);
                        break;
                    case R.id.ic_papers:
                        Intent intent2 = new Intent(MainActivity.this, PapersActivity.class);
                        intent2.setFlags(FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent2);
                        break;
                    case R.id.ic_sections:
                        Intent intent3 = new Intent(MainActivity.this, SectionsActivity.class);
                        intent3.setFlags(FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent3);
                        break;
                    case R.id.ic_chairpersons:
                        Intent intent4 = new Intent(MainActivity.this, ChairpersonsActivity.class);
                        intent4.setFlags(FLAG_ACTIVITY_NO_ANIMATION);
                        //intent4.setFlags(Integer.parseInt(intent4.ACTION_SEARCH));
                        startActivity(intent4);
                        break;
                    case R.id.ic_home:
                       /* Intent intent0 = new Intent(MainActivity.this,MainActivity.class);
                        intent0.setFlags(FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent0);*/
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
        /*searchView.setIconifiedByDefault(false);
        searchView.requestFocus();*/
        searchView.onActionViewExpanded();
        return true;
    }


}
