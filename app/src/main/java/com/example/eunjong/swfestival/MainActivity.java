package com.example.eunjong.swfestival;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button createButton = (Button) findViewById(R.id.create);

        createButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), CreateActivity.class);//intent는 새로운 창을 열기 위해서 필요한 객체
                startActivity(intent);
            }
        });



        ///
        TextView welcomeMessage = (TextView) findViewById(R.id.welcomeMessage);

        Intent intent = getIntent();
        String userID = intent.getStringExtra("userID");
        String userPassword = intent.getStringExtra("userPassword");
        String message = "환영합니다, " + userID + "님!";
        Button managementButton = (Button) findViewById(R.id.managementButton);

        welcomeMessage.setText(message);

        if (!userID.equals("admin")) {
            managementButton.setVisibility(View.GONE);
        }

        managementButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                new BackrgroundTask().execute();
            }
        });

    }


        class BackrgroundTask extends AsyncTask<Void, Void, String>{
            String target;

            @Override
            protected void onPreExecute(){
                target = "http://gladi4231.cafe24.com/List.php";
            }

            @Override
            protected String doInBackground(Void... voids){
                try{
                    URL url = new URL(target);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    String temp;
                    StringBuilder stringBuilder = new StringBuilder();
                    while((temp = bufferedReader.readLine()) != null){
                        stringBuilder.append(temp + "/n");
                    }
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return stringBuilder.toString().trim();

                } catch (Exception e){
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            public void onProgressUpdate(Void... values){
                super.onProgressUpdate(values);
            }

            @Override
            public void onPostExecute(String result){
                Intent intent = new Intent(MainActivity.this, ManagementActivity.class);
                intent.putExtra("userList", result);
                MainActivity.this.startActivity(intent);
            }


        }

}
