package com.etf.telfor.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;

import com.etf.telfor.R;
import com.etf.telfor.api.FakeApi;
import com.etf.telfor.data.Author;
import com.etf.telfor.data.Paper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import static android.content.Intent.FLAG_ACTIVITY_NO_ANIMATION;

public class PapersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_papers);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_logo_round);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setTitle(R.string.papersLabel);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavView);
        bottomNavigationView.getMenu().getItem(1).setChecked(true);
        packPapers();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ic_authors:
                        Intent intent1 = new Intent(PapersActivity.this,AuthorsActivity.class);
                        intent1.setFlags(FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent1);
                        break;
                    case R.id.ic_papers:
                        /*Intent intent2 = new Intent(MainActivity.this,PapersActivity.class);
                        intent2.setFlags(FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent2);*/
                        break;
                    case R.id.ic_sections:
                        Intent intent3 = new Intent(PapersActivity.this,SectionsActivity.class);
                        intent3.setFlags(FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent3);
                        break;
                    case R.id.ic_chairpersons:
                        Intent intent4 = new Intent(PapersActivity.this,ChairpersonsActivity.class);
                        intent4.setFlags(FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent4);
                        break;
                    case R.id.ic_home:
                        Intent intent0 = new Intent(PapersActivity.this,MainActivity.class);
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

    public void packPapers(){
        ArrayList<Paper> list = FakeApi.getPapers();
        LinearLayout paperScrolView = (LinearLayout) findViewById(R.id.paperScrollView);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        for(Paper p:list){

            ConstraintLayout cl = (ConstraintLayout) inflater.inflate(R.layout.paper_view,null);
            ConstraintLayout line = (ConstraintLayout) inflater.inflate(R.layout.line,null);

            ((TextView)cl.findViewById(R.id.paperTitle)).setText(p.getTitle());
            ((TextView)cl.findViewById(R.id.authorList)).append("Autor Autorovic, Drugi Autor, Treci Autor, Cetvrti autor");
            ((TextView)cl.findViewById(R.id.paperAbstract)).append(p.getPaper_abstract());
            ((TextView)cl.findViewById(R.id.paperSection)).append("1. Computers");
            ((TextView)cl.findViewById(R.id.paperTime)).append("12:00");


            paperScrolView.addView(cl);
            paperScrolView.addView(line);



        }
    }

}
