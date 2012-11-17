package com.nrcan.controllers;

import java.util.ArrayList;

import com.nrcan.main.R;
import com.nrcan.main.*;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

public class SpinnerController extends BaseAdapter implements Filterable {
	private LayoutInflater mInflater;
	private PicklistDatabaseHandler pldb;
	private String picklist = null;
	private ArrayList<String> elements = new ArrayList<String>();

	public SpinnerController(Context context, Activity activity, String name) {
		this.mInflater = LayoutInflater.from(context);
		this.pldb = ((MainActivity)activity).getPLDB();
		this.picklist = name;
	}

	public int getCount() {
		return elements.size() + 1;
	}

	public Object getItem(int arg0) {
		return null;
	}

	public long getItemId(int arg0) {
		return 0;
	}

	public View getView(final int position, View convertView, ViewGroup parent) {
		int tmpSize = elements.size();
		
		if(position == tmpSize)
		{
			convertView = mInflater.inflate(R.layout.cell_spinner_new, null);
		}
		else
		{
			convertView = mInflater.inflate(R.layout.cell_spinner_list, null);
			
			TextView textView = (TextView) convertView.findViewById(R.id.cell_list_textViewTitle);
			textView.setText(elements.get(position));
		}

		return convertView;
	}

	public Filter getFilter() {
		return null;
	}
	
	public void setElementsCol1() {
		elements = pldb.getCol1(picklist);
		notifyDataSetChanged();
	}
	
	public void setElementsCol2(String col1) {
		elements = pldb.getCol2(picklist, col1);
		notifyDataSetChanged();
	}
	
	public void setElementsCol3(String col1, String col2) {
		elements = pldb.getCol3(picklist, col1, col2);
		notifyDataSetChanged();
	}
	
}
