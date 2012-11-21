package com.nrcan.controllers;

import java.util.ArrayList;

import com.nrcan.main.PicklistDatabaseHandler;
import com.nrcan.main.R;
import com.nrcan.models.EnvironSurficialModel;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class EnvironSurficialController  extends BaseAdapter implements Filterable {
	private LayoutInflater mInflater;
	private Activity activity;
	private Context context;
	private int tab;
	private EnvironSurficialModel environSurficialModel;
	private PicklistDatabaseHandler pldb;
	private ArrayList<String> e = new ArrayList<String>();
	
	public EnvironSurficialController(Context context, Activity activity,EnvironSurficialModel environSurficialModel,PicklistDatabaseHandler pldb) {
		this.mInflater = LayoutInflater.from(context);
		this.activity = activity;
		this.context = context;
		this.tab = 1;
		this.environSurficialModel = environSurficialModel;
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
				
				Spinner spinnerRelief = (Spinner)convertView.findViewById(R.id.environ_surficial_spinner_relief);
				SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
				spinnerRelief.setAdapter(sp1);
				sp1.setElements(e);//(pldb.getCol1("lutSUREnvironsRelief"));
				spinnerRelief.setAdapter(sp1);
				spinnerRelief.setOnItemSelectedListener(new OnItemSelectedListener() {
					public void onNothingSelected(AdapterView<?> arg0) {
						
					}

					public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
						//earthmatbedrockModel.getEntity().setLithGroup("");
						System.out.println(parent.getItemAtPosition(position));
					}
				});
				
				EditText editTextSlope = (EditText)convertView.findViewById(R.id.environ_surficial_editText_slope);
				EditText editTextAzimuth = (EditText)convertView.findViewById(R.id.environ_surficial_editText_azimuth);
				
				
				
				
				CheckBox checkBoxPermafrost = (CheckBox)convertView.findViewById(R.id.environ_checkBox_permafrost);
				Spinner spinnerIndicators = (Spinner)convertView.findViewById(R.id.environ_surficial_spinner_indicators);
				SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
				spinnerIndicators.setAdapter(sp2);
				sp2.setElements(e);//(pldb.getCol1("lutSUREnvironsPFindic"));
				spinnerIndicators.setAdapter(sp2);
				spinnerIndicators.setOnItemSelectedListener(new OnItemSelectedListener() {
					public void onNothingSelected(AdapterView<?> arg0) {
						
					}

					public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
						//earthmatbedrockModel.getEntity().setLithGroup("");
						System.out.println(parent.getItemAtPosition(position));
					}
				});
				
				
				EditText editTextIndicators = (EditText)convertView.findViewById(R.id.environ_surficial_editText_indicators);
				EditText editTextDepthOfAL = (EditText)convertView.findViewById(R.id.environ_surficial_editText_depthOfAL);
				
				
			}
			else if (tab == 2)
			{
				
				convertView = mInflater.inflate(R.layout.environ_surficial2, null);
				
				CheckBox checkBoxGossan = (CheckBox)convertView.findViewById(R.id.environ_checkBox_gossan);
				EditText editTextMinOfImp = (EditText)convertView.findViewById(R.id.environ_surficial_editText_minOfImp);
				Spinner spinnerPercentBedrock = (Spinner)convertView.findViewById(R.id.environ_surficial_spinner_percentBedrock);
				SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
				spinnerPercentBedrock.setAdapter(sp1);
				sp1.setElements(e);//(pldb.getCol1("lutSURGeneralPercent5incr"));
				spinnerPercentBedrock.setAdapter(sp1);
				spinnerPercentBedrock.setOnItemSelectedListener(new OnItemSelectedListener() {
					public void onNothingSelected(AdapterView<?> arg0) {
						
					}

					public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
						//earthmatbedrockModel.getEntity().setLithGroup("");
						System.out.println(parent.getItemAtPosition(position));
					}
				});
				
				Spinner spinnerExposureType = (Spinner)convertView.findViewById(R.id.environ_surficial_spinner_exposureType);
				SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
				spinnerExposureType.setAdapter(sp2);
				sp2.setElements(e);//(pldb.getCol1("lutSUREnvironsExposure"));
				spinnerExposureType.setAdapter(sp2);
				spinnerExposureType.setOnItemSelectedListener(new OnItemSelectedListener() {
					public void onNothingSelected(AdapterView<?> arg0) {
						
					}

					public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
						//earthmatbedrockModel.getEntity().setLithGroup("");
						System.out.println(parent.getItemAtPosition(position));
					}
				});
			}
			else if (tab == 3)
			{
				
				convertView = mInflater.inflate(R.layout.environ_surficial3, null);
				
				Spinner spinnerVegetation = (Spinner)convertView.findViewById(R.id.environ_surficial_spinner_vegetation);
				SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
				spinnerVegetation.setAdapter(sp1);
				sp1.setElements(e);//(pldb.getCol1("lutSUREnvironsVegetation"));
				spinnerVegetation.setAdapter(sp1);
				spinnerVegetation.setOnItemSelectedListener(new OnItemSelectedListener() {
					public void onNothingSelected(AdapterView<?> arg0) {
						
					}

					public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
						//earthmatbedrockModel.getEntity().setLithGroup("");
						System.out.println(parent.getItemAtPosition(position));
					}
				});
				
				Spinner spinnerVegetationPer = (Spinner)convertView.findViewById(R.id.environ_surficial_spinner_vegetationPer);
				SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
				spinnerVegetationPer.setAdapter(sp2);
				sp2.setElements(e);//(pldb.getCol1("lutSURGeneralPercent5incr"));
				spinnerVegetationPer.setAdapter(sp2);
				spinnerVegetationPer.setOnItemSelectedListener(new OnItemSelectedListener() {
					public void onNothingSelected(AdapterView<?> arg0) {
						
					}

					public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
						//earthmatbedrockModel.getEntity().setLithGroup("");
						System.out.println(parent.getItemAtPosition(position));
					}
				});
				
				
				Button buttonVegetation = (Button)convertView.findViewById(R.id.environ_surficial_button_vegetation);
				EditText editTextVegetation = (EditText)convertView.findViewById(R.id.environ_surficial_editText_vegetation);
				Spinner spinnerBoulders = (Spinner)convertView.findViewById(R.id.environ_surficial_spinner_boulders);
				SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
				spinnerBoulders.setAdapter(sp3);
				sp3.setElements(e);//(pldb.getCol1("lutSUREnvironsBoulders"));
				spinnerBoulders.setAdapter(sp3);
				spinnerBoulders.setOnItemSelectedListener(new OnItemSelectedListener() {
					public void onNothingSelected(AdapterView<?> arg0) {
						
					}

					public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
						//earthmatbedrockModel.getEntity().setLithGroup("");
						System.out.println(parent.getItemAtPosition(position));
					}
				});
				
				
				CheckBox checkBoxBoulderField = (CheckBox)convertView.findViewById(R.id.environ_checkBox_boulderField);
				Spinner spinnerBoulderField = (Spinner)convertView.findViewById(R.id.environ_surficial_spinner_boulderField);
				SpinnerController sp4 = new SpinnerController(context, android.R.layout.simple_spinner_item);
				spinnerBoulderField.setAdapter(sp4);
				sp4.setElements(e);//(pldb.getCol1("lutSUREnvironsBoFldTyp"));
				spinnerBoulderField.setAdapter(sp4);
				spinnerBoulderField.setOnItemSelectedListener(new OnItemSelectedListener() {
					public void onNothingSelected(AdapterView<?> arg0) {
						
					}

					public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
						//earthmatbedrockModel.getEntity().setLithGroup("");
						System.out.println(parent.getItemAtPosition(position));
					}
				});
				
			}
			else if (tab == 4)
			{
				
				convertView = mInflater.inflate(R.layout.environ_surficial4, null);
				
				Spinner spinnerGroundCover = (Spinner)convertView.findViewById(R.id.environ_surficial_spinner_groundCover);
				SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
				spinnerGroundCover.setAdapter(sp1);
				sp1.setElements(e);//(pldb.getCol1("lutSUREnvironsGroundcover"));
				spinnerGroundCover.setAdapter(sp1);
				spinnerGroundCover.setOnItemSelectedListener(new OnItemSelectedListener() {
					public void onNothingSelected(AdapterView<?> arg0) {
						
					}

					public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
						//earthmatbedrockModel.getEntity().setLithGroup("");
						System.out.println(parent.getItemAtPosition(position));
					}
				});
				
				Spinner spinnerGroundCoverPer = (Spinner)convertView.findViewById(R.id.environ_surficial_spinner_groundCoverPer);
				SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
				spinnerGroundCoverPer.setAdapter(sp2);
				sp2.setElements(e);//(pldb.getCol1("lutSURGeneralPercent5incr"));
				spinnerGroundCoverPer.setAdapter(sp2);
				spinnerGroundCoverPer.setOnItemSelectedListener(new OnItemSelectedListener() {
					public void onNothingSelected(AdapterView<?> arg0) {
						
					}

					public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
						//earthmatbedrockModel.getEntity().setLithGroup("");
						System.out.println(parent.getItemAtPosition(position));
					}
				});
				
				Button buttonGroundCover = (Button)convertView.findViewById(R.id.environ_surficial_button_groundCover);
				EditText editTextGroundCover = (EditText)convertView.findViewById(R.id.environ_surficial_editText_groundCover);
				Spinner spinnerPattGrnd = (Spinner)convertView.findViewById(R.id.environ_surficial_spinner_pattGrnd);
				SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
				spinnerPattGrnd.setAdapter(sp3);
				sp3.setElements(e);//(pldb.getCol1("lutSUREnvironsPatterngrn"));
				spinnerPattGrnd.setAdapter(sp3);
				spinnerPattGrnd.setOnItemSelectedListener(new OnItemSelectedListener() {
					public void onNothingSelected(AdapterView<?> arg0) {
						
					}

					public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
						//earthmatbedrockModel.getEntity().setLithGroup("");
						System.out.println(parent.getItemAtPosition(position));
					}
				});
				
				Button buttonPattGrndClear = (Button)convertView.findViewById(R.id.environ_surficial_button_pattGrnd_clear);
				EditText editTextPattGrnd = (EditText)convertView.findViewById(R.id.environ_surficial_editText_pattGrnd);
				EditText editTextPatternArea = (EditText)convertView.findViewById(R.id.environ_surficial_editText_patternArea);
				
				
			}
			else if (tab == 5)
			{
				
				convertView = mInflater.inflate(R.layout.environ_surficial5, null);
				
				EditText editTextEnvironNote = (EditText)convertView.findViewById(R.id.environ_surficial_editText_environNote);
				
				
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
