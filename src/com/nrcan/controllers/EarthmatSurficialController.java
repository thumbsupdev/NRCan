package com.nrcan.controllers;

import com.nrcan.entities.EarthmatSurficialEntity;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class EarthmatSurficialController extends BaseAdapter implements Filterable {
	private LayoutInflater mInflater;
	//private Activity activity;
	private Context context;
	private int tab;
	private EarthmatSurficialEntity earthmatSurficialEntity;
	private PicklistDatabaseHandler pldb;
	private boolean erratic1Boolean = true;
	private boolean erratic2Boolean = false;
	private String erraticTmp;

	public EarthmatSurficialController(Context context, Activity activity, EarthmatSurficialEntity earthmatSurficialEntity, PicklistDatabaseHandler pldb) {
		this.mInflater = LayoutInflater.from(context);
		//this.activity = activity;
		this.context = context;
		this.earthmatSurficialEntity = earthmatSurficialEntity;
		this.pldb = pldb;
		this.tab = 1;
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
			convertView = mInflater.inflate(R.layout.earthmat_surficial1, null);
			
			/////////////////////////////////////
			// SPINNER GROUP
			//
			// Drop-down for "Group" - Column 1 of lutSUREarthmatLith2 Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (1/4)
			/////////////////////////////////////
			// [] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerGroup = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_group);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutSUREarthmatLith2"));
			sp1.setNewElement(pldb, "lutSUREarthmatLith2", 1, null, null);
			spinnerGroup.setAdapter(sp1);
			spinnerGroup.setSelection(sp1.getPosition(earthmatSurficialEntity.getLithGroup()));
			spinnerGroup.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {}
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					String tmp = parent.getItemAtPosition(position).toString();
					if(!tmp.equalsIgnoreCase(earthmatSurficialEntity.getLithGroup()))
					{
						earthmatSurficialEntity.setLithGroup(tmp);
						earthmatSurficialEntity.setLithType("");
						earthmatSurficialEntity.setLithDetail("");
						notifyDataSetChanged();
					}
				}
			});
			
			/////////////////////////////////////
			// SPINNER TYPE
			//
			// Drop-down for "Type" - Column 2 of lutSUREarthmatLith2 Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (2/4)
			/////////////////////////////////////
			//[] JORDAN KUROSKY
			//[] JAMIE POSPIECH
			//[] DEREK ELLIOTT
			//[X] PIERRE LAFOREST-GRANT
			//[X] ALEX YEUNG
			/////////////////////////////////////	
			Spinner spinnerType = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_type);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp2.setElements(pldb.getCol2("lutSUREarthmatLith2",earthmatSurficialEntity.getLithGroup()));
			sp2.setNewElement(pldb, "lutSUREarthmatLith2", 2, earthmatSurficialEntity.getLithGroup(), null);
			spinnerType.setAdapter(sp2);
			spinnerType.setSelection(sp2.getPosition(earthmatSurficialEntity.getLithType()));
			spinnerType.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {}
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					String tmp = parent.getItemAtPosition(position).toString();
					if(!tmp.equalsIgnoreCase(earthmatSurficialEntity.getLithType()))
					{
						earthmatSurficialEntity.setLithType(tmp);
						earthmatSurficialEntity.setLithDetail("");
						notifyDataSetChanged();
					}
				}
			});
			
			/////////////////////////////////////
			// SPINNER DETAIL
			//
			// Drop-down for "Detail" - Column 3 of lutSUREarthmatLith2 Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (3/4)
			/////////////////////////////////////
			//[] JORDAN KUROSKY
			//[] JAMIE POSPIECH
			//[] DEREK ELLIOTT
			//[X] PIERRE LAFOREST-GRANT
			//[X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerDetail = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_detail);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp3.setElements(pldb.getCol3("lutSUREarthmatLith2",earthmatSurficialEntity.getLithGroup(),earthmatSurficialEntity.getLithType()));
			sp3.setNewElement(pldb, "lutSUREarthmatLith2", 3, earthmatSurficialEntity.getLithGroup(), earthmatSurficialEntity.getLithType());
			spinnerDetail.setAdapter(sp3);
			spinnerDetail.setSelection(sp3.getPosition(earthmatSurficialEntity.getLithDetail()));
			spinnerDetail.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {}
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setLithDetail(parent.getItemAtPosition(position).toString());
				}
			});
			
			/////////////////////////////////////
			// SPINNER COLOUR
			//
			// Drop-down for "Colour" - Column 1 of lutSUREarthmatColour Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (4/4)
			/////////////////////////////////////
			//[] JORDAN KUROSKY
			//[] JAMIE POSPIECH
			//[] DEREK ELLIOTT
			//[X] PIERRE LAFOREST-GRANT
			//[X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerColour = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_colour);
			SpinnerController sp4 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp4.setElements(pldb.getCol1("lutSUREarthmatColour"));
			sp4.setNewElement(pldb, "lutSUREarthmatColour", 1, null, null);
			spinnerColour.setAdapter(sp4);
			spinnerColour.setSelection(sp4.getPosition(earthmatSurficialEntity.getColour()));
			spinnerColour.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {}
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setColour(parent.getItemAtPosition(position).toString());
				}
			});
			
		} else if (tab == 2) {
			convertView = mInflater.inflate(R.layout.earthmat_surficial2, null);
			
			/////////////////////////////////////
			// CONCAT SPINNER PRIMARY
			//
			// Drop-down for "Primary" - Column 1 of lutSUREarthmatPrimestruc Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 2 - ELEMENT (1/7)
			/////////////////////////////////////
			//[] JORDAN KUROSKY
			//[] JAMIE POSPIECH
			//[] DEREK ELLIOTT
			//[X] PIERRE LAFOREST-GRANT
			//[X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerPrimary = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_primary);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutSUREarthmatPrimestruc"));
			sp1.setNewElement(pldb, "lutSUREarthmatPrimestruc", 1, null, null);
			sp1.addSpace();
			spinnerPrimary.setAdapter(sp1);
			spinnerPrimary.setSelection(sp1.getPosition(earthmatSurficialEntity.getPrimeStruc()));
			spinnerPrimary.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {}
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					String tmp = earthmatSurficialEntity.getPrimeStruc();
					String sel = parent.getItemAtPosition(position).toString();
					if(!tmp.contains(sel))
					{
						if(tmp.length() > 1)
							earthmatSurficialEntity.setPrimeStruc(tmp + " | " + sel);
						else
							earthmatSurficialEntity.setPrimeStruc(sel);
						
						notifyDataSetChanged();
					}
				}
			});
			
			/////////////////////////////////////
			// CONCAT EDITTEXT PRIMARY
			//
			// Text field concatenates selections from SPINNER PRIMARY
			/////////////////////////////////////
			// VERIFIED - TAB 2 - ELEMENT (2/7)
			/////////////////////////////////////
			//[] JORDAN KUROSKY
			//[] JAMIE POSPIECH
			//[] DEREK ELLIOTT
			//[X] PIERRE LAFOREST-GRANT
			//[X] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextPrimary = (EditText) convertView.findViewById(R.id.earthmat_surficial_editText_primary);
			editTextPrimary.setText(earthmatSurficialEntity.getPrimeStruc());
			editTextPrimary.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						earthmatSurficialEntity.setPrimeStruc("");
					else
						earthmatSurficialEntity.setPrimeStruc(s.toString());
				}
			});
			
			/////////////////////////////////////
			//CONCAT BUTTON PRIMARY
			//
			// Button clears EDITTEXT PRIMARY text field
			/////////////////////////////////////
			//VERIFIED - TAB 2 - ELEMENT (3/7)
			/////////////////////////////////////
			//[] JORDAN KUROSKY
			//[] JAMIE POSPIECH
			//[] DEREK ELLIOTT
			//[X] PIERRE LAFOREST-GRANT
			//[X] ALEX YEUNG
			/////////////////////////////////////
			Button buttonPrimary = (Button) convertView.findViewById(R.id.earthmat_surficial_button_primary_clear);
			buttonPrimary.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					earthmatSurficialEntity.setPrimeStruc("");
					notifyDataSetChanged();
				}
			});
			
			
			/////////////////////////////////////
			// SPINNER WAYUP
			//
			// Drop-down for "Way Up" - Column 1 of lutSUREarthmatWayup Picklist
			/////////////////////////////////////
			//VERIFIED - TAB 2 - ELEMENT (4/7)
			/////////////////////////////////////
			//[] JORDAN KUROSKY
			//[] JAMIE POSPIECH
			//[] DEREK ELLIOTT
			//[X] PIERRE LAFOREST-GRANT
			//[X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerWayUp = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_wayup);
			SpinnerController sp2= new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp2.setElements(pldb.getCol1("lutSUREarthmatWayup"));
			sp2.setNewElement(pldb, "lutSUREarthmatWayup", 1, null, null);
			spinnerWayUp.setAdapter(sp2);
			spinnerWayUp.setSelection(sp2.getPosition(earthmatSurficialEntity.getWayUp()));
			spinnerWayUp.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {}
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setWayUp(parent.getItemAtPosition(position).toString());
				}
			});
			
			/////////////////////////////////////
			// CONCAT SPINNER SECONDARY
			//
			// Drop-down for "Secondary" - Column 1 of lutSUREarthmatScndstruc Picklist
			/////////////////////////////////////
			//VERIFIED - TAB 2 - ELEMENT (5/7)
			/////////////////////////////////////
			//[] JORDAN KUROSKY
			//[] JAMIE POSPIECH
			//[] DEREK ELLIOTT
			//[X] PIERRE LAFOREST-GRANT
			//[X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerSecondary = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_secondary);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp3.setElements(pldb.getCol1("lutSUREarthmatScndstruc"));
			sp3.setNewElement(pldb, "lutSUREarthmatScndstruc", 1, null, null);
			sp3.addSpace();
			spinnerSecondary.setAdapter(sp3);
			spinnerSecondary.setSelection(sp3.getPosition(earthmatSurficialEntity.getScndStruc()));
			spinnerSecondary.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {}
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					String tmp = earthmatSurficialEntity.getScndStruc();
					String sel = parent.getItemAtPosition(position).toString();
					if(!tmp.contains(sel))
					{
						if(tmp.length() > 1)
							earthmatSurficialEntity.setScndStruc(tmp + " | " + sel);
						else
							earthmatSurficialEntity.setScndStruc(sel);
						
						notifyDataSetChanged();
					}
				}
			});
			
			/////////////////////////////////////
			// CONCAT EDITTEXT SECONDARY
			//
			// Text field concatenates selections from SPINNER SECONDARY
			/////////////////////////////////////
			//VERIFIED - TAB 2 - ELEMENT (6/7)
			/////////////////////////////////////
			//[] JORDAN KUROSKY
			//[] JAMIE POSPIECH
			//[] DEREK ELLIOTT
			//[X] PIERRE LAFOREST-GRANT
			//[X] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextSecondary = (EditText) convertView.findViewById(R.id.earthmat_surficial_editText_secondary);
			editTextSecondary.setText(earthmatSurficialEntity.getScndStruc());
			editTextSecondary.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						earthmatSurficialEntity.setScndStruc("");
					else
						earthmatSurficialEntity.setScndStruc(s.toString());
				}
			});
			
			/////////////////////////////////////
			// CONCAT BUTTON SECONDARY STRUCT
			//
			// Button clears EDITTEXT SECONDARY text field
			/////////////////////////////////////
			//VERIFIED - TAB 2 - ELEMENT (7/7)
			/////////////////////////////////////
			//[] JORDAN KUROSKY
			//[] JAMIE POSPIECH
			//[] DEREK ELLIOTT
			//[X] PIERRE LAFOREST-GRANT
			//[X] ALEX YEUNG
			/////////////////////////////////////
			Button buttonSecondary = (Button) convertView.findViewById(R.id.earthmat_surficial_button_secondary_clear);
			buttonSecondary.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					earthmatSurficialEntity.setScndStruc("");
					notifyDataSetChanged();
				}
			});
			
		} else if (tab == 3) {
			convertView = mInflater.inflate(R.layout.earthmat_surficial3, null);
			
			/////////////////////////////////////
			// SPINNER THICKNESSTYPE
			//
			// Drop-down for "Thickness Type" - Column 1 of lutSUREarthmatThickType Picklist
			/////////////////////////////////////
			//VERIFIED - TAB 3 - ELEMENT (1/6)
			/////////////////////////////////////
			//[] JORDAN KUROSKY
			//[] JAMIE POSPIECH
			//[] DEREK ELLIOTT
			//[X] PIERRE LAFOREST-GRANT
			//[X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerIntThickness = (Spinner) convertView	.findViewById(R.id.earthmat_surficial_spinner_intThickness);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutSUREarthmatThickType"));
			sp1.setNewElement(pldb, "lutSUREarthmatThickType", 1, null, null);
			sp1.addSpace();
			spinnerIntThickness.setAdapter(sp1);
			spinnerIntThickness.setSelection(sp1.getPosition(earthmatSurficialEntity.getThickType()));
			spinnerIntThickness.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {}
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setThickType(parent.getItemAtPosition(position).toString());
				}
			});
			
			/////////////////////////////////////
			// EDITTEXT TO
			//
			// Text field for "To(m)"
			/////////////////////////////////////
			//VERIFIED - TAB 3 - ELEMENT (2/6)
			/////////////////////////////////////
			//[] JORDAN KUROSKY
			//[] JAMIE POSPIECH
			//[] DEREK ELLIOTT
			//[X] PIERRE LAFOREST-GRANT
			//[X] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextTo = (EditText) convertView.findViewById(R.id.earthmat_surficial_editText_to);
			editTextTo.setText(earthmatSurficialEntity.getThickMax());
			editTextTo.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						earthmatSurficialEntity.setThickMax("");
					else
						earthmatSurficialEntity.setThickMax(s.toString());
				}
			});
			
			/////////////////////////////////////
			// EDITTEXT FROM
			//
			// Text field for "From(m)"
			/////////////////////////////////////
			//VERIFIED - TAB 3 - ELEMENT (3/6)
			/////////////////////////////////////
			//[] JORDAN KUROSKY
			//[] JAMIE POSPIECH
			//[] DEREK ELLIOTT
			//[X] PIERRE LAFOREST-GRANT
			//[X] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextFrom = (EditText) convertView.findViewById(R.id.earthmat_surficial_editText_from);
			editTextFrom.setText(earthmatSurficialEntity.getThickMin());
			editTextFrom.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						earthmatSurficialEntity.setThickMin("");
					else
						earthmatSurficialEntity.setThickMin(s.toString());
				}
			});
		
			/////////////////////////////////////
			// SPINNER LOWER CONTACT
			//
			// Drop-down for "Lower Contact" - Column 1 of lutSUREarthmatLwrcontact Picklist
			/////////////////////////////////////
			//VERIFIED - TAB 3 - ELEMENT (4/6)
			/////////////////////////////////////
			//[] JORDAN KUROSKY
			//[] JAMIE POSPIECH
			//[] DEREK ELLIOTT
			//[X] PIERRE LAFOREST-GRANT
			//[X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerLowContact = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_lowContact);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp2.setElements(pldb.getCol1("lutSUREarthmatLwrcontact"));
			sp2.setNewElement(pldb, "lutSUREarthmatLwrcontact", 1, null, null);
			sp2.addSpace();
			spinnerLowContact.setAdapter(sp2);
			spinnerLowContact.setSelection(sp2.getPosition(earthmatSurficialEntity.getLwrContact()));
			spinnerLowContact.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {}
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setLwrContact(parent.getItemAtPosition(position).toString());
				}
			});
			
			/////////////////////////////////////
			// SPINNER INT CONTACT
			//
			// Drop-down for "Contact Interpretation" - Column 1 of lutSUREarthmatIntcontact Picklist
			/////////////////////////////////////
			//VERIFIED - TAB 3 - ELEMENT (5/6)
			/////////////////////////////////////
			//[] JORDAN KUROSKY
			//[] JAMIE POSPIECH
			//[] DEREK ELLIOTT
			//[X] PIERRE LAFOREST-GRANT
			//[X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerInterpretation = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_interpretation);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp3.setElements(pldb.getCol1("lutSUREarthmatIntcontact"));
			sp3.setNewElement(pldb, "lutSUREarthmatIntcontact", 1, null, null);
			sp3.addSpace();
			spinnerInterpretation.setAdapter(sp3);
			spinnerInterpretation.setSelection(sp3.getPosition(earthmatSurficialEntity.getIntContact()));
			spinnerInterpretation.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {}
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setIntContact(parent.getItemAtPosition(position).toString());
				}
			});
			
			/////////////////////////////////////
			// SPINNER LAT CONTACT
			//
			// Drop-down for "Lateral Contact" - Column 1 of lutSUREarthmatLatcontact Picklist
			/////////////////////////////////////
			//VERIFIED - TAB 3 - ELEMENT (6/6)
			/////////////////////////////////////
			//[] JORDAN KUROSKY
			//[] JAMIE POSPIECH
			//[] DEREK ELLIOTT
			//[X] PIERRE LAFOREST-GRANT
			//[X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerLatContact = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_latContact);
			SpinnerController sp4 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp4.setElements(pldb.getCol1("lutSUREarthmatLatcontact"));
			sp4.setNewElement(pldb, "lutSUREarthmatLatcontact", 1, null, null);
			sp4.addSpace();
			spinnerLatContact.setAdapter(sp4);
			spinnerLatContact.setSelection(sp4.getPosition(earthmatSurficialEntity.getLatContact()));
			spinnerLatContact.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {}
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setLatContact(parent.getItemAtPosition(position).toString());
				}
			});
			
		} else if (tab == 4) {
			convertView = mInflater.inflate(R.layout.earthmat_surficial4, null);
			
			/////////////////////////////////////
			// SPINNER SORTING
			//
			// Drop-down for "Sorting" - Column 1 of lutSUREarthmatSorting Picklist
			/////////////////////////////////////
			//VERIFIED - TAB 4 - ELEMENT (1/11)
			/////////////////////////////////////
			//[] JORDAN KUROSKY
			//[] JAMIE POSPIECH
			//[] DEREK ELLIOTT
			//[X] PIERRE LAFOREST-GRANT
			//[X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerSorting = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_sorting);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutSUREarthmatSorting"));
			sp1.setNewElement(pldb, "lutSUREarthmatSorting", 1, null, null);
			sp1.addSpace();
			spinnerSorting.setAdapter(sp1);
			spinnerSorting.setSelection(sp1.getPosition(earthmatSurficialEntity.getSorting()));
			spinnerSorting.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {}
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setSorting(parent.getItemAtPosition(position).toString());
				}
			});
			
			/////////////////////////////////////
			// CONCAT SPINNER MATRIX
			//
			// Drop-down for "Matrix" - Column 1 of lutSUREarthmatMatrix Picklist
			/////////////////////////////////////
			//VERIFIED - TAB 4 - ELEMENT (2/11)
			/////////////////////////////////////
			//[] JORDAN KUROSKY
			//[] JAMIE POSPIECH
			//[] DEREK ELLIOTT
			//[X] PIERRE LAFOREST-GRANT
			//[X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerMatrix = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_matrix);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp2.setElements(pldb.getCol1("lutSUREarthmatMatrix"));
			sp2.setNewElement(pldb, "lutSUREarthmatMatrix", 1, null, null);
			sp2.addSpace();
			spinnerMatrix.setAdapter(sp2);
			//spinnerMatrix.setSelection(sp2.getPosition(earthmatSurficialEntity.getMatrix()));
			spinnerMatrix.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {}
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					String tmp = earthmatSurficialEntity.getMatrixMod();
					String sel = parent.getItemAtPosition(position).toString();
					if(!tmp.contains(sel))
					{
						if(tmp.length() > 1)
							earthmatSurficialEntity.setMatrixMod(tmp + " | " + sel);
						else
							earthmatSurficialEntity.setMatrixMod(sel);
			
						notifyDataSetChanged();
					}
				}
			});
			
			/////////////////////////////////////
			// CONCAT SPINNER MODIFIER
			//
			// Drop-down for "Matrix" - Column 1 of lutSUREarthmatMatrixMod Picklist
			/////////////////////////////////////
			//VERIFIED - TAB 4 - ELEMENT (3/11)
			/////////////////////////////////////
			//[] JORDAN KUROSKY
			//[] JAMIE POSPIECH
			//[] DEREK ELLIOTT
			//[X] PIERRE LAFOREST-GRANT
			//[X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerModifier = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_modifier);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp3.setElements(pldb.getCol1("lutSUREarthmatMatrixMod"));
			sp3.setNewElement(pldb, "lutSUREarthmatMatrixMod", 1, null, null);
			sp3.addSpace();
			spinnerModifier.setAdapter(sp3);
			//spinnerModifier.setSelection(sp3.getPosition(earthmatSurficialEntity.getMatrixMod()));
			spinnerModifier.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {}
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setMatrixMod(parent.getItemAtPosition(position).toString());
					String tmp = earthmatSurficialEntity.getMatrixMod();
					String sel = parent.getItemAtPosition(position).toString();
					if(!tmp.contains(sel))
					{
						if(tmp.length() > 1)
							earthmatSurficialEntity.setMatrixMod(tmp + " | " + sel);
						else
							earthmatSurficialEntity.setMatrixMod(sel);
			
						notifyDataSetChanged();
					}
				
				}
			});
			
			/////////////////////////////////////
			// CONCAT EDITTEXT MATRIXMOD
			//
			// Text field concatenates selections from SPINNER MATRIX and SPINNER MATRIXMOD
			/////////////////////////////////////
			//VERIFIED - TAB 4 - ELEMENT (4/11)
			/////////////////////////////////////
			//[] JORDAN KUROSKY
			//[] JAMIE POSPIECH
			//[] DEREK ELLIOTT
			//[X] PIERRE LAFOREST-GRANT
			//[X] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextMatrixMod = (EditText) convertView.findViewById(R.id.earthmat_surficial_editText_matrixMod);
			editTextMatrixMod.setText(earthmatSurficialEntity.getMatrixMod());
			editTextMatrixMod.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						earthmatSurficialEntity.setMatrixMod("");
					else
						earthmatSurficialEntity.setMatrixMod(s.toString());
				}
			});
			
			/////////////////////////////////////
			// CONCAT BUTTON MATRIXMOD
			//
			// Button clears EDITTEXT MATRIXMOD text field
			/////////////////////////////////////
			//VERIFIED - TAB 4 - ELEMENT (5/11)
			/////////////////////////////////////
			//[] JORDAN KUROSKY
			//[] JAMIE POSPIECH
			//[] DEREK ELLIOTT
			//[X] PIERRE LAFOREST-GRANT
			//[X] ALEX YEUNG
			/////////////////////////////////////
			Button buttonMatrixClear = (Button) convertView.findViewById(R.id.earthmat_surficial_button_matrixMod_clear);
			buttonMatrixClear.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					earthmatSurficialEntity.setMatrixMod("");
					notifyDataSetChanged();
				}
			});
			
			
			/////////////////////////////////////
			// SPINNER OXIDATION
			//
			// Drop-down for "Oxidation" - Column 1 of lutSUREarthmatOxidation Picklist
			/////////////////////////////////////
			//VERIFIED - TAB 4 - ELEMENT (6/11)
			/////////////////////////////////////
			//[] JORDAN KUROSKY
			//[] JAMIE POSPIECH
			//[] DEREK ELLIOTT
			//[X] PIERRE LAFOREST-GRANT
			//[X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerOxidation = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_oxidation);
			SpinnerController sp4 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp4.setElements(pldb.getCol1("lutSUREarthmatOxidation"));
			sp4.setNewElement(pldb, "lutSUREarthmatOxidation", 1, null, null);
			sp4.addSpace();
			spinnerOxidation.setAdapter(sp4);
			spinnerOxidation.setSelection(sp4.getPosition(earthmatSurficialEntity.getOxidation()));
			spinnerOxidation.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setOxidation(parent.getItemAtPosition(position).toString());
				}
			});
			
			/////////////////////////////////////
			// SPINNER COMPACTION
			//
			// Drop-down for "Compaction" - Column 1 of lutSUREarthmatCompaction Picklist
			/////////////////////////////////////
			//VERIFIED - TAB 4 - ELEMENT (7/11)
			/////////////////////////////////////
			//[] JORDAN KUROSKY
			//[] JAMIE POSPIECH
			//[] DEREK ELLIOTT
			//[X] PIERRE LAFOREST-GRANT
			//[X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerCompact = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_compact);
			SpinnerController sp5 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp5.setElements(pldb.getCol1("lutSUREarthmatCompaction"));
			sp5.setNewElement(pldb, "lutSUREarthmatCompaction", 1, null, null);
			sp5.addSpace();
			spinnerCompact.setAdapter(sp5);
			spinnerCompact.setSelection(sp5.getPosition(earthmatSurficialEntity.getCompaction()));
			spinnerCompact.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {}
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setCompaction(parent.getItemAtPosition(position).toString());
				}
			});
			
			/////////////////////////////////////
			// SPINNER JOINTING
			//
			// Drop-down for "Jointing" - Column 1 of lutSUREarthmatJointing Picklist
			/////////////////////////////////////
			//VERIFIED - TAB 4 - ELEMENT (8/11)
			/////////////////////////////////////
			//[] JORDAN KUROSKY
			//[] JAMIE POSPIECH
			//[] DEREK ELLIOTT
			//[X] PIERRE LAFOREST-GRANT
			//[X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerJointing = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_jointing);
			SpinnerController sp6 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp6.setElements(pldb.getCol1("lutSUREarthmatJointing"));
			sp6.setNewElement(pldb, "lutSUREarthmatJointing", 1, null, null);
			sp6.addSpace();
			spinnerJointing.setAdapter(sp6);
			spinnerJointing.setSelection(sp6.getPosition(earthmatSurficialEntity.getJointing()));
			spinnerJointing.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {}
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setJointing(parent.getItemAtPosition(position).toString());
				}
			});
			
			/////////////////////////////////////
			// SPINNER H20 CONTENT
			//
			// Drop-down for "H20 Content" - Column 1 of lutSUREarthmatH2OContent Picklist
			/////////////////////////////////////
			//VERIFIED - TAB 4 - ELEMENT (9/11)
			/////////////////////////////////////
			//[] JORDAN KUROSKY
			//[] JAMIE POSPIECH
			//[] DEREK ELLIOTT
			//[X] PIERRE LAFOREST-GRANT
			//[X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerh2oContent = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_h2oContent);
			SpinnerController sp7 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp7.setElements(pldb.getCol1("lutSUREarthmatH2OContent"));
			sp7.setNewElement(pldb, "lutSUREarthmatH2OContent", 1, null, null);
			sp7.addSpace();
			spinnerh2oContent.setAdapter(sp7);
			spinnerh2oContent.setSelection(sp7.getPosition(earthmatSurficialEntity.getH2oContent()));
			spinnerh2oContent.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {}
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setH2oContent(parent.getItemAtPosition(position).toString());
				}
			});
			
			/////////////////////////////////////
			// SPINNER HCL React
			//
			// Drop-down for "HCL React." - Column 1 of lutSUREarthmatHCLReact Picklist
			/////////////////////////////////////
			//VERIFIED - TAB 4 - ELEMENT (10/11)
			/////////////////////////////////////
			//[] JORDAN KUROSKY
			//[] JAMIE POSPIECH
			//[] DEREK ELLIOTT
			//[X] PIERRE LAFOREST-GRANT
			//[X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerHclReact = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_hclReact);
			SpinnerController sp8 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp8.setElements(pldb.getCol1("lutSUREarthmatHCLReact"));
			sp8.setNewElement(pldb, "lutSUREarthmatHCLReact", 1, null, null);
			sp8.addSpace();
			spinnerHclReact.setAdapter(sp8);
			spinnerHclReact.setSelection(sp8.getPosition(earthmatSurficialEntity.getHclReact()));
			spinnerHclReact.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {}
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setHclReact(parent.getItemAtPosition(position).toString());
				}
			});
			
			/////////////////////////////////////
			// SPINNER FISSILITY
			//
			// Drop-down for "Fissility" - Column 1 of lutSUREarthmatFissility Picklist
			/////////////////////////////////////
			//VERIFIED - TAB 4 - ELEMENT (11/11)
			/////////////////////////////////////
			//[] JORDAN KUROSKY
			//[] JAMIE POSPIECH
			//[] DEREK ELLIOTT
			//[X] PIERRE LAFOREST-GRANT
			//[X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerFissility = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_fissility);
			SpinnerController sp9 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp9.setElements(pldb.getCol1("lutSUREarthmatFissility"));
			sp9.setNewElement(pldb, "lutSUREarthmatFissility", 1, null, null);
			sp9.addSpace();
			spinnerFissility.setAdapter(sp9);
			spinnerFissility.setSelection(sp9.getPosition(earthmatSurficialEntity.getFissilty()));
			spinnerFissility.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {}
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setFissilty(parent.getItemAtPosition(position).toString());
				}
			});
			
		} else if (tab == 5) {
			convertView = mInflater.inflate(R.layout.earthmat_surficial5, null);
			
			/////////////////////////////////////
			// SPINNER MAP UNIT
			//
			// Drop-down for "Map Unit" - Column 1 of lutSUREarthmatMapunit Picklist
			/////////////////////////////////////
			//VERIFIED - TAB 2 - ELEMENT ()
			/////////////////////////////////////
			//[] JORDAN KUROSKY
			//[] JAMIE POSPIECH
			//[] DEREK ELLIOTT
			//[X] PIERRE LAFOREST-GRANT
			//[X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerMapUnit = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_mapUnit);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutSUREarthmatMapunit"));
			sp1.setNewElement(pldb, "lutSUREarthmatMapunit", 1, null, null);
			sp1.addSpace();
			spinnerMapUnit.setAdapter(sp1);
			spinnerMapUnit.setSelection(sp1.getPosition(earthmatSurficialEntity.getMapUnit()));
			spinnerMapUnit.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {}
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setMapUnit(parent.getItemAtPosition(position).toString());
				}
			});
			
			/////////////////////////////////////
			// SPINNER SURFICIAL ORIGIN
			//
			// Drop-down for "Surficial Origin" - Column 1 of lutSUREarthmatSurfform Picklist
			/////////////////////////////////////
			//VERIFIED - TAB 2 - ELEMENT ()
			/////////////////////////////////////
			//[] JORDAN KUROSKY
			//[] JAMIE POSPIECH
			//[] DEREK ELLIOTT
			//[X] PIERRE LAFOREST-GRANT
			//[X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerSurficialOrigin = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_surficialOrigin);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp2.setElements(pldb.getCol1("lutSUREarthmatSurfform"));
			sp2.setNewElement(pldb, "lutSUREarthmatSurfform", 1, null, null);
			sp2.addSpace();
			spinnerSurficialOrigin.setAdapter(sp2);
			spinnerSurficialOrigin.setSelection(sp2.getPosition(earthmatSurficialEntity.getSufform()));
			spinnerSurficialOrigin.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {}
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setSufform(parent.getItemAtPosition(position).toString());
				}
			});
			

			
		} else if (tab == 6) {
			convertView = mInflater.inflate(R.layout.earthmat_surficial6, null);
			
			/////////////////////////////////////
			// EDITTEXT MODAL
			//
			// Text field for "Modal"
			/////////////////////////////////////
			//VERIFIED - TAB 6 - ELEMENT (1/8)
			/////////////////////////////////////
			//[] JORDAN KUROSKY
			//[] JAMIE POSPIECH
			//[] DEREK ELLIOTT
			//[X] PIERRE LAFOREST-GRANT
			//[X] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextModal = (EditText) convertView.findViewById(R.id.earthmat_surficial_editText_clastModal);
			editTextModal.setText(earthmatSurficialEntity.getClastModal());
			editTextModal.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						earthmatSurficialEntity.setClastModal("");
					else
						earthmatSurficialEntity.setClastModal(s.toString());
				}
			});
			
			/////////////////////////////////////
			// EDITTEXT MODAL MIN
			//
			// Text field for "Min"
			/////////////////////////////////////
			//VERIFIED - TAB 6 - ELEMENT (2/8)
			/////////////////////////////////////
			//[] JORDAN KUROSKY
			//[] JAMIE POSPIECH
			//[] DEREK ELLIOTT
			//[X] PIERRE LAFOREST-GRANT
			//[X] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextMin = (EditText) convertView.findViewById(R.id.earthmat_surficial_editText_clastMin);
			editTextMin.setText(earthmatSurficialEntity.getClastMin());
			editTextMin.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						earthmatSurficialEntity.setClastMin("");
					else
						earthmatSurficialEntity.setClastMin(s.toString());
				}
			});
			
			/////////////////////////////////////
			// EDITTEXT MODAL MAX
			//
			// Text field for "Max"
			/////////////////////////////////////
			//VERIFIED - TAB 6 - ELEMENT (3/8)
			/////////////////////////////////////
			//[] JORDAN KUROSKY
			//[] JAMIE POSPIECH
			//[] DEREK ELLIOTT
			//[X] PIERRE LAFOREST-GRANT
			//[X] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextMax = (EditText) convertView.findViewById(R.id.earthmat_surficial_editText_clastMax);
			editTextMax.setText(earthmatSurficialEntity.getClastMax());
			editTextMax.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						earthmatSurficialEntity.setClastMax("");
					else
						earthmatSurficialEntity.setClastMax(s.toString());
				}
			});
			
			
			
			/////////////////////////////////////
			// EDITTEXT CLAST PERCENT
			//
			//Text field for "Clast%"
			/////////////////////////////////////
			//VERIFIED - TAB 6 - ELEMENT (4/8)
			/////////////////////////////////////
			//[] JORDAN KUROSKY
			//[] JAMIE POSPIECH
			//[] DEREK ELLIOTT
			//[X] PIERRE LAFOREST-GRANT
			//[X] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextClastPer = (EditText) convertView.findViewById(R.id.earthmat_surficial_editText_clastPer);
			editTextClastPer.setText(earthmatSurficialEntity.getClastPct());
			editTextClastPer.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						earthmatSurficialEntity.setClastPct("");
					else
						earthmatSurficialEntity.setClastPct(s.toString());
				}
			});

			
			/////////////////////////////////////
			// SPINNER CLAST FORMS
			//
			// Drop-down for "Clast Forms" - Column 1 of lutSUREarthmatClastform Picklist
			/////////////////////////////////////
			//VERIFIED - TAB 6 - ELEMENT (5/8)
			/////////////////////////////////////
			//[] JORDAN KUROSKY
			//[] JAMIE POSPIECH
			//[] DEREK ELLIOTT
			//[X] PIERRE LAFOREST-GRANT
			//[X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerClastForms = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_clastForms);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutSUREarthmatClastform"));
			sp1.setNewElement(pldb, "lutSUREarthmatClastform", 1, null, null);
			sp1.addSpace();
			spinnerClastForms.setAdapter(sp1);
			spinnerClastForms.setSelection(sp1.getPosition(earthmatSurficialEntity.getClastForm()));
			spinnerClastForms.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {}
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setClastForm(parent.getItemAtPosition(position).toString());
				}
			});
			
			/////////////////////////////////////
			// SPINNER MODAL ROUND
			//
			// Drop-down for "Average/Modal" - Column 1 of lutSUREarthmatRoundness Picklist
			/////////////////////////////////////
			//VERIFIED - TAB 6 - ELEMENT (6/8)
			/////////////////////////////////////
			//[] JORDAN KUROSKY
			//[] JAMIE POSPIECH
			//[] DEREK ELLIOTT
			//[X] PIERRE LAFOREST-GRANT
			//[X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerAverageModal = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_averageModal);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp2.setElements(pldb.getCol1("lutSUREarthmatRoundness"));
			sp2.setNewElement(pldb, "lutSUREarthmatRoundness", 1, null, null);
			sp2.addSpace();
			spinnerAverageModal.setAdapter(sp2);
			spinnerAverageModal.setSelection(sp2.getPosition(earthmatSurficialEntity.getModalRnd()));
			spinnerAverageModal.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {}
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setModalRnd(parent.getItemAtPosition(position).toString());
				}
			});
			
			/////////////////////////////////////
			// SPINNER MAX ROUNDESS
			//
			// Drop-down for "Maximum" - Column 1 of lutSUREarthmatRoundness Picklist
			/////////////////////////////////////
			//VERIFIED - TAB 6 - ELEMENT (7/8)
			/////////////////////////////////////
			//[] JORDAN KUROSKY
			//[] JAMIE POSPIECH
			//[] DEREK ELLIOTT
			//[X] PIERRE LAFOREST-GRANT
			//[X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerMaximum = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_roundMax);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp3.setElements(pldb.getCol1("lutSUREarthmatRoundness"));
			sp3.setNewElement(pldb, "lutSUREarthmatRoundness", 1, null, null);
			sp3.addSpace();
			spinnerMaximum.setAdapter(sp3);
			spinnerMaximum.setSelection(sp3.getPosition(earthmatSurficialEntity.getMaxRound()));
			spinnerMaximum.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setMaxRound(parent.getItemAtPosition(position).toString());
				}
			});
			
			/////////////////////////////////////
			// SPINNER MIN ROUNDNESS
			//
			// Drop-down for "Minimum" - Column 1 of lutSUREarthmatRoundness Picklist
			/////////////////////////////////////
			//VERIFIED - TAB 6 - ELEMENT (8/8)
			/////////////////////////////////////
			//[] JORDAN KUROSKY
			//[] JAMIE POSPIECH
			//[] DEREK ELLIOTT
			//[X] PIERRE LAFOREST-GRANT
			//[X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerMinimum = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_roundMin);
			SpinnerController sp4 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp4.setElements(pldb.getCol1("lutSUREarthmatRoundness"));
			sp4.setNewElement(pldb, "lutSUREarthmatRoundness", 1, null, null);
			sp4.addSpace();
			spinnerMinimum.setAdapter(sp4);
			spinnerMinimum.setSelection(sp4.getPosition(earthmatSurficialEntity.getMinRound()));
			spinnerMinimum.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {}
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setMinRound(parent.getItemAtPosition(position).toString());
				}
			});
			
		} else if (tab == 7) {
			convertView = mInflater.inflate(R.layout.earthmat_surficial7, null);

			/////////////////////////////////////
			// PERCENT SPINNER ERRATIC
			//
			// Drop-down for "Erratic Type" - Column 1 of lutSUREarthmatErratictyp Picklist
			/////////////////////////////////////
			//VERIFIED - TAB 7 - ELEMENT (1/7)
			/////////////////////////////////////
			//[] JORDAN KUROSKY
			//[] JAMIE POSPIECH
			//[] DEREK ELLIOTT
			//[X] PIERRE LAFOREST-GRANT
			//[X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerErratic = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_erraticType);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutSUREarthmatErratictyp"));
			sp1.setNewElement(pldb, "lutSUREarthmatErratictyp", 1, null, null);
			sp1.addSpace();
			spinnerErratic.setAdapter(sp1);
			spinnerErratic.setEnabled(erratic1Boolean);
			spinnerErratic.setSelection(sp1.getPosition(erraticTmp));
			spinnerErratic.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {}
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					String tmp = parent.getItemAtPosition(position).toString();
					if(!tmp.equalsIgnoreCase("") && !tmp.equalsIgnoreCase(erraticTmp))
					{
						erraticTmp = tmp;
						erratic1Boolean = false;
						erratic2Boolean = true;
						notifyDataSetChanged();
					}
				}
			});
			
			
			/////////////////////////////////////
			// PERCENT SPINNER ERRATIC%
			//
			// Drop-down for "%" - Column 1 of lutSURGeneralPercent5incr Picklist
			/////////////////////////////////////
			//VERIFIED - TAB 7 - ELEMENT (2/7)
			/////////////////////////////////////
			//[] JORDAN KUROSKY
			//[] JAMIE POSPIECH
			//[] DEREK ELLIOTT
			//[X] PIERRE LAFOREST-GRANT
			//[X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerErraticPer = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_erraticPer);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp2.setElements(pldb.getCol1("lutSURGeneralPercent5incr"));
			sp2.setNewElement(pldb, "lutSURGeneralPercent5incr", 1, null, null);
			spinnerErraticPer.setAdapter(sp2);
			spinnerErraticPer.setEnabled(erratic2Boolean);
			spinnerErraticPer.setSelection(sp2.getPosition(earthmatSurficialEntity.getErraticPer()));
			spinnerErraticPer.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {}
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatSurficialEntity.setErraticPer(parent.getItemAtPosition(position).toString());
					String tmp = earthmatSurficialEntity.getErraticTyp();
					String sel = parent.getItemAtPosition(position).toString();

					if(!sel.equalsIgnoreCase(""))
					{
						if(tmp.length() > 1)
							earthmatSurficialEntity.setErraticTyp(tmp + " | " + erraticTmp + " - " + sel);
						else
							earthmatSurficialEntity.setErraticTyp(erraticTmp + " - " + sel);

						erraticTmp = "";
						erratic1Boolean = true;
						erratic2Boolean = false;
						notifyDataSetChanged();
					}
					
				}
			});
			
			/////////////////////////////////////
			// CONCAT EDITTEXT ERRATIC%
			//
			// Text field concatenates selections from SPINNER ERRATIC and SPINNER ERRATIC%
			/////////////////////////////////////
			//VERIFIED - TAB 7 - ELEMENT (3/7)
			/////////////////////////////////////
			//[] JORDAN KUROSKY
			//[] JAMIE POSPIECH
			//[] DEREK ELLIOTT
			//[X] PIERRE LAFOREST-GRANT
			//[X] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextErraticComp = (EditText) convertView.findViewById(R.id.earthmat_surficial_editText_erraticComp);
			editTextErraticComp.setText(earthmatSurficialEntity.getErraticTyp());
			editTextErraticComp.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						earthmatSurficialEntity.setErraticTyp("");
					else
						earthmatSurficialEntity.setClastModal(s.toString());
				}
			});
			
			/////////////////////////////////////
			// PERCENT BUTTON ERRATIC CLEAR
			//
			// Button clears EDITTEXT ERRATIC% text field
			/////////////////////////////////////
			//VERIFIED - TAB 7 - ELEMENT (4/7)
			/////////////////////////////////////
			//[] JORDAN KUROSKY
			//[] JAMIE POSPIECH
			//[] DEREK ELLIOTT
			//[X] PIERRE LAFOREST-GRANT
			//[X] ALEX YEUNG
			/////////////////////////////////////
			Button buttonErraticClear = (Button) convertView.findViewById(R.id.earthmat_surficial_button_erraticClear);
			buttonErraticClear.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					earthmatSurficialEntity.setErraticTyp("");
					notifyDataSetChanged();
				}
			});
			
			/////////////////////////////////////
			// SPINNER LANDFORM
			//
			// Drop-down for "Landform" - Column 1 of lutSUREarthmatLandform Picklist
			/////////////////////////////////////
			//VERIFIED - TAB 7 - ELEMENT (5/7)
			/////////////////////////////////////
			//[] JORDAN KUROSKY
			//[] JAMIE POSPIECH
			//[] DEREK ELLIOTT
			//[X] PIERRE LAFOREST-GRANT
			//[X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerLandForm = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_landForm);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp3.setElements(pldb.getCol1("lutSUREarthmatLandform"));
			sp3.setNewElement(pldb, "lutSUREarthmatLandform", 1, null, null);
			sp3.addSpace();
			spinnerLandForm.setAdapter(sp3);
			spinnerLandForm.setSelection(sp3.getPosition(earthmatSurficialEntity.getLandForm()));
			spinnerLandForm.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {}
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setLandForm(parent.getItemAtPosition(position).toString());
				}
			});
			
			/////////////////////////////////////
			//EDITTEXT INTERPRETATION
			//
			// Text field for "Interpretation"
			/////////////////////////////////////
			//VERIFIED - TAB 7 - ELEMENT (6/7)
			/////////////////////////////////////
			//[] JORDAN KUROSKY
			//[] JAMIE POSPIECH
			//[] DEREK ELLIOTT
			//[X] PIERRE LAFOREST-GRANT
			//[X] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextInterpretation = (EditText) convertView.findViewById(R.id.earthmat_surficial_editText_interpretation);
			editTextInterpretation.setText(earthmatSurficialEntity.getInterp());
			editTextInterpretation.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						earthmatSurficialEntity.setInterp("");
					else
						earthmatSurficialEntity.setInterp(s.toString());
				}
			});
			
			/////////////////////////////////////
			// SPINNER INTERP CONFIDENCE
			//
			// Drop-down for "Interpretation Confidence" - Column 1 of lutSUREarthmatInterpconf Picklist
			/////////////////////////////////////
			//VERIFIED - TAB 7 - ELEMENT (7/7)
			/////////////////////////////////////
			//[] JORDAN KUROSKY
			//[] JAMIE POSPIECH
			//[] DEREK ELLIOTT
			//[X] PIERRE LAFOREST-GRANT
			//[X] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerInterpConfidence = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_interpConf);
			SpinnerController sp4 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp4.setElements(pldb.getCol1("lutSUREarthmatInterpconf"));
			sp4.setNewElement(pldb, "lutSUREarthmatInterpconf", 1, null, null);
			sp4.addSpace();
			spinnerInterpConfidence.setAdapter(sp4);
			spinnerInterpConfidence.setSelection(sp4.getPosition(earthmatSurficialEntity.getInterpConf()));
			spinnerInterpConfidence.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {}
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setInterpConf(parent.getItemAtPosition(position).toString());
				}
			});
			
			
			
		} else if (tab == 8) {
			convertView = mInflater.inflate(R.layout.earthmat_surficial8, null);
			
			/////////////////////////////////////
			// EDITTEXT NOTES
			//
			// Text field for "Notes"
			/////////////////////////////////////
			//VERIFIED - TAB 8 - ELEMENT (1/1)
			/////////////////////////////////////
			//[] JORDAN KUROSKY
			//[] JAMIE POSPIECH
			//[] DEREK ELLIOTT
			//[X] PIERRE LAFOREST-GRANT
			//[X] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextNotes = (EditText) convertView	.findViewById(R.id.earthmat_surficial_editText_notes);
			editTextNotes.setText(earthmatSurficialEntity.getNotes());
			editTextNotes.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						earthmatSurficialEntity.setNotes("");
					else
						earthmatSurficialEntity.setNotes(s.toString());
				}
			});
			
		}

		return convertView;
	}

	public Filter getFilter() {
		return null;
	}

	public boolean setTab(int tabNum) {
		if(this.tab == 1){
			if(earthmatSurficialEntity.getLithGroup().equalsIgnoreCase("")){
				return false;
			}
			
		}
		this.tab = tabNum;
		notifyDataSetChanged();
		return true;
	}

	public void clear() {
		earthmatSurficialEntity.clearEntity();
		tab = 1;
		notifyDataSetChanged();
		erratic1Boolean = true;
		erratic2Boolean = false;
	}
	

}
