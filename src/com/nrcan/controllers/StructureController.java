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

public class StructureController  extends BaseAdapter implements Filterable {
	private LayoutInflater mInflater;
	private Activity activity;
	private Context context;
	private int tab;
	
	public StructureController(Context context, Activity activity) {
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
				Structure1 holder;
				holder = new Structure1();
				convertView = mInflater.inflate(R.layout.structure_1, null);
				
				holder.spinnerClass = (Spinner)convertView.findViewById(R.id.structure_spinner_class);
				holder.spinnerType = (Spinner)convertView.findViewById(R.id.structure_spinner_type);
				holder.spinnerDetail = (Spinner)convertView.findViewById(R.id.structure_spinner_detail);
				
				convertView.setTag(holder);
			}
			else if (tab == 2)
			{
				Structure2 holder;
				holder = new Structure2();
				convertView = mInflater.inflate(R.layout.structure_2, null);
				
				holder.spinnerMethod = (Spinner)convertView.findViewById(R.id.structure_spinner_method);
				holder.spinnerFormat = (Spinner)convertView.findViewById(R.id.structure_spinner_format);
				holder.editTextStrike = (EditText)convertView.findViewById(R.id.structure_text_strike);	
				holder.buttonStrikeUp = (Button)convertView.findViewById(R.id.structure_button_strikeup);
				holder.buttonStrikeDown = (Button)convertView.findViewById(R.id.structure_button_strikedown);
				holder.seekbarStrike = (SeekBar)convertView.findViewById(R.id.structure_seekbar_strike);
				holder.editTextDip = (EditText)convertView.findViewById(R.id.structure_text_dip);
				holder.buttonDipUp = (Button)convertView.findViewById(R.id.structure_button_dipup);
				holder.buttonDipDown =  (Button)convertView.findViewById(R.id.structure_button_dipdown);
				holder.seekbarDip = (SeekBar)convertView.findViewById(R.id.structure_seekbar_dip);
				
				convertView.setTag(holder);
			}
			else if (tab == 3)
			{
				Structure3 holder;
				holder = new Structure3();
				convertView = mInflater.inflate(R.layout.structure_3, null);
				
				holder.spinnerAttitude = (Spinner)convertView.findViewById(R.id.structure_spinner_attitude);
				holder.spinnerYounging = (Spinner)convertView.findViewById(R.id.structure_spinner_younging);
				holder.spinnerGeneration = (Spinner)convertView.findViewById(R.id.structure_spinner_generation);
				holder.spinnerStrain = (Spinner)convertView.findViewById(R.id.structure_spinner_strain);
				holder.spinnerFlattening = (Spinner)convertView.findViewById(R.id.structure_spinner_flattening);
				holder.spinnerRelated = (Spinner)convertView.findViewById(R.id.structure_spinner_related);
				
				convertView.setTag(holder);
			}
			else if (tab == 4)
			{
				Structure4 holder;
				holder = new Structure4();
				convertView = mInflater.inflate(R.layout.structure_4, null);
				
				holder.editTextFabric = (EditText)convertView.findViewById(R.id.structure_text_fabric);
				holder.editTextSense = (EditText)convertView.findViewById(R.id.structure_text_sense);
				
				convertView.setTag(holder);
			}
			else if (tab == 5)
			{
				Structure5 holder;
				holder = new Structure5();
				convertView = mInflater.inflate(R.layout.structure_5, null);
				
				holder.editTextNote = (EditText)convertView.findViewById(R.id.structure_text_sense);
				
				convertView.setTag(holder);
			}
		
		return convertView;
	}

	public Filter getFilter() {
		return null;
	}

	static class Structure1 {
		Spinner spinnerClass;
		Spinner spinnerType;
		Spinner spinnerDetail;
	}
	
	static class Structure2 {
		Spinner spinnerMethod;
		Spinner spinnerFormat;
		EditText editTextStrike;
		Button buttonStrikeUp;
		Button buttonStrikeDown;
		SeekBar seekbarStrike;
		EditText editTextDip;
		Button buttonDipUp;
		Button buttonDipDown;
		SeekBar seekbarDip;
	}
	
	static class Structure3 {
		Spinner spinnerAttitude;
		Spinner spinnerYounging;
		Spinner spinnerGeneration;
		Spinner spinnerStrain;
		Spinner spinnerFlattening;
		Spinner spinnerRelated;
	}
	
	static class Structure4 {
		EditText editTextFabric;
		EditText editTextSense;
	}
	
	static class Structure5 {
		EditText editTextNote;
	}
	
}
