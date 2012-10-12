package com.nrcan.main;

import com.nrcan.controllers.MetadataController;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ViewFlipper;

public class MainActivity extends ListActivity {
	private MetadataController adap1;
	private ListView lv1;
	SQLiteDatabase db;
	ViewFlipper flipper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button button1 = (Button) findViewById(R.id.buttonSave);
    	button1.setOnClickListener(new View.OnClickListener() {
    		public void onClick(View v) {
    			flipper.showNext();
    		}
    	});
    	
    	//initializeDatabase();
    	
    	lv1 = getListView();
    	adap1 = new MetadataController(this, this);
    	setListAdapter(adap1);
        
        flipper = (ViewFlipper) findViewById(R.id.viewFlipper1);
        
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
        //View v1 = inflater.inflate(R.layout.metadata, null);
        //View v2 = inflater.inflate(R.layout.station_bedrock_1, null);
        
        //flipper.addView(v1);
        //flipper.addView(v2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    /*
    public void initializeDatabase() {
    	db = this.openOrCreateDatabase("nrcandb", MODE_PRIVATE, null);
    	db.close();
    }
    */
    
}
