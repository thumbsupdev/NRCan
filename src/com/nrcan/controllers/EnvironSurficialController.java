package com.nrcan.controllers;

import com.nrcan.entities.EnvironSurficialEntity;
import com.nrcan.main.PicklistDatabaseHandler;
import com.nrcan.main.R;
import com.nrcan.main.MainActivity;

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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class EnvironSurficialController  extends BaseAdapter implements Filterable {
	private LayoutInflater mInflater;
	private Activity activity;
	private Context context;
	private int tab;
	private PicklistDatabaseHandler pldb;
	private EnvironSurficialEntity environSurficialEntity;

	private boolean gossanBoolean = false;
	private boolean boulderBoolean = false;
	private boolean vegitation1Boolean = true;
	private boolean vegitation2Boolean = false;
	private boolean groundCover1Boolean = true;
	private boolean groundCover2Boolean = false;
	private String vegetationTemp;
	private String groundCoverTemp;

	public EnvironSurficialController(Context context, Activity activity, EnvironSurficialEntity environSurficialEntity, PicklistDatabaseHandler pldb) {
		this.mInflater = LayoutInflater.from(context);
		this.activity = activity;
		this.context = context;
		this.tab = 1;
		this.environSurficialEntity = environSurficialEntity;
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
		if(tab == 1)
		{
			convertView = mInflater.inflate(R.layout.environ_surficial1, null);

			/////////////////////////////////////
			// SPINNER RELIEF
			//
			// Drop-down for "Relief" - Column 1 of lutSUREnvironsRelief Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (1/8)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerRelief = (Spinner)convertView.findViewById(R.id.environ_surficial_spinner_relief);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutSUREnvironsRelief"));
			sp1.setNewElement(pldb, "lutSUREnvironsRelief", 1, null, null);
			sp1.addSpace();
			spinnerRelief.setAdapter(sp1);
			spinnerRelief.setSelection(sp1.getPosition(environSurficialEntity.getDrainage()));
			spinnerRelief.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {}
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					environSurficialEntity.setDrainage(parent.getItemAtPosition(position).toString());
				}
			});

			/////////////////////////////////////
			// EDITTEXT SLOPE
			//
			// Text field for "Slope(Degrees)"
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (2/8)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextSlope = (EditText)convertView.findViewById(R.id.environ_surficial_editText_slope);
			editTextSlope.setText(environSurficialEntity.getSlope());
			editTextSlope.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					environSurficialEntity.setSlope((s.length() == 0) ? "" : s.toString());
				}
			});

			/////////////////////////////////////
			// EDITTEXT AZIMUTH
			//
			// Text field "Azimuth"
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (3/8)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextAzimuth = (EditText)convertView.findViewById(R.id.environ_surficial_editText_azimuth);
			editTextAzimuth.setText(environSurficialEntity.getAspect());
			editTextAzimuth.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					environSurficialEntity.setAspect((s.length() == 0) ? "" : s.toString());
				}
			});

			/////////////////////////////////////
			// CHECKBOX PERMAFROST
			//
			// Checkbox to indicate if "Permafrost"
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (4/8)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			boolean pfFlag = environSurficialEntity.getPfPresent().equalsIgnoreCase("T");
			LinearLayout layoutPF = (LinearLayout) convertView.findViewById(R.id.environ_layout_permafrost);
			layoutPF.setVisibility(((pfFlag) ? LinearLayout.VISIBLE : LinearLayout.INVISIBLE));
			CheckBox checkBoxPermafrost = (CheckBox)convertView.findViewById(R.id.environ_checkBox_permafrost);
			checkBoxPermafrost.setChecked(pfFlag);
			checkBoxPermafrost.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					environSurficialEntity.setPfPresent((isChecked) ? "T" : "F");
					notifyDataSetChanged();
				}
			});

			/////////////////////////////////////
			// CONCAT SPINNER INDICATORS
			//
			// Drop-down for "Indicators" - Column 1 of lutSUREnvironsPFindic Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (5/8)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerIndicators = (Spinner)convertView.findViewById(R.id.environ_surficial_spinner_indicators);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerIndicators.setAdapter(sp2);
			sp2.setElements(pldb.getCol1("lutSUREnvironsPFindic"));
			sp2.setNewElement(pldb, "lutSUREnvironsPFindic", 1, null, null);
			sp2.addSpace();
			spinnerIndicators.setAdapter(sp2);
			spinnerIndicators.setSelection(sp2.getPosition(environSurficialEntity.getPfIndic()));
			spinnerIndicators.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					String tmp = environSurficialEntity.getPfIndic();
					String sel = parent.getItemAtPosition(position).toString();
					if(!tmp.contains(sel))
					{
						environSurficialEntity.setPfIndic((tmp.length() > 1) ? (tmp + " | " + sel) : sel);
						notifyDataSetChanged();
					}
				}
			});

			/////////////////////////////////////
			// CONCAT EDITTEXT INDICATORS
			//
			// Text field concatenates selections from SPINNER INDICATORS
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (6/8)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextIndicators = (EditText)convertView.findViewById(R.id.environ_surficial_editText_indicators);
			editTextIndicators.setText(environSurficialEntity.getPfIndic());
			editTextIndicators.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					environSurficialEntity.setPfIndic((s.length() == 0) ? "" : s.toString());
				}
			});

			/////////////////////////////////////
			// CONCAT BUTTON INDICATORS
			//
			// Button clears EDITTEXT INDICATORS text field
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (7/8)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Button buttonIndic = (Button) convertView.findViewById(R.id.environ_surficial_button_clear);
			buttonIndic.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					environSurficialEntity.setPfIndic("");
					notifyDataSetChanged();
				}
			});

			/////////////////////////////////////
			// EDITTEXT PERMAFROST DEPTH
			//
			// Text field for "Depth"
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (8/8)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextDepthOfAL = (EditText)convertView.findViewById(R.id.environ_surficial_editText_depthOfAL);
			editTextDepthOfAL.setText(environSurficialEntity.getPfDepth());
			editTextDepthOfAL.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					environSurficialEntity.setPfDepth((s.length() == 0) ? "" : s.toString());
				}
			});

		} else if (tab == 2) {
			convertView = mInflater.inflate(R.layout.environ_surficial2, null);

			/////////////////////////////////////
			// CHECKBOX GOSSAN PRES
			//
			// Checkbox to indicate if "Gossan"
			/////////////////////////////////////
			// VERIFIED - TAB 2 - ELEMENT (1/4)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			boolean gossanFlag = environSurficialEntity.getGossanPres().equalsIgnoreCase("T");
			LinearLayout layoutGossan = (LinearLayout)convertView.findViewById(R.id.environ_layout_gossan);
			layoutGossan.setVisibility(((gossanFlag) ? LinearLayout.VISIBLE : LinearLayout.INVISIBLE));
			CheckBox checkBoxGossan = (CheckBox)convertView.findViewById(R.id.environ_checkBox_gossan);
			checkBoxGossan.setChecked(gossanFlag);
			checkBoxGossan.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					environSurficialEntity.setGossanPres((isChecked) ? "T" : "F");
					notifyDataSetChanged();
				}
			});

			/////////////////////////////////////
			// EDITTEXT MINERALIZATION OF IMPORTANCE
			//
			// Text field for "Mineralization of Importance"
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (2/4)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextMinOfImp = (EditText)convertView.findViewById(R.id.environ_surficial_editText_minOfImp);
			editTextMinOfImp.setText(environSurficialEntity.getGossanMat());
			editTextMinOfImp.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					environSurficialEntity.setGossanMat((s.length() == 0) ? "" : s.toString());
				}
			});

			/////////////////////////////////////
			// SPINNER PERCENT BEDROCK
			//
			// Drop-down for "Percent Bedrock" - Column 1 of lutSURGeneralPercent5incr Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 2 - ELEMENT (3/4)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerPercentBedrock = (Spinner)convertView.findViewById(R.id.environ_surficial_spinner_percentBedrock);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerPercentBedrock.setAdapter(sp1);
			sp1.setElements(pldb.getCol1("lutSURGeneralPercent5incr"));
			sp1.setNewElement(pldb, "lutSURGeneralPercent5incr", 1, null, null);
			sp1.addSpace();
			spinnerPercentBedrock.setAdapter(sp1);
			spinnerPercentBedrock.setSelection(sp1.getPosition(environSurficialEntity.getbRock()));
			spinnerPercentBedrock.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					environSurficialEntity.setbRock(parent.getItemAtPosition(position).toString());
				}
			});

			/////////////////////////////////////
			// SPINNER EXPOSURE TYPE
			//
			// Drop-down for "Exposure Type" - Column 1 of lutSUREnvironsExposure Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 2 - ELEMENT (4/4)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerExposureType = (Spinner)convertView.findViewById(R.id.environ_surficial_spinner_exposureType);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerExposureType.setAdapter(sp2);
			sp2.setElements(pldb.getCol1("lutSUREnvironsExposure"));
			sp2.setNewElement(pldb, "lutSUREnvironsExposure", 1, null, null);
			sp2.addSpace();
			spinnerExposureType.setAdapter(sp2);
			spinnerExposureType.setSelection(sp2.getPosition(environSurficialEntity.getExposure()));
			spinnerExposureType.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					environSurficialEntity.setExposure(parent.getItemAtPosition(position).toString());
				}
			});

		} else if (tab == 3) {
			convertView = mInflater.inflate(R.layout.environ_surficial3, null);

			/////////////////////////////////////
			// CONCAT SPINNER VEGETATION
			//
			// Drop-down for "Vegetation" - Column 1 of lutSUREnvironsVegetation Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 3 - ELEMENT (1/7)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerVegetation = (Spinner)convertView.findViewById(R.id.environ_surficial_spinner_vegetation);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutSUREnvironsVegetation"));
			sp1.setNewElement(pldb, "lutSUREnvironsVegetation", 1, null, null);
			sp1.addSpace();
			spinnerVegetation.setAdapter(sp1);
			spinnerVegetation.setEnabled(vegitation1Boolean);
			spinnerVegetation.setSelection(sp1.getPosition(vegetationTemp));
			spinnerVegetation.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					String tmp = parent.getItemAtPosition(position).toString();
					if(!tmp.equalsIgnoreCase("") && !tmp.equalsIgnoreCase(vegetationTemp))
					{
						vegetationTemp = tmp;
						vegitation1Boolean = false;
						vegitation2Boolean = true;
						notifyDataSetChanged();
					}
				}
			});

			/////////////////////////////////////
			// PERCENT SPINNER VEGETATION %
			//
			// Drop-down for "%" - Column 1 of lutSURGeneralPercent5incr Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 3 - ELEMENT (2/7)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerVegetationPer = (Spinner)convertView.findViewById(R.id.environ_surficial_spinner_vegetationPer);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp2.setElements(pldb.getCol1("lutSURGeneralPercent5incr"));
			sp2.setNewElement(pldb, "lutSURGeneralPercent5incr", 1, null, null);
			sp2.addSpace();
			spinnerVegetationPer.setAdapter(sp2);
			spinnerVegetationPer.setEnabled(vegitation2Boolean);
			spinnerVegetationPer.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					String tmp = environSurficialEntity.getVegetation();
					String sel = parent.getItemAtPosition(position).toString();

					if(!sel.equalsIgnoreCase(""))
					{
						if(tmp.length() > 1)
							environSurficialEntity.setVegetation(tmp + " | " + vegetationTemp + " - " + sel);
						else
							environSurficialEntity.setVegetation(vegetationTemp + " - " + sel);

						vegetationTemp = "";
						vegitation1Boolean = true;
						vegitation2Boolean = false;
						notifyDataSetChanged();
					}
				}
			});

			/////////////////////////////////////
			// PERCENT EDITTEXT VEGETATION
			//
			// Text field concatenates selections from SPINNER VEGETATION and SPINNER VEGETATION%
			/////////////////////////////////////
			// VERIFIED - TAB 3 - ELEMENT (3/7)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextVegetation = (EditText)convertView.findViewById(R.id.environ_surficial_editText_vegetation);
			editTextVegetation.setText(environSurficialEntity.getVegetation());
			editTextVegetation.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					environSurficialEntity.setVegetation((s.length() == 0) ? "" : s.toString());
				}
			});

			/////////////////////////////////////
			// PERCENT BUTTON VEGETATION
			//
			// Button clears EDITTEXT VEGETATION text field
			/////////////////////////////////////
			// VERIFIED - TAB 3 - ELEMENT (4/7)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			Button buttonVegetation = (Button) convertView.findViewById(R.id.environ_surficial_button_vegetation);
			buttonVegetation.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					environSurficialEntity.setVegetation("");
					notifyDataSetChanged();
				}
			});

			/////////////////////////////////////
			// SPINNER BOULDERS
			//
			// Drop-down for "Boulders" - Column 1 of lutSUREnvironsBoulders Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 3 - ELEMENT (5/7)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerBoulders = (Spinner)convertView.findViewById(R.id.environ_surficial_spinner_boulders);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerBoulders.setAdapter(sp3);
			sp3.setElements(pldb.getCol1("lutSUREnvironsBoulders"));
			sp3.setNewElement(pldb, "lutSUREnvironsBoulders", 1, null, null);
			sp3.addSpace();
			spinnerBoulders.setAdapter(sp3);
			spinnerBoulders.setSelection(sp3.getPosition(environSurficialEntity.getBoulders()));
			spinnerBoulders.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {}
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					environSurficialEntity.setBoulders(parent.getItemAtPosition(position).toString());
				}
			});

			/////////////////////////////////////
			// CHECKBOX BOULDERFIELD
			//
			// Checkbox to indicate if "Boulderfield"
			/////////////////////////////////////
			// VERIFIED - TAB 3 - ELEMENT (6/7)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			boolean boulderFlag = environSurficialEntity.getBouldFld().equalsIgnoreCase("T");
			CheckBox checkBoxBoulderField = (CheckBox)convertView.findViewById(R.id.environ_checkBox_boulderField);
			checkBoxBoulderField.setChecked(boulderFlag);


			/////////////////////////////////////
			//  SPINNER BOULDERFIELD VISIBILITY CHECK
			//
			// Sets visibility of SPINNER BOULDERFIELD based on CHECKBOX BOULDERFIELD
			/////////////////////////////////////
			// VERIFIED - TAB 3 - ELEMENT ()
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [???] DERRICK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Spinner boulderSpinner = (Spinner)convertView.findViewById(R.id.environ_surficial_spinner_boulderField);
			if(boulderBoolean)
				boulderSpinner.setVisibility(LinearLayout.VISIBLE);
			else
				boulderSpinner.setVisibility(LinearLayout.INVISIBLE);

			checkBoxBoulderField.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

					Spinner boulderSpinner = (Spinner)((MainActivity)context).findViewById(R.id.environ_surficial_spinner_boulderField);
					if(isChecked){
						boulderSpinner.setVisibility(LinearLayout.VISIBLE);
						environSurficialEntity.setBouldFld("T");
					}
					else{
						boulderSpinner.setVisibility(LinearLayout.INVISIBLE);
						environSurficialEntity.setBouldFld("F");
					}
				}
			});

			/////////////////////////////////////
			// SPINNER BOULDERFIELD
			//
			// Drop-down for "Boulderfield" - Column 1 of lutSUREnvironsBoFldTyp Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 3 - ELEMENT (7/7)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerBoulderField = (Spinner)convertView.findViewById(R.id.environ_surficial_spinner_boulderField);
			SpinnerController sp4 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerBoulderField.setAdapter(sp4);
			sp4.setElements(pldb.getCol1("lutSUREnvironsBoFldTyp"));
			sp4.setNewElement(pldb, "lutSUREnvironsBoFldTyp", 1, null, null);
			sp4.addSpace();
			spinnerBoulderField.setAdapter(sp4);
			spinnerBoulderField.setSelection(sp4.getPosition(environSurficialEntity.getBoFldTyp()));
			spinnerBoulderField.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {}
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					environSurficialEntity.setBoFldTyp(parent.getItemAtPosition(position).toString());
				}
			});

		} else if (tab == 4) {
			convertView = mInflater.inflate(R.layout.environ_surficial4, null);

			/////////////////////////////////////
			// SPINNER GROUND COVER
			//
			// Drop-down for "Ground Cover" - Column 1 of lutSUREnvironsGroundcover Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 4 - ELEMENT (1/8)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerGroundCover = (Spinner)convertView.findViewById(R.id.environ_surficial_spinner_groundCover);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutSUREnvironsGroundcover"));
			sp1.setNewElement(pldb, "lutSUREnvironsGroundcover", 1, null, null);
			sp1.addSpace();
			spinnerGroundCover.setAdapter(sp1);
			spinnerGroundCover.setEnabled(groundCover1Boolean);
			spinnerGroundCover.setSelection(sp1.getPosition(groundCoverTemp));
			spinnerGroundCover.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					String tmp = parent.getItemAtPosition(position).toString();
					if(!tmp.equalsIgnoreCase("") && !tmp.equalsIgnoreCase(groundCoverTemp))
					{
						groundCoverTemp = parent.getItemAtPosition(position).toString();
						groundCover1Boolean = false;
						groundCover2Boolean = true;
						notifyDataSetChanged();
					}
				}
			});

			/////////////////////////////////////
			// PERCENT SPINNER GROUND COVER PERCENT
			//
			// Drop-down for "%" - Column 1 of lutSURGeneralPercent5incr Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 4 - ELEMENT (2/8)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerGroundCoverPer = (Spinner)convertView.findViewById(R.id.environ_surficial_spinner_groundCoverPer);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp2.setElements(pldb.getCol1("lutSURGeneralPercent5incr"));
			sp2.setNewElement(pldb, "lutSURGeneralPercent5incr", 1, null, null);
			sp2.addSpace();
			spinnerGroundCoverPer.setAdapter(sp2);
			spinnerGroundCoverPer.setEnabled(groundCover2Boolean);
			spinnerGroundCoverPer.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					String tmp = environSurficialEntity.getGrndCover();
					String sel = parent.getItemAtPosition(position).toString();
					if(!sel.equalsIgnoreCase(""))
					{
						environSurficialEntity.setGrndCover((tmp.length() > 1) ? (tmp + " | " + groundCoverTemp + " - " + sel) : (groundCoverTemp + " - " + sel));
						groundCoverTemp = "";
						groundCover1Boolean = true;
						groundCover2Boolean = false;
						notifyDataSetChanged();
					}
				}
			});

			/////////////////////////////////////
			// PERCENT EDITTEXT GROUND COVER 
			//
			// Text field concatenates selections from SPINNER GROUND COVER and SPINNER GROUND COVER PERCENT
			/////////////////////////////////////
			// VERIFIED - TAB 4 - ELEMENT (3/8)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextGroundCover = (EditText)convertView.findViewById(R.id.environ_surficial_editText_groundCover);
			editTextGroundCover.setText(environSurficialEntity.getPcentCover());
			editTextGroundCover.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					environSurficialEntity.setPcentCover((s.length() == 0) ? "" : s.toString());
				}
			});

			/////////////////////////////////////
			// PERCENT BUTTON GROUND COVER  CLEAR
			//
			// Button clears EDITTEXT GROUND COVER text field
			/////////////////////////////////////
			// VERIFIED - TAB 4 - ELEMENT (4/8)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			Button buttonGroundCover = (Button) convertView.findViewById(R.id.environ_surficial_button_groundCover);
			buttonGroundCover.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					environSurficialEntity.setPcentCover("");
					notifyDataSetChanged();
				}
			});

			/////////////////////////////////////
			// CONCAT SPINNER PATT GROUND
			//
			// Drop-down for "Patterned Ground" - Column 1 of lutSUREnvironsPatterngrn Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 4 - ELEMENT (5/8)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerPattGrnd = (Spinner)convertView.findViewById(R.id.environ_surficial_spinner_pattGrnd);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerPattGrnd.setAdapter(sp3);
			sp3.setElements(pldb.getCol1("lutSUREnvironsPatterngrn"));
			sp3.setNewElement(pldb, "lutSUREnvironsPatterngrn", 1, null, null);
			sp3.addSpace();
			spinnerPattGrnd.setAdapter(sp3);
			spinnerPattGrnd.setSelection(sp3.getPosition(environSurficialEntity.getPatternGrn()));
			spinnerPattGrnd.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					String tmp = environSurficialEntity.getPatternGrn();
					String sel = parent.getItemAtPosition(position).toString();
					if(!tmp.contains(sel))
					{
						environSurficialEntity.setPatternGrn((tmp.length() > 1) ? (tmp + " | " + sel) : sel);
						notifyDataSetChanged();
					}
				}
			});

			/////////////////////////////////////
			// CONCAT EDITTEXT PATT GROUND
			//
			// Text field concatenates selections from SPINNER PATT GROUND
			/////////////////////////////////////
			// VERIFIED - TAB 4 - ELEMENT (6/8)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextPattGrnd = (EditText)convertView.findViewById(R.id.environ_surficial_editText_pattGrnd);
			editTextPattGrnd.setText(environSurficialEntity.getPatternGrn());
			editTextPattGrnd.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					environSurficialEntity.setPatternGrn((s.length() == 0) ? "" : s.toString());
				}
			});

			/////////////////////////////////////
			// CONCAT BUTTON PATT GROUND CLEAR
			//
			// Button clears EDITTEXT PATT GROUND text field
			/////////////////////////////////////
			// VERIFIED - TAB 4 - ELEMENT (7/8)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			Button buttonPattGrndClear = (Button) convertView.findViewById(R.id.environ_surficial_button_pattGrnd_clear);
			buttonPattGrndClear.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					environSurficialEntity.setPatternGrn("");
					notifyDataSetChanged();
				}
			});

			/////////////////////////////////////
			// EDITTEXT PATT AREA
			//
			// Text field for "Patterned Area"
			/////////////////////////////////////
			// VERIFIED - TAB 4 - ELEMENT (8/8)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextPatternArea = (EditText)convertView.findViewById(R.id.environ_surficial_editText_patternArea);
			editTextPatternArea.setText(environSurficialEntity.getPatArea());
			editTextPatternArea.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					environSurficialEntity.setPatArea((s.length() == 0) ? "" : s.toString());
				}
			});

		} else if (tab == 5) {
			convertView = mInflater.inflate(R.layout.environ_surficial5, null);

			/////////////////////////////////////
			// NOTES
			//
			// Text field for "Environs Note"
			/////////////////////////////////////
			// VERIFIED - TAB 5 - ELEMENT (1/1)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextEnvironNote = (EditText)convertView.findViewById(R.id.environ_surficial_editText_environNote);
			editTextEnvironNote.setText(environSurficialEntity.getNotes());
			editTextEnvironNote.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					environSurficialEntity.setNotes((s.length() == 0) ? "" : s.toString());
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
		environSurficialEntity.clearEntity();
		tab = 1;
		notifyDataSetChanged();
	}
}
