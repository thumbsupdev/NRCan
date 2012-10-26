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

public class MineralBedrockController extends BaseAdapter implements
Filterable {
	private LayoutInflater mInflater;
	private Activity activity;
	private Context context;
	private int tab;

	public MineralBedrockController(Context context, Activity activity) {
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
			MineralBedrock1 holder;
			holder = new MineralBedrock1();
			convertView = mInflater.inflate(R.layout.mineral_bedrock1, null);


			holder.spinnerMineral = (Spinner) convertView
					.findViewById(R.id.mineral_bedrock_spinner_mineral);
			holder.spinnerMode = (Spinner) convertView
					.findViewById(R.id.mineral_bedrock_spinner_mode);
			holder.seekBarMode = (SeekBar) convertView
					.findViewById(R.id.mineral_bedrock_seekbar_mode);
			holder.buttonMode = (Button) convertView
					.findViewById(R.id.mineral_bedrock_button_mode);

			convertView.setTag(holder);
		} else if (tab == 2) {
			MineralBedrock2 holder;
			holder = new MineralBedrock2();
			convertView = mInflater.inflate(R.layout.mineral_bedrock2, null);

			holder.spinnerColour = (Spinner) convertView
					.findViewById(R.id.mineral_bedrock_spinner_colour);
			holder.spinnerMin = (Spinner) convertView
					.findViewById(R.id.mineal_bedrock_spinner_min);
			holder.seekBarMin = (SeekBar) convertView
					.findViewById(R.id.mineral_bedrock_seekbar_min);
			holder.spinnerMax = (Spinner) convertView
					.findViewById(R.id.mineral_bedrock_spinner_max);
			holder.seekBarMax = (SeekBar) convertView
					.findViewById(R.id.mineral_bedrock_seekbar_max);

			convertView.setTag(holder);
		} else if (tab == 3) {
			MineralBedrock3 holder;
			holder = new MineralBedrock3();
			convertView = mInflater.inflate(R.layout.mineral_bedrock3, null);

			holder.spinnerForm = (Spinner) convertView
					.findViewById(R.id.mineral_bedrock_spinner_form);
			holder.spinnerHabit = (Spinner) convertView
					.findViewById(R.id.mineral_bedrock_spinner_habit);
			holder.spinnerOccur = (Spinner) convertView
					.findViewById(R.id.mineral_bedrock_spinner_occur);

			convertView.setTag(holder);
		} else if (tab == 4) {
			MineralBedrock4 holder;
			holder = new MineralBedrock4();
			convertView = mInflater.inflate(R.layout.mineral_bedrock4, null);


			holder.editTextNotes = (EditText) convertView
					.findViewById(R.id.mineral_editText_note);
			
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

	static class MineralBedrock1 {

		Spinner spinnerMineral;
		Spinner spinnerMode;
		SeekBar seekBarMode;
		Button buttonMode;

	}

	static class MineralBedrock2 {
		Spinner spinnerColour;
		Spinner spinnerMin;
		SeekBar seekBarMin;
		Spinner spinnerMax;
		SeekBar seekBarMax;

	}

	static class MineralBedrock3 {
		Spinner spinnerForm;
		Spinner spinnerHabit;
		Spinner spinnerOccur;

	}
	static class MineralBedrock4 {

		EditText editTextNotes;

	}



}
