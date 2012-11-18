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
			
			convertView = mInflater.inflate(R.layout.earthmat_surficial1, null);

			Spinner spinnerGroup = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_group);
			SpinnerController sp1 = new SpinnerController(context, activity, "lutSUREarthmatLith2");
			spinnerGroup.setAdapter(sp1);
			sp1.setElementsCol1();
			
			
			Spinner spinnerType = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_type);
			SpinnerController sp2 = new SpinnerController(context, activity, "lutSUREarthmatLith2");
			spinnerType.setAdapter(sp2);
			sp2.setElementsCol2(""); // NEEDS INPUT
			
			Spinner spinnerDetail = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_detail);
			SpinnerController sp3 = new SpinnerController(context, activity, "lutSUREarthmatLith2");
			spinnerDetail.setAdapter(sp3);
			sp3.setElementsCol3("",""); // NEEDS INPUT
			
			Spinner spinnerColour = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_colour);
			SpinnerController sp4 = new SpinnerController(context, activity, "lutSUREarthmatColour");
			spinnerColour.setAdapter(sp4);
			sp4.setElementsCol1();

			
		} else if (tab == 2) {
			
			convertView = mInflater.inflate(R.layout.earthmat_surficial2, null);

			Spinner spinnerPrimary = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_primary);
			SpinnerController sp1 = new SpinnerController(context, activity, "lutSUREarthmatPrimestruct");
			spinnerPrimary.setAdapter(sp1);
			sp1.setElementsCol1();
			
			Button buttonPrimary = (Button) convertView.findViewById(R.id.earthmat_surficial_button_primary_clear);
			EditText editTextPrimary = (EditText) convertView.findViewById(R.id.earthmat_surficial_editText_primary);
			
			
			Spinner spinnerWayUp = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_wayup);
			SpinnerController sp2= new SpinnerController(context, activity, "lutSUREarthmatWayup");
			spinnerWayUp.setAdapter(sp2);
			sp2.setElementsCol1();
			
			
			Spinner spinnerSecondary = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_secondary);
			SpinnerController sp3 = new SpinnerController(context, activity, "lutSUREarthmatScndstruct");
			spinnerSecondary.setAdapter(sp3);
			sp3.setElementsCol1();
			
			Button buttonSecondary = (Button) convertView.findViewById(R.id.earthmat_surficial_button_secondary_clear);
			EditText editTextSecondary = (EditText) convertView.findViewById(R.id.earthmat_surficial_editText_secondary);
			
		} else if (tab == 3) {
			
			
			convertView = mInflater.inflate(R.layout.earthmat_surficial3, null);
			Spinner spinnerIntThickness = (Spinner) convertView	.findViewById(R.id.earthmat_surficial_spinner_intThickness);
			SpinnerController sp1 = new SpinnerController(context, activity, "lutSUREarthmatThickType");
			spinnerIntThickness.setAdapter(sp1);
			sp1.setElementsCol1();
			
			
			EditText editTextTo = (EditText) convertView.findViewById(R.id.earthmat_surficial_editText_to);
			EditText editTextFrom = (EditText) convertView.findViewById(R.id.earthmat_surficial_editText_from);
		
			Spinner spinnerLowContact = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_lowContact);
			SpinnerController sp2 = new SpinnerController(context, activity, "lutSUREarthmatLwrcontact");
			spinnerLowContact.setAdapter(sp2);
			sp2.setElementsCol1();
			
			Spinner spinnerInterpretation = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_interpretation);
			SpinnerController sp3 = new SpinnerController(context, activity, "lutSUREarthmatIntcontact");
			spinnerInterpretation.setAdapter(sp3);
			sp3.setElementsCol1();
			
			
			Spinner spinnerLatContact = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_latContact);
			SpinnerController sp4 = new SpinnerController(context, activity, "lutSUREarthmatLatcontact");
			spinnerLatContact.setAdapter(sp4);
			sp4.setElementsCol1();

			
		} else if (tab == 4) {
			
			convertView = mInflater.inflate(R.layout.earthmat_surficial4, null);
			
			Spinner spinnerSorting = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_sorting);
			SpinnerController sp1 = new SpinnerController(context, activity, "lutSUREarthmatSorting");
			spinnerSorting.setAdapter(sp1);
			sp1.setElementsCol1();
			
			Spinner spinnerMatrix = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_matrix);
			SpinnerController sp2 = new SpinnerController(context, activity, "lutSUREarthmatMatrix");
			spinnerMatrix.setAdapter(sp2);
			sp2.setElementsCol1();
			
			
			Spinner spinnerModifier = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_modifier);
			SpinnerController sp3 = new SpinnerController(context, activity, "lutSUREarthmatMatrixMod");
			spinnerModifier.setAdapter(sp3);
			sp3.setElementsCol1();
			
			Button buttonMatrixClear = (Button) convertView.findViewById(R.id.earthmat_surficial_button_matrixMod_clear);
			EditText editTextMatrixMod = (EditText) convertView.findViewById(R.id.earthmat_surficial_editText_matrixMod);
			Spinner spinnerOxidation = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_oxidation);
			SpinnerController sp4 = new SpinnerController(context, activity, "lutSUREarthmatOxidation");
			spinnerOxidation.setAdapter(sp4);
			sp4.setElementsCol1();
			
			Spinner spinnerCompact = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_compact);
			SpinnerController sp5 = new SpinnerController(context, activity, "lutSUREarthmatCompaction");
			spinnerCompact.setAdapter(sp5);
			sp5.setElementsCol1();
			
			
			Spinner spinnerJointing = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_jointing);
			SpinnerController sp6 = new SpinnerController(context, activity, "lutSUREarthmatJointing");
			spinnerJointing.setAdapter(sp6);
			sp6.setElementsCol1();
			
			
			Spinner spinnerh2oContent = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_h2oContent);
			SpinnerController sp7 = new SpinnerController(context, activity, "lutSUREarthmatH2OContent");
			spinnerh2oContent.setAdapter(sp7);
			sp7.setElementsCol1();
			
			Spinner spinnerHclReact = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_hclReact);
			SpinnerController sp8 = new SpinnerController(context, activity, "lutSUREarthmatHCLReact");
			spinnerHclReact.setAdapter(sp8);
			sp8.setElementsCol1();
			
			
			Spinner spinnerFissility = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_fissility);
			SpinnerController sp9 = new SpinnerController(context, activity, "lutSUREarthmatFissility");
			spinnerFissility.setAdapter(sp9);
			sp9.setElementsCol1();
			
		} else if (tab == 5) {
			
			convertView = mInflater.inflate(R.layout.earthmat_surficial5, null);
			Spinner spinnerMapUnit = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_mapUnit);
			SpinnerController sp1 = new SpinnerController(context, activity, "lutSUREarthmatMapunit");
			spinnerMapUnit.setAdapter(sp1);
			sp1.setElementsCol1();
			
			
			Spinner spinnerSurficialOrigin = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_surficialOrigin);
			SpinnerController sp2 = new SpinnerController(context, activity, "lutSUREarthmatSufform");
			spinnerSurficialOrigin.setAdapter(sp2);
			sp2.setElementsCol1();
			

			
		} else if (tab == 6) {
			
			convertView = mInflater.inflate(R.layout.earthmat_surficial6, null);
			EditText editTextModal = (EditText) convertView
					.findViewById(R.id.earthmat_surficial_editText_clastModal);
			EditText editTextMax = (EditText) convertView
					.findViewById(R.id.earthmat_surficial_editText_clastMax);
			EditText editTextMin = (EditText) convertView
					.findViewById(R.id.earthmat_surficial_editText_clastMin);
			EditText editTextClastPer = (EditText) convertView
					.findViewById(R.id.earthmat_surficial_editText_clastPer);

			Spinner spinnerClastForms = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_clastForms);
			SpinnerController sp1 = new SpinnerController(context, activity, "lutSUREarthmatClastform");
			spinnerClastForms.setAdapter(sp1);
			sp1.setElementsCol1();
			
			
			Spinner spinnerAverageModal = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_averageModal);
			SpinnerController sp2 = new SpinnerController(context, activity, "lutSUREarthmatRoundness");
			spinnerAverageModal.setAdapter(sp2);
			sp2.setElementsCol1();
			
			Spinner spinnerMaximum = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_roundMax);
			SpinnerController sp3 = new SpinnerController(context, activity, "lutSUREarthmatRoundness");
			spinnerMaximum.setAdapter(sp3);
			sp3.setElementsCol1();
			
			Spinner spinnerMinimum = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_roundMin);
			SpinnerController sp4 = new SpinnerController(context, activity, "lutSUREarthmatRoundness");
			spinnerMinimum.setAdapter(sp4);
			sp4.setElementsCol1();
			

			
		} else if (tab == 7) {
			
			convertView = mInflater.inflate(R.layout.earthmat_surficial7, null);

			Spinner spinnerErratic = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_erraticType);
			SpinnerController sp1 = new SpinnerController(context, activity, "lutSUREarthmatErratictyp");
			spinnerErratic.setAdapter(sp1);
			sp1.setElementsCol1();
			
			Spinner spinnerErraticPer = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_erraticPer);
			SpinnerController sp2 = new SpinnerController(context, activity, "lutSURGeneralPercent5incr");
			spinnerErraticPer.setAdapter(sp2);
			sp2.setElementsCol1();
			
			EditText editTextErraticComp = (EditText) convertView
					.findViewById(R.id.earthmat_surficial_editText_erraticComp);
			EditText editTextInterpretation = (EditText) convertView
					.findViewById(R.id.earthmat_surficial_editText_interpretation);
			
		} else if (tab == 8) {
			
		
			convertView = mInflater.inflate(R.layout.earthmat_surficial8, null);
			EditText editTextNotes = (EditText) convertView
					.findViewById(R.id.earthmat_surficial_editText_notes);
			
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
