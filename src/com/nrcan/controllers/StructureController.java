package com.nrcan.controllers;

import java.util.ArrayList;

import com.nrcan.main.PicklistDatabaseHandler;
import com.nrcan.main.R;
import com.nrcan.models.StructureModel;

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

public class StructureController extends BaseAdapter implements Filterable {
	private LayoutInflater mInflater;
	private Activity activity;
	private Context context;
	private int tab;
	private StructureModel structureModel;
	private PicklistDatabaseHandler pldb;
	private ArrayList<String> e = new ArrayList<String>();
	

	public StructureController(Context context, Activity activity,StructureModel structureModel,PicklistDatabaseHandler pldb) {
		this.mInflater = LayoutInflater.from(context);
		this.activity = activity;
		this.context = context;
		this.tab = 1;
		this.structureModel = structureModel;
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

			Spinner spinnerClass = (Spinner) convertView
					.findViewById(R.id.structure_spinner_class);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerClass.setAdapter(sp1);
			sp1.setElements(e);//(pldb.getCol1("lutBEDStrucType"));
			spinnerClass.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			
			Spinner spinnerType = (Spinner) convertView
					.findViewById(R.id.structure_spinner_type);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerType.setAdapter(sp2);
			sp2.setElements(e);//(pldb.getCol2("lutBEDStrucType"));
			spinnerType.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Spinner spinnerDetail = (Spinner) convertView
					.findViewById(R.id.structure_spinner_detail);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerDetail.setAdapter(sp3);
			sp3.setElements(e);//(pldb.getCol3("lutBEDStrucType"));
			spinnerDetail.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			

			
		} else if (tab == 2) {
			
			convertView = mInflater.inflate(R.layout.structure_2, null);

			Spinner spinnerMethod = (Spinner) convertView
					.findViewById(R.id.structure_spinner_method);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerMethod.setAdapter(sp1);
			sp1.setElements(e);//(pldb.getCol1("lutBEDGeneralStrucMethod"));
			spinnerMethod.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Spinner spinnerFormat = (Spinner) convertView
					.findViewById(R.id.structure_spinner_format);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerFormat.setAdapter(sp2);
			sp1.setElements(e);//(pldb.getCol1("lutBEDGeneralStrucFormat"));
			spinnerFormat.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			EditText editTextStrike = (EditText) convertView
					.findViewById(R.id.structure_text_strike);
			EditText editTextDip = (EditText) convertView
					.findViewById(R.id.structure_text_dip);
			
		} else if (tab == 3) {
			
			convertView = mInflater.inflate(R.layout.structure_3, null);

			Spinner spinnerAttitude = (Spinner) convertView
					.findViewById(R.id.structure_spinner_attitude);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerAttitude.setAdapter(sp1);
			sp1.setElements(e);//(pldb.getCol1("lutBEDStrucAttitude"));
			spinnerAttitude.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Spinner spinnerYounging = (Spinner) convertView
					.findViewById(R.id.structure_spinner_younging);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerYounging.setAdapter(sp2);
			sp2.setElements(e);//(pldb.getCol1("lutBEDStrucYounging"));
			spinnerYounging.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Spinner spinnerGeneration = (Spinner) convertView
					.findViewById(R.id.structure_spinner_generation);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerGeneration.setAdapter(sp3);
			sp3.setElements(e);//(pldb.getCol1("lutBEDStrucGeneration"));
			spinnerGeneration.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Spinner spinnerStrain = (Spinner) convertView
					.findViewById(R.id.structure_spinner_strain);
			SpinnerController sp4 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerStrain.setAdapter(sp4);
			sp4.setElements(e);//(pldb.getCol1("lutBEDStrucStrain"));
			spinnerStrain.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Spinner spinnerFlattening = (Spinner) convertView
					.findViewById(R.id.structure_spinner_flattening);
			SpinnerController sp5 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerFlattening.setAdapter(sp5);
			sp5.setElements(e);//(pldb.getCol1("lutBEDStrucFlattening"));
			spinnerFlattening.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			EditText editTextRelated = (EditText) convertView
					.findViewById(R.id.structure_editText_related);

			
		} else if (tab == 4) {
			
			convertView = mInflater.inflate(R.layout.structure_4, null);

			EditText editTextFabric = (EditText) convertView
					.findViewById(R.id.structure_text_fabric);
			EditText editTextSense = (EditText) convertView
					.findViewById(R.id.structure_text_sense);

			
		} else if (tab == 5) {
			
			convertView = mInflater.inflate(R.layout.structure_5, null);

			EditText editTextNote = (EditText) convertView
					.findViewById(R.id.structure_text_sense);

			
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
