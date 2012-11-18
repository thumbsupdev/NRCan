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
			
			convertView = mInflater.inflate(R.layout.mineral_bedrock1, null);


			Spinner spinnerMineral = (Spinner) convertView
					.findViewById(R.id.mineral_bedrock_spinner_mineral);
			SpinnerController sp1 = new SpinnerController(context, activity, "lutBEDMineralMineral");
			spinnerMineral.setAdapter(sp1);
			sp1.setElementsCol1();
			
			EditText editTextMode = (EditText) convertView
					.findViewById(R.id.mineral_bedrock_editText_percent);

			
		} else if (tab == 2) {
			
			convertView = mInflater.inflate(R.layout.mineral_bedrock2, null);

			Spinner spinnerColour = (Spinner) convertView
					.findViewById(R.id.mineral_bedrock_spinner_colour);
			SpinnerController sp1 = new SpinnerController(context, activity, "lutBEDMineralColour");
			spinnerColour.setAdapter(sp1);
			sp1.setElementsCol1();
			
			EditText editTextMin = (EditText) convertView
					.findViewById(R.id.mineal_bedrock_editText_min);
			EditText editTextMax = (EditText) convertView
					.findViewById(R.id.mineral_bedrock_editText_max);
			
			
		} else if (tab == 3) {
			
			convertView = mInflater.inflate(R.layout.mineral_bedrock3, null);

			Spinner spinnerForm = (Spinner) convertView
					.findViewById(R.id.mineral_bedrock_spinner_form);
			SpinnerController sp1 = new SpinnerController(context, activity, "lutBEDMineralForm");
			spinnerForm.setAdapter(sp1);
			sp1.setElementsCol1();
			
			Spinner spinnerHabit = (Spinner) convertView
					.findViewById(R.id.mineral_bedrock_spinner_habit);
			SpinnerController sp2 = new SpinnerController(context, activity, "lutBEDMineralHabit");
			spinnerHabit.setAdapter(sp2);
			sp1.setElementsCol1();
			
			Spinner spinnerOccur = (Spinner) convertView
					.findViewById(R.id.mineral_bedrock_spinner_occur);
			SpinnerController sp3 = new SpinnerController(context, activity, "lutBEDMineralOccur");
			spinnerOccur.setAdapter(sp3);
			sp3.setElementsCol1();

			
		} else if (tab == 4) {
		
			convertView = mInflater.inflate(R.layout.mineral_bedrock4, null);


			EditText editTextNotes = (EditText) convertView
					.findViewById(R.id.mineral_editText_note);
			
			
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
