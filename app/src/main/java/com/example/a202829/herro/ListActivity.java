package com.example.a202829.herro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ListActivity extends ActionBarActivity {

    List myLIst = new ArrayList<>();
    Button addToList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_a_list);

        addToList = (Button) findViewById(R.id.addToListButton);

        myLIst.add(new ListItem("one", "first item"));
        final ArrayAdapter<ListItem> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myLIst);

        final ListView listView = (ListView) findViewById(R.id.myList);
        listView.setAdapter(listAdapter);

        addToList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                listAdapter.add(new ListItem(UUID.randomUUID().toString(), "another random item"));


            }
        });
    }





    public class ListItem {
      String label;
      String description;

        public ListItem(String label, String description) {
            this.label = label;
            this.description = description;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String toString() {
            return label + " " + description;
        }
    }
}
