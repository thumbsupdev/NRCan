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
			

			convertView = mInflater.inflate(R.layout.station_bedrock_1, null);
			EditText editTextTrav = (EditText) convertView
					.findViewById(R.id.station_text_traverse);
			Button buttonDate = (Button) convertView
					.findViewById(R.id.station_button_date);
			EditText editTextElev = (EditText) convertView
					.findViewById(R.id.station_text_elevation);
			Spinner spinnerElev = (Spinner) convertView
					.findViewById(R.id.station_spinner_elevation);
			SpinnerController sp1 = new SpinnerController(context, activity, "lutBEDStationElevmethod");
			spinnerElev.setAdapter(sp1);
			sp1.setElementsCol1();
			
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
			SpinnerController sp1 = new SpinnerController(context, activity, "lutBEDStationObstype");
			spinnerObsType.setAdapter(sp1);
			sp1.setElementsCol1();
			
			Spinner spinnerEntryType = (Spinner) convertView
					.findViewById(R.id.station_spinner_entryType);
			SpinnerController sp2 = new SpinnerController(context, activity, "lutBEDStationEntrytype");
			spinnerEntryType.setAdapter(sp2);
			sp2.setElementsCol1();
			
			Spinner spinnerOutcrop = (Spinner) convertView
					.findViewById(R.id.station_spinner_outcropqual);
			SpinnerController sp3 = new SpinnerController(context, activity, "lutBEDStationOutcropqual");
			spinnerOutcrop.setAdapter(sp3);
			sp3.setElementsCol1();
			
			Spinner spinnerPhysEnviron = (Spinner) convertView
					.findViewById(R.id.station_spinner_physenviron);
			SpinnerController sp4 = new SpinnerController(context, activity, "lutBEDStationPhysenviron");
			spinnerPhysEnviron.setAdapter(sp4);
			sp4.setElementsCol1();
			
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
