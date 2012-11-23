package com.nrcan.controllers;

import java.util.ArrayList;

import com.nrcan.entities.SampleBedrockEntity;
import com.nrcan.main.PicklistDatabaseHandler;
import com.nrcan.main.R;
import com.nrcan.models.SampleBedrockModel;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
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

public class SampleBedrockController extends BaseAdapter implements Filterable {
	private LayoutInflater mInflater;
	private Activity activity;
	private Context context;
	private int tab;
	private PicklistDatabaseHandler pldb;
	
	private SampleBedrockEntity sampleBedrockEntity;

	public SampleBedrockController(Context context, Activity activity, SampleBedrockEntity sampleBedrockEntity,PicklistDatabaseHandler pldb ) {
		this.mInflater = LayoutInflater.from(context);
		this.activity = activity;
		this.context = context;
		this.tab = 1;
		this.pldb = pldb;
		this.sampleBedrockEntity = sampleBedrockEntity;
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
			
			convertView = mInflater.inflate(R.layout.sample_bedrock_1, null);

			Spinner spinnerType = (Spinner) convertView
					.findViewById(R.id.sample_bedrock_spinner_type);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerType.setAdapter(sp1);
			sp1.setElements(pldb.getCol1("lutBEDSampleType"));
			spinnerType.setAdapter(sp1);
			spinnerType.setSelection(sp1.getPosition(sampleBedrockEntity.getSampleType()));
			spinnerType.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					sampleBedrockEntity.setSampleType(parent.getItemAtPosition(position).toString());
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Spinner spinnerPurpose = (Spinner) convertView
					.findViewById(R.id.sample_bedrock_spinner_purpose);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerPurpose.setAdapter(sp2);
			sp2.setElements(pldb.getCol1("lutBEDSamplePurpose"));
			spinnerPurpose.setAdapter(sp2);
			spinnerPurpose.setSelection(sp2.getPosition(sampleBedrockEntity.getPurpose()));
			spinnerPurpose.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					String tmp = sampleBedrockEntity.getPurpose();
					String sel = parent.getItemAtPosition(position).toString();
					if(!tmp.contains(sel))
					{
						if(tmp.length() > 1)
							sampleBedrockEntity.setPurpose(tmp + " | " + sel);
						else
							sampleBedrockEntity.setPurpose(sel);
						
						notifyDataSetChanged();
					}
				}
			});
			
			
			Button buttonPurpose = (Button) convertView.findViewById(R.id.sample_bedrock_button_purpose);
			buttonPurpose.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					sampleBedrockEntity.setPurpose("");
					notifyDataSetChanged();
				}
			});
			EditText editTextPurpose = (EditText) convertView
					.findViewById(R.id.sample_bedrock_text_purpose);
			editTextPurpose.setText(sampleBedrockEntity.getPurpose());
			editTextPurpose.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						sampleBedrockEntity.setPurpose("");
					else
						sampleBedrockEntity.setPurpose(s.toString());
				}
			});

			
		} else if (tab == 2) {
			
			convertView = mInflater.inflate(R.layout.sample_bedrock_2, null);

			Spinner spinnerFormat = (Spinner) convertView
					.findViewById(R.id.sample_bedrock_spinner_format);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerFormat.setAdapter(sp1);
			sp1.setElements(pldb.getCol1("lutBEDGeneralStrucFormat"));
			spinnerFormat.setAdapter(sp1);
			spinnerFormat.setSelection(sp1.getPosition(sampleBedrockEntity.getFormat()));
			spinnerFormat.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					sampleBedrockEntity.setFormat(parent.getItemAtPosition(position).toString());
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			EditText editTextAzimuth = (EditText) convertView
					.findViewById(R.id.sample_bedrock_editText_azimuth);
			editTextAzimuth.setText(sampleBedrockEntity.getAzimuth());
			editTextAzimuth.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						sampleBedrockEntity.setAzimuth("");
					else
						sampleBedrockEntity.setAzimuth(s.toString());
				}
			});
			EditText editTextDipPlunge = (EditText) convertView
					.findViewById(R.id.sample_bedrock_editText_dipPlunge);
			editTextDipPlunge.setText(sampleBedrockEntity.getDipplunge());
			editTextDipPlunge.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						sampleBedrockEntity.setDipplunge("");
					else
						sampleBedrockEntity.setDipplunge(s.toString());
				}
			});
			Spinner spinnerSurface = (Spinner) convertView
					.findViewById(R.id.sample_bedrock_spinner_surface);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerSurface.setAdapter(sp2);
			sp2.setElements(pldb.getCol1("lutBEDSampleSurface"));
			spinnerSurface.setAdapter(sp2);
			spinnerSurface.setSelection(sp2.getPosition(sampleBedrockEntity.getSurface()));
			spinnerSurface.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					sampleBedrockEntity.setSurface(parent.getItemAtPosition(position).toString());
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			

			
		} else if (tab == 3) {
			
			convertView = mInflater.inflate(R.layout.sample_bedrock_3, null);

			EditText editTextNote = (EditText) convertView
					.findViewById(R.id.sample_bedrock_text_note);
			editTextNote.setText(sampleBedrockEntity.getNotes());
			editTextNote.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						sampleBedrockEntity.setNotes("");
					else
						sampleBedrockEntity.setNotes(s.toString());
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
			if(sampleBedrockEntity.getPurpose().equalsIgnoreCase("")){
				return false;
			}
			
		}
		this.tab = tabNum;
		notifyDataSetChanged();
		return true;
		
	}

	

}
