package com.nrcan.controllers;

import com.nrcan.entities.EarthmatBedrockEntity;
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
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.Spinner;

public class EarthmatBedrockController extends BaseAdapter implements Filterable {
	private LayoutInflater mInflater;
	//private Activity activity;
	private Context context;
	private int tab;
	private EarthmatBedrockEntity earthmatBedrockEntity;
	private PicklistDatabaseHandler pldb;

	public EarthmatBedrockController(Context context, Activity activity, EarthmatBedrockEntity earthmatBedrockEntity, PicklistDatabaseHandler pldb) {
		this.mInflater = LayoutInflater.from(context);
		//this.activity = activity;
		this.context = context;
		this.tab = 1;
		this.earthmatBedrockEntity = earthmatBedrockEntity;
		this.pldb = pldb;
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
			convertView = mInflater.inflate(R.layout.earthmat_bedrock1, null);
			
			/////////////////////////////////////
			// SPINNER LITH GROUP
			//
			// Drop-down for "Group" - Column 1 of lutBEDEarthmatRocktype Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (1/5)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerGroup = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_group);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutBEDEarthmatRocktype"));
			sp1.setNewElement(pldb, "lutBEDEarthmatRocktype", 1, null, null);
			sp1.addSpace();
			spinnerGroup.setAdapter(sp1);
			spinnerGroup.setSelection(sp1.getPosition(earthmatBedrockEntity.getLithGroup()));
			spinnerGroup.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					String tmp = parent.getItemAtPosition(position).toString();
					if(!tmp.equalsIgnoreCase(earthmatBedrockEntity.getLithGroup()))
					{
						earthmatBedrockEntity.setLithGroup(tmp);
						earthmatBedrockEntity.setLithType("");
						earthmatBedrockEntity.setLithDetail("");
						earthmatBedrockEntity.setOccurAs("");
						notifyDataSetChanged();
					}
				}
			});

			/////////////////////////////////////
			// SPINNER LITH TYPE
			//
			// Drop-down for "Type" - Column 2 of lutBEDEarthmatRocktype Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (2/5)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerType = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_type);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp2.setElements(pldb.getCol2("lutBEDEarthmatRocktype", earthmatBedrockEntity.getLithGroup()));
			sp2.setNewElement(pldb, "lutBEDEarthmatRocktype", 2, earthmatBedrockEntity.getLithGroup(), null);
			spinnerType.setAdapter(sp2);
			spinnerType.setSelection(sp2.getPosition(earthmatBedrockEntity.getLithType()));
			spinnerType.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					String tmp = parent.getItemAtPosition(position).toString();
					if(!tmp.equalsIgnoreCase(earthmatBedrockEntity.getLithType()))
					{
						earthmatBedrockEntity.setLithType(tmp);
						earthmatBedrockEntity.setLithDetail("");
						notifyDataSetChanged();
					}
				}
			});

			/////////////////////////////////////
			// SPINNER LITH DETAIL
			//
			// Drop-down for "Detail" - Column 3 of lutBEDEarthmatRocktype Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (3/5)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerDetail = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_detail);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp3.setElements(pldb.getCol3("lutBEDEarthmatRocktype", earthmatBedrockEntity.getLithGroup(), earthmatBedrockEntity.getLithType()));
			sp3.setNewElement(pldb, "lutBEDEarthmatRocktype", 3, earthmatBedrockEntity.getLithGroup(), earthmatBedrockEntity.getLithType());
			spinnerDetail.setAdapter(sp3);
			spinnerDetail.setSelection(sp3.getPosition(earthmatBedrockEntity.getLithDetail()));
			spinnerDetail.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatBedrockEntity.setLithDetail(parent.getItemAtPosition(position).toString());
				}
			});

			/////////////////////////////////////
			// SPINNER MAP UNIT
			//
			// Drop-down for "Unit" - Column 1 of lutBEDEarthmatMapUnit Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (4/5)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerUnit = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_unit);
			SpinnerController sp4 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp4.setElements(pldb.getCol1("lutBEDEarthmatMapUnit"));
			sp4.setNewElement(pldb, "lutBEDEarthmatMapUnit", 1, null, null);
			sp4.addSpace();
			spinnerUnit.setAdapter(sp4);
			spinnerUnit.setSelection(sp4.getPosition(earthmatBedrockEntity.getMapUnit()));
			spinnerUnit.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatBedrockEntity.setMapUnit(parent.getItemAtPosition(position).toString());
				}
			});

			/////////////////////////////////////
			// SPINNER OCCURS AS
			//
			// Drop-down for "Occurs As" - Column 2 of lutBEDEarthmatOccurs Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 1 - ELEMENT (5/5)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerOccurs = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_occursAs);
			SpinnerController sp5 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp5.setElements(pldb.getCol2("lutBEDEarthmatOccurs", earthmatBedrockEntity.getLithGroup()));
			sp5.setNewElement(pldb, "lutBEDEarthmatOccurs", 2, earthmatBedrockEntity.getLithGroup(), null);
			spinnerOccurs.setAdapter(sp5);
			spinnerOccurs.setSelection(sp5.getPosition(earthmatBedrockEntity.getOccurAs()));
			spinnerOccurs.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatBedrockEntity.setOccurAs(parent.getItemAtPosition(position).toString());
				}
			});

		} else if (tab == 2) {
			convertView = mInflater.inflate(R.layout.earthmat_bedrock2, null);

			/////////////////////////////////////
			// CONCAT SPINNER MOD STRUCT
			//
			// Drop-down for "Structure" - Column 2 of lutBEDEarthmatStructural Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 2 - ELEMENT (1/9)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerStructure = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_structure);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol2("lutBEDEarthmatStructural", earthmatBedrockEntity.getLithGroup()));
			sp1.setNewElement(pldb, "lutBEDEarthmatStructural", 2, earthmatBedrockEntity.getLithGroup(), null);
			sp1.addSpace();
			spinnerStructure.setAdapter(sp1);
			spinnerStructure.setSelection(sp1.getPosition(earthmatBedrockEntity.getModStruc()));
			spinnerStructure.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					String tmp = earthmatBedrockEntity.getModStruc();
					String sel = parent.getItemAtPosition(position).toString();
					if(!tmp.contains(sel))
					{
						if(tmp.length() > 1)
							earthmatBedrockEntity.setModStruc(tmp + " | " + sel);
						else
							earthmatBedrockEntity.setModStruc(sel);

						notifyDataSetChanged();
					}
				}
			});

			/////////////////////////////////////
			// CONCAT EDITTEXT MOD STRUCT
			//
			// Text field concatenates selections from SPINNER MOD STRUCT
			/////////////////////////////////////
			// VERIFIED - TAB 2 - ELEMENT (2/9)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextStructure = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_structure);
			editTextStructure.setText(earthmatBedrockEntity.getModStruc());
			editTextStructure.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						earthmatBedrockEntity.setModStruc("");
					else
						earthmatBedrockEntity.setModStruc(s.toString());
				}
			});

			/////////////////////////////////////
			// CONCAT BUTTON MOD STRUCT
			//
			// Button clears EDITTEXT MOD STRUCT text field
			/////////////////////////////////////
			// VERIFIED - TAB 2 - ELEMENT (3/9)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Button buttonStructure = (Button) convertView.findViewById(R.id.earthmat_bedrock_button_structure);
			buttonStructure.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					earthmatBedrockEntity.setModStruc("");
					notifyDataSetChanged();
				}
			});

			/////////////////////////////////////
			// CONCAT SPINNER MOD TEXTURE
			//
			// Drop-down for "Texture" - Column 2 of lutBEDEarthmatTextural Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 2 - ELEMENT (4/9)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerTexture = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_texture);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp2.setElements(pldb.getCol2("lutBEDEarthmatTextural", earthmatBedrockEntity.getLithGroup()));
			sp2.setNewElement(pldb, "lutBEDEarthmatTextural", 2, earthmatBedrockEntity.getLithGroup(), null);
			spinnerTexture.setAdapter(sp2);
			spinnerTexture.setSelection(sp2.getPosition(earthmatBedrockEntity.getModTexture()));
			spinnerTexture.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					String tmp = earthmatBedrockEntity.getModTexture();
					String sel = parent.getItemAtPosition(position).toString();
					if(!tmp.contains(sel))
					{
						if(tmp.length() > 1)
							earthmatBedrockEntity.setModTexture(tmp + " | " + sel);
						else
							earthmatBedrockEntity.setModTexture(sel);

						notifyDataSetChanged();
					}
				}
			});

			/////////////////////////////////////
			// CONCAT EDITTEXT MOD TEXTURE
			//
			// Text field concatenates selections from SPINNER MOD TEXTURE
			/////////////////////////////////////
			// VERIFIED - TAB 2 - ELEMENT (5/9)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextTexture = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_texture);
			editTextTexture.setText(earthmatBedrockEntity.getModTexture());
			editTextTexture.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						earthmatBedrockEntity.setModTexture("");
					else
						earthmatBedrockEntity.setModTexture(s.toString());
				}
			});

			/////////////////////////////////////
			// CONCAT BUTTON MOD TEXTURE
			//
			// Button clears EDITTEXT MOD TEXTURE text field
			/////////////////////////////////////
			// VERIFIED - TAB 2 - ELEMENT (6/9)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Button buttonTexture = (Button) convertView.findViewById(R.id.earthmat_bedrock_button_texture);
			buttonTexture.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					earthmatBedrockEntity.setModTexture("");
					notifyDataSetChanged();
				}
			});

			/////////////////////////////////////
			// CONCAT SPINNER MOD COMPOSITION
			//
			// Drop-down for "Composition" - Column 2 of lutBEDEarthmatComposition Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 2 - ELEMENT (7/9)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerComposition = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_composition);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp3.setElements(pldb.getCol2("lutBEDEarthmatComposition", earthmatBedrockEntity.getLithGroup()));
			sp3.setNewElement(pldb, "lutBEDEarthmatComposition", 2, earthmatBedrockEntity.getLithGroup(), null);
			spinnerComposition.setAdapter(sp3);
			spinnerComposition.setSelection(sp3.getPosition(earthmatBedrockEntity.getModComp()));
			spinnerComposition.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					String tmp = earthmatBedrockEntity.getModComp();
					String sel = parent.getItemAtPosition(position).toString();
					if(!tmp.contains(sel))
					{
						if(tmp.length() > 1)
							earthmatBedrockEntity.setModComp(tmp + " | " + sel);
						else
							earthmatBedrockEntity.setModComp(sel);

						notifyDataSetChanged();
					}
				}
			});

			/////////////////////////////////////
			// CONCAT EDITTEXT MOD COMPOSITION
			//
			// Text field concatenates selections from SPINNER MOD COMPOSITION
			/////////////////////////////////////
			// VERIFIED - TAB 2 - ELEMENT (8/9)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextComposition = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_composition);
			editTextComposition.setText(earthmatBedrockEntity.getModComp());
			editTextComposition.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						earthmatBedrockEntity.setModComp("");
					else
						earthmatBedrockEntity.setModComp(s.toString());
				}
			});

			/////////////////////////////////////
			// CONCAT BUTTON MOD COMPOSITION
			//
			// Button clears EDITTEXT MOD COMPOSITION text field
			/////////////////////////////////////
			// VERIFIED - TAB 2 - ELEMENT (9/9)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Button buttonComposition = (Button) convertView.findViewById(R.id.earthmat_bedrock_button_composition);
			buttonComposition.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					earthmatBedrockEntity.setModComp("");
					notifyDataSetChanged();
				}
			});

		} else if (tab == 3) {
			convertView = mInflater.inflate(R.layout.earthmat_bedrock3, null);

			/////////////////////////////////////
			// CONCAT SPINNER GRN/CRY
			//
			// Drop-down for "Grn/Cry" - Column 2 of lutBEDEarthmatGCSize Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 3 - ELEMENT (1/9)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerGrnCry = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_grnCry);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol2("lutBEDEarthmatGCSize",earthmatBedrockEntity.getLithGroup()));
			sp1.setNewElement(pldb, "lutBEDEarthmatGCSize", 2, earthmatBedrockEntity.getLithGroup(), null);
			spinnerGrnCry.setAdapter(sp1);
			spinnerGrnCry.setSelection(sp1.getPosition(earthmatBedrockEntity.getGrcrySize()));
			spinnerGrnCry.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					String tmp = earthmatBedrockEntity.getGrcrySize();
					String sel = parent.getItemAtPosition(position).toString();
					if(!tmp.contains(sel))
					{
						if(tmp.length() > 1)
							earthmatBedrockEntity.setGrcrySize(tmp + " | " + sel);
						else
							earthmatBedrockEntity.setGrcrySize(sel);

						notifyDataSetChanged();
					}
				}
			});

			/////////////////////////////////////
			// CONCAT EDITTEXT GRN/CRY
			//
			// Text field concatenates selections from SPINNER GRN/CRY
			/////////////////////////////////////
			// VERIFIED - TAB 3 - ELEMENT (2/9)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextGrnCry = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_grnCry);
			editTextGrnCry.setText(earthmatBedrockEntity.getGrcrySize());
			editTextGrnCry.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						earthmatBedrockEntity.setGrcrySize("");
					else
						earthmatBedrockEntity.setGrcrySize(s.toString());
				}
			});

			/////////////////////////////////////
			// CONCAT BUTTON GRN/CRY
			//
			// Button clears EDITTEXT GRN/CRY text field
			/////////////////////////////////////
			// VERIFIED - TAB 3 - ELEMENT (3/9)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Button buttonGrnCry = (Button) convertView.findViewById(R.id.earthmat_bedrock_button_grnCry);
			buttonGrnCry.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					earthmatBedrockEntity.setGrcrySize("");
					notifyDataSetChanged();
				}
			});

			/////////////////////////////////////
			// CONCAT SPINNER DEF/FABRIC
			//
			// Drop-down for "Def fabric" - Column 1 of lutBEDEarthmatDeffabric Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 3 - ELEMENT (4/9)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerDefFabric = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_defFabric);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp2.setElements(pldb.getCol1("lutBEDEarthmatDeffabric"));
			sp2.setNewElement(pldb, "lutBEDEarthmatDeffabric", 1, null, null);
			sp2.addSpace();
			spinnerDefFabric.setAdapter(sp2);
			spinnerDefFabric.setSelection(sp2.getPosition(earthmatBedrockEntity.getDefFabric()));
			spinnerDefFabric.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					String tmp = earthmatBedrockEntity.getDefFabric();
					String sel = parent.getItemAtPosition(position).toString();
					if(!tmp.contains(sel))
					{
						if(tmp.length() > 1)
							earthmatBedrockEntity.setDefFabric(tmp + " | " + sel);
						else
							earthmatBedrockEntity.setDefFabric(sel);

						notifyDataSetChanged();
					}	
				}
			});

			/////////////////////////////////////
			// CONCAT EDITTEXT DEF FABRIC
			//
			// Text field concatenates selections from SPINNER DEF FABRIC
			/////////////////////////////////////
			// VERIFIED - TAB 3 - ELEMENT (5/9)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextDefFabric = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_defFabric);
			editTextDefFabric.setText(earthmatBedrockEntity.getDefFabric());
			editTextDefFabric.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						earthmatBedrockEntity.setDefFabric("");
					else
						earthmatBedrockEntity.setDefFabric(s.toString());
				}
			});

			/////////////////////////////////////
			// CONCAT BUTTON DEF FABRIC
			//
			// Button clears EDITTEXT DEF FABRIC text field
			/////////////////////////////////////
			// VERIFIED - TAB 3 - ELEMENT (6/9)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Button buttonDefFabric = (Button) convertView.findViewById(R.id.earthmat_bedrock_button_defFabric);
			buttonDefFabric.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					earthmatBedrockEntity.setDefFabric("");
					notifyDataSetChanged();
				}
			});

			/////////////////////////////////////
			// CONCAT SPINNER BED THICK
			//
			// Drop-down for "Bed Thick" - Column 1 of lutBEDEarthmatBedthick Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 3 - ELEMENT (7/9)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerBedThick = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_bedThick);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp3.setElements(pldb.getCol1("lutBEDEarthmatBedthick"));
			sp3.setNewElement(pldb, "lutBEDEarthmatBedthick", 1, null, null);
			sp3.addSpace();
			spinnerBedThick.setAdapter(sp3);
			spinnerBedThick.setSelection(sp3.getPosition(earthmatBedrockEntity.getBedThick()));
			spinnerBedThick.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					String tmp = earthmatBedrockEntity.getBedThick();
					String sel = parent.getItemAtPosition(position).toString();
					if(!tmp.contains(sel))
					{
						if(tmp.length() > 1)
							earthmatBedrockEntity.setBedThick(tmp + " | " + sel);
						else
							earthmatBedrockEntity.setBedThick(sel);

						notifyDataSetChanged();
					}	
				}
			});

			/////////////////////////////////////
			// CONCAT EDITTEXT BED THICK
			//
			// Text field concatenates selections from SPINNER BED THICK
			/////////////////////////////////////
			// VERIFIED - TAB 3 - ELEMENT (8/9)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextBedThick = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_bedThick);
			editTextBedThick.setText(earthmatBedrockEntity.getBedThick());
			editTextBedThick.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						earthmatBedrockEntity.setBedThick("");
					else
						earthmatBedrockEntity.setBedThick(s.toString());
				}
			});

			/////////////////////////////////////
			// CONCAT BUTTON BED THICK
			//
			// Button clears EDITTEXT BED THICK text field
			/////////////////////////////////////
			// VERIFIED - TAB 3 - ELEMENT (9/9)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Button buttonBedThick = (Button) convertView.findViewById(R.id.earthmat_bedrock_button_bedThick);
			buttonBedThick.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					earthmatBedrockEntity.setBedThick("");
					notifyDataSetChanged();
				}
			});

		} else if (tab == 4) {
			convertView = mInflater.inflate(R.layout.earthmat_bedrock4, null);

			/////////////////////////////////////
			// CONCAT SPINNER MINERAL
			//
			// Drop-down for "Mineral" - Column 1 of lutBEDEarthmatMineral Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 4 - ELEMENT (1/4)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerMineral = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_mineral);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutBEDEarthmatMineral"));
			sp1.setNewElement(pldb, "lutBEDEarthmatMineral", 1, null, null);
			sp1.addSpace();
			spinnerMineral.setAdapter(sp1);
			spinnerMineral.setSelection(sp1.getPosition(earthmatBedrockEntity.getMineral()));
			spinnerMineral.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					String tmp = earthmatBedrockEntity.getMineral();
					String sel = parent.getItemAtPosition(position).toString();
					if(!tmp.contains(sel))
					{
						if(tmp.length() > 1)
							earthmatBedrockEntity.setMineral(tmp + " | " + sel);
						else
							earthmatBedrockEntity.setMineral(sel);

						notifyDataSetChanged();
					}	
				}
			});

			/////////////////////////////////////
			// CONCAT EDITTEXT MINERAL
			//
			// Text field concatenates selections from SPINNER MINERAL
			/////////////////////////////////////
			// VERIFIED - TAB 4 - ELEMENT (2/4)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextMineral = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_mineral);
			editTextMineral.setText(earthmatBedrockEntity.getMineral());
			editTextMineral.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						earthmatBedrockEntity.setMineral("");
					else
						earthmatBedrockEntity.setMineral(s.toString());
				}
			});

			/////////////////////////////////////
			// CONCAT BUTTON MINERAL 
			//
			// Button clears EDITTEXT MINERAL text field
			/////////////////////////////////////
			// VERIFIED - TAB 4 - ELEMENT (3/4)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Button buttonClear = (Button) convertView.findViewById(R.id.earthmat_bedrock_button_mineral);
			buttonClear.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					earthmatBedrockEntity.setMineral("");
					notifyDataSetChanged();
				}
			});

			/////////////////////////////////////
			// EDITTEXT MINERAL DESC (254)
			//
			// Text field for description of selected mineral(s)
			/////////////////////////////////////
			// VERIFIED - TAB 4 - ELEMENT (4/4)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextRockDescription = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_rockDescription);
			editTextRockDescription.setText(earthmatBedrockEntity.getMinNote());
			editTextRockDescription.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						earthmatBedrockEntity.setMinNote("");
					else
						earthmatBedrockEntity.setMinNote(s.toString());
				}
			});

		} else if (tab == 5) {
			convertView = mInflater.inflate(R.layout.earthmat_bedrock5, null);

			/////////////////////////////////////
			// SPINNER COLOUR FRESH
			//
			// Drop-down for "Colour Fresh" - Column 1 of lutBEDEarthmatColour Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 5 - ELEMENT (1/4)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerFresh = (Spinner) convertView.findViewById(R.id.earthmat_spinner_fresh);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutBEDEarthmatColour"));
			sp1.setNewElement(pldb, "lutBEDEarthmatColour", 1, null, null);
			sp1.addSpace();
			spinnerFresh.setAdapter(sp1);
			spinnerFresh.setSelection(sp1.getPosition(earthmatBedrockEntity.getColourF()));
			spinnerFresh.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatBedrockEntity.setColourF(parent.getItemAtPosition(position).toString());
				}
			});

			/////////////////////////////////////
			// SPINNER COLOUR WEATHERED
			//
			// Drop-down for "Colour Weathered" - Column 1 of lutBEDEarthmatColour Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 5 - ELEMENT (2/4)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerWeathered = (Spinner) convertView.findViewById(R.id.earthmat_spinner_weathered);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp2.setElements(pldb.getCol1("lutBEDEarthmatColour"));
			sp2.setNewElement(pldb, "lutBEDEarthmatColour", 1, null, null);
			sp2.addSpace();
			spinnerWeathered.setAdapter(sp2);
			spinnerWeathered.setSelection(sp2.getPosition(earthmatBedrockEntity.getColourW()));
			spinnerWeathered.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatBedrockEntity.setColourW(parent.getItemAtPosition(position).toString());
				}
			});

			/////////////////////////////////////
			// EDITTEXT INDEX
			//
			// Text field for colour index
			/////////////////////////////////////
			// VERIFIED - TAB 5 - ELEMENT (3/4)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextIndex = (EditText) convertView.findViewById(R.id.earthmat_editText_index);
			editTextIndex.setText(earthmatBedrockEntity.getColourInd());
			editTextIndex.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						earthmatBedrockEntity.setColourInd("");
					else
						earthmatBedrockEntity.setColourInd(s.toString());
				}
			});

			/////////////////////////////////////
			// EDITTEXT MAG SUSCEPTIBILITY
			//
			// Text field for mag susceptibility
			/////////////////////////////////////
			// VERIFIED - TAB 5 - ELEMENT (4/4)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextMagSus = (EditText) convertView.findViewById(R.id.earthmat_editText_magSusceptibility);
			editTextMagSus.setText(earthmatBedrockEntity.getMagSuscept());
			editTextMagSus.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						earthmatBedrockEntity.setMagSuscept("");
					else
						earthmatBedrockEntity.setMagSuscept(s.toString());
				}
			});

		} else if (tab == 6) {
			convertView = mInflater.inflate(R.layout.earthmat_bedrock6, null);

			/////////////////////////////////////
			// CONCAT SPINNER FOSSIL
			//
			// Drop-down for "Fossil" - Column 1 of lutBEDEarthmatFossil Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 6 - ELEMENT (1/4)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerFossil = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_fossil);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutBEDEarthmatFossil"));
			sp1.setNewElement(pldb, "lutBEDEarthmatFossil", 1, null, null);
			sp1.addSpace();
			spinnerFossil.setAdapter(sp1);
			spinnerFossil.setSelection(sp1.getPosition(earthmatBedrockEntity.getFossils()));
			spinnerFossil.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					String tmp = earthmatBedrockEntity.getFossils();
					String sel = parent.getItemAtPosition(position).toString();
					if(!tmp.contains(sel))
					{
						if(tmp.length() > 1)
							earthmatBedrockEntity.setFossils(tmp + " | " + sel);
						else
							earthmatBedrockEntity.setFossils(sel);

						notifyDataSetChanged();
					}
				}
			});

			/////////////////////////////////////
			// CONCAT EDITTEXT FOSSIL
			//
			// Text field concatenates selections from SPINNER FOSSIL
			/////////////////////////////////////
			// VERIFIED - TAB 6 - ELEMENT (2/4)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextFossil = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_fossil);
			editTextFossil.setText(earthmatBedrockEntity.getFossils());
			editTextFossil.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						earthmatBedrockEntity.setFossils("");
					else
						earthmatBedrockEntity.setFossils(s.toString());
				}
			});

			/////////////////////////////////////
			// CONCAT BUTTON FOSSIL
			//
			// Button clears EDITTEXT FOSSIL text field
			/////////////////////////////////////
			// VERIFIED - TAB 6 - ELEMENT (3/4)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Button buttonFossil = (Button) convertView.findViewById(R.id.earthmat_bedrock_button_fossil);
			buttonFossil.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					earthmatBedrockEntity.setFossils("");
					notifyDataSetChanged();
				}
			});

			/////////////////////////////////////
			// EDITTEXT FOSSIL DESC (254)
			//
			// Text field for description of selected fossil(s)
			/////////////////////////////////////
			// VERIFIED - TAB 6 - ELEMENT (4/4)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextFossilDescription = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_rockDescription);
			editTextFossilDescription.setText(earthmatBedrockEntity.getFossilNote());
			editTextFossilDescription.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						earthmatBedrockEntity.setFossilNote("");
					else
						earthmatBedrockEntity.setFossilNote(s.toString());
				}
			});
			
		} else if (tab == 7) {
			convertView = mInflater.inflate(R.layout.earthmat_bedrock7, null);

			/////////////////////////////////////
			// SPINNER CONTACT UPPER
			//
			// Drop-down for "Upper" - Column 1 of lutBEDEarthmatContact Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 7 - ELEMENT (1/3)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerContactUpper = (Spinner) convertView.findViewById(R.id.earthmat_spinner_upper);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutBEDEarthmatContact"));
			sp1.setNewElement(pldb, "lutBEDEarthmatContact", 1, null, null);
			sp1.addSpace();
			spinnerContactUpper.setAdapter(sp1);
			spinnerContactUpper.setSelection(sp1.getPosition(earthmatBedrockEntity.getContactUp()));
			spinnerContactUpper.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatBedrockEntity.setContactUp(parent.getItemAtPosition(position).toString());
				}
			});
			
			/////////////////////////////////////
			// SPINNER CONTACT LOWER
			//
			// Drop-down for "Lower" - Column 1 of lutBEDEarthmatContact Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 7 - ELEMENT (2/3)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerContactLower = (Spinner) convertView.findViewById(R.id.earthmat_spinner_lower);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp2.setElements(pldb.getCol1("lutBEDEarthmatContact"));
			sp2.setNewElement(pldb, "lutBEDEarthmatContact", 1, null, null);
			sp2.addSpace();
			spinnerContactLower.setAdapter(sp2);
			spinnerContactLower.setSelection(sp2.getPosition(earthmatBedrockEntity.getContactLow()));
			spinnerContactLower.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatBedrockEntity.setContactLow(parent.getItemAtPosition(position).toString());
				}
			});

			/////////////////////////////////////
			// EDITTEXT CONTACT DESC (254)
			//
			// Text field for description of selected contact(s)
			/////////////////////////////////////
			// VERIFIED - TAB 7 - ELEMENT (3/3)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextContactDescription = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_contactDescription);
			editTextContactDescription.setText(earthmatBedrockEntity.getContact());
			editTextContactDescription.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						earthmatBedrockEntity.setContact("");
					else
						earthmatBedrockEntity.setContact(s.toString());
				}
			});

		} else if (tab == 8) {
			convertView = mInflater.inflate(R.layout.earthmat_bedrock8, null);

			/////////////////////////////////////
			// EDITTEXT LITH INTERP (254)
			//
			// Text field for "Lith Interpretation"
			/////////////////////////////////////
			// VERIFIED - TAB 8 - ELEMENT (1/2)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			EditText editTextLithDescription = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_lithInterpretation);
			editTextLithDescription.setText(earthmatBedrockEntity.getInterp());
			editTextLithDescription.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						earthmatBedrockEntity.setInterp("");
					else
						earthmatBedrockEntity.setInterp(s.toString());
				}
			});
			
			/////////////////////////////////////
			// SPINNER LITH INTERP CONFIDENCE
			//
			// Drop-down for "Lith Interp Confidence" - Column 1 of lutBEDEarthmatInterpconf Picklist
			/////////////////////////////////////
			// VERIFIED - TAB 8 - ELEMENT (2/2)
			/////////////////////////////////////
			// [X] JORDAN KUROSKY
			// [] JAMIE POSPIECH
			// [] DEREK ELLIOTT
			// [X] PIERRE LAFOREST-GRANT
			// [] ALEX YEUNG
			/////////////////////////////////////
			Spinner spinnerLithInterp = (Spinner) convertView.findViewById(R.id.earthmat_spinner_lithInterpConfidence);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(pldb.getCol1("lutBEDEarthmatInterpconf"));
			sp1.setNewElement(pldb, "lutBEDEarthmatInterpconf", 1, null, null);
			sp1.addSpace();
			spinnerLithInterp.setAdapter(sp1);
			spinnerLithInterp.setSelection(sp1.getPosition(earthmatBedrockEntity.getInterpConf()));
			spinnerLithInterp.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) { }
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatBedrockEntity.setInterpConf(parent.getItemAtPosition(position).toString());
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
			if(earthmatBedrockEntity.getLithGroup().equalsIgnoreCase("")){
				return false;
			}
			if(earthmatBedrockEntity.getLithType().equalsIgnoreCase("")){
				return false;
			}
			if(earthmatBedrockEntity.getLithDetail().equalsIgnoreCase("")){
				return false;
			}
		}
		this.tab = tabNum;
		notifyDataSetChanged();
		return true;
	}
	
	public void clear() {
		earthmatBedrockEntity.clearEntity();
		tab = 1;
		notifyDataSetChanged();
	}
}
