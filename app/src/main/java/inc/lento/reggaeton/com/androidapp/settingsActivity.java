package inc.lento.reggaeton.com.androidapp;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class settingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText name = (EditText) findViewById(R.id.nameEditText);
        final EditText number = (EditText) findViewById(R.id.numberEditText);
        final EditText nameContact1 = (EditText) findViewById(R.id.nameContact1);
        final EditText numberContact1 = (EditText) findViewById(R.id.numberContact1);
        final EditText nameContact2 = (EditText) findViewById(R.id.nameContact2);
        final EditText numberContact2 = (EditText) findViewById(R.id.numberContact2);
        final EditText nameContact3 = (EditText) findViewById(R.id.nameContact3);
        final EditText numberContact3 = (EditText) findViewById(R.id.numberContact3);

        name.setText(PreferenceManager.getDefaultSharedPreferences(getApplication()).getString("name", ""));
        number.setText(PreferenceManager.getDefaultSharedPreferences(getApplication()).getString("number", "+34"));
        nameContact1.setText(PreferenceManager.getDefaultSharedPreferences(getApplication()).getString("nameContact1", ""));
        numberContact1.setText(PreferenceManager.getDefaultSharedPreferences(getApplication()).getString("numberContact1", "+34"));
        nameContact2.setText(PreferenceManager.getDefaultSharedPreferences(getApplication()).getString("nameContact2", ""));
        numberContact2.setText(PreferenceManager.getDefaultSharedPreferences(getApplication()).getString("numberContact2", "+34"));
        nameContact3.setText(PreferenceManager.getDefaultSharedPreferences(getApplication()).getString("nameContact3", ""));
        numberContact3.setText(PreferenceManager.getDefaultSharedPreferences(getApplication()).getString("numberContact3", "+34"));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PreferenceManager.getDefaultSharedPreferences(getApplication()).edit().putString("name", name.getText().toString()).apply();
                PreferenceManager.getDefaultSharedPreferences(getApplication()).edit().putString("number", number.getText().toString()).apply();
                PreferenceManager.getDefaultSharedPreferences(getApplication()).edit().putString("nameContact1", nameContact1.getText().toString()).apply();
                PreferenceManager.getDefaultSharedPreferences(getApplication()).edit().putString("numberContact1", numberContact1.getText().toString()).apply();
                PreferenceManager.getDefaultSharedPreferences(getApplication()).edit().putString("nameContact2", nameContact2.getText().toString()).apply();
                PreferenceManager.getDefaultSharedPreferences(getApplication()).edit().putString("numberContact2", numberContact2.getText().toString()).apply();
                PreferenceManager.getDefaultSharedPreferences(getApplication()).edit().putString("nameContact3", nameContact3.getText().toString()).apply();
                PreferenceManager.getDefaultSharedPreferences(getApplication()).edit().putString("numberContact3", numberContact3.getText().toString()).apply();

            }
        });
    }

}
