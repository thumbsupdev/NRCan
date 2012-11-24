package com.nrcan.controllers;

import java.util.ArrayList;

import com.nrcan.entities.StationBedrockEntity;

import com.nrcan.main.PicklistDatabaseHandler;
import com.nrcan.main.R;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
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
	private StationBedrockEntity stationBedrockEntity;

	public StationBedrockController(Context context, Activity activity,StationBedrockEntity stationBedrockEntity,PicklistDatabaseHandler pldb) {
		this.mInflater = LayoutInflater.from(context);
		this.activity = activity;
		this.context = context;
		this.tab = 1;
		this.stationBedrockEntity = stationBedrockEntity;
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
			EditText editTextTrav = (EditText) convertView.findViewById(R.id.station_text_traverse);
			editTextTrav.setText(stationBedrockEntity.getTravNo());
			editTextTrav.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						stationBedrockEntity.setTravNo("");
					else
						stationBedrockEntity.setTravNo(s.toString());
				}
			});
			//Button buttonDate = (Button) convertView
			//		.findViewById(R.id.station_button_date);
			// need some button functionality
			EditText editTextElev = (EditText) convertView.findViewById(R.id.station_text_elevation);
			editTextElev.setText(stationBedrockEntity.getElevation());
			editTextElev.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						stationBedrockEntity.setElevation("");
					else
						stationBedrockEntity.setElevation(s.toString());
				}
			});
			
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
			
			
			
			EditText editTextEasting = (EditText) convertView.findViewById(R.id.station_text_easting);
			editTextEasting.setText(stationBedrockEntity.getEasting());
			editTextEasting.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						stationBedrockEntity.setEasting("");
					else
						stationBedrockEntity.setEasting(s.toString());
				}
			});
			EditText editTextNorthing = (EditText) convertView.findViewById(R.id.station_text_northing);
			editTextNorthing.setText(stationBedrockEntity.getNorthing());
			editTextNorthing.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						stationBedrockEntity.setNorthing("");
					else
						stationBedrockEntity.setNorthing(s.toString());
				}
			});
			
			EditText editTextLatitude = (EditText) convertView.findViewById(R.id.station_text_latitude);
			editTextLatitude.setText(stationBedrockEntity.getLatitude());
			editTextLatitude.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						stationBedrockEntity.setLatitude("");
					else
						stationBedrockEntity.setLatitude(s.toString());
				}
			});
			
			EditText editTextLongitude = (EditText) convertView
					.findViewById(R.id.station_text_longitude);
			editTextLongitude.setText(stationBedrockEntity.getLongitude());
			editTextLongitude.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						stationBedrockEntity.setLongitude("");
					else
						stationBedrockEntity.setLongitude(s.toString());
				}
			});

			
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
			
			Spinner spinnerOCQuality = (Spinner) convertView.findViewById(R.id.station_spinner_outcropqual);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp3.setElements(pldb.getCol1("lutBEDStationOutcropqual"));
			spinnerOCQuality.setAdapter(sp3);
			spinnerOCQuality.setSelection(sp3.getPosition(stationBedrockEntity.getOCQuality()));
			spinnerOCQuality.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					stationBedrockEntity.setEntryType(parent.getItemAtPosition(position).toString());
				}
			});
			
			EditText editTextOutcropSize = (EditText) convertView.findViewById(R.id.station_text_outcropsize);
			editTextOutcropSize.setText(stationBedrockEntity.getOcSize());
			editTextOutcropSize.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						stationBedrockEntity.setOcSize("");
					else
						stationBedrockEntity.setOcSize(s.toString());
				}
			});
			
			Spinner spinnerPhysEnviron = (Spinner) convertView.findViewById(R.id.station_spinner_physenviron);
			SpinnerController sp4 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp4.setElements(pldb.getCol1("lutBEDStationPhysenviron"));
			spinnerPhysEnviron.setAdapter(sp4);
			spinnerPhysEnviron.setSelection(sp4.getPosition(stationBedrockEntity.getPhysEnv()));
			spinnerPhysEnviron.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					stationBedrockEntity.setPhysEnv(parent.getItemAtPosition(position).toString());
				}
			});

			
		} else if (tab == 3) {
			
			convertView = mInflater.inflate(R.layout.station_bedrock_3, null);
			EditText editTextAirPhoto = (EditText) convertView.findViewById(R.id.station_text_airphoto);
			editTextAirPhoto.setText(stationBedrockEntity.getAirPhoto());
			editTextAirPhoto.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						stationBedrockEntity.setAirPhoto("");
					else
						stationBedrockEntity.setAirPhoto(s.toString());
				}
			});
			EditText editTextPartner = (EditText) convertView.findViewById(R.id.station_editText_partner);
			editTextPartner.setText(stationBedrockEntity.getPartner());
			editTextPartner.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						stationBedrockEntity.setPartner("");
					else
						stationBedrockEntity.setPartner(s.toString());
				}
			});
			
			
		} else if (tab == 4) {
			
			convertView = mInflater.inflate(R.layout.station_bedrock_4, null);

			EditText editTextStationNote = (EditText) convertView.findViewById(R.id.station_text_stationnote);
			editTextStationNote.setText(stationBedrockEntity.getNotes());
			editTextStationNote.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						stationBedrockEntity.setNotes("");
					else
						stationBedrockEntity.setNotes(s.toString());
				}
			});
			
		} else if (tab == 5) {
			convertView = mInflater.inflate(R.layout.station_bedrock_5, null);

			EditText editTextLastStationNote = (EditText) convertView.findViewById(R.id.station_text_sincelaststationnote);
			editTextLastStationNote.setText(stationBedrockEntity.getSlsNotes());
			editTextLastStationNote.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						stationBedrockEntity.setSlsNotes("");
					else
						stationBedrockEntity.setSlsNotes(s.toString());
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


}
