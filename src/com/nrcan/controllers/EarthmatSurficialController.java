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
import android.widget.Spinner;

public class EarthmatSurficialController extends BaseAdapter implements Filterable {
	private LayoutInflater mInflater;
	private Activity activity;
	private Context context;
	private int tab;
	
	public EarthmatSurficialController(Context context, Activity activity) {
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
			EarthmatSurficial1 holder;
			holder = new EarthmatSurficial1();
			convertView = mInflater.inflate(R.layout.earthmat_surficial1, null);
			
			holder.spinnerMaterial = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_material);
			holder.spinnerGeneral = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_general);
			holder.spinnerPrimary = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_primary);
			holder.spinnerOther = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_other);
			holder.buttonOtherClear = (Button) convertView
					.findViewById(R.id.earthmat_surficial_button_other_clear);
			holder.editTextOther = (EditText) convertView
					.findViewById(R.id.earthmat_surficial_editText_other);
			holder.spinnerInterval = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_interval);
			holder.spinnerInterval2 = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_interval2);
			
			
			convertView.setTag(holder);
		} else if (tab == 2) {
			EarthmatSurficial2 holder;
			holder = new EarthmatSurficial2();
			convertView = mInflater.inflate(R.layout.earthmat_surficial2, null);
			holder.spinnerIntThickness = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_intThickness);
			holder.editTextTo = (EditText) convertView
					.findViewById(R.id.earthmat_surficial_editText_to);
			holder.editTextFrom = (EditText) convertView
					.findViewById(R.id.earthmat_surficial_editText_from);
			holder.editTextColour = (EditText) convertView
					.findViewById(R.id.earthmat_surficial_editText_colour);
			holder.spinnerLowContact = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_lowContact);
			holder.spinnerInterpretation = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_interpretation);
			holder.spinnerLatContact = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_latContact);
			holder.spinnerSorting = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_sorting);
			
			convertView.setTag(holder);
		} else if (tab == 3) {
			EarthmatSurficial3 holder;
			holder = new EarthmatSurficial3();
			convertView = mInflater.inflate(R.layout.earthmat_surficial3, null);
			
			holder.spinnerMatrix = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_matrix);
			holder.spinnerModifier = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_modifier);
			holder.buttonMatrixClear = (Button) convertView
					.findViewById(R.id.earthmat_surficial_button_matrixMod_clear);
			holder.editTextMatrixMod = (EditText) convertView
					.findViewById(R.id.earthmat_surficial_editText_matrixMod);
			holder.spinnerOxidation = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_oxidation);
			holder.spinnerCompact = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_compact);
			holder.spinnerJointing = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_jointing);
			holder.spinnerh2oContent = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_h2oContent);
			holder.spinnerHclReact = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_hclReact);
			holder.spinnerFissility = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_fissility);
			convertView.setTag(holder);
		}else if (tab == 4) {
			EarthmatSurficial4 holder;
			holder = new EarthmatSurficial4();
			convertView = mInflater.inflate(R.layout.earthmat_surficial4, null);
			holder.spinnerUnitValue = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_unitValue);
			holder.spinnerModifier = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_modifier);
			holder.editTextModifier = (EditText) convertView
					.findViewById(R.id.earthmat_surficial_editText_modifier);
			
			convertView.setTag(holder);
		}else if (tab == 5) {
			EarthmatSurficial5 holder;
			holder = new EarthmatSurficial5();
			convertView = mInflater.inflate(R.layout.earthmat_surficial5, null);
			/*
			 * EditText editTextModal;
		EditText editTextMin;
		EditText editTextMax;
		EditText editTextClastPer;
		
		Spinner spinnerClastForms;
		Spinner spinnerAverageModal;
		Spinner spinnerMaximum;
		Spinner spinnerMinimum;
			 */
			holder.editTextModal = (EditText) convertView
					.findViewById(R.id.earthmat_surficial_editText_clastModal);
			holder.editTextMax = (EditText) convertView
					.findViewById(R.id.earthmat_surficial_editText_clastMax);
			holder.editTextMin = (EditText) convertView
					.findViewById(R.id.earthmat_surficial_editText_clastMin);
			holder.editTextClastPer = (EditText) convertView
					.findViewById(R.id.earthmat_surficial_editText_clastPer);
			
			holder.spinnerClastForms= (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_clastForms);
			holder.spinnerAverageModal = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_averageModal);
			holder.spinnerMaximum = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_roundMax);
			holder.spinnerMinimum = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_roundMin);
			
			convertView.setTag(holder);
		}else if (tab == 6) {
			EarthmatSurficial6 holder;
			holder = new EarthmatSurficial6();
			convertView = mInflater.inflate(R.layout.earthmat_surficial6, null);

			holder.editTextErratic = (EditText) convertView
					.findViewById(R.id.earthmat_surficial_editText_erraticType);
			holder.spinnerErraticPer = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_erraticPer);
			holder.editTextErraticComp= (EditText) convertView
					.findViewById(R.id.earthmat_surficial_editText_erraticComp);
			holder.editTextGenFossil = (EditText) convertView
					.findViewById(R.id.earthmat_surficial_editText_genFossilCategories);
			convertView.setTag(holder);
		} else if (tab == 7) {
			EarthmatSurficial7 holder;
			holder = new EarthmatSurficial7();
			convertView = mInflater.inflate(R.layout.earthmat_surficial7, null);
			holder.editTextNotes = (EditText) convertView
					.findViewById(R.id.earthmat_surficial_editText_notes);
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
	
	static class EarthmatSurficial1{
		Spinner spinnerMaterial;
		Spinner spinnerGeneral;
		Spinner spinnerPrimary;
		Spinner spinnerOther;
		Button buttonOtherClear;
		EditText editTextOther;
		Spinner spinnerInterval;
		Spinner spinnerInterval2;
	}
	
	static class EarthmatSurficial2{
		Spinner spinnerIntThickness;
		EditText editTextTo;
		EditText editTextFrom;
		EditText editTextColour;
		Spinner spinnerLowContact;
		Spinner spinnerInterpretation;
		Spinner spinnerLatContact;
		Spinner spinnerSorting;
	}
	
	static class EarthmatSurficial3{
		Spinner spinnerMatrix;
		Spinner spinnerModifier;
		Button buttonMatrixClear;
		EditText editTextMatrixMod;
		Spinner spinnerOxidation;
		Spinner spinnerCompact;
		Spinner spinnerJointing;
		Spinner spinnerh2oContent;
		Spinner spinnerHclReact;
		Spinner spinnerFissility;
		
	}
	static class EarthmatSurficial4{
		Spinner spinnerUnitValue;
		Spinner spinnerModifier;
		EditText editTextModifier;
		
	}
	static class EarthmatSurficial5{
		EditText editTextModal;
		EditText editTextMin;
		EditText editTextMax;
		EditText editTextClastPer;
		
		Spinner spinnerClastForms;
		Spinner spinnerAverageModal;
		Spinner spinnerMaximum;
		Spinner spinnerMinimum;
		
	}
	static class EarthmatSurficial6{
		EditText editTextErratic;
		Spinner spinnerErraticPer;
		Button buttonErraticClear;
		EditText editTextErraticComp;
		EditText editTextGenFossil;
		
	}
	static class EarthmatSurficial7{
		EditText editTextNotes;
	}

}
