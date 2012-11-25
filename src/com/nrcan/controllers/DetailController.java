package com.nrcan.controllers;

import java.util.ArrayList;

import com.nrcan.main.R;
import com.nrcan.main.MainActivity;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

public class DetailController extends BaseAdapter implements Filterable {
	private LayoutInflater mInflater;
	private Activity activity;
	private ArrayList<String> cells = new ArrayList<String>();
	
	public DetailController(Context context, Activity activity, ArrayList<String> cells) {
		this.mInflater = LayoutInflater.from(context);
		this.activity = activity;
		this.cells = cells;
	}

	public int getCount() {
		return cells.size();
	}

	public Object getItem(int arg0) {
		return null;
	}

	public long getItemId(int arg0) {
		return 0;
	}

	public View getView(final int position, View convertView, ViewGroup parent) {
		CellDetailHolder holder;
		holder = new CellDetailHolder();
		convertView = mInflater.inflate(R.layout.cell_detail, null);
		
		holder.textView = (TextView) convertView.findViewById(R.id.cell_detail_textViewDetails);
		holder.textView.setText(cells.get(position));
		
		convertView.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				((MainActivity)activity).setDetail(position);
				((MainActivity)activity).cellActionControl(-1);
			}
		});
		
		convertView.setTag(holder);
		
		return convertView;
	}

	public Filter getFilter() {
		return null;
	}
	
	static class CellDetailHolder {
		TextView textView;
	}

}
