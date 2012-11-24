package com.nrcan.controllers;


import com.nrcan.entities.PFlowSurficialEntity;
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
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class PFlowSurficialController  extends BaseAdapter implements Filterable {
	private LayoutInflater mInflater;
	//private Activity activity;
	private Context context;
	private int tab;
	
	private PicklistDatabaseHandler pldb;
	private PFlowSurficialEntity pflowSurficialEntity;
	
	public PFlowSurficialController(Context context, Activity activity,PFlowSurficialEntity pflowSurficialEntity,PicklistDatabaseHandler pldb) {
		this.mInflater = LayoutInflater.from(context);
		//this.activity = activity;
		this.context = context;
		this.tab = 1;
		this.pldb = pldb;
		
		this.pflowSurficialEntity = pflowSurficialEntity;
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
			if(tab == 1)
			{
				convertView = mInflater.inflate(R.layout.pflow_surficial_1, null);
				
				
				/////////////////////////////////////
				// SPINNER CLASS
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
				Spinner spinnerClass = (Spinner)convertView.findViewById(R.id.pflow_surficial_spinner_class);
				SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
				sp1.setElements(pldb.getCol1("lutSURPflowPaleoflow"));
				sp1.setNewElement(pldb, "lutSURPflowPaleoflow", 1, null, null);
				sp1.addSpace();
				spinnerClass.setAdapter(sp1);
				spinnerClass.setSelection(sp1.getPosition(pflowSurficialEntity.getPfClass()));
				spinnerClass.setOnItemSelectedListener(new OnItemSelectedListener() {
					public void onNothingSelected(AdapterView<?> arg0) {}
					public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
						String tmp = parent.getItemAtPosition(position).toString();
						if(!tmp.equalsIgnoreCase(pflowSurficialEntity.getPfClass()))
						{
							pflowSurficialEntity.setPfClass(tmp);
							pflowSurficialEntity.setPfFeature("");
							notifyDataSetChanged();
						}
					}
				});
				
				/////////////////////////////////////
				// SPINNER SENSE
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
				Spinner spinnerSense = (Spinner)convertView.findViewById(R.id.pflow_surficial_spinner_sense);
				SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
				sp2.setElements(pldb.getCol1("lutSURPflowPFsense"));
				sp2.setNewElement(pldb, "lutSURPflowPFsense", 1, null, null);
				sp2.addSpace();
				spinnerSense.setAdapter(sp2);
				spinnerSense.setSelection(sp2.getPosition(pflowSurficialEntity.getPfSense()));
				spinnerSense.setOnItemSelectedListener(new OnItemSelectedListener() {
					public void onNothingSelected(AdapterView<?> arg0) {}
					public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
						pflowSurficialEntity.setPfSense(parent.getItemAtPosition(position).toString());
					}
				});
				
				/////////////////////////////////////
				// CONCAT SPINNER FEAUTRE
				//
				// DESCRIPTION
				/////////////////////////////////////
				// VERIFIED - TAB 1 - ELEMENT (3/6)
				/////////////////////////////////////
				// [] JORDAN KUROSKY
				// [] JAMIE POSPIECH
				// [] DEREK ELLIOTT
				// [] PIERRE LAFOREST-GRANT
				// [X] ALEX YEUNG
				/////////////////////////////////////
				Spinner spinnerFeature = (Spinner)convertView.findViewById(R.id.pflow_surficial_spinner_feature);
				SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
				sp3.setElements(pldb.getCol2("lutSURPflowPaleoflow",pflowSurficialEntity.getPfClass()));
				sp3.setNewElement(pldb, "lutSURPflowPaleoflow", 2, pflowSurficialEntity.getPfClass(), null);
				sp3.addSpace();
				spinnerFeature.setAdapter(sp3);
				spinnerFeature.setSelection(sp3.getPosition(pflowSurficialEntity.getPfFeature()));
				spinnerFeature.setOnItemSelectedListener(new OnItemSelectedListener() {
					public void onNothingSelected(AdapterView<?> arg0) {}
					public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
						String tmp = pflowSurficialEntity.getPfFeature();
						String sel = parent.getItemAtPosition(position).toString();
						if(!tmp.contains(sel))
						{
							if(tmp.length() > 1)
								pflowSurficialEntity.setPfFeature(tmp + " | " + sel);
							else
								pflowSurficialEntity.setPfFeature(sel);
							
							notifyDataSetChanged();
						}
					}
				});
				
				/////////////////////////////////////
				// CONCAT EDITTEXT FEATURE
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
				EditText editTextFeature = (EditText)convertView.findViewById(R.id.pflow_surficial_text_feature);
				editTextFeature.setText(pflowSurficialEntity.getPfFeature());
				editTextFeature.addTextChangedListener(new TextWatcher() {
					public void onTextChanged(CharSequence s, int start, int before, int count) { }
					public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
					public void afterTextChanged(Editable s) {
						if (s.length() == 0)
							pflowSurficialEntity.setPfFeature("");
						else
							pflowSurficialEntity.setPfFeature(s.toString());
					}
				});
				
				/////////////////////////////////////
				// CONCAT BUTTON FEATURE CLEAR
				//
				// DESCRIPTION
				/////////////////////////////////////
				// VERIFIED - TAB 1 - ELEMENT (5/6)
				/////////////////////////////////////
				// [] JORDAN KUROSKY
				// [] JAMIE POSPIECH
				// [] DEREK ELLIOTT
				// [] PIERRE LAFOREST-GRANT
				// [] ALEX YEUNG
				/////////////////////////////////////
				Button buttonFeature = (Button) convertView.findViewById(R.id.pflow_surficial_button_feature);
				buttonFeature.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						pflowSurficialEntity.setPfFeature("");
						notifyDataSetChanged();
					}
				});
				
		
				
				/////////////////////////////////////
				// SPINNER BEDROCK SURFACE
				//
				// DESCRIPTION
				/////////////////////////////////////
				// VERIFIED - TAB 1 - ELEMENT (6/6)
				/////////////////////////////////////
				// [] JORDAN KUROSKY
				// [] JAMIE POSPIECH
				// [] DEREK ELLIOTT
				// [] PIERRE LAFOREST-GRANT
				// [] ALEX YEUNG
				/////////////////////////////////////
				Spinner spinnerBedrockSurface = (Spinner)convertView.findViewById(R.id.pflow_surficial_spinner_bedrockSurface);
				SpinnerController sp4 = new SpinnerController(context, android.R.layout.simple_spinner_item);
				sp4.setElements(pldb.getCol1("lutSURPflowBedrocksurface"));
				sp4.setNewElement(pldb, "lutSURPflowBedrocksurface", 1, null, null);
				sp4.addSpace();
				spinnerBedrockSurface.setAdapter(sp4);
				spinnerBedrockSurface.setSelection(sp4.getPosition(pflowSurficialEntity.getNotes_1()));
				spinnerBedrockSurface.setOnItemSelectedListener(new OnItemSelectedListener() {
					public void onNothingSelected(AdapterView<?> arg0) {}
					public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
						pflowSurficialEntity.setNotes_1(parent.getItemAtPosition(position).toString());
					}
				});
				
			}
			else if (tab == 2)
			{
				convertView = mInflater.inflate(R.layout.pflow_surficial_2, null);
				
				/////////////////////////////////////
				// SPINNER METHOD
				//
				// DESCRIPTION
				/////////////////////////////////////
				// VERIFIED - TAB 2 - ELEMENT (1/6)
				/////////////////////////////////////
				// [] JORDAN KUROSKY
				// [] JAMIE POSPIECH
				// [] DEREK ELLIOTT
				// [] PIERRE LAFOREST-GRANT
				// [X] ALEX YEUNG
				/////////////////////////////////////
				Spinner spinnerMethod = (Spinner)convertView.findViewById(R.id.pflow_surficial_spinner_method);
				SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
				sp1.setElements(pldb.getCol1("lutSURGeneralStrucMethod"));
				sp1.setNewElement(pldb, "lutSURGeneralStrucMethod", 1, null, null);
				sp1.addSpace();
				spinnerMethod.setAdapter(sp1);
				spinnerMethod.setSelection(sp1.getPosition(pflowSurficialEntity.getMethod()));
				spinnerMethod.setOnItemSelectedListener(new OnItemSelectedListener() {
					public void onNothingSelected(AdapterView<?> arg0) {}
					public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
						pflowSurficialEntity.setMethod(parent.getItemAtPosition(position).toString());
					}
				});
				
				/////////////////////////////////////
				// EDITTEXT AZIMUTH
				//
				// DESCRIPTION
				/////////////////////////////////////
				// VERIFIED - TAB 2 - ELEMENT (2/6)
				/////////////////////////////////////
				// [] JORDAN KUROSKY
				// [] JAMIE POSPIECH
				// [] DEREK ELLIOTT
				// [] PIERRE LAFOREST-GRANT
				// [X] ALEX YEUNG
				/////////////////////////////////////
				EditText editTextAzimuth = (EditText)convertView.findViewById(R.id.pflow_surficial_text_azimuth);
				editTextAzimuth.setText(pflowSurficialEntity.getPfAzimuth());
				editTextAzimuth.addTextChangedListener(new TextWatcher() {
					public void onTextChanged(CharSequence s, int start, int before, int count) { }
					public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
					public void afterTextChanged(Editable s) {
						if (s.length() == 0)
							pflowSurficialEntity.setPfAzimuth("");
						else
							pflowSurficialEntity.setPfAzimuth(s.toString());
					}
				});
				
				/////////////////////////////////////
				// EDITTEXT RELATIVE AGE
				//
				// DESCRIPTION
				/////////////////////////////////////
				// VERIFIED - TAB 2 - ELEMENT (3/6)
				/////////////////////////////////////
				// [] JORDAN KUROSKY
				// [] JAMIE POSPIECH
				// [] DEREK ELLIOTT
				// [] PIERRE LAFOREST-GRANT
				// [X] ALEX YEUNG
				/////////////////////////////////////
				EditText editTextAge = (EditText)convertView.findViewById(R.id.pflow_surficial_editText_age);
				editTextAge.setText(pflowSurficialEntity.getRelage());
				editTextAge.addTextChangedListener(new TextWatcher() {
					public void onTextChanged(CharSequence s, int start, int before, int count) { }
					public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
					public void afterTextChanged(Editable s) {
						if (s.length() == 0)
							pflowSurficialEntity.setRelage("");
						else
							pflowSurficialEntity.setRelage(s.toString());
					}
				});
				
				/////////////////////////////////////
				// SPINNER NUM INDICATORS
				//
				// DESCRIPTION
				/////////////////////////////////////
				// VERIFIED - TAB 2 - ELEMENT (4/6)
				/////////////////////////////////////
				// [] JORDAN KUROSKY
				// [] JAMIE POSPIECH
				// [] DEREK ELLIOTT
				// [] PIERRE LAFOREST-GRANT
				// [X] ALEX YEUNG
				/////////////////////////////////////
				Spinner spinnerIndicators = (Spinner)convertView.findViewById(R.id.pflow_surficial_spinner_indicators);
				SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
				sp2.setElements(pldb.getCol1("lutSURPflowNumindic"));
				sp2.setNewElement(pldb, "lutSURPflowNumindic", 1, null, null);
				sp2.addSpace();
				spinnerIndicators.setAdapter(sp2);
				spinnerIndicators.setSelection(sp2.getPosition(pflowSurficialEntity.getNumIndic()));
				spinnerIndicators.setOnItemSelectedListener(new OnItemSelectedListener() {
					public void onNothingSelected(AdapterView<?> arg0) {}
					public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
						pflowSurficialEntity.setNumIndic(parent.getItemAtPosition(position).toString());
					}
				});
				
				/////////////////////////////////////
				// SPINNER DEFINITION
				//
				// DESCRIPTION
				/////////////////////////////////////
				// VERIFIED - TAB 2 - ELEMENT (5/6)
				/////////////////////////////////////
				// [] JORDAN KUROSKY
				// [] JAMIE POSPIECH
				// [] DEREK ELLIOTT
				// [] PIERRE LAFOREST-GRANT
				// [X] ALEX YEUNG
				/////////////////////////////////////
				Spinner spinnerDefinition = (Spinner)convertView.findViewById(R.id.pflow_surficial_spinner_definition);
				SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
				sp3.setElements(pldb.getCol1("lutSURPflowDefinition"));
				sp3.setNewElement(pldb, "lutSURPflowDefinition", 1, null, null);
				sp3.addSpace();
				spinnerDefinition.setAdapter(sp3);
				spinnerDefinition.setSelection(sp3.getPosition(pflowSurficialEntity.getDefinition()));
				spinnerDefinition.setOnItemSelectedListener(new OnItemSelectedListener() {
					public void onNothingSelected(AdapterView<?> arg0) {}
					public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
						pflowSurficialEntity.setDefinition(parent.getItemAtPosition(position).toString());
					}
				});
				
				/////////////////////////////////////
				// SPINNER RELATIONSHIP
				//
				// DESCRIPTION
				/////////////////////////////////////
				// VERIFIED - TAB 2 - ELEMENT (6/6)
				/////////////////////////////////////
				// [] JORDAN KUROSKY
				// [] JAMIE POSPIECH
				// [] DEREK ELLIOTT
				// [] PIERRE LAFOREST-GRANT
				// [X] ALEX YEUNG
				/////////////////////////////////////
				Spinner spinnerRelationship = (Spinner)convertView.findViewById(R.id.pflow_surficial_spinner_relationship);
				SpinnerController sp4 = new SpinnerController(context, android.R.layout.simple_spinner_item);
				sp4.setElements(pldb.getCol1("lutSURPflowRelation"));
				sp4.setNewElement(pldb, "lutSURPflowRelation", 1, null, null);
				sp4.addSpace();
				spinnerRelationship.setAdapter(sp4);
				spinnerRelationship.setSelection(sp4.getPosition(pflowSurficialEntity.getRelation()));
				spinnerRelationship.setOnItemSelectedListener(new OnItemSelectedListener() {
					public void onNothingSelected(AdapterView<?> arg0) {}
					public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
						pflowSurficialEntity.setRelation(parent.getItemAtPosition(position).toString());
					}
				});
			}
			else if (tab == 3)
			{
				convertView = mInflater.inflate(R.layout.pflow_surficial_3, null);
				
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
				EditText editTextNote = (EditText)convertView.findViewById(R.id.pflow_surficial_text_note);
				editTextNote.setText(pflowSurficialEntity.getNotes());
				editTextNote.addTextChangedListener(new TextWatcher() {
					public void onTextChanged(CharSequence s, int start, int before, int count) { }
					public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
					public void afterTextChanged(Editable s) {
						if (s.length() == 0)
							pflowSurficialEntity.setNotes("");
						else
							pflowSurficialEntity.setNotes(s.toString());
					}
				});
			}
		
		return convertView;
	}

	public Filter getFilter() {
		return null;
	}

	public boolean setTab(int tabNum) {

		if(this.tab == 2){
			if(pflowSurficialEntity.getPfAzimuth().equalsIgnoreCase("")){
				//return false;
			}
			
		}
		this.tab = tabNum;
		notifyDataSetChanged();
		return true;
	}


	
}


