package com.nrcan.controllers;

import java.util.Calendar;

import com.nrcan.entities.StationSurficialEntity;
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

public class StationSurficialController extends BaseAdapter implements Filterable {
	private LayoutInflater mInflater;
	//private Activity activity;
	private Context context;
	private int tab;
	private PicklistDatabaseHandler pldb;
	private StationSurficialEntity stationSurficialEntity;
    private GPSController gpsController;

	public StationSurficialController(Context context, Activity activity,StationSurficialEntity stationSurficialEntity,PicklistDatabaseHandler pldb) {
		this.mInflater = LayoutInflater.from(context);
		//this.activity = activity;
		this.context = context;
		this.tab = 1;	
		this.stationSurficialEntity = stationSurficialEntity;
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

			convertView = mInflater.inflate(R.layout.station_surficial_1, null);

			/////////////////////////////////////
			// EDITTEXT TRAV NO
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (1/8)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextTrav = (EditText) convertView.findViewById(R.id.station_surficial_text_traverse);
			editTextTrav.setText(stationSurficialEntity.getTravNo());
			editTextTrav.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						stationSurficialEntity.setTravNo("");
					else
						stationSurficialEntity.setTravNo(s.toString());
				}
			});

			/////////////////////////////////////
			// BUTTON VISIT DATE
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (2/8)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			setDate();
			Button buttonDate = (Button) convertView.findViewById(R.id.station_surficial_button_date);
			buttonDate.setText(stationSurficialEntity.getVisitDate());
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
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextElev = (EditText) convertView.findViewById(R.id.station_surficial_text_elevation);
			editTextElev.setText(stationSurficialEntity.getElevation());
			editTextElev.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					stationSurficialEntity.setElevation((s.length() == 0) ? "" : s.toString());
				}
			});

			/////////////////////////////////////
			// SPINNER ELEVATION METHOD
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (4/8)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerElev = (Spinner) convertView.findViewById(R.id.station_surficial_spinner_elevation);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutSURStationElevmethod"));
			sp1.setNewElement(pldb, "lutSURStationElevmethod", 1, null, null);
			sp1.addSpace();
			spinnerElev.setAdapter(sp1);
			spinnerElev.setSelection(sp1.getPosition(stationSurficialEntity.getElevMethod()));
			spinnerElev.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					stationSurficialEntity.setElevMethod(parent.getItemAtPosition(position).toString());
				}
			});


			/////////////////////////////////////
			// EDITTEXT EASTING
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (5/8)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextEasting = (EditText) convertView.findViewById(R.id.station_surficial_text_easting);
			editTextEasting.setText(stationSurficialEntity.getEasting());
			editTextEasting.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						stationSurficialEntity.setEasting("");
					else
						stationSurficialEntity.setEasting(s.toString());
				}
			});

			/////////////////////////////////////
			// EDITTEXT NORTHING
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (6/8)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextNorthing = (EditText) convertView.findViewById(R.id.station_surficial_text_northing);
			editTextNorthing.setText(stationSurficialEntity.getNorthing());
			editTextNorthing.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						stationSurficialEntity.setNorthing("");
					else
						stationSurficialEntity.setNorthing(s.toString());
				}
			});

			/////////////////////////////////////
			// EDITTEXT LATITUDE
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (7/8)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextLatitude = (EditText) convertView.findViewById(R.id.station_surficial_text_latitude);
			editTextLatitude.setText(stationSurficialEntity.getLatitude());
			editTextLatitude.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						stationSurficialEntity.setLatitude("");
					else
						stationSurficialEntity.setLatitude(s.toString());
				}
			});

			/////////////////////////////////////
			// EDITTEXT LONGITUDE
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (8/8)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextLongitude = (EditText) convertView.findViewById(R.id.station_surficial_text_longitude);
			editTextLongitude.setText(stationSurficialEntity.getLongitude());
			editTextLongitude.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						stationSurficialEntity.setLongitude("");
					else
						stationSurficialEntity.setLongitude(s.toString());
				}
			});


		} else if (tab == 2) {
			convertView = mInflater.inflate(R.layout.station_surficial_2, null);

			/////////////////////////////////////
			// SPINNER OBSERVATION TYPE
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 2 - ELEMENT (1/3)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerObsType = (Spinner) convertView.findViewById(R.id.station_surficial_spinner_obstype);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutSURStationObsType"));
			sp1.setNewElement(pldb, "lutSURStationObsType", 1, null, null);
			sp1.addSpace();
			spinnerObsType.setAdapter(sp1);
			spinnerObsType.setSelection(sp1.getPosition(stationSurficialEntity.getObsType()));
			spinnerObsType.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					stationSurficialEntity.setObsType(parent.getItemAtPosition(position).toString());
				}
			});

			/////////////////////////////////////
			// SPINNER ENTRY TYPE
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 2 - ELEMENT (2/3)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerEntrytype = (Spinner) convertView.findViewById(R.id.station_surficial_spinner_entryType);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp2.setElements(pldb.getCol1("lutSURStationEntrytype"));
			sp2.setNewElement(pldb, "lutSURStationEntrytype", 1, null, null);
			sp2.addSpace();
			spinnerEntrytype.setAdapter(sp2);
			spinnerEntrytype.setSelection(sp2.getPosition(stationSurficialEntity.getEntryType()));
			spinnerEntrytype.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					stationSurficialEntity.setEntryType(parent.getItemAtPosition(position).toString());
				}
			});

			/////////////////////////////////////
			// SPINNER LEGEND VAL
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 2 - ELEMENT (3/3)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerLegendValue = (Spinner) convertView.findViewById(R.id.station_surficial_spinner_legendvalue);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp3.setElements(pldb.getCol1("lutSURStationLegendval"));
			sp3.setNewElement(pldb, "lutSURStationLegendval", 1, null, null);
			sp3.addSpace();
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

			/////////////////////////////////////
			// SPINNER SITE QUALITY
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (1/7)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerSiteQual = (Spinner) convertView.findViewById(R.id.station_surficial_spinner_sitequal);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutSURStationSitequality"));
			sp1.setNewElement(pldb, "lutSURStationSitequality", 1, null, null);
			sp1.addSpace();
			spinnerSiteQual.setAdapter(sp1);
			spinnerSiteQual.setSelection(sp1.getPosition(stationSurficialEntity.getOcQuality()));
			spinnerSiteQual.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					stationSurficialEntity.setOcQuality(parent.getItemAtPosition(position).toString());
				}
			});

			/////////////////////////////////////
			// SPINNER PHYS. ENVIRON
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 3 - ELEMENT (2/7)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerPhysEnviron = (Spinner) convertView.findViewById(R.id.station_surficial_spinner_physenviron);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp2.setElements(pldb.getCol1("lutSURStationPhysenv"));
			sp2.setNewElement(pldb, "lutSURStationPhysenv", 1, null, null);
			sp2.addSpace();
			spinnerPhysEnviron.setAdapter(sp2);
			spinnerPhysEnviron.setSelection(sp2.getPosition(stationSurficialEntity.getPhysEnv()));
			spinnerPhysEnviron.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					stationSurficialEntity.setPhysEnv(parent.getItemAtPosition(position).toString());
				}
			});


			/////////////////////////////////////
			// EDITTEXT INTERPRETATION - SITE SIZE?
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 3 - ELEMENT (3/7)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextInterpretation = (EditText) convertView.findViewById(R.id.station_surficial_editText_interpretation);
			editTextInterpretation.setText(stationSurficialEntity.getOcSize());
			editTextInterpretation.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						stationSurficialEntity.setOcSize("");
					else
						stationSurficialEntity.setOcSize(s.toString());
				}
			});

			/////////////////////////////////////
			// EDITTEXT AIR PHOTO
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 3 - ELEMENT (4/7)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextAirPhoto = (EditText) convertView.findViewById(R.id.station_surficial_text_airphoto);
			editTextAirPhoto.setText(stationSurficialEntity.getAirPhoto());
			editTextAirPhoto.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						stationSurficialEntity.setAirPhoto("");
					else
						stationSurficialEntity.setAirPhoto(s.toString());
				}
			});

			/////////////////////////////////////
			// BUTTON AIR PHOTO
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 3 - ELEMENT (5/7)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			Button buttonAirPhoto = (Button) convertView.findViewById(R.id.station_surficial_button_airphoto);


			/////////////////////////////////////
			// EDITTEXT MAP SHEET
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 3 - ELEMENT (6/7)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextMapSheet = (EditText) convertView.findViewById(R.id.station_surficial_text_mapsheet);
			editTextMapSheet.setText(stationSurficialEntity.getMapSheet());
			editTextMapSheet.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						stationSurficialEntity.setMapSheet("");
					else
						stationSurficialEntity.setMapSheet(s.toString());
				}
			});

			/////////////////////////////////////
			// BUTTON MAP SHEET
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 3 - ELEMENT (7/7)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			Button buttonMapSheet = (Button) convertView.findViewById(R.id.station_surficial_button_mapsheet);


		} else if (tab == 4) {
			convertView = mInflater.inflate(R.layout.station_surficial_4, null);

			/////////////////////////////////////
			// EDITTEXT STATION NOTE
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 4 - ELEMENT (1/2)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextStationNote = (EditText) convertView.findViewById(R.id.station_surficial_text_stationnote);
			editTextStationNote.setText(stationSurficialEntity.getNotes());
			editTextStationNote.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						stationSurficialEntity.setNotes("");
					else
						stationSurficialEntity.setNotes(s.toString());
				}
			});

			/////////////////////////////////////
			// EDITTEXT PARTNER
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 4 - ELEMENT (2/2)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextPartner = (EditText) convertView.findViewById(R.id.station_surficial_editText_partner);
			editTextPartner.setText(stationSurficialEntity.getPartner());
			editTextPartner.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						stationSurficialEntity.setPartner("");
					else
						stationSurficialEntity.setPartner(s.toString());
				}
			});



		} else if (tab == 5) {
			convertView = mInflater.inflate(R.layout.station_surficial_5, null);

			/////////////////////////////////////
			// EDIT TEXT SINCE LAST STATION
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 5 - ELEMENT ()
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextLastStationNote = (EditText) convertView.findViewById(R.id.station_surficial_text_sincelaststationnote);
			editTextLastStationNote.setText(stationSurficialEntity.getSlsNotes());
			editTextLastStationNote.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						stationSurficialEntity.setSlsNotes("");
					else
						stationSurficialEntity.setSlsNotes(s.toString());
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
				stationSurficialEntity.setVisitDate(date);
			}
		}, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));

		dateDialog.setMessage("Please select a date");
		dateDialog.show();
	}
	
	public void setDate() {
		Time time = new Time();
		time.setToNow();
		String date = DateFormat.format("MMMM dd, yyyy", time.toMillis(true)).toString();
		stationSurficialEntity.setVisitDate(date);
		stationSurficialEntity.setVisitTime(DateFormat.format("hh:mm:ss", time.toMillis(true)).toString());
	}
	
	private void doGPS() {
        if(gpsController == null) {
            gpsController = new GPSController(context);
            gpsController.turnOnGPS();
            gpsController.requestGPSData();
            stationSurficialEntity.setLatitude(String.valueOf(gpsController.getLatitude()));
            stationSurficialEntity.setLongitude(String.valueOf(gpsController.getLongitude()));
            stationSurficialEntity.setElevation(String.valueOf(gpsController.getElevation()));
        } else {
            gpsController.turnOffGPS();
            gpsController = null;
        }
	}

	public void clear() {
		stationSurficialEntity.clearEntity();
		tab = 1;
		notifyDataSetChanged();
	}
}
