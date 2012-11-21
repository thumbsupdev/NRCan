package com.nrcan.controllers;

import java.util.ArrayList;

import com.nrcan.main.PicklistDatabaseHandler;
import com.nrcan.main.R;
import com.nrcan.models.MineralBedrockModel;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class MineralBedrockController extends BaseAdapter implements
Filterable {
	private LayoutInflater mInflater;
	private Activity activity;
	private Context context;
	private int tab;
	private MineralBedrockModel mineralBedrockModel;
	private PicklistDatabaseHandler pldb;
	private ArrayList<String> e = new ArrayList<String>();

	public MineralBedrockController(Context context, Activity activity,MineralBedrockModel mineralBedrockModel,PicklistDatabaseHandler pldb) {
		this.mInflater = LayoutInflater.from(context);
		this.activity = activity;
		this.context = context;
		this.tab = 1;
		this.pldb = pldb;
		this.mineralBedrockModel = mineralBedrockModel;
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
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(e);//(pldb.getCol1("lutBEDMineralMineral"));
			spinnerMineral.setAdapter(sp1);
			spinnerMineral.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			EditText editTextMode = (EditText) convertView
					.findViewById(R.id.mineral_bedrock_editText_percent);

			
		} else if (tab == 2) {
			
			convertView = mInflater.inflate(R.layout.mineral_bedrock2, null);

			Spinner spinnerColour = (Spinner) convertView
					.findViewById(R.id.mineral_bedrock_spinner_colour);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(e);//(pldb.getCol1("lutBEDMineralColour"));
			spinnerColour.setAdapter(sp1);
			spinnerColour.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			EditText editTextMin = (EditText) convertView
					.findViewById(R.id.mineal_bedrock_editText_min);
			EditText editTextMax = (EditText) convertView
					.findViewById(R.id.mineral_bedrock_editText_max);
			
			
		} else if (tab == 3) {
			
			convertView = mInflater.inflate(R.layout.mineral_bedrock3, null);

			Spinner spinnerForm = (Spinner) convertView
					.findViewById(R.id.mineral_bedrock_spinner_form);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(e);//(pldb.getCol1("lutBEDMineralForm"));
			spinnerForm.setAdapter(sp1);
			spinnerForm.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Spinner spinnerHabit = (Spinner) convertView
					.findViewById(R.id.mineral_bedrock_spinner_habit);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp2.setElements(e);//(pldb.getCol1("lutBEDMineralHabit"));
			spinnerHabit.setAdapter(sp2);
			spinnerHabit.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Spinner spinnerOccur = (Spinner) convertView
					.findViewById(R.id.mineral_bedrock_spinner_occur);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp3.setElements(e);//(pldb.getCol1("lutBEDMineralOccur"));
			spinnerOccur.setAdapter(sp3);
			spinnerOccur.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});

			
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
