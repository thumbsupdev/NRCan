package com.nrcan.main;

import com.nrcan.controllers.MetadataController;
import com.nrcan.controllers.PhotoController;
import com.nrcan.controllers.SampleBedrockController;
import com.nrcan.controllers.StationBedrockController;
import com.nrcan.controllers.StructureController;

import android.os.Bundle;
import android.app.ListActivity;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ViewFlipper;

public class MainActivity extends ListActivity {
	
	private StationBedrockController adap1;
	private StationBedrockController adap2;
	private SampleBedrockController adap3;
	private StructureController adap4;
	private PhotoController adap5;
	
	private ListView lv1;
	private ListView lv2;
	private ListView lv3;
	private ListView lv4;
	private ListView lv5;
	private ListView lv6;
	private ListView lv7;
	private ListView lv8;
	private ListView lv9;
	private ListView lv10;
	private ListView lv11;
	private ListView lv12;
	private ListView lv13;
	private ListView lv14;
	private ListView lv15;
	private ListView lv16;
	private ListView lv17;
	private ListView lv18;
	private ListView lv19;
	private ListView lv20;
	private ListView lv21;
	private ListView lv22;
	private ListView lv23;
	private ListView lv24;
	private ListView lv25;
	private ListView lv26;
	private ListView lv27;
	private ListView lv28;
	
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
        Button button2 = (Button) findViewById(R.id.buttonBack);
    	button2.setOnClickListener(new View.OnClickListener() {
    		public void onClick(View v) {
    			flipper.showPrevious();
    		}
    	});
    	
    	//initializeDatabase();
    	
    	lv1 = getListView();
    	lv2 = (ListView)findViewById(R.id.llMetadata);
    	lv2 = (ListView)findViewById(R.id.listStationBedrock);
    	lv3 = (ListView)findViewById(R.id.listSampleBedrock);
    	lv4 = (ListView)findViewById(R.id.listStructure);
    	lv5 = (ListView)findViewById(R.id.listPhoto);
    	
    	adap1 = new StationBedrockController(this, this);
    	/*
    	adap2 = new StationBedrockController(this, this);
    	adap3 = new SampleBedrockController(this, this);
    	adap4 = new StructureController(this, this);
    	adap5 = new PhotoController(this, this);
    	*/
    	
    	setListAdapter(adap1);
    	/*
    	lv2.setAdapter(adap2);
    	lv3.setAdapter(adap3);
    	lv4.setAdapter(adap4);
    	lv5.setAdapter(adap5);
    	*/
    	
    	//flipper.addView(lv1);
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
