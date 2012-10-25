package com.nrcan.controllers;

import com.nrcan.controllers.MetadataController.TabHolder;
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

public class StructureController  extends BaseAdapter implements Filterable {
	private LayoutInflater mInflater;
	private Activity activity;
	private Context context;
	private int tab;
	
	public StructureController(Context context, Activity activity) {
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
		
			if(tab == 1)
			{
				TabHolder holder;
				holder = new TabHolder();
				convertView = mInflater.inflate(R.layout.structure_1, null);
				convertView.setTag(holder);
			}
			else if (tab == 2)
			{
				TabHolder holder;
				holder = new TabHolder();
				convertView = mInflater.inflate(R.layout.structure_2, null);
				convertView.setTag(holder);
			}
			else if (tab == 3)
			{
				TabHolder holder;
				holder = new TabHolder();
				convertView = mInflater.inflate(R.layout.structure_3, null);
				convertView.setTag(holder);
			}
			else if (tab == 4)
			{
				TabHolder holder;
				holder = new TabHolder();
				convertView = mInflater.inflate(R.layout.structure_4, null);
				convertView.setTag(holder);
			}
			else if (tab == 5)
			{
				TabHolder holder;
				holder = new TabHolder();
				convertView = mInflater.inflate(R.layout.structure_5, null);
				convertView.setTag(holder);
			}
		
		return convertView;
	}

	public Filter getFilter() {
		return null;
	}

	static class Structure1 {
		Spinner spinnerClass;
		Spinner spinnerType;
		Spinner detail;
	}
	
	static class Structure2 {
		Spinner spinnerMethod;
		Spinner spinnerFormat;
		EditText editTextStrike;
		Button buttonStrikeUp;
		Button buttonStrikeDown;
		SeekBar seekbarStrike;
		EditText editTextDip;
		Button buttonDipUp;
		Button buttonDipDown;
		SeekBar seekbarDip;
	}
	
	static class Structure3 {
		Spinner spinnerAttitude;
		Spinner spinnerYounging;
		Spinner spinnerGeneration;
		Spinner spinnerStrain;
		Spinner spinnerFlattening;
		Spinner spinnerRelated;
	}
	
	static class Structure4 {
		
	}
	
	static class Structure5 {
	}
	
}
