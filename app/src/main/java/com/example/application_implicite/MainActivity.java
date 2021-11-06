package com.example.application_implicite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button cl,sms,cam,gal,pl;
    ImageView im;
private  static  final int CAMERA_REQUEST=123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cl = findViewById(R.id.btncall);
        sms = findViewById(R.id.btn_SmS);
        cam = findViewById(R.id.btn_cam);
        gal = findViewById(R.id.btn_Gall);
        pl = findViewById(R.id.btn_plytech);
        im = findViewById(R.id.img);

      /*  cl.setOnClickListener(ls);
        sms.setOnClickListener(ls);
        cam.setOnClickListener(ls);
        gal.setOnClickListener(ls);
        pl.setOnClickListener(ls);*/
    }
      /*  View.OnClickListener ls = new View.OnClickListener() {


            @Override
            public void onClick(View view) {



            }
        };*/

      public void Camonclick(View v ){
           Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
          //startActivity(i);
          startActivityForResult(i, CAMERA_REQUEST);
      };


      @SuppressLint("MissingSuperCall")
      public void onActivityResult(int requestCode , int resultCode , Intent data) {
            if (requestCode== CAMERA_REQUEST && resultCode== Activity.RESULT_OK){
                Bitmap photo =(Bitmap) data.getExtras().get("data");
                im.setImageBitmap(photo);
            }

      }


      public void clonclick(View v){
          Uri u;
          //u =  Uri.parse("https://polytechmonastir.tn/");
          Intent i = new Intent(Intent.ACTION_DIAL);
          i.setData(Uri.parse("tel:"));
          startActivity(i);

      }


      public void clicksite(View v){
          Uri u = Uri.parse("https://polytechmonastir.tn/");
         Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(u);
          startActivity(i);
      }
      public void opeImage(View v){
          Intent i = new Intent();
          i.setAction(Intent.ACTION_VIEW);
          i.setType("image/*");
          i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
          startActivity(i);
      }

      public void clickmessage(View v){
          Uri sms = Uri.parse("smsto:");
          Intent i = new Intent(Intent.ACTION_SENDTO,sms);
          i.putExtra("sms_body","bonjour");
          startActivity(i);



      }

}