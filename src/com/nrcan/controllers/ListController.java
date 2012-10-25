package com.nrcan.controllers;

import com.nrcan.main.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

public class ListController extends BaseAdapter implements Filterable {
	private LayoutInflater mInflater;
	private String title;

	public ListController (String title) {
		this.title = title;
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

	public View getView(final int position, View convertView, ViewGroup parent) {
		
		CellNewHolder holder;
		holder = new CellNewHolder();
		convertView = mInflater.inflate(R.layout.cell_new, null);
		
		holder.textView = (TextView) convertView.findViewById(R.id.cell_new_textView2);
		holder.textView.setText(title);
		
		convertView.setTag(holder);
		
		return null;
	}

	public Filter getFilter() {
		return null;
	}
	
	static class CellNewHolder {
		TextView textView;
	}

}
