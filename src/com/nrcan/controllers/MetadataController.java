package com.nrcan.controllers;

import com.nrcan.entities.MetadataEntity;
import com.nrcan.main.PicklistDatabaseHandler;
import com.nrcan.main.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class MetadataController extends BaseAdapter implements Filterable {
	private LayoutInflater mInflater;
	private Activity activity;
	private Context context;
	private PicklistDatabaseHandler pldb;
	private MetadataEntity metadataEntity;
    private int tab;

	public MetadataController(Context context, Activity activity, MetadataEntity metadataEntity,PicklistDatabaseHandler pldb) {
		this.mInflater = LayoutInflater.from(context);
		this.activity = activity;
		this.context = context;
		this.tab = 1;
        this.pldb = pldb;
        this.metadataEntity = metadataEntity;
	}

	public int getCount() {
		return 1;
	}

	public Object getItem(int arg0) {
		return null;
	}

	public long getItemId(int arg0) {
		return 0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		if (tab == 1) {
			convertView = mInflater.inflate(R.layout.metadata1, null);

			EditText editTextProjectName = (EditText) convertView.findViewById(R.id.metadata_editText_projectName);
			editTextProjectName.setText(metadataEntity.getPrjct_name());
			
			EditText editTextProjectCode = (EditText) convertView.findViewById(R.id.metadata_editText_projectCode);
			editTextProjectCode.setText(metadataEntity.getPrjct_code());
			
			EditText editTextProjectLeader = (EditText) convertView.findViewById(R.id.metadata_editText_projectLeader);
			editTextProjectLeader.setText(metadataEntity.getPrjct_lead());
			
			Spinner spinnerProjectType = (Spinner) convertView.findViewById(R.id.metadata_spinner_projectType);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutBEDMetadataPrjctType"));
			spinnerProjectType.setAdapter(sp1);
			spinnerProjectType.setSelection(sp1.getPosition(metadataEntity.getPrjct_type()));
			spinnerProjectType.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					metadataEntity.setPrjct_type(parent.getItemAtPosition(position).toString());
				}
			});
			
		} else if (tab == 2) {
			convertView = mInflater.inflate(R.layout.metadata2, null);

			Spinner spinnerGeologistName = (Spinner) convertView.findViewById(R.id.metadata_spinner_geologistName);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutBEDMetadataGeologist"));
			spinnerGeologistName.setAdapter(sp1);
			spinnerGeologistName.setSelection(sp1.getPosition(metadataEntity.getGeologist()));
			spinnerGeologistName.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					metadataEntity.setGeologist(parent.getItemAtPosition(position).toString());
				}
			});
			
			Spinner spinnerGeologistCode = (Spinner) convertView.findViewById(R.id.metadata_spinner_geologistCode);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp2.setElements(pldb.getCol2("lutBEDMetadataGeologist", metadataEntity.getGeologist()));
			spinnerGeologistCode.setAdapter(sp2);
			spinnerGeologistCode.setSelection(sp2.getPosition(metadataEntity.getGeolcode()));
			spinnerGeologistCode.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					metadataEntity.setGeolcode(parent.getItemAtPosition(position).toString());
				}
			});
			
			Spinner spinnerCameraPrefix = (Spinner) convertView.findViewById(R.id.metadata_spinner_cameraPrefix);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp3.setElements(pldb.getCol1("lutBEDMetadataDigcamera"));
			spinnerCameraPrefix.setAdapter(sp3);
			spinnerCameraPrefix.setSelection(sp3.getPosition(metadataEntity.getDigcamera()));
			spinnerCameraPrefix.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					metadataEntity.setDigcamera(parent.getItemAtPosition(position).toString());
				}
			});
			
			Spinner spinnerMapProjection = (Spinner) convertView.findViewById(R.id.metadata_spinner_selectMapProjection);
			SpinnerController sp4 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp4.setElements(pldb.getCol1("lutBEDMetadataPrjname"));
			spinnerMapProjection.setAdapter(sp4);
			spinnerMapProjection.setSelection(sp4.getPosition(metadataEntity.getPrj_name()));
			spinnerMapProjection.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					metadataEntity.setPrj_name(parent.getItemAtPosition(position).toString());
				}
			});
			
			EditText editTextStationStartNo = (EditText) convertView.findViewById(R.id.metadata_editText_stationStartNo);
			editTextStationStartNo.setText(metadataEntity.getStnstartno());
		}

		return convertView;
	}

	public Filter getFilter() {
		return null;
	}

	public void setTab(int tabNum) {
		this.tab = tabNum;
		notifyDataSetChanged();
	}
	
	public void saveTab1() {
		EditText editTextProjectName = (EditText) activity.findViewById(R.id.metadata_editText_projectName);
		EditText editTextProjectCode = (EditText) activity.findViewById(R.id.metadata_editText_projectCode);
		EditText editTextProjectLeader = (EditText) activity.findViewById(R.id.metadata_editText_projectLeader);
		
		metadataEntity.setPrjct_name(editTextProjectName.getText().toString());
		metadataEntity.setPrjct_code(editTextProjectCode.getText().toString());
		metadataEntity.setPrjct_lead(editTextProjectLeader.getText().toString());
	}
	
	public void saveTab2() {
		EditText editTextStationStartNo = (EditText) activity.findViewById(R.id.metadata_editText_stationStartNo);

		metadataEntity.setStnstartno(editTextStationStartNo.getText().toString());
		metadataEntity.setPrj_type(pldb.getCol2("lutBEDMetadataPrjname", metadataEntity.getPrj_name()).get(1));
		metadataEntity.setPrj_datum(pldb.getCol3("lutBEDMetadataPrjname", metadataEntity.getPrj_name(), metadataEntity.getPrj_type()).get(1));
	}
	/*
    <<<--- APPLICATION --->>>
	private int nrcanId1;		<<<--- APP GENERATED
    
	<<<--- TAB 1 --->>>
    private String prjct_name;	<<<--- TEXT
    private String prjct_code;	<<<--- TEXT
    private String prjct_lead;	<<<--- TEXT
    private String prjct_type;	<<<--- PICKLIST
    
	<<<--- TAB 2 --->>>
    private String geologist;	<<<--- PICKLIST
    private String geolcode;	<<<--- PICKLIST
    private String prj_name;	<<<--- PICKLIST
    private String prj_type;	<<<--- PICKLIST / APP GENERATED
    private String prj_datum;	<<<--- PICKLIST / APP GENERATED
    private String digcamera;	<<<--- PICKLIST
    private String stnstartno;	<<<--- TEXT
    
    <<<--- UNKNOWN --->>>
    private String mappath;
    private String metaid;
	*/
}
