package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<AdapterItems> listViewData = new ArrayList<AdapterItems>();
    MyCustomAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ArrayList<AdapterItems> listViewData = new ArrayList<AdapterItems>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listViewList);

        myAdapter = new MyCustomAdapter(listViewData);
        listView.setAdapter(myAdapter);

        //add data and view it
        listViewData.add(new AdapterItems(R.drawable.one,"developer"," develop apps"));
        listViewData.add(new AdapterItems(R.drawable.two,"tester"," develop apps"));
        listViewData.add(new AdapterItems(R.drawable.three,"manager"," develop apps"));

        myAdapter=new MyCustomAdapter(listViewData);
        ListView  lsNews=(ListView)findViewById(R.id.listViewList);

        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                final AdapterItems s = listViewData.get(i);
                TextView textView = view.findViewById(R.id.imageViewPicture);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        lsNews.setAdapter(myAdapter);

        myAdapter.notifyDataSetChanged();
    }

    public void addNew(View view) {
        listViewData.add(new AdapterItems(R.drawable.one,"Added"," develop apps"));
        myAdapter.notifyDataSetChanged();
    }

    //display news list
    private class MyCustomAdapter extends BaseAdapter {
        public ArrayList<AdapterItems> listnewsDataAdpater ;

        public MyCustomAdapter(ArrayList<AdapterItems>  listnewsDataAdpater) {
            this.listnewsDataAdpater=listnewsDataAdpater;
        }


        @Override
        public int getCount() {
            return listnewsDataAdpater.size();
        }

        @Override
        public String getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            LayoutInflater mInflater = getLayoutInflater();
            View myView = mInflater.inflate(R.layout.layout_ticket, null);

            final   AdapterItems s = listnewsDataAdpater.get(position);

            ImageView imageViewOne=myView.findViewById(R.id.imageViewPicture);
            imageViewOne.setImageResource(s.ID);

            TextView textViewJobTitle=( TextView)myView.findViewById(R.id.textViewJobTitle);
            textViewJobTitle.setText(s.jobTitle);

            textViewJobTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, s.jobTitle, Toast.LENGTH_SHORT).show();
                }
            });

            TextView textViewDescription=( TextView)myView.findViewById(R.id.textViewDescription);
            textViewDescription.setText(s.description);

            return myView;
        }

    }

}

