package com.littlecheesecake.drawerdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.littlecheesecake.drawerdemo.layout.MainLayout;


public class MyActivity extends Activity {
    // Main content will holds our Fragment respectively
    MainLayout mainLayout;

    // ListView menu
    private ListView lvMenu;
    private String[] lvMenuItems;

    // Menu button
    Button btMenu;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        mainLayout = (MainLayout)this.getLayoutInflater().inflate(R.layout.activity_my, null);
        setContentView(mainLayout);

        lvMenuItems = getResources().getStringArray(R.array.menu_items);
        lvMenu = (ListView) findViewById(R.id.activity_main_menu_listview);
        lvMenu.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, lvMenuItems));
        lvMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onMenuItemClick(parent, view, position, id);
            }

        });


        // Get menu button
        btMenu = (Button) findViewById(R.id.activity_main_content_button_menu);
        btMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show/hide the menu
                toggleMenu(v);
            }
        });

    }
    public void toggleMenu(View v){
        mainLayout.toggleMenu();
    }

    // Perform action when a menu item is clicked
    private void onMenuItemClick(AdapterView<?> parent, View view, int position, long id) {
        String selectedItem = lvMenuItems[position];
        String currentItem = "Home";

        // Do nothing if selectedItem is currentItem
        if (selectedItem.compareTo(currentItem) == 0) {
            mainLayout.toggleMenu();
            return;
        }

    }
}
