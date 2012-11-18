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

public class SampleBedrockController extends BaseAdapter implements Filterable {
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
		if (tab == 1) {
			
			convertView = mInflater.inflate(R.layout.sample_bedrock_1, null);

			Spinner spinnerType = (Spinner) convertView
					.findViewById(R.id.sample_bedrock_spinner_type);
			SpinnerController sp1 = new SpinnerController(context, activity, "lutBEDSampleType");
			spinnerType.setAdapter(sp1);
			sp1.setElementsCol1();
			
			Spinner spinnerPurpose = (Spinner) convertView
					.findViewById(R.id.sample_bedrock_spinner_purpose);
			SpinnerController sp2 = new SpinnerController(context, activity, "lutBEDSamplePurpose");
			spinnerPurpose.setAdapter(sp2);
			sp2.setElementsCol1();
			
			Button buttonPurpose = (Button) convertView
					.findViewById(R.id.sample_bedrock_button_purpose);
			EditText editTextPurpose = (EditText) convertView
					.findViewById(R.id.sample_bedrock_text_purpose);

			
		} else if (tab == 2) {
			
			convertView = mInflater.inflate(R.layout.sample_bedrock_2, null);

			Spinner spinnerFormat = (Spinner) convertView
					.findViewById(R.id.sample_bedrock_spinner_format);
			SpinnerController sp1 = new SpinnerController(context, activity, "lutBEDGeneralStrucFormat");
			spinnerFormat.setAdapter(sp1);
			sp1.setElementsCol1();
			
			EditText editTextAzimuth = (EditText) convertView
					.findViewById(R.id.sample_bedrock_editText_azimuth);
			EditText editTextDipPlunge = (EditText) convertView
					.findViewById(R.id.sample_bedrock_editText_dipPlunge);
			Spinner spinnerSurface = (Spinner) convertView
					.findViewById(R.id.sample_bedrock_spinner_surface);
			SpinnerController sp2 = new SpinnerController(context, activity, "lutBEDSampleSurface");
			spinnerSurface.setAdapter(sp2);
			sp2.setElementsCol1();
			

			
		} else if (tab == 3) {
			
			convertView = mInflater.inflate(R.layout.sample_bedrock_3, null);

			EditText editTextNote = (EditText) convertView
					.findViewById(R.id.sample_bedrock_text_note);

			
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
