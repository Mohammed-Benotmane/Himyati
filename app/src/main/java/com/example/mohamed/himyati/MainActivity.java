package com.example.mohamed.himyati;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.logo));

    }

    public void login (View view){
        EditText userName = findViewById(R.id.editText);
        EditText password = findViewById(R.id.editText2);
        if(userName.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
            Intent intent = new Intent(MainActivity.this,Main2Activity.class);
            startActivity(intent);
        }else{
            Toast.makeText(MainActivity.this,"Username or Password incorrect",Toast.LENGTH_SHORT).show();
        }
    }
}
