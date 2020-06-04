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
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static android.content.Intent.FLAG_ACTIVITY_NO_ANIMATION;

public class AuthorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authors);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavView);
        bottomNavigationView.getMenu().getItem(0).setChecked(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_logo_round);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setTitle(R.string.authorsLabel);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        packAuthors();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ic_authors:
                        /*Intent intent1 = new Intent(MainActivity.this,AuthorsActivity.class);
                        intent1.setFlags(FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent1);*/
                        break;
                    case R.id.ic_papers:
                        Intent intent2 = new Intent(AuthorsActivity.this,PapersActivity.class);
                        intent2.setFlags(FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent2);
                        break;
                    case R.id.ic_sections:
                        Intent intent3 = new Intent(AuthorsActivity.this,SectionsActivity.class);
                        intent3.setFlags(FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent3);
                        break;
                    case R.id.ic_chairpersons:
                        Intent intent4 = new Intent(AuthorsActivity.this,ChairpersonsActivity.class);
                        intent4.setFlags(FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent4);
                        break;
                    case R.id.ic_home:
                      Intent intent0 = new Intent(AuthorsActivity.this,MainActivity.class);
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

    public void packAuthors(){
        ArrayList<Author> list = FakeApi.getAuthors();
        LinearLayout authorScrolView = (LinearLayout) findViewById(R.id.authorScrollView);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        for(Author a:list){

            ConstraintLayout cl = (ConstraintLayout) inflater.inflate(R.layout.author_view,null);
            ConstraintLayout line = (ConstraintLayout) inflater.inflate(R.layout.line,null);

            ((TextView)cl.findViewById(R.id.authorName)).setText(a.getFirstName()+" "+a.getLastName());
            ((TextView)cl.findViewById(R.id.authorInstitution)).setText(a.getInstitution());
            ((TextView)cl.findViewById(R.id.authorEmail)).setText(a.getUsername());
            ((TextView)cl.findViewById(R.id.authorCountry)).setText(a.getCountry());


            authorScrolView.addView(cl);
            authorScrolView.addView(line);



        }
    }
}
