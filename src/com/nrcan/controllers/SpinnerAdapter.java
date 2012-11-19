package com.nrcan.controllers;

import java.util.ArrayList;

import com.nrcan.main.*;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

public class SpinnerAdapter extends ArrayAdapter<String> implements Filterable {
	private LayoutInflater mInflater;
	//private PicklistDatabaseHandler pldb;
	//private String picklist = null;
	private String[] test;
	private ArrayList<String> elements = new ArrayList<String>();

	public SpinnerAdapter(Context context, int resource, String[] test) {
		super(context, resource);
		this.mInflater = LayoutInflater.from(context);
		this.test = test;
		//this.pldb = ((MainActivity)activity).getPLDB();
		//this.picklist = name;
	}

	public int getCount() {
		return 2;
	}

	public String getItem(int position) {
		return test[position];
	}

	public long getItemId(int arg0) {
		return 0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		//int tmpSize = 2;
		/*
		if(position == tmpSize)
		{
			convertView = mInflater.inflate(R.layout.cell_spinner_new, null);
		}
		else
		{*/
			convertView = mInflater.inflate(R.layout.cell_spinner_list, null);
			
			TextView textView = (TextView) convertView.findViewById(R.id.list_title);
			textView.setText(test[position]);
		//}

			System.out.println("inside getview " + position);
		return convertView;
	}

	public Filter getFilter() {
		return null;
	}
	/*
	public void setElementsCol1() {
		elements.add("a");
		elements.add("b");
		elements.add("c");
		elements.add("d");
		elements.add("e");
		
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
	
	public String getValue() {
		return "";
	}
	*/
	
}
