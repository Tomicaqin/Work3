package com.example.tomisan.tomicaqin;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.example.tomisan.tomicaqin.R;

public class CLASS1 extends Activity {
    private EditText account,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class1);
        account = (EditText) findViewById(R.id.editText);
        pass = (EditText) findViewById(R.id.editText2);

        SharedPreferences user = getSharedPreferences("user",0);
        account.setText(user.getString("username","who are you"));
        pass.setText(user.getString("pass",""));
    }

    public void save(View v) {
        SharedPreferences user = getSharedPreferences("user",0);
        SharedPreferences.Editor editor = user.edit();
        editor.putString("username",account.getText().toString());
        editor.putString("pass",pass.getText().toString());
        editor.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_class1, menu);
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
