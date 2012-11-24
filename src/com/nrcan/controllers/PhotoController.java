package com.nrcan.controllers;

import java.util.ArrayList;

import com.nrcan.entities.PhotoEntity;
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

public class PhotoController extends BaseAdapter implements Filterable {
	private LayoutInflater mInflater;
	private Activity activity;
	private Context context;
	private int tab;
	private PicklistDatabaseHandler pldb;
	private PhotoEntity photoEntity;
	private ArrayList<String> plNames = new ArrayList<String>();

	public PhotoController(Context context, Activity activity, PhotoEntity photoEntity, PicklistDatabaseHandler pldb) {
		this.mInflater = LayoutInflater.from(context);
		this.activity = activity;
		this.context = context;
		this.tab = 1;
		this.pldb = pldb;
		this.photoEntity = photoEntity;
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
			convertView = mInflater.inflate(R.layout.photo_1, null);

			Spinner spinnerCategory = (Spinner) convertView.findViewById(R.id.photo_spinner_category);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerCategory.setAdapter(sp1);
			sp1.setElements(pldb.getCol1(plNames.get(0)));
			spinnerCategory.setAdapter(sp1);
			spinnerCategory.setSelection(sp1.getPosition(photoEntity.getCategory()));
			spinnerCategory.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					photoEntity.setCaption(parent.getItemAtPosition(position).toString());
				}
			});
			
			EditText editTextPhotoName = (EditText) convertView.findViewById(R.id.photo_text_filename);
			EditText editTextFileNumber = (EditText) convertView.findViewById(R.id.photo_text_filenumber);
			EditText editTextDirection = (EditText) convertView.findViewById(R.id.photo_text_direction);
			
		} else if (tab == 2) {
			convertView = mInflater.inflate(R.layout.photo_2, null);

			EditText editTextCaption = (EditText) convertView.findViewById(R.id.photo_text_caption);
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
	
	public void setPLBedrock() {
		plNames.clear();
		plNames.add("lutBEDPhotoCategory");
	}
	
	public void setPLSurficial() {
		plNames.clear();
		plNames.add("lutSURPhotoCategory");
	}
}
