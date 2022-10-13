
package com.si5b.implicitinternet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etLink,etLokasi,etTeks;
    private Button btnBukaWebsite,btnBukalokasi,btnBagikanTeks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etLink = findViewById(R.id.et_link);
        etLokasi = findViewById(R.id.et_lokasi);
        etTeks = findViewById(R.id.et_teks);

        btnBukaWebsite = findViewById(R.id.btn_buka_website);
        btnBukalokasi = findViewById(R.id.btn_buka_lokasi);
        btnBagikanTeks = findViewById(R.id.btn_bagikan_teks);

        btnBukaWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View View) {
                String link = etLink.getText().toString();
                Uri urilink = Uri.parse(link);
                Intent bukaWebsite = new Intent(Intent.ACTION_VIEW,urilink);

                try {
                    startActivity(bukaWebsite);
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "Ada Kesalahan!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnBukalokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String lokasi = etLokasi.getText().toString();
                Uri urilokasi = Uri.parse("geo:0,0?q-="+lokasi);
                Intent bukalokasi = new Intent(Intent.ACTION_VIEW,urilokasi);
                startActivity(bukalokasi);

            }
        });

        btnBagikanTeks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String teks = etTeks.getText().toString();

                String mimiType = "text/plain";
                new ShareCompat
                        .IntentBuilder(MainActivity.this)
                        .setType(mimiType)
                        .setChooserTitle("Bagikan Teks ini")
                        .setText(teks)
                        .startChooser();

            }
        });


    }
}