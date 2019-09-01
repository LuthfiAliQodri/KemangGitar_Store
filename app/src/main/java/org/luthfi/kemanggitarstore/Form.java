package org.luthfi.kemanggitarstore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Form extends AppCompatActivity {

    private  Button bsimpan;
    private  EditText enama;
    private EditText ealamat;
    private  RadioGroup ekurir;
    private TextView thasil;
    private  TextView enamaBrand;
    private TextView eOutputHarga;

    String name;
    String price;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);


        enamaBrand = findViewById(R.id.tv_item_name);
        eOutputHarga = findViewById(R.id.idoutputharga);
        bsimpan = (Button) findViewById(R.id.simpan);
        enama = (EditText) findViewById(R.id.isinama);
        ealamat = (EditText) findViewById(R.id.isialamat);
        ekurir = (RadioGroup) findViewById(R.id.kurir);
        thasil = (TextView) findViewById(R.id.hasil);
        eOutputHarga = findViewById(R.id.idoutputharga);
        name = getIntent().getStringExtra(Detail.EXTRA_INFO);
        price = getIntent().getStringExtra(Detail.EXTRA_PRICE);
        enamaBrand.setText(name);

        bsimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputnama = String.valueOf(enama.getText().toString());
                String inputalamat = String.valueOf(ealamat.getText().toString());

                int kurir = ekurir.getCheckedRadioButtonId();
                RadioButton ekurir = (RadioButton) findViewById(kurir);
                String input = String.valueOf(ekurir.getText().toString());

                thasil.setText("\n" + "Nama\t\t: " + inputnama + "\n" + "Alamat\t\t: " + inputalamat + "\n" +
                        "Kurir\t\t: " + kurir + "\n");



            }
        });

    }
}
