package com.nrcan.controllers;

import java.util.ArrayList;

import com.nrcan.main.*;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

public class SpinnerController extends ArrayAdapter<String> implements Filterable {
	private LayoutInflater mInflater;
	private ArrayList<String> elements = new ArrayList<String>();

	public SpinnerController(Context context, int resource) {
		super(context, resource);
		this.mInflater = LayoutInflater.from(context);
	}

	public int getCount() {
		return elements.size() + 1;
	}

	public String getItem(int position) {
		return elements.get(position);
	}

	public long getItemId(int arg0) {
		return 0;
	}

	public View getDropDownView(int position, View convertView, ViewGroup parent) {
		if(position == elements.size())
		{
			convertView = mInflater.inflate(R.layout.cell_spinner_new, null);
			
			EditText editText = (EditText) convertView.findViewById(R.id.cell_spinner_new_edit_text);
			editText.setHint("New Element");
		}
		else
		{
			convertView = mInflater.inflate(R.layout.cell_spinner_list, null);
			
			TextView textView = (TextView) convertView.findViewById(R.id.list_title);
			textView.setText(elements.get(position));
		}
		
		return convertView;
	}

	public Filter getFilter() {
		return null;
	}
	
	public void setElements(ArrayList<String> elements) {
		this.elements = elements;
		notifyDataSetChanged();
	}
}
