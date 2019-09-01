package org.luthfi.kemanggitarstore;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Detail extends AppCompatActivity implements View.OnClickListener{

    public static  String EXTRA_INFO = "BRAND";
    public String EXTRA_GAMBAR = "GAMBAR";
    public static  String EXTRA_PRICE = "PRICE";
    public String EXTRA_DESKRIPSI = "DESKRIPSI";

    private int total = 0;
    String info;
    String price;


    ImageView img_item_Photo;
    TextView tv_item_name, tv_price, tv_desc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        img_item_Photo = findViewById(R.id.img_detail);
        tv_item_name = findViewById(R.id.txt_name_detail);
        tv_price = findViewById(R.id.txt_price);
        tv_desc = findViewById(R.id.txt_detail_desc);

        String info = getIntent().getStringExtra(EXTRA_INFO);
        String price = getIntent().getStringExtra(EXTRA_PRICE);
        Glide.with(this).load(getIntent().getStringExtra(EXTRA_GAMBAR)).into(img_item_Photo);
        String desc = getIntent().getStringExtra(EXTRA_DESKRIPSI);

        tv_item_name.setText(info);
        tv_price.setText(price);
        tv_desc.setText(desc);

        Button btnBeli = findViewById(R.id.btnbeli);
        btnBeli.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnbeli:
                Intent moveIntent = new Intent(Detail.this, Form.class);
                moveIntent.putExtra(EXTRA_INFO, info);
                moveIntent.putExtra(EXTRA_PRICE, price);
                startActivity(moveIntent);
                break;
        }
    }
}
