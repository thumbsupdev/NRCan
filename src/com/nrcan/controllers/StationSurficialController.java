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

public class StationSurficialController extends BaseAdapter implements
		Filterable {
	private LayoutInflater mInflater;
	private Activity activity;
	private Context context;
	private int tab;

	public StationSurficialController(Context context, Activity activity) {
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
			
			convertView = mInflater.inflate(R.layout.station_surficial_1, null);

			EditText editTextTrav = (EditText) convertView
					.findViewById(R.id.station_surficial_text_traverse);
			Button buttonDate = (Button) convertView
					.findViewById(R.id.station_surficial_button_date);
			EditText editTextElev = (EditText) convertView
					.findViewById(R.id.station_surficial_text_elevation);
			Spinner spinnerElev = (Spinner) convertView
					.findViewById(R.id.station_surficial_spinner_elevation);
			SpinnerController sp1 = new SpinnerController(context, activity, "lutStationSURElevmethod");
			spinnerElev.setAdapter(sp1);
			sp1.setElementsCol1();
			
			EditText editTextEasting = (EditText) convertView
					.findViewById(R.id.station_surficial_text_easting);
			EditText editTextNorthing = (EditText) convertView
					.findViewById(R.id.station_surficial_text_northing);
			EditText editTextLatitude = (EditText) convertView
					.findViewById(R.id.station_surficial_text_latitude);
			EditText editTextLongitude = (EditText) convertView
					.findViewById(R.id.station_surficial_text_longitude);

			
		} else if (tab == 2) {
			
			convertView = mInflater.inflate(R.layout.station_surficial_2, null);

			Spinner spinnerObsType = (Spinner) convertView
					.findViewById(R.id.station_surficial_spinner_obstype);
			SpinnerController sp1 = new SpinnerController(context, activity, "lutSURStationObsType");
			spinnerObsType.setAdapter(sp1);
			sp1.setElementsCol1();
			
			Spinner spinnerEntrytype = (Spinner) convertView
					.findViewById(R.id.station_surficial_spinner_entryType);
			SpinnerController sp2 = new SpinnerController(context, activity, "lutSURStationEntrytype");
			spinnerEntrytype.setAdapter(sp2);
			sp2.setElementsCol1();
			
			Spinner spinnerLegendValue = (Spinner) convertView
					.findViewById(R.id.station_surficial_spinner_legendvalue);
			SpinnerController sp3 = new SpinnerController(context, activity, "lutSURStationLegendval");
			spinnerLegendValue.setAdapter(sp3);
			sp3.setElementsCol1();
			

			
		} else if (tab == 3) {
			
			convertView = mInflater.inflate(R.layout.station_surficial_3, null);

			Spinner spinnerSiteQual = (Spinner) convertView
					.findViewById(R.id.station_surficial_spinner_sitequal);
			SpinnerController sp1 = new SpinnerController(context, activity, "lutSURStationSitequality");
			spinnerSiteQual.setAdapter(sp1);
			sp1.setElementsCol1();
			
			Spinner spinnerPhysEnviron = (Spinner) convertView
					.findViewById(R.id.station_surficial_spinner_physenviron);
			SpinnerController sp2 = new SpinnerController(context, activity, "lutSURStationPhysenv");
			spinnerPhysEnviron.setAdapter(sp2);
			sp2.setElementsCol1();
			
			EditText editTextInterpretation = (EditText) convertView
					.findViewById(R.id.station_surficial_editText_interpretation);
			EditText editTextAirPhoto = (EditText) convertView
					.findViewById(R.id.station_surficial_text_airphoto);
			Button buttonAirPhoto = (Button) convertView
					.findViewById(R.id.station_surficial_button_airphoto);
			EditText editTextMapSheet = (EditText) convertView
					.findViewById(R.id.station_surficial_text_mapsheet);
			Button buttonMapSheet = (Button) convertView
					.findViewById(R.id.station_surficial_button_mapsheet);
			
		} else if (tab == 4) {
			
			convertView = mInflater.inflate(R.layout.station_surficial_4, null);

			EditText editTextStationNote = (EditText) convertView
					.findViewById(R.id.station_surficial_text_stationnote);
			
		} else if (tab == 5) {
			
			convertView = mInflater.inflate(R.layout.station_surficial_5, null);
			EditText editTextLastStationNote = (EditText) convertView
					.findViewById(R.id.station_surficial_text_sincelaststationnote);

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
