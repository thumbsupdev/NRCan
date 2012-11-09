package com.nrcan.controllers;

import java.util.ArrayList;

import com.nrcan.main.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

public class ListController extends BaseAdapter implements Filterable {
	private LayoutInflater mInflater;
	private Context context;
	private String title;
	private ArrayList<String> elements = new ArrayList<String>();

	public ListController (Context context, String title) {
		this.mInflater = LayoutInflater.from(context);
		this.context = context;
		this.title = title;
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
		
		if(position == tmpSize) {
			CellNewHolder holder;
			holder = new CellNewHolder();
			convertView = mInflater.inflate(R.layout.cell_new, null);

			holder.textView = (TextView) convertView.findViewById(R.id.cell_new_textView2);
			holder.textView.setText(title);

			convertView.setTag(holder);
		}
		else
		{
			CellEditHolder holder;
			holder = new CellEditHolder();
			convertView = mInflater.inflate(R.layout.cell_list, null);
			
			holder.textView = (TextView) convertView.findViewById(R.id.cell_list_textViewTitle);
			holder.textView.setText(elements.get(position));
		}

		return convertView;
	}

	public Filter getFilter() {
		return null;
	}

	public void setElements(ArrayList<String> tmp) {
		elements = tmp;
		notifyDataSetChanged();
	}

	static class CellNewHolder {
		TextView textView;
	}
	
	static class CellEditHolder {
		TextView textView;
	}

}
