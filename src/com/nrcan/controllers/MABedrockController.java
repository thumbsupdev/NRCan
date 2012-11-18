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

public class MABedrockController extends BaseAdapter implements Filterable {
	private LayoutInflater mInflater;
	private Activity activity;
	private Context context;
	private int tab;

	public MABedrockController(Context context, Activity activity) {
		this.mInflater = LayoutInflater.from(context);
		this.activity = activity;
		this.context = context;
		this.tab = 1;

	}

	public int getCount() {
		return 1;
	}

	public Object getItem(int position) {
		return null;
	}

	public long getItemId(int position) {
		return 0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		if (tab == 1) {
			
			convertView = mInflater.inflate(R.layout.ma_bedrock1, null);

			Spinner spinnerMinAlt = (Spinner) convertView.findViewById(R.id.ma_bedrock_spinner_minAlt);
			SpinnerController sp1 = new SpinnerController(context, activity, "lutBEDMAMineralogy");
			spinnerMinAlt.setAdapter(sp1);
			sp1.setElementsCol1();
			
			
			Spinner spinnerMineral = (Spinner) convertView.findViewById(R.id.ma_bedrock_spinner_mineral);
			SpinnerController sp2 = new SpinnerController(context, activity, "lutBEDMAMineralogy");
			spinnerMineral.setAdapter(sp2);
			sp2.setElementsCol2(""); // NEEDS INPUT
			
			Spinner spinnerMineralPercent = (Spinner) convertView.findViewById(R.id.ma_bedrock_spinner_mineralPercent);
			SpinnerController sp3 = new SpinnerController(context, activity, "lutSURGeneralPercent5incr");
			spinnerMineralPercent.setAdapter(sp3);
			sp3.setElementsCol1();
			
			Spinner spinnerDistribution = (Spinner) convertView.findViewById(R.id.ma_bedrock_spinner_distribution);
			SpinnerController sp4 = new SpinnerController(context, activity, "lutBEDMADistribute");
			spinnerDistribution.setAdapter(sp4);
			sp4.setElementsCol2("");
			
			Button buttonMAClear = (Button) convertView
					.findViewById(R.id.ma_bedrock_button_mAClear);
			EditText editTextMA = (EditText) convertView
					.findViewById(R.id.ma_bedrock_editText_mA);
			Spinner spinnerWhatAffected = (Spinner) convertView.findViewById(R.id.ma_bedrock_spinner_whatAffected);
			SpinnerController sp5 = new SpinnerController(context, activity, "lutBEDMAUnit");
			spinnerWhatAffected.setAdapter(sp5);
			sp5.setElementsCol1();
			
			
		} else if (tab == 2) {
			
			convertView = mInflater.inflate(R.layout.ma_bedrock2, null);

			EditText editTextNote = (EditText) convertView
					.findViewById(R.id.ma_bedrock_editText_note);

			

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
