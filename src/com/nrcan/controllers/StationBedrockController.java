package com.nrcan.controllers;

import java.util.ArrayList;

import com.nrcan.main.PicklistDatabaseHandler;
import com.nrcan.main.R;
import com.nrcan.models.StationBedrockModel;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;


public class StationBedrockController extends BaseAdapter implements Filterable {
	private LayoutInflater mInflater;
	private Activity activity;
	private Context context;
	private int tab;
	private PicklistDatabaseHandler pldb;
	private ArrayList<String> e = new ArrayList<String>();
	private StationBedrockModel stationBedrockModel;

	public StationBedrockController(Context context, Activity activity,StationBedrockModel stationBedrockModel,PicklistDatabaseHandler pldb) {
		this.mInflater = LayoutInflater.from(context);
		this.activity = activity;
		this.context = context;
		this.tab = 1;
		this.stationBedrockModel = stationBedrockModel;
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
			

			convertView = mInflater.inflate(R.layout.station_bedrock_1, null);
			EditText editTextTrav = (EditText) convertView
					.findViewById(R.id.station_text_traverse);
			Button buttonDate = (Button) convertView
					.findViewById(R.id.station_button_date);
			EditText editTextElev = (EditText) convertView
					.findViewById(R.id.station_text_elevation);
			Spinner spinnerElev = (Spinner) convertView
					.findViewById(R.id.station_spinner_elevation);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerElev.setAdapter(sp1);
			sp1.setElements(e);//(pldb.getCol1("lutBEDStationElevmethod"));
			spinnerElev.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			EditText editTextEasting = (EditText) convertView
					.findViewById(R.id.station_text_easting);
			EditText editTextNorthing = (EditText) convertView
					.findViewById(R.id.station_text_northing);
			EditText editTextLatitude = (EditText) convertView
					.findViewById(R.id.station_text_latitude);
			EditText editTextLongitude = (EditText) convertView
					.findViewById(R.id.station_text_longitude);

			
		} else if (tab == 2) {
			
			convertView = mInflater.inflate(R.layout.station_bedrock_2, null);

			Spinner spinnerObsType = (Spinner) convertView
					.findViewById(R.id.station_spinner_obstype);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerObsType.setAdapter(sp1);
			sp1.setElements(e);//(pldb.getCol1("lutBEDStationObstype"));
			spinnerObsType.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Spinner spinnerEntryType = (Spinner) convertView
					.findViewById(R.id.station_spinner_entryType);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerEntryType.setAdapter(sp2);
			sp2.setElements(e);//(pldb.getCol1("lutBEDStationEntrytype"));
			spinnerEntryType.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Spinner spinnerOutcrop = (Spinner) convertView
					.findViewById(R.id.station_spinner_outcropqual);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerOutcrop.setAdapter(sp3);
			sp3.setElements(e);//(pldb.getCol1("lutBEDStationOutcropqual"));
			spinnerOutcrop.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Spinner spinnerPhysEnviron = (Spinner) convertView
					.findViewById(R.id.station_spinner_physenviron);
			SpinnerController sp4 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerPhysEnviron.setAdapter(sp4);
			sp4.setElements(e);//(pldb.getCol1("lutBEDStationPhysenviron"));
			spinnerPhysEnviron.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			EditText editTextOutcropSize = (EditText) convertView
					.findViewById(R.id.station_text_outcropsize);
			

			
		} else if (tab == 3) {
			
			convertView = mInflater.inflate(R.layout.station_bedrock_3, null);
			EditText editTextAirPhoto = (EditText) convertView
					.findViewById(R.id.station_text_airphoto);
			EditText editTextPartner = (EditText) convertView
					.findViewById(R.id.station_editText_partner);
			
			
		} else if (tab == 4) {
			
			convertView = mInflater.inflate(R.layout.station_bedrock_4, null);

			EditText editTextStationNote = (EditText) convertView
					.findViewById(R.id.station_text_stationnote);
			
		} else if (tab == 5) {
			
			convertView = mInflater.inflate(R.layout.station_bedrock_4, null);

			EditText editTextLastStationNote = (EditText) convertView
					.findViewById(R.id.station_text_sincelaststationnote);
			
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
