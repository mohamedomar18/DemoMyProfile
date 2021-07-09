package sg.edu.rp.c346.id20048218.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.shadow.ShadowRenderer;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etGPA = findViewById(R.id.etGPA);
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);

        SharedPreferences.Editor prefEdit = prefs.edit();

        String strName = etName.getText().toString();
        String strGPA = etGPA.getText().toString();
        float gpa = Float.parseFloat(strGPA);

        prefEdit.putString("name", strName);
        prefEdit.putFloat("gpa", gpa);

        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);

        String strname = prefs.getString("name", "No name set");
        float gpa = prefs.getFloat("gpa", 0.0f);
        String strGPA = String.valueOf(gpa);

        etName.setText(strname);
        etGPA.setText(strGPA);
    }
}