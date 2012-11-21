package com.nrcan.controllers;

import java.util.ArrayList;

import com.nrcan.main.PicklistDatabaseHandler;
import com.nrcan.main.R;
import com.nrcan.models.PFlowSurficialModel;

import android.app.Activity;
import android.content.Context;
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
	private PFlowSurficialModel pflowSurficialModel;
	private PicklistDatabaseHandler pldb;
	private ArrayList<String> e = new ArrayList<String>();
	
	public PFlowSurficialController(Context context, Activity activity,PFlowSurficialModel pflowSurficialModel,PicklistDatabaseHandler pldb) {
		this.mInflater = LayoutInflater.from(context);
		this.activity = activity;
		this.context = context;
		this.tab = 1;
		this.pldb = pldb;
		this.pflowSurficialModel = pflowSurficialModel;
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
				sp1.setElements(e);//(pldb.getCol1("lutSURPflowPaleoflow"));
				spinnerClass.setAdapter(sp1);
				spinnerClass.setOnItemSelectedListener(new OnItemSelectedListener() {
					public void onNothingSelected(AdapterView<?> arg0) {
						
					}

					public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
						//earthmatbedrockModel.getEntity().setLithGroup("");
						System.out.println(parent.getItemAtPosition(position));
					}
				});
				
				Spinner spinnerSense = (Spinner)convertView.findViewById(R.id.pflow_surficial_spinner_sense);
				SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
				spinnerSense.setAdapter(sp2);
				sp2.setElements(e);//(pldb.getCol1("lutSURPflowPFsense"));
				spinnerSense.setAdapter(sp2);
				spinnerSense.setOnItemSelectedListener(new OnItemSelectedListener() {
					public void onNothingSelected(AdapterView<?> arg0) {
						
					}

					public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
						//earthmatbedrockModel.getEntity().setLithGroup("");
						System.out.println(parent.getItemAtPosition(position));
					}
				});
				
				Spinner spinnerFeature = (Spinner)convertView.findViewById(R.id.pflow_surficial_spinner_feature);
				SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
				spinnerFeature.setAdapter(sp3);
				sp3.setElements(e);//(pldb.getCol2("lutSURPflowPaleoflow"));
				spinnerFeature.setAdapter(sp3);
				spinnerFeature.setOnItemSelectedListener(new OnItemSelectedListener() {
					public void onNothingSelected(AdapterView<?> arg0) {
						
					}

					public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
						//earthmatbedrockModel.getEntity().setLithGroup("");
						System.out.println(parent.getItemAtPosition(position));
					}
				});
				
				Button buttonFeature = (Button)convertView.findViewById(R.id.pflow_surficial_button_feature);
				EditText editTextFeature = (EditText)convertView.findViewById(R.id.pflow_surficial_text_feature);
				
				Spinner spinnerBedrockSurface = (Spinner)convertView.findViewById(R.id.pflow_surficial_spinner_bedrockSurface);
				SpinnerController sp4 = new SpinnerController(context, android.R.layout.simple_spinner_item);
				spinnerBedrockSurface.setAdapter(sp4);
				sp4.setElements(e);//(pldb.getCol1("lutSURPflowBedrocksurface"));
				spinnerBedrockSurface.setAdapter(sp4);
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
				sp1.setElements(e);//(pldb.getCol1("lutSURGeneralStrucMethod"));
				spinnerMethod.setAdapter(sp1);
				spinnerMethod.setOnItemSelectedListener(new OnItemSelectedListener() {
					public void onNothingSelected(AdapterView<?> arg0) {
						
					}

					public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
						//earthmatbedrockModel.getEntity().setLithGroup("");
						System.out.println(parent.getItemAtPosition(position));
					}
				});
				
				EditText editTextAzimuth = (EditText)convertView.findViewById(R.id.pflow_surficial_text_azimuth);
				EditText editTextAge = (EditText)convertView.findViewById(R.id.pflow_surficial_editText_age);
				Spinner spinnerIndicators = (Spinner)convertView.findViewById(R.id.pflow_surficial_spinner_indicators);
				SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
				spinnerIndicators.setAdapter(sp2);
				sp2.setElements(e);//(pldb.getCol1("lutSURPflowNumindic"));
				spinnerIndicators.setAdapter(sp2);
				spinnerIndicators.setOnItemSelectedListener(new OnItemSelectedListener() {
					public void onNothingSelected(AdapterView<?> arg0) {
						
					}

					public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
						//earthmatbedrockModel.getEntity().setLithGroup("");
						System.out.println(parent.getItemAtPosition(position));
					}
				});
				
				Spinner spinnerDefinition = (Spinner)convertView.findViewById(R.id.pflow_surficial_spinner_definition);
				SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
				spinnerDefinition.setAdapter(sp3);
				sp3.setElements(e);//(pldb.getCol1("lutSURPflowDefinition"));
				spinnerDefinition.setAdapter(sp3);
				spinnerDefinition.setOnItemSelectedListener(new OnItemSelectedListener() {
					public void onNothingSelected(AdapterView<?> arg0) {
						
					}

					public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
						//earthmatbedrockModel.getEntity().setLithGroup("");
						System.out.println(parent.getItemAtPosition(position));
					}
				});
				
				Spinner spinnerRelationship = (Spinner)convertView.findViewById(R.id.pflow_surficial_spinner_relationship);
				SpinnerController sp4 = new SpinnerController(context, android.R.layout.simple_spinner_item);
				spinnerRelationship.setAdapter(sp4);
				sp4.setElements(e);//(pldb.getCol1("lutSURPflowRelation"));
				spinnerRelationship.setAdapter(sp4);
				spinnerRelationship.setOnItemSelectedListener(new OnItemSelectedListener() {
					public void onNothingSelected(AdapterView<?> arg0) {
						
					}

					public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
						//earthmatbedrockModel.getEntity().setLithGroup("");
						System.out.println(parent.getItemAtPosition(position));
					}
				});
				
				
			}
			else if (tab == 3)
			{
				
				convertView = mInflater.inflate(R.layout.pflow_surficial_3, null);
				
				EditText editTextNote = (EditText)convertView.findViewById(R.id.pflow_surficial_text_note);
				
			
			}
		
		return convertView;
	}

	public Filter getFilter() {
		return null;
	}

	public boolean setTab(int tabNum) {

		if(this.tab == 2){
			if(pflowSurficialModel.getEntity().getPfAzimuth().equalsIgnoreCase("")){
				return false;
			}
			
		}
		this.tab = tabNum;
		notifyDataSetChanged();
		return true;
	}


	
}


