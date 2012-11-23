package com.nrcan.controllers;

import java.util.ArrayList;

import com.nrcan.entities.EarthmatBedrockEntity;
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

public class EarthmatBedrockController extends BaseAdapter implements Filterable {
	private LayoutInflater mInflater;
	private Activity activity;
	private Context context;
	private int tab;
	private EarthmatBedrockEntity earthmatBedrockEntity;
	private PicklistDatabaseHandler pldb;

	public EarthmatBedrockController(Context context, Activity activity, EarthmatBedrockEntity earthmatBedrockEntity, PicklistDatabaseHandler pldb) {
		this.mInflater = LayoutInflater.from(context);
		this.activity = activity;
		this.context = context;
		this.tab = 1;
		this.earthmatBedrockEntity = earthmatBedrockEntity;
		this.pldb = pldb;
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
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutBEDEarthmatRocktype"));
			spinnerGroup.setAdapter(sp1);
			spinnerGroup.setSelection(sp1.getPosition(earthmatBedrockEntity.getLithGroup()));
			spinnerGroup.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					String tmp = parent.getItemAtPosition(position).toString();
					if(!tmp.equalsIgnoreCase(earthmatBedrockEntity.getLithGroup()))
					{
						earthmatBedrockEntity.setLithGroup(tmp);
						earthmatBedrockEntity.setLithType("");
						earthmatBedrockEntity.setLithDetail("");
						earthmatBedrockEntity.setOccurAs("");
						notifyDataSetChanged();
					}
				}
			});

			Spinner spinnerType = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_type);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp2.setElements(pldb.getCol2("lutBEDEarthmatRocktype", earthmatBedrockEntity.getLithGroup()));
			spinnerType.setAdapter(sp2);
			spinnerType.setSelection(sp2.getPosition(earthmatBedrockEntity.getLithType()));
			spinnerType.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					String tmp = parent.getItemAtPosition(position).toString();
					if(!tmp.equalsIgnoreCase(earthmatBedrockEntity.getLithType()))
					{
						earthmatBedrockEntity.setLithType(tmp);
						earthmatBedrockEntity.setLithDetail("");
						notifyDataSetChanged();
					}
				}
			});

			Spinner spinnerDetail = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_detail);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp3.setElements(pldb.getCol3("lutBEDEarthmatRocktype", earthmatBedrockEntity.getLithGroup(), earthmatBedrockEntity.getLithType()));
			spinnerDetail.setAdapter(sp3);
			spinnerDetail.setSelection(sp3.getPosition(earthmatBedrockEntity.getLithDetail()));
			spinnerDetail.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatBedrockEntity.setLithDetail(parent.getItemAtPosition(position).toString());
				}
			});

			Spinner spinnerUnit = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_unit);
			SpinnerController sp4 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp4.setElements(pldb.getCol1("lutBEDEarthmatMapUnit"));
			spinnerUnit.setAdapter(sp4);
			spinnerUnit.setSelection(sp4.getPosition(earthmatBedrockEntity.getMapUnit()));
			spinnerUnit.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatBedrockEntity.setMapUnit(parent.getItemAtPosition(position).toString());
				}
			});

			Spinner spinnerOccurs = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_occursAs);
			SpinnerController sp5 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerOccurs.setAdapter(sp5);
			sp5.setElements(pldb.getCol2("lutBEDEarthmatOccurs", earthmatBedrockEntity.getLithGroup()));
			spinnerOccurs.setSelection(sp5.getPosition(earthmatBedrockEntity.getOccurAs()));
			spinnerOccurs.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatBedrockEntity.setOccurAs(parent.getItemAtPosition(position).toString());
				}
			});

		} else if (tab == 2) {
			convertView = mInflater.inflate(R.layout.earthmat_bedrock2, null);
			
			//
			//////////////////////////////////////
			// VERIFIED
			//////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] DEREK ELLIOT
			// [] JAMIE POSPIECH
			// [] ALEX YEUNG
			// [] PIERRE LAFOREST-GRANT
			//////////////////////////////////////
			Spinner spinnerStructure = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_structure);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol2("lutBEDEarthmatStructural", earthmatBedrockEntity.getLithGroup()));
			spinnerStructure.setAdapter(sp1);
			spinnerStructure.setSelection(sp1.getPosition(earthmatBedrockEntity.getModStruc()));
			spinnerStructure.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					String tmp = earthmatBedrockEntity.getModStruc();
					String sel = parent.getItemAtPosition(position).toString();
					if(!tmp.contains(sel))
					{
						if(tmp.length() > 1)
							earthmatBedrockEntity.setModStruc(tmp + " | " + sel);
						else
							earthmatBedrockEntity.setModStruc(sel);
						
						notifyDataSetChanged();
					}
				}
			});

			EditText editTextStructure = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_structure);
			editTextStructure.setText(earthmatBedrockEntity.getModStruc());
			editTextStructure.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						earthmatBedrockEntity.setModStruc("");
					else
						earthmatBedrockEntity.setModStruc(s.toString());
				}
			});

			Button buttonStructure = (Button) convertView.findViewById(R.id.earthmat_bedrock_button_structure);
			buttonStructure.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					earthmatBedrockEntity.setModStruc("");
					notifyDataSetChanged();
				}
			});

			Spinner spinnerTexture = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_texture);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp2.setElements(pldb.getCol2("lutBEDEarthmatTextural", earthmatBedrockEntity.getLithGroup()));
			spinnerTexture.setAdapter(sp2);
			spinnerTexture.setSelection(sp2.getPosition(earthmatBedrockEntity.getModTexture()));
			spinnerTexture.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatBedrockEntity.setModTexture(parent.getItemAtPosition(position).toString());
				}
			});

			EditText editTextTexture = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_texture);
			editTextTexture.setText(earthmatBedrockEntity.getModTexture());
			editTextTexture.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						earthmatBedrockEntity.setModTexture("");
					else
						earthmatBedrockEntity.setModTexture(s.toString());
				}
			});
			
			Button buttonTexture = (Button) convertView.findViewById(R.id.earthmat_bedrock_button_texture);
			buttonTexture.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					earthmatBedrockEntity.setModTexture("");
					notifyDataSetChanged();
				}
			});

			Spinner spinnerComposition = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_composition);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerComposition.setAdapter(sp3);
			sp3.setElements(pldb.getCol2("lutBEDEarthmatComposition", earthmatBedrockEntity.getLithGroup()));
			spinnerComposition.setSelection(sp3.getPosition(earthmatBedrockEntity.getModComp()));
			spinnerComposition.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatBedrockEntity.setModComp(parent.getItemAtPosition(position).toString());
				}
			});

			EditText editTextComposition = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_composition);
			editTextComposition.setText(earthmatBedrockEntity.getModComp());
			editTextComposition.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						earthmatBedrockEntity.setModComp("");
					else
						earthmatBedrockEntity.setModComp(s.toString());
				}
			});
			
			Button buttonComposition = (Button) convertView.findViewById(R.id.earthmat_bedrock_button_composition);
			buttonComposition.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					earthmatBedrockEntity.setModComp("");
					notifyDataSetChanged();
				}
			});

		} else if (tab == 3) {
			convertView = mInflater.inflate(R.layout.earthmat_bedrock3, null);

			Spinner spinnerGrnCry = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_grnCry);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol2("lutBEDEarthmatGCSize",earthmatBedrockEntity.getLithGroup()));
			spinnerGrnCry.setAdapter(sp1);
			spinnerGrnCry.setSelection(sp1.getPosition(earthmatBedrockEntity.getGrcrySize()));
			spinnerGrnCry.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {

				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatBedrockEntity.setGrcrySize(parent.getItemAtPosition(position).toString());
					System.out.println(parent.getItemAtPosition(position));
				}
			});


			Button buttonGrnCry = (Button) convertView.findViewById(R.id.earthmat_bedrock_button_grnCry);
			EditText editTextGrnCry = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_grnCry);
			editTextGrnCry.setOnFocusChangeListener(new View.OnFocusChangeListener() {
				public void onFocusChange(View v, boolean hasFocus) {
					System.out.println("Changed" + ((EditText)v).getText());
				}
			});

			Spinner spinnerDefFabric = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_defFabric);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp2.setElements(pldb.getCol1("lutBEDEarthmatDeffabric"));
			spinnerDefFabric.setAdapter(sp2);
			spinnerDefFabric.setSelection(sp2.getPosition(earthmatBedrockEntity.getDefFabric()));
			spinnerDefFabric.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {

				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatBedrockEntity.setDefFabric(parent.getItemAtPosition(position).toString());
					System.out.println(parent.getItemAtPosition(position));
				}
			});


			Button buttonDefFabric = (Button) convertView.findViewById(R.id.earthmat_bedrock_button_defFabric);
			EditText editTextDefFabric = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_defFabric);

			Spinner spinnerBedThick = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_bedThick);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp3.setElements(pldb.getCol1("lutBEDEarthmatBedthick"));
			spinnerBedThick.setAdapter(sp3);
			spinnerBedThick.setSelection(sp3.getPosition(earthmatBedrockEntity.getBedThick()));
			spinnerBedThick.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {

				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatBedrockEntity.setBedThick(parent.getItemAtPosition(position).toString());
					System.out.println(parent.getItemAtPosition(position));
				}
			});


			Button buttonBedThick = (Button) convertView.findViewById(R.id.earthmat_bedrock_button_bedThick);
			EditText editTextBedThick = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_bedThick);

		} else if (tab == 4) {

			convertView = mInflater.inflate(R.layout.earthmat_bedrock4, null);

			Spinner spinnerMineral = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_mineral);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutBEDEarthmatMineral"));
			spinnerMineral.setAdapter(sp1);
			spinnerMineral.setSelection(sp1.getPosition(earthmatBedrockEntity.getMineral()));
			spinnerMineral.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {

				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatBedrockEntity.setMineral(parent.getItemAtPosition(position).toString());
					System.out.println(parent.getItemAtPosition(position));
				}
			});


			Button buttonClear = (Button) convertView.findViewById(R.id.earthmat_bedrock_button_mineral);
			EditText editTextMineral = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_mineral);
			EditText editTextRockDescription = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_rockDescription);

		} else if (tab == 5) {

			convertView = mInflater.inflate(R.layout.earthmat_bedrock5, null);

			Spinner spinnerFresh = (Spinner) convertView.findViewById(R.id.earthmat_spinner_fresh);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutBEDEarthmatColour"));
			spinnerFresh.setAdapter(sp1);
			spinnerFresh.setSelection(sp1.getPosition(earthmatBedrockEntity.getColourF()));
			spinnerFresh.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {

				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatBedrockEntity.setColourF(parent.getItemAtPosition(position).toString());
					System.out.println(parent.getItemAtPosition(position));
				}
			});


			Spinner spinnerWeathered = (Spinner) convertView.findViewById(R.id.earthmat_spinner_weathered);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp2.setElements(pldb.getCol1("lutBEDEarthmatColour"));
			spinnerWeathered.setAdapter(sp2);
			spinnerWeathered.setSelection(sp2.getPosition(earthmatBedrockEntity.getColourW()));
			spinnerWeathered.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {

				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatBedrockEntity.setColourW(parent.getItemAtPosition(position).toString());
					System.out.println(parent.getItemAtPosition(position));
				}
			});


			EditText editTextIndex = (EditText) convertView.findViewById(R.id.earthmat_editText_index);
			EditText editTextMagSus = (EditText) convertView.findViewById(R.id.earthmat_editText_magSusceptibility);

		} else if (tab == 6) {

			convertView = mInflater.inflate(R.layout.earthmat_bedrock6, null);

			Spinner spinnerFossil = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_fossil);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutBEDEarthmatFossil"));
			spinnerFossil.setAdapter(sp1);
			spinnerFossil.setSelection(sp1.getPosition(earthmatBedrockEntity.getFossils()));
			spinnerFossil.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {

				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatBedrockEntity.setFossils(parent.getItemAtPosition(position).toString());
					//editTextFossil.setText();
					System.out.println(parent.getItemAtPosition(position));
				}
			});

			Button buttonFossil = (Button) convertView.findViewById(R.id.earthmat_bedrock_button_fossil);
			EditText editTextFossil = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_fossil);
			EditText editTextFossilDescription = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_rockDescription);

		} else if (tab == 7) {

			convertView = mInflater.inflate(R.layout.earthmat_bedrock7, null);

			Spinner spinnerContactUpper = (Spinner) convertView.findViewById(R.id.earthmat_spinner_upper);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutBEDEarthmatContact"));
			spinnerContactUpper.setAdapter(sp1);
			spinnerContactUpper.setSelection(sp1.getPosition(earthmatBedrockEntity.getContactUp()));
			spinnerContactUpper.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {

				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatBedrockEntity.setContactUp(parent.getItemAtPosition(position).toString());
					System.out.println(parent.getItemAtPosition(position));
				}
			});


			Spinner spinnerContactLower = (Spinner) convertView.findViewById(R.id.earthmat_spinner_lower);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerContactLower.setAdapter(sp2);
			sp2.setElements(pldb.getCol1("lutBEDEarthmatContact"));
			spinnerContactLower.setSelection(sp2.getPosition(earthmatBedrockEntity.getContactLow()));
			spinnerContactLower.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {

				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatBedrockEntity.setContactLow(parent.getItemAtPosition(position).toString());
					System.out.println(parent.getItemAtPosition(position));
				}
			});

			EditText editTextContactDescription = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_contactDescription);

		} else if (tab == 8) {

			convertView = mInflater.inflate(R.layout.earthmat_bedrock8, null);

			EditText editTextLithDescription = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_lithInterpretation);
			Spinner spinnerLithInterp = (Spinner) convertView.findViewById(R.id.earthmat_spinner_lithInterpConfidence);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerLithInterp.setAdapter(sp1);
			sp1.setElements(pldb.getCol1("lutBEDEarthmatInterpconf"));
			spinnerLithInterp.setSelection(sp1.getPosition(earthmatBedrockEntity.getInterpConf()));
			spinnerLithInterp.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {

				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatBedrockEntity.setInterpConf("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
		}

		return convertView;
	}

	public Filter getFilter() {
		return null;
	}

	public boolean setTab(int tabNum) {

		if(this.tab == 1){
			if(earthmatBedrockEntity.getLithGroup().equalsIgnoreCase("")){
				return false;
			}
			if(earthmatBedrockEntity.getLithType().equalsIgnoreCase("")){
				return false;
			}
			if(earthmatBedrockEntity.getLithDetail().equalsIgnoreCase("")){
				return false;
			}
		}
		this.tab = tabNum;
		notifyDataSetChanged();
		return true;
	}

}
