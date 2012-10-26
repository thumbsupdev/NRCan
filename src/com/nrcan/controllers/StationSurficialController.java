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
			StationSurficial1 holder;
			holder = new StationSurficial1();
			convertView = mInflater.inflate(R.layout.station_surficial_1, null);

			holder.editTextTrav = (EditText) convertView
					.findViewById(R.id.station_surficial_text_traverse);
			holder.buttonDate = (Button) convertView
					.findViewById(R.id.station_surficial_button_date);
			holder.editTextElev = (EditText) convertView
					.findViewById(R.id.station_surficial_text_elevation);
			holder.spinnerElev = (Spinner) convertView
					.findViewById(R.id.station_surficial_spinner_elevation);
			holder.editTextEasting = (EditText) convertView
					.findViewById(R.id.station_surficial_text_easting);
			holder.editTextNorthing = (EditText) convertView
					.findViewById(R.id.station_surficial_text_northing);
			holder.editTextLatitude = (EditText) convertView
					.findViewById(R.id.station_surficial_text_latitude);
			holder.editTextLongitude = (EditText) convertView
					.findViewById(R.id.station_surficial_text_longitude);
			
			
			
			convertView.setTag(holder);
		} else if (tab == 2) {
			StationSurficial2 holder;
			holder = new StationSurficial2();
			convertView = mInflater.inflate(R.layout.station_surficial_2, null);

			holder.spinnerObsType = (Spinner) convertView
					.findViewById(R.id.station_surficial_spinner_obstype);
			holder.editTextLegendValue = (EditText) convertView
					.findViewById(R.id.station_surficial_text_legendvalue);
			holder.spinnerSiteQual = (Spinner) convertView
					.findViewById(R.id.station_surficial_spinner_sitequal);
			holder.spinnerPhysEnviron = (Spinner) convertView
					.findViewById(R.id.station_surficial_spinner_physenviron);
			holder.spinnerInterpretation = (Spinner) convertView
					.findViewById(R.id.station_surficial_spinner_interpretation);
			holder.editTextAirPhoto = (EditText) convertView
					.findViewById(R.id.station_surficial_text_airphoto);
			holder.buttonAirPhoto = (Button) convertView
					.findViewById(R.id.station_surficial_button_airphoto);
			holder.editTextMapSheet = (EditText) convertView
					.findViewById(R.id.station_surficial_text_mapsheet);
			holder.buttonMapSheet = (Button) convertView
					.findViewById(R.id.station_surficial_button_mapsheet);
			
			
			

			convertView.setTag(holder);
		} else if (tab == 3) {
			StationSurficial3 holder;
			holder = new StationSurficial3();
			convertView = mInflater.inflate(R.layout.station_surficial_3, null);

			
			holder.editTextStationNote = (EditText) convertView
					.findViewById(R.id.station_surficial_text_stationnote);

			
				

			convertView.setTag(holder);
		} else if (tab == 4) {
			StationSurficial4 holder;
			holder = new StationSurficial4();
			convertView = mInflater.inflate(R.layout.station_surficial_4, null);

			
			holder.editTextLastStationNote = (EditText) convertView
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

	static class StationSurficial1 {
		EditText editTextTrav;
		Button buttonDate;
		EditText editTextElev;
		Spinner spinnerElev;
		EditText editTextEasting;
		EditText editTextNorthing;
		EditText editTextLatitude;
		EditText editTextLongitude;
		
		

	}

	static class StationSurficial2 {
		
		Spinner spinnerObsType;
		EditText editTextLegendValue;
		Spinner spinnerSiteQual;
		Spinner spinnerPhysEnviron;
		Spinner spinnerInterpretation;
		EditText editTextAirPhoto;
		Button buttonAirPhoto;
		EditText editTextMapSheet;
		Button buttonMapSheet;
		
		

	}

	static class StationSurficial3 {
		
		EditText editTextStationNote;

		

	}

	static class StationSurficial4 {
		
		EditText editTextLastStationNote;
	}

	
}
