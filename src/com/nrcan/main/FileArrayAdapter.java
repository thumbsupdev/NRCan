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
import android.widget.ImageButton;
import android.widget.TextView;
import com.nrcan.picklists.BedrockPicklist;
import com.nrcan.picklists.SurficialPicklist;

public class FileArrayAdapter extends ArrayAdapter<Option>{

	private Context c;
	private int id;
	private List<Option>items;
	ProgressThread progThread;
    ProgressDialog progDialog;                            
    int maxBarValue = 0;

	public FileArrayAdapter(Context context, int textViewResourceId, List<Option> objects) {
		super(context, textViewResourceId, objects);
		this.c = context;
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
					maxBarValue = 0;
					//loadPicklists(o);
					if(o.isBedrock())
						maxBarValue+=MainActivity.getBedrock().size();
					if(o.isSurficial())
						maxBarValue+=MainActivity.getSurficial().size();
						
					progDialog = new ProgressDialog(c){
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
			//bedrockPicklist.fillTables();
		}
		if(option.isSurficial()) {
			SurficialPicklist surficialPicklist = new SurficialPicklist(c, MainActivity.getSurficial(), option.getPath());
			surficialPicklist.dropTables();
			surficialPicklist.createTables();
			//surficialPicklist.fillTables();
		}
	}
	
	 private class ProgressThread extends Thread {	
         
         // Class constants defining state of the thread
         final static int DONE = 0;
         final static int RUNNING = 1;
         
         Handler mHandler;
         int mState;
         int total;
         Option option;
     
         // Constructor with an argument that specifies Handler on main thread
         // to which messages will be sent by this thread.
         
         ProgressThread(Handler h, Option o) {
             mHandler = h;
             option = o;
         }
         
         // Override the run() method that will be invoked automatically when 
         // the Thread starts.  Do the work required to update the progress bar on this
         // thread but send a message to the Handler on the main UI thread to actually
         // change the visual representation of the progress. In this example we count
         // the index total down to zero, so the horizontal progress bar will start full and
         // count down.
         
         @Override
         public void run() {
             mState = RUNNING;   
             total = 0;
             if(option.isBedrock()) {
     			BedrockPicklist bedrockPicklist = new BedrockPicklist(c, MainActivity.getBedrock(), option.getPath());
     			bedrockPicklist.dropTables();
     			bedrockPicklist.createTables();
     			//bedrockPicklist.fillTables();
     		
	             for(Map.Entry<String, Integer> entry : bedrockPicklist.getBedrockFilenames().entrySet())
	             {
	            	 bedrockPicklist.fillTable(entry);
	                 // The method Thread.sleep throws an InterruptedException if Thread.interrupt() 
	                 // were to be issued while thread is sleeping; the exception must be caught.
	            	 /*try {
	                     // Control speed of update (but precision of delay not guaranteed)
	                     Thread.sleep(40);
	                 } catch (InterruptedException e) {
	                     Log.e("ERROR", "Thread was Interrupted");
	                 }*/
	                 // Send message (with current value of  total as data) to Handler on UI thread
	                 // so that it can update the progress bar.
	                 
	                 Message msg = mHandler.obtainMessage();
	                 Bundle b = new Bundle();
	                 b.putInt("total", total+1);
	                 msg.setData(b);
	                 mHandler.sendMessage(msg);
	                 
	                 total++;    // Count down
	             }
             }
             
             if(option.isSurficial()) {
            	 SurficialPicklist surficialPicklist = new SurficialPicklist(c, MainActivity.getSurficial(), option.getPath());
     			surficialPicklist.dropTables();
     			surficialPicklist.createTables();
      			//bedrockPicklist.fillTables();
      		
 	             for(Map.Entry<String, Integer> entry : surficialPicklist.getSurficialFilenames().entrySet())
 	             {
 	            	 surficialPicklist.fillTable(entry);
 	                 // The method Thread.sleep throws an InterruptedException if Thread.interrupt() 
 	                 // were to be issued while thread is sleeping; the exception must be caught.
 	            	 /*try {
 	                     // Control speed of update (but precision of delay not guaranteed)
 	                     Thread.sleep(40);
 	                 } catch (InterruptedException e) {
 	                     Log.e("ERROR", "Thread was Interrupted");
 	                 }*/
 	                 // Send message (with current value of  total as data) to Handler on UI thread
 	                 // so that it can update the progress bar.
 	                 
 	                 Message msg = mHandler.obtainMessage();
 	                 Bundle b = new Bundle();
 	                 b.putInt("total", total+1);
 	                 msg.setData(b);
 	                 mHandler.sendMessage(msg);
 	                 
 	                 total++;    // Count down
 	             }
              }
         }
         
         // Set current state of thread (use state=ProgressThread.DONE to stop thread)
         public void setState(int state) {
             mState = state;
         }
     }

}

