package com.example.mohamed.himyati;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ImageView imageView = findViewById(R.id.imageView2);
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.logo));
    }
    public void valider (View view){
        EditText nom = findViewById(R.id.editText3);
        EditText age = findViewById(R.id.editText4);
        EditText taille = findViewById(R.id.editText5);
        EditText poids = findViewById(R.id.editText6);
        Intent intent = new Intent(Main2Activity.this,Main3Activity.class);
        intent.putExtra("a",nom.getText().toString());
        intent.putExtra("b",age.getText().toString());
        intent.putExtra("c",taille.getText().toString());
        intent.putExtra("d",poids.getText().toString());
        startActivity(intent);

    }
}
