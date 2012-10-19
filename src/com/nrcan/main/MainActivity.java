package com.nrcan.main;

import com.nrcan.controllers.MetadataController;
import com.nrcan.controllers.PhotoController;
import com.nrcan.controllers.SampleBedrockController;
import com.nrcan.controllers.StationBedrockController;
import com.nrcan.controllers.StructureController;

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
	private StationBedrockController adap2;
	private SampleBedrockController adap3;
	private StructureController adap4;
	private PhotoController adap5;
	
	private ListView lv1;
	private ListView lv2;
	private ListView lv3;
	private ListView lv4;
	private ListView lv5;
    // test comment	
	SQLiteDatabase db;
	ViewFlipper flipper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flipper = (ViewFlipper) findViewById(R.id.viewFlipper1);
        
        Button button1 = (Button) findViewById(R.id.buttonSave);
    	button1.setOnClickListener(new View.OnClickListener() {
    		public void onClick(View v) {
    			flipper.showNext();
    		}
    	});
    	
    	//initializeDatabase();
    	
    	lv1 = getListView();
    	lv2 = (ListView)findViewById(R.id.listStationBedrock);
    	lv3 = (ListView)findViewById(R.id.listSampleBedrock);
    	lv4 = (ListView)findViewById(R.id.listStructure);
    	lv5 = (ListView)findViewById(R.id.listPhoto);
    	
    	adap1 = new MetadataController(this, this);
    	adap2 = new StationBedrockController(this, this);
    	adap3 = new SampleBedrockController(this, this);
    	adap4 = new StructureController(this, this);
    	adap5 = new PhotoController(this, this);
    	
    	setListAdapter(adap1);
    	lv2.setAdapter(adap2);
    	lv3.setAdapter(adap3);
    	lv4.setAdapter(adap4);
    	lv5.setAdapter(adap5);
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
