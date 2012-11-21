package com.nrcan.controllers;

import java.util.ArrayList;

import com.nrcan.main.PicklistDatabaseHandler;
import com.nrcan.main.R;
import com.nrcan.models.MABedrockModel;

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

public class MABedrockController extends BaseAdapter implements Filterable {
	private LayoutInflater mInflater;
	private Activity activity;
	private Context context;
	private int tab;
	private MABedrockModel maBedrockModel;
	private PicklistDatabaseHandler pldb;
	private ArrayList<String> e = new ArrayList<String>();

	public MABedrockController(Context context, Activity activity,MABedrockModel maBedrockModel,PicklistDatabaseHandler pldb) {
		this.mInflater = LayoutInflater.from(context);
		this.activity = activity;
		this.context = context;
		this.tab = 1;
		this.pldb = pldb;
		this.maBedrockModel = maBedrockModel;

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
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerMinAlt.setAdapter(sp1);
			sp1.setElements(e);//(pldb.getCol1("lutBEDMAMineralogy"));
			spinnerMinAlt.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Spinner spinnerMineral = (Spinner) convertView.findViewById(R.id.ma_bedrock_spinner_mineral);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerMineral.setAdapter(sp2);
			sp2.setElements(e);//(pldb.getCol2("lutBEDMAMineralogy"));
			spinnerMineral.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Spinner spinnerMineralPercent = (Spinner) convertView.findViewById(R.id.ma_bedrock_spinner_mineralPercent);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerMineralPercent.setAdapter(sp3);
			sp3.setElements(e);//(pldb.getCol1("lutSURGeneralPercent5incr"));
			spinnerMineralPercent.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Spinner spinnerDistribution = (Spinner) convertView.findViewById(R.id.ma_bedrock_spinner_distribution);
			SpinnerController sp4 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerDistribution.setAdapter(sp4);
			sp4.setElements(e);//(pldb.getCol2("lutBEDMADistribute"));
			spinnerDistribution.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Button buttonMAClear = (Button) convertView
					.findViewById(R.id.ma_bedrock_button_mAClear);
			EditText editTextMA = (EditText) convertView
					.findViewById(R.id.ma_bedrock_editText_mA);
			Spinner spinnerWhatAffected = (Spinner) convertView.findViewById(R.id.ma_bedrock_spinner_whatAffected);
			SpinnerController sp5 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerWhatAffected.setAdapter(sp5);
			sp5.setElements(e);//(pldb.getCol1("lutBEDMAUnit"));
			spinnerWhatAffected.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			
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
