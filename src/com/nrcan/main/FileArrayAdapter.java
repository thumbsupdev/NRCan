package com.nrcan.main;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class FileArrayAdapter extends ArrayAdapter<Option>{

	private Context c;
	private int id;
	private List<Option>items;

	public FileArrayAdapter(Context context, int textViewResourceId, List<Option> objects) {
		super(context, textViewResourceId, objects);
		this.c = context;
		this.id = textViewResourceId;
		this.items = objects;
	}
	
	public Option getItem(int i)
	{
		return items.get(i);
	}
	@Override
	
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		if (v == null)
		{
			LayoutInflater vi = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(id, null);
		}
		
		final Option o = items.get(position);
		
		if (o != null)
		{
			TextView t1 = (TextView) v.findViewById(R.id.folderName);
			TextView t2 = (TextView) v.findViewById(R.id.folderPath);
			CheckBox c1 = (CheckBox) v.findViewById(R.id.checkBedrock);
			CheckBox c2 = (CheckBox) v.findViewById(R.id.checkSurficial);
			
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

		}
		return v;
	}

}

