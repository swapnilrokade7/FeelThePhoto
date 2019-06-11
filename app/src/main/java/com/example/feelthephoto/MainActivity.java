package com.example.feelthephoto;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    Button button;
    ImageButton button1;
    ImageView imageView;
    final static int picbycamera=10;
    Intent intent;
    Bitmap bitmp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        button1=findViewById(R.id.imageButton2);
        imageView=findViewById(R.id.imageView);
        InputStream inputStream=getResources().openRawResource(R.drawable.image_one);
        bitmp= BitmapFactory.decodeStream(inputStream);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               try {
                    getApplicationContext().setWallpaper(bitmp);
                }
                catch (IOException e){
                    e.printStackTrace();
                }
                Toast.makeText(MainActivity.this, "Feel !!!", Toast.LENGTH_SHORT).show();

            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,picbycamera);
                Toast.makeText(MainActivity.this,"Look",Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK)
        {
            Bundle extras= data.getExtras();
            bitmp=(Bitmap) extras.get("data");
            imageView.setImageBitmap(bitmp);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();//int bcoz of switch case
        switch (id)
        {
            case R.id.item1:
                Toast.makeText(MainActivity.this, "Hii  1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2:
                Toast.makeText(MainActivity.this, "Hii  2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item3:
                Toast.makeText(MainActivity.this, "Hii  3", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
