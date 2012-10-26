package com.nrcan.main;

import com.nrcan.controllers.*;

import android.os.Bundle;
import android.app.ListActivity;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ViewFlipper;

public class MainActivity extends ListActivity {
	
	private ListController adap1;
	private EarthmatBedrockController adap2;
	private ListController adap3;
	private EarthmatSurficialController adap4;
	private ListController adap5;
	private EnvironSurficialController adap6;
	private ListController adap7;
	private MABedrockController adap8;
	private ListController adap9;
	private MetadataController adap10;
	private ListController adap11;
	private MineralBedrockController adap12;
	private ListController adap13;
	private PFlowSurficialController adap14;
	private ListController adap15;
	private PhotoController adap16;
	private ListController adap17;
	private SampleBedrockController adap18;
	private ListController adap19;
	private SampleSurficialController adap20;
	private ListController adap21;
	private SoilProSurficialController adap22;
	private ListController adap23;
	private StationBedrockController adap24;
	private ListController adap25;
	private StationSurficialController adap26;
	private ListController adap27;
	private StructureController adap28;
	
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
    	lv2 = (ListView)findViewById(R.id.listEarthmatBedrock);
    	
    	/*
    	lv2 = (ListView)findViewById(R.id.listStationBedrock);
    	lv3 = (ListView)findViewById(R.id.listSampleBedrock);
    	lv4 = (ListView)findViewById(R.id.listStructure);
    	lv5 = (ListView)findViewById(R.id.listPhoto);
    	*/
    	
    	adap1 = new ListController(this, "EARTH MATERIAL");
    	adap2 = new EarthmatBedrockController(this, this);
    	
    	/*
    	adap2 = new StationBedrockController(this, this);
    	adap3 = new SampleBedrockController(this, this);
    	adap4 = new StructureController(this, this);
    	adap5 = new PhotoController(this, this);
    	*/
    	
    	setListAdapter(adap1);
    	lv2.setAdapter(adap2);
    	
    	/*
    	lv2.setAdapter(adap2);
    	lv3.setAdapter(adap3);
    	lv4.setAdapter(adap4);
    	lv5.setAdapter(adap5);
    	*/
    	
    	//flipper.addView(lv2);

    	Button tab_button_1 = (Button) findViewById(R.id.tab_host_button1);
    	tab_button_1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				setTabs(1);
			}
		});
    	Button tab_button_2 = (Button) findViewById(R.id.tab_host_button2);
    	tab_button_2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				setTabs(2);
			}
		});
    	Button tab_button_3 = (Button) findViewById(R.id.tab_host_button3);
    	tab_button_3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				setTabs(3);
			}
		});
    	Button tab_button_4 = (Button) findViewById(R.id.tab_host_button4);
    	tab_button_4.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				setTabs(4);
			}
		});
    	Button tab_button_5 = (Button) findViewById(R.id.tab_host_button5);
    	tab_button_5.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				setTabs(5);
			}
		});
    	Button tab_button_6 = (Button) findViewById(R.id.tab_host_button6);
    	tab_button_6.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				setTabs(6);
			}
		});
    	Button tab_button_7 = (Button) findViewById(R.id.tab_host_button7);
    	tab_button_7.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				setTabs(7);
			}
		});
    	Button tab_button_8 = (Button) findViewById(R.id.tab_host_button8);
    	tab_button_8.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				setTabs(8);
			}
		});
    }
    
    public void setTabs(int tab) {
		adap2.setTab(tab);
		adap4.setTab(tab);
		//adap6.setTab(tab);
		adap8.setTab(tab);
		adap10.setTab(tab);
		adap12.setTab(tab);
		adap14.setTab(tab);
		adap16.setTab(tab);
		adap18.setTab(tab);
		adap20.setTab(tab);
		adap22.setTab(tab);
		adap24.setTab(tab);
		adap26.setTab(tab);
		adap28.setTab(tab);
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
