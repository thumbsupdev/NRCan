package com.nrcan.main;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class FileChooser extends ListActivity {
    
    private File currentDir;
    private FileArrayAdapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        currentDir = new File("/sdcard/");
        fill(currentDir);
    }
    private void fill(File f)
    {
        File[]dirs = f.listFiles();
         this.setTitle("Current Dir: "+f.getName());
         List<Option>dir = new ArrayList<Option>();
         List<Option>fls = new ArrayList<Option>();
         try{
             for(File ff: dirs)
             {
                if(ff.isDirectory())
                    dir.add(new Option(ff.getName(),"Folder",ff.getAbsolutePath()));
                else
                {
                    fls.add(new Option(ff.getName(),"File Size: "+ff.length(),ff.getAbsolutePath()));
                }
             }
         }catch(Exception e)
         {
             
         }
         Collections.sort(dir);
         Collections.sort(fls);
         
         boolean pickListFolder = false;
         
         if(fls.size()>5)
         {
        	 pickListFolder = true;
	         for(int i = 0; i<=4; i++)
	         {
	        	 if(!fls.get(i).getName().matches("lut[a-zA-Z0-9]+.txt"))
	        	 	pickListFolder=false;
	         }
         }
         if(pickListFolder)
        	 Toast.makeText(this, "PickList Selected: ", Toast.LENGTH_SHORT).show();
        	 
         
         dir.addAll(fls);
         if(!f.getName().equalsIgnoreCase("sdcard"))
             dir.add(0,new Option("..","Parent Directory",f.getParent()));
         adapter = new FileArrayAdapter(FileChooser.this,R.layout.file_view,dir);
         this.setListAdapter(adapter);
    }
    Stack<File> dirStack = new Stack<File>();
    
    @Override
	 protected void onListItemClick(ListView l, View v, int position, long id) {
	 	super.onListItemClick(l, v, position, id);
	 	Option o = adapter.getItem(position);
	 	if(o.getData().equalsIgnoreCase("folder")){
	     		dirStack.push(currentDir);
	 		currentDir = new File(o.getPath());
	 		fill(currentDir);
	 	}
	 	else
	 	if(o.getData().equalsIgnoreCase("parent directory")){
	 		currentDir = dirStack.pop();
	     		fill(currentDir);
	 	}
	 	else
	 	{
	 		onFileClick(o);
	 	}
	 }
    
    @Override
    public void onBackPressed() {
 	if (dirStack.size() == 0)
 		super.onBackPressed();
 	else
 	{
 	currentDir = dirStack.pop();
    		fill(currentDir);
 	}
    }


    private void onFileClick(Option o)
    {
        Toast.makeText(this, "File Clicked: "+o.getName(), Toast.LENGTH_SHORT).show();
    }
}
