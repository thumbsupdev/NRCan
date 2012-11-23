package com.nrcan.controllers;

import java.util.ArrayList;

import com.nrcan.entities.PFlowSurficialEntity;
import com.nrcan.main.PicklistDatabaseHandler;
import com.nrcan.main.R;
import com.nrcan.models.PFlowSurficialModel;

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
	private Activity activity;
	private Context context;
	private int tab;
	
	private PicklistDatabaseHandler pldb;
	private PFlowSurficialEntity pflowSurficialEntity;
	
	public PFlowSurficialController(Context context, Activity activity,PFlowSurficialEntity pflowSurficialEntity,PicklistDatabaseHandler pldb) {
		this.mInflater = LayoutInflater.from(context);
		this.activity = activity;
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
				
				Spinner spinnerClass = (Spinner)convertView.findViewById(R.id.pflow_surficial_spinner_class);
				SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
				spinnerClass.setAdapter(sp1);
				sp1.setElements(pldb.getCol1("lutSURPflowPaleoflow"));
				spinnerClass.setAdapter(sp1);
				spinnerClass.setSelection(sp1.getPosition(pflowSurficialEntity.getPfClass()));
				spinnerClass.setOnItemSelectedListener(new OnItemSelectedListener() {
					public void onNothingSelected(AdapterView<?> arg0) {
						
					}

					public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
						
						String tmp = parent.getItemAtPosition(position).toString();
						if(!tmp.equalsIgnoreCase(pflowSurficialEntity.getPfClass()))
						{
							pflowSurficialEntity.setPfClass(tmp);
							pflowSurficialEntity.setPfFeature("");
						
							System.out.println(parent.getItemAtPosition(position));
							notifyDataSetChanged();
						}
						
						System.out.println(parent.getItemAtPosition(position));
					}
				});
				
				Spinner spinnerSense = (Spinner)convertView.findViewById(R.id.pflow_surficial_spinner_sense);
				SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
				spinnerSense.setAdapter(sp2);
				sp2.setElements(pldb.getCol1("lutSURPflowPFsense"));
				spinnerSense.setAdapter(sp2);
				spinnerSense.setSelection(sp2.getPosition(pflowSurficialEntity.getPfSense()));
				spinnerSense.setOnItemSelectedListener(new OnItemSelectedListener() {
					public void onNothingSelected(AdapterView<?> arg0) {
						
					}

					public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
						//earthmatbedrockModel.getEntity().setLithGroup("");
						pflowSurficialEntity.setPfSense(parent.getItemAtPosition(position).toString());
						System.out.println(parent.getItemAtPosition(position));
					}
				});
				
				Spinner spinnerFeature = (Spinner)convertView.findViewById(R.id.pflow_surficial_spinner_feature);
				SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
				spinnerFeature.setAdapter(sp3);
				sp3.setElements(pldb.getCol2("lutSURPflowPaleoflow",pflowSurficialEntity.getPfClass()));
				spinnerFeature.setAdapter(sp3);
				spinnerFeature.setSelection(sp3.getPosition(pflowSurficialEntity.getPfFeature()));
				spinnerFeature.setOnItemSelectedListener(new OnItemSelectedListener() {
					public void onNothingSelected(AdapterView<?> arg0) {
						
					}

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
				
				Button buttonFeature = (Button) convertView.findViewById(R.id.pflow_surficial_button_feature);
				buttonFeature.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						pflowSurficialEntity.setPfFeature("");
						notifyDataSetChanged();
					}
				});
				
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
				Spinner spinnerBedrockSurface = (Spinner)convertView.findViewById(R.id.pflow_surficial_spinner_bedrockSurface);
				SpinnerController sp4 = new SpinnerController(context, android.R.layout.simple_spinner_item);
				spinnerBedrockSurface.setAdapter(sp4);
				sp4.setElements(pldb.getCol1("lutSURPflowBedrocksurface"));
				spinnerBedrockSurface.setAdapter(sp4);
				//spinnerBedrockSurface.setSelection(sp4.getPosition(pflowSurficialEntity.get))
				spinnerBedrockSurface.setOnItemSelectedListener(new OnItemSelectedListener() {
					public void onNothingSelected(AdapterView<?> arg0) {
						
					}

					public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
						//earthmatbedrockModel.getEntity().setLithGroup("");
						System.out.println(parent.getItemAtPosition(position));
					}
				});
				
			}
			else if (tab == 2)
			{
				
				convertView = mInflater.inflate(R.layout.pflow_surficial_2, null);
				Spinner spinnerMethod = (Spinner)convertView.findViewById(R.id.pflow_surficial_spinner_method);
				SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
				spinnerMethod.setAdapter(sp1);
				sp1.setElements(pldb.getCol1("lutSURGeneralStrucMethod"));
				spinnerMethod.setAdapter(sp1);
				spinnerMethod.setSelection(sp1.getPosition(pflowSurficialEntity.getMethod()));
				spinnerMethod.setOnItemSelectedListener(new OnItemSelectedListener() {
					public void onNothingSelected(AdapterView<?> arg0) {
						
					}

					public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
						//earthmatbedrockModel.getEntity().setLithGroup("");
						pflowSurficialEntity.setMethod(parent.getItemAtPosition(position).toString());
						System.out.println(parent.getItemAtPosition(position));
					}
				});
				
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
				Spinner spinnerIndicators = (Spinner)convertView.findViewById(R.id.pflow_surficial_spinner_indicators);
				SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
				spinnerIndicators.setAdapter(sp2);
				sp2.setElements(pldb.getCol1("lutSURPflowNumindic"));
				spinnerIndicators.setAdapter(sp2);
				spinnerIndicators.setSelection(sp2.getPosition(pflowSurficialEntity.getNumIndic()));
				spinnerIndicators.setOnItemSelectedListener(new OnItemSelectedListener() {
					public void onNothingSelected(AdapterView<?> arg0) {
						
					}

					public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
						//earthmatbedrockModel.getEntity().setLithGroup("");
						pflowSurficialEntity.setNumIndic(parent.getItemAtPosition(position).toString());
						System.out.println(parent.getItemAtPosition(position));
					}
				});
				
				Spinner spinnerDefinition = (Spinner)convertView.findViewById(R.id.pflow_surficial_spinner_definition);
				SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
				spinnerDefinition.setAdapter(sp3);
				sp3.setElements(pldb.getCol1("lutSURPflowDefinition"));
				spinnerDefinition.setAdapter(sp3);
				spinnerDefinition.setSelection(sp3.getPosition(pflowSurficialEntity.getDefinition()));
				spinnerDefinition.setOnItemSelectedListener(new OnItemSelectedListener() {
					public void onNothingSelected(AdapterView<?> arg0) {
						
					}

					public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
						//earthmatbedrockModel.getEntity().setLithGroup("");
						pflowSurficialEntity.setDefinition(parent.getItemAtPosition(position).toString());
						System.out.println(parent.getItemAtPosition(position));
					}
				});
				
				Spinner spinnerRelationship = (Spinner)convertView.findViewById(R.id.pflow_surficial_spinner_relationship);
				SpinnerController sp4 = new SpinnerController(context, android.R.layout.simple_spinner_item);
				spinnerRelationship.setAdapter(sp4);
				sp4.setElements(pldb.getCol1("lutSURPflowRelation"));
				spinnerRelationship.setAdapter(sp4);
				spinnerRelationship.setSelection(sp4.getPosition(pflowSurficialEntity.getRelation()));
				spinnerRelationship.setOnItemSelectedListener(new OnItemSelectedListener() {
					public void onNothingSelected(AdapterView<?> arg0) {
						
					}

					public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
						//earthmatbedrockModel.getEntity().setLithGroup("");
						pflowSurficialEntity.setRelation(parent.getItemAtPosition(position).toString());
						System.out.println(parent.getItemAtPosition(position));
					}
				});
				
				
			}
			else if (tab == 3)
			{
				
				convertView = mInflater.inflate(R.layout.pflow_surficial_3, null);
				
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
				return false;
			}
			
		}
		this.tab = tabNum;
		notifyDataSetChanged();
		return true;
	}


	
}


