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

public class SampleSurficialController extends BaseAdapter implements
		Filterable {
	private LayoutInflater mInflater;
	private Activity activity;
	private Context context;
	private int tab;

	public SampleSurficialController(Context context, Activity activity) {
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
		if (tab == 1) {
			
			convertView = mInflater.inflate(R.layout.sample_surficial1, null);
			
			
			Spinner spinnerType = (Spinner) convertView
					.findViewById(R.id.sample_surficial_spinner_type);
			
			SpinnerController sp1 = new SpinnerController(context, activity, "lutSURSampleType");
			spinnerType.setAdapter(sp1);
			sp1.setElementsCol1();
			
			Spinner spinnerPurpose = (Spinner) convertView
					.findViewById(R.id.sample_surficial_spinner_purpose);
			SpinnerController sp2 = new SpinnerController(context, activity, "lutSURSamplePurpose");
			spinnerPurpose.setAdapter(sp2);
			sp2.setElementsCol1();
			
			Button buttonPurpose = (Button) convertView
					.findViewById(R.id.sample_surficial_button_purpose);
			EditText editTextPurpose = (EditText) convertView
					.findViewById(R.id.sample_surficial_editText_purpose);
			EditText editTextHorizon = (EditText) convertView
					.findViewById(R.id.sample_surficial_editText_horizon);
			EditText editTextDepth = (EditText) convertView
					.findViewById(R.id.sample_surficial_editText_depthInterval);
			

			
		} else if (tab == 2) {
			
			convertView = mInflater.inflate(R.layout.sample_surficial2, null);
			
			Spinner spinnerSampleState = (Spinner) convertView
					.findViewById(R.id.sample_surficial_spinner_sampleState);
			SpinnerController sp1 = new SpinnerController(context, activity, "lutSURSampleState");
			spinnerSampleState.setAdapter(sp1);
			sp1.setElementsCol1();
			
			Spinner spinnerFormat = (Spinner) convertView
					.findViewById(R.id.sample_surficial_spinner_format);
			SpinnerController sp2 = new SpinnerController(context, activity, "lutSURGeneralStrucFormat");
			spinnerFormat.setAdapter(sp2);
			sp2.setElementsCol1();
			
			EditText editTextAzimuth = (EditText) convertView
					.findViewById(R.id.sample_surficial_editText_azimuth);
			EditText editTextDipPlunge = (EditText) convertView
					.findViewById(R.id.sample_surficial_editText_dipPlunge);
			Spinner spinnerSurface = (Spinner) convertView
					.findViewById(R.id.sample_surficial_spinner_surface);
			SpinnerController sp3 = new SpinnerController(context, activity, "lutSURSampleSurface");
			spinnerSurface.setAdapter(sp3);
			sp3.setElementsCol1();
			
	

			
		} else if (tab == 3) {
			
			convertView = mInflater.inflate(R.layout.sample_surficial3, null);

			
			EditText editTextNotes = (EditText) convertView
					.findViewById(R.id.sample_surficial_editText_notes);

			
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
