package com.example.tomisan.tomicaqin;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.example.tomisan.tomicaqin.R;

public class MenuDemo extends Activity {

    private EditText tEdit1;
    private EditText tEdit2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_demo);
        tEdit1 = (EditText) this.findViewById(R.id.editText1);
        tEdit2 = (EditText) this.findViewById(R.id.editText2);
        registerForContextMenu(tEdit1);
        registerForContextMenu(tEdit2);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch (v.getId()){
            case R.id.editText1:
                menu.add(0,1,0,"菜单项1");
                menu.add(0,2,0,"菜单项2");
                menu.add(0,3,0,"菜单项3");
                break;
            case R.id.editText2:
                menu.add(0,4,0,"菜单项4");
                menu.add(0,5,0,"菜单项5");
                break;
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        menu.add(Menu.NONE,1,Menu.NONE,"添加");
        menu.add(Menu.NONE,2,Menu.NONE,"删除");
        menu.add(Menu.NONE,3,Menu.NONE,"保存").setIcon(android.R.drawable.ic_menu_edit);
        menu.add(Menu.NONE,4,Menu.NONE,"退出");
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
