package com.ench.sandhya2117.list_exe;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView) findViewById(R.id.onemn);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
 new kilomilo().execute(Global_Url_Used.INSERT_DATA);
    }
   public class MovieAdap extends ArrayAdapter {

        private List<Alldays_main> movieModelList;
        private int resource;
        Context context;
        private LayoutInflater inflater;
        MovieAdap(Context context, int resource, List<Alldays_main> objects) {
            super(context, resource, objects);
            movieModelList = objects;
            this.context =context;
            this.resource = resource;
            inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

        }
        @Override
        public int getViewTypeCount() {

            return 1;
        }

        @Override
        public int getItemViewType(int position) {

            return position;
        }


        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            final ViewHolder holder  ;

            if(convertView == null){
                convertView = inflater.inflate(resource,null);
                holder = new ViewHolder();

                holder.textidd=(TextView)  convertView.findViewById(R.id.textView1);
                holder.textid =(TextView)  convertView.findViewById(R.id.textView2);
                convertView.setTag(holder);
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);

            }
            else {
                holder = (ViewHolder) convertView.getTag();
            }
            Alldays_main ccitac=movieModelList.get(position);
            holder.textidd.setText(ccitac.getIds());
            holder.textid.setText(ccitac.getDaysofwhat());
            return convertView;

        }
        class ViewHolder{

            public TextView textid,textidd,t1,t2;

        }

    }


    public class kilomilo extends AsyncTask<String,String, List<Alldays_main>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected List<Alldays_main> doInBackground(String... params) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuilder buffer = new StringBuilder();
                String line = "";
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }

                String finalJson = buffer.toString();

                JSONObject parentObject = new JSONObject(finalJson);
                JSONArray parentArray = parentObject.getJSONArray("result");
                List<Alldays_main> milokilo = new ArrayList<>();
                Gson gson = new Gson();
                for (int i = 0; i < parentArray.length(); i++) {
                    JSONObject finalObject = parentArray.getJSONObject(i);
                    Alldays_main catego = gson.fromJson(finalObject.toString(), Alldays_main.class);
                    milokilo.add(catego);

                }

                return milokilo;

            } catch (JSONException | IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;

        }

        @Override
        protected void onPostExecute(final List<Alldays_main> movieMode) {
            super.onPostExecute(movieMode);
            if (movieMode.size()>0)
            {
                MovieAdap adapter = new MovieAdap(getApplicationContext(), R.layout.list_main, movieMode);
                listView.setAdapter(adapter);

            }
            else
            {
               // Toast.makeText(getApplicationContext(),"Check your internet connection",Toast.LENGTH_SHORT).show();
            }

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                   // if(position==0) {

                        ViewGroup vb=(ViewGroup) view;
                        TextView t1=(TextView)vb.findViewById(R.id.textView1);
                        TextView t2=(TextView)vb.findViewById(R.id.textView2);
                        String amm=t1.getText().toString();
                        String ann=t2.getText().toString();
                        Intent in = new Intent(view.getContext(), Main2Activity.class);
                        in.putExtra("abc",amm);
                        in.putExtra("acb",ann);
                       startActivity(in);
                        // startActivityForResult(in,0);
                 //
                    //   }
//                   if(position==1) {
//                    ViewGroup vb=(ViewGroup) view;
//                    TextView t1=(TextView)vb.findViewById(R.id.textView1);
//                    TextView t2=(TextView)vb.findViewById(R.id.textView2);
//                    String amm=t1.getText().toString();
//                    String ann=t2.getText().toString();
//                    Intent inn = new Intent(view.getContext(), Main2Activity.class);
//                    inn.putExtra("abc",amm);
//                   inn.putExtra("acb",ann);
//                    startActivity(inn);
////                        Intent in = new Intent(view.getContext(), Main2Activity.class);
////                        startActivityForResult(in,1);
//                    }
//                   if(position==2) {
//                    ViewGroup vb=(ViewGroup) view;
//                    TextView t1=(TextView)vb.findViewById(R.id.textView1);
//                    TextView t2=(TextView)vb.findViewById(R.id.textView2);
//                    String amm=t1.getText().toString();
//                    String ann=t1.getText().toString();
//                    Intent in = new Intent(view.getContext(), Main2Activity.class);
//                    in.putExtra("abc",amm);
//                    in.putExtra("acb",ann);
//                    startActivity(in);
////                       Intent in = new Intent(view.getContext(), Main2Activity.class);
////                        startActivityForResult(in,2);
////                    }


                }
            });

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
