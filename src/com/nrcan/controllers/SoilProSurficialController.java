package com.nrcan.controllers;

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

import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;

public class SoilProSurficialController extends BaseAdapter implements Filterable {
	private LayoutInflater mInflater;
	//private Activity activity;
	//private Context context;
	private int tab;
	//private PicklistDatabaseHandler pldb;
	private SoilProSurficialEntity soilProSurficialEntity;

	public SoilProSurficialController(Context context, Activity activity,SoilProSurficialModel soilproModel,PicklistDatabaseHandler pldb) {
		this.mInflater = LayoutInflater.from(context);
		//this.context = context;
		this.tab = 1;
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
			/////////////////////////////////////
			// EDITTEXT O THICKNESS
			//
			// Text field for "O-Hrz Thickness"
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (1/18)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
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
			
			/////////////////////////////////////
			// EDITTEXT LFH THICKNESS
			//
			// Text field for "LFH-Hrz Thickness"
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (2/18)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
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
			
			/////////////////////////////////////
			// EDITTEXT A THICKNESS
			//
			// Text field for "A-Hrz Thickness"
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (3/18)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
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
			
			/////////////////////////////////////
			// EDITTEXT B THICKNESS
			//
			// Text field for "B-Hrz Thickness"
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (4/18)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
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
			
			/////////////////////////////////////
			// EDITTEXT C THICKNESS
			//
			// Text field for "C-Hrz Thickness"
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (5/18)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
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
			
			/////////////////////////////////////
			// EDITTEXT R THICKNESS
			//
			// Text field for "R-Hrz Thickness"
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (6/18)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
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
		
			/////////////////////////////////////
			// EDITTEXT O QUALIFIER
			//
			// Text field for "O-Hrz Hrz Qualifier"
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (7/18)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
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
			
			/////////////////////////////////////
			// EDITTEXT LFH QUALIFIER
			//
			// Text field for "LFH-Hrz Hrz Qualifier"
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (8/18)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
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
			
			/////////////////////////////////////
			// EDITTEXT A QUALIFIER
			//
			// Text field for "A-Hrz Hrz Qualifier"
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (9/18)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
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
			
			/////////////////////////////////////
			// EDITTEXT B QUALIFIER
			//
			// Text field for "B-Hrz Hrz Qualifier"
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (10/18)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
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
			
			/////////////////////////////////////
			// EDITTEXT C QUALIFIER
			//
			// Text field for "C-Hrz Hrz Qualifier"
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (11/18)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
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
			

			/////////////////////////////////////
			// EDITTEXT R QUALIFIER
			//
			// Text field for "R-Hrz Hrz Qualifier"
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (12/18)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
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
			
			/////////////////////////////////////
			// EDITTEXT ATOP
			//
			// Text field for "Depth 1"
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (13/18)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
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
			
			/////////////////////////////////////
			// EDITTEXT BTOP
			//
			// Text field for "Depth 2"
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (14/18)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
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
			
			/////////////////////////////////////
			// EDITTEXT CTOP
			//
			// Text field for "Depth 3"
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (15/18)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
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
			
			/////////////////////////////////////
			// EDITTEXT RTOP
			//
			// Text field for "Depth 4"
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (16/18)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
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
			
			/////////////////////////////////////
			// EDITTEXT TOTAL PROFILE/TOTTHICK
			//
			// Text field for "Total Profile"
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (17/18)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
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
			
			/////////////////////////////////////
			// EDITTEXT BOTTOM TEXTFIELD
			//
			// Text field for "Bottom text field"
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (18/18)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
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
			/////////////////////////////////////
			// EDITTEXT NOTES
			//
			// Text field for "Notes"
			/////////////////////////////////////
			// VERIFIED - TAB 2 - ELEMENT (1/1)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
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
	
	public void clear() {
		soilProSurficialEntity.clearEntity();
		tab = 1;
		notifyDataSetChanged();
	
	}
}
