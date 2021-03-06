package com.nrcan.controllers;

import java.util.ArrayList;

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
	private ArrayList<String> plNames = new ArrayList<String>();

	public StructureController(Context context, Activity activity,StructureEntity structureEntity,PicklistDatabaseHandler pldb) {
		this.mInflater = LayoutInflater.from(context);
		this.activity = activity;
		this.context = context;
		this.tab = 1;
		this.structureEntity = structureEntity;
		this.pldb = pldb;
		setPLBedrock();
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
			
			/////////////////////////////////////
			// SPINNER CLASS
			//
			// Drop-down for "Class" - Column 1 of plNames[0] Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 2 - ELEMENT (1/3)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerClass = (Spinner) convertView.findViewById(R.id.structure_spinner_class);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1(plNames.get(0)));
			sp1.setNewElement(pldb, plNames.get(0), 1, null,null);
			sp1.addSpace();
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
			
			/////////////////////////////////////
			// SPINNER TYPE
			//
			// Drop-down for "Type" - Column 2 of plNames[1] Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (2/3)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerType = (Spinner) convertView.findViewById(R.id.structure_spinner_type);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp2.setElements(pldb.getCol2(plNames.get(1), structureEntity.getStrucClass()));
			sp2.setNewElement(pldb, plNames.get(1), 2, structureEntity.getStrucClass(),null);
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
			
			/////////////////////////////////////
			// SPINNER DETAIL
			//
			// Drop-down for "Detail" - Column 3 of plNames[2] Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (3/3)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerDetail = (Spinner) convertView.findViewById(R.id.structure_spinner_detail);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp3.setElements(pldb.getCol3(plNames.get(2), structureEntity.getStrucClass(), structureEntity.getStrucType()));
			sp3.setNewElement(pldb, plNames.get(2), 3, structureEntity.getStrucClass(), structureEntity.getStrucType());
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
			
			/////////////////////////////////////
			// SPINNER METHOD
			//
			// Drop-down for "Method" - Column 1 of plNames[3] Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 2 - ELEMENT (1/4)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerMethod = (Spinner) convertView.findViewById(R.id.structure_spinner_method);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1(plNames.get(3)));
			sp1.setNewElement(pldb, plNames.get(3), 1, null,null);
			sp1.addSpace();
			spinnerMethod.setAdapter(sp1);
			spinnerMethod.setSelection(sp1.getPosition(structureEntity.getMethod()));
			spinnerMethod.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					structureEntity.setMethod(parent.getItemAtPosition(position).toString());
				}
			});
			
			/////////////////////////////////////
			// SPINNER FORMAT
			//
			// Drop-down for "Format" - Column 1 of plNames[4] Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 2 - ELEMENT (2/4)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerFormat = (Spinner) convertView.findViewById(R.id.structure_spinner_format);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp2.setElements(pldb.getCol1(plNames.get(4)));
			sp2.setNewElement(pldb, plNames.get(4), 1, null,null);
			sp2.addSpace();
			spinnerFormat.setAdapter(sp2);
			spinnerFormat.setSelection(sp1.getPosition(structureEntity.getFormat()));
			spinnerFormat.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					structureEntity.setFormat(parent.getItemAtPosition(position).toString());
				}
			});
			
			/////////////////////////////////////
			// EDITTEXT AZIMUTH
			//
			// Text field for "Azimuth"
			/////////////////////////////////////
			// VERIFIED - TAB 2 - ELEMENT (3/4)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
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
			
			/////////////////////////////////////
			// EDITTEXT DIP
			//
			// Text field for "Dip/Plunge"
			/////////////////////////////////////
			// VERIFIED - TAB 2 - ELEMENT (4/4)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
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
			
			/////////////////////////////////////
			// SPINNER ATTITUDE
			//
			// Drop-down for "Attitude" - Column 1 of plNames[5] Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 3 - ELEMENT (1/6)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerAttitude = (Spinner) convertView.findViewById(R.id.structure_spinner_attitude);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1(plNames.get(5)));
			sp1.setNewElement(pldb, plNames.get(5), 1, null,null);
			sp1.addSpace();
			spinnerAttitude.setAdapter(sp1);
			spinnerAttitude.setSelection(sp1.getPosition(structureEntity.getAttitude()));
			spinnerAttitude.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					structureEntity.setAttitude(parent.getItemAtPosition(position).toString());
				}
			});
			
			/////////////////////////////////////
			// SPINNER YOUNGING
			//
			// Drop-down for "Younging" - Column 1 of plNames[6] Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 3 - ELEMENT (2/6)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerYounging = (Spinner) convertView.findViewById(R.id.structure_spinner_younging);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp2.setElements(pldb.getCol1(plNames.get(6)));
			sp2.setNewElement(pldb, plNames.get(6), 1, null,null);
			sp2.addSpace();
			spinnerYounging.setAdapter(sp2);
			spinnerYounging.setSelection(sp2.getPosition(structureEntity.getYounging()));
			spinnerYounging.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					structureEntity.setYounging(parent.getItemAtPosition(position).toString());
				}
			});
			
			/////////////////////////////////////
			// SPINNER GENERATION
			//
			// Drop-down for "Generation" - Column 1 of plNames[7] Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 3 - ELEMENT (3/6)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerGeneration = (Spinner) convertView.findViewById(R.id.structure_spinner_generation);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp3.setElements(pldb.getCol1(plNames.get(7)));
			sp3.setNewElement(pldb, plNames.get(7), 1, null,null);
			sp3.addSpace();
			spinnerGeneration.setAdapter(sp3);
			spinnerGeneration.setSelection(sp3.getPosition(structureEntity.getGeneration()));
			spinnerGeneration.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					structureEntity.setGeneration(parent.getItemAtPosition(position).toString());
				}
			});
			
			/////////////////////////////////////
			// SPINNER STRAIN
			//
			// Drop-down for "Strain" - Column 1 of plNames[8] Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 3 - ELEMENT (4/6)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerStrain = (Spinner) convertView.findViewById(R.id.structure_spinner_strain);
			SpinnerController sp4 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp4.setElements(pldb.getCol1(plNames.get(8)));
			sp4.setNewElement(pldb, plNames.get(8), 1, null,null);
			sp4.addSpace();
			spinnerStrain.setAdapter(sp4);
			spinnerStrain.setSelection(sp4.getPosition(structureEntity.getStrain()));
			spinnerStrain.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					structureEntity.setStrain(parent.getItemAtPosition(position).toString());
				}
			});
			
			/////////////////////////////////////
			// SPINNER FLATTENING
			//
			// Drop-down for "Flattening" - Column 1 of plNames[9] Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 3 - ELEMENT (5/6)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerFlattening = (Spinner) convertView.findViewById(R.id.structure_spinner_flattening);
			SpinnerController sp5 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp5.setElements(pldb.getCol1(plNames.get(9)));
			sp5.setNewElement(pldb, plNames.get(9), 1, null,null);
			sp5.addSpace();
			spinnerFlattening.setAdapter(sp5);
			spinnerFlattening.setSelection(sp5.getPosition(structureEntity.getFlattening()));
			spinnerFlattening.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					structureEntity.setFlattening(parent.getItemAtPosition(position).toString());
				}
			});
			
			/////////////////////////////////////
			// EDITTEXT RELATED
			//
			// Text field for "Related"
			/////////////////////////////////////
			// VERIFIED - TAB 3 - ELEMENT (6/6)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
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

			/////////////////////////////////////
			// EDITTEXT FABRIC
			//
			// Text field for "Fabric"
			/////////////////////////////////////
			// VERIFIED - TAB 4 - ELEMENT (1/2)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
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
			
			/////////////////////////////////////
			// EDITTEXT SENSE
			//
			// Text field for "Sense"
			/////////////////////////////////////
			// VERIFIED - TAB 4 - ELEMENT (2/2)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
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
			
			/////////////////////////////////////
			// EDITTEXT NOTE
			//
			// Text field for "Note"
			/////////////////////////////////////
			// VERIFIED - TAB 5 - ELEMENT (1/1)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
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
	
	public void setPLBedrock() {
		plNames.clear();
		plNames.add("lutBEDStrucType");
		plNames.add("lutBEDStrucType");
		plNames.add("lutBEDStrucType");
		plNames.add("lutBEDGeneralStrucMethod");
		plNames.add("lutBEDGeneralStrucFormat");
		plNames.add("lutBEDStrucAttitude");
		plNames.add("lutBEDStrucYounging");
		plNames.add("lutBEDStrucGeneration");
		plNames.add("lutBEDStrucStrain");
		plNames.add("lutBEDStrucFlattening");
	}
	
	public void setPLSurficial() {
		plNames.clear();
		plNames.add("lutSURStrucType");
		plNames.add("lutSURStrucType");
		plNames.add("lutSURStrucType");
		plNames.add("lutSURGeneralStrucMethod");
		plNames.add("lutSURGeneralStrucFormat");
		plNames.add("lutSURStrucAttitude");
		plNames.add("lutSURStrucYounging");
		plNames.add("lutSURStrucGeneration");
		plNames.add("lutSURStrucStrain");
		plNames.add("lutSURStrucFlattening");
	}
	
	public void clear() {
		structureEntity.clearEntity();
		tab = 1;
		notifyDataSetChanged();
	
	}
}
