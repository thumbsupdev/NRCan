package com.nrcan.controllers;

import com.nrcan.main.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.SeekBar;
import android.widget.Spinner;

public class EnvironSurficialController  extends BaseAdapter implements Filterable {
	private LayoutInflater mInflater;
	private Activity activity;
	private Context context;
	private int tab;
	
	public EnvironSurficialController(Context context, Activity activity) {
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
				EnvironSurficial1 holder;
				holder = new EnvironSurficial1();
				convertView = mInflater.inflate(R.layout.environ_surficial1, null);
				
				holder.spinnerRelief = (Spinner)convertView.findViewById(R.id.environ_surficial_spinner_relief);
				holder.editTextSlope = (EditText)convertView.findViewById(R.id.environ_surficial_editText_slope);
				holder.spinnerAzimuth = (Spinner)convertView.findViewById(R.id.environ_surficial_spinner_azimuth);
				holder.checkBoxPermafrost = (CheckBox)convertView.findViewById(R.id.environ_checkBox_permafrost);
				holder.spinnerIndicators = (Spinner)convertView.findViewById(R.id.environ_surficial_spinner_indicators);
				holder.editTextIndicators = (EditText)convertView.findViewById(R.id.environ_surficial_editText_indicators);
				holder.editTextDepthOfAL = (EditText)convertView.findViewById(R.id.environ_surficial_editText_depthOfAL);
				
				convertView.setTag(holder);
			}
			else if (tab == 2)
			{
				EnvironSurficial2 holder;
				holder = new EnvironSurficial2();
				convertView = mInflater.inflate(R.layout.environ_surficial2, null);
				
				holder.checkBoxGossan = (CheckBox)convertView.findViewById(R.id.environ_checkBox_gossan);
				holder.editTextMinOfImp = (EditText)convertView.findViewById(R.id.environ_surficial_editText_minOfImp);
				holder.spinnerPercentBedrock = (Spinner)convertView.findViewById(R.id.environ_surficial_spinner_percentBedrock);
				holder.spinnerExposureType = (Spinner)convertView.findViewById(R.id.environ_surficial_spinner_exposureType);
				
				convertView.setTag(holder);
			}
			else if (tab == 3)
			{
				EnvironSurficial3 holder;
				holder = new EnvironSurficial3();
				convertView = mInflater.inflate(R.layout.environ_surficial3, null);
				
				holder.spinnerVegetation = (Spinner)convertView.findViewById(R.id.environ_surficial_spinner_vegetation);
				holder.spinnerVegetationPer = (Spinner)convertView.findViewById(R.id.environ_surficial_spinner_vegetationPer);
				holder.buttonVegetation = (Button)convertView.findViewById(R.id.environ_surficial_button_vegetation);
				holder.editTextVegetation = (EditText)convertView.findViewById(R.id.environ_surficial_editText_vegetation);
				holder.spinnerBoulders = (Spinner)convertView.findViewById(R.id.environ_surficial_spinner_boulders);
				holder.checkBoxBoulderField = (CheckBox)convertView.findViewById(R.id.environ_checkBox_boulderField);
				holder.spinnerBoulderField = (Spinner)convertView.findViewById(R.id.environ_surficial_spinner_boulderField);
				
				convertView.setTag(holder);
			}
			else if (tab == 4)
			{
				EnvironSurficial4 holder;
				holder = new EnvironSurficial4();
				convertView = mInflater.inflate(R.layout.environ_surficial4, null);
				
				holder.spinnerGroundCover = (Spinner)convertView.findViewById(R.id.environ_surficial_spinner_groundCover);
				holder.spinnerGroundCoverPer = (Spinner)convertView.findViewById(R.id.environ_surficial_spinner_groundCoverPer);
				holder.buttonGroundCover = (Button)convertView.findViewById(R.id.environ_surficial_button_groundCover);
				holder.editTextGroundCover = (EditText)convertView.findViewById(R.id.environ_surficial_editText_groundCover);
				holder.spinnerPattGrnd = (Spinner)convertView.findViewById(R.id.environ_surficial_spinner_pattGrnd);
				holder.buttonPattGrndClear = (Button)convertView.findViewById(R.id.environ_surficial_button_pattGrnd_clear);
				holder.editTextPattGrnd = (EditText)convertView.findViewById(R.id.environ_surficial_editText_pattGrnd);
				holder.editTextPatternArea = (EditText)convertView.findViewById(R.id.environ_surficial_editText_patternArea);
				
				convertView.setTag(holder);
			}
			else if (tab == 5)
			{
				EnvironSurficial5 holder;
				holder = new EnvironSurficial5();
				convertView = mInflater.inflate(R.layout.environ_surficial5, null);
				
				holder.editTextEnvironNote = (EditText)convertView.findViewById(R.id.environ_surficial_editText_environNote);
				
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

	static class EnvironSurficial1 {
		Spinner spinnerRelief;
		EditText editTextSlope;
		Spinner spinnerAzimuth;
		CheckBox checkBoxPermafrost;
		Spinner spinnerIndicators;
		EditText editTextIndicators;
		EditText editTextDepthOfAL;
	}
	
	static class EnvironSurficial2 {
		CheckBox checkBoxGossan;
		EditText editTextMinOfImp;
		Spinner spinnerPercentBedrock;
		Spinner spinnerExposureType;
	}
	
	static class EnvironSurficial3 {
		Spinner spinnerVegetation;
		Spinner spinnerVegetationPer;
		Button buttonVegetation;
		EditText editTextVegetation;
		Spinner spinnerBoulders;
		CheckBox checkBoxBoulderField;
		Spinner spinnerBoulderField;
	}
	
	static class EnvironSurficial4 {
		Spinner spinnerGroundCover;
		Spinner spinnerGroundCoverPer;
		Button buttonGroundCover;
		EditText editTextGroundCover;
		
		Spinner spinnerPattGrnd;
		Button buttonPattGrndClear;
		EditText editTextPattGrnd;
		
		EditText editTextPatternArea;
	}
	
	static class EnvironSurficial5 {
		EditText editTextEnvironNote;
	}
	
}
