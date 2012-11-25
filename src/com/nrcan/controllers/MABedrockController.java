package com.nrcan.controllers;

import com.nrcan.entities.MABedrockEntity;
import com.nrcan.main.PicklistDatabaseHandler;
import com.nrcan.main.R;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.Spinner;

public class MABedrockController extends BaseAdapter implements Filterable {
	private LayoutInflater mInflater;
	//private Activity activity;
	private Context context;
	private int tab;
	private MABedrockEntity maBedrockEntity;
	private PicklistDatabaseHandler pldb;

	public MABedrockController(Context context, Activity activity, MABedrockEntity maBedrockEntity, PicklistDatabaseHandler pldb) {
		this.mInflater = LayoutInflater.from(context);
		//this.activity = activity;
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

			/////////////////////////////////////
			// SPINNER MIN/ALT
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (1/7)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerMinAlt = (Spinner) convertView.findViewById(R.id.ma_bedrock_spinner_minAlt);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutBEDMAMineralogy"));
			sp1.setNewElement(pldb, "lutBEDMAMineralogy", 1, null, null);
			sp1.addSpace();
			spinnerMinAlt.setAdapter(sp1);
			spinnerMinAlt.setSelection(sp1.getPosition(maBedrockEntity.getMa()));
			spinnerMinAlt.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					String tmp = parent.getItemAtPosition(position).toString();
					if(!tmp.equalsIgnoreCase(maBedrockEntity.getMa()))
					{
						maBedrockEntity.setMa(tmp);
						maBedrockEntity.setMineral("");
						maBedrockEntity.setMode("");
						notifyDataSetChanged();
					}
				}
			});

			/////////////////////////////////////
			// SPINNER MINERAL
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (2/7)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerMineral = (Spinner) convertView.findViewById(R.id.ma_bedrock_spinner_mineral);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp2.setElements(pldb.getCol2("lutBEDMAMineralogy", maBedrockEntity.getMa()));
			sp2.setNewElement(pldb, "lutBEDMAMineralogy", 2, maBedrockEntity.getMa(), null);
			spinnerMineral.setAdapter(sp2);
			spinnerMineral.setSelection(sp2.getPosition(maBedrockEntity.getMineral()));
			spinnerMineral.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					String tmp = parent.getItemAtPosition(position).toString();
					if(!tmp.equalsIgnoreCase(maBedrockEntity.getMineral()))
					{
						maBedrockEntity.setMineral(parent.getItemAtPosition(position).toString());
						maBedrockEntity.setMode("");
						notifyDataSetChanged();
					}
				}
			});

			/////////////////////////////////////
			// SPINNER MINERAL PERCENT
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (3/7)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerMineralPercent = (Spinner) convertView.findViewById(R.id.ma_bedrock_spinner_mineralPercent);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp3.setElements(pldb.getCol1("lutBEDGeneralPercent5incr"));
			sp3.setNewElement(pldb, "lutBEDGeneralPercent5incr", 1, null, null);
			sp3.addSpace();
			spinnerMineralPercent.setAdapter(sp3);
			spinnerMineralPercent.setSelection(sp3.getPosition(maBedrockEntity.getMode()));
			spinnerMineralPercent.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					maBedrockEntity.setMode(parent.getItemAtPosition(position).toString());
				}
			});

			/////////////////////////////////////
			// CONCAT SPINNER DISTRIBUTION
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (4/7)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerDistribution = (Spinner) convertView.findViewById(R.id.ma_bedrock_spinner_distribution);
			SpinnerController sp4 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp4.setElements(pldb.getCol2("lutBEDMADistribute", maBedrockEntity.getMa()));
			sp4.setNewElement(pldb, "lutBEDMADistribute", 2, maBedrockEntity.getMa(), null);
			spinnerDistribution.setAdapter(sp4);
			spinnerDistribution.setSelection(sp4.getPosition(maBedrockEntity.getDistribute()));
			spinnerDistribution.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
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

			/////////////////////////////////////
			// CONCAT EDITTEXT DISTRIBUTION
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (5/7)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextMA = (EditText) convertView.findViewById(R.id.ma_bedrock_editText_mA);
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
			
			/////////////////////////////////////
			// CONCAT BUTTON DISTRIBUTION
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (6/7)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Button buttonMAClear = (Button) convertView.findViewById(R.id.ma_bedrock_button_mAClear);
			buttonMAClear.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					maBedrockEntity.setDistribute("");
					notifyDataSetChanged();
				}
			});
			
			/////////////////////////////////////
			// SPINNER WHAT AFFECTED
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (7/7)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerWhatAffected = (Spinner) convertView.findViewById(R.id.ma_bedrock_spinner_whatAffected);
			SpinnerController sp5 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp5.setElements(pldb.getCol1("lutBEDMAUnit"));
			sp5.setNewElement(pldb, "lutBEDMAUnit", 1, null, null);
			sp5.addSpace();
			spinnerWhatAffected.setAdapter(sp5);
			spinnerWhatAffected.setSelection(sp5.getPosition(maBedrockEntity.getUnit()));
			spinnerWhatAffected.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					maBedrockEntity.setUnit(parent.getItemAtPosition(position).toString());
				}
			});

		} else if (tab == 2) {
			convertView = mInflater.inflate(R.layout.ma_bedrock2, null);

			/////////////////////////////////////
			// EDITTEXT NOTE (254)
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 2 - ELEMENT (1/1)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextNote = (EditText) convertView.findViewById(R.id.ma_bedrock_editText_note);
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
	

	public void clear() {
		maBedrockEntity.clearEntity();
		tab = 1;
		notifyDataSetChanged();
	
	}
}
