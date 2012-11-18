package com.nrcan.controllers;

import com.nrcan.main.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.SeekBar;
import android.widget.Spinner;

public class PhotoController extends BaseAdapter implements Filterable {
	private LayoutInflater mInflater;
	private Activity activity;
	private Context context;
	private int tab;

	public PhotoController(Context context, Activity activity) {
		this.mInflater = LayoutInflater.from(context);
		this.activity = activity;
		this.context = context;
		this.tab = 1;
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

			Spinner spinnerCategory = (Spinner) convertView
					.findViewById(R.id.photo_spinner_category);
			SpinnerController sp1 = new SpinnerController(context, activity, "lutSURPhotoCategory");
			spinnerCategory.setAdapter(sp1);
			sp1.setElementsCol1();
			
			EditText editTextPhotoName = (EditText) convertView
					.findViewById(R.id.photo_text_filename);
			EditText editTextFileNumber = (EditText) convertView
					.findViewById(R.id.photo_text_filenumber);
			EditText editTextDirection = (EditText) convertView
					.findViewById(R.id.photo_text_direction);
			
			
		} else if (tab == 2) {
			
			convertView = mInflater.inflate(R.layout.photo_2, null);

			EditText editTextCaption = (EditText) convertView
					.findViewById(R.id.photo_text_caption);

		
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
