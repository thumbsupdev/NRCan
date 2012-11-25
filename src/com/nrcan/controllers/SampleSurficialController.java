package com.nrcan.controllers;

import com.nrcan.entities.SampleSurficialEntity;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class SampleSurficialController extends BaseAdapter implements
		Filterable {
	private LayoutInflater mInflater;
	//private Activity activity;
	private Context context;
	private int tab;
	private PicklistDatabaseHandler pldb;
	
	private SampleSurficialEntity sampleSurficialEntity;

	public SampleSurficialController(Context context, Activity activity,SampleSurficialEntity sampleSurficialEntity,PicklistDatabaseHandler pldb) {
		this.mInflater = LayoutInflater.from(context);
		//this.activity = activity;
		this.context = context;
		this.tab = 1;
		
		this.sampleSurficialEntity = sampleSurficialEntity;
		this.pldb = pldb;
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
			
			convertView = mInflater.inflate(R.layout.sample_surficial1, null);
			
			
			/////////////////////////////////////
			// SPINNER TYPE
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (1/6)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerType = (Spinner) convertView.findViewById(R.id.sample_surficial_spinner_type);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutSURSampleType"));
			sp1.setNewElement(pldb, "lutSURSampleType", 1, null, null);
			sp1.addSpace();
			spinnerType.setAdapter(sp1);
			spinnerType.setSelection(sp1.getPosition(sampleSurficialEntity.getSampleType()));
			spinnerType.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {}
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					sampleSurficialEntity.setSampleType(parent.getItemAtPosition(position).toString());
				}
			});
			
			/////////////////////////////////////
			// CONCAT SPINNER PURPOSE
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (2/6)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerPurpose = (Spinner) convertView.findViewById(R.id.sample_surficial_spinner_purpose);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp2.setElements(pldb.getCol1("lutSURSamplePurpose"));
			sp2.setNewElement(pldb, "lutSURSamplePurpose", 1, null, null);
			sp2.addSpace();
			spinnerPurpose.setAdapter(sp2);
			spinnerPurpose.setSelection(sp2.getPosition(sampleSurficialEntity.getPurpose()));
			spinnerPurpose.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {}
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					String tmp = sampleSurficialEntity.getPurpose();
					String sel = parent.getItemAtPosition(position).toString();
					if(!tmp.contains(sel))
					{
						if(tmp.length() > 1)
							sampleSurficialEntity.setPurpose(tmp + " | " + sel);
						else
							sampleSurficialEntity.setPurpose(sel);
						
						notifyDataSetChanged();
					}
				}
			});
			
			/////////////////////////////////////
			// SPINNER 
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (3/6)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextPurpose = (EditText) convertView.findViewById(R.id.sample_surficial_editText_purpose);
			editTextPurpose.setText(sampleSurficialEntity.getPurpose());
			editTextPurpose.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						sampleSurficialEntity.setPurpose("");
					else
						sampleSurficialEntity.setPurpose(s.toString());
				}
			});
			
			/////////////////////////////////////
			// CONCAT BUTTON PURPOSE
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (4/6)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			Button buttonPurpose = (Button) convertView.findViewById(R.id.sample_surficial_button_purpose);
			buttonPurpose.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					sampleSurficialEntity.setPurpose("");
					notifyDataSetChanged();
				}
			});
			
			
			
			/////////////////////////////////////
			// EDITTEXT HORIZON
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (1/6)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextHorizon = (EditText) convertView.findViewById(R.id.sample_surficial_editText_horizon);
			editTextHorizon.setText(sampleSurficialEntity.getHorizon());
			editTextHorizon.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						sampleSurficialEntity.setHorizon("");
					else
						sampleSurficialEntity.setHorizon(s.toString());
				}
			});
			
			/////////////////////////////////////
			// EDITTEXT DEPTH
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (6/6)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextDepth = (EditText) convertView.findViewById(R.id.sample_surficial_editText_depthInterval);
			editTextDepth.setText(sampleSurficialEntity.getSampleDep());
			editTextDepth.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						sampleSurficialEntity.setSampleDep("");
					else
						sampleSurficialEntity.setSampleDep(s.toString());
				}
			});

			
		} else if (tab == 2) {
			
			convertView = mInflater.inflate(R.layout.sample_surficial2, null);
			
			/////////////////////////////////////
			// SPINNER SAMPLE STATE
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
			Spinner spinnerSampleState = (Spinner) convertView.findViewById(R.id.sample_surficial_spinner_sampleState);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutSURSampleState"));
			sp1.setNewElement(pldb, "lutSURSampleState", 1, null, null);
			sp1.addSpace();
			spinnerSampleState.setAdapter(sp1);
			spinnerSampleState.setSelection(sp1.getPosition(sampleSurficialEntity.getState()));
			spinnerSampleState.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {}
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					sampleSurficialEntity.setState(parent.getItemAtPosition(position).toString());
				}
			});
			
			/////////////////////////////////////
			// SPINNER FORMAT
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 2 - ELEMENT (2/5)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerFormat = (Spinner) convertView.findViewById(R.id.sample_surficial_spinner_format);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp2.setElements(pldb.getCol1("lutSURGeneralStrucFormat"));
			sp2.setNewElement(pldb, "lutSURGeneralStrucFormat", 1, null, null);
			sp2.addSpace();
			spinnerFormat.setAdapter(sp2);
			spinnerFormat.setSelection(sp2.getPosition(sampleSurficialEntity.getFormat()));
			spinnerFormat.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {}
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					sampleSurficialEntity.setFormat(parent.getItemAtPosition(position).toString());
				}
			});
			
			/////////////////////////////////////
			// EDITTEXT AZIMUTH
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
			EditText editTextAzimuth = (EditText) convertView.findViewById(R.id.sample_surficial_editText_azimuth);
			editTextAzimuth.setText(sampleSurficialEntity.getAzimuth());
			editTextAzimuth.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						sampleSurficialEntity.setAzimuth("");
					else
						sampleSurficialEntity.setAzimuth(s.toString());
				}
			});
			
			/////////////////////////////////////
			// EDITTEXT DIP/PLUNGE
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (4/5)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextDipPlunge = (EditText) convertView.findViewById(R.id.sample_surficial_editText_dipPlunge);
			editTextDipPlunge.setText(sampleSurficialEntity.getDipplunge());
			editTextDipPlunge.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						sampleSurficialEntity.setDipplunge("");
					else
						sampleSurficialEntity.setDipplunge(s.toString());
				}
			});
			
			/////////////////////////////////////
			// SPINNER SURFACE
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (5/5)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerSurface = (Spinner) convertView.findViewById(R.id.sample_surficial_spinner_surface);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp3.setElements(pldb.getCol1("lutSURSampleSurface"));
			sp3.setNewElement(pldb, "lutSURSampleSurface", 1, null, null);
			sp3.addSpace();
			spinnerSurface.setAdapter(sp3);
			spinnerSurface.setSelection(sp3.getPosition(sampleSurficialEntity.getSurface()));
			spinnerSurface.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {}
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					sampleSurficialEntity.setSurface(parent.getItemAtPosition(position).toString());
				}
			});
		} else if (tab == 3) {
			convertView = mInflater.inflate(R.layout.sample_surficial3, null);
			
			/////////////////////////////////////
			// NOTES
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 3 - ELEMENT (1/1)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextNotes = (EditText) convertView.findViewById(R.id.sample_surficial_editText_notes);
			editTextNotes.setText(sampleSurficialEntity.getNotes());
			editTextNotes.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						sampleSurficialEntity.setNotes("");
					else
						sampleSurficialEntity.setNotes(s.toString());
				}
			});
		} 

		return convertView;
	}

	public Filter getFilter() {
		return null;
	}

	public boolean setTab(int tabNum) {
		if(this.tab == 1){
			if(sampleSurficialEntity.getPurpose().equalsIgnoreCase("")){
				return false;
			}
			
		}
		this.tab = tabNum;
		notifyDataSetChanged();
		return true;
	}
	
	public void clear() {
		sampleSurficialEntity.clearEntity();
		tab = 1;
		notifyDataSetChanged();
	
	}
	
}
