package sg.edu.rp.c346.id20009530.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etName, etGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etGPA = findViewById(R.id.gpa);
        etName = findViewById(R.id.name);


    }


    @Override
    protected void onPause() {
        super.onPause();
        //step 1 get user input and store in a variable
        String nameStr = etName.getText().toString();
        float gpaFloat = Float.parseFloat(etGPA.getText().toString());

        //step 2 obtain an instance of the SharedPreferences
        SharedPreferences pref = getPreferences(MODE_PRIVATE);

        //step 3 create sharedPreference editor by calling edit;
        SharedPreferences.Editor prefEdit = pref.edit();

        // step 4 set a key-value pair in the editor;
        prefEdit.putString("name", nameStr);
        prefEdit.putFloat("gpa", gpaFloat);

        //step 5 call commit to save the changes;
        prefEdit.commit();

    }

    @Override
    protected void onResume() {
        super.onResume();

        //step 1 obtain an instance of the SharedPreferences
        SharedPreferences pref = getPreferences(MODE_PRIVATE);

        //step 2 retrieve the saved data from sharedPreference
        String message = pref.getString("name", "name not entered to be saved");
        float message2 = pref.getFloat("gpa", 4.0f);

        // update UI  ELEMENT with the value
        etName.setText(message);
        etGPA.setText(message2 + ""); // cannot setText float so add a space


    }
}