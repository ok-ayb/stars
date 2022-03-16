package ma.emsi.recycle1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import ma.emsi.recycle1.adapter.FruitAdapter;
import ma.emsi.recycle1.beans.Fruit;
import ma.emsi.recycle1.service.FruitService;


public class MainActivity extends AppCompatActivity  {

    private FruitService fs;

    private RecyclerView recyle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fs = FruitService.getInstance();

        fs.create(new Fruit("Cabbage", 12, "https://www.hindimeaning.com/wp-content/uploads/2012/12/green-cabbage.jpg"));
        fs.create(new Fruit("Cauliflower", 12, "https://www.hindimeaning.com/wp-content/uploads/2015/08/cauliflower.jpg"));
        fs.create(new Fruit("Carrot", 12, "https://www.hindimeaning.com/wp-content/uploads/2012/12/carrots-vegetables.jpg"));
        fs.create(new Fruit("Cabbage", 12, "https://www.hindimeaning.com/wp-content/uploads/2012/12/green-cabbage.jpg"));
        fs.create(new Fruit("Cauliflower", 12, "https://www.hindimeaning.com/wp-content/uploads/2015/08/cauliflower.jpg"));
        fs.create(new Fruit("Carrot", 12, "https://www.hindimeaning.com/wp-content/uploads/2012/12/carrots-vegetables.jpg"));

        fs.create(new Fruit("Cabbage", 12, "https://www.hindimeaning.com/wp-content/uploads/2012/12/green-cabbage.jpg"));
        fs.create(new Fruit("Cauliflower", 12, "https://www.hindimeaning.com/wp-content/uploads/2015/08/cauliflower.jpg"));
        fs.create(new Fruit("Carrot", 12, "https://www.hindimeaning.com/wp-content/uploads/2012/12/carrots-vegetables.jpg"));

        fs.create(new Fruit("Cabbage", 12, "https://www.hindimeaning.com/wp-content/uploads/2012/12/green-cabbage.jpg"));
        fs.create(new Fruit("Cauliflower", 12, "https://www.hindimeaning.com/wp-content/uploads/2015/08/cauliflower.jpg"));
        fs.create(new Fruit("Carrot", 12, "https://www.hindimeaning.com/wp-content/uploads/2012/12/carrots-vegetables.jpg"));

        recyle = findViewById(R.id.recyle);

        recyle.setAdapter(new FruitAdapter(getApplicationContext(), fs.findAll()));
        recyle.setLayoutManager(new GridLayoutManager(this, 2 ));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id) {
            case R.id.save :
                String txt = "Fruits";
                String mimeType = "text/plain";
                ShareCompat.IntentBuilder
                        .from(this)
                        .setType(mimeType)
                        .setChooserTitle("Fruits")
                        .setText(txt)
                        .startChooser();
                return true;
            case R.id.edit:
                Toast.makeText(this, "locate", Toast.LENGTH_LONG).show();
                return true;
            case R.id.exit :
                Toast.makeText(this, "exit", Toast.LENGTH_LONG).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
