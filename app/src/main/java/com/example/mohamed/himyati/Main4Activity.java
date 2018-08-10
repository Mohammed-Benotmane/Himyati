package com.example.mohamed.himyati;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Intent intent = getIntent();
        TextView nom = findViewById(R.id.textView6);
        nom.setText(intent.getStringExtra("a"));
        ArrayList<Item> fatGP = new ArrayList<>();

        Item item1 = new Item(R.drawable.coffee,"-Céréales(70da) \n-un verre jus/lait (30da)");
        Item item2 = new Item(R.drawable.lunch,"-Légumes vert (70da) \n-150g escalope/poulet (150da) \n-300g Riz(30da) " );
        Item item3 = new Item(R.drawable.dinner,"-Soupe de Légumes (60da) \n-150g escalope/poulet (150da) \n-60g pain(10da) \n-un fruit pomme/poire (100da) ");

        fatGP.add(item1);
        fatGP.add(item2);
        fatGP.add(item3);

        Adapter adapter = new Adapter(fatGP);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);


    }
    public class Adapter extends BaseAdapter {
        ArrayList<Item> items=new ArrayList<Item>();
        public Adapter(ArrayList<Item> items){
            this.items=items;
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int i) {
            return items.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            Item item=new Item();
            item=items.get(i);
            View v;
            LayoutInflater inflater=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=inflater.inflate(R.layout.items,null);
            ImageView imageView=v.findViewById(R.id.imageView4);
            TextView textView=v.findViewById(R.id.textView9);
            textView.setText(item.getDescription());
            imageView.setImageResource(item.getImage());
            return v;
        }
    }
}
