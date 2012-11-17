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
import android.widget.Spinner;


public class StationBedrockController extends BaseAdapter implements Filterable {
	private LayoutInflater mInflater;
	private Activity activity;
	private Context context;
	private int tab;

	public StationBedrockController(Context context, Activity activity) {
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
			StationBedrock1 holder;
			holder = new StationBedrock1();

			convertView = mInflater.inflate(R.layout.station_bedrock_1, null);
			holder.editTextTrav = (EditText) convertView
					.findViewById(R.id.station_text_traverse);
			holder.buttonDate = (Button) convertView
					.findViewById(R.id.station_button_date);
			holder.editTextElev = (EditText) convertView
					.findViewById(R.id.station_text_elevation);
			holder.spinnerElev = (Spinner) convertView
					.findViewById(R.id.station_spinner_elevation);
			holder.editTextEasting = (EditText) convertView
					.findViewById(R.id.station_text_easting);
			holder.editTextNorthing = (EditText) convertView
					.findViewById(R.id.station_text_northing);
			holder.editTextLatitude = (EditText) convertView
					.findViewById(R.id.station_text_latitude);
			holder.editTextLongitude = (EditText) convertView
					.findViewById(R.id.station_text_longitude);

			convertView.setTag(holder);
		} else if (tab == 2) {
			StationBedrock2 holder;
			holder = new StationBedrock2();
			convertView = mInflater.inflate(R.layout.station_bedrock_2, null);

			holder.spinnerObsType = (Spinner) convertView
					.findViewById(R.id.station_spinner_obstype);
			holder.spinnerEntryType = (Spinner) convertView
					.findViewById(R.id.station_spinner_entryType);
			holder.spinnerOutcrop = (Spinner) convertView
					.findViewById(R.id.station_spinner_outcropqual);
			holder.spinnerPhysEnviron = (Spinner) convertView
					.findViewById(R.id.station_spinner_physenviron);
			holder.editTextOutcropSize = (EditText) convertView
					.findViewById(R.id.station_text_outcropsize);
			

			convertView.setTag(holder);
		} else if (tab == 3) {
			StationBedrock3 holder;
			holder = new StationBedrock3();
			convertView = mInflater.inflate(R.layout.station_bedrock_3, null);
			holder.editTextAirPhoto = (EditText) convertView
					.findViewById(R.id.station_text_airphoto);
			holder.editTextPartner = (EditText) convertView
					.findViewById(R.id.station_editText_partner);
			
			convertView.setTag(holder);
		} else if (tab == 4) {
			StationBedrock4 holder;
			holder = new StationBedrock4();
			convertView = mInflater.inflate(R.layout.station_bedrock_4, null);

			holder.editTextStationNote = (EditText) convertView
					.findViewById(R.id.station_text_stationnote);
			convertView.setTag(holder);
		} else if (tab == 5) {
			StationBedrock5 holder;
			holder = new StationBedrock5();
			convertView = mInflater.inflate(R.layout.station_bedrock_4, null);

			holder.editTextLastStationNote = (EditText) convertView
					.findViewById(R.id.station_text_sincelaststationnote);
			convertView.setTag(holder);
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

	static class StationBedrock1 {
		EditText editTextTrav;
		Button buttonDate;
		EditText editTextElev;
		Spinner spinnerElev;
		EditText editTextEasting;
		EditText editTextNorthing;
		EditText editTextLatitude;
		EditText editTextLongitude;

	}

	static class StationBedrock2 {
		Spinner spinnerObsType;
		Spinner spinnerEntryType;
		Spinner spinnerOutcrop;
		EditText editTextOutcropSize;
		Spinner spinnerPhysEnviron;
		
		
	}
	
	static class StationBedrock3 {
		EditText editTextAirPhoto;
		EditText editTextPartner;
	}

	static class StationBedrock4 {
		EditText editTextStationNote;

	}

	static class StationBedrock5 {
		EditText editTextLastStationNote;
	}
}
