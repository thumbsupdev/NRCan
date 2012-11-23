package com.nrcan.controllers;

import com.nrcan.entities.StructureEntity;
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

public class StructureController extends BaseAdapter implements Filterable {
	private LayoutInflater mInflater;
	private Activity activity;
	private Context context;
	private int tab;
	private StructureEntity structureEntity;
	private PicklistDatabaseHandler pldb;

	public StructureController(Context context, Activity activity,StructureEntity structureEntity,PicklistDatabaseHandler pldb) {
		this.mInflater = LayoutInflater.from(context);
		this.activity = activity;
		this.context = context;
		this.tab = 1;
		this.structureEntity = structureEntity;
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
			convertView = mInflater.inflate(R.layout.structure_1, null);
			
			Spinner spinnerClass = (Spinner) convertView.findViewById(R.id.structure_spinner_class);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutBEDStrucType"));
			spinnerClass.setAdapter(sp1);
			spinnerClass.setSelection(sp1.getPosition(structureEntity.getStrucClass()));
			spinnerClass.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					String tmp = parent.getItemAtPosition(position).toString();
					if(!tmp.equalsIgnoreCase(structureEntity.getStrucClass()))
					{
						structureEntity.setStrucClass(tmp);
						structureEntity.setStrucType("");
						structureEntity.setDetail("");
						notifyDataSetChanged();
					}
					
				}
			});
			
			Spinner spinnerType = (Spinner) convertView.findViewById(R.id.structure_spinner_type);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp2.setElements(pldb.getCol2("lutBEDStrucType", structureEntity.getStrucClass()));
			spinnerType.setAdapter(sp2);
			spinnerType.setSelection(sp2.getPosition(structureEntity.getStrucType()));
			spinnerType.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					String tmp = parent.getItemAtPosition(position).toString();
					if(!tmp.equalsIgnoreCase(structureEntity.getStrucType()))
					{
						structureEntity.setStrucType(tmp);
						structureEntity.setDetail("");					
						notifyDataSetChanged();
					}
				}
			});
			
			Spinner spinnerDetail = (Spinner) convertView.findViewById(R.id.structure_spinner_detail);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp3.setElements(pldb.getCol3("lutBEDStrucType", structureEntity.getStrucClass(), structureEntity.getStrucType()));
			spinnerDetail.setAdapter(sp3);
			spinnerDetail.setSelection(sp3.getPosition(structureEntity.getDetail()));
			spinnerDetail.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					String tmp = parent.getItemAtPosition(position).toString();
					if(!tmp.equalsIgnoreCase(structureEntity.getDetail()))
					{
						structureEntity.setDetail(parent.getItemAtPosition(position).toString());
					}
				}
			});
			
		} else if (tab == 2) {
			convertView = mInflater.inflate(R.layout.structure_2, null);
			
			Spinner spinnerMethod = (Spinner) convertView.findViewById(R.id.structure_spinner_method);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutBEDGeneralStrucMethod"));
			spinnerMethod.setAdapter(sp1);
			spinnerMethod.setSelection(sp1.getPosition(structureEntity.getMethod()));
			spinnerMethod.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					structureEntity.setMethod(parent.getItemAtPosition(position).toString());
				}
			});
			
			Spinner spinnerFormat = (Spinner) convertView.findViewById(R.id.structure_spinner_format);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp2.setElements(pldb.getCol1("lutBEDGeneralStrucFormat"));
			spinnerFormat.setAdapter(sp2);
			spinnerFormat.setSelection(sp1.getPosition(structureEntity.getFormat()));
			spinnerFormat.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					structureEntity.setFormat(parent.getItemAtPosition(position).toString());
				}
			});
			
			EditText editTextStrike = (EditText) convertView.findViewById(R.id.structure_text_strike);
			editTextStrike.setText(structureEntity.getAzimuth());
			editTextStrike.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						structureEntity.setAzimuth("");
					else
						structureEntity.setAzimuth(s.toString());
				}
			});
			
			EditText editTextDip = (EditText) convertView.findViewById(R.id.structure_text_dip);
			editTextDip.setText(structureEntity.getDipplunge());
			editTextDip.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						structureEntity.setDipplunge("");
					else
						structureEntity.setDipplunge(s.toString());
				}
			});
			
		} else if (tab == 3) {
			convertView = mInflater.inflate(R.layout.structure_3, null);
			
			Spinner spinnerAttitude = (Spinner) convertView.findViewById(R.id.structure_spinner_attitude);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutBEDStrucAttitude"));
			spinnerAttitude.setAdapter(sp1);
			spinnerAttitude.setSelection(sp1.getPosition(structureEntity.getAttitude()));
			spinnerAttitude.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					structureEntity.setAttitude(parent.getItemAtPosition(position).toString());
				}
			});
			
			Spinner spinnerYounging = (Spinner) convertView.findViewById(R.id.structure_spinner_younging);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp2.setElements(pldb.getCol1("lutBEDStrucYounging"));
			spinnerYounging.setAdapter(sp2);
			spinnerYounging.setSelection(sp2.getPosition(structureEntity.getYounging()));
			spinnerYounging.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					structureEntity.setYounging(parent.getItemAtPosition(position).toString());
				}
			});
			
			Spinner spinnerGeneration = (Spinner) convertView.findViewById(R.id.structure_spinner_generation);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp3.setElements(pldb.getCol1("lutBEDStrucGeneration"));
			spinnerGeneration.setAdapter(sp3);
			spinnerGeneration.setSelection(sp3.getPosition(structureEntity.getGeneration()));
			spinnerGeneration.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					structureEntity.setGeneration(parent.getItemAtPosition(position).toString());
				}
			});
			
			Spinner spinnerStrain = (Spinner) convertView.findViewById(R.id.structure_spinner_strain);
			SpinnerController sp4 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp4.setElements(pldb.getCol1("lutBEDMetadataPrjctType"));
			spinnerStrain.setAdapter(sp4);
			spinnerStrain.setSelection(sp4.getPosition(structureEntity.getStrain()));
			spinnerStrain.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					structureEntity.setStrain(parent.getItemAtPosition(position).toString());
				}
			});
			
			Spinner spinnerFlattening = (Spinner) convertView.findViewById(R.id.structure_spinner_flattening);
			SpinnerController sp5 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp5.setElements(pldb.getCol1("lutBEDStrucFlattening"));
			spinnerFlattening.setAdapter(sp5);
			spinnerFlattening.setSelection(sp5.getPosition(structureEntity.getFlattening()));
			spinnerFlattening.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					structureEntity.setFlattening(parent.getItemAtPosition(position).toString());
				}
			});
			
			EditText editTextRelated = (EditText) convertView.findViewById(R.id.structure_editText_related);
			editTextRelated.setText(structureEntity.getFlattening());
			editTextRelated.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						structureEntity.setFlattening("");
					else
						structureEntity.setFlattening(s.toString());
				}
			});
			
		} else if (tab == 4) {
			convertView = mInflater.inflate(R.layout.structure_4, null);

			EditText editTextFabric = (EditText) convertView.findViewById(R.id.structure_text_fabric);
			editTextFabric.setText(structureEntity.getFabric());
			editTextFabric.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						structureEntity.setFabric("");
					else
						structureEntity.setFabric(s.toString());
				}
			});
			
			EditText editTextSense = (EditText) convertView.findViewById(R.id.structure_text_sense);
			editTextSense.setText(structureEntity.getSense());
			editTextSense.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						structureEntity.setSense("");
					else
						structureEntity.setSense(s.toString());
				}
			});
			
		} else if (tab == 5) {
			convertView = mInflater.inflate(R.layout.structure_5, null);

			EditText editTextNote = (EditText) convertView.findViewById(R.id.structure_text_note);
			editTextNote.setText(structureEntity.getNotes());
			editTextNote.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						structureEntity.setNotes("");
					else
						structureEntity.setNotes(s.toString());
				}
			});
		}

		return convertView;
	}

	public Filter getFilter() {
		return null;
	}

	public boolean setTab(int tabNum) {
		if(this.tab == 1){
			if(structureEntity.getStrucClass().equalsIgnoreCase("")){
				return false;
			}
			if(structureEntity.getStrucType().equalsIgnoreCase("")){
				return false;
			}
			if(structureEntity.getDetail().equalsIgnoreCase("")){
				return false;
			}
			
		}
		this.tab = tabNum;
		notifyDataSetChanged();
		return true;
	}
	
	

	

}
