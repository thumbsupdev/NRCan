package com.nrcan.controllers;

import java.util.ArrayList;

import com.nrcan.entities.SoilProSurficialEntity;
import com.nrcan.main.PicklistDatabaseHandler;
import com.nrcan.main.R;
import com.nrcan.models.SoilProSurficialModel;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.SeekBar;
import android.widget.Spinner;

public class SoilProSurficialController extends BaseAdapter implements
		Filterable {
	private LayoutInflater mInflater;
	private Activity activity;
	private Context context;
	private int tab;
	private SoilProSurficialModel soilproModel;
	private PicklistDatabaseHandler pldb;
	private SoilProSurficialEntity soilProSurficialEntity;

	public SoilProSurficialController(Context context, Activity activity,SoilProSurficialModel soilproModel,PicklistDatabaseHandler pldb) {
		this.mInflater = LayoutInflater.from(context);
		this.activity = activity;
		this.context = context;
		this.tab = 1;
		this.soilproModel = soilproModel;
		this.pldb = pldb;
		this.soilProSurficialEntity = soilproModel.getEntity();
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
			convertView = mInflater.inflate(R.layout.soilpro_surficial1, null);
			
			//EDIT TEXT O THICK
			EditText editTextOHrzThick = (EditText) convertView.findViewById(R.id.soilpro_text_oHrzThick);
			editTextOHrzThick.setText(soilProSurficialEntity.getO_hrz());
			editTextOHrzThick.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						soilProSurficialEntity.setO_hrz("");
					else
						soilProSurficialEntity.setO_hrz(s.toString());
				}
			});
			
			//EDIT TEXT LF THICK
			EditText editTextLFHrzThick = (EditText) convertView.findViewById(R.id.soilpro_text_lfhHrzThick);
			editTextLFHrzThick.setText(soilProSurficialEntity.getL_f_h());
			editTextLFHrzThick.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						soilProSurficialEntity.setL_f_h("");
					else
						soilProSurficialEntity.setL_f_h(s.toString());
				}
			});
			
			//EDIT TEXT A THICK
			EditText editTextAHrzThick = (EditText) convertView.findViewById(R.id.soilpro_text_aHrzThick);
			editTextAHrzThick.setText(soilProSurficialEntity.getA_hrz());
			editTextAHrzThick.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						soilProSurficialEntity.setA_hrz("");
					else
						soilProSurficialEntity.setA_hrz(s.toString());
				}
			});
			
			//EDIT TEXT B THICK
			EditText editTextBHrzThick = (EditText) convertView.findViewById(R.id.soilpro_text_bHrzThick);
			editTextBHrzThick.setText(soilProSurficialEntity.getB_hrz());
			editTextBHrzThick.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						soilProSurficialEntity.setB_hrz("");
					else
						soilProSurficialEntity.setB_hrz(s.toString());
				}
			});
			
			//EDIT TEXT C THICK
			EditText editTextCHrzThick = (EditText) convertView.findViewById(R.id.soilpro_text_cHrzThick);
			editTextCHrzThick.setText(soilProSurficialEntity.getC_hrz());
			editTextCHrzThick.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						soilProSurficialEntity.setC_hrz("");
					else
						soilProSurficialEntity.setC_hrz(s.toString());
				}
			});
			
			//EDIT TEXT R THICK
			EditText editTextRHrzThick = (EditText) convertView.findViewById(R.id.soilpro_text_rHrzThick);
			editTextRHrzThick.setText(soilProSurficialEntity.getR_hrz());
			editTextRHrzThick.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						soilProSurficialEntity.setR_hrz("");
					else
						soilProSurficialEntity.setR_hrz(s.toString());
				}
			});
		
			//EDIT TEXT O QUAL
			EditText editTextOHrzQual = (EditText) convertView.findViewById(R.id.soilpro_text_oHrzQual);
			editTextOHrzQual.setText(soilProSurficialEntity.getoQualifier());
			editTextOHrzQual.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						soilProSurficialEntity.setoQualifier("");
					else
						soilProSurficialEntity.setoQualifier(s.toString());
				}
			});
			
			//EDIT TEXT LF QUAL
			EditText editTextLFHrzQual = (EditText) convertView.findViewById(R.id.soilpro_text_lfhHrzQual);
			editTextLFHrzQual.setText(soilProSurficialEntity.getL_f_HQuali());
			editTextLFHrzQual.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						soilProSurficialEntity.setL_f_HQuali("");
					else
						soilProSurficialEntity.setL_f_HQuali(s.toString());
				}
			});
			
			//EDIT TEXT A QUAL
			EditText editTextAHrzQual = (EditText) convertView.findViewById(R.id.soilpro_text_aHrzQual);
			editTextAHrzQual.setText(soilProSurficialEntity.getaQualifier());
			editTextAHrzQual.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						soilProSurficialEntity.setaQualifier("");
					else
						soilProSurficialEntity.setaQualifier(s.toString());
				}
			});
			
			//EDIT TEXT B QUAL
			EditText editTextBHrzQual = (EditText) convertView.findViewById(R.id.soilpro_text_bHrzQual);
			editTextBHrzQual.setText(soilProSurficialEntity.getbQualifier());
			editTextBHrzQual.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						soilProSurficialEntity.setbQualifier("");
					else
						soilProSurficialEntity.setbQualifier(s.toString());
				}
			});
			
			//EDIT TEXT C QUAL
			EditText editTextCHrzQual = (EditText) convertView.findViewById(R.id.soilpro_text_cHrzQual);
			editTextCHrzQual.setText(soilProSurficialEntity.getcQualifier());
			editTextCHrzQual.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						soilProSurficialEntity.setcQualifier("");
					else
						soilProSurficialEntity.setcQualifier(s.toString());
				}
			});
			
			//EDIT TEXT R Qual
			EditText editTextRHrzQual = (EditText) convertView.findViewById(R.id.soilpro_text_rHrzQual);
			editTextRHrzQual.setText(soilProSurficialEntity.getrQualifier());
			editTextRHrzQual.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						soilProSurficialEntity.setrQualifier("");
					else
						soilProSurficialEntity.setrQualifier(s.toString());
				}
			});
			
			
			//EDIT TEXT ATOP?
			EditText editTextDepth1 = (EditText) convertView.findViewById(R.id.soilpro_text_depth1);
			editTextDepth1.setText(soilProSurficialEntity.getaTop());
			editTextDepth1.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						soilProSurficialEntity.setaTop("");
					else
						soilProSurficialEntity.setaTop(s.toString());
				}
			});
			
			//EDIT TEXT BTOP?
			EditText editTextDepth2 = (EditText) convertView.findViewById(R.id.soilpro_text_depth2);
			editTextDepth2.setText(soilProSurficialEntity.getbTop());
			editTextDepth2.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						soilProSurficialEntity.setbTop("");
					else
						soilProSurficialEntity.setbTop(s.toString());
				}
			});
			
			//EDIT TEXT CTOP?
			EditText editTextDepth3 = (EditText) convertView.findViewById(R.id.soilpro_text_depth3);
			editTextDepth3.setText(soilProSurficialEntity.getcTop());
			editTextDepth3.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						soilProSurficialEntity.setcTop("");
					else
						soilProSurficialEntity.setcTop(s.toString());
				}
			});
			
			//EDIT TEXT RTOP?
			EditText editTextDepth4 = (EditText) convertView.findViewById(R.id.soilpro_text_depth4);
			editTextDepth4.setText(soilProSurficialEntity.getrTop());
			editTextDepth4.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						soilProSurficialEntity.setrTop("");
					else
						soilProSurficialEntity.setrTop(s.toString());
				}
			});
			
			//EDIT TEXT TOTAL PROFILE/TOTTHICK?
			EditText editTextTotalProfile = (EditText) convertView.findViewById(R.id.soilpro_text_totalProfile);
			editTextTotalProfile.setText(soilProSurficialEntity.getTotThick());
			editTextTotalProfile.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						soilProSurficialEntity.setTotThick("");
					else
						soilProSurficialEntity.setTotThick(s.toString());
				}
			});
			
			//EDIT TEXT No idea
			EditText editTextUnknownBottom = (EditText) convertView.findViewById(R.id.soilpro_text_unknownBottomText);
			//editTextUnknownBottom.setText(soilProSurficialEntity.getModStruc());
			editTextUnknownBottom.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0){
						//soilProSurficialEntity.setModStruc("");
					}else{
						//soilProSurficialEntity.setModStruc(s.toString());
					}
				}
			});
			
		} else if (tab == 2) {
			
			convertView = mInflater.inflate(R.layout.soilpro_surficial2, null);
			//EDIT TEXT NOTES
			EditText editTextNotes = (EditText) convertView.findViewById(R.id.soilpro_surficial_editText_notes);
			editTextNotes.setText(soilProSurficialEntity.getNotes());
			editTextNotes.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						soilProSurficialEntity.setNotes("");
					else
						soilProSurficialEntity.setNotes(s.toString());
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


	

	
}
