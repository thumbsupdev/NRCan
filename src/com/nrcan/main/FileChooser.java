package com.nrcan.main;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.os.Environment;

public class FileChooser extends ListActivity {

	private File currentDir;
	private FileArrayAdapter adapter;
	private HashMap<String, Integer> bedrockFileNames;
	private HashMap<String, Integer> surficialFileNames;
	private List<Option>dir = new ArrayList<Option>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		bedrockFileNames = MainActivity.getBedrock();
		surficialFileNames = MainActivity.getSurficial();
		currentDir = new File(Environment.getExternalStorageDirectory().getName());
		fill2(currentDir);
		showFolders();
	}

	private boolean lookForPicklist(File f,HashMap<String, Integer> tempMap) {
		File[] files = null;
		//HashMap<String, Integer> tmp = new HashMap<String, Integer>(tempMap);
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
						//tmp.remove(s);
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

	private void fill2(File f)
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
					fill2(ff);
				}
			}
		} catch(Exception e) {

		}
	}

	private void showFolders()
	{
		adapter = new FileArrayAdapter(FileChooser.this, R.layout.file_view, dir);
		this.setListAdapter(adapter);
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
	}
}
