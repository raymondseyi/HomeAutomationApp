package com.example.raymond.homeautomation;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.ToggleButton;

import com.example.raymond.homeautomation.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class MainActivity extends Activity{

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                ToggleButton port1 = (ToggleButton) findViewById(R.id.Port1);
                ToggleButton port2 = (ToggleButton) findViewById(R.id.Port2);
                ToggleButton port3 = (ToggleButton) findViewById(R.id.Port3);
                ToggleButton port4 = (ToggleButton) findViewById(R.id.Port4);
                ToggleButton port5 = (ToggleButton) findViewById(R.id.Port5);
                ToggleButton port6 = (ToggleButton) findViewById(R.id.Port6);
                ToggleButton port7 = (ToggleButton) findViewById(R.id.Port7);
                ToggleButton port8 = (ToggleButton) findViewById(R.id.Port8);
                port1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                if (isChecked) {

                                        new Background_get().execute("port1=1");
                                } else {
                                        new Background_get().execute("port1=0");
                                }
                        }
                });
                port2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                if (isChecked) {

                                        new Background_get().execute("port2=1");
                                } else {
                                        new Background_get().execute("port2=0");
                                }
                        }
                });
                port3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                if (isChecked) {

                                        new Background_get().execute("port3=1");
                                } else {
                                        new Background_get().execute("port3=0");
                                }
                        }
                });
                port4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                if (isChecked) {

                                        new Background_get().execute("port4=1");
                                } else {
                                        new Background_get().execute("port4=0");
                                }
                        }
                });
                port5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                if (isChecked) {

                                        new Background_get().execute("port5=1");
                                } else {
                                        new Background_get().execute("port5=0");
                                }
                        }
                });
                port6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                if (isChecked) {

                                        new Background_get().execute("port6=1");
                                } else {
                                        new Background_get().execute("port6=0");
                                }
                        }
                });
                port7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                if (isChecked) {

                                        new Background_get().execute("port7=1");
                                } else {
                                        new Background_get().execute("port7=0");
                                }
                        }
                });
                port8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                if (isChecked) {

                                        new Background_get().execute("port8=1");
                                } else {
                                        new Background_get().execute("port8=0");
                                }
                        }
                });

        }
        private class Background_get extends AsyncTask<String, Void, String> {
                @Override
                protected String doInBackground(String... params) {
                        try {

                                URL url = new URL("http://192.168.43.20/?" + params[0]);
                                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                                StringBuilder result = new StringBuilder();
                                String inputLine;
                                while ((inputLine = in.readLine()) != null)
                                        result.append(inputLine).append("\n");

                                in.close();
                                connection.disconnect();
                                return result.toString();

                        } catch (IOException e) {
                                e.printStackTrace();
                        }
                        return null;
                }
        }
}
