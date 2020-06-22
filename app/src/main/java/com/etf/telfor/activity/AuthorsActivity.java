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
import android.view.View;
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

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import static android.content.Intent.FLAG_ACTIVITY_NO_ANIMATION;

public class AuthorsActivity extends AppCompatActivity {


    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authors);
        apiInterface = ApiClient.getClient(ApiInterface.class);


        SQLiteDatabase database = new SampleSQLiteDBHelper(this).getReadableDatabase();
        String[] projection = {
                SampleSQLiteDBHelper.AUTHOR_COLUMN_ID,
                SampleSQLiteDBHelper.AUTHOR_COLUMN_FIRST_NAME,
                SampleSQLiteDBHelper.AUTHOR_COLUMN_LAST_NAME,
                SampleSQLiteDBHelper.AUTHOR_COLUMN_USERNAME,
                SampleSQLiteDBHelper.AUTHOR_COLUMN_INSTITUTION,
                SampleSQLiteDBHelper.AUTHOR_COLUMN_COUNTRY,
        };

        Cursor cursor = database.query(
                SampleSQLiteDBHelper.AUTHOR_TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null,
                null
        );
        ArrayList<Author> list = new ArrayList<>();

        while (cursor.moveToNext()){
            Author author = new Author(cursor.getInt(cursor.getColumnIndex(SampleSQLiteDBHelper.AUTHOR_COLUMN_ID)),
                    cursor.getString(cursor.getColumnIndex(SampleSQLiteDBHelper.AUTHOR_COLUMN_FIRST_NAME)),
                    cursor.getString(cursor.getColumnIndex(SampleSQLiteDBHelper.AUTHOR_COLUMN_LAST_NAME)),
                    cursor.getString(cursor.getColumnIndex(SampleSQLiteDBHelper.AUTHOR_COLUMN_USERNAME)),
                    cursor.getString(cursor.getColumnIndex(SampleSQLiteDBHelper.AUTHOR_COLUMN_COUNTRY)),
                    cursor.getString(cursor.getColumnIndex(SampleSQLiteDBHelper.AUTHOR_COLUMN_INSTITUTION))
                    );
            list.add(author);
        }


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavView);
        bottomNavigationView.getMenu().getItem(0).setChecked(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_logo_round);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setTitle(R.string.authorsLabel);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

       // getAuthors();
        packAuthors(list);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ic_authors:
                        /*Intent intent1 = new Intent(MainActivity.this,AuthorsActivity.class);
                        intent1.setFlags(FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent1);*/
                        break;
                    case R.id.ic_papers:
                        Intent intent2 = new Intent(AuthorsActivity.this, PapersActivity.class);
                        intent2.setFlags(FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent2);
                        break;
                    case R.id.ic_sections:
                        Intent intent3 = new Intent(AuthorsActivity.this, SectionsActivity.class);
                        intent3.setFlags(FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent3);
                        break;
                    case R.id.ic_chairpersons:
                        Intent intent4 = new Intent(AuthorsActivity.this, ChairpersonsActivity.class);
                        intent4.setFlags(FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent4);
                        break;
                    case R.id.ic_home:
                        Intent intent0 = new Intent(AuthorsActivity.this, MainActivity.class);
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

  /*  public void getAuthors() {
        final ArrayList<Author>[] list = new ArrayList[]{new ArrayList<>()};
        Call<ArrayList<Author>> callLanguage = apiInterface.getAllAuthors();

        callLanguage.enqueue(new Callback<ArrayList<Author>>() {
            @Override
            public void onResponse(Call<ArrayList<Author>> call, Response<ArrayList<Author>> response) {
                if (response.code() == HttpURLConnection.HTTP_OK && response.body() != null) {
                    list[0] = response.body();
                    packAuthors(list[0]);
                    System.out.println("USPESNO DOBIJENA LISTA: " + list[0].toString());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Author>> call, Throwable t) {
                System.out.println("FAIL!!!!!!!!!!!!!!!!!!!!!");
            }


        });
    }
*/
    public void getPapersByAuthor(int authorId) {




        SQLiteDatabase database = new SampleSQLiteDBHelper(this).getReadableDatabase();

        Cursor cursor = database.rawQuery("SELECT paper.paper_id,paper.abstract,paper_index,keywords ,title " +
                "from paper, author_paper " +
                "WHERE paper.paper_id=author_paper.paper_id AND author_id=?",
                new String[]{String.valueOf(authorId)});
        ArrayList<Paper> list = new ArrayList<>();

        while (cursor.moveToNext()){
            Paper paper = new Paper(cursor.getInt(cursor.getColumnIndex(SampleSQLiteDBHelper.PAPER_COLUMN_ID)),
                    cursor.getString(cursor.getColumnIndex(SampleSQLiteDBHelper.PAPER_COLUMN_TITLE)),
                    cursor.getString(cursor.getColumnIndex(SampleSQLiteDBHelper.PAPER_COLUMN_ABSTRACT)),
                    cursor.getString(cursor.getColumnIndex(SampleSQLiteDBHelper.PAPER_COLUMN_KEYWORDS)),
                    cursor.getString(cursor.getColumnIndex(SampleSQLiteDBHelper.PAPER_COLUMN_INDEX)));
            list.add(paper);
        }
        Intent intent = new Intent(AuthorsActivity.this, PapersActivity.class);
        intent.putExtra("list", list);
        intent.putExtra("id", "AuthorsActivity");
        intent.setFlags(FLAG_ACTIVITY_NO_ANIMATION);

        startActivity(intent);




/*

        final ArrayList<Paper>[] list = new ArrayList[]{new ArrayList<>()};
        Call<ArrayList<Paper>> callLanguage = apiInterface.getPapersByAuthor(authorId);
        callLanguage.enqueue(new Callback<ArrayList<Paper>>() {
            @Override
            public void onResponse(Call<ArrayList<Paper>> call, Response<ArrayList<Paper>> response) {
                if (response.code() == HttpURLConnection.HTTP_OK && response.body() != null) {
                    list[0] = response.body();
                    Intent intent = new Intent(AuthorsActivity.this, PapersActivity.class);
                    intent.putExtra("list", list[0]);
                    intent.putExtra("id", "AuthorsActivity");
                    intent.setFlags(FLAG_ACTIVITY_NO_ANIMATION);

                    startActivity(intent);
                    System.out.println("USPESNO DOBIJENA LISTA: " + list[0].toString());

                }
            }

            @Override
            public void onFailure(Call<ArrayList<Paper>> call, Throwable t) {
                System.out.println("FAIL!!!!!!!!!!!!!!!!!!!!!");
            }


        });*/
    }

    public void packAuthors(ArrayList<Author> list) {
        //ArrayList<Author> list = FakeApi.getAuthors();

        //ArrayList<Author> list =
        LinearLayout authorScrolView = (LinearLayout) findViewById(R.id.authorScrollView);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        for (final Author a : list) {

            ConstraintLayout cl = (ConstraintLayout) inflater.inflate(R.layout.author_view, null);
            cl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TODO
                }
            });
            ConstraintLayout line = (ConstraintLayout) inflater.inflate(R.layout.line, null);
            cl.findViewById(R.id.imageViewPapers).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    getPapersByAuthor(a.getAuthorId());

                }
            });
            ((TextView) cl.findViewById(R.id.authorName)).setText(a.getFirstName() + " " + a.getLastName());
            ((TextView) cl.findViewById(R.id.authorInstitution)).setText(a.getInstitution());
            ((TextView) cl.findViewById(R.id.authorEmail)).setText(a.getUsername());
            ((TextView) cl.findViewById(R.id.authorCountry)).setText(a.getCountry());


            authorScrolView.addView(cl);
            authorScrolView.addView(line);


        }
    }
}
