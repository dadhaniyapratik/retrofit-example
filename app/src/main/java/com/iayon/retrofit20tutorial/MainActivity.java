package com.iayon.retrofit20tutorial;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;

import models.ActorContact;
import rest.RestClient;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

public class MainActivity extends AppCompatActivity {

    private UserAdapter adapter ;
    ArrayList<ActorContact> actorContacts;
    ActorContact actorContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView = (ListView) findViewById(R.id.listView);
        actorContacts = new ArrayList<ActorContact>();


        final ProgressDialog dialog = ProgressDialog.show(this, "", "loading...");
        RestClient.GitApiInterface service = RestClient.getClient();

//        LoginInformation loginInformation = new LoginInformation();
//        loginInformation.setUsername("aa");
//        loginInformation.setPassword("aa");
//
//        Call<Item> call1   = service.createUser(loginInformation);
//        call1.enqueue(new Callback<Item>() {
//            @Override
//            public void onResponse(Response<Item> response) {
//                if (response.isSuccess())
//                {
//
//                    Log.e("","success");
//                    Log.e("",response.body().getLogin().toString());
//                }
//                else
//                {
//                    Log.e("","fail");
//                }
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                Log.e("","failed");
//            }
//        });
        Call<ActorContact> call = service.getUsersNamedTom("tom");
        call.enqueue(new Callback<ActorContact>() {
            @Override
            public void onResponse(Response<ActorContact> response) {
                dialog.dismiss();
                Log.d("MainActivity", "Status Code = " + response.code());
                if (response.isSuccess()) {
                    // request successful (status code 200, 201)
                    actorContact = response.body();
                    Log.d("MainActivity", "response = " + new Gson().toJson(actorContact));
//                    actorContacts = actorContact.getActors();
                    for (int i = 0; i <actorContact.getActors().size() ; i++) {
                        actorContacts.add(actorContact);
                    }

                    Log.d("MainActivity", "Items = " + actorContacts.size());
                    adapter = new UserAdapter(MainActivity.this, actorContacts);
                    listView.setAdapter(adapter);
                } else {
                    // response received but request not successful (like 400,401,403 etc)
                    //Handle errors

                }
            }

            @Override
            public void onFailure(Throwable t) {
                dialog.dismiss();
            }
        });
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
