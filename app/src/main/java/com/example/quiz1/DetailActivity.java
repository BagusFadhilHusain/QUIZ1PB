package com.example.quiz1;

import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String Nama = extras.getString("Nama");
            String TipeMember = extras.getString("TipeMember");
            String KodeBarang = extras.getString("KodeBarang");
            String NamaBarang = extras.getString("NamaBarang");
            double Harga = extras.getDouble("Harga");
            int JumlahBarang = extras.getInt("JumlahBarang");
            double TotalHarga = extras.getDouble("TotalHarga");
            double DiscountHarga = extras.getDouble("DiscountHarga");
            double DiscountMember = extras.getDouble("DiscountMember");
            double JumlahBayar = extras.getDouble("JumlahBayar");

            TextView tvNama = findViewById(R.id.tvNama);
            TextView tvTipeMember = findViewById(R.id.tvTipeMember);
            TextView tvKodeBarang = findViewById(R.id.tvKodeBarang);
            TextView tvNamaBarang = findViewById(R.id.tvNamaBarang);
            TextView tvHarga = findViewById(R.id.tvHarga);
            TextView tvJumlahBarang = findViewById(R.id.tvJumlahBarang);
            TextView tvTotalHarga = findViewById(R.id.tvTotalHarga);
            TextView tvDiscountHarga = findViewById(R.id.tvDiscountHarga);
            TextView tvDiscountMember = findViewById(R.id.tvDiscountMember);
            TextView tvJumlahBayar = findViewById(R.id.tvJumlahBayar);

            tvNama.setText("Selamat Datang " + Nama);
            tvTipeMember.setText("Tipe Member : " + TipeMember);
            tvKodeBarang.setText("Kode Barang : " + KodeBarang);
            tvNamaBarang.setText("Nama Barang : " + NamaBarang);
            tvHarga.setText("Harga Barang : Rp " + Harga);
            tvJumlahBarang.setText("Jumlah Barang : " + JumlahBarang);
            tvTotalHarga.setText("Total Harga: Rp " + TotalHarga);
            tvDiscountHarga.setText("Discount Harga : Rp " + DiscountHarga);
            tvDiscountMember.setText("Discount Member : Rp " + DiscountMember);
            tvJumlahBayar.setText("Jumlah Bayar : Rp " + JumlahBayar);
        }
    }
}