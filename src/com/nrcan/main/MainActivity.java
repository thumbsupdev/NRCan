package com.nrcan.main;

import java.util.ArrayList;

import com.nrcan.controllers.*;
import com.nrcan.models.*;

import android.os.Bundle;
import android.app.ListActivity;
import android.view.Menu;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
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
	private DetailController adap29;
	private DetailController adap30;

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
	private ListView lv29;
	private ListView lv30;

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
			"STRUCTURE",
			"STATION DETAILS",
			"EARTH MATERIAL DETAILS"
	};
	
	private ArrayList<String> details1 = new ArrayList<String>();
	private ArrayList<String> details2 = new ArrayList<String>();

	private BackAction backAction = new BackAction();

	private BackActionInterface[] backActions = new BackActionInterface[] {
			new BackActionInterface() { public void runBack() { backAction.backAction0(); } },
			new BackActionInterface() { public void runBack() { backAction.backAction1(); } },
			new BackActionInterface() { public void runBack() { backAction.backAction2(); } },
			new BackActionInterface() { public void runBack() { backAction.backAction3(); } },
			new BackActionInterface() { public void runBack() { backAction.backAction4(); } },
			new BackActionInterface() { public void runBack() { backAction.backAction5(); } },
			new BackActionInterface() { public void runBack() { backAction.backAction6(); } },
			new BackActionInterface() { public void runBack() { backAction.backAction7(); } },
			new BackActionInterface() { public void runBack() { backAction.backAction8(); } },
			new BackActionInterface() { public void runBack() { backAction.backAction9(); } },
			new BackActionInterface() { public void runBack() { backAction.backAction10(); } },
			new BackActionInterface() { public void runBack() { backAction.backAction11(); } },
			new BackActionInterface() { public void runBack() { backAction.backAction12(); } },
			new BackActionInterface() { public void runBack() { backAction.backAction13(); } },
			new BackActionInterface() { public void runBack() { backAction.backAction14(); } },
			new BackActionInterface() { public void runBack() { backAction.backAction15(); } },
			new BackActionInterface() { public void runBack() { backAction.backAction16(); } },
			new BackActionInterface() { public void runBack() { backAction.backAction17(); } },
			new BackActionInterface() { public void runBack() { backAction.backAction18(); } },
			new BackActionInterface() { public void runBack() { backAction.backAction19(); } },
			new BackActionInterface() { public void runBack() { backAction.backAction20(); } },
			new BackActionInterface() { public void runBack() { backAction.backAction21(); } },
			new BackActionInterface() { public void runBack() { backAction.backAction22(); } },
			new BackActionInterface() { public void runBack() { backAction.backAction23(); } },
			new BackActionInterface() { public void runBack() { backAction.backAction24(); } },
			new BackActionInterface() { public void runBack() { backAction.backAction25(); } },
			new BackActionInterface() { public void runBack() { backAction.backAction26(); } },
			new BackActionInterface() { public void runBack() { backAction.backAction27(); } },
			new BackActionInterface() { public void runBack() { backAction.backAction28(); } },
			new BackActionInterface() { public void runBack() { backAction.backAction29(); } }
	};

	private SaveAction saveAction = new SaveAction();

	private SaveActionInterface[] saveActions = new SaveActionInterface[] {
			new SaveActionInterface() { public void runSave() { saveAction.saveAction0(); } },
			new SaveActionInterface() { public void runSave() { saveAction.saveAction1(); } },
			new SaveActionInterface() { public void runSave() { saveAction.saveAction2(); } },
			new SaveActionInterface() { public void runSave() { saveAction.saveAction3(); } },
			new SaveActionInterface() { public void runSave() { saveAction.saveAction4(); } },
			new SaveActionInterface() { public void runSave() { saveAction.saveAction5(); } },
			new SaveActionInterface() { public void runSave() { saveAction.saveAction6(); } },
			new SaveActionInterface() { public void runSave() { saveAction.saveAction7(); } },
			new SaveActionInterface() { public void runSave() { saveAction.saveAction8(); } },
			new SaveActionInterface() { public void runSave() { saveAction.saveAction9(); } },
			new SaveActionInterface() { public void runSave() { saveAction.saveAction10(); } },
			new SaveActionInterface() { public void runSave() { saveAction.saveAction11(); } },
			new SaveActionInterface() { public void runSave() { saveAction.saveAction12(); } },
			new SaveActionInterface() { public void runSave() { saveAction.saveAction13(); } },
			new SaveActionInterface() { public void runSave() { saveAction.saveAction14(); } },
			new SaveActionInterface() { public void runSave() { saveAction.saveAction15(); } },
			new SaveActionInterface() { public void runSave() { saveAction.saveAction16(); } },
			new SaveActionInterface() { public void runSave() { saveAction.saveAction17(); } },
			new SaveActionInterface() { public void runSave() { saveAction.saveAction18(); } },
			new SaveActionInterface() { public void runSave() { saveAction.saveAction19(); } },
			new SaveActionInterface() { public void runSave() { saveAction.saveAction20(); } },
			new SaveActionInterface() { public void runSave() { saveAction.saveAction21(); } },
			new SaveActionInterface() { public void runSave() { saveAction.saveAction22(); } },
			new SaveActionInterface() { public void runSave() { saveAction.saveAction23(); } },
			new SaveActionInterface() { public void runSave() { saveAction.saveAction24(); } },
			new SaveActionInterface() { public void runSave() { saveAction.saveAction25(); } },
			new SaveActionInterface() { public void runSave() { saveAction.saveAction26(); } },
			new SaveActionInterface() { public void runSave() { saveAction.saveAction27(); } },
			new SaveActionInterface() { public void runSave() { saveAction.saveAction28(); } },
			new SaveActionInterface() { public void runSave() { saveAction.saveAction29(); } }
	};

	private EditAction editAction = new EditAction();

	private EditActionInterface[] editActions = new EditActionInterface[] {
			new EditActionInterface() { public void runEdit() { editAction.editAction0(); } },
			new EditActionInterface() { public void runEdit() { editAction.editAction1(); } },
			new EditActionInterface() { public void runEdit() { editAction.editAction2(); } },
			new EditActionInterface() { public void runEdit() { editAction.editAction3(); } },
			new EditActionInterface() { public void runEdit() { editAction.editAction4(); } },
			new EditActionInterface() { public void runEdit() { editAction.editAction5(); } },
			new EditActionInterface() { public void runEdit() { editAction.editAction6(); } },
			new EditActionInterface() { public void runEdit() { editAction.editAction7(); } },
			new EditActionInterface() { public void runEdit() { editAction.editAction8(); } },
			new EditActionInterface() { public void runEdit() { editAction.editAction9(); } },
			new EditActionInterface() { public void runEdit() { editAction.editAction10(); } },
			new EditActionInterface() { public void runEdit() { editAction.editAction11(); } },
			new EditActionInterface() { public void runEdit() { editAction.editAction12(); } },
			new EditActionInterface() { public void runEdit() { editAction.editAction13(); } },
			new EditActionInterface() { public void runEdit() { editAction.editAction14(); } },
			new EditActionInterface() { public void runEdit() { editAction.editAction15(); } },
			new EditActionInterface() { public void runEdit() { editAction.editAction16(); } },
			new EditActionInterface() { public void runEdit() { editAction.editAction17(); } },
			new EditActionInterface() { public void runEdit() { editAction.editAction18(); } },
			new EditActionInterface() { public void runEdit() { editAction.editAction19(); } },
			new EditActionInterface() { public void runEdit() { editAction.editAction20(); } },
			new EditActionInterface() { public void runEdit() { editAction.editAction21(); } },
			new EditActionInterface() { public void runEdit() { editAction.editAction22(); } },
			new EditActionInterface() { public void runEdit() { editAction.editAction23(); } },
			new EditActionInterface() { public void runEdit() { editAction.editAction24(); } },
			new EditActionInterface() { public void runEdit() { editAction.editAction25(); } },
			new EditActionInterface() { public void runEdit() { editAction.editAction26(); } },
			new EditActionInterface() { public void runEdit() { editAction.editAction27(); } },
			new EditActionInterface() { public void runEdit() { editAction.editAction28(); } },
			new EditActionInterface() { public void runEdit() { editAction.editAction29(); } }
	};

	private CellAction cellAction = new CellAction();

	private CellActionInterface[] cellActions = new CellActionInterface[] {
			new CellActionInterface() { public void runCell() { cellAction.cellAction0(); } },
			new CellActionInterface() { public void runCell() { cellAction.cellAction1(); } },
			new CellActionInterface() { public void runCell() { cellAction.cellAction2(); } },
			new CellActionInterface() { public void runCell() { cellAction.cellAction3(); } },
			new CellActionInterface() { public void runCell() { cellAction.cellAction4(); } },
			new CellActionInterface() { public void runCell() { cellAction.cellAction5(); } },
			new CellActionInterface() { public void runCell() { cellAction.cellAction6(); } },
			new CellActionInterface() { public void runCell() { cellAction.cellAction7(); } },
			new CellActionInterface() { public void runCell() { cellAction.cellAction8(); } },
			new CellActionInterface() { public void runCell() { cellAction.cellAction9(); } },
			new CellActionInterface() { public void runCell() { cellAction.cellAction10(); } },
			new CellActionInterface() { public void runCell() { cellAction.cellAction11(); } },
			new CellActionInterface() { public void runCell() { cellAction.cellAction12(); } },
			new CellActionInterface() { public void runCell() { cellAction.cellAction13(); } },
			new CellActionInterface() { public void runCell() { cellAction.cellAction14(); } },
			new CellActionInterface() { public void runCell() { cellAction.cellAction15(); } },
			new CellActionInterface() { public void runCell() { cellAction.cellAction16(); } },
			new CellActionInterface() { public void runCell() { cellAction.cellAction17(); } },
			new CellActionInterface() { public void runCell() { cellAction.cellAction18(); } },
			new CellActionInterface() { public void runCell() { cellAction.cellAction19(); } },
			new CellActionInterface() { public void runCell() { cellAction.cellAction20(); } },
			new CellActionInterface() { public void runCell() { cellAction.cellAction21(); } },
			new CellActionInterface() { public void runCell() { cellAction.cellAction22(); } },
			new CellActionInterface() { public void runCell() { cellAction.cellAction23(); } },
			new CellActionInterface() { public void runCell() { cellAction.cellAction24(); } },
			new CellActionInterface() { public void runCell() { cellAction.cellAction25(); } },
			new CellActionInterface() { public void runCell() { cellAction.cellAction26(); } },
			new CellActionInterface() { public void runCell() { cellAction.cellAction27(); } },
			new CellActionInterface() { public void runCell() { cellAction.cellAction28(); } },
			new CellActionInterface() { public void runCell() { cellAction.cellAction29(); } }
	};

	private NewAction newAction = new NewAction();

	private NewActionInterface[] newActions = new NewActionInterface[] {
			new NewActionInterface() { public void runNew() { newAction.newAction0(); } },
			new NewActionInterface() { public void runNew() { newAction.newAction1(); } },
			new NewActionInterface() { public void runNew() { newAction.newAction2(); } },
			new NewActionInterface() { public void runNew() { newAction.newAction3(); } },
			new NewActionInterface() { public void runNew() { newAction.newAction4(); } },
			new NewActionInterface() { public void runNew() { newAction.newAction5(); } },
			new NewActionInterface() { public void runNew() { newAction.newAction6(); } },
			new NewActionInterface() { public void runNew() { newAction.newAction7(); } },
			new NewActionInterface() { public void runNew() { newAction.newAction8(); } },
			new NewActionInterface() { public void runNew() { newAction.newAction9(); } },
			new NewActionInterface() { public void runNew() { newAction.newAction10(); } },
			new NewActionInterface() { public void runNew() { newAction.newAction11(); } },
			new NewActionInterface() { public void runNew() { newAction.newAction12(); } },
			new NewActionInterface() { public void runNew() { newAction.newAction13(); } },
			new NewActionInterface() { public void runNew() { newAction.newAction14(); } },
			new NewActionInterface() { public void runNew() { newAction.newAction15(); } },
			new NewActionInterface() { public void runNew() { newAction.newAction16(); } },
			new NewActionInterface() { public void runNew() { newAction.newAction17(); } },
			new NewActionInterface() { public void runNew() { newAction.newAction18(); } },
			new NewActionInterface() { public void runNew() { newAction.newAction19(); } },
			new NewActionInterface() { public void runNew() { newAction.newAction20(); } },
			new NewActionInterface() { public void runNew() { newAction.newAction21(); } },
			new NewActionInterface() { public void runNew() { newAction.newAction22(); } },
			new NewActionInterface() { public void runNew() { newAction.newAction23(); } },
			new NewActionInterface() { public void runNew() { newAction.newAction24(); } },
			new NewActionInterface() { public void runNew() { newAction.newAction25(); } },
			new NewActionInterface() { public void runNew() { newAction.newAction26(); } },
			new NewActionInterface() { public void runNew() { newAction.newAction27(); } },
			new NewActionInterface() { public void runNew() { newAction.newAction28(); } },
			new NewActionInterface() { public void runNew() { newAction.newAction29(); } }
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
				saveActions[flipper.getDisplayedChild()].runSave();
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
				backActions[flipper.getDisplayedChild()].runBack();
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
		lv29 = (ListView)findViewById(R.id.listDetail1);
		lv30 = (ListView)findViewById(R.id.listDetail2);

		adap1 = new ListController(this, this, "EARTH MATERIAL");
		adap2 = new EarthmatBedrockController(this, this);
		adap3 = new ListController(this, this, "EARTH MATERIAL");
		adap4 = new EarthmatSurficialController(this, this);
		adap5 = new ListController(this, this, "ENVIRONMENT");
		adap6 = new EnvironSurficialController(this, this);
		adap7 = new ListController(this, this, "MINERALIZATION / ALTERATION");
		adap8 = new MABedrockController(this, this);
		adap9 = new ListController(this, this, "METADATA");
		adap10 = new MetadataController(this, this, metadataModel);
		adap11 = new ListController(this, this, "MINERAL");
		adap12 = new MineralBedrockController(this, this);
		adap13 = new ListController(this, this, "PALEO FLOW");
		adap14 = new PFlowSurficialController(this, this);
		adap15 = new ListController(this, this, "PHOTO");
		adap16 = new PhotoController(this, this);
		adap17 = new ListController(this, this, "SAMPLE");
		adap18 = new SampleBedrockController(this, this);
		adap19 = new ListController(this, this, "SAMPLE");
		adap20 = new SampleSurficialController(this, this);
		adap21 = new ListController(this, this, "SOIL PROFILE");
		adap22 = new SoilProSurficialController(this, this);
		adap23 = new ListController(this, this, "STATION");
		adap24 = new StationBedrockController(this, this);
		adap25 = new ListController(this, this, "STATION");
		adap26 = new StationSurficialController(this, this);
		adap27 = new ListController(this, this, "STRUCTURE");
		adap28 = new StructureController(this, this);	
		adap29 = new DetailController(this, this, details1);
		adap30  =new DetailController(this, this, details2);

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
		lv29.setAdapter(adap29);
		lv30.setAdapter(adap30);

		setupButtons();
		
		//setupDetailsBedrock();
		//setupDetailsSurficial();
		
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
	
	public void setupDetailsBedrock() {
		details1.add("1-1a");
		details1.add("1-2a");
		details1.add("1-3a");
		
		details2.add("2-1a");
		details2.add("2-2a");
		details2.add("2-3a");
		adap29.notifyDataSetChanged();
		adap30.notifyDataSetChanged();
	}
	
	public void setupDetailsSurficial() {
		details1.add("1-1b");
		details1.add("1-2b");
		details1.add("1-3b");
		
		details2.add("2-1b");
		details2.add("2-2b");
		details2.add("2-3b");
		adap29.notifyDataSetChanged();
		adap30.notifyDataSetChanged();
	}

	public void cellActionControl() {
		cellActions[flipper.getDisplayedChild()].runCell();
	}

	public void editActionControl() {
		editActions[flipper.getDisplayedChild()].runEdit();
	}

	public void newActionControl() {
		newActions[flipper.getDisplayedChild()].runNew();
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

	public void setAnimationBack() {
		flipper.setAnimation(AnimationHelper.inFromLeftAnimation(1));
		flipper.setAnimation(AnimationHelper.outToRightAnimation(1));
	}

	public void setAnimationForward() {
		flipper.setAnimation(AnimationHelper.inFromRightAnimation(1));
		flipper.setAnimation(AnimationHelper.outToLeftAnimation(1));
	}

	public interface BackActionInterface
	{
		public void runBack();
	}

	public interface SaveActionInterface
	{
		public void runSave();
	}

	public interface EditActionInterface
	{
		public void runEdit();
	}

	public interface CellActionInterface
	{
		public void runCell();
	}

	public interface NewActionInterface
	{
		public void runNew();
	}

	public class BackAction {

		public void backAction0() {
			
		}

		public void backAction1() {

		}

		public void backAction2() {

		}

		public void backAction3() {

		}

		public void backAction4() {

		}

		public void backAction5() {

		}

		public void backAction6() {

		}

		public void backAction7() {

		}

		public void backAction8() {

		}

		public void backAction9() {
			
		}

		public void backAction10() {

		}

		public void backAction11() {

		}

		public void backAction12() {

		}

		public void backAction13() {

		}

		public void backAction14() {

		}

		public void backAction15() {

		}

		public void backAction16() {

		}

		public void backAction17() {

		}

		public void backAction18() {

		}

		public void backAction19() {

		}

		public void backAction20() {

		}

		public void backAction21() {

		}

		public void backAction22() {

		}

		public void backAction23() {

		}

		public void backAction24() {

		}

		public void backAction25() {

		}

		public void backAction26() {

		}

		public void backAction27() {

		}

		public void backAction28() {

		}

		public void backAction29() {

		}
	}

	public class CellAction {

		public void cellAction0() {

		}

		public void cellAction1() {

		}

		public void cellAction2() {

		}

		public void cellAction3() {

		}

		public void cellAction4() {

		}

		public void cellAction5() {

		}

		public void cellAction6() {

		}

		public void cellAction7() {

		}

		public void cellAction8() {

		}

		public void cellAction9() {

		}

		public void cellAction10() {

		}

		public void cellAction11() {

		}

		public void cellAction12() {

		}

		public void cellAction13() {

		}

		public void cellAction14() {

		}

		public void cellAction15() {

		}

		public void cellAction16() {

		}

		public void cellAction17() {

		}

		public void cellAction18() {

		}

		public void cellAction19() {

		}

		public void cellAction20() {

		}

		public void cellAction21() {

		}

		public void cellAction22() {

		}

		public void cellAction23() {

		}

		public void cellAction24() {

		}

		public void cellAction25() {

		}

		public void cellAction26() {

		}

		public void cellAction27() {

		}

		public void cellAction28() {

		}

		public void cellAction29() {

		}
	}

	public class EditAction {

		public void editAction0() {

		}

		public void editAction1() {

		}

		public void editAction2() {

		}

		public void editAction3() {

		}

		public void editAction4() {

		}

		public void editAction5() {

		}

		public void editAction6() {

		}

		public void editAction7() {

		}

		public void editAction8() {

		}

		public void editAction9() {

		}

		public void editAction10() {

		}

		public void editAction11() {

		}

		public void editAction12() {

		}

		public void editAction13() {

		}

		public void editAction14() {

		}

		public void editAction15() {

		}

		public void editAction16() {

		}

		public void editAction17() {

		}

		public void editAction18() {

		}

		public void editAction19() {

		}

		public void editAction20() {

		}

		public void editAction21() {

		}

		public void editAction22() {

		}

		public void editAction23() {

		}

		public void editAction24() {

		}

		public void editAction25() {

		}

		public void editAction26() {

		}

		public void editAction27() {

		}

		public void editAction28() {

		}

		public void editAction29() {

		}
	}

	public class NewAction {

		public void newAction0() {

		}

		public void newAction1() {

		}

		public void newAction2() {

		}

		public void newAction3() {

		}

		public void newAction4() {

		}

		public void newAction5() {

		}

		public void newAction6() {

		}

		public void newAction7() {

		}

		public void newAction8() {

		}

		public void newAction9() {

		}

		public void newAction10() {

		}

		public void newAction11() {

		}

		public void newAction12() {

		}

		public void newAction13() {

		}

		public void newAction14() {

		}

		public void newAction15() {

		}

		public void newAction16() {

		}

		public void newAction17() {

		}

		public void newAction18() {

		}

		public void newAction19() {

		}

		public void newAction20() {

		}

		public void newAction21() {

		}

		public void newAction22() {

		}

		public void newAction23() {

		}

		public void newAction24() {

		}

		public void newAction25() {

		}

		public void newAction26() {

		}

		public void newAction27() {

		}

		public void newAction28() {

		}

		public void newAction29() {

		}
	}

	public class SaveAction {

		public void saveAction0() {

		}

		public void saveAction1() {

		}

		public void saveAction2() {

		}

		public void saveAction3() {

		}

		public void saveAction4() {

		}

		public void saveAction5() {

		}

		public void saveAction6() {

		}

		public void saveAction7() {

		}

		public void saveAction8() {

		}

		public void saveAction9() {

		}

		public void saveAction10() {

		}

		public void saveAction11() {

		}

		public void saveAction12() {

		}

		public void saveAction13() {

		}

		public void saveAction14() {

		}

		public void saveAction15() {

		}

		public void saveAction16() {

		}

		public void saveAction17() {

		}

		public void saveAction18() {

		}

		public void saveAction19() {

		}

		public void saveAction20() {

		}

		public void saveAction21() {

		}

		public void saveAction22() {

		}

		public void saveAction23() {

		}

		public void saveAction24() {

		}

		public void saveAction25() {

		}

		public void saveAction26() {

		}

		public void saveAction27() {

		}

		public void saveAction28() {

		}

		public void saveAction29() {

		}
	}


	/*
    public ArrayList<String> readRows() {
        dbHandler.executeQuery(PreparedStatements.READ_ALL_ROWS, new String [] { METADATA_TABLE_NAME });

        return dbHandler.getList();
    }
	 //************************************************************************************
	 * 
	 * ANIMATION HELPER CLASS
	 *
	 ************************************************************************************/

	 public static class AnimationHelper {
		 private static int dur = 200;

		 public void setDuration (int duration) {
			 dur = duration;
		 }

		 public static Animation inFromRightAnimation(float param) {
			 Animation inFromRight = new TranslateAnimation(
					 Animation.RELATIVE_TO_PARENT, param,
					 Animation.RELATIVE_TO_PARENT, 0.0f,
					 Animation.RELATIVE_TO_PARENT, 0.0f,
					 Animation.RELATIVE_TO_PARENT, 0.0f);
			 inFromRight.setDuration(dur);
			 inFromRight.setInterpolator(new AccelerateInterpolator());
			 return inFromRight;
		 }

		 public static Animation outToLeftAnimation(float param) {
			 Animation outtoLeft = new TranslateAnimation(
					 Animation.RELATIVE_TO_PARENT, 0.0f,
					 Animation.RELATIVE_TO_PARENT, -param,
					 Animation.RELATIVE_TO_PARENT, 0.0f,
					 Animation.RELATIVE_TO_PARENT, 0.0f);
			 outtoLeft.setDuration(dur);
			 outtoLeft.setInterpolator(new AccelerateInterpolator());
			 return outtoLeft;
		 }

		 public static Animation inFromLeftAnimation(float param) {
			 Animation inFromLeft = new TranslateAnimation(
					 Animation.RELATIVE_TO_PARENT, -param,
					 Animation.RELATIVE_TO_PARENT, 0.0f,
					 Animation.RELATIVE_TO_PARENT, 0.0f,
					 Animation.RELATIVE_TO_PARENT, 0.0f);
			 inFromLeft.setDuration(dur);
			 inFromLeft.setInterpolator(new AccelerateInterpolator());
			 return inFromLeft;
		 }

		 public static Animation outToRightAnimation(float param) {
			 Animation outtoRight = new TranslateAnimation(
					 Animation.RELATIVE_TO_PARENT, 0.0f,
					 Animation.RELATIVE_TO_PARENT, +param,
					 Animation.RELATIVE_TO_PARENT, 0.0f,
					 Animation.RELATIVE_TO_PARENT, 0.0f);
			 outtoRight.setDuration(dur);
			 outtoRight.setInterpolator(new AccelerateInterpolator());
			 return outtoRight;
		 }
	 }

}
