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

public class SampleBedrockController  extends BaseAdapter implements Filterable {
	private LayoutInflater mInflater;
	private Activity activity;
	private Context context;
	private int tab;
	
	public SampleBedrockController(Context context, Activity activity) {
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
				SampleBedrock1 holder;
				holder = new SampleBedrock1();
				convertView = mInflater.inflate(R.layout.sample_bedrock_1, null);
				
				holder.spinnerType = (Spinner)convertView.findViewById(R.id.sample_bedrock_spinner_type);
				holder.spinnerPurpose = (Spinner)convertView.findViewById(R.id.sample_bedrock_label_purpose);
				holder.buttonPurpose = (Button)convertView.findViewById(R.id.sample_bedrock_button_purpose);
				holder.editTextPurpose = (EditText)convertView.findViewById(R.id.sample_bedrock_text_purpose);
				
				convertView.setTag(holder);
			}
			else if (tab == 2)
			{
				SampleBedrock2 holder;
				holder = new SampleBedrock2();
				convertView = mInflater.inflate(R.layout.sample_bedrock_2, null);
				
				holder.spinnerFormat = (Spinner)convertView.findViewById(R.id.sample_bedrock_spinner_format);
				holder.editTextStrike = (EditText)convertView.findViewById(R.id.sample_bedrock_text_strike);
				holder.buttonStrikeUp = (Button)convertView.findViewById(R.id.sample_bedrock_button_strikeup);
				holder.buttonStrikeDown = (Button)convertView.findViewById(R.id.sample_bedrock_button_strikedown);
				holder.seekbarStrike = (SeekBar)convertView.findViewById(R.id.sample_bedrock_seekbar_strike);
				holder.editTextDip = (EditText)convertView.findViewById(R.id.sample_bedrock_text_dip);
				holder.buttonDipUp = (Button)convertView.findViewById(R.id.sample_bedrock_button_dipup);
				holder.buttonDipDown = (Button)convertView.findViewById(R.id.sample_bedrock_button_dipdown);
				holder.seekbarDip = (SeekBar)convertView.findViewById(R.id.sample_bedrock_seekbar_dip);
				holder.spinnerSurface = (Spinner)convertView.findViewById(R.id.sample_bedrock_spinner_surface);
				
				convertView.setTag(holder);
			}
			else if (tab == 3)
			{
				SampleBedrock3 holder;
				holder = new SampleBedrock3();
				convertView = mInflater.inflate(R.layout.sample_bedrock_3, null);
				
				holder.editTextNote = (EditText)convertView.findViewById(R.id.sample_bedrock_text_note);
				
				convertView.setTag(holder);
			}
		
		return convertView;
	}

	public Filter getFilter() {
		return null;
	}

	static class SampleBedrock1 {
		Spinner spinnerType;
		Spinner spinnerPurpose;
		Button buttonPurpose;
		EditText editTextPurpose;
	}
	
	static class SampleBedrock2 {
		Spinner spinnerFormat;
		EditText editTextStrike;
		Button buttonStrikeUp;
		Button buttonStrikeDown;
		SeekBar seekbarStrike;
		EditText editTextDip;
		Button buttonDipUp;
		Button buttonDipDown;
		SeekBar seekbarDip;
		Spinner spinnerSurface;
	}
	
	static class SampleBedrock3{
		EditText editTextNote;
	}
	
}

