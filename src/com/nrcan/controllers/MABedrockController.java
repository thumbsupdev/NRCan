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

			holder.spinnerSummary = (Spinner) convertView
					.findViewById(R.id.ma_bedrock_spinner_summary);
			holder.buttonSummary = (Button) convertView
					.findViewById(R.id.ma_bedrock_button_summary);
			holder.spinnerMinAlt = (Spinner) convertView
					.findViewById(R.id.ma_bedrock_spinner_minAlt);
			holder.spinnerMineral = (Spinner) convertView
					.findViewById(R.id.ma_bedrock_spinner_mineral);
			holder.spinnerDistribution = (Spinner) convertView
					.findViewById(R.id.ma_bedrock_spinner_distribution);
			holder.buttonMAClear = (Button) convertView
					.findViewById(R.id.ma_bedrock_button_mAClear);
			holder.editTextMA = (EditText) convertView
					.findViewById(R.id.ma_bedrock_editText_mA);
			convertView.setTag(holder);
		} else if (tab == 2) {
			MABedrock2 holder;
			holder = new MABedrock2();
			convertView = mInflater.inflate(R.layout.ma_bedrock2, null);
			holder.spinnerUnit = (Spinner) convertView
					.findViewById(R.id.ma_bedrock_spinner_unit);
			holder.spinnerMode = (Spinner) convertView
					.findViewById(R.id.ma_bedrock_spinner_mode);
			holder.seekbarMode = (SeekBar) convertView
					.findViewById(R.id.ma_bedrock_seekbar_mode);
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
		Spinner spinnerSummary;
		Button buttonSummary;
		Spinner spinnerMinAlt;
		Spinner spinnerMineral;
		Spinner spinnerDistribution;
		Button buttonMAClear;
		EditText editTextMA;

	}

	static class MABedrock2 {
		Spinner spinnerUnit;
		Spinner spinnerMode;
		SeekBar seekbarMode;
		EditText editTextNote;
	}

}
