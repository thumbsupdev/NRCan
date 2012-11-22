package com.nrcan.controllers;

import java.util.ArrayList;

import com.nrcan.entities.MetadataEntity;
import com.nrcan.main.PicklistDatabaseHandler;
import com.nrcan.main.R;

import android.app.Activity;
import android.content.Context;
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

import com.nrcan.models.MetadataModel;
import com.nrcan.main.DatabaseHandler;

public class MetadataController extends BaseAdapter implements Filterable {

	private LayoutInflater mInflater;
	private Activity activity;
	private Context context;
    private int tab;
	private MetadataModel metadataModel;
	private MetadataEntity metadataEntity;
	private PicklistDatabaseHandler pldb;
	private ArrayList<String> e = new ArrayList<String>();

    public MetadataController() { }

	public MetadataController(Context context, Activity activity, MetadataModel metadataModel,PicklistDatabaseHandler pldb) {
		this.mInflater = LayoutInflater.from(context);
		this.activity = activity;
		this.context = context;
		this.tab = 1;
        this.metadataModel = metadataModel;
        this.pldb = pldb;
        this.metadataEntity = metadataModel.getEntity();
	}

    public MetadataModel getMetadataModel() {
        return metadataModel;
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
			convertView = mInflater.inflate(R.layout.metadata1, null);

			EditText editTextProjectName = (EditText) convertView.findViewById(R.id.metadata_editText_projectName);
			editTextProjectName.setText(metadataEntity.getPrjct_name());
			
			EditText editTextProjectCode = (EditText) convertView.findViewById(R.id.metadata_editText_projectCode);
			editTextProjectCode.setText(metadataEntity.getPrjct_code());
			
			EditText editTextProjectLeader = (EditText) convertView.findViewById(R.id.metadata_editText_projectLeader);
			editTextProjectLeader.setText(metadataEntity.getPrjct_lead());
			
			
			
			final Spinner spinnerProjectType = (Spinner) convertView.findViewById(R.id.metadata_spinner_projectType);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			
			sp1.setElements(pldb.getCol1("lutBEDMetadataPrjctType"));
			
			spinnerProjectType.setAdapter(sp1);
			
			System.out.println("n: " + sp1.getPosition(metadataEntity.getPrjct_type().toString()));

			spinnerProjectType.setSelection(sp1.getPosition(metadataEntity.getPrjct_type()));
			
			spinnerProjectType.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					metadataEntity.setPrjct_type(spinnerProjectType.getSelectedItem().toString());
					//earthmatbedrockModel.getEntity().setLithGroup("");
					//System.out.println(parent.getItemAtPosition(position));
				}
			});

			
		} else if (tab == 2) {
			
			convertView = mInflater.inflate(R.layout.metadata2, null);

			Spinner spinnerGeologistName = (Spinner) convertView.findViewById(R.id.metadata_spinner_geologistName);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerGeologistName.setAdapter(sp1);
			sp1.setElements(pldb.getCol1("lutBEDMetadataGeologist"));
			spinnerGeologistName.setAdapter(sp1);
			spinnerGeologistName.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					//System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Spinner spinnerGeologistCode = (Spinner) convertView.findViewById(R.id.metadata_spinner_geologistCode);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerGeologistCode.setAdapter(sp2);
			sp2.setElements(pldb.getCol2("lutBEDMetadataGeologist", metadataEntity.getGeologist()));
			spinnerGeologistCode.setAdapter(sp2);
			spinnerGeologistCode.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					//System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Spinner spinnerCameraPrefix = (Spinner) convertView.findViewById(R.id.metadata_spinner_cameraPrefix);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerCameraPrefix.setAdapter(sp3);
			sp3.setElements(pldb.getCol1("lutBEDMetadataDigcamera"));
			spinnerCameraPrefix.setAdapter(sp3);
			spinnerCameraPrefix.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					//System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Spinner spinnerMapProjection = (Spinner) convertView.findViewById(R.id.metadata_spinner_selectMapProjection);
			SpinnerController sp4 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerMapProjection.setAdapter(sp4);
			sp4.setElements(pldb.getCol1("lutBEDMetadataPrjname"));
			spinnerMapProjection.setAdapter(sp4);
			spinnerMapProjection.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					//System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			EditText editTextStationStartNo = (EditText) convertView.findViewById(R.id.metadata_editText_stationStartNo);
			

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
	
	public void save() {
		metadataModel.getEntity().setPrjct_name("Field 1");
		metadataModel.getEntity().setPrjct_code("Field 2");
		metadataModel.getEntity().setPrjct_lead("Field 3");
		metadataModel.getEntity().setPrjct_type("Field 4");
		metadataModel.getEntity().setGeolcode("Field 5");
		metadataModel.getEntity().setGeologist("Field 6");
		metadataModel.getEntity().setMappath("Field 7");
		metadataModel.getEntity().setPrj_name("Field 8");
		metadataModel.getEntity().setPrj_type("Field 9");
		metadataModel.getEntity().setPrj_datum("Field 10");
		metadataModel.getEntity().setDigcamera("Field 11");
		metadataModel.getEntity().setStnstartno("Field 12");
		metadataModel.getEntity().setMetaid("Field 13");
		
		//metadataModel.insertRow();
	}
	
	public void tUpdate() {
		notifyDataSetChanged();
	}

 //   public void insertMetadataInfo() {
    	//metadataModel.getEntity();
/*
        String[] contents = {
            (EditText) activity.findViewById(R.id.metadata_editText_workspace).getText().toString(),
            "-1",
            ((EditText) activity.findViewById(R.id.metadata_editText_projectName)).getText().toString(),
            ((EditText) activity.findViewById(R.id.metadata_editText_projectCode)).getText().toString(),
            ((EditText) activity.findViewById(R.id.metadata_editText_projectLeader)).getText().toString(),
            ((Spinner) activity.findViewById(R.id.metadata_spinner_projectType)).getSelectedItem().toString(),
            ((EditText) activity.findViewById(R.id.metadata_editText_geologistName)).getText().toString(),
            ((EditText) activity.findViewById(R.id.metadata_editText_geologistCode)).getText().toString(),
            ((Spinner) activity.findViewById(R.id.metadata_spinner_cameraPrefix)).getSelectedItem().toString(),
            "0",
            ((Spinner) activity.findViewById(R.id.metadata_spinner_selectMapProjection)).getSelectedItem().toString()
        };*/

    	/*
        String[] contents = {
            "0",
            "TestName",
            "C123",
            "TestLead",
            "Type1",
            "TestGeologist",
            "123Code",
            "DigCam",
            "datum",
            "mappath"
        };
        */

        //metadataModel.setEntity(contents);
        //long rowsAffected = metadataModel.insertRow();

        //Log.v("MetadataController insertMetadataInfo()", "Rows affected = " + rowsAffected);

//    }


}
