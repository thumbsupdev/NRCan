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
			SampleSurficial1 holder;
			holder = new SampleSurficial1();
			convertView = mInflater.inflate(R.layout.sample_surficial1, null);
			
			
			holder.spinnerType = (Spinner) convertView
					.findViewById(R.id.sample_surficial_spinner_type);
			holder.spinnerPurpose = (Spinner) convertView
					.findViewById(R.id.sample_surficial_spinner_purpose);
			holder.buttonPurpose = (Button) convertView
					.findViewById(R.id.sample_surficial_button_purpose);
			holder.editTextPurpose = (EditText) convertView
					.findViewById(R.id.sample_surficial_editText_purpose);
			holder.editTextHorizon = (EditText) convertView
					.findViewById(R.id.sample_surficial_editText_horizon);
			holder.editTextDepth = (EditText) convertView
					.findViewById(R.id.sample_surficial_editText_depthInterval);
			

			convertView.setTag(holder);
		} else if (tab == 2) {
			SampleSurficial2 holder;
			holder = new SampleSurficial2();
			convertView = mInflater.inflate(R.layout.sample_surficial2, null);
			
			holder.spinnerSampleState = (Spinner) convertView
					.findViewById(R.id.sample_surficial_spinner_sampleState);
			holder.spinnerFormat = (Spinner) convertView
					.findViewById(R.id.sample_surficial_spinner_format);
			holder.editTextAzimuth = (EditText) convertView
					.findViewById(R.id.sample_surficial_editText_azimuth);
			holder.editTextDipPlunge = (EditText) convertView
					.findViewById(R.id.sample_surficial_editText_dipPlunge);
			holder.spinnerSurface = (Spinner) convertView
					.findViewById(R.id.sample_surficial_spinner_surface);
	

			convertView.setTag(holder);
		} else if (tab == 3) {
			SampleSurficial3 holder;
			holder = new SampleSurficial3();
			convertView = mInflater.inflate(R.layout.sample_surficial3, null);

			
			holder.editTextNotes = (EditText) convertView
					.findViewById(R.id.sample_surficial_editText_notes);

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

	static class SampleSurficial1 {
		
		Spinner spinnerType;
		Spinner spinnerPurpose;
		Button buttonPurpose;
		EditText editTextPurpose;
		EditText editTextHorizon;
		EditText editTextDepth;
}

	static class SampleSurficial2 {
		Spinner spinnerSampleState;
		Spinner spinnerFormat;
		EditText editTextAzimuth;
		EditText editTextDipPlunge;
		
		
		Spinner spinnerSurface;
		
		
		
		

	}

	static class SampleSurficial3 {
		
		EditText editTextNotes;

		

	}

	

	
}
