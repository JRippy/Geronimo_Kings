package fr.geronimo.listsimple;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.ShareActionProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private ShareActionProvider mShareActionProvider;
    List<King> kingl = new ArrayList<King>();
    KingAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.listView);

        List<King> kingl = generateDefaultKingList();

        adapter = new KingAdapter(MainActivity.this, kingl);
        mListView.setAdapter(adapter);

    }

    private List<King> generateDefaultKingList(){

        kingl.add(new King(BitmapFactory.decodeResource(getResources(), R.drawable.game_of_throne), getResources().getString(R.string.GoFName), getResources().getString(R.string.GoFDetail)));
        kingl.add(new King(BitmapFactory.decodeResource(getResources(), R.drawable.cow_king), getResources().getString(R.string.CowName), getResources().getString(R.string.CowDetail)));
        kingl.add(new King(BitmapFactory.decodeResource(getResources(), R.drawable.viking_king), getResources().getString(R.string.VikingsName), getResources().getString(R.string.VikingsDetail)));
        return kingl;
    }

    private List<King> generateKingListMinus(){

        if (kingl.size() > 0)
        kingl.remove(kingl.size() - 1);

        return kingl;
    }

    private List<King> generateKingListPlus(){

        Random r = new Random();
        int newKing = 1 + r.nextInt(2);

        switch (newKing){
            case 1 :
                kingl.add(new King(BitmapFactory.decodeResource(getResources(), R.drawable.game_of_throne), getResources().getString(R.string.GoFName), getResources().getString(R.string.GoFDetail)));
            break;
            case 2 :
                kingl.add(new King(BitmapFactory.decodeResource(getResources(), R.drawable.cow_king), getResources().getString(R.string.CowName), getResources().getString(R.string.CowDetail)));
            break;
            case 3 :
                kingl.add(new King(BitmapFactory.decodeResource(getResources(), R.drawable.viking_king), getResources().getString(R.string.VikingsName), getResources().getString(R.string.VikingsDetail)));
            break;
            default:
        }



        return kingl;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_kings, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.plus:
                generateKingListPlus();
                adapter.notifyDataSetChanged();
                return true;
            case R.id.minus:
                generateKingListMinus();
                adapter.notifyDataSetChanged();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
