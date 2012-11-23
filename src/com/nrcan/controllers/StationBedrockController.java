package com.nrcan.controllers;

import java.util.ArrayList;

import com.nrcan.entities.StationBedrockEntity;

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
	private StationBedrockEntity stationBedrockEntity;

	public StationBedrockController(Context context, Activity activity,StationBedrockModel stationBedrockModel,PicklistDatabaseHandler pldb) {
		this.mInflater = LayoutInflater.from(context);
		this.activity = activity;
		this.context = context;
		this.tab = 1;
		this.stationBedrockModel = stationBedrockModel;
		this.stationBedrockEntity = stationBedrockModel.getEntity();
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
			editTextTrav.setText(stationBedrockEntity.getTravNo());
			//Button buttonDate = (Button) convertView
			//		.findViewById(R.id.station_button_date);
			// need some button functionality
			EditText editTextElev = (EditText) convertView
					.findViewById(R.id.station_text_elevation);
			editTextElev.setText(stationBedrockEntity.getElevation());
			
			Spinner spinnerElev = (Spinner) convertView.findViewById(R.id.station_spinner_elevation);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutBEDStationElevmethod"));
			spinnerElev.setAdapter(sp1);
			spinnerElev.setSelection(sp1.getPosition(stationBedrockEntity.getElevMethod()));
			spinnerElev.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					stationBedrockEntity.setElevMethod(parent.getItemAtPosition(position).toString());
				}
			});
			
			
			
			EditText editTextEasting = (EditText) convertView
					.findViewById(R.id.station_text_easting);
			editTextEasting.setText(stationBedrockEntity.getEasting());
			EditText editTextNorthing = (EditText) convertView
					.findViewById(R.id.station_text_northing);
			editTextNorthing.setText(stationBedrockEntity.getNorthing());
			EditText editTextLatitude = (EditText) convertView
					.findViewById(R.id.station_text_latitude);
			editTextLatitude.setText(stationBedrockEntity.getLatitude());
			EditText editTextLongitude = (EditText) convertView
					.findViewById(R.id.station_text_longitude);
			editTextLongitude.setText(stationBedrockEntity.getLongitude());

			
		} else if (tab == 2) {
			
			convertView = mInflater.inflate(R.layout.station_bedrock_2, null);

			Spinner spinnerObsType = (Spinner) convertView.findViewById(R.id.station_spinner_obstype);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutBEDStationObstype"));
			spinnerObsType.setAdapter(sp1);
			spinnerObsType.setSelection(sp1.getPosition(stationBedrockEntity.getObsType()));
			spinnerObsType.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					stationBedrockEntity.setObsType(parent.getItemAtPosition(position).toString());
				}
			});
			
			Spinner spinnerEntryType = (Spinner) convertView.findViewById(R.id.station_spinner_entryType);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp2.setElements(pldb.getCol1("lutBEDStationEntrytype"));
			spinnerEntryType.setAdapter(sp2);
			spinnerEntryType.setSelection(sp2.getPosition(stationBedrockEntity.getEntryType()));
			spinnerEntryType.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					stationBedrockEntity.setEntryType(parent.getItemAtPosition(position).toString());
				}
			});
			
			Spinner spinnerPhysEnviron = (Spinner) convertView.findViewById(R.id.station_spinner_physenviron);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp3.setElements(pldb.getCol1("lutBEDStationPhysenviron"));
			spinnerPhysEnviron.setAdapter(sp3);
			spinnerPhysEnviron.setSelection(sp3.getPosition(stationBedrockEntity.getPhysEnv()));
			spinnerPhysEnviron.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					stationBedrockEntity.setPhysEnv(parent.getItemAtPosition(position).toString());
				}
			});
			
			
			
			
			EditText editTextOutcropSize = (EditText) convertView
					.findViewById(R.id.station_text_outcropsize);
			editTextOutcropSize.setText(stationBedrockEntity.getOcSize());

			
		} else if (tab == 3) {
			
			convertView = mInflater.inflate(R.layout.station_bedrock_3, null);
			EditText editTextAirPhoto = (EditText) convertView
					.findViewById(R.id.station_text_airphoto);
			editTextAirPhoto.setText(stationBedrockEntity.getAirPhoto());
			EditText editTextPartner = (EditText) convertView
					.findViewById(R.id.station_editText_partner);
			editTextPartner.setText(stationBedrockEntity.getPartner());
			
			
		} else if (tab == 4) {
			
			convertView = mInflater.inflate(R.layout.station_bedrock_4, null);

			EditText editTextStationNote = (EditText) convertView
					.findViewById(R.id.station_text_stationnote);
			editTextStationNote.setText(stationBedrockEntity.getNotes());
			
		} else if (tab == 5) {
			
			convertView = mInflater.inflate(R.layout.station_bedrock_4, null);

			EditText editTextLastStationNote = (EditText) convertView
					.findViewById(R.id.station_text_sincelaststationnote);
			editTextLastStationNote.setText(stationBedrockEntity.getSlsNotes());
			
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
