package com.example.mohamed.himyati;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    String[] budget = {"1000da","2000da","3000da","4000da","5000da","6000da","7000da","8000da","9000da","10000da"};
    String age;
    String nom;
    double res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ImageView imageView3 = findViewById(R.id.imageView3);
        imageView3.setImageDrawable(getResources().getDrawable(R.drawable.logo));
        ListView listView = findViewById(R.id.listView);
        ImageView imageView = findViewById(R.id.imageView10);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,budget);
        listView.setAdapter(adapter);
        Intent intent = getIntent();
        nom = intent.getStringExtra("a");
        age = intent.getStringExtra("b");
        String taille = intent.getStringExtra("c");
        String poids = intent.getStringExtra("d");
        double t = Double.parseDouble(taille)/100;
        double p = Double.parseDouble(poids);
        res = (int)((p / (t * t))*100);
        res = res/100;
        TextView hello = findViewById(R.id.textView);
        hello.setText("Hello" + nom);
        final TextView imc = findViewById(R.id.textView2);
        TextView kilo = findViewById(R.id.textView3);
        imc.setText("Votre masse corporelle est de " + Double.toString(res));
        if(res<18.5){
            kilo.setText("Poids Insuffisant");
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.sad));
        }
        else{
            if(res<25){
                kilo.setText("Poids Normal");
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.happy));
            }
            else{
                if (res<30){
                    kilo.setText("Surpoids");
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.sad));
                }
                else{
                    if (res<35){
                        kilo.setText("Obesité Classe 1");
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.sad));
                    }
                    else{
                        if (res<40){
                            kilo.setText("obesité Classe 2");
                            imageView.setImageDrawable(getResources().getDrawable(R.drawable.angry));
                        }
                        else{
                            kilo.setText("Obesité Classe 3");
                            imageView.setImageDrawable(getResources().getDrawable(R.drawable.angry));
                        }
                    }
                }
            }
        }
        int p1;
        TextView textView = findViewById(R.id.textView4);
        if (res<18.5){
            p1= (int)((18.5 * t * t)-p)+1;
            textView.setText("Vous devez prendre au minimum " + String.valueOf(p1) + " kg ");
        }
        else{
            if (res>24.9){
                p1 = (int)(p -(24.9 * t * t));
                textView.setText("Vous devez perdre au minimum " + String.valueOf(p1) + " kg ");
            }else{
                textView.setText("Bravo Vous etes parfait");
            }
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent moha = new Intent(Main3Activity.this,Main4Activity.class);
                moha.putExtra("a",nom);
                moha.putExtra("b",res);
                moha.putExtra("c",adapterView.getItemIdAtPosition(i));
                startActivity(moha);

            }
        });
    }
}
