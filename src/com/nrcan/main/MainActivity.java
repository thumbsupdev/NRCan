package com.nrcan.main;

import java.util.ArrayList;
import java.util.HashMap;

import com.nrcan.controllers.*;
import com.nrcan.models.*;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class MainActivity extends ListActivity {
	private static Button swapButton;
	private Context context;

	private static HashMap<String, Integer> bedrockFileNames = new HashMap<String, Integer>();
	private static HashMap<String, Integer> surficialFileNames = new HashMap<String, Integer>();
	public static ArrayList<Option> dir = new ArrayList<Option>();

	private ProgressThread progThread;
	private ProgressDialog progDialog;
	int typeBar = 0;

	private boolean selectionFlag;
	private boolean newFlag;
	private int nrCanId1;
	private int nrCanId2;
	private int nrCanId3;
	private int nrCanId4;

	private int detail;

	private PicklistDatabaseHandler pldb;
	private DatabaseHandler databaseHandler;
	private ViewFlipper flipper;
	private Button button1;
	private Button button2;

	private MetadataModel metadataModel;
	private EnvironSurficialModel environSurficialModel;
	private SoilProSurficialModel soilProSurficialModel;
	private PhotoModel photoModel;
	private StationBedrockModel stationBedrockModel;
	private StationSurficialModel stationSurficialModel;
	private EarthmatBedrockModel earthmatBedrockModel;
	private MineralBedrockModel mineralBedrockModel;
	private EarthmatSurficialModel earthmatSurficialModel;
	private SampleBedrockModel sampleBedrockModel;
	private SampleSurficialModel sampleSurficialModel;
	private StructureModel structureModel;
	private MABedrockModel mABedrockModel;
	private PFlowSurficialModel pFlowSurficialModel;

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
	private TextView topTitle;

	private String[] titles = {
			"EARTH MATERIAL BEDROCK",
			"EARTH MATERIAL BEDROCK",
			"EARTH MATERIAL SURFICIAL",
			"EARTH MATERIAL SURFICIAL",
			"ENVIRONMENT SURFICIAL",
			"ENVIRONMENT SURFICIAL",
			"M / A BEDROCK",
			"M / A BEDROCK",
			"PROJECTS",
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
		pldb = new PicklistDatabaseHandler(this);

		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
		
		setupMaps();

		earthmatBedrockModel = new EarthmatBedrockModel(databaseHandler);
		earthmatSurficialModel = new EarthmatSurficialModel(databaseHandler);
		environSurficialModel = new EnvironSurficialModel(databaseHandler);
		mABedrockModel = new MABedrockModel(databaseHandler);
		metadataModel = new MetadataModel(databaseHandler);
		mineralBedrockModel = new MineralBedrockModel(databaseHandler);
		pFlowSurficialModel = new PFlowSurficialModel(databaseHandler);
		photoModel = new PhotoModel(databaseHandler);
		sampleBedrockModel = new SampleBedrockModel(databaseHandler);
		sampleSurficialModel = new SampleSurficialModel(databaseHandler);
		soilProSurficialModel = new SoilProSurficialModel(databaseHandler);
		stationBedrockModel = new StationBedrockModel(databaseHandler);
		stationSurficialModel = new StationSurficialModel(databaseHandler);
		structureModel = new StructureModel(databaseHandler);

		topTitle = (TextView) findViewById(R.id.textViewMainID);
		mainTitle = (TextView) findViewById(R.id.textViewMainTitle);

		flipper = (ViewFlipper) findViewById(R.id.viewFlipper1);

		button1 = (Button) findViewById(R.id.buttonSave);
		button1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				//saveActions[flipper.getDisplayedChild()].runSave();
				//adap10.save();
				//adap10.insertMetadataInfo();
				//metadataModel.insertRow();
				flipper.showNext();
				mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
				//setTabs(1);
			}
		});
		button2 = (Button) findViewById(R.id.buttonBack);
		button2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				//backActions[flipper.getDisplayedChild()].runBack();
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
		adap2 = new EarthmatBedrockController(this, this, earthmatBedrockModel.getEntity(), pldb);
		adap3 = new ListController(this, this, "EARTH MATERIAL");
		adap4 = new EarthmatSurficialController(this, this,earthmatSurficialModel.getEntity(), pldb);
		adap5 = new ListController(this, this, "ENVIRONMENT");
		adap6 = new EnvironSurficialController(this, this,environSurficialModel.getEntity(), pldb);
		adap7 = new ListController(this, this, "MINERALIZATION / ALTERATION");
		adap8 = new MABedrockController(this, this,mABedrockModel.getEntity(), pldb);
		adap9 = new ListController(this, this, "METADATA");
		adap10 = new MetadataController(this, this, metadataModel.getEntity(), pldb);
		adap11 = new ListController(this, this, "MINERAL");
		adap12 = new MineralBedrockController(this, this,mineralBedrockModel.getEntity(), pldb);
		adap13 = new ListController(this, this, "PALEO FLOW");
		adap14 = new PFlowSurficialController(this, this,pFlowSurficialModel.getEntity(), pldb);
		adap15 = new ListController(this, this, "PHOTO");
		adap16 = new PhotoController(this, this,photoModel.getEntity(), pldb);
		adap17 = new ListController(this, this, "SAMPLE");
		adap18 = new SampleBedrockController(this, this,sampleBedrockModel.getEntity(), pldb);
		adap19 = new ListController(this, this, "SAMPLE");
		adap20 = new SampleSurficialController(this, this,sampleSurficialModel.getEntity(), pldb);
		adap21 = new ListController(this, this, "SOIL PROFILE");
		adap22 = new SoilProSurficialController(this, this,soilProSurficialModel, pldb);
		adap23 = new ListController(this, this, "STATION");
		adap24 = new StationBedrockController(this, this,stationBedrockModel.getEntity(), pldb);
		adap25 = new ListController(this, this, "STATION");
		adap26 = new StationSurficialController(this, this,stationSurficialModel.getEntity(), pldb);
		adap27 = new ListController(this, this, "STRUCTURE");
		adap28 = new StructureController(this, this,structureModel.getEntity(), pldb);
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

		flipper.setDisplayedChild(6);
		//button2.setVisibility(View.INVISIBLE);
		//button1.setVisibility(View.INVISIBLE);
		mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
		selectionFlag = false;
		newFlag = false;
		nrCanId1 = 0;
		nrCanId2 = 0;
		nrCanId3 = 0;
		nrCanId4 = 0;

		swapButton = (Button)findViewById(R.id.tab_host_5_button1);
		swapButton.setEnabled(false);

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

	public PicklistDatabaseHandler getPLDB() {
		return this.pldb;
	}

	public void setupDetailsBedrock() {
		details1.clear();
		details2.clear();
		details1.add("EARTH MATERIALS");
		details1.add("MINERALIZATION / ALTERATION");
		details1.add("PHOTO");

		details2.add("SAMPLE");
		details2.add("STRUTURE");
		details2.add("MINERAL");
		adap29.notifyDataSetChanged();
		adap30.notifyDataSetChanged();
	}

	public void setupDetailsSurficial() {
		details1.clear();
		details2.clear();
		details1.add("EARTH MATERIALS");
		details1.add("ENVIRONMENT");
		details1.add("SOIL PROFILE");
		details1.add("PHOTO");

		details2.add("SAMPLE");
		details2.add("STRUCTURE");
		details2.add("PALEO FLOW");

		adap29.notifyDataSetChanged();
		adap30.notifyDataSetChanged();
	}

	public void setupMaps() {
		bedrockFileNames.put("lutBEDEarthmatBedthick.txt", Integer.valueOf(1));
		bedrockFileNames.put("lutBEDEarthmatColour.txt", Integer.valueOf(1));
		bedrockFileNames.put("lutBEDEarthmatComposition.txt", Integer.valueOf(2));
		bedrockFileNames.put("lutBEDEarthmatContact.txt", Integer.valueOf(1));
		bedrockFileNames.put("lutBEDEarthmatDeffabric.txt", Integer.valueOf(1));
		bedrockFileNames.put("lutBEDEarthmatFossil.txt", Integer.valueOf(1));
		bedrockFileNames.put("lutBEDEarthmatGCSize.txt", Integer.valueOf(2));
		bedrockFileNames.put("lutBEDEarthmatInterpconf.txt", Integer.valueOf(1));
		bedrockFileNames.put("lutBEDEarthmatMapunit.txt", Integer.valueOf(1));
		bedrockFileNames.put("lutBEDEarthmatMineral.txt", Integer.valueOf(1));
		bedrockFileNames.put("lutBEDEarthmatOccurs.txt", Integer.valueOf(2));
		bedrockFileNames.put("lutBEDEarthmatRocktype.txt", Integer.valueOf(3));
		bedrockFileNames.put("lutBEDEarthmatStructural.txt", Integer.valueOf(2));
		bedrockFileNames.put("lutBEDEarthmatTextural.txt", Integer.valueOf(2));
		bedrockFileNames.put("lutBEDGeneralPercent5incr.txt", Integer.valueOf(1));
		bedrockFileNames.put("lutBEDGeneralStrucFormat.txt", Integer.valueOf(1));
		bedrockFileNames.put("lutBEDGeneralStrucMethod.txt", Integer.valueOf(1));
		bedrockFileNames.put("lutBEDMADistribute.txt", Integer.valueOf(2));
		bedrockFileNames.put("lutBEDMAMineralogy.txt", Integer.valueOf(2));
		bedrockFileNames.put("lutBEDMAUnit.txt", Integer.valueOf(1));
		bedrockFileNames.put("lutMetadataDigcamera.txt", Integer.valueOf(1));
		bedrockFileNames.put("lutMetadataGeologist.txt", Integer.valueOf(2));
		bedrockFileNames.put("lutMetadataPrjctType.txt", Integer.valueOf(1));
		bedrockFileNames.put("lutMetadataPrjname.txt", Integer.valueOf(3));
		bedrockFileNames.put("lutBEDMineralColour.txt", Integer.valueOf(1));
		bedrockFileNames.put("lutBEDMineralForm.txt", Integer.valueOf(1));
		bedrockFileNames.put("lutBEDMineralHabit.txt", Integer.valueOf(1));
		bedrockFileNames.put("lutBEDMineralMineral.txt", Integer.valueOf(1));
		bedrockFileNames.put("lutBEDMineralOccur.txt", Integer.valueOf(1));
		bedrockFileNames.put("lutBEDPhotoCategory.txt", Integer.valueOf(1));
		bedrockFileNames.put("lutBEDSamplePurpose.txt", Integer.valueOf(1));
		bedrockFileNames.put("lutBEDSampleSurface.txt", Integer.valueOf(1));
		bedrockFileNames.put("lutBEDSampleType.txt", Integer.valueOf(1));
		bedrockFileNames.put("lutBEDStationElevmethod.txt", Integer.valueOf(1));
		bedrockFileNames.put("lutBEDStationEntrytype.txt", Integer.valueOf(1));
		bedrockFileNames.put("lutBEDStationObstype.txt", Integer.valueOf(1));
		bedrockFileNames.put("lutBEDStationOutcropqual.txt", Integer.valueOf(1));
		bedrockFileNames.put("lutBEDStationPhysenviron.txt", Integer.valueOf(1));
		bedrockFileNames.put("lutBEDStrucAttitude.txt", Integer.valueOf(1));
		bedrockFileNames.put("lutBEDStrucFlattening.txt", Integer.valueOf(1));
		bedrockFileNames.put("lutBEDStrucGeneration.txt", Integer.valueOf(1));
		bedrockFileNames.put("lutBEDStrucStrain.txt", Integer.valueOf(1));
		bedrockFileNames.put("lutBEDStrucType.txt", Integer.valueOf(3));
		bedrockFileNames.put("lutBEDStrucYounging.txt", Integer.valueOf(1));

		surficialFileNames.put("lutSUREarthmatClastform.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSUREarthmatColour.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSUREarthmatCompaction.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSUREarthmatErratictyp.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSUREarthmatFissility.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSUREarthmatH2OContent.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSUREarthmatHCLReact.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSUREarthmatIntcontact.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSUREarthmatInterpconf.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSUREarthmatJointing.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSUREarthmatLandform.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSUREarthmatLatcontact.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSUREarthmatLith2.txt", Integer.valueOf(3));
		surficialFileNames.put("lutSUREarthmatLwrcontact.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSUREarthmatMapunit.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSUREarthmatMatrix.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSUREarthmatMatrixMod.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSUREarthmatOxidation.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSUREarthmatPrimestruc.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSUREarthmatRoundness.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSUREarthmatScndstruc.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSUREarthmatSorting.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSUREarthmatSurfform.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSUREarthmatThicktype.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSUREarthmatWayup.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSUREnvironsBoFldTyp.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSUREnvironsBoulders.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSUREnvironsExposure.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSUREnvironsGroundcover.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSUREnvironsPatterngrn.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSUREnvironsPFindic.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSUREnvironsRelief.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSUREnvironsVegetation.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSURGeneralPercent5incr.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSURGeneralStrucFormat.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSURGeneralStrucMethod.txt", Integer.valueOf(1));
		surficialFileNames.put("lutMetadataDigcamera.txt", Integer.valueOf(1));
		surficialFileNames.put("lutMetadataGeologist.txt", Integer.valueOf(2));
		surficialFileNames.put("lutMetadataPrjctType.txt", Integer.valueOf(1));
		surficialFileNames.put("lutMetadataPrjname.txt", Integer.valueOf(3));
		surficialFileNames.put("lutSURPflowBedrocksurface.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSURPflowDefinition.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSURPflowNumindic.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSURPflowPaleoflow.txt", Integer.valueOf(2));
		surficialFileNames.put("lutSURPflowPFsense.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSURPflowRelation.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSURPhotoCategory.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSURSamplePurpose.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSURSampleState.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSURSampleSurface.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSURSampleType.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSURStationElevmethod.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSURStationEntrytype.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSURStationLegendval.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSURStationObsType.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSURStationPhysenv.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSURStationSitequality.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSURStrucAttitude.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSURStrucFlattening.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSURStrucGeneration.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSURStrucStrain.txt", Integer.valueOf(1));
		surficialFileNames.put("lutSURStrucType.txt", Integer.valueOf(3));
		surficialFileNames.put("lutSURStrucYounging.txt", Integer.valueOf(1));
	}

	public void setDetail(int temp){
		this.detail = temp;
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
		Button [] buttons = {
				(Button) findViewById(R.id.tab_host_1_button1),
				(Button) findViewById(R.id.tab_host_1_button2),
				(Button) findViewById(R.id.tab_host_1_button3),
				(Button) findViewById(R.id.tab_host_1_button4),
				(Button) findViewById(R.id.tab_host_1_button5),
				(Button) findViewById(R.id.tab_host_1_button6),
				(Button) findViewById(R.id.tab_host_1_button7),
				(Button) findViewById(R.id.tab_host_1_button8)
		};

		for(int i = 0; i < buttons.length; i++) {
			buttons[i].setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {

					if(adap2.setTab(Integer.parseInt(((Button)v).getText().toString()))){
						swapButton.setEnabled(true);
						swapButton = ((Button)v);
						swapButton.setEnabled(false);
					}
					else{
						AlertDialog.Builder builder = new AlertDialog.Builder(context);
						builder.setTitle(R.string.earthmatBedrockDialog);
						builder.setMessage(R.string.earthmatBedrockDialogMessage);
						builder.setPositiveButton("Okay",
								new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int whichButton) {

							}
						});
						final AlertDialog dialog = builder.create();
						dialog.show();
					}



				}
			});
		}
	}

	public void setupButtonsEarthmatSurficial() {
		Button [] buttons = {
				(Button) findViewById(R.id.tab_host_2_button1),
				(Button) findViewById(R.id.tab_host_2_button2),
				(Button) findViewById(R.id.tab_host_2_button3),
				(Button) findViewById(R.id.tab_host_2_button4),
				(Button) findViewById(R.id.tab_host_2_button5),
				(Button) findViewById(R.id.tab_host_2_button6),
				(Button) findViewById(R.id.tab_host_2_button7),
				(Button) findViewById(R.id.tab_host_2_button8)
		};

		for(int i = 0; i < buttons.length; i++) {
			buttons[i].setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					if(adap4.setTab(Integer.parseInt(((Button)v).getText().toString()))){
						swapButton.setEnabled(true);
						swapButton = ((Button)v);
						swapButton.setEnabled(false);
					}
					else{
						AlertDialog.Builder builder = new AlertDialog.Builder(context);
						builder.setTitle(R.string.earthmatSurficialDialog);
						builder.setMessage(R.string.earthmatSurficialDialogMessage);
						builder.setPositiveButton("Okay",
								new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int whichButton) {

							}
						});
						final AlertDialog dialog = builder.create();
						dialog.show();
					}

				}
			});
		}
	}

	public void setupButtonsEnvironSurficial() {
		Button [] buttons = {
				(Button) findViewById(R.id.tab_host_3_button1),
				(Button) findViewById(R.id.tab_host_3_button2),
				(Button) findViewById(R.id.tab_host_3_button3),
				(Button) findViewById(R.id.tab_host_3_button4),
				(Button) findViewById(R.id.tab_host_3_button5)
		};

		for(int i = 0; i < buttons.length; i++) {
			buttons[i].setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					swapButton.setEnabled(true);
					swapButton = ((Button)v);
					adap6.setTab(Integer.parseInt(((Button)v).getText().toString()));
					swapButton.setEnabled(false);
				}
			});
		}
	}

	public void setupButtonsMABedrock() {
		Button [] buttons = {
				(Button) findViewById(R.id.tab_host_4_button1),
				(Button) findViewById(R.id.tab_host_4_button2)
		};

		for(int i = 0; i < buttons.length; i++) {
			buttons[i].setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					swapButton.setEnabled(true);
					swapButton = ((Button)v);
					adap8.setTab(Integer.parseInt(((Button)v).getText().toString()));
					swapButton.setEnabled(false);
				}
			});
		}
	}

	public void setupButtonsMetadata() {
		Button [] buttons = {
				(Button) findViewById(R.id.tab_host_5_button1),
				(Button) findViewById(R.id.tab_host_5_button2)
		};

		for(int i = 0; i < buttons.length; i++) {
			buttons[i].setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					swapButton.setEnabled(true);
					swapButton = ((Button)v);
					adap10.setTab(Integer.parseInt(((Button)v).getText().toString()));
					swapButton.setEnabled(false);
				}
			});
		}
	}

	public void setupButtonsMineralBedrock() {
		Button [] buttons = {
				(Button) findViewById(R.id.tab_host_6_button1),
				(Button) findViewById(R.id.tab_host_6_button2),
				(Button) findViewById(R.id.tab_host_6_button3),
				(Button) findViewById(R.id.tab_host_6_button4)
		};

		for(int i = 0; i < buttons.length; i++) {
			buttons[i].setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					swapButton.setEnabled(true);
					swapButton = ((Button)v);
					adap12.setTab(Integer.parseInt(((Button)v).getText().toString()));
					swapButton.setEnabled(false);
				}
			});
		}
	}

	public void setupButtonsPFlowSurficial() {
		Button [] buttons = {
				(Button) findViewById(R.id.tab_host_7_button1),
				(Button) findViewById(R.id.tab_host_7_button2),
				(Button) findViewById(R.id.tab_host_7_button3)
		};

		for(int i = 0; i < buttons.length; i++) {
			buttons[i].setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					if(adap14.setTab(Integer.parseInt(((Button)v).getText().toString()))){
						swapButton.setEnabled(true);
						swapButton = ((Button)v);
						swapButton.setEnabled(false);
					}
					else{
						AlertDialog.Builder builder = new AlertDialog.Builder(context);
						builder.setTitle(R.string.pFlowSurficialDialog);
						builder.setMessage(R.string.pFlowSurficialDialogMessage);
						builder.setPositiveButton("Okay",
								new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int whichButton) {

							}
						});
						final AlertDialog dialog = builder.create();
						dialog.show();
					}

				}
			});
		}
	}

	public void setupButtonsPhoto() {
		Button [] buttons = {
				(Button) findViewById(R.id.tab_host_8_button1),
				(Button) findViewById(R.id.tab_host_8_button2)
		};

		for(int i = 0; i < buttons.length; i++) {
			buttons[i].setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					swapButton.setEnabled(true);
					swapButton = ((Button)v);
					adap16.setTab(Integer.parseInt(((Button)v).getText().toString()));
					swapButton.setEnabled(false);
				}
			});
		}
	}

	public void setupButtonsSampleBedrock() {
		Button [] buttons = {
				(Button) findViewById(R.id.tab_host_9_button1),
				(Button) findViewById(R.id.tab_host_9_button2),
				(Button) findViewById(R.id.tab_host_9_button3)
		};

		for(int i = 0; i < buttons.length; i++) {
			buttons[i].setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					if(adap18.setTab(Integer.parseInt(((Button)v).getText().toString()))){
						swapButton.setEnabled(true);
						swapButton = ((Button)v);
						swapButton.setEnabled(false);
					}
					else{
						AlertDialog.Builder builder = new AlertDialog.Builder(context);
						builder.setTitle(R.string.sampleBedrockDialog);
						builder.setMessage(R.string.sampleBedrockDialogMessage);
						builder.setPositiveButton("Okay",
								new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int whichButton) {

							}
						});
						final AlertDialog dialog = builder.create();
						dialog.show();
					}

				}
			});
		}
	}

	public void setupButtonsSampleSurficial() {
		Button [] buttons = {
				(Button) findViewById(R.id.tab_host_10_button1),
				(Button) findViewById(R.id.tab_host_10_button2),
				(Button) findViewById(R.id.tab_host_10_button3)
		};

		for(int i = 0; i < buttons.length; i++) {
			buttons[i].setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					if(adap20.setTab(Integer.parseInt(((Button)v).getText().toString()))){
						swapButton.setEnabled(true);
						swapButton = ((Button)v);
						swapButton.setEnabled(false);
					}
					else{
						AlertDialog.Builder builder = new AlertDialog.Builder(context);
						builder.setTitle(R.string.sampleSurficialDialog);
						builder.setMessage(R.string.sampleSurficialDialogMessage);
						builder.setPositiveButton("Okay",
								new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int whichButton) {

							}
						});
						final AlertDialog dialog = builder.create();
						dialog.show();
					}

				}
			});
		}
	}

	public void setupButtonsSoilProSurficial() {
		Button [] buttons = {
				(Button) findViewById(R.id.tab_host_11_button1),
				(Button) findViewById(R.id.tab_host_11_button2)
		};

		for(int i = 0; i < buttons.length; i++) {
			buttons[i].setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					swapButton.setEnabled(true);
					swapButton = ((Button)v);
					adap22.setTab(Integer.parseInt(((Button)v).getText().toString()));
					swapButton.setEnabled(false);
				}
			});
		}
	}

	public void setupButtonsStationBedrock() {
		Button [] buttons = {
				(Button) findViewById(R.id.tab_host_12_button1),
				(Button) findViewById(R.id.tab_host_12_button2),
				(Button) findViewById(R.id.tab_host_12_button3),
				(Button) findViewById(R.id.tab_host_12_button4),
				(Button) findViewById(R.id.tab_host_12_button5)
		};

		for(int i = 0; i < buttons.length; i++) {
			buttons[i].setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					swapButton.setEnabled(true);
					swapButton = ((Button)v);
					adap24.setTab(Integer.parseInt(((Button)v).getText().toString()));
					swapButton.setEnabled(false);
				}
			});
		}
	}

	public void setupButtonsStationSurficial() {
		Button [] buttons = {
				(Button) findViewById(R.id.tab_host_13_button1),
				(Button) findViewById(R.id.tab_host_13_button2),
				(Button) findViewById(R.id.tab_host_13_button3),
				(Button) findViewById(R.id.tab_host_13_button4),
				(Button) findViewById(R.id.tab_host_13_button5)
		};

		for(int i = 0; i < buttons.length; i++) {
			buttons[i].setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					swapButton.setEnabled(true);
					swapButton = ((Button)v);
					adap26.setTab(Integer.parseInt(((Button)v).getText().toString()));
					swapButton.setEnabled(false);
				}
			});
		}
	}

	public void setupButtonsStructure() {
		Button [] buttons = {
				(Button) findViewById(R.id.tab_host_14_button1),
				(Button) findViewById(R.id.tab_host_14_button2),
				(Button) findViewById(R.id.tab_host_14_button3),
				(Button) findViewById(R.id.tab_host_14_button4),
				(Button) findViewById(R.id.tab_host_14_button5)
		};

		for(int i = 0; i < buttons.length; i++) {
			buttons[i].setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					if(adap28.setTab(Integer.parseInt(((Button)v).getText().toString()))){
						swapButton.setEnabled(true);
						swapButton = ((Button)v);
						swapButton.setEnabled(false);
					}
					else{
						AlertDialog.Builder builder = new AlertDialog.Builder(context);
						builder.setTitle(R.string.structureDialog);
						builder.setMessage(R.string.structureDialogMessage);
						builder.setPositiveButton("Okay",
								new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int whichButton) {

							}
						});
						final AlertDialog dialog = builder.create();
						dialog.show();
					}
					swapButton.setEnabled(true);
					swapButton = ((Button)v);
					adap28.setTab(Integer.parseInt(((Button)v).getText().toString()));
					swapButton.setEnabled(false);
				}
			});
		}
	}

	private void startFileChooser()
	{
		Intent intent = new Intent(this, FileChooser.class);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add("Picklists");
		menu.add("Export Data");
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("Are you sure you want to find Picklists? (May take a few seconds)")
		.setTitle("Picklists");

		builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				System.out.println("PICKLIST BUTTON CLICKED"); 
				showDialog(0);
			}
		});
		builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				dialog.dismiss();
			}
		});

		AlertDialog dialog = builder.create();

		switch (item.getItemId()) {
		case 0:
			dialog.show();
			return true;
		case 1:
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		switch(id) {
		case 0:
			progDialog = new ProgressDialog(this){
				@Override
				public boolean onSearchRequested() {
					return false;
				}
			};
			System.out.println("NEW DIALOG CREATED");
			progDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			progDialog.setMessage("Loading...");
			progDialog.setCancelable(false);
			progThread = new ProgressThread(handler);
			System.out.println("NEW THREAD CREATED");
			progThread.start();
			System.out.println("THREAD STARTED");
			return progDialog;

		case 1:/*
            progDialog = new ProgressDialog(this);
            progDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progDialog.setMax(maxBarValue);
            progDialog.setMessage("Dollars in checking account:");
            progThread = new ProgressThread(handler);
            progThread.start();
            return progDialog;*/

		default:
			return null;
		}
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
			flipper.setDisplayedChild(28);
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void backAction1() {
			flipper.setDisplayedChild(0);
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void backAction2() {
			flipper.setDisplayedChild(28);
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void backAction3() {
			flipper.setDisplayedChild(2);
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void backAction4() {
			flipper.setDisplayedChild(28);
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void backAction5() {
			flipper.setDisplayedChild(4);
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void backAction6() {
			flipper.setDisplayedChild(28);
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void backAction7() {
			flipper.setDisplayedChild(6);
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void backAction8() {
			//First page.. no back button. 
		}

		public void backAction9() {
			flipper.setDisplayedChild(8);
			button2.setVisibility(View.INVISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void backAction10() {
			flipper.setDisplayedChild(29);
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void backAction11() {
			flipper.setDisplayedChild(10);
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void backAction12() {
			flipper.setDisplayedChild(29);
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void backAction13() {
			flipper.setDisplayedChild(12);
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void backAction14() {
			flipper.setDisplayedChild(28);
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void backAction15() {
			flipper.setDisplayedChild(14);
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void backAction16() {
			flipper.setDisplayedChild(29);
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void backAction17() {
			flipper.setDisplayedChild(16);
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void backAction18() {
			flipper.setDisplayedChild(29);
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void backAction19() {
			flipper.setDisplayedChild(18);
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void backAction20() {
			flipper.setDisplayedChild(28);
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void backAction21() {
			flipper.setDisplayedChild(20);
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void backAction22() {
			flipper.setDisplayedChild(8);
			button2.setVisibility(View.INVISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void backAction23() {
			flipper.setDisplayedChild(22);
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void backAction24() {
			flipper.setDisplayedChild(8);
			button2.setVisibility(View.INVISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void backAction25() {
			flipper.setDisplayedChild(24);
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void backAction26() {
			flipper.setDisplayedChild(29);
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void backAction27() {
			flipper.setDisplayedChild(26);
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void backAction28() {
			if(metadataModel.getEntity().getPrjct_type().equalsIgnoreCase("bedrock")){
				flipper.setDisplayedChild(22);
				button2.setVisibility(View.VISIBLE);
				button1.setVisibility(View.INVISIBLE);
				mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
				topTitle.setText(titles[flipper.getDisplayedChild()].toString());

			}else if (metadataModel.getEntity().getPrjct_type().equalsIgnoreCase("surficial")){
				flipper.setDisplayedChild(24);
				button2.setVisibility(View.VISIBLE);
				button1.setVisibility(View.INVISIBLE);
				mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
				topTitle.setText(titles[flipper.getDisplayedChild()].toString());
			}


		}

		public void backAction29() {
			flipper.setDisplayedChild(28);
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}
	}

	public class CellAction {

		public void cellAction0() {
			nrCanId3 = earthmatBedrockModel.getEntity().getNrcanId3();

			flipper.setDisplayedChild(29);

			newFlag = false;
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void cellAction1() {
			//no cells in form page
		}

		public void cellAction2() {
			nrCanId3 = earthmatSurficialModel.getEntity().getNrcanId3();

			flipper.setDisplayedChild(29);

			newFlag = false;
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void cellAction3() {
			//no cells in form page
		}

		public void cellAction4() {
			nrCanId3 = environSurficialModel.getEntity().getNrcanId3();

			flipper.setDisplayedChild(5);

			newFlag = false;
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.VISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void cellAction5() {
			//no cells in form page
		}

		public void cellAction6() {
			nrCanId3 = mABedrockModel.getEntity().getNrcanId3();

			flipper.setDisplayedChild(7);

			newFlag = false;
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.VISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void cellAction7() {
			//no cells in form page
		}

		public void cellAction8() {

			nrCanId1= metadataModel.getEntity().getNrcanId1();


			if(metadataModel.getEntity().getPrjct_type().equalsIgnoreCase("bedrock")){
				flipper.setDisplayedChild(22);

			}else if (metadataModel.getEntity().getPrjct_type().equalsIgnoreCase("surficial")){
				flipper.setDisplayedChild(24);

			}else {}


			newFlag = false;
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void cellAction9() {
			//no cells in form page
		}

		public void cellAction10() {
			nrCanId4 = mineralBedrockModel.getEntity().getNrcanId4();
			flipper.setDisplayedChild(11);




			newFlag = false;
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.VISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void cellAction11() {
			//no cells in form page
		}

		public void cellAction12() {
			nrCanId4 = pFlowSurficialModel.getEntity().getNrcanId4();
			flipper.setDisplayedChild(13);




			newFlag = false;
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.VISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void cellAction13() {
			//no cells in form page
		}

		public void cellAction14() {
			nrCanId3 = photoModel.getEntity().getNrcanId3();

			flipper.setDisplayedChild(15);

			newFlag = false;
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.VISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void cellAction15() {
			//no cells in form page
		}

		public void cellAction16() {
			nrCanId4 = sampleBedrockModel.getEntity().getNrcanId4();

			flipper.setDisplayedChild(17);

			newFlag = false;
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.VISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void cellAction17() {
			//no cells in form page
		}

		public void cellAction18() {
			nrCanId4 = sampleSurficialModel.getEntity().getNrcanId4();
			flipper.setDisplayedChild(19);




			newFlag = false;
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.VISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void cellAction19() {
			//no cells in form page
		}

		public void cellAction20() {
			nrCanId3 = soilProSurficialModel.getEntity().getNrcanId3();

			flipper.setDisplayedChild(21);

			newFlag = false;
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.VISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void cellAction21() {
			//no cells in form page
		}

		public void cellAction22() {
			nrCanId2= stationBedrockModel.getEntity().getNrcanId2();

			flipper.setDisplayedChild(28);




			newFlag = false;
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void cellAction23() {
			//no cells in form page
		}

		public void cellAction24() {
			nrCanId2 = stationSurficialModel.getEntity().getNrcanId2();

			flipper.setDisplayedChild(28);

			newFlag = false;
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void cellAction25() {
			//no cells in form page
		}

		public void cellAction26() {
			nrCanId4 = structureModel.getEntity().getNrcanId4();
			flipper.setDisplayedChild(27);




			newFlag = false;
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.VISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void cellAction27() {
			//no cells in form page
		}

		public void cellAction28() {

			if(metadataModel.getEntity().getPrjct_type().equalsIgnoreCase("bedrock")){
				if(detail==0){
					flipper.setDisplayedChild(0);
				}
				else if(detail==1){
					flipper.setDisplayedChild(6);
				}
				else if (detail==2){
					flipper.setDisplayedChild(14);
				}


			}else if (metadataModel.getEntity().getPrjct_type().equalsIgnoreCase("surficial")){
				if(detail==0){
					flipper.setDisplayedChild(2);
				}
				else if(detail==1){
					flipper.setDisplayedChild(4);
				}
				else if (detail==2){
					flipper.setDisplayedChild(20);
				}
				else if (detail==3){
					flipper.setDisplayedChild(14);
				}

			}


			newFlag = false;
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void cellAction29() {
			if(metadataModel.getEntity().getPrjct_type().equalsIgnoreCase("bedrock")){
				if(detail==0){
					flipper.setDisplayedChild(16);
				}
				else if(detail==1){
					flipper.setDisplayedChild(26);
				}
				else if (detail==2){
					flipper.setDisplayedChild(10);
				}


			}else if (metadataModel.getEntity().getPrjct_type().equalsIgnoreCase("surficial")){
				if(detail==0){
					flipper.setDisplayedChild(18);
				}
				else if(detail==1){
					flipper.setDisplayedChild(26);
				}
				else if (detail==2){
					flipper.setDisplayedChild(12);
				}


			}


			newFlag = false;
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}
	}

	public class EditAction {

		public void editAction0() {
			nrCanId3 = earthmatBedrockModel.getEntity().getNrcanId3();
			flipper.setDisplayedChild(1);
			newFlag = false;
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.VISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void editAction1() {
			//no edit functionality on form
		}

		public void editAction2() {
			nrCanId3 = earthmatSurficialModel.getEntity().getNrcanId3();
			flipper.setDisplayedChild(3);
			newFlag = false;
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.VISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void editAction3() {
			//no edit functionality on form
		}

		public void editAction4() {
			nrCanId3 = environSurficialModel.getEntity().getNrcanId3();
			flipper.setDisplayedChild(5);
			newFlag = false;
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.VISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void editAction5() {

		}

		public void editAction6() {
			nrCanId3 = mABedrockModel.getEntity().getNrcanId3();
			flipper.setDisplayedChild(7);
			newFlag = false;
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.VISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void editAction7() {
			//no edit functionality on form
		}

		public void editAction8() {
			nrCanId1 = metadataModel.getEntity().getNrcanId1();
			flipper.setDisplayedChild(9);
			newFlag = false;
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.VISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void editAction9() {
			//no edit functionality on form
		}

		public void editAction10() {
			nrCanId4 = mineralBedrockModel.getEntity().getNrcanId4();
			flipper.setDisplayedChild(11);
			newFlag = false;
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.VISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void editAction11() {
			//no edit functionality on form
		}

		public void editAction12() {
			nrCanId4 = pFlowSurficialModel.getEntity().getNrcanId4();
			flipper.setDisplayedChild(13);
			newFlag = false;
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.VISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void editAction13() {
			//no edit functionality on form
		}

		public void editAction14() {
			nrCanId3 = photoModel.getEntity().getNrcanId3();
			flipper.setDisplayedChild(15);
			newFlag = false;
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.VISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void editAction15() {
			//no edit functionality on form
		}

		public void editAction16() {
			nrCanId4 = sampleBedrockModel.getEntity().getNrcanId4();
			flipper.setDisplayedChild(17);
			newFlag = false;
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.VISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void editAction17() {
			//no edit functionality on form
		}

		public void editAction18() {
			nrCanId4 = sampleSurficialModel.getEntity().getNrcanId4();
			flipper.setDisplayedChild(19);
			newFlag = false;
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.VISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void editAction19() {
			//no edit functionality on form
		}

		public void editAction20() {
			nrCanId3 = soilProSurficialModel.getEntity().getNrcanId3();
			flipper.setDisplayedChild(21);
			newFlag = false;
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.VISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void editAction21() {
			//no edit functionality on form
		}

		public void editAction22() {
			nrCanId2 = stationBedrockModel.getEntity().getNrcanId2();
			flipper.setDisplayedChild(23);
			newFlag = false;
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.VISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void editAction23() {
			//no edit functionality on form
		}

		public void editAction24() {
			nrCanId2 = stationSurficialModel.getEntity().getNrcanId2();
			flipper.setDisplayedChild(25);
			newFlag = false;
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.VISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void editAction25() {
			//no edit functionality on form
		}

		public void editAction26() {
			nrCanId4 = structureModel.getEntity().getNrcanId4();
			flipper.setDisplayedChild(27);
			newFlag = false;
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.VISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void editAction27() {
			//no edit functionality on form
		}

		public void editAction28() {
			//a list with no edit on list
		}

		public void editAction29() {
			//a list with no edit on list
		}
	}

	public class NewAction {

		public void newAction0() {
			nrCanId3 = earthmatBedrockModel.getEntity().getNrcanId3();
			flipper.setDisplayedChild(1);
			newFlag = true;
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.VISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void newAction1() {
			//no new functionality on form
		}

		public void newAction2() {
			nrCanId3 = earthmatSurficialModel.getEntity().getNrcanId3();
			flipper.setDisplayedChild(3);
			newFlag = true;
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.VISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void newAction3() {
			//no new functionality on form
		}

		public void newAction4() {
			nrCanId3 = environSurficialModel.getEntity().getNrcanId3();
			flipper.setDisplayedChild(5);
			newFlag = true;
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.VISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void newAction5() {
			//no new functionality on form
		}

		public void newAction6() {
			nrCanId3 = mABedrockModel.getEntity().getNrcanId3();
			flipper.setDisplayedChild(7);
			newFlag = true;
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.VISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void newAction7() {
			//no new functionality on form
		}

		public void newAction8() {
			nrCanId1 = metadataModel.getEntity().getNrcanId1();
			flipper.setDisplayedChild(9);
			newFlag = true;
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.VISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());


		}

		public void newAction9() {
			//no new functionality on form
		}

		public void newAction10() {
			nrCanId4 = mineralBedrockModel.getEntity().getNrcanId4();
			flipper.setDisplayedChild(11);
			newFlag = true;
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.VISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void newAction11() {
			//no new functionality on form
		}

		public void newAction12() {
			nrCanId4 = pFlowSurficialModel.getEntity().getNrcanId4();
			flipper.setDisplayedChild(13);
			newFlag = true;
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.VISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void newAction13() {
			//no new functionality on form
		}

		public void newAction14() {
			nrCanId3 = photoModel.getEntity().getNrcanId3();
			flipper.setDisplayedChild(15);
			newFlag = true;
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.VISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void newAction15() {
			//no new functionality on form
		}

		public void newAction16() {
			nrCanId4 = sampleBedrockModel.getEntity().getNrcanId4();
			flipper.setDisplayedChild(17);
			newFlag = true;
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.VISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void newAction17() {
			//no new functionality on form
		}

		public void newAction18() {
			nrCanId4 = sampleSurficialModel.getEntity().getNrcanId4();
			flipper.setDisplayedChild(19);
			newFlag = true;
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.VISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void newAction19() {
			//no new functionality on form
		}

		public void newAction20() {
			nrCanId3 = soilProSurficialModel.getEntity().getNrcanId3();
			flipper.setDisplayedChild(21);
			newFlag = true;
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.VISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void newAction21() {
			//no new functionality on form
		}

		public void newAction22() {
			nrCanId2 = stationBedrockModel.getEntity().getNrcanId2();
			flipper.setDisplayedChild(23);
			newFlag = true;
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.VISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void newAction23() {
			//no new functionality on form
		}

		public void newAction24() {
			nrCanId2 = stationSurficialModel.getEntity().getNrcanId2();
			flipper.setDisplayedChild(25);
			newFlag = true;
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.VISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void newAction25() {
			//no new functionality on form
		}

		public void newAction26() {
			nrCanId4 = structureModel.getEntity().getNrcanId4();
			flipper.setDisplayedChild(27);
			newFlag = true;
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.VISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void newAction27() {
			//no new functionality on form
		}

		public void newAction28() {
			//no new functionality on this particular list
		}

		public void newAction29() {
			//no new functionality on this particular list
		}
	}

	public class SaveAction {

		public void saveAction0() {
			//no save functionality on list view with cells
		}

		public void saveAction1() {
			if(newFlag)
			{
				earthmatBedrockModel.insertRow();
				nrCanId3= earthmatBedrockModel.getEntity().getNrcanId3();
				newFlag = false;



			}
			else
			{
				earthmatBedrockModel.updateRow();

			}


			flipper.setDisplayedChild(29);
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void saveAction2() {
			//no save functionality on list view with cells
		}

		public void saveAction3() {
			if(newFlag)
			{
				earthmatSurficialModel.insertRow();
				nrCanId3= earthmatSurficialModel.getEntity().getNrcanId3();
				newFlag = false;



			}
			else
			{
				earthmatSurficialModel.updateRow();

			}


			flipper.setDisplayedChild(29);
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void saveAction4() {

		}

		public void saveAction5() {
			if(newFlag)
			{
				environSurficialModel.insertRow();
				nrCanId3= environSurficialModel.getEntity().getNrcanId3();
				newFlag = false;



			}
			else
			{
				environSurficialModel.updateRow();

			}


			flipper.setDisplayedChild(4);
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void saveAction6() {
			//no save functionality on list view with cells
		}

		public void saveAction7() {
			if(newFlag)
			{
				mABedrockModel.insertRow();
				nrCanId3= mABedrockModel.getEntity().getNrcanId3();
				newFlag = false;



			}
			else
			{
				mABedrockModel.updateRow();

			}


			flipper.setDisplayedChild(6);
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void saveAction8() {
			//no save functionality on list view with cells
		}

		public void saveAction9() {
			//check to see if anything has been done on the form page yet
			//if its a NEW form, set nrcanID1 on save
			//run insert row to save current fields entered
			//then advance to station list (22)

			//if you reached the form by hitting edit, the nrcanid1 already is set
			//you will update the already populate fields in the database
			//then advance to station list(22)

			//in both cases, a project type *bedrock or surficial will be set
			//and this information is needed as it effects if you go to
			//station(22 bedrock) or station (24 surficial)

			//a .equals is performed on .getPrjct_type() to determine which project type has been set
			//if a project type was NOT set and save was initiated, I would suggest a modal dialog
			//pop up reminding them to select it. For now I will just not code the advancement to
			// flipper 22 or 24 respectivly. 
			if(newFlag)
			{
				metadataModel.insertRow();
				nrCanId1= metadataModel.getEntity().getNrcanId1();
				newFlag = false;



			}
			else
			{
				metadataModel.updateRow();


			}
			if(metadataModel.getEntity().getPrjct_type().equalsIgnoreCase("bedrock")){
				flipper.setDisplayedChild(22);
				button2.setVisibility(View.VISIBLE);
				button1.setVisibility(View.INVISIBLE);
				mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
				topTitle.setText(titles[flipper.getDisplayedChild()].toString());
				newFlag = false;

			}else if (metadataModel.getEntity().getPrjct_type().equalsIgnoreCase("surficial")){
				flipper.setDisplayedChild(24);
				button2.setVisibility(View.VISIBLE);
				button1.setVisibility(View.INVISIBLE);
				mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
				topTitle.setText(titles[flipper.getDisplayedChild()].toString());
				newFlag = false;
			}else{
				//maybe set dialog box to remind entering project type to advance with save
				button2.setVisibility(View.VISIBLE);
				button1.setVisibility(View.VISIBLE);
				mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
				topTitle.setText(titles[flipper.getDisplayedChild()].toString());
			}





		}

		public void saveAction10() {
			//no save functionality on list view with cells
		}

		public void saveAction11() {
			if(newFlag)
			{
				mineralBedrockModel.insertRow();
				nrCanId4= mineralBedrockModel.getEntity().getNrcanId4();
				newFlag = false;



			}
			else
			{
				mineralBedrockModel.updateRow();

			}


			flipper.setDisplayedChild(10);
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void saveAction12() {

		}

		public void saveAction13() {
			if(newFlag)
			{
				pFlowSurficialModel.insertRow();
				nrCanId4= pFlowSurficialModel.getEntity().getNrcanId4();
				newFlag = false;



			}
			else
			{
				pFlowSurficialModel.updateRow();

			}


			flipper.setDisplayedChild(12);
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void saveAction14() {
			//no save functionality on list view with cells
		}

		public void saveAction15() {
			if(newFlag)
			{
				photoModel.insertRow();
				nrCanId3= photoModel.getEntity().getNrcanId3();
				newFlag = false;



			}
			else
			{
				photoModel.updateRow();

			}


			flipper.setDisplayedChild(14);
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void saveAction16() {
			//no save functionality on list view with cells
		}

		public void saveAction17() {
			if(newFlag)
			{
				sampleBedrockModel.insertRow();
				nrCanId4= sampleBedrockModel.getEntity().getNrcanId4();
				newFlag = false;



			}
			else
			{
				sampleBedrockModel.updateRow();

			}


			flipper.setDisplayedChild(16);
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void saveAction18() {
			//no save functionality on list view with cells
		}

		public void saveAction19() {
			if(newFlag)
			{
				sampleSurficialModel.insertRow();
				nrCanId4= sampleSurficialModel.getEntity().getNrcanId4();
				newFlag = false;



			}
			else
			{
				sampleSurficialModel.updateRow();

			}


			flipper.setDisplayedChild(18);
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void saveAction20() {

		}

		public void saveAction21() {
			if(newFlag)
			{
				soilProSurficialModel.insertRow();
				nrCanId3= soilProSurficialModel.getEntity().getNrcanId3();
				newFlag = false;



			}
			else
			{
				soilProSurficialModel.updateRow();

			}


			flipper.setDisplayedChild(20);
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void saveAction22() {
			//no save functionality on list view with cells
		}

		public void saveAction23() {
			if(newFlag)
			{
				stationBedrockModel.insertRow();
				nrCanId2= stationBedrockModel.getEntity().getNrcanId2();
				newFlag = false;



			}
			else
			{
				stationBedrockModel.updateRow();

			}


			flipper.setDisplayedChild(28);
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());

		}

		public void saveAction24() {
			//no save functionality on list view with cells
		}

		public void saveAction25() {
			if(newFlag)
			{
				stationSurficialModel.insertRow();
				nrCanId2= stationSurficialModel.getEntity().getNrcanId2();
				newFlag = false;



			}
			else
			{
				stationSurficialModel.updateRow();

			}


			flipper.setDisplayedChild(28);
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());

		}


		public void saveAction26() {
			//no save functionality on list view with cells
		}

		public void saveAction27() {
			if(newFlag)
			{
				structureModel.insertRow();
				nrCanId4= structureModel.getEntity().getNrcanId4();
				newFlag = false;



			}
			else
			{
				structureModel.updateRow();

			}


			flipper.setDisplayedChild(26);
			button2.setVisibility(View.VISIBLE);
			button1.setVisibility(View.INVISIBLE);
			mainTitle.setText(titles[flipper.getDisplayedChild()].toString());
			topTitle.setText(titles[flipper.getDisplayedChild()].toString());
		}

		public void saveAction28() {
			//no save functionality on list view with cells
		}

		public void saveAction29() {
			//no save functionality on list view with cells
		}
	}

	public static HashMap<String, Integer> getBedrock() {
		return bedrockFileNames;
	}

	public static HashMap<String, Integer> getSurficial() {
		return surficialFileNames;
	}

	/*
    public ArrayList<String> readRows() {
        dbHandler.executeQuery(PreparedStatements.READ_ALL_ROWS, new String [] { METADATA_TABLE_NAME });

        return dbHandler.getList();
    }
	 *//************************************************************************************
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

	final Handler handler =  new Handler() {
		public void handleMessage(Message msg) {
			boolean isdone = msg.getData().getBoolean("isdone");
			if (isdone) {
				removeDialog(0);
				progThread.setState(ProgressThread.DONE);
				startFileChooser();
			}
		}
	};

	private class ProgressThread extends Thread {	
		final static int DONE = 0;
		final static int RUNNING = 1;

		FileChooser fc = new FileChooser();
		Handler mHandler;
		int mState;

		ProgressThread(Handler h) {
			mHandler = h;
		}

		@Override
		public void run() {
			mState = RUNNING;
			dir = fc.doWork();

			Message msg = mHandler.obtainMessage();
			Bundle b = new Bundle();
			b.putBoolean("isdone", fc.isDoneWork());
			msg.setData(b);
			mHandler.sendMessage(msg);
		}

		public void setState(int state) {
			mState = state;
		}
	}
}
