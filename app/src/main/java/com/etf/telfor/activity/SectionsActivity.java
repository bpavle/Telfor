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
import com.etf.telfor.data.SampleSQLiteDBHelper;
import com.etf.telfor.data.Section;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import static android.content.Intent.FLAG_ACTIVITY_NO_ANIMATION;

public class SectionsActivity extends AppCompatActivity {
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sections);

        apiInterface = ApiClient.getClient(ApiInterface.class);


        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_logo_round);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setTitle(R.string.sectionsLabel);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavView);
        bottomNavigationView.getMenu().getItem(2).setChecked(true);

        packSections(getSections());
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ic_authors:
                        Intent intent1 = new Intent(SectionsActivity.this, AuthorsActivity.class);
                        intent1.setFlags(FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent1);
                        break;
                    case R.id.ic_papers:
                        Intent intent2 = new Intent(SectionsActivity.this, PapersActivity.class);
                        intent2.setFlags(FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent2);
                        break;
                    case R.id.ic_sections:
                       /* Intent intent3 = new Intent(SectionsActivity.this,SectionsActivity.class);
                        intent3.setFlags(FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent3);*/
                        break;
                    case R.id.ic_chairpersons:
                        Intent intent4 = new Intent(SectionsActivity.this, ChairpersonsActivity.class);
                        intent4.setFlags(FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent4);
                        break;
                    case R.id.ic_home:
                        Intent intent0 = new Intent(SectionsActivity.this, MainActivity.class);
                        intent0.setFlags(FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent0);
                        break;

                }

                return false;
            }
        });
    }


    public ArrayList<Section> getSections() {


        SQLiteDatabase database = new SampleSQLiteDBHelper(this).getReadableDatabase();
        String[] projection = {
                SampleSQLiteDBHelper.SECTION_COLUMN_ID,
                SampleSQLiteDBHelper.SECTION_COLUMN_TITLE
        };
        Cursor cursor = database.query(
                SampleSQLiteDBHelper.SECTION_TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null,
                null
        );
        ArrayList<Section> list = new ArrayList<>();
        while (cursor.moveToNext()){
            Section section = new Section(cursor.getInt(cursor.getColumnIndex(SampleSQLiteDBHelper.SECTION_COLUMN_ID)),
                                          cursor.getString(cursor.getColumnIndex(SampleSQLiteDBHelper.SECTION_COLUMN_TITLE)));
        list.add(section);
        }
        return list;
/*
        final ArrayList<Section>[] list = new ArrayList[]{new ArrayList<>()};
        Call<ArrayList<Section>> callLanguage = apiInterface.getAllSections();
        callLanguage.enqueue(new Callback<ArrayList<Section>>() {
            @Override
            public void onResponse(Call<ArrayList<Section>> call, Response<ArrayList<Section>> response) {
                if (response.code() == HttpURLConnection.HTTP_OK && response.body() != null) {
                    list[0] = response.body();
                    packSections(list[0]);
                    System.out.println("USPESNO DOBIJENA LISTA: " + list[0].toString());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Section>> call, Throwable t) {
                System.out.println("FAIL!!!!!!!!!!!!!!!!!!!!!");
            }


        });*/
    }
    public void getPapersBySection(int sectionId){

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

    public void packSections(ArrayList<Section> list) {
        //ArrayList<Section> list = FakeApi.getSections();
        LinearLayout sectionScrolView = (LinearLayout) findViewById(R.id.sectionScrollView);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        for (final Section s : list) {
            ConstraintLayout cl = (ConstraintLayout) inflater.inflate(R.layout.section_view, null);
            ConstraintLayout line = (ConstraintLayout) inflater.inflate(R.layout.line, null);
            ((TextView) cl.findViewById(R.id.sectionTitle)).setText(s.getTitle());

            cl.findViewById(R.id.sectionTitle).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getPapersBySection(s.getSectionId());
                }
            });
            ((TextView) cl.findViewById(R.id.sectionTitle)).setTextColor(getResources().getColorStateList(R.color.button_selector));
            sectionScrolView.addView(cl);
            sectionScrolView.addView(line);
        }
    }
}
