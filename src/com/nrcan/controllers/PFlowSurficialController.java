package com.nrcan.controllers;

import com.nrcan.main.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.SeekBar;
import android.widget.Spinner;

public class PFlowSurficialController  extends BaseAdapter implements Filterable {
	private LayoutInflater mInflater;
	private Activity activity;
	private Context context;
	private int tab;
	
	public PFlowSurficialController(Context context, Activity activity) {
		this.mInflater = LayoutInflater.from(context);
		this.activity = activity;
		this.context = context;
		this.tab = 1;
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
				SpinnerController sp1 = new SpinnerController(context, activity, "lutSURPflowPaleoflow");
				spinnerClass.setAdapter(sp1);
				sp1.setElementsCol1();
				
				Spinner spinnerSense = (Spinner)convertView.findViewById(R.id.pflow_surficial_spinner_sense);
				SpinnerController sp2 = new SpinnerController(context, activity, "lutSURPflowPFsense");
				spinnerSense.setAdapter(sp2);
				sp2.setElementsCol1();
				
				Spinner spinnerFeature = (Spinner)convertView.findViewById(R.id.pflow_surficial_spinner_feature);
				SpinnerController sp3 = new SpinnerController(context, activity, "lutSURPflowPaleoflow");
				spinnerFeature.setAdapter(sp3);
				sp3.setElementsCol2(""); //NEEDS INPUT (based on spinnerClass)
				
				Button buttonFeature = (Button)convertView.findViewById(R.id.pflow_surficial_button_feature);
				EditText editTextFeature = (EditText)convertView.findViewById(R.id.pflow_surficial_text_feature);
				
				Spinner spinnerBedrockSurface = (Spinner)convertView.findViewById(R.id.pflow_surficial_spinner_bedrockSurface);
				SpinnerController sp4 = new SpinnerController(context, activity, "lutSURPflowBedrocksurface");
				spinnerBedrockSurface.setAdapter(sp4);
				sp4.setElementsCol1();
				
			}
			else if (tab == 2)
			{
				
				convertView = mInflater.inflate(R.layout.pflow_surficial_2, null);
				Spinner spinnerMethod = (Spinner)convertView.findViewById(R.id.pflow_surficial_spinner_method);
				SpinnerController sp2 = new SpinnerController(context, activity, "lutSURGeneralStrucMethod");
				spinnerMethod.setAdapter(sp2);
				sp2.setElementsCol1();
				
				EditText editTextAzimuth = (EditText)convertView.findViewById(R.id.pflow_surficial_text_azimuth);
				EditText editTextAge = (EditText)convertView.findViewById(R.id.pflow_surficial_editText_age);
				Spinner spinnerIndicators = (Spinner)convertView.findViewById(R.id.pflow_surficial_spinner_indicators);
				SpinnerController sp3 = new SpinnerController(context, activity, "lutSURPflowNumindic");
				spinnerIndicators.setAdapter(sp3);
				sp3.setElementsCol1();
				
				Spinner spinnerDefinition = (Spinner)convertView.findViewById(R.id.pflow_surficial_spinner_definition);
				SpinnerController sp4 = new SpinnerController(context, activity, "lutSURPflowDefinition");
				spinnerDefinition.setAdapter(sp4);
				sp4.setElementsCol1();
				
				Spinner spinnerRelationship = (Spinner)convertView.findViewById(R.id.pflow_surficial_spinner_relationship);
				SpinnerController sp5 = new SpinnerController(context, activity, "lutSURPflowRelation");
				spinnerRelationship.setAdapter(sp5);
				sp5.setElementsCol1();
				
				
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

	public void setTab(int tabNum) {
		this.tab = tabNum;
		notifyDataSetChanged();
	}


	
}


