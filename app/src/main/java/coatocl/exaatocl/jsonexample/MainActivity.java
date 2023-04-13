package coatocl.exaatocl.jsonexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.res.AssetManager;
import android.os.Bundle;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recycler;
    ArrayList<String> employeeName = new ArrayList<>();
    ArrayList<String> employeeEmail = new ArrayList<>();
    ArrayList<String> employeeNumber = new ArrayList<>();
    Adapter adapter;
    LinearLayoutManager linearLayoutManager;
//    String filename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler = findViewById(R.id.recycler);

        linearLayoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(linearLayoutManager);

        try {

            String jsonLocation = AssetsJSONFile();

            JSONObject jsnObj = new JSONObject(jsonLocation);
            JSONArray array123 = jsnObj.getJSONArray("employees");

            for (int i = 0; i < array123.length(); i++) {
                JSONObject userDetails = array123.getJSONObject(i);

                employeeName.add(userDetails.getString("employeeName"));
                employeeEmail.add(userDetails.getString("employeeEmail"));
                employeeNumber.add(userDetails.getString("employeeMobile"));

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        adapter = new Adapter(employeeName, employeeEmail, employeeNumber, this);
        recycler.setAdapter(adapter);

    }

    private String AssetsJSONFile() {
        AssetManager manager = this.getAssets();
        InputStream file = null;
        try {
            file = manager.open("employee_details.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] formArray = new byte[0];
        try {
            assert file != null;
            formArray = new byte[file.available()];
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            file.read(formArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new String(formArray);
    }
}