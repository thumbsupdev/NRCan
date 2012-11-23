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
	private boolean permafrostBoolean = false;
	private boolean gossanBoolean = false;
	private boolean boulderBoolean = false;
	private boolean vegitation1Boolean = true;
	private boolean vegitation2Boolean = false;
	private boolean groundCover1Boolean = true;
	private boolean groundCover2Boolean = false;
	private String vegetationTemp;
	private String groundCoverTemp;

	private EnvironSurficialEntity environSurficialEntity;

	public EnvironSurficialController(Context context, Activity activity,EnvironSurficialEntity environSurficialEntity,PicklistDatabaseHandler pldb) {
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
			if(environSurficialEntity.getPfPresent().equalsIgnoreCase("T"))
				permafrostBoolean = true;
			else
				permafrostBoolean = false;

			convertView = mInflater.inflate(R.layout.environ_surficial1, null);

			Spinner spinnerRelief = (Spinner)convertView.findViewById(R.id.environ_surficial_spinner_relief);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerRelief.setAdapter(sp1);
			sp1.setElements(pldb.getCol1("lutSUREnvironsRelief"));
			spinnerRelief.setAdapter(sp1);
			spinnerRelief.setSelection(sp1.getPosition(environSurficialEntity.getDrainage()));
			spinnerRelief.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {

				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					environSurficialEntity.setDrainage(parent.getItemAtPosition(position).toString());
					System.out.println(parent.getItemAtPosition(position));
				}
			});

			EditText editTextSlope = (EditText)convertView.findViewById(R.id.environ_surficial_editText_slope);
			editTextSlope.setText(environSurficialEntity.getSlope());
			editTextSlope.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						environSurficialEntity.setSlope("");
					else
						environSurficialEntity.setSlope(s.toString());
				}
			});
			EditText editTextAzimuth = (EditText)convertView.findViewById(R.id.environ_surficial_editText_azimuth);
			editTextAzimuth.setText(environSurficialEntity.getAspect());
			editTextAzimuth.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						environSurficialEntity.setAspect("");
					else
						environSurficialEntity.setAspect(s.toString());
				}
			});




			CheckBox checkBoxPermafrost = (CheckBox)convertView.findViewById(R.id.environ_checkBox_permafrost);
			checkBoxPermafrost.setChecked(permafrostBoolean);
			//setCheckPermafrost(tmp);

			LinearLayout layoutPermafrost = (LinearLayout)convertView.findViewById(R.id.environ_layout_permafrost);
			if(permafrostBoolean)
				layoutPermafrost.setVisibility(LinearLayout.VISIBLE);
			else
				layoutPermafrost.setVisibility(LinearLayout.INVISIBLE);

			checkBoxPermafrost.setOnCheckedChangeListener(new OnCheckedChangeListener() {

				public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {

					LinearLayout layoutPermafrost = (LinearLayout)((MainActivity)context).findViewById(R.id.environ_layout_permafrost);
					if(isChecked){
						layoutPermafrost.setVisibility(LinearLayout.VISIBLE);
						environSurficialEntity.setPfPresent("T");
					}
					else{
						layoutPermafrost.setVisibility(LinearLayout.INVISIBLE);
						environSurficialEntity.setPfPresent("F");
						//setCheckPermafrost(isChecked);
					}
				}
			});

			Spinner spinnerIndicators = (Spinner)convertView.findViewById(R.id.environ_surficial_spinner_indicators);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerIndicators.setAdapter(sp2);
			sp2.setElements(pldb.getCol1("lutSUREnvironsPFindic"));
			spinnerIndicators.setAdapter(sp2);
			spinnerIndicators.setSelection(sp2.getPosition(environSurficialEntity.getPfIndic()));
			spinnerIndicators.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {

				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					String tmp = environSurficialEntity.getPfIndic();
					String sel = parent.getItemAtPosition(position).toString();
					if(!tmp.contains(sel))
					{
						if(tmp.length() > 1)
							environSurficialEntity.setPfIndic(tmp + " | " + sel);
						else
							environSurficialEntity.setPfIndic(sel);

						notifyDataSetChanged();
					}
				}
			});


			EditText editTextIndicators = (EditText)convertView.findViewById(R.id.environ_surficial_editText_indicators);
			editTextIndicators.setText(environSurficialEntity.getPfIndic());
			editTextIndicators.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						environSurficialEntity.setPfIndic("");
					else
						environSurficialEntity.setPfIndic(s.toString());
				}
			});
			EditText editTextDepthOfAL = (EditText)convertView.findViewById(R.id.environ_surficial_editText_depthOfAL);
			editTextDepthOfAL.setText(environSurficialEntity.getPfDepth());
			editTextDepthOfAL.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						environSurficialEntity.setPfDepth("");
					else
						environSurficialEntity.setPfDepth(s.toString());
				}
			});


		}
		else if (tab == 2)
		{
			if(environSurficialEntity.getGossanPres().equalsIgnoreCase("T"))
				gossanBoolean = true;
			else
				gossanBoolean = false;


			convertView = mInflater.inflate(R.layout.environ_surficial2, null);

			CheckBox checkBoxGossan = (CheckBox)convertView.findViewById(R.id.environ_checkBox_gossan);
			checkBoxGossan.setChecked(gossanBoolean);

			LinearLayout layoutGossan = (LinearLayout)convertView.findViewById(R.id.environ_layout_permafrost);
			if(gossanBoolean)
				layoutGossan.setVisibility(LinearLayout.VISIBLE);
			else
				layoutGossan.setVisibility(LinearLayout.INVISIBLE);

			checkBoxGossan.setOnCheckedChangeListener(new OnCheckedChangeListener() {

				public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {

					LinearLayout layoutGossan = (LinearLayout)((MainActivity)context).findViewById(R.id.environ_layout_permafrost);
					if(isChecked){
						layoutGossan.setVisibility(LinearLayout.VISIBLE);
						environSurficialEntity.setGossanPres("T");
					}
					else{
						layoutGossan.setVisibility(LinearLayout.INVISIBLE);
						environSurficialEntity.setGossanPres("F");
						//setCheckPermafrost(isChecked);
					}
				}

			});
			EditText editTextMinOfImp = (EditText)convertView.findViewById(R.id.environ_surficial_editText_minOfImp);
			editTextMinOfImp.setText(environSurficialEntity.getGossanMat());
			editTextMinOfImp.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						environSurficialEntity.setGossanMat("");
					else
						environSurficialEntity.setGossanMat(s.toString());
				}
			});
			Spinner spinnerPercentBedrock = (Spinner)convertView.findViewById(R.id.environ_surficial_spinner_percentBedrock);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerPercentBedrock.setAdapter(sp1);
			sp1.setElements(pldb.getCol1("lutSURGeneralPercent5incr"));
			spinnerPercentBedrock.setAdapter(sp1);
			spinnerPercentBedrock.setSelection(sp1.getPosition(environSurficialEntity.getPfPresent()));
			spinnerPercentBedrock.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {

				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					environSurficialEntity.setPfPresent(parent.getItemAtPosition(position).toString());
					//System.out.println(parent.getItemAtPosition(position));
				}
			});

			Spinner spinnerExposureType = (Spinner)convertView.findViewById(R.id.environ_surficial_spinner_exposureType);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerExposureType.setAdapter(sp2);
			sp2.setElements(pldb.getCol1("lutSUREnvironsExposure"));
			spinnerExposureType.setAdapter(sp2);
			spinnerExposureType.setSelection(sp2.getPosition(environSurficialEntity.getExposure()));
			spinnerExposureType.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {

				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					environSurficialEntity.setExposure(parent.getItemAtPosition(position).toString());
					System.out.println(parent.getItemAtPosition(position));
				}
			});
		}
		else if (tab == 3)
		{
			convertView = mInflater.inflate(R.layout.environ_surficial3, null);

			if(environSurficialEntity.getBouldFld().equalsIgnoreCase("T"))
				boulderBoolean = true;
			else
				boulderBoolean = false;

			Spinner spinnerVegetation = (Spinner)convertView.findViewById(R.id.environ_surficial_spinner_vegetation);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutSUREnvironsVegetation"));
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

			Spinner spinnerVegetationPer = (Spinner)convertView.findViewById(R.id.environ_surficial_spinner_vegetationPer);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp2.setElements(pldb.getCol1("lutSURGeneralPercent5incr"));
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


			Button buttonVegetation = (Button) convertView.findViewById(R.id.environ_surficial_button_vegetation);
			buttonVegetation.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					environSurficialEntity.setVegetation("");
					notifyDataSetChanged();
				}
			});
			EditText editTextVegetation = (EditText)convertView.findViewById(R.id.environ_surficial_editText_vegetation);
			editTextVegetation.setText(environSurficialEntity.getVegetation());
			editTextVegetation.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						environSurficialEntity.setVegetation("");
					else
						environSurficialEntity.setVegetation(s.toString());
				}
			});
			Spinner spinnerBoulders = (Spinner)convertView.findViewById(R.id.environ_surficial_spinner_boulders);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerBoulders.setAdapter(sp3);
			sp3.setElements(pldb.getCol1("lutSUREnvironsBoulders"));
			spinnerBoulders.setAdapter(sp3);
			spinnerBoulders.setSelection(sp3.getPosition(environSurficialEntity.getBoulders()));
			spinnerBoulders.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {

				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					environSurficialEntity.setBoulders(parent.getItemAtPosition(position).toString());
					System.out.println(parent.getItemAtPosition(position));
				}
			});


			CheckBox checkBoxBoulderField = (CheckBox)convertView.findViewById(R.id.environ_checkBox_boulderField);
			checkBoxBoulderField.setChecked(boulderBoolean);
			//setCheckPermafrost(tmp);

			Spinner boulderSpinner = (Spinner)convertView.findViewById(R.id.environ_surficial_spinner_boulderField);
			if(boulderBoolean)
				boulderSpinner.setVisibility(LinearLayout.VISIBLE);
			else
				boulderSpinner.setVisibility(LinearLayout.INVISIBLE);

			checkBoxBoulderField.setOnCheckedChangeListener(new OnCheckedChangeListener() {

				public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {

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

			Spinner spinnerBoulderField = (Spinner)convertView.findViewById(R.id.environ_surficial_spinner_boulderField);
			SpinnerController sp4 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerBoulderField.setAdapter(sp4);
			sp4.setElements(pldb.getCol1("lutSUREnvironsBoFldTyp"));
			spinnerBoulderField.setAdapter(sp4);
			spinnerBoulderField.setSelection(sp4.getPosition(environSurficialEntity.getBoFldTyp()));
			spinnerBoulderField.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {

				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					environSurficialEntity.setBoFldTyp(parent.getItemAtPosition(position).toString());
					System.out.println(parent.getItemAtPosition(position));
				}
			});

		}
		else if (tab == 4)
		{

			convertView = mInflater.inflate(R.layout.environ_surficial4, null);

			Spinner spinnerGroundCover = (Spinner)convertView.findViewById(R.id.environ_surficial_spinner_groundCover);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutSUREnvironsGroundcover"));
			sp1.addSpace();
			spinnerGroundCover.setAdapter(sp1);
			spinnerGroundCover.setEnabled(groundCover1Boolean);
			spinnerGroundCover.setSelection(sp1.getPosition(groundCoverTemp));
			spinnerGroundCover.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {}
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

			Spinner spinnerGroundCoverPer = (Spinner)convertView.findViewById(R.id.environ_surficial_spinner_groundCoverPer);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp2.setElements(pldb.getCol1("lutSURGeneralPercent5incr"));
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
						if(tmp.length() > 1)
							environSurficialEntity.setGrndCover(tmp + " | " + groundCoverTemp + " - " + sel);
						else
							environSurficialEntity.setGrndCover(groundCoverTemp + " - " + sel);

						groundCoverTemp = "";
						groundCover1Boolean = true;
						groundCover2Boolean = false;
						notifyDataSetChanged();
					}
				}
			});
			
			Button buttonGroundCover = (Button) convertView.findViewById(R.id.environ_surficial_button_groundCover);
			buttonGroundCover.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					environSurficialEntity.setGrndCover("");
					notifyDataSetChanged();
				}
			});

			EditText editTextGroundCover = (EditText)convertView.findViewById(R.id.environ_surficial_editText_groundCover);
			editTextGroundCover.setText(environSurficialEntity.getGrndCover());
			editTextGroundCover.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						environSurficialEntity.setGrndCover("");
					else
						environSurficialEntity.setGrndCover(s.toString());
				}
			});

			Spinner spinnerPattGrnd = (Spinner)convertView.findViewById(R.id.environ_surficial_spinner_pattGrnd);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerPattGrnd.setAdapter(sp3);
			sp3.setElements(pldb.getCol1("lutSUREnvironsPatterngrn"));
			spinnerPattGrnd.setAdapter(sp3);
			spinnerPattGrnd.setSelection(sp3.getPosition(environSurficialEntity.getPatternGrn()));
			spinnerPattGrnd.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {

				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					String tmp = environSurficialEntity.getPatternGrn();
					String sel = parent.getItemAtPosition(position).toString();
					if(!tmp.contains(sel))
					{
						if(tmp.length() > 1)
							environSurficialEntity.setPatternGrn(tmp + " | " + sel);
						else
							environSurficialEntity.setPatternGrn(sel);

						notifyDataSetChanged();
					}
				}
			});

			Button buttonPattGrndClear = (Button) convertView.findViewById(R.id.environ_surficial_button_pattGrnd_clear);
			buttonPattGrndClear.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					environSurficialEntity.setPatternGrn("");
					notifyDataSetChanged();
				}
			});

			EditText editTextPattGrnd = (EditText)convertView.findViewById(R.id.environ_surficial_editText_pattGrnd);
			editTextPattGrnd.setText(environSurficialEntity.getPatternGrn());
			editTextPattGrnd.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						environSurficialEntity.setPatternGrn("");
					else
						environSurficialEntity.setPatternGrn(s.toString());
				}
			});
			EditText editTextPatternArea = (EditText)convertView.findViewById(R.id.environ_surficial_editText_patternArea);
			editTextPatternArea.setText(environSurficialEntity.getPatArea());
			editTextPatternArea.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						environSurficialEntity.setPatArea("");
					else
						environSurficialEntity.setPatArea(s.toString());
				}
			});

		}
		else if (tab == 5)
		{

			convertView = mInflater.inflate(R.layout.environ_surficial5, null);

			EditText editTextEnvironNote = (EditText)convertView.findViewById(R.id.environ_surficial_editText_environNote);
			editTextEnvironNote.setText(environSurficialEntity.getNotes());
			editTextEnvironNote.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						environSurficialEntity.setNotes("");
					else
						environSurficialEntity.setNotes(s.toString());
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

	/*
	public boolean setCheckPermafrost(boolean isChecked){
		LinearLayout lin1 = (LinearLayout)activity.findViewById(R.id.environ_layout_permafrost);
		if(isChecked)
			lin1.setVisibility(LinearLayout.VISIBLE);
		else
			lin1.setVisibility(LinearLayout.INVISIBLE);
		//setCheckPermafrost(isChecked);
		return isChecked;
	}
	 */


}
