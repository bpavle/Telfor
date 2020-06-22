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
import com.etf.telfor.data.Chairperson;
import com.etf.telfor.data.SampleSQLiteDBHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import static android.content.Intent.FLAG_ACTIVITY_NO_ANIMATION;

public class ChairpersonsActivity extends AppCompatActivity {
    ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chairpersons);

        apiInterface = ApiClient.getClient(ApiInterface.class);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_logo_round);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setTitle(R.string.chairpersonsLabel);
        getSupportActionBar().setDisplayShowTitleEnabled(true);


        packChairpersons(getChairpersons());



        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavView);
        bottomNavigationView.getMenu().getItem(3).setChecked(true);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ic_authors:
                        Intent intent1 = new Intent(ChairpersonsActivity.this,AuthorsActivity.class);
                        intent1.setFlags(FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent1);
                        break;
                    case R.id.ic_papers:
                        Intent intent2 = new Intent(ChairpersonsActivity.this,PapersActivity.class);
                        intent2.setFlags(FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent2);
                        break;
                    case R.id.ic_sections:
                        Intent intent3 = new Intent(ChairpersonsActivity.this,SectionsActivity.class);
                        intent3.setFlags(FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent3);
                        break;
                    case R.id.ic_chairpersons:
                       /* Intent intent4 = new Intent(SearchActivity.this,SearchActivity.class);
                        intent4.setFlags(FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent4);*/
                        break;
                    case R.id.ic_home:
                        Intent intent0 = new Intent(ChairpersonsActivity.this,MainActivity.class);
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

    public ArrayList<Chairperson> getChairpersons() {

        SQLiteDatabase database = new SampleSQLiteDBHelper(this).getReadableDatabase();
        String[] projections = {
          SampleSQLiteDBHelper.CHAIRPERSON_COLUMN_ID,
          SampleSQLiteDBHelper.CHAIRPERSON_COLUMN_FIRST_NAME,
          SampleSQLiteDBHelper.CHAIRPERSON_COLUMN_LAST_NAME,

        };
        Cursor cursor = database.query(
                SampleSQLiteDBHelper.CHAIRPERSON_TABLE_NAME,
                projections,

                null,
                null,
                null,
                null,
                null,
                null
        );
        ArrayList<Chairperson> list = new ArrayList<>();
        while(cursor.moveToNext()){
            Chairperson chairperson = new Chairperson(cursor.getInt(cursor.getColumnIndex(SampleSQLiteDBHelper.CHAIRPERSON_COLUMN_ID)),
                    cursor.getString(cursor.getColumnIndex(SampleSQLiteDBHelper.CHAIRPERSON_COLUMN_FIRST_NAME)),
                    cursor.getString(cursor.getColumnIndex(SampleSQLiteDBHelper.CHAIRPERSON_COLUMN_LAST_NAME)));

            list.add(chairperson);
        };


return list;
/*
        final ArrayList<Chairperson>[] list = new ArrayList[]{new ArrayList<>()};
        Call<ArrayList<Chairperson>> callLanguage = apiInterface.getAllChairpersons();
        callLanguage.enqueue(new Callback<ArrayList<Chairperson>>() {
            @Override
            public void onResponse(Call<ArrayList<Chairperson>> call, Response<ArrayList<Chairperson>> response) {
                if (response.code() == HttpURLConnection.HTTP_OK && response.body() != null) {
                    list[0] = response.body();
                    System.out.println("USPESNO DOBIJENA LISTA: " + list[0].toString());
                    packChairpersons(list[0]);

                }
            }

            @Override
            public void onFailure(Call<ArrayList<Chairperson>> call, Throwable t) {
                System.out.println("FAIL!!!!!!!!!!!!!!!!!!!!!");
            }


        });*/
    }


   /* public void getSectionsByChairperson(int chairpersonId){





        final ArrayList<Section>[] list = new ArrayList[]{new ArrayList<>()};
        Call<ArrayList<Section>> callLanguage = apiInterface.getSectionsByChairperson(chairpersonId);
        callLanguage.enqueue(new Callback<ArrayList<Section>>() {
            @Override
            public void onResponse(Call<ArrayList<Section>> call, Response<ArrayList<Section>> response) {
                if (response.code() == HttpURLConnection.HTTP_OK && response.body() != null) {
                    list[0] = response.body();
                    Intent intent = new Intent(ChairpersonsActivity.this,SectionsActivity.class);
                    intent.putExtra("list",list[0]);
                    intent.putExtra("id","ChairpersonsActivity");
                    intent.setFlags(FLAG_ACTIVITY_NO_ANIMATION);

                    startActivity(intent);


                }
            }

            @Override
            public void onFailure(Call<ArrayList<Section>> call, Throwable t) {
                System.out.println("FAIL!!!!!!!!!!!!!!!!!!!!!");
            }


        });
    }*/



    public void packChairpersons(ArrayList<Chairperson> list){
        //ArrayList<Chairperson>list = FakeApi.getChairpersons();
        LinearLayout chairpersonScrollView = (LinearLayout) findViewById(R.id.chairpersonScrollView);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        for(Chairperson c:list){
            ConstraintLayout cl = (ConstraintLayout) inflater.inflate(R.layout.chairperson_view,null);
            ConstraintLayout line = (ConstraintLayout) inflater.inflate(R.layout.line,null);
            ((TextView)cl.findViewById(R.id.chairprsonName)).setText(c.getFirstName()+ " "+ c.getLastName());
            cl.findViewById(R.id.imageViewSections).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TODO
                }
            });
            chairpersonScrollView.addView(cl);
            chairpersonScrollView.addView(line);
        }

    }
}
