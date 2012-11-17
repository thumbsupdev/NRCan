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
			MABedrock1 holder;
			holder = new MABedrock1();
			convertView = mInflater.inflate(R.layout.ma_bedrock1, null);

			holder.spinnerMinAlt = (Spinner) convertView
					.findViewById(R.id.ma_bedrock_spinner_minAlt);
			holder.spinnerMineral = (Spinner) convertView
					.findViewById(R.id.ma_bedrock_spinner_mineral);
			holder.spinnerMineralPercent = (Spinner) convertView
					.findViewById(R.id.ma_bedrock_spinner_mineralPercent);
			holder.spinnerDistribution = (Spinner) convertView
					.findViewById(R.id.ma_bedrock_spinner_distribution);
			holder.buttonMAClear = (Button) convertView
					.findViewById(R.id.ma_bedrock_button_mAClear);
			holder.editTextMA = (EditText) convertView
					.findViewById(R.id.ma_bedrock_editText_mA);
			holder.spinnerWhatAffected = (Spinner) convertView
					.findViewById(R.id.ma_bedrock_spinner_whatAffected);
			
			convertView.setTag(holder);
		} else if (tab == 2) {
			MABedrock2 holder;
			holder = new MABedrock2();
			convertView = mInflater.inflate(R.layout.ma_bedrock2, null);

			holder.editTextNote = (EditText) convertView
					.findViewById(R.id.ma_bedrock_editText_note);

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

	static class MABedrock1 {
		Spinner spinnerMinAlt;
		Spinner spinnerMineral;
		Spinner spinnerMineralPercent;
		Spinner spinnerDistribution;
		Button buttonMAClear;
		EditText editTextMA;
		Spinner spinnerWhatAffected;
	}

	static class MABedrock2 {
		
		
		EditText editTextNote;
	}

}
