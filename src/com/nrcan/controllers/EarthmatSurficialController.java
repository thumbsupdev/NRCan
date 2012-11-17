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

public class EarthmatSurficialController extends BaseAdapter implements
		Filterable {
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

			holder.spinnerGroup = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_group);
			holder.spinnerType = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_type);
			holder.spinnerDetail = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_detail);
			holder.spinnerColour = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_colour);

			convertView.setTag(holder);
		} else if (tab == 2) {
			EarthmatSurficial2 holder;
			holder = new EarthmatSurficial2();
			convertView = mInflater.inflate(R.layout.earthmat_surficial2, null);

			holder.spinnerPrimary = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_primary);
			holder.buttonPrimary = (Button) convertView
					.findViewById(R.id.earthmat_surficial_button_primary_clear);
			holder.editTextPrimary = (EditText) convertView
					.findViewById(R.id.earthmat_surficial_editText_primary);
			holder.spinnerWayUp = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_wayup);
			
			holder.spinnerSecondary = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_secondary);
			holder.buttonSecondary = (Button) convertView
					.findViewById(R.id.earthmat_surficial_button_secondary_clear);
			holder.editTextSecondary = (EditText) convertView
					.findViewById(R.id.earthmat_surficial_editText_secondary);
			convertView.setTag(holder);
		} else if (tab == 3) {
			EarthmatSurficial3 holder;
			holder = new EarthmatSurficial3();
			
			convertView = mInflater.inflate(R.layout.earthmat_surficial3, null);
			holder.spinnerIntThickness = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_intThickness);
			holder.editTextTo = (EditText) convertView
					.findViewById(R.id.earthmat_surficial_editText_to);
			holder.editTextFrom = (EditText) convertView
					.findViewById(R.id.earthmat_surficial_editText_from);
		
			holder.spinnerLowContact = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_lowContact);
			holder.spinnerInterpretation = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_interpretation);
			holder.spinnerLatContact = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_latContact);
			

			convertView.setTag(holder);
		} else if (tab == 4) {
			EarthmatSurficial4 holder;
			holder = new EarthmatSurficial4();
			convertView = mInflater.inflate(R.layout.earthmat_surficial4, null);
			
			holder.spinnerSorting = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_sorting);
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
		} else if (tab == 5) {
			EarthmatSurficial5 holder;
			holder = new EarthmatSurficial5();
			convertView = mInflater.inflate(R.layout.earthmat_surficial5, null);
			holder.spinnerMapUnit = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_mapUnit);
			holder.spinnerSurficialOrigin = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_surficialOrigin);
			

			convertView.setTag(holder);
		} else if (tab == 6) {
			EarthmatSurficial6 holder;
			holder = new EarthmatSurficial6();
			convertView = mInflater.inflate(R.layout.earthmat_surficial6, null);
			holder.editTextModal = (EditText) convertView
					.findViewById(R.id.earthmat_surficial_editText_clastModal);
			holder.editTextMax = (EditText) convertView
					.findViewById(R.id.earthmat_surficial_editText_clastMax);
			holder.editTextMin = (EditText) convertView
					.findViewById(R.id.earthmat_surficial_editText_clastMin);
			holder.editTextClastPer = (EditText) convertView
					.findViewById(R.id.earthmat_surficial_editText_clastPer);

			holder.spinnerClastForms = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_clastForms);
			holder.spinnerAverageModal = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_averageModal);
			holder.spinnerMaximum = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_roundMax);
			holder.spinnerMinimum = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_roundMin);

			convertView.setTag(holder);
		} else if (tab == 7) {
			EarthmatSurficial7 holder;
			holder = new EarthmatSurficial7();
			convertView = mInflater.inflate(R.layout.earthmat_surficial7, null);

			holder.spinnerErratic = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_erraticType);
			holder.spinnerErraticPer = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_erraticPer);
			holder.editTextErraticComp = (EditText) convertView
					.findViewById(R.id.earthmat_surficial_editText_erraticComp);
			holder.editTextInterpretation = (EditText) convertView
					.findViewById(R.id.earthmat_surficial_editText_interpretation);
			convertView.setTag(holder);
		} else if (tab == 8) {
			EarthmatSurficial8 holder;
			holder = new EarthmatSurficial8();
			convertView = mInflater.inflate(R.layout.earthmat_surficial8, null);
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

	static class EarthmatSurficial1 {
		Spinner spinnerGroup;
		Spinner spinnerType;
		Spinner spinnerDetail;
		Spinner spinnerColour;
		/*
		 * Spinner spinnerOther; Button buttonOtherClear; EditText
		 * editTextOther; Spinner spinnerInterval; Spinner spinnerInterval2;
		 */
	}

	static class EarthmatSurficial2 {
		Spinner spinnerPrimary;
		Button buttonPrimary;
		EditText editTextPrimary;

		Spinner spinnerWayUp;
		
		Spinner spinnerSecondary;
		Button buttonSecondary;
		EditText editTextSecondary;

	}

	static class EarthmatSurficial3 {
		Spinner spinnerIntThickness;
		EditText editTextTo;
		EditText editTextFrom;
	
		Spinner spinnerLowContact;
		Spinner spinnerInterpretation;
		Spinner spinnerLatContact;

	}

	static class EarthmatSurficial4 {
		Spinner spinnerSorting;
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

	static class EarthmatSurficial5 {
		Spinner spinnerMapUnit;
		
		Spinner spinnerSurficialOrigin;
	}

	static class EarthmatSurficial6 {

		EditText editTextModal;
		EditText editTextMin;
		EditText editTextMax;
		EditText editTextClastPer;

		Spinner spinnerClastForms;
		Spinner spinnerAverageModal;
		Spinner spinnerMaximum;
		Spinner spinnerMinimum;

	}

	static class EarthmatSurficial7 {

		Spinner spinnerErratic;
		Spinner spinnerErraticPer;
		Button buttonErraticClear;
		EditText editTextErraticComp;
		EditText editTextInterpretation;
		Spinner spinnerInterpConf;

	}

	static class EarthmatSurficial8 {
		EditText editTextNotes;
	}

}
