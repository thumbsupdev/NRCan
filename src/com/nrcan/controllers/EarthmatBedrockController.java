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

public class EarthmatBedrockController extends BaseAdapter implements Filterable {
	private LayoutInflater mInflater;
	private Activity activity;
	private Context context;
	private int tab;

	public EarthmatBedrockController(Context context, Activity activity) {
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
			convertView = mInflater.inflate(R.layout.earthmat_bedrock1, null);

			Spinner spinnerGroup = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_group);
			SpinnerController sp1 = new SpinnerController(context, activity, "lutBEDEarthmatRocktype");
			spinnerGroup.setAdapter(sp1);
			sp1.setElementsCol1();
			
			Spinner spinnerType = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_type);
			SpinnerController sp2 = new SpinnerController(context, activity, "lutBEDEarthmatRocktype");
			spinnerType.setAdapter(sp2);
			sp2.setElementsCol2(""); // NEEDS INPUT
			
			
			Spinner spinnerDetail = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_detail);
			SpinnerController sp3 = new SpinnerController(context, activity, "lutBEDEarthmatRocktype");
			spinnerDetail.setAdapter(sp3);
			sp3.setElementsCol3("",""); // NEEDS INPUT
			
			Spinner spinnerUnit = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_unit);
			SpinnerController sp4 = new SpinnerController(context, activity, "lutBEDEarthmatMapunit");
			spinnerUnit.setAdapter(sp4);
			sp4.setElementsCol1(); 
			
			
			Spinner spinnerOccurs = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_occursAs);
			SpinnerController sp5 = new SpinnerController(context, activity, "lutBEDEarthmatOccurs");
			spinnerOccurs.setAdapter(sp5);
			sp5.setElementsCol2("");  // NEEDS INPUT
			
		} else if (tab == 2) {
			
			convertView = mInflater.inflate(R.layout.earthmat_bedrock2, null);

			Spinner spinnerStructure = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_structure);
			SpinnerController sp1 = new SpinnerController(context, activity, "lutBEDEarthmatStructural");
			spinnerStructure.setAdapter(sp1);
			sp1.setElementsCol2(""); // NEEDS INPUT
			
			
			Button buttonStructure = (Button) convertView.findViewById(R.id.earthmat_bedrock_button_structure);
			EditText editTextStructure = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_structure);

			Spinner spinnerTexture = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_texture);
			SpinnerController sp2 = new SpinnerController(context, activity, "lutBEDEarthmatTextural");
			spinnerTexture.setAdapter(sp2);
			sp2.setElementsCol2(""); // NEEDS INPUT
			
			
			Button buttonTexture = (Button) convertView.findViewById(R.id.earthmat_bedrock_button_texture);
			EditText editTextTexture = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_texture);

			Spinner spinnerComposition = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_composition);
			SpinnerController sp3 = new SpinnerController(context, activity, "lutBEDEarthmatComposition");
			spinnerComposition.setAdapter(sp3);
			sp3.setElementsCol2(""); // NEEDS INPUT
			
			
			
			Button buttonComposition = (Button) convertView.findViewById(R.id.earthmat_bedrock_button_composition);
			EditText editTextComposition = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_composition);

			
		} else if (tab == 3) {
			
			convertView = mInflater.inflate(R.layout.earthmat_bedrock3, null);

			Spinner spinnerGrnCry = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_grnCry);
			SpinnerController sp1 = new SpinnerController(context, activity, "lutBEDEarthmatGCSize");
			spinnerGrnCry.setAdapter(sp1);
			sp1.setElementsCol2(""); // NEEDS INPUT
			
			
			Button buttonGrnCry = (Button) convertView.findViewById(R.id.earthmat_bedrock_button_grnCry);
			EditText editTextGrnCry = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_grnCry);

			Spinner spinnerDefFabric = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_defFabric);
			SpinnerController sp2 = new SpinnerController(context, activity, "lutBEDEarthmatDeffabric");
			spinnerDefFabric.setAdapter(sp2);
			sp2.setElementsCol1(); 
			
			
			Button buttonDefFabric = (Button) convertView.findViewById(R.id.earthmat_bedrock_button_defFabric);
			EditText editTextDefFabric = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_defFabric);

			Spinner spinnerBedThick = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_bedThick);
			SpinnerController sp3 = new SpinnerController(context, activity, "lutBEDEarthmatBedthick");
			spinnerBedThick.setAdapter(sp3);
			sp3.setElementsCol1();
			
			
			Button buttonBedThick = (Button) convertView.findViewById(R.id.earthmat_bedrock_button_bedThick);
			EditText editTextBedThick = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_bedThick);

			
		} else if (tab == 4) {
			
			
			convertView = mInflater.inflate(R.layout.earthmat_bedrock4, null);

			Spinner spinnerMineral = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_mineral);
			SpinnerController sp1 = new SpinnerController(context, activity, "lutBEDEarthmatMineral");
			spinnerMineral.setAdapter(sp1);
			sp1.setElementsCol1(); 
			
			
			Button buttonClear = (Button) convertView.findViewById(R.id.earthmat_bedrock_button_mineral);
			EditText editTextMineral = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_mineral);
			EditText editTextRockDescription = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_rockDescription);

		} else if (tab == 5) {
			
			convertView = mInflater.inflate(R.layout.earthmat_bedrock5, null);

			Spinner spinnerFresh = (Spinner) convertView.findViewById(R.id.earthmat_spinner_fresh);
			SpinnerController sp1 = new SpinnerController(context, activity, "lutBEDEarthmatColour");
			spinnerFresh.setAdapter(sp1);
			sp1.setElementsCol1(); 
			
			
			Spinner spinnerWeathered = (Spinner) convertView.findViewById(R.id.earthmat_spinner_weathered);
			SpinnerController sp2 = new SpinnerController(context, activity, "lutBEDEarthmatColour");
			spinnerWeathered.setAdapter(sp2);
			sp2.setElementsCol1(); 
			
			
			EditText editTextIndex = (EditText) convertView.findViewById(R.id.earthmat_editText_index);
			EditText editTextMagSus = (EditText) convertView
					.findViewById(R.id.earthmat_editText_magSusceptibility);

		} else if (tab == 6) {
			
			convertView = mInflater.inflate(R.layout.earthmat_bedrock6, null);

			Spinner spinnerFossil = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_fossil);
			SpinnerController sp1 = new SpinnerController(context, activity, "lutBEDEarthmatFossil");
			spinnerFossil.setAdapter(sp1);
			sp1.setElementsCol1();
			
			Button buttonFossil = (Button) convertView.findViewById(R.id.earthmat_bedrock_button_fossil);
			EditText editTextFossil = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_fossil);
			EditText editTextFossilDescription = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_rockDescription);

		} else if (tab == 7) {
			
			convertView = mInflater.inflate(R.layout.earthmat_bedrock7, null);

			Spinner spinnerContactUpper = (Spinner) convertView.findViewById(R.id.earthmat_spinner_upper);
			SpinnerController sp1 = new SpinnerController(context, activity, "lutBEDEarthmatContact");
			spinnerContactUpper.setAdapter(sp1);
			sp1.setElementsCol1();
			
			
			Spinner spinnerContactLower = (Spinner) convertView.findViewById(R.id.earthmat_spinner_lower);
			SpinnerController sp2 = new SpinnerController(context, activity, "lutBEDEarthmatContact");
			spinnerContactLower.setAdapter(sp2);
			sp2.setElementsCol1();

			EditText editTextContactDescription = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_contactDescription);

		} else if (tab == 8) {
			
			convertView = mInflater.inflate(R.layout.earthmat_bedrock8, null);
			EditText editTextLithDescription = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_lithInterpretation);
			Spinner spinnerLithInterp = (Spinner) convertView.findViewById(R.id.earthmat_spinner_lithInterpConfidence);
			SpinnerController sp1 = new SpinnerController(context, activity, "lutBEDInterpconf");
			spinnerLithInterp.setAdapter(sp1);
			sp1.setElementsCol1();

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
