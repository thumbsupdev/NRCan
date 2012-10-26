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
			EarthmatBedrock1 holder;
			holder = new EarthmatBedrock1();
			convertView = mInflater.inflate(R.layout.earthmat_bedrock1, null);

			holder.spinnerGroup = (Spinner) convertView
					.findViewById(R.id.earthmat_bedrock_spinner_group);
			holder.spinnerType = (Spinner) convertView
					.findViewById(R.id.earthmat_bedrock_spinner_type);
			holder.spinnerDetail = (Spinner) convertView
					.findViewById(R.id.earthmat_bedrock_spinner_detail);
			holder.spinnerUnit = (Spinner) convertView
					.findViewById(R.id.earthmat_bedrock_spinner_unit);
			holder.spinnerOccurs = (Spinner) convertView
					.findViewById(R.id.earthmat_bedrock_spinner_occursAs);

			convertView.setTag(holder);
		} else if (tab == 2) {
			EarthmatBedrock2 holder;
			holder = new EarthmatBedrock2();
			convertView = mInflater.inflate(R.layout.earthmat_bedrock2, null);

			holder.spinnerStructure = (Spinner) convertView
					.findViewById(R.id.earthmat_bedrock_spinner_structure);
			holder.buttonStructure = (Button) convertView
					.findViewById(R.id.earthmat_bedrock_button_structure);
			holder.editTextStructure = (EditText) convertView
					.findViewById(R.id.earthmat_bedrock_editText_structure);

			holder.spinnerTexture = (Spinner) convertView
					.findViewById(R.id.earthmat_bedrock_spinner_texture);
			holder.buttonTexture = (Button) convertView
					.findViewById(R.id.earthmat_bedrock_button_texture);
			holder.editTextTexture = (EditText) convertView
					.findViewById(R.id.earthmat_bedrock_editText_texture);

			holder.spinnerComposition = (Spinner) convertView
					.findViewById(R.id.earthmat_bedrock_spinner_composition);
			holder.buttonComposition = (Button) convertView
					.findViewById(R.id.earthmat_bedrock_button_composition);
			holder.editTextComposition = (EditText) convertView
					.findViewById(R.id.earthmat_bedrock_editText_composition);

			convertView.setTag(holder);
		} else if (tab == 3) {
			EarthmatBedrock3 holder;
			holder = new EarthmatBedrock3();
			convertView = mInflater.inflate(R.layout.earthmat_bedrock3, null);

			holder.spinnerGrnCry = (Spinner) convertView
					.findViewById(R.id.earthmat_bedrock_spinner_grnCry);
			holder.buttonGrnCry = (Button) convertView
					.findViewById(R.id.earthmat_bedrock_button_grnCry);
			holder.editTextGrnCry = (EditText) convertView
					.findViewById(R.id.earthmat_bedrock_editText_grnCry);

			holder.spinnerDefFabric = (Spinner) convertView
					.findViewById(R.id.earthmat_bedrock_spinner_defFabric);
			holder.buttonDefFabric = (Button) convertView
					.findViewById(R.id.earthmat_bedrock_button_defFabric);
			holder.editTextDefFabric = (EditText) convertView
					.findViewById(R.id.earthmat_bedrock_editText_defFabric);

			holder.spinnerBedThick = (Spinner) convertView
					.findViewById(R.id.earthmat_bedrock_spinner_bedThick);
			holder.buttonBedThick = (Button) convertView
					.findViewById(R.id.earthmat_bedrock_button_bedThick);
			holder.editTextBedThick = (EditText) convertView
					.findViewById(R.id.earthmat_bedrock_editText_bedThick);

			convertView.setTag(holder);
		} else if (tab == 4) {
			EarthmatBedrock4 holder;
			holder = new EarthmatBedrock4();
			convertView = mInflater.inflate(R.layout.earthmat_bedrock4, null);

			holder.spinnerRock = (Spinner) convertView
					.findViewById(R.id.earthmat_bedrock_spinner_rock);
			holder.spinnerMineral = (Spinner) convertView
					.findViewById(R.id.earthmat_bedrock_spinner_mineral);
			holder.spinnerMode = (Spinner) convertView
					.findViewById(R.id.earthmat_bedrock_spinner_mode);
			holder.buttonAdd = (Button) convertView
					.findViewById(R.id.earthmat_bedrock_button_add);
			holder.buttonClear = (Button) convertView
					.findViewById(R.id.earthmat_bedrock_button_grnCry);
			holder.editTextBesideC = (EditText) convertView
					.findViewById(R.id.earthmat_bedrock_editText_grnCry);
			holder.editTextRockDescription = (EditText) convertView
					.findViewById(R.id.earthmat_bedrock_editText_rockDescription);
			
		}else if (tab == 5) {
			EarthmatBedrock5 holder;
			holder = new EarthmatBedrock5();
			convertView = mInflater.inflate(R.layout.earthmat_bedrock5, null);

			holder.spinnerFresh = (Spinner) convertView
					.findViewById(R.id.earthmat_bedrock_spinner_rock);
			holder.spinnerWeathered = (Spinner) convertView
					.findViewById(R.id.earthmat_bedrock_spinner_mineral);
			holder.spinnerIndex = (Spinner) convertView
					.findViewById(R.id.earthmat_bedrock_spinner_mode);
			holder.seekBarIndex = (SeekBar) convertView
					.findViewById(R.id.earthmat_seekbar_index);
			holder.editTextMagSus = (EditText) convertView
					.findViewById(R.id.earthmat_editText_magSusceptibility);
			
		}else if (tab == 6) {
			EarthmatBedrock6 holder;
			holder = new EarthmatBedrock6();
			convertView = mInflater.inflate(R.layout.earthmat_bedrock6, null);

			holder.spinnerFossil = (Spinner) convertView
					.findViewById(R.id.earthmat_bedrock_spinner_fossil);
			holder.buttonFossil = (Button) convertView
					.findViewById(R.id.earthmat_bedrock_button_fossil);
			holder.editTextFossil = (EditText) convertView
					.findViewById(R.id.earthmat_bedrock_editText_fossil);
			holder.editTextFossilDescription = (EditText) convertView
					.findViewById(R.id.earthmat_bedrock_editText_rockDescription);
			
		}else if (tab == 7) {
			EarthmatBedrock7 holder;
			holder = new EarthmatBedrock7();
			convertView = mInflater.inflate(R.layout.earthmat_bedrock7, null);

			holder.spinnerContactUpper = (Spinner) convertView
					.findViewById(R.id.earthmat_spinner_upper);
			holder.spinnerContactLower = (Spinner) convertView
					.findViewById(R.id.earthmat_spinner_lower);
			
			holder.editTextContactDescription = (EditText) convertView
					.findViewById(R.id.earthmat_bedrock_editText_contactDescription);
			
			
		}else if (tab == 8) {
			EarthmatBedrock8 holder;
			holder = new EarthmatBedrock8();
			convertView = mInflater.inflate(R.layout.earthmat_bedrock8, null);
			holder.editTextLithDescription = (EditText) convertView
					.findViewById(R.id.earthmat_bedrock_editText_lithInterpretation);
			holder.spinnerLithInterp = (Spinner) convertView
					.findViewById(R.id.earthmat_spinner_lithInterpConfidence);
			
			
			
			
			
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

	static class EarthmatBedrock1 {

		Spinner spinnerGroup;
		Spinner spinnerType;
		Spinner spinnerDetail;
		Spinner spinnerUnit;
		Spinner spinnerOccurs;

	}

	static class EarthmatBedrock2 {
		Spinner spinnerStructure;
		Button buttonStructure;
		EditText editTextStructure;

		Spinner spinnerTexture;
		Button buttonTexture;
		EditText editTextTexture;

		Spinner spinnerComposition;
		Button buttonComposition;
		EditText editTextComposition;

	}

	static class EarthmatBedrock3 {
		Spinner spinnerGrnCry;
		Button buttonGrnCry;
		EditText editTextGrnCry;

		Spinner spinnerDefFabric;
		Button buttonDefFabric;
		EditText editTextDefFabric;

		Spinner spinnerBedThick;
		Button buttonBedThick;
		EditText editTextBedThick;

	}

	static class EarthmatBedrock4 {
		Spinner spinnerRock;
		Spinner spinnerMineral;
		Spinner spinnerMode;
		Button buttonAdd;
		Button buttonClear;
		EditText editTextBesideC;
		EditText editTextRockDescription;
	}

	static class EarthmatBedrock5 {
		Spinner spinnerFresh;
		Spinner spinnerWeathered;
		Spinner spinnerIndex;
		SeekBar seekBarIndex;
		EditText editTextMagSus;
	}

	static class EarthmatBedrock6 {
		Spinner spinnerFossil;
		Button buttonFossil;
		EditText editTextFossil;
		EditText editTextFossilDescription;
	}

	static class EarthmatBedrock7 {
		Spinner spinnerContactUpper;
		Spinner spinnerContactLower;
		EditText editTextContactDescription;
	}

	static class EarthmatBedrock8 {
		EditText editTextLithDescription;
		Spinner spinnerLithInterp;
	}
}
