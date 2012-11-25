package com.nrcan.controllers;

import com.nrcan.entities.MetadataEntity;
import com.nrcan.main.PicklistDatabaseHandler;
import com.nrcan.main.R;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
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

	public MetadataController(Context context, Activity activity, MetadataEntity metadataEntity, PicklistDatabaseHandler pldb) {
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
			
			
			/////////////////////////////////////
			// EDITTEXT PROJECT NAME
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (1/4)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextProjectName = (EditText) convertView.findViewById(R.id.metadata_editText_projectName);
			editTextProjectName.setText(metadataEntity.getPrjct_name());
			editTextProjectName.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						metadataEntity.setPrjct_name("");
					else
						metadataEntity.setPrjct_name(s.toString());
				}
			});
			
			/////////////////////////////////////
			// EDITTEXT PROJECT CODE
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (2/4)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextProjectCode = (EditText) convertView.findViewById(R.id.metadata_editText_projectCode);
			editTextProjectCode.setText(metadataEntity.getPrjct_code());
			editTextProjectCode.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						metadataEntity.setPrjct_code("");
					else
						metadataEntity.setPrjct_code(s.toString());
				}
			});
			
			/////////////////////////////////////
			//  EDITTEXT PROJECT LEADER
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (3/4)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextProjectLeader = (EditText) convertView.findViewById(R.id.metadata_editText_projectLeader);
			editTextProjectLeader.setText(metadataEntity.getPrjct_lead());
			editTextProjectLeader.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						metadataEntity.setPrjct_lead("");
					else
						metadataEntity.setPrjct_lead(s.toString());
				}
			});
			
			/////////////////////////////////////
			// SPINNER PROJECT TYPE
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (4/4)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerProjectType = (Spinner) convertView.findViewById(R.id.metadata_spinner_projectType);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutMetadataPrjctType"));
			//sp1.setNewElement(pldb, "lutMetadataPrjctType", 1, null, null);
			sp1.addSpace();
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
			
			/////////////////////////////////////
			// SPINNER GEOLOGIST NAME
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 2 - ELEMENT (1/5)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerGeologistName = (Spinner) convertView.findViewById(R.id.metadata_spinner_geologistName);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutMetadataGeologist"));
			sp1.setNewElement(pldb, "lutMetadataGeologist", 1, null, null);
			sp1.addSpace();
			spinnerGeologistName.setAdapter(sp1);
			spinnerGeologistName.setSelection(sp1.getPosition(metadataEntity.getGeologist()));
			spinnerGeologistName.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					String tmp = parent.getItemAtPosition(position).toString();
					if(!tmp.equalsIgnoreCase(metadataEntity.getGeologist()))
					{
						metadataEntity.setGeologist(tmp);
						metadataEntity.setGeolcode("");
						notifyDataSetChanged();
					}
				}
			});
			
			/////////////////////////////////////
			// SPINNER GEOLOGIST CODE
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 2 - ELEMENT (2/5)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerGeologistCode = (Spinner) convertView.findViewById(R.id.metadata_spinner_geologistCode);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp2.setElements(pldb.getCol2("lutMetadataGeologist", metadataEntity.getGeologist()));
			sp2.setNewElement(pldb, "lutMetadataGeologist", 2, metadataEntity.getGeologist(), null);
			sp2.addSpace();
			spinnerGeologistCode.setAdapter(sp2);
			spinnerGeologistCode.setSelection(sp2.getPosition(metadataEntity.getGeolcode()));
			spinnerGeologistCode.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					metadataEntity.setGeolcode(parent.getItemAtPosition(position).toString());
				}
			});
			
			/////////////////////////////////////
			// 
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 2 - ELEMENT (3/5)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerCameraPrefix = (Spinner) convertView.findViewById(R.id.metadata_spinner_cameraPrefix);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp3.setElements(pldb.getCol1("lutMetadataDigcamera"));
			sp3.setNewElement(pldb, "lutMetadataDigcamera", 1, null, null);
			sp3.addSpace();
			spinnerCameraPrefix.setAdapter(sp3);
			spinnerCameraPrefix.setSelection(sp3.getPosition(metadataEntity.getDigcamera()));
			spinnerCameraPrefix.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					metadataEntity.setDigcamera(parent.getItemAtPosition(position).toString());
				}
			});
			
			/////////////////////////////////////
			// SPINNER MAP PROJECTION
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 2 - ELEMENT (4/5)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerMapProjection = (Spinner) convertView.findViewById(R.id.metadata_spinner_selectMapProjection);
			SpinnerController sp4 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp4.setElements(pldb.getCol1("lutMetadataPrjname"));
			sp4.setNewElement(pldb, "lutMetadataPrjname", 1, null, null);
			sp4.addSpace();
			spinnerMapProjection.setAdapter(sp4);
			spinnerMapProjection.setSelection(sp4.getPosition(metadataEntity.getPrj_name()));
			spinnerMapProjection.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					metadataEntity.setPrj_name(parent.getItemAtPosition(position).toString());
					metadataEntity.setPrj_type(pldb.getCol2("lutMetadataPrjname", metadataEntity.getPrj_name()).get(1));
					metadataEntity.setPrj_datum(pldb.getCol3("lutMetadataPrjname", metadataEntity.getPrj_name(), metadataEntity.getPrj_type()).get(1));
				}
			});
			
			/////////////////////////////////////
			// EDITTEXT STATION START NO
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 2 - ELEMENT (5/5)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextStationStartNo = (EditText) convertView.findViewById(R.id.metadata_editText_stationStartNo);
			editTextStationStartNo.setText(metadataEntity.getStnstartno());
			editTextStationStartNo.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						metadataEntity.setStnstartno("");
					else
						metadataEntity.setStnstartno(s.toString());
				}
			});
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
