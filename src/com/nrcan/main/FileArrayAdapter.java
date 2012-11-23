package com.nrcan.main;

import java.io.File;
import java.util.List;
import java.util.Map;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;

import com.nrcan.picklists.BedrockPicklist;
import com.nrcan.picklists.SurficialPicklist;

public class FileArrayAdapter extends ArrayAdapter<Option>{

	private AlertDialog dialog;
	private AlertDialog.Builder builder;
	private Context context;
	private int id;
	private List<Option>items;
	ProgressThread progThread;
	ProgressDialog progDialog;                            
	int maxBarValue = 0;

	public FileArrayAdapter(Context context, int textViewResourceId, List<Option> objects) {
		super(context, textViewResourceId, objects);
		this.context = context;
		this.id = textViewResourceId;
		this.items = objects;
	}

	final Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			// Get the current value of the variable total from the message data
			// and update the progress bar.
			int total = msg.getData().getInt("total");
			progDialog.setProgress(total);
			if (total >= maxBarValue){
				progDialog.dismiss();
				progThread.setState(ProgressThread.DONE);
			}
		}
	};

	public Option getItem(int i)
	{
		return items.get(i);
	}
	@Override

	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		if (v == null)
		{
			LayoutInflater vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(id, null);
		}

		final Option o = items.get(position);

		if (o != null)
		{
			TextView t1 = (TextView) v.findViewById(R.id.folderName);
			TextView t2 = (TextView) v.findViewById(R.id.folderPath);
			CheckBox c1 = (CheckBox) v.findViewById(R.id.checkBedrock);
			CheckBox c2 = (CheckBox) v.findViewById(R.id.checkSurficial);

			c1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					o.setBChecked(isChecked);
				}
			});

			c2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					o.setSChecked(isChecked);
				}
			});

			if(t1!=null)
			{
				t1.setText(o.getName());
			}
			if(t2!=null)
			{
				t2.setText(o.getPath());
			}

			if(o.isBedrock())
				c1.setChecked(true);
			else
				c1.setEnabled(false);

			if(o.isSurficial())
				c2.setChecked(true);
			else
				c2.setEnabled(false);

			ImageButton loadPicklistButton = (ImageButton)v.findViewById(R.id.loadPicklistButton);
			loadPicklistButton.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					setupDialog(o);
					dialog = builder.create();
					dialog.show();
				}
			});
		}
		return v;
	}

	public void setupDialog(final Option o) {
		builder = new AlertDialog.Builder(context);

		if(o.isBChecked() && o.isSChecked()) {
			builder.setMessage("Are you sure you want to load both Picklists (This may take a minute)")
			.setTitle("Bedrock and Surficial Picklists");
		} else if(o.isBChecked()) {
			builder.setMessage("Are you sure you want to load this Picklist (This may take a minute)")
			.setTitle("Bedrock Picklists");
		} else if(o.isSChecked()) {
			builder.setMessage("Are you sure you want to load this Picklist (This may take a minute)")
			.setTitle("Surficial Picklists");
		} else {
			builder.setMessage("Please select a picklist to load")
			.setTitle("No Picklist Selected");
		}

		if(o.isBChecked() || o.isSChecked()) {
			builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					maxBarValue = 0;
					if(o.isBChecked())
						maxBarValue+=MainActivity.getBedrock().size();
					if(o.isSChecked())
						maxBarValue+=MainActivity.getSurficial().size();

					progDialog = new ProgressDialog(context){
						@Override
						public boolean onSearchRequested() {
							return false;
						}
					};
					progDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
					progDialog.setMax(maxBarValue);
					progDialog.setMessage("Loading Picklists:");
					progDialog.setCancelable(false);
					progThread = new ProgressThread(handler, o);
					progThread.start();

					progDialog.show();
				}
			});
		}

		builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				dialog.dismiss();
			}
		});
	}

	private class ProgressThread extends Thread {
		final static int DONE = 0;
		final static int RUNNING = 1;

		Handler mHandler;
		int mState;
		int total;
		Option option;

		ProgressThread(Handler h, Option o) {
			mHandler = h;
			option = o;
		}

		@Override
		public void run() {
			mState = RUNNING;   
			total = 0;
			if(option.isBChecked()) {
				BedrockPicklist bedrockPicklist = new BedrockPicklist(context, MainActivity.getBedrock(), option.getPath());
				bedrockPicklist.dropTables();
				bedrockPicklist.createTables();

				for(Map.Entry<String, Integer> entry : bedrockPicklist.getBedrockFilenames().entrySet())
				{
					bedrockPicklist.fillTable(entry);

					Message msg = mHandler.obtainMessage();
					Bundle b = new Bundle();
					b.putInt("total", total + 1);
					msg.setData(b);
					mHandler.sendMessage(msg);

					total++;
				}
			}

			if(option.isSChecked()) {
				SurficialPicklist surficialPicklist = new SurficialPicklist(context, MainActivity.getSurficial(), option.getPath());
				surficialPicklist.dropTables();
				surficialPicklist.createTables();

				for(Map.Entry<String, Integer> entry : surficialPicklist.getSurficialFilenames().entrySet())
				{
					surficialPicklist.fillTable(entry);

					Message msg = mHandler.obtainMessage();
					Bundle b = new Bundle();
					b.putInt("total", total + 1);
					msg.setData(b);
					mHandler.sendMessage(msg);

					total++;
				}
			}
		}

		public void setState(int state) {
			mState = state;
		}
	}

}

