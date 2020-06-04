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
import com.etf.telfor.data.Section;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import static android.content.Intent.FLAG_ACTIVITY_NO_ANIMATION;

public class SectionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sections);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_logo_round);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setTitle(R.string.sectionsLabel);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavView);
        bottomNavigationView.getMenu().getItem(2).setChecked(true);

        packSections();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ic_authors:
                        Intent intent1 = new Intent(SectionsActivity.this,AuthorsActivity.class);
                        intent1.setFlags(FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent1);
                        break;
                    case R.id.ic_papers:
                        Intent intent2 = new Intent(SectionsActivity.this,PapersActivity.class);
                        intent2.setFlags(FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent2);
                        break;
                    case R.id.ic_sections:
                       /* Intent intent3 = new Intent(SectionsActivity.this,SectionsActivity.class);
                        intent3.setFlags(FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent3);*/
                        break;
                    case R.id.ic_chairpersons:
                        Intent intent4 = new Intent(SectionsActivity.this,ChairpersonsActivity.class);
                        intent4.setFlags(FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent4);
                        break;
                    case R.id.ic_home:
                        Intent intent0 = new Intent(SectionsActivity.this,MainActivity.class);
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

    public void packSections(){
        ArrayList<Section> list = FakeApi.getSections();
        LinearLayout sectionScrolView = (LinearLayout) findViewById(R.id.sectionScrollView);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        for(Section s:list){
            ConstraintLayout cl = (ConstraintLayout) inflater.inflate(R.layout.section_view,null);
            ConstraintLayout line = (ConstraintLayout) inflater.inflate(R.layout.line,null);
            ((TextView)cl.findViewById(R.id.sectionTitle)).setText(s.getTitle());

            sectionScrolView.addView(cl);
            sectionScrolView.addView(line);
        }
    }
}
