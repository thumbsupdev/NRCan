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

public class SoilProSurficialController extends BaseAdapter implements
		Filterable {
	private LayoutInflater mInflater;
	private Activity activity;
	private Context context;
	private int tab;

	public SoilProSurficialController(Context context, Activity activity) {
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
			SoilProSurficial1 holder;
			holder = new SoilProSurficial1();
			convertView = mInflater.inflate(R.layout.soilpro_surficial1, null);

			
			
			
			convertView.setTag(holder);
		} else if (tab == 2) {
			SoilProSurficial2 holder;
			holder = new SoilProSurficial2();
			convertView = mInflater.inflate(R.layout.soilpro_surficial2, null);

			
			
			

			convertView.setTag(holder);
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

	static class SoilProSurficial1 {
		
		
		

	}

	static class SoilProSurficial2 {
		
		
		

	}

	

	
}
