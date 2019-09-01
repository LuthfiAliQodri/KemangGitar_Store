package org.luthfi.kemanggitarstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvInfo;
    private ArrayList<Guitar> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvInfo = findViewById(R.id.rv_info);
        rvInfo.setHasFixedSize(true);

        list.addAll(DataGuitar.getListData());
        showRecylerCardView();
    }

    private void showRecylerCardView(){
        rvInfo.setLayoutManager(new LinearLayoutManager(this));
        CardViewGuitar cardViewYamaha = new CardViewGuitar(list);
        rvInfo.setAdapter(cardViewYamaha);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menus,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private void setMode(int itemId) {
        switch (itemId){
            case R.id.action_about:
                Intent intent = new Intent(MainActivity.this, Profile.class);
                startActivity(intent);
        }
    }
}
