package com.mr.testsavedinstance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etNama, etAsal;
    private TextView tvNama, tvAsal;
    private Button btnSubmit;

    private static final String KEY_NAMA = "nama_key";
    private static final String KEY_ASAL = "asal_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Inisiasi Edit Text Variabel diatas dengan memanggil id pada layout */
        etNama = (EditText) findViewById(R.id.et_nama);
        etAsal = (EditText) findViewById(R.id.et_asal);

        /* Inisiasi Text View Variabel diatas dengan memanggil id pada layout */
        tvNama = (TextView) findViewById(R.id.tv_nama);
        tvAsal = (TextView) findViewById(R.id.tv_asal);

        /* Inisiasi Button Jika Di Klik ( CARA 1 ) */
        /*btnSubmit = (Button) findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvNama.setText(etNama.getText().toString().trim());
                tvAsal.setText(etAsal.getText().toString().trim());
            }
        });*/
    }

    /* Inisiasi Button Jika Di Klik ( CARA 2 ), menggunakan tool OnClick Pada Layout XML */
    public void saveData(View view) {
        tvNama.setText(etNama.getText().toString().trim());
        tvAsal.setText(etAsal.getText().toString().trim());
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString(KEY_NAMA, etNama.getText().toString());
        outState.putString(KEY_ASAL, etAsal.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        String savedNama = savedInstanceState.getString(KEY_NAMA);
        tvNama.setText(savedNama);
        String savedAsal = savedInstanceState.getString(KEY_ASAL);
        tvAsal.setText(savedAsal);
        super.onRestoreInstanceState(savedInstanceState);
    }


}