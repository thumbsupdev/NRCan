package com.nrcan.controllers;

import java.util.ArrayList;

import com.nrcan.entities.MABedrockEntity;
import com.nrcan.main.PicklistDatabaseHandler;
import com.nrcan.main.R;
import com.nrcan.models.MABedrockModel;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
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
	
	private MABedrockEntity maBedrockEntity;
	private PicklistDatabaseHandler pldb;

	public MABedrockController(Context context, Activity activity,MABedrockEntity maBedrockEntity,PicklistDatabaseHandler pldb) {
		this.mInflater = LayoutInflater.from(context);
		this.activity = activity;
		this.context = context;
		this.tab = 1;
		this.pldb = pldb;
		this.maBedrockEntity = maBedrockEntity;

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
			sp1.setElements(pldb.getCol1("lutBEDMAMineralogy"));
			spinnerMinAlt.setSelection(sp1.getPosition(maBedrockEntity.getMa()));
			spinnerMinAlt.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					String tmp = parent.getItemAtPosition(position).toString();
					if(!tmp.equalsIgnoreCase(maBedrockEntity.getMineral()));
					{
						maBedrockEntity.setMa(tmp);
						maBedrockEntity.setMineral("");
						
						System.out.println(parent.getItemAtPosition(position));
						notifyDataSetChanged();
					}
					//earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Spinner spinnerMineral = (Spinner) convertView.findViewById(R.id.ma_bedrock_spinner_mineral);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerMineral.setAdapter(sp2);
			sp2.setElements(pldb.getCol2("lutBEDMAMineralogy",maBedrockEntity.getMa()));
			spinnerMineral.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					maBedrockEntity.setMineral(parent.getItemAtPosition(position).toString());
					
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Spinner spinnerMineralPercent = (Spinner) convertView.findViewById(R.id.ma_bedrock_spinner_mineralPercent);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerMineralPercent.setAdapter(sp3);
			sp3.setElements(pldb.getCol1("lutSURGeneralPercent5incr"));
			//spinnerMineralPercent.setSelection(sp3.getPosition(maBedrockEntity.get))
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
			sp4.setElements(pldb.getCol2("lutBEDMADistribute",maBedrockEntity.getMa()));
			spinnerDistribution.setSelection(sp4.getPosition(maBedrockEntity.getDistribute()));
			spinnerDistribution.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					String tmp = maBedrockEntity.getDistribute();
					String sel = parent.getItemAtPosition(position).toString();
					if(!tmp.contains(sel))
					{
						if(tmp.length() > 1)
							maBedrockEntity.setDistribute(tmp + " | " + sel);
						else
							maBedrockEntity.setDistribute(sel);
						
						notifyDataSetChanged();
					}
				}
			});
			
			Button buttonMAClear = (Button) convertView.findViewById(R.id.ma_bedrock_button_mAClear);
			buttonMAClear.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					maBedrockEntity.setDistribute("");
					notifyDataSetChanged();
				}
			});
			
			EditText editTextMA = (EditText) convertView
					.findViewById(R.id.ma_bedrock_editText_mA);
			editTextMA.setText(maBedrockEntity.getDistribute());
			editTextMA.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						maBedrockEntity.setDistribute("");
					else
						maBedrockEntity.setDistribute(s.toString());
				}
			});
			Spinner spinnerWhatAffected = (Spinner) convertView.findViewById(R.id.ma_bedrock_spinner_whatAffected);
			SpinnerController sp5 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerWhatAffected.setAdapter(sp5);
			sp5.setElements(pldb.getCol1("lutBEDMAUnit"));
			spinnerWhatAffected.setSelection(sp5.getPosition(maBedrockEntity.getUnit()));
			spinnerWhatAffected.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					maBedrockEntity.setUnit(parent.getItemAtPosition(position).toString());
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			
		} else if (tab == 2) {
			
			convertView = mInflater.inflate(R.layout.ma_bedrock2, null);

			EditText editTextNote = (EditText) convertView
					.findViewById(R.id.ma_bedrock_editText_note);
			editTextNote.setText(maBedrockEntity.getNotes());
			editTextNote.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						maBedrockEntity.setNotes("");
					else
						maBedrockEntity.setNotes(s.toString());
				}
			});

			

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
