package com.example.pumpen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private EditText discordTag;
    private EditText password;
    private OkHttpClient client;
    private Request request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        discordTag = (EditText) findViewById(R.id.discordTag);
        password = (EditText) findViewById(R.id.password);
        password.setHint("Password");
        discordTag.setHint("Discord Tag");

        client = new OkHttpClient();

        request = new Request.Builder()

                // using localhost does not work since the emulated phone does not host the server
                // with 10.0.2.2, the host can be accessed
                .url("http://10.0.2.2:3000/login")
                .build();

    }

    public void login(View view) {

        try {

            String s = new JSONObject().put("discord_tag", discordTag.getText())
                    .put("password", password.getText())
                    .toString();
            System.out.println(s);

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(@NonNull Call call, @NonNull IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                    System.out.println(response.body().string());
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}