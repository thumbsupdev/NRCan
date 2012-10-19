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
import android.widget.Filter;
import android.widget.Filterable;

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
		return 2;
	}

	public Object getItem(int arg0) {
		return null;
	}

	public long getItemId(int arg0) {
		return 0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		
		if(position == 0)
		{
			TabHolder holder;
			holder = new TabHolder();
			convertView = mInflater.inflate(R.layout.tab_host_5, null);
			
			holder.button1 = (Button) convertView.findViewById(R.id.tab_host_button1);
			holder.button1.setOnClickListener(new View.OnClickListener() {

				public void onClick(View v) {
					tab = 1;
					notifyDataSetChanged();
				}
			});
			
			holder.button2 = (Button) convertView.findViewById(R.id.tab_host_button2);
			holder.button2.setOnClickListener(new View.OnClickListener() {

				public void onClick(View v) {
					tab = 2;
					notifyDataSetChanged();
				}
			});
			holder.button3 = (Button) convertView.findViewById(R.id.tab_host_button3);
			holder.button3.setOnClickListener(new View.OnClickListener() {

				public void onClick(View v) {
					tab = 3;
					notifyDataSetChanged();
				}
			});
			
			holder.button4 = (Button) convertView.findViewById(R.id.tab_host_button4);
			holder.button4.setOnClickListener(new View.OnClickListener() {

				public void onClick(View v) {
					tab = 4;
					notifyDataSetChanged();
				}
			});
			
			holder.button5 = (Button) convertView.findViewById(R.id.tab_host_button5);
			holder.button5.setOnClickListener(new View.OnClickListener() {

				public void onClick(View v) {
					tab = 5;
					notifyDataSetChanged();
				}
			});
			
			convertView.setTag(holder);
		}
		else if (position == 1)
		{
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
		}
		
		return convertView;
	}

	public Filter getFilter() {
		return null;
	}

	static class TabHolder {
		Button button1;
		Button button2;
		Button button3;
		Button button4;
		Button button5;
	}
	
}
