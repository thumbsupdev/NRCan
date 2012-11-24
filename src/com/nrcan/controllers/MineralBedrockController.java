package com.nrcan.controllers;

import com.nrcan.entities.MineralBedrockEntity;
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
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.Spinner;

public class MineralBedrockController extends BaseAdapter implements Filterable {
	private LayoutInflater mInflater;
	//private Activity activity;
	private Context context;
	private int tab;
	private MineralBedrockEntity mineralBedrockEntity;
	private PicklistDatabaseHandler pldb;

	public MineralBedrockController(Context context, Activity activity, MineralBedrockEntity mineralBedrockEntity, PicklistDatabaseHandler pldb) {
		this.mInflater = LayoutInflater.from(context);
		//this.activity = activity;
		this.context = context;
		this.tab = 1;
		this.pldb = pldb;
		this.mineralBedrockEntity = mineralBedrockEntity;
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
			
			/////////////////////////////////////
			// SPINNER MINERAL
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (1/2)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerMineral = (Spinner) convertView.findViewById(R.id.mineral_bedrock_spinner_mineral);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutBEDMineralMineral"));
			sp1.setNewElement(pldb, "lutBEDMineralMineral", 1, null, null);
			sp1.addSpace();
			spinnerMineral.setAdapter(sp1);
			spinnerMineral.setSelection(sp1.getPosition(mineralBedrockEntity.getMineral()));
			spinnerMineral.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					mineralBedrockEntity.setMineral(parent.getItemAtPosition(position).toString());
				}
			});
			
			/////////////////////////////////////
			// EDITTEXT PERCENT
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (2/2)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextMode = (EditText) convertView.findViewById(R.id.mineral_bedrock_editText_percent);
			editTextMode.setText(mineralBedrockEntity.getMode());
			editTextMode.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						mineralBedrockEntity.setMode("");
					else
						mineralBedrockEntity.setMode(s.toString());
				}
			});
			
		} else if (tab == 2) {
			convertView = mInflater.inflate(R.layout.mineral_bedrock2, null);
			
			/////////////////////////////////////
			// SPINNER COLOUR
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 2 - ELEMENT (1/3)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerColour = (Spinner) convertView.findViewById(R.id.mineral_bedrock_spinner_colour);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutBEDMineralColour"));
			sp1.setNewElement(pldb, "lutBEDMineralColour", 1, null, null);
			sp1.addSpace();
			spinnerColour.setAdapter(sp1);
			spinnerColour.setSelection(sp1.getPosition(mineralBedrockEntity.getColour()));
			spinnerColour.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					mineralBedrockEntity.setColour(parent.getItemAtPosition(position).toString());
				}
			});
			
			/////////////////////////////////////
			// EDITTEXT SIZE MIN
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 2 - ELEMENT (2/3)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextMin = (EditText) convertView.findViewById(R.id.mineal_bedrock_editText_min);
			editTextMin.setText(mineralBedrockEntity.getSizeMinmm());
			editTextMin.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						mineralBedrockEntity.setSizeMinmm("");
					else
						mineralBedrockEntity.setSizeMinmm(s.toString());
				}
			});
			
			/////////////////////////////////////
			// EDITTEXT SIZE MAX
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 2 - ELEMENT (3/3)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextMax = (EditText) convertView.findViewById(R.id.mineral_bedrock_editText_max);
			editTextMax.setText(mineralBedrockEntity.getSizeMaxmm());
			editTextMax.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						mineralBedrockEntity.setSizeMaxmm("");
					else
						mineralBedrockEntity.setSizeMaxmm(s.toString());
				}
			});
			
		} else if (tab == 3) {
			convertView = mInflater.inflate(R.layout.mineral_bedrock3, null);
			
			/////////////////////////////////////
			// SPINNER FORM
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 3 - ELEMENT (1/3)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerForm = (Spinner) convertView.findViewById(R.id.mineral_bedrock_spinner_form);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutBEDMineralForm"));
			sp1.setNewElement(pldb, "lutBEDMineralForm", 1, null, null);
			sp1.addSpace();
			spinnerForm.setAdapter(sp1);
			spinnerForm.setSelection(sp1.getPosition(mineralBedrockEntity.getForm()));
			spinnerForm.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					mineralBedrockEntity.setForm(parent.getItemAtPosition(position).toString());
				}
			});
			
			/////////////////////////////////////
			// SPINNER HABIT
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 3 - ELEMENT (2/3)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerHabit = (Spinner) convertView.findViewById(R.id.mineral_bedrock_spinner_habit);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp2.setElements(pldb.getCol1("lutBEDMineralHabit"));
			sp2.setNewElement(pldb, "lutBEDMineralHabit", 1, null, null);
			sp2.addSpace();
			spinnerHabit.setAdapter(sp2);
			spinnerHabit.setSelection(sp2.getPosition(mineralBedrockEntity.getHabit()));
			spinnerHabit.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					mineralBedrockEntity.setHabit(parent.getItemAtPosition(position).toString());
				}
			});
			
			/////////////////////////////////////
			// SPINNER OCCURANCE
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 3 - ELEMENT (3/3)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerOccur = (Spinner) convertView.findViewById(R.id.mineral_bedrock_spinner_occur);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp3.setElements(pldb.getCol1("lutBEDMineralOccur"));
			sp3.setNewElement(pldb, "lutBEDMineralOccur", 1, null, null);
			sp3.addSpace();
			spinnerOccur.setAdapter(sp3);
			spinnerOccur.setSelection(sp3.getPosition(mineralBedrockEntity.getOccurrence()));
			spinnerOccur.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					mineralBedrockEntity.setOccurrence(parent.getItemAtPosition(position).toString());
				}
			});
			
		} else if (tab == 4) {
			convertView = mInflater.inflate(R.layout.mineral_bedrock4, null);

			/////////////////////////////////////
			// EDITTEXT NOTE (254)
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 4 - ELEMENT (1/1)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextNotes = (EditText) convertView.findViewById(R.id.mineral_editText_note);
			editTextNotes.setText(mineralBedrockEntity.getNotes());
			editTextNotes.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						mineralBedrockEntity.setNotes("");
					else
						mineralBedrockEntity.setNotes(s.toString());
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
