package com.nrcan.main;

import java.util.ArrayList;

import com.nrcan.controllers.*;
import com.nrcan.models.*;

import android.os.Bundle;
import android.app.ListActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class MainActivity extends ListActivity {
	
    private DatabaseHandler databaseHandler;
	private ViewFlipper flipper;

	private MetadataModel metadataModel;
	
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
	
	//private ListView lv1;
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
	
	private TextView mainTitle;
	private String[] titles = {
			"EARTH MATERIAL BEDROCK",
			"EARTH MATERIAL BEDROCK",
			"EARTH MATERIAL SURFICIAL",
			"EARTH MATERIAL SURFICIAL",
			"ENVIRONMENT SURFICIAL",
			"ENVIRONMENT SURFICIAL",
			"M / A BEDROCK",
			"M / A BEDROCK",
			"METADATA",
			"METADATA",
			"MINERAL BEDROCK",
			"MINERAL BEDROCK",
			"PALEO FLOW SURFICIAL",
			"PALEO FLOW SURFICIAL",
			"PHOTO",
			"PHOTO",
			"SAMPLE BEDROCK",
			"SAMPLE BEDROCK",
			"SAMPLE SURFICIAL",
			"SAMPLE SURFICIAL",
			"SOIL PROFILE",
			"SOIL PROFILE",
			"STATION BEDROCK",
			"STATION BEDROCK",
			"STATION SURFICIAL",
			"STATION SURFICIAL",
			"STRUCTURE",
			"STRUCTURE"
	};
	
	private Flow f = new Flow();
	
	private Dataflow[] positions = new Dataflow[] {
		new Dataflow() { public void run() { f.runPosition0(); } },
		new Dataflow() { public void run() { f.runPosition1(); } },
		new Dataflow() { public void run() { f.runPosition2(); } },
		new Dataflow() { public void run() { f.runPosition3(); } },
		new Dataflow() { public void run() { f.runPosition4(); } },
		new Dataflow() { public void run() { f.runPosition5(); } },
		new Dataflow() { public void run() { f.runPosition6(); } },
		new Dataflow() { public void run() { f.runPosition7(); } },
		new Dataflow() { public void run() { f.runPosition8(); } },
		new Dataflow() { public void run() { f.runPosition9(); } },
		new Dataflow() { public void run() { f.runPosition10(); } },
		new Dataflow() { public void run() { f.runPosition11(); } },
		new Dataflow() { public void run() { f.runPosition12(); } },
		new Dataflow() { public void run() { f.runPosition13(); } },
		new Dataflow() { public void run() { f.runPosition14(); } },
		new Dataflow() { public void run() { f.runPosition15(); } },
		new Dataflow() { public void run() { f.runPosition16(); } },
		new Dataflow() { public void run() { f.runPosition17(); } },
		new Dataflow() { public void run() { f.runPosition18(); } },
		new Dataflow() { public void run() { f.runPosition19(); } },
		new Dataflow() { public void run() { f.runPosition20(); } },
		new Dataflow() { public void run() { f.runPosition21(); } },
		new Dataflow() { public void run() { f.runPosition22(); } },
		new Dataflow() { public void run() { f.runPosition23(); } },
		new Dataflow() { public void run() { f.runPosition24(); } },
		new Dataflow() { public void run() { f.runPosition25(); } },
		new Dataflow() { public void run() { f.runPosition26(); } },
		new Dataflow() { public void run() { f.runPosition27(); } }
	};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        databaseHandler = new DatabaseHandler(this);
        
        metadataModel = new MetadataModel(databaseHandler);
        
        mainTitle = (TextView) findViewById(R.id.textViewMainTitle);
        mainTitle.setText(titles[0].toString());
        
        flipper = (ViewFlipper) findViewById(R.id.viewFlipper1);
        
        Button button1 = (Button) findViewById(R.id.buttonSave);
    	button1.setOnClickListener(new View.OnClickListener() {
    		public void onClick(View v) {
    			//adap10.save();
                //adap10.insertMetadataInfo();
    			//metadataModel.insertRow();
    			flipper.showNext();
    	        mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
				//setTabs(1);
    		}
    	});
        Button button2 = (Button) findViewById(R.id.buttonBack);
    	button2.setOnClickListener(new View.OnClickListener() {
    		public void onClick(View v) {
    			//adap10.tUpdate();
    			//metadataModel.deleteRow();
    			flipper.showPrevious();
    	        mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
				//setTabs(1);
    		}
    	});
    	
    	getListView(); //lv1 = getListView();
    	lv2 = (ListView)findViewById(R.id.listEarthmatBedrock);
    	lv3 = (ListView)findViewById(R.id.listEarthmatSurficial2);
    	lv4 = (ListView)findViewById(R.id.listEarthmatSurficial);
    	lv5 = (ListView)findViewById(R.id.listEnvironSurficial2);
    	lv6 = (ListView)findViewById(R.id.listEnvironSurficial);
    	lv7 = (ListView)findViewById(R.id.listMABedrock2);
    	lv8 = (ListView)findViewById(R.id.listMABedrock);
    	lv9 = (ListView)findViewById(R.id.listMetadata2);
    	lv10 = (ListView)findViewById(R.id.listMetadata);
    	lv11 = (ListView)findViewById(R.id.listMineralBedrock2);
    	lv12 = (ListView)findViewById(R.id.listMineralBedrock);
    	lv13 = (ListView)findViewById(R.id.listPFlowSurficial2);
    	lv14 = (ListView)findViewById(R.id.listPFlowSurficial);
    	lv15 = (ListView)findViewById(R.id.listPhoto2);
    	lv16 = (ListView)findViewById(R.id.listPhoto);
    	lv17 = (ListView)findViewById(R.id.listSampleBedrock2);
    	lv18 = (ListView)findViewById(R.id.listSampleBedrock);
    	lv19 = (ListView)findViewById(R.id.listSampleSurficial2);
    	lv20 = (ListView)findViewById(R.id.listSampleSurficial);
    	lv21 = (ListView)findViewById(R.id.listSoilProSurficial2);
    	lv22 = (ListView)findViewById(R.id.listSoilProSurficial);
    	lv23 = (ListView)findViewById(R.id.listStationBedrock2);
    	lv24 = (ListView)findViewById(R.id.listStationBedrock);
    	lv25 = (ListView)findViewById(R.id.listStationSurficial2);
    	lv26 = (ListView)findViewById(R.id.listStationSurficial);
    	lv27 = (ListView)findViewById(R.id.listStructure2);
    	lv28 = (ListView)findViewById(R.id.listStructure);
    	
    	adap1 = new ListController(this, "EARTH MATERIAL");
    	adap2 = new EarthmatBedrockController(this, this);
    	adap3 = new ListController(this, "EARTH MATERIAL");
    	adap4 = new EarthmatSurficialController(this, this);
    	adap5 = new ListController(this, "ENVIRONMENT");
    	adap6 = new EnvironSurficialController(this, this);
    	adap7 = new ListController(this, "MINERALIZATION / ALTERATION");
    	adap8 = new MABedrockController(this, this);
    	adap9 = new ListController(this, "METADATA");
    	adap10 = new MetadataController(this, this, metadataModel);
    	adap11 = new ListController(this, "MINERAL");
    	adap12 = new MineralBedrockController(this, this);
    	adap13 = new ListController(this, "PALEO FLOW");
    	adap14 = new PFlowSurficialController(this, this);
    	adap15 = new ListController(this, "PHOTO");
    	adap16 = new PhotoController(this, this);
    	adap17 = new ListController(this, "SAMPLE");
    	adap18 = new SampleBedrockController(this, this);
    	adap19 = new ListController(this, "SAMPLE");
    	adap20 = new SampleSurficialController(this, this);
    	adap21 = new ListController(this, "SOIL PROFILE");
    	adap22 = new SoilProSurficialController(this, this);
    	adap23 = new ListController(this, "STATION");
    	adap24 = new StationBedrockController(this, this);
    	adap25 = new ListController(this, "STATION");
    	adap26 = new StationSurficialController(this, this);
    	adap27 = new ListController(this, "STRUCTURE");
    	adap28 = new StructureController(this, this);
    	
    	setListAdapter(adap1);
    	lv2.setAdapter(adap2);
    	lv3.setAdapter(adap3);
    	lv4.setAdapter(adap4);
    	lv5.setAdapter(adap5);
    	lv6.setAdapter(adap6);
    	lv7.setAdapter(adap7);
    	lv8.setAdapter(adap8);
    	lv9.setAdapter(adap9);
    	lv10.setAdapter(adap10);
    	lv11.setAdapter(adap11);
    	lv12.setAdapter(adap12);
    	lv13.setAdapter(adap13);
    	lv14.setAdapter(adap14);
    	lv15.setAdapter(adap15);
    	lv16.setAdapter(adap16);
    	lv17.setAdapter(adap17);
    	lv18.setAdapter(adap18);
    	lv19.setAdapter(adap19);
    	lv20.setAdapter(adap20);
    	lv21.setAdapter(adap21);
    	lv22.setAdapter(adap22);
    	lv23.setAdapter(adap23);
    	lv24.setAdapter(adap24);
    	lv25.setAdapter(adap25);
    	lv26.setAdapter(adap26);
    	lv27.setAdapter(adap27);
    	lv28.setAdapter(adap28);
    	
    	setupButtons();
    	/*
    	flipper.setDisplayedChild(8);
    	
    	ArrayList<String> tt = new ArrayList<String>();
    	tt.add("Data 1");
    	tt.add("Data 2");
    	tt.add("Data 3");
    	tt.add("Data 4");
    	
    	adap9.setElements(tt);
    	*/
    }
    
    public void setTabs(int tab) {
		adap2.setTab(tab);
		adap4.setTab(tab);
		adap6.setTab(tab);
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
    
    public void setupButtons() {
    	setupButtonsEarthmatBedrock();
    	setupButtonsEarthmatSurficial();
    	setupButtonsEnvironSurficial();
        setupButtonsMABedrock();
    	setupButtonsMetadata();
    	setupButtonsMineralBedrock();
    	setupButtonsPFlowSurficial();
    	setupButtonsPhoto();
    	setupButtonsSampleBedrock();
    	setupButtonsSampleSurficial();
    	setupButtonsSoilProSurficial();
    	setupButtonsStationBedrock();
    	setupButtonsStationSurficial();
    	setupButtonsStructure();
    }
    
    public void setupButtonsEarthmatBedrock() {

    	Button tab_button_1 = (Button) findViewById(R.id.tab_host_1_button1);
    	tab_button_1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap2.setTab(1);
			}
		});
    	Button tab_button_2 = (Button) findViewById(R.id.tab_host_1_button2);
    	tab_button_2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap2.setTab(2);
			}
		});
    	Button tab_button_3 = (Button) findViewById(R.id.tab_host_1_button3);
    	tab_button_3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap2.setTab(3);
			}
		});
    	Button tab_button_4 = (Button) findViewById(R.id.tab_host_1_button4);
    	tab_button_4.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap2.setTab(4);
			}
		});
    	Button tab_button_5 = (Button) findViewById(R.id.tab_host_1_button5);
    	tab_button_5.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap2.setTab(5);
			}
		});
    	Button tab_button_6 = (Button) findViewById(R.id.tab_host_1_button6);
    	tab_button_6.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap2.setTab(6);
			}
		});
    	Button tab_button_7 = (Button) findViewById(R.id.tab_host_1_button7);
    	tab_button_7.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap2.setTab(7);
			}
		});
    	Button tab_button_8 = (Button) findViewById(R.id.tab_host_1_button8);
    	tab_button_8.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap2.setTab(8);
			}
		});
    }
    
    public void setupButtonsEarthmatSurficial() {
    	Button tab_button_1 = (Button) findViewById(R.id.tab_host_2_button1);
    	tab_button_1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap4.setTab(1);
			}
		});
    	Button tab_button_2 = (Button) findViewById(R.id.tab_host_2_button2);
    	tab_button_2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap4.setTab(2);
			}
		});
    	Button tab_button_3 = (Button) findViewById(R.id.tab_host_2_button3);
    	tab_button_3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap4.setTab(3);
			}
		});
    	Button tab_button_4 = (Button) findViewById(R.id.tab_host_2_button4);
    	tab_button_4.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap4.setTab(4);
			}
		});
    	Button tab_button_5 = (Button) findViewById(R.id.tab_host_2_button5);
    	tab_button_5.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap4.setTab(5);
			}
		});
    	Button tab_button_6 = (Button) findViewById(R.id.tab_host_2_button6);
    	tab_button_6.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap4.setTab(6);
			}
		});
    	Button tab_button_7 = (Button) findViewById(R.id.tab_host_2_button7);
    	tab_button_7.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap4.setTab(7);
			}
		});
    }
    public void setupButtonsEnvironSurficial() {
    	Button tab_button_1 = (Button) findViewById(R.id.tab_host_3_button1);
    	tab_button_1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap6.setTab(1);
			}
		});
    	Button tab_button_2 = (Button) findViewById(R.id.tab_host_3_button2);
    	tab_button_2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap6.setTab(2);
			}
		});
    	Button tab_button_3 = (Button) findViewById(R.id.tab_host_3_button3);
    	tab_button_3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap6.setTab(3);
			}
		});
    	Button tab_button_4 = (Button) findViewById(R.id.tab_host_3_button4);
    	tab_button_4.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap6.setTab(4);
			}
		});
    	Button tab_button_5 = (Button) findViewById(R.id.tab_host_3_button5);
    	tab_button_5.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap6.setTab(5);
			}
		});
    }
    public void setupButtonsMABedrock() {
    	Button tab_button_1 = (Button) findViewById(R.id.tab_host_4_button1);
    	tab_button_1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap8.setTab(1);
			}
		});
    	Button tab_button_2 = (Button) findViewById(R.id.tab_host_4_button2);
    	tab_button_2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap8.setTab(2);
			}
		});
    }
    public void setupButtonsMetadata() {
    	Button tab_button_1 = (Button) findViewById(R.id.tab_host_5_button1);
    	tab_button_1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap10.setTab(1);
			}
		});
    	Button tab_button_2 = (Button) findViewById(R.id.tab_host_5_button2);
    	tab_button_2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap10.setTab(2);
			}
		});
    }
    public void setupButtonsMineralBedrock() {
    	Button tab_button_1 = (Button) findViewById(R.id.tab_host_6_button1);
    	tab_button_1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap12.setTab(1);
			}
		});
    	Button tab_button_2 = (Button) findViewById(R.id.tab_host_6_button2);
    	tab_button_2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap12.setTab(2);
			}
		});
    	Button tab_button_3 = (Button) findViewById(R.id.tab_host_6_button3);
    	tab_button_3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap12.setTab(3);
			}
		});
    	Button tab_button_4 = (Button) findViewById(R.id.tab_host_6_button4);
    	tab_button_4.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap12.setTab(4);
			}
		});
    }
    public void setupButtonsPFlowSurficial() {
    	Button tab_button_1 = (Button) findViewById(R.id.tab_host_7_button1);
    	tab_button_1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap14.setTab(1);
			}
		});
    	Button tab_button_2 = (Button) findViewById(R.id.tab_host_7_button2);
    	tab_button_2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap14.setTab(2);
			}
		});
    	Button tab_button_3 = (Button) findViewById(R.id.tab_host_7_button3);
    	tab_button_3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap14.setTab(3);
			}
		});
    }
    public void setupButtonsPhoto() {
    	Button tab_button_1 = (Button) findViewById(R.id.tab_host_8_button1);
    	tab_button_1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap16.setTab(1);
			}
		});
    	Button tab_button_2 = (Button) findViewById(R.id.tab_host_8_button2);
    	tab_button_2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap16.setTab(2);
			}
		});
    }
    public void setupButtonsSampleBedrock() {
    	Button tab_button_1 = (Button) findViewById(R.id.tab_host_9_button1);
    	tab_button_1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap18.setTab(1);
			}
		});
    	Button tab_button_2 = (Button) findViewById(R.id.tab_host_9_button2);
    	tab_button_2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap18.setTab(2);
			}
		});
    	Button tab_button_3 = (Button) findViewById(R.id.tab_host_9_button3);
    	tab_button_3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap18.setTab(3);
			}
		});
    }
    public void setupButtonsSampleSurficial() {
    	Button tab_button_1 = (Button) findViewById(R.id.tab_host_10_button1);
    	tab_button_1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap20.setTab(1);
			}
		});
    	Button tab_button_2 = (Button) findViewById(R.id.tab_host_10_button2);
    	tab_button_2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap20.setTab(2);
			}
		});
    	Button tab_button_3 = (Button) findViewById(R.id.tab_host_10_button3);
    	tab_button_3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap20.setTab(3);
			}
		});
    }
    public void setupButtonsSoilProSurficial() {
    	Button tab_button_1 = (Button) findViewById(R.id.tab_host_11_button1);
    	tab_button_1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap22.setTab(1);
			}
		});
    	Button tab_button_2 = (Button) findViewById(R.id.tab_host_11_button2);
    	tab_button_2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap22.setTab(2);
			}
		});
    }
    public void setupButtonsStationBedrock() {
    	Button tab_button_1 = (Button) findViewById(R.id.tab_host_12_button1);
    	tab_button_1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap24.setTab(1);
			}
		});
    	Button tab_button_2 = (Button) findViewById(R.id.tab_host_12_button2);
    	tab_button_2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap24.setTab(2);
			}
		});
    	Button tab_button_3 = (Button) findViewById(R.id.tab_host_12_button3);
    	tab_button_3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap24.setTab(3);
			}
		});
    	Button tab_button_4 = (Button) findViewById(R.id.tab_host_12_button4);
    	tab_button_4.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap24.setTab(4);
			}
		});
    }
    public void setupButtonsStationSurficial() {
    	Button tab_button_1 = (Button) findViewById(R.id.tab_host_13_button1);
    	tab_button_1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap26.setTab(1);
			}
		});
    	Button tab_button_2 = (Button) findViewById(R.id.tab_host_13_button2);
    	tab_button_2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap26.setTab(2);
			}
		});
    	Button tab_button_3 = (Button) findViewById(R.id.tab_host_13_button3);
    	tab_button_3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap26.setTab(3);
			}
		});
    	Button tab_button_4 = (Button) findViewById(R.id.tab_host_13_button4);
    	tab_button_4.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap26.setTab(4);
			}
		});
    }
    public void setupButtonsStructure() {
    	Button tab_button_1 = (Button) findViewById(R.id.tab_host_14_button1);
    	tab_button_1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap28.setTab(1);
			}
		});
    	Button tab_button_2 = (Button) findViewById(R.id.tab_host_14_button2);
    	tab_button_2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap28.setTab(2);
			}
		});
    	Button tab_button_3 = (Button) findViewById(R.id.tab_host_14_button3);
    	tab_button_3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap28.setTab(3);
			}
		});
    	Button tab_button_4 = (Button) findViewById(R.id.tab_host_14_button4);
    	tab_button_4.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap28.setTab(4);
			}
		});
    	Button tab_button_5 = (Button) findViewById(R.id.tab_host_14_button5);
    	tab_button_5.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				adap28.setTab(5);
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public interface Dataflow
    {
    	public void run();
    }
    
    class Flow
    {
		public void runPosition0() {
			
		}
		
		public void runPosition1() {
			
		}
		
		public void runPosition2() {
			
		}
		
		public void runPosition3() {
			
		}
		
		public void runPosition4() {
			
		}
		
		public void runPosition5() {
			
		}
		
		public void runPosition6() {
			
		}
		
		public void runPosition7() {
			
		}
		
		public void runPosition8() {
			
		}
		
		public void runPosition9() {
			
		}
		
		public void runPosition10() {
			
		}
		
		public void runPosition11() {
			
		}
		
		public void runPosition12() {
			
		}
		
		public void runPosition13() {
			
		}
		
		public void runPosition14() {
			
		}
		
		public void runPosition15() {
			
		}
		
		public void runPosition16() {
			
		}
		
		public void runPosition17() {
			
		}
		
		public void runPosition18() {
			
		}
		
		public void runPosition19() {
			
		}
		
		public void runPosition20() {
			
		}
		
		public void runPosition21() {
			
		}
		
		public void runPosition22() {
			
		}
		
		public void runPosition23() {
			
		}
		
		public void runPosition24() {
			
		}
		
		public void runPosition25() {
			
		}
		
		public void runPosition26() {
			
		}
		
		public void runPosition27() {
			
		}
    }

    /*
    public ArrayList<String> readRows() {
        dbHandler.executeQuery(PreparedStatements.READ_ALL_ROWS, new String [] { METADATA_TABLE_NAME });

        return dbHandler.getList();
    }
    */
    
}
