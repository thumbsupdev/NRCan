package com.nrcan.main;

import java.util.List;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import com.nrcan.picklists.BedrockPicklist;
import com.nrcan.picklists.SurficialPicklist;

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
			
			ImageButton loadPicklistButton = (ImageButton)v.findViewById(R.id.loadPicklistButton);
			
			AlertDialog.Builder builder = new AlertDialog.Builder(c);
			builder.setMessage("Are you sure you want to load this Picklist (This may take a minute)")
			       .setTitle("Picklists");

			builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			           public void onClick(DialogInterface dialog, int id) {
			        	   loadPicklists(o);
			           }
			       });
			builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			           public void onClick(DialogInterface dialog, int id) {
			               dialog.dismiss();
			           }
			       });

			final AlertDialog dialog = builder.create();
			
			loadPicklistButton.setOnClickListener(new OnClickListener() {
				 
				public void onClick(View arg0) {
					dialog.show();
				}
	 
			});

		}
		return v;
	}

    public void loadPicklists(Option option) {

        if(option.isBedrock()) {
            BedrockPicklist bedrockPicklist = new BedrockPicklist(c, MainActivity.getBedrock(), option.getPath());
            bedrockPicklist.dropTables();
            bedrockPicklist.createTables();
            bedrockPicklist.fillTables();
        }
        if(option.isSurficial()) {
            SurficialPicklist surficialPicklist = new SurficialPicklist(c, MainActivity.getSurficial(), option.getPath());
            surficialPicklist.dropTables();
            surficialPicklist.createTables();
            surficialPicklist.fillTables();
        }
    }

}

