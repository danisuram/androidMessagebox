package com.example.latihanmessagebox;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

//    TODO 1 deklarasi widget
    Button btnToast, btnAlert, btnSnackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        TODO 2 Inisialisasi dgn panggil ID

        btnToast    = findViewById(R.id.btn_toast);
        btnAlert    = findViewById(R.id.btn_alert);
        btnSnackbar = findViewById(R.id.btn_snackbar);

//        TODO 3.1 action button cara 1 di tampung dalam onCreate
        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "hehe.", Toast.LENGTH_SHORT).show();
            }
        });

//        TODO 3.2 button cara 2, implement ke view onClick
        btnAlert.setOnClickListener(this);
        btnSnackbar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        int id = view.getId();

        if (id==R.id.btn_alert){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Judul Alert");
            alert.setMessage("Pesan Alert");
            alert.setCancelable(false);
            alert.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            alert.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            alert.setNeutralButton("Netral", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            alert.show();


        }

        if(id == R.id.btn_snackbar){

            Snackbar mySnackbar = Snackbar.make(findViewById(R.id.linear),"ini snackbar", Snackbar.LENGTH_SHORT);
            mySnackbar.setAction("Undo", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this,"Undo", Toast.LENGTH_SHORT).show();
                }
            });
            mySnackbar.show();
        }

    }
}
