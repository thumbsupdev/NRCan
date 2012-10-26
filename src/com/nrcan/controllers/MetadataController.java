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
import android.widget.Spinner;

public class MetadataController extends BaseAdapter implements Filterable {
	private LayoutInflater mInflater;
	private Activity activity;
	private Context context;
	private int tab;

	public MetadataController(Context context, Activity activity) {
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
			MetaData1 holder;
			holder = new MetaData1();

			convertView = mInflater.inflate(R.layout.metadata1, null);

			holder.editTextWorkspace = (EditText) convertView
					.findViewById(R.id.metadata_editText_workspace);
			holder.editTextProjectName = (EditText) convertView
					.findViewById(R.id.metadata_editText_projectName);
			holder.editTextProjectCode = (EditText) convertView
					.findViewById(R.id.metadata_editText_projectCode);
			holder.editTextProjectLeader = (EditText) convertView
					.findViewById(R.id.metadata_editText_projectLeader);
			holder.spinnerProjectType = (Spinner) convertView
					.findViewById(R.id.metadata_spinner_projectType);

			convertView.setTag(holder);
		} else if (tab == 2) {
			MetaData2 holder;
			holder = new MetaData2();
			convertView = mInflater.inflate(R.layout.metadata2, null);

			holder.editTextGeologistName = (EditText) convertView
					.findViewById(R.id.metadata_editText_geologistName);
			holder.editTextGeologistCode = (EditText) convertView
					.findViewById(R.id.metadata_editText_geologistCode);
			holder.spinnerCameraPrefix = (Spinner) convertView
					.findViewById(R.id.metadata_spinner_cameraPrefix);
			holder.spinnerMapProjection = (Spinner) convertView
					.findViewById(R.id.metadata_spinner_selectMapProjection);

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

	static class MetaData1 {
		EditText editTextWorkspace;
		EditText editTextProjectName;
		EditText editTextProjectCode;
		EditText editTextProjectLeader;
		Spinner spinnerProjectType;

	}

	static class MetaData2 {
		EditText editTextGeologistName;
		EditText editTextGeologistCode;
		Spinner spinnerCameraPrefix;
		Spinner spinnerMapProjection;

	}
}
