package com.nrcan.controllers;

import java.util.Calendar;

import com.nrcan.entities.StationBedrockEntity;
import com.nrcan.main.PicklistDatabaseHandler;
import com.nrcan.main.R;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class StationBedrockController extends BaseAdapter implements Filterable {
	private LayoutInflater mInflater;
	//private Activity activity;
	private Context context;
	private int tab;
	private PicklistDatabaseHandler pldb;
	private StationBedrockEntity stationBedrockEntity;
    private GPSController gpsController;

	public StationBedrockController(Context context, Activity activity, StationBedrockEntity stationBedrockEntity, PicklistDatabaseHandler pldb) {
		this.mInflater = LayoutInflater.from(context);
		//this.activity = activity;
		this.context = context;
		this.tab = 1;
		this.stationBedrockEntity = stationBedrockEntity;
		this.pldb = pldb;
		//doGPS();
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
			
			/////////////////////////////////////
			// EDITTEXT TRAVERSE
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (1/8)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
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
			
			/////////////////////////////////////
			// BUTTON DATE
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (2/8)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			setDate();
			Button buttonDate = (Button) convertView.findViewById(R.id.station_button_date);
			buttonDate.setText(stationBedrockEntity.getVisitDate());
			buttonDate.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					spawnDateDialog();
				}
			});
			
			/////////////////////////////////////
			// EDITTEXT ELEVATION
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (3/8)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
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
			
			/////////////////////////////////////
			// SPINNER ELEVATION METHOD
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (4/8)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerElev = (Spinner) convertView.findViewById(R.id.station_spinner_elevation);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutBEDStationElevmethod"));
			sp1.setNewElement(pldb, "lutBEDStationElevmethod", 1, null, null);
			sp1.addSpace();
			spinnerElev.setAdapter(sp1);
			spinnerElev.setSelection(sp1.getPosition(stationBedrockEntity.getElevMethod()));
			spinnerElev.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					stationBedrockEntity.setElevMethod(parent.getItemAtPosition(position).toString());
				}
			});

			/////////////////////////////////////
			// EDITTEXT EASTING
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (5/8)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
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

			/////////////////////////////////////
			// EDITTEXT NORTHING
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (6/8)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
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

			/////////////////////////////////////
			// EDITTEXT LATITUDE
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (7/8)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
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

			/////////////////////////////////////
			// EDITTEXT LONGITUDE
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (8/8)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextLongitude = (EditText) convertView.findViewById(R.id.station_text_longitude);
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
			
			/////////////////////////////////////
			// SPINNER OBSERVATION TYPE
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 2 - ELEMENT (1/5)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerObsType = (Spinner) convertView.findViewById(R.id.station_spinner_obstype);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutBEDStationObstype"));
			sp1.setNewElement(pldb, "lutBEDStationObstype", 1, null, null);
			sp1.addSpace();
			spinnerObsType.setAdapter(sp1);
			spinnerObsType.setSelection(sp1.getPosition(stationBedrockEntity.getObsType()));
			spinnerObsType.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					stationBedrockEntity.setObsType(parent.getItemAtPosition(position).toString());
				}
			});
			
			/////////////////////////////////////
			// SPINNER ENTRY TYPE
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 2 - ELEMENT (2/5)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerEntryType = (Spinner) convertView.findViewById(R.id.station_spinner_entryType);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp2.setElements(pldb.getCol1("lutBEDStationEntrytype"));
			sp2.setNewElement(pldb, "lutBEDStationEntrytype", 1, null, null);
			sp2.addSpace();
			spinnerEntryType.setAdapter(sp2);
			spinnerEntryType.setSelection(sp2.getPosition(stationBedrockEntity.getEntryType()));
			spinnerEntryType.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					stationBedrockEntity.setEntryType(parent.getItemAtPosition(position).toString());
				}
			});
			
			/////////////////////////////////////
			// SPINNER OUTCROP QUALITY
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 2 - ELEMENT (3/5)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerOCQuality = (Spinner) convertView.findViewById(R.id.station_spinner_outcropqual);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp3.setElements(pldb.getCol1("lutBEDStationOutcropqual"));
			sp3.setNewElement(pldb, "lutBEDStationOutcropqual", 1, null, null);
			sp3.addSpace();
			spinnerOCQuality.setAdapter(sp3);
			spinnerOCQuality.setSelection(sp3.getPosition(stationBedrockEntity.getOCQuality()));
			spinnerOCQuality.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					stationBedrockEntity.setOCQuality(parent.getItemAtPosition(position).toString());
				}
			});
			
			/////////////////////////////////////
			// EDITTEXT OUTCROP SIZE
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 2 - ELEMENT (4/5)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
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

			/////////////////////////////////////
			// SPINNER PHYSICAL ENVIRONMENT
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 2 - ELEMENT (5/5)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerPhysEnviron = (Spinner) convertView.findViewById(R.id.station_spinner_physenviron);
			SpinnerController sp4 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp4.setElements(pldb.getCol1("lutBEDStationPhysenviron"));
			sp4.setNewElement(pldb, "lutBEDStationPhysenviron", 1, null, null);
			sp4.addSpace();
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

			/////////////////////////////////////
			// EDITTEXT AIR PHOTO
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 3 - ELEMENT (1/2)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
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

			/////////////////////////////////////
			// EDITTEXT PARTNER
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 3 - ELEMENT (2/2)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
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
			
			/////////////////////////////////////
			// EDITTEXT STATION NOTE (254)
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 4 - ELEMENT (1/1)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
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

			/////////////////////////////////////
			// EDITTEXT SLS NOTE (254)
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 5 - ELEMENT (1/1)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
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

	public void spawnDateDialog() {
		Calendar cal = Calendar.getInstance();

		DatePickerDialog dateDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
			public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
				Time time = new Time();
				time.set(dayOfMonth, monthOfYear, year);
				String date = DateFormat.format("MMMM dd, yyyy", time.toMillis(true)).toString();
				stationBedrockEntity.setVisitDate(date);
				notifyDataSetChanged();
			}
		}, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));

		dateDialog.setMessage("Please select a date");
		dateDialog.show();
	}
	
	public void setDate() {
		Time time = new Time();
		time.setToNow();
		String date = DateFormat.format("MMMM dd, yyyy", time.toMillis(true)).toString();
		stationBedrockEntity.setVisitDate(date);
        stationBedrockEntity.setVisitTime(DateFormat.format("hh:mm:ss", time.toMillis(true)).toString());
	}
	
	private void doGPS() {
        if(gpsController == null) {
            gpsController = new GPSController(context);
            gpsController.turnOnGPS();
            gpsController.requestGPSData();
            stationBedrockEntity.setLatitude(String.valueOf(gpsController.getLatitude()));
            stationBedrockEntity.setLongitude(String.valueOf(gpsController.getLongitude()));
            stationBedrockEntity.setElevation(String.valueOf(gpsController.getElevation()));
        } else {
            gpsController.turnOffGPS();
            gpsController = null;
        }
	}
	
	public void clear() {
		stationBedrockEntity.clearEntity();
		tab = 1;
		notifyDataSetChanged();
	
	}
}
