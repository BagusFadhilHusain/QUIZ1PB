package com.example.quiz1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etKodeBarang, etJumlahBarang, etNama;
    RadioGroup rgMembership;
    Button btnProses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etKodeBarang = findViewById(R.id.etKodeBarang);
        etJumlahBarang = findViewById(R.id.etJumlahBarang);
        etNama = findViewById(R.id.etNama);
        rgMembership = findViewById(R.id.rgMembership);
        btnProses = findViewById(R.id.btnProses);

        btnProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HitungTotalBayar();
            }
        });
    }

    private void HitungTotalBayar() {
        String KodeBarang = etKodeBarang.getText().toString();
        int JumlahBarang;
        String Nama = etNama.getText().toString();

        try {
            JumlahBarang = Integer.parseInt(etJumlahBarang.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(MainActivity.this, "Masukkan jumlah barang dengan benar!", Toast.LENGTH_SHORT).show();
            return;
        }


        double Harga;
        String NamaBarang;

        switch (KodeBarang) {
            case "SGS":
                NamaBarang = "SAMSUNG GALAXY S ";
                Harga = 12999999;
                break;
            case "IPX":
                NamaBarang = "IPHONE X ";
                Harga = 5725300;
                break;
            case "O17":
                NamaBarang = "OPPO A17 ";
                Harga = 2500999;
                break;
            default:
                Toast.makeText(MainActivity.this, "Kode barang tidak valid", Toast.LENGTH_SHORT).show();
                return;
        }

        double TotalBayar = Harga * JumlahBarang;

        int selectedId = rgMembership.getCheckedRadioButtonId();
        double DiscountMember = 0;
        String membership = null;

        if (selectedId != -1) {
            RadioButton radioButton = findViewById(selectedId);
            membership = radioButton.getText().toString();
            switch (membership) {
                case "Gold":
                    DiscountMember = TotalBayar * 0.1;
                    break;
                case "Silver":
                    DiscountMember = TotalBayar * 0.05;
                    break;
                case "Biasa":
                    DiscountMember = TotalBayar * 0.02;
                    break;
            }
        }


        // Diskon membership
        double Discount = TotalBayar - DiscountMember;

        // Diskon di atas 10 juta
        if (TotalBayar > 10000000) {
            Discount += 100000;
        }

        TotalBayar = Discount;

        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("Nama", Nama);
        intent.putExtra("TipeMember", membership);
        intent.putExtra("KodeBarang", KodeBarang);
        intent.putExtra("NamaBarang", NamaBarang);
        intent.putExtra("Harga", Harga);
        intent.putExtra("JumlahBarang", JumlahBarang);
        intent.putExtra("TotalHarga", TotalBayar);
        intent.putExtra("Discount", Discount);
        intent.putExtra("DiscountMember", DiscountMember);
        intent.putExtra("JumlahBayar", TotalBayar);
        startActivity(intent);
    }}
