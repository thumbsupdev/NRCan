package com.nrcan.controllers;

import java.util.ArrayList;

import com.nrcan.entities.PhotoEntity;
import com.nrcan.main.PicklistDatabaseHandler;
import com.nrcan.main.R;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class PhotoController extends BaseAdapter implements Filterable {
	private LayoutInflater mInflater;
	private Activity activity;
	private Context context;
	private int tab;
	private PicklistDatabaseHandler pldb;
	private PhotoEntity photoEntity;
	private ArrayList<String> plNames = new ArrayList<String>();

	public PhotoController(Context context, Activity activity, PhotoEntity photoEntity, PicklistDatabaseHandler pldb) {
		this.mInflater = LayoutInflater.from(context);
		this.activity = activity;
		this.context = context;
		this.tab = 1;
		this.pldb = pldb;
		this.photoEntity = photoEntity;
		setPLBedrock();
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
			convertView = mInflater.inflate(R.layout.photo_1, null);

			/////////////////////////////////////
			// SPINNER CATEGORY
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (1/4)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerCategory = (Spinner) convertView.findViewById(R.id.photo_spinner_category);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerCategory.setAdapter(sp1);
			sp1.setElements(pldb.getCol1(plNames.get(0)));
			sp1.setNewElement(pldb, plNames.get(0), 1, null, null);
			sp1.addSpace();
			spinnerCategory.setAdapter(sp1);
			spinnerCategory.setSelection(sp1.getPosition(photoEntity.getCategory()));
			spinnerCategory.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					photoEntity.setCaption(parent.getItemAtPosition(position).toString());
				}
			});
			
			/////////////////////////////////////
			// EDITTEXT PHOTONAME/FILENAME
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (2/4)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextPhotoName = (EditText) convertView.findViewById(R.id.photo_text_filename);
			editTextPhotoName.setText(photoEntity.getFileName());
			editTextPhotoName.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						photoEntity.setFileName("");
					else
						photoEntity.setFileName(s.toString());
				}
			});
			
			/////////////////////////////////////
			// EDITTEXT PHOTO FILE NUMBER
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (3/4)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextFileNumber = (EditText) convertView.findViewById(R.id.photo_text_filenumber);
			editTextFileNumber.setText(photoEntity.getFileNo());
			editTextFileNumber.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						photoEntity.setFileNo("");
					else
						photoEntity.setFileNo(s.toString());
				}
			});
			
			/////////////////////////////////////
			// EDITTEXT DIRECTION
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (4/4)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextDirection = (EditText) convertView.findViewById(R.id.photo_text_direction);
			editTextDirection.setText(photoEntity.getDirection());
			editTextDirection.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						photoEntity.setDirection("");
					else
						photoEntity.setDirection(s.toString());
				}
			});
			
		} else if (tab == 2) {
			convertView = mInflater.inflate(R.layout.photo_2, null);
			
			/////////////////////////////////////
			// EDITTEXT CAPTION
			//
			// DESCRIPTION
			/////////////////////////////////////
			// VERIFIED - TAB 2 - ELEMENT (1/1)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextCaption = (EditText) convertView.findViewById(R.id.photo_text_caption);
			editTextCaption.setText(photoEntity.getCaption());
			editTextCaption.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						photoEntity.setCaption("");
					else
						photoEntity.setCaption(s.toString());
				}
			});
			
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
	
	public void setPLBedrock() {
		plNames.clear();
		plNames.add("lutBEDPhotoCategory");
	}
	
	public void setPLSurficial() {
		plNames.clear();
		plNames.add("lutSURPhotoCategory");
	}
}
