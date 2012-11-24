package com.nrcan.main;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;

public class FileChooser extends ListActivity {

	private File currentDir;
	private FileArrayAdapter adapter;
	private HashMap<String, Integer> bedrockFileNames;
	private HashMap<String, Integer> surficialFileNames;
	private ArrayList<Option>dir = new ArrayList<Option>();
	private boolean doneWork = false;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		dir = MainActivity.dir;
		showFolders();
	}

	public ArrayList<Option> doWork() {
		bedrockFileNames = MainActivity.getBedrock();
		surficialFileNames = MainActivity.getSurficial();
		currentDir = new File(Environment.getExternalStorageDirectory().getName());
		fill(currentDir);
		doneWork = true;
		return dir;
	}

	public boolean isDoneWork(){
		return doneWork;
	}

	private boolean lookForPicklist(File f,HashMap<String, Integer> tempMap) {
		File[] files = null;
		int size = tempMap.size();

		files = f.listFiles();
		if(files.length >= tempMap.size())
		{
			for(File file : files)
			{
				for(String s: tempMap.keySet())
				{
					if(s.equals(file.getName()))
					{
						size--;
						break;
					}
				}

				if(size == 0)
				{
					return true;
				}
			}
		}

		return false;
	}

	private void fill(File f)
	{
		File[]dirs = f.listFiles();

		try {
			for(File ff: dirs)
			{
				if(ff.isDirectory() && !ff.isHidden())
				{
					boolean b = lookForPicklist(ff, bedrockFileNames);
					boolean s = lookForPicklist(ff, surficialFileNames);
					if(b && s)
					{
						dir.add(new Option(ff, b, s));
					}
					else if(b)
					{
						dir.add(new Option(ff, b, s));
					}
					else if(s)
					{
						dir.add(new Option(ff, b, s));
					}
					fill(ff);
				}
			}
		} catch(Exception e) {

		}
	}

	private void showFolders()
	{
		if(dir.isEmpty()||dir==null)
		{
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage("There are no available Picklists")
			.setTitle("Picklists");

			builder.setPositiveButton("Return", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					onBackPressed();
				}
			});

			AlertDialog dialog = builder.create();

			dialog.show();
		}
		else
		{
			adapter = new FileArrayAdapter(FileChooser.this, R.layout.file_view, dir);
			this.setListAdapter(adapter);
		}
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
	}
}
