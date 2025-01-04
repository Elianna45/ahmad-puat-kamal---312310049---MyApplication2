package com.example.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.app.DownloadManager;

public class gambar02 extends AppCompatActivity {

    private EditText searchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gambar01);  // pastikan nama layout Anda sesuai

        // Mendapatkan referensi dari search bar
        searchBar = findViewById(R.id.search_bar);

        // Menambahkan listener untuk klik pada search bar
        searchBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mengarahkan ke SearchActivity saat search bar diklik
                Intent intent = new Intent(gambar02.this, search.class);
                startActivity(intent);
            }
        });

        // Cek dan minta izin untuk menulis ke penyimpanan eksternal jika belum diberikan
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            // Minta izin
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }

        // Tombol Download
        Button downloadButton = findViewById(R.id.download_button);

        // Set OnClickListener untuk tombol download
        downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Panggil metode untuk mengunduh ketika tombol diklik
                performDownload();
            }
        });
    }

    // Metode untuk menangani unduhan
    private void performDownload() {
        String url = "https://example.com/elsia1.jpg";  // Ganti dengan URL file yang sesuai

        // Dapatkan layanan DownloadManager sistem
        DownloadManager downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);

        // Buat Uri dari URL file
        Uri uri = Uri.parse(url);

        // Buat permintaan unduhan
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setTitle("Downloading File");
        request.setDescription("Downloading file to device");

        // Tentukan lokasi penyimpanan file yang diunduh
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "elsia1.jpg");

        // Tambahkan permintaan unduhan ke dalam antrean
        downloadManager.enqueue(request);

        // Tampilkan Toast sebagai konfirmasi
        Toast.makeText(gambar02.this, "Download started", Toast.LENGTH_SHORT).show();
    }

    // Tangani hasil izin (untuk perangkat dengan API 23+)
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Izin diberikan, sekarang Anda bisa melanjutkan unduhan
                Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
            } else {
                // Izin ditolak, tampilkan pesan kesalahan
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
