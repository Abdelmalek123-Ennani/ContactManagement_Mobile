package ma.enset.contactlist_api_spring;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    ArrayList<Contact> contacts = new ArrayList<>();
   // String base_url = "http://localhost:8080/";
    ApiInterface apiInterface;
    FloatingActionButton floatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Context context = this;
        floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, LoginActivity.class);
                startActivity(intent);
            }
        });

        fetchDataFromAPI();
    }


    private void fetchDataFromAPI() {
        ApiInterface apiInterface = ApiClient.getApiRetrofit().create(ApiInterface.class);
        Call<List<Contact>> call = apiInterface.getContacts();
        call.enqueue(new Callback<List<Contact>>() {
            @Override
            public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {
              List<Contact> contactList = response.body();
                for (int i = 0; i < contactList.size(); i++) {
                    Contact c=new Contact(contactList.get(i));
                    contacts.add(c);
                }

                RecyclerView recyclerView = findViewById(R.id.contactRecycleView);
                RecyclerViewAdapter adapter = new RecyclerViewAdapter(MainActivity.this, contacts);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

                Log.i(MainActivity.class.getSimpleName(), response.body().toString());
            }

            @Override
            public void onFailure(Call<List<Contact>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "rp :"+
                                t.getMessage().toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }


}