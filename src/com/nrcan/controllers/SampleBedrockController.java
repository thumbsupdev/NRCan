package com.nrcan.controllers;

import java.util.ArrayList;

import com.nrcan.main.PicklistDatabaseHandler;
import com.nrcan.main.R;
import com.nrcan.models.SampleBedrockModel;

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

public class SampleBedrockController extends BaseAdapter implements Filterable {
	private LayoutInflater mInflater;
	private Activity activity;
	private Context context;
	private int tab;
	private PicklistDatabaseHandler pldb;
	private ArrayList<String> e = new ArrayList<String>();
	private SampleBedrockModel sampleBedrockModel;

	public SampleBedrockController(Context context, Activity activity, SampleBedrockModel sampleBedrockModel,PicklistDatabaseHandler pldb ) {
		this.mInflater = LayoutInflater.from(context);
		this.activity = activity;
		this.context = context;
		this.tab = 1;
		this.sampleBedrockModel = sampleBedrockModel;
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
			
			convertView = mInflater.inflate(R.layout.sample_bedrock_1, null);

			Spinner spinnerType = (Spinner) convertView
					.findViewById(R.id.sample_bedrock_spinner_type);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerType.setAdapter(sp1);
			sp1.setElements(e);//(pldb.getCol1("lutBEDSampleType"));
			spinnerType.setAdapter(sp1);
			spinnerType.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Spinner spinnerPurpose = (Spinner) convertView
					.findViewById(R.id.sample_bedrock_spinner_purpose);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerPurpose.setAdapter(sp2);
			sp2.setElements(e);//(pldb.getCol1("lutBEDSamplePurpose"));
			spinnerPurpose.setAdapter(sp2);
			spinnerPurpose.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Button buttonPurpose = (Button) convertView
					.findViewById(R.id.sample_bedrock_button_purpose);
			EditText editTextPurpose = (EditText) convertView
					.findViewById(R.id.sample_bedrock_text_purpose);

			
		} else if (tab == 2) {
			
			convertView = mInflater.inflate(R.layout.sample_bedrock_2, null);

			Spinner spinnerFormat = (Spinner) convertView
					.findViewById(R.id.sample_bedrock_spinner_format);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerFormat.setAdapter(sp1);
			sp1.setElements(e);//(pldb.getCol1("lutBEDGeneralStrucFormat"));
			spinnerFormat.setAdapter(sp1);
			spinnerFormat.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			EditText editTextAzimuth = (EditText) convertView
					.findViewById(R.id.sample_bedrock_editText_azimuth);
			EditText editTextDipPlunge = (EditText) convertView
					.findViewById(R.id.sample_bedrock_editText_dipPlunge);
			Spinner spinnerSurface = (Spinner) convertView
					.findViewById(R.id.sample_bedrock_spinner_surface);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerSurface.setAdapter(sp2);
			sp2.setElements(e);//(pldb.getCol1("lutBEDSampleSurface"));
			spinnerSurface.setAdapter(sp2);
			spinnerSurface.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			

			
		} else if (tab == 3) {
			
			convertView = mInflater.inflate(R.layout.sample_bedrock_3, null);

			EditText editTextNote = (EditText) convertView
					.findViewById(R.id.sample_bedrock_text_note);

			
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
