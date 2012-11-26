package com.nrcan.controllers;

import com.nrcan.entities.SampleBedrockEntity;
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
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.Spinner;

public class SampleBedrockController extends BaseAdapter implements Filterable {
	private LayoutInflater mInflater;
	//private Activity activity;
	private Context context;
	private int tab;
	private PicklistDatabaseHandler pldb;
	private SampleBedrockEntity sampleBedrockEntity;

	public SampleBedrockController(Context context, Activity activity, SampleBedrockEntity sampleBedrockEntity, PicklistDatabaseHandler pldb) {
		this.mInflater = LayoutInflater.from(context);
		//this.activity = activity;
		this.context = context;
		this.tab = 1;
		this.pldb = pldb;
		this.sampleBedrockEntity = sampleBedrockEntity;
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
			convertView = mInflater.inflate(R.layout.sample_bedrock_1, null);
			
			/////////////////////////////////////
			// SPINNER TYPE
			//
			// Drop-down for "Type" - Column 1 of lutBEDSampleType Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (1/4)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerType = (Spinner) convertView.findViewById(R.id.sample_bedrock_spinner_type);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutBEDSampleType"));
			sp1.setNewElement(pldb, "lutBEDSampleType", 1, null, null);
			sp1.addSpace();
			spinnerType.setAdapter(sp1);
			spinnerType.setSelection(sp1.getPosition(sampleBedrockEntity.getSampleType()));
			spinnerType.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					sampleBedrockEntity.setSampleType(parent.getItemAtPosition(position).toString());
				}
			});
			
			/////////////////////////////////////
			// CONCAT SPINNER PURPOSE
			//
			// Drop-down for "Purpose" - Column 1 of lutBEDSamplePurpose Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (2/4)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerPurpose = (Spinner) convertView.findViewById(R.id.sample_bedrock_spinner_purpose);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp2.setElements(pldb.getCol1("lutBEDSamplePurpose"));
			sp2.setNewElement(pldb, "lutBEDSamplePurpose", 1, null, null);
			sp2.addSpace();
			spinnerPurpose.setAdapter(sp2);
			spinnerPurpose.setSelection(sp2.getPosition(sampleBedrockEntity.getPurpose()));
			spinnerPurpose.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					String tmp = sampleBedrockEntity.getPurpose();
					String sel = parent.getItemAtPosition(position).toString();
					if(!tmp.contains(sel))
					{
						if(tmp.length() > 1)
							sampleBedrockEntity.setPurpose(tmp + " | " + sel);
						else
							sampleBedrockEntity.setPurpose(sel);
						
						notifyDataSetChanged();
					}
				}
			});
			
			/////////////////////////////////////
			// CONCAT EDITTEXT PURPOSE
			//
			// Text field concatenates selections from SPINNER PURPOSE
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (3/4)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextPurpose = (EditText) convertView.findViewById(R.id.sample_bedrock_text_purpose);
			editTextPurpose.setText(sampleBedrockEntity.getPurpose());
			editTextPurpose.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						sampleBedrockEntity.setPurpose("");
					else
						sampleBedrockEntity.setPurpose(s.toString());
				}
			});
			
			/////////////////////////////////////
			// CONCAT BUTTON PURPOSE
			//
			// Button clears EDITTEXT PURPOSE text field
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (4/4)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Button buttonPurpose = (Button) convertView.findViewById(R.id.sample_bedrock_button_purpose);
			buttonPurpose.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					sampleBedrockEntity.setPurpose("");
					notifyDataSetChanged();
				}
			});
			
		} else if (tab == 2) {
			convertView = mInflater.inflate(R.layout.sample_bedrock_2, null);
			
			/////////////////////////////////////
			// SPINNER FORMAT
			//
			// Drop-down for "Format" - Column 1 of lutBEDGeneralStrucFormat Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 2 - ELEMENT (1/4)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerFormat = (Spinner) convertView.findViewById(R.id.sample_bedrock_spinner_format);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutBEDGeneralStrucFormat"));
			sp1.setNewElement(pldb, "lutBEDGeneralStrucFormat", 1, null, null);
			sp1.addSpace();
			spinnerFormat.setAdapter(sp1);
			spinnerFormat.setSelection(sp1.getPosition(sampleBedrockEntity.getFormat()));
			spinnerFormat.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					sampleBedrockEntity.setFormat(parent.getItemAtPosition(position).toString());
				}
			});

			/////////////////////////////////////
			// EDITTEXT AZIMUTH
			//
			// Text field for "Azimuth"
			/////////////////////////////////////
			// VERIFIED - TAB 2 - ELEMENT (2/4)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextAzimuth = (EditText) convertView.findViewById(R.id.sample_bedrock_editText_azimuth);
			editTextAzimuth.setText(sampleBedrockEntity.getAzimuth());
			editTextAzimuth.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						sampleBedrockEntity.setAzimuth("");
					else
						sampleBedrockEntity.setAzimuth(s.toString());
				}
			});

			/////////////////////////////////////
			// EDITTEXT DIP/PLUNGE
			//
			// Text field for "Dip/Plunge"
			/////////////////////////////////////
			// VERIFIED - TAB 2 - ELEMENT (3/4)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextDipPlunge = (EditText) convertView.findViewById(R.id.sample_bedrock_editText_dipPlunge);
			editTextDipPlunge.setText(sampleBedrockEntity.getDipplunge());
			editTextDipPlunge.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						sampleBedrockEntity.setDipplunge("");
					else
						sampleBedrockEntity.setDipplunge(s.toString());
				}
			});

			/////////////////////////////////////
			// SPINNER SURFACE
			//
			// Drop-down for "Surface" - Column 1 of lutBEDSampleSurface Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 2 - ELEMENT (4/4)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerSurface = (Spinner) convertView.findViewById(R.id.sample_bedrock_spinner_surface);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp2.setElements(pldb.getCol1("lutBEDSampleSurface"));
			sp2.setNewElement(pldb, "lutBEDSampleSurface", 1, null, null);
			sp2.addSpace();
			spinnerSurface.setAdapter(sp2);
			spinnerSurface.setSelection(sp2.getPosition(sampleBedrockEntity.getSurface()));
			spinnerSurface.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {}
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					sampleBedrockEntity.setSurface(parent.getItemAtPosition(position).toString());
				}
			});
			
		} else if (tab == 3) {
			convertView = mInflater.inflate(R.layout.sample_bedrock_3, null);

			/////////////////////////////////////
			// EDITTEXT NOTES (254)
			//
			// Text field for "Notes"
			/////////////////////////////////////
			// VERIFIED - TAB 3 - ELEMENT (1/1)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextNote = (EditText) convertView.findViewById(R.id.sample_bedrock_text_note);
			editTextNote.setText(sampleBedrockEntity.getNotes());
			editTextNote.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						sampleBedrockEntity.setNotes("");
					else
						sampleBedrockEntity.setNotes(s.toString());
				}
			});
		}
		
		return convertView;
	}
	
	public Filter getFilter() {
		return null;
	}

	public boolean setTab(int tabNum) {
		if(this.tab == 1) {
			if(sampleBedrockEntity.getPurpose().equalsIgnoreCase("")) {
				return false;
			}
		}
		this.tab = tabNum;
		notifyDataSetChanged();
		return true;
	}
	
	public void clear() {
		sampleBedrockEntity.clearEntity();
		tab = 1;
		notifyDataSetChanged();
	
	}
}
