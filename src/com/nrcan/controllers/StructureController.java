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

public class StructureController extends BaseAdapter implements Filterable {
	private LayoutInflater mInflater;
	private Activity activity;
	private Context context;
	private int tab;

	public StructureController(Context context, Activity activity) {
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
			
			convertView = mInflater.inflate(R.layout.structure_1, null);

			Spinner spinnerClass = (Spinner) convertView
					.findViewById(R.id.structure_spinner_class);
			SpinnerController sp1 = new SpinnerController(context, activity, "lutBEDStrucType");
			spinnerClass.setAdapter(sp1);
			sp1.setElementsCol1();
			
			Spinner spinnerType = (Spinner) convertView
					.findViewById(R.id.structure_spinner_type);
			SpinnerController sp2 = new SpinnerController(context, activity, "lutBEDStrucType");
			spinnerType.setAdapter(sp2);
			sp2.setElementsCol2(""); // NEEDS INPUT (based on class)
			
			Spinner spinnerDetail = (Spinner) convertView
					.findViewById(R.id.structure_spinner_detail);
			SpinnerController sp3 = new SpinnerController(context, activity, "lutBEDStrucType");
			spinnerDetail.setAdapter(sp3);
			sp3.setElementsCol3("",""); // NEEDS INPUT (based on class & type)
			

			
		} else if (tab == 2) {
			
			convertView = mInflater.inflate(R.layout.structure_2, null);

			Spinner spinnerMethod = (Spinner) convertView
					.findViewById(R.id.structure_spinner_method);
			SpinnerController sp1 = new SpinnerController(context, activity, "lutBEDGeneralStrucMethod");
			spinnerMethod.setAdapter(sp1);
			sp1.setElementsCol1();
			
			Spinner spinnerFormat = (Spinner) convertView
					.findViewById(R.id.structure_spinner_format);
			SpinnerController sp2 = new SpinnerController(context, activity, "lutBEDGeneralStrucFormat");
			spinnerFormat.setAdapter(sp2);
			sp2.setElementsCol1();
			
			EditText editTextStrike = (EditText) convertView
					.findViewById(R.id.structure_text_strike);
			EditText editTextDip = (EditText) convertView
					.findViewById(R.id.structure_text_dip);
			
		} else if (tab == 3) {
			
			convertView = mInflater.inflate(R.layout.structure_3, null);

			Spinner spinnerAttitude = (Spinner) convertView
					.findViewById(R.id.structure_spinner_attitude);
			SpinnerController sp1 = new SpinnerController(context, activity, "lutBEDStrucAttitude");
			spinnerAttitude.setAdapter(sp1);
			sp1.setElementsCol1();
			
			Spinner spinnerYounging = (Spinner) convertView
					.findViewById(R.id.structure_spinner_younging);
			SpinnerController sp2 = new SpinnerController(context, activity, "lutBEDStrucYounging");
			spinnerYounging.setAdapter(sp2);
			sp2.setElementsCol1();
			
			Spinner spinnerGeneration = (Spinner) convertView
					.findViewById(R.id.structure_spinner_generation);
			SpinnerController sp3 = new SpinnerController(context, activity, "lutBEDStrucGeneration");
			spinnerGeneration.setAdapter(sp3);
			sp3.setElementsCol1();
			
			Spinner spinnerStrain = (Spinner) convertView
					.findViewById(R.id.structure_spinner_strain);
			SpinnerController sp4 = new SpinnerController(context, activity, "lutBEDStrucStrain");
			spinnerStrain.setAdapter(sp4);
			sp4.setElementsCol1();
			
			Spinner spinnerFlattening = (Spinner) convertView
					.findViewById(R.id.structure_spinner_flattening);
			SpinnerController sp5 = new SpinnerController(context, activity, "lutBEDStrucFlattening");
			spinnerFlattening.setAdapter(sp5);
			sp5.setElementsCol1();
			
			EditText editTextRelated = (EditText) convertView
					.findViewById(R.id.structure_editText_related);

			
		} else if (tab == 4) {
			
			convertView = mInflater.inflate(R.layout.structure_4, null);

			EditText editTextFabric = (EditText) convertView
					.findViewById(R.id.structure_text_fabric);
			EditText editTextSense = (EditText) convertView
					.findViewById(R.id.structure_text_sense);

			
		} else if (tab == 5) {
			
			convertView = mInflater.inflate(R.layout.structure_5, null);

			EditText editTextNote = (EditText) convertView
					.findViewById(R.id.structure_text_sense);

			
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
