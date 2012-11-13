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
				PFlowSurficial1 holder;
				holder = new PFlowSurficial1();
				convertView = mInflater.inflate(R.layout.pflow_surficial_1, null);
				
				holder.spinnerClass = (Spinner)convertView.findViewById(R.id.pflow_surficial_spinner_class);
				holder.spinnerDirection = (Spinner)convertView.findViewById(R.id.pflow_surficial_spinner_direction);
				holder.spinnerFeature = (Spinner)convertView.findViewById(R.id.pflow_surficial_spinner_feature);
				holder.buttonFeature = (Button)convertView.findViewById(R.id.pflow_surficial_button_feature);
				holder.editTextFeature = (EditText)convertView.findViewById(R.id.pflow_surficial_text_feature);
				
				convertView.setTag(holder);
			}
			else if (tab == 2)
			{
				PFlowSurficial2 holder;
				holder = new PFlowSurficial2();
				convertView = mInflater.inflate(R.layout.pflow_surficial_2, null);
				
				holder.spinnerMethod = (Spinner)convertView.findViewById(R.id.pflow_surficial_spinner_method);
				holder.editTextAzimuth = (EditText)convertView.findViewById(R.id.pflow_surficial_text_azimuth);
				holder.buttonAzimuthUp = (Button)convertView.findViewById(R.id.pflow_surficial_button_azimuthup);
				holder.buttonAzimuthDown = (Button)convertView.findViewById(R.id.pflow_surficial_button_azimuthdown);
				holder.seekbarAzimuth = (SeekBar)convertView.findViewById(R.id.pflow_surficial_seekbar_azimuth);
				holder.editTextPlungedip = (EditText)convertView.findViewById(R.id.pflow_surficial_text_plungedip);
				holder.spinnerAge = (Spinner)convertView.findViewById(R.id.pflow_surficial_spinner_age);
				holder.spinnerIndicators = (Spinner)convertView.findViewById(R.id.pflow_surficial_spinner_indicators);
				holder.spinnerDefined = (Spinner)convertView.findViewById(R.id.pflow_surficial_spinner_defined);
				holder.spinnerRelationship = (Spinner)convertView.findViewById(R.id.pflow_surficial_spinner_relationship);
				
				convertView.setTag(holder);
			}
			else if (tab == 3)
			{
				PFlowSurficial3 holder;
				holder = new PFlowSurficial3();
				convertView = mInflater.inflate(R.layout.pflow_surficial_3, null);
				
				holder.editTextNote = (EditText)convertView.findViewById(R.id.pflow_surficial_text_note);
				
				convertView.setTag(holder);
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

	static class PFlowSurficial1 {
		Spinner spinnerClass;
		Spinner spinnerDirection;
		Spinner spinnerFeature;
		Button buttonFeature;
		EditText editTextFeature;
	}
	
	static class PFlowSurficial2 {
		Spinner spinnerMethod;
		EditText editTextAzimuth;
		Button buttonAzimuthUp;
		Button buttonAzimuthDown;
		SeekBar seekbarAzimuth;
		EditText editTextPlungedip;
		Spinner spinnerAge;
		Spinner spinnerIndicators;
		Spinner spinnerDefined;
		Spinner spinnerRelationship;
	}
	
	static class PFlowSurficial3{
		EditText editTextNote;
	}
	
}


