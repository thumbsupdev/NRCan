package com.nrcan.controllers;

import java.util.ArrayList;

import com.nrcan.entities.StationSurficialEntity;
import com.nrcan.main.PicklistDatabaseHandler;
import com.nrcan.main.R;
import com.nrcan.models.StationBedrockModel;
import com.nrcan.models.StationSurficialModel;

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
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class StationSurficialController extends BaseAdapter implements
		Filterable {
	private LayoutInflater mInflater;
	private Activity activity;
	private Context context;
	private int tab;
	private PicklistDatabaseHandler pldb;
	private ArrayList<String> e = new ArrayList<String>();
	private StationSurficialModel stationSurficialModel;
	private StationSurficialEntity stationSurficialEntity;

	public StationSurficialController(Context context, Activity activity,StationSurficialModel stationSurficialModel,PicklistDatabaseHandler pldb) {
		this.mInflater = LayoutInflater.from(context);
		this.activity = activity;
		this.context = context;
		this.tab = 1;
		this.stationSurficialModel = stationSurficialModel;
		this.stationSurficialEntity = stationSurficialModel.getEntity();
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
			
			convertView = mInflater.inflate(R.layout.station_surficial_1, null);

			EditText editTextTrav = (EditText) convertView
					.findViewById(R.id.station_surficial_text_traverse);
			editTextTrav.setText(stationSurficialEntity.getTravNo());
			//Button buttonDate = (Button) convertView
			//		.findViewById(R.id.station_surficial_button_date);
			
			//Needs date button functionality
			
			EditText editTextElev = (EditText) convertView
					.findViewById(R.id.station_surficial_text_elevation);
			editTextElev.setText(stationSurficialEntity.getElevation());
			
			Spinner spinnerElev = (Spinner) convertView.findViewById(R.id.station_surficial_spinner_elevation);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutStationSURElevmethod"));
			spinnerElev.setAdapter(sp1);
			spinnerElev.setSelection(sp1.getPosition(stationSurficialEntity.getElevation()));
			spinnerElev.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					stationSurficialEntity.setElevation(parent.getItemAtPosition(position).toString());
				}
			});
			
			
			
			EditText editTextEasting = (EditText) convertView
					.findViewById(R.id.station_surficial_text_easting);
			editTextEasting.setText(stationSurficialEntity.getEasting());
			EditText editTextNorthing = (EditText) convertView
					.findViewById(R.id.station_surficial_text_northing);
			editTextNorthing.setText(stationSurficialEntity.getNorthing());
			EditText editTextLatitude = (EditText) convertView
					.findViewById(R.id.station_surficial_text_latitude);
			editTextLatitude.setText(stationSurficialEntity.getLatitude());
			EditText editTextLongitude = (EditText) convertView
					.findViewById(R.id.station_surficial_text_longitude);
			editTextLongitude.setText(stationSurficialEntity.getLongitude());

			
		} else if (tab == 2) {
			
			convertView = mInflater.inflate(R.layout.station_surficial_2, null);

			Spinner spinnerObsType = (Spinner) convertView.findViewById(R.id.station_surficial_spinner_obstype);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutSURStationObsType"));
			spinnerObsType.setAdapter(sp1);
			spinnerObsType.setSelection(sp1.getPosition(stationSurficialEntity.getObsType()));
			spinnerObsType.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					stationSurficialEntity.setObsType(parent.getItemAtPosition(position).toString());
				}
			});
			
			Spinner spinnerEntrytype = (Spinner) convertView.findViewById(R.id.station_surficial_spinner_entryType);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp2.setElements(pldb.getCol1("lutSURStationEntrytype"));
			spinnerEntrytype.setAdapter(sp2);
			spinnerEntrytype.setSelection(sp2.getPosition(stationSurficialEntity.getEntryType()));
			spinnerEntrytype.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					stationSurficialEntity.setEntryType(parent.getItemAtPosition(position).toString());
				}
			});
			
			Spinner spinnerLegendValue = (Spinner) convertView.findViewById(R.id.station_surficial_spinner_legendvalue);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp3.setElements(pldb.getCol1("lutBEDMetadataPrjctType"));
			spinnerLegendValue.setAdapter(sp3);
			spinnerLegendValue.setSelection(sp3.getPosition(stationSurficialEntity.getLegendVal()));
			spinnerLegendValue.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					stationSurficialEntity.setLegendVal(parent.getItemAtPosition(position).toString());
				}
			});

			
		} else if (tab == 3) {
			
			convertView = mInflater.inflate(R.layout.station_surficial_3, null);
			
			Spinner spinnerSiteQual = (Spinner) convertView.findViewById(R.id.station_surficial_spinner_sitequal);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutSURStationSitequality"));
			spinnerSiteQual.setAdapter(sp1);
			spinnerSiteQual.setSelection(sp1.getPosition(stationSurficialEntity.getOcQuality()));
			spinnerSiteQual.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					stationSurficialEntity.setOcQuality(parent.getItemAtPosition(position).toString());
				}
			});

			Spinner spinnerPhysEnviron = (Spinner) convertView.findViewById(R.id.station_surficial_spinner_physenviron);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp2.setElements(pldb.getCol1("lutSURStationPhysenv"));
			spinnerPhysEnviron.setAdapter(sp2);
			spinnerPhysEnviron.setSelection(sp2.getPosition(stationSurficialEntity.getPhysEnv()));
			spinnerPhysEnviron.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					stationSurficialEntity.setPhysEnv(parent.getItemAtPosition(position).toString());
				}
			});
			
			
			
			EditText editTextInterpretation = (EditText) convertView
					.findViewById(R.id.station_surficial_editText_interpretation);
			editTextInterpretation.setText(stationSurficialEntity.getOcSize());
			EditText editTextAirPhoto = (EditText) convertView
					.findViewById(R.id.station_surficial_text_airphoto);
			editTextAirPhoto.setText(stationSurficialEntity.getAirPhoto());
			//Button buttonAirPhoto = (Button) convertView
			//		.findViewById(R.id.station_surficial_button_airphoto);
			//Need some button functionality
			EditText editTextMapSheet = (EditText) convertView
					.findViewById(R.id.station_surficial_text_mapsheet);
			editTextMapSheet.setText(stationSurficialEntity.getMapSheet());
			//Button buttonMapSheet = (Button) convertView
			//		.findViewById(R.id.station_surficial_button_mapsheet);
			//need some button functionality
			
		} else if (tab == 4) {
			
			convertView = mInflater.inflate(R.layout.station_surficial_4, null);

			EditText editTextStationNote = (EditText) convertView
					.findViewById(R.id.station_surficial_text_stationnote);
			editTextStationNote.setText(stationSurficialEntity.getNotes());
			
		} else if (tab == 5) {
			
			convertView = mInflater.inflate(R.layout.station_surficial_5, null);
			EditText editTextLastStationNote = (EditText) convertView
					.findViewById(R.id.station_surficial_text_sincelaststationnote);
			editTextLastStationNote.setText(stationSurficialEntity.getSlsNotes());

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
