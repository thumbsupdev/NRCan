package com.nrcan.controllers;

import com.nrcan.main.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;

public class StationBedrockController  extends BaseAdapter implements Filterable {
	private LayoutInflater mInflater;
	private Activity activity;
	private Context context;
	private int tab;

	public StationBedrockController(Context context, Activity activity) {
		this.mInflater = LayoutInflater.from(context);
		this.activity = activity;
		this.context = context;
		this.tab = 1;
	}

	public int getCount() {
		return 4;
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
			convertView = mInflater.inflate(R.layout.station_bedrock_1, null);
			convertView.setTag(holder);
		}
		else if (tab == 2)
		{
			TabHolder holder;
			holder = new TabHolder();
			convertView = mInflater.inflate(R.layout.station_bedrock_2, null);
			convertView.setTag(holder);
		}
		else if (tab == 3)
		{
			TabHolder holder;
			holder = new TabHolder();
			convertView = mInflater.inflate(R.layout.station_bedrock_3, null);
			convertView.setTag(holder);
		}
		else if (tab == 4)
		{
			TabHolder holder;
			holder = new TabHolder();
			convertView = mInflater.inflate(R.layout.station_bedrock_4, null);
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

	static class TabHolder {
		Button button1;
		Button button2;
		Button button3;
		Button button4;
	}

}
