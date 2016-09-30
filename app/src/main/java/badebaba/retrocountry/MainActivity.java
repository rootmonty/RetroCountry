package badebaba.retrocountry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/*
Warnings approaching the solution of app code,The json array has been parsed and received in a list,however sometimes on running the app
the app shows the list butmany a times not.I have not gone to the handling of database yet I was just working on lists.
09-30 08:33:26.720 18158-18158/badebaba.retrocountry I/Checking output: [badebaba.retrocountry.Model@3f3a977e, badebaba.retrocountry.Model@2f8f14df, badebaba.retrocountry.Model@1bc2052c, badebaba.retrocountry.Model@1b37cbf5, badebaba.retrocountry.Model@b64ad8a, badebaba.retrocountry.Model@97a1ffb, badebaba.retrocountry.Model@35e04818, badebaba.retrocountry.Model@21063271, badebaba.retrocountry.Model@27681856, badebaba.retrocountry.Model@2740c0d7, badebaba.retrocountry.Model@2e9dcdc4, badebaba.retrocountry.Model@177a84ad, badebaba.retrocountry.Model@1e6563e2, badebaba.retrocountry.Model@38669373, badebaba.retrocountry.Model@28c0230, badebaba.retrocountry.Model@1f67bea9, badebaba.retrocountry.Model@1af9dc2e, badebaba.retrocountry.Model@170cf3cf, badebaba.retrocountry.Model@23e7115c, badebaba.retrocountry.Model@39d49c65]
09-30 08:33:31.380 18158-18158/badebaba.retrocountry W/art: Before Android 4.1, method int android.support.v7.widget.ListViewCompat.lookForSelectablePosition(int, boolean) would have incorrectly overridden the package-private method in android.widget.ListView
09-30 08:33:31.380 18158-18158/badebaba.retrocountry I/ListPopupWindow: Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.
09-30 08:33:31.440 18158-18186/badebaba.retrocountry W/EGL_emulation: eglSurfaceAttrib not implemented
09-30 08:33:31.440 18158-18186/badebaba.retrocountry W/OpenGLRenderer: Failed to set EGL_SWAP_BEHAVIOR on surface 0x7f290a572480, error=EGL_SUCCESS
09-30 08:33:33.590 18158-18158/badebaba.retrocountry W/InputEventReceiver: Attempted to finish an input event but the input event receiver has already been disposed.
 */
public class MainActivity extends AppCompatActivity {

    ListView listView;
    MyAdapter adapter;
    Model_List obj = new Model_List();
    Model chik;
    List<Model> modchik = new ArrayList<>();
    List<String> test = new ArrayList<>();
    List<Model> check = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listview);
        /*
        This includes the section of retrofit.Retrofit building of Url and conversion of http api
        to java interface
         */
        Retrofit retrofit;
        retrofit = new Retrofit.Builder().baseUrl("http://staging.pstakecare.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();

      /*
        Type collectionType = new TypeToken<Collection<Integer>>(){}.getType();
        Collection<Integer> ints2 = gson.fromJson(json, collectionType);
        */
        ServiceApi service = retrofit.create(ServiceApi.class);
        Call<List<Model>> route = service.repos();

        route.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                Log.d("Debugging", "" + response.body());
                modchik = response.body();
                for (int i = 0; i < modchik.size(); i++) {
                    test.add(i, modchik.get(i).getName());
                    check.add(i, modchik.get(i));

                }
                Log.i("Checking output", "" + modchik);
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                Log.e("ERROR FOUND", t.toString());

            }
        });

        // Collections.sort(check,new AreaComparator());
        // ArrayAdapter<String> testing = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,test);
        adapter = new MyAdapter(getApplicationContext(), check);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);
        // listView.setAdapter(testing);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void arranging(MenuItem item) {
        List<Model> nulist;
        nulist = check;
        adapter.clear();
        Collections.sort(nulist, new AreaComparator());
        adapter = new MyAdapter(getApplicationContext(), nulist);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);
    }

    public void refresh(MenuItem item) {
        // adapter.clear();
        List<Model> refreshlist;
        refreshlist = check;
        adapter.clear();
        adapter = new MyAdapter(getApplicationContext(), refreshlist);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);
    }

}
