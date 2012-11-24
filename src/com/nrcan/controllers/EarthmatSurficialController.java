package com.nrcan.controllers;

import java.util.ArrayList;


import com.nrcan.entities.EarthmatSurficialEntity;
import com.nrcan.main.PicklistDatabaseHandler;
import com.nrcan.main.R;
import com.nrcan.models.EarthmatSurficialModel;

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
	private Activity activity;
	private Context context;
	private int tab;
	private EarthmatSurficialEntity earthmatSurficialEntity;
	private PicklistDatabaseHandler pldb;

	public EarthmatSurficialController(Context context, Activity activity, EarthmatSurficialEntity earthmatSurficialEntity, PicklistDatabaseHandler pldb) {
		this.mInflater = LayoutInflater.from(context);
		this.activity = activity;
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

			Spinner spinnerGroup = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_group);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerGroup.setAdapter(sp1);
			sp1.setElements(pldb.getCol1("lutSUREarthmatLith2"));
			spinnerGroup.setAdapter(sp1);
			spinnerGroup.setSelection(sp1.getPosition(earthmatSurficialEntity.getLithGroup()));
			spinnerGroup.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					String tmp = parent.getItemAtPosition(position).toString();
					if(!tmp.equalsIgnoreCase(earthmatSurficialEntity.getLithGroup()))
					{
						earthmatSurficialEntity.setLithGroup(tmp);
						earthmatSurficialEntity.setLithType("");
						earthmatSurficialEntity.setLithDetail("");
					
						System.out.println(parent.getItemAtPosition(position));
						notifyDataSetChanged();
					}
					
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			
			Spinner spinnerType = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_type);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerType.setAdapter(sp2);
			
			sp2.setElements(pldb.getCol2("lutSUREarthmatLith2",earthmatSurficialEntity.getLithGroup()));
			spinnerType.setAdapter(sp2);
			spinnerType.setSelection(sp2.getPosition(earthmatSurficialEntity.getLithType()));
			spinnerType.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					String tmp = parent.getItemAtPosition(position).toString();
					if(!tmp.equalsIgnoreCase(earthmatSurficialEntity.getLithGroup()))
					{
						earthmatSurficialEntity.setLithType(tmp);
						earthmatSurficialEntity.setLithDetail("");
					
						System.out.println(parent.getItemAtPosition(position));
						notifyDataSetChanged();
					}
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Spinner spinnerDetail = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_detail);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerDetail.setAdapter(sp3);
			sp3.setElements(pldb.getCol3("lutSUREarthmatLith2",earthmatSurficialEntity.getLithGroup(),earthmatSurficialEntity.getLithType()));
			spinnerDetail.setAdapter(sp3);
			spinnerDetail.setSelection(sp3.getPosition(earthmatSurficialEntity.getLithDetail()));
			spinnerDetail.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setLithDetail(parent.getItemAtPosition(position).toString());
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Spinner spinnerColour = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_colour);
			SpinnerController sp4 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerColour.setAdapter(sp4);
			sp4.setElements(pldb.getCol1("lutSUREarthmatColour"));
			spinnerColour.setAdapter(sp4);
			spinnerColour.setSelection(sp4.getPosition(earthmatSurficialEntity.getColour()));
			spinnerColour.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setColour(parent.getItemAtPosition(position).toString());
					System.out.println(parent.getItemAtPosition(position));
				}
			});

			
		} else if (tab == 2) {
			
			convertView = mInflater.inflate(R.layout.earthmat_surficial2, null);

			Spinner spinnerPrimary = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_primary);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerPrimary.setAdapter(sp1);
			sp1.setElements(pldb.getCol1("lutSUREarthmatPrimestruct"));
			spinnerPrimary.setAdapter(sp1);
			spinnerPrimary.setSelection(sp1.getPosition(earthmatSurficialEntity.getPrimeStruc()));
			spinnerPrimary.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setPrimeStruc(parent.getItemAtPosition(position).toString());
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Button buttonPrimary = (Button) convertView.findViewById(R.id.earthmat_surficial_button_primary_clear);
			EditText editTextPrimary = (EditText) convertView.findViewById(R.id.earthmat_surficial_editText_primary);
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
			
			Spinner spinnerWayUp = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_wayup);
			SpinnerController sp2= new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerWayUp.setAdapter(sp2);
			sp2.setElements(pldb.getCol1("lutSUREarthmatWayup"));
			spinnerWayUp.setAdapter(sp2);
			spinnerWayUp.setSelection(sp2.getPosition(earthmatSurficialEntity.getWayUp()));
			spinnerWayUp.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setWayUp(parent.getItemAtPosition(position).toString());
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			
			Spinner spinnerSecondary = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_secondary);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerSecondary.setAdapter(sp3);
			sp3.setElements(pldb.getCol1("lutSUREarthmatScndstruct"));
			spinnerSecondary.setAdapter(sp3);
			spinnerSecondary.setSelection(sp3.getPosition(earthmatSurficialEntity.getScndStruc()));
			spinnerSecondary.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setScndStruc(parent.getItemAtPosition(position).toString());
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Button buttonSecondary = (Button) convertView.findViewById(R.id.earthmat_surficial_button_secondary_clear);
			EditText editTextSecondary = (EditText) convertView.findViewById(R.id.earthmat_surficial_editText_secondary);
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
		} else if (tab == 3) {
			
			
			convertView = mInflater.inflate(R.layout.earthmat_surficial3, null);
			Spinner spinnerIntThickness = (Spinner) convertView	.findViewById(R.id.earthmat_surficial_spinner_intThickness);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerIntThickness.setAdapter(sp1);
			sp1.setElements(pldb.getCol1("lutSUREarthmatThickType"));
			spinnerIntThickness.setAdapter(sp1);
			spinnerIntThickness.setSelection(sp1.getPosition(earthmatSurficialEntity.getThickType()));
			spinnerIntThickness.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setThickType(parent.getItemAtPosition(position).toString());
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			
			EditText editTextTo = (EditText) convertView.findViewById(R.id.earthmat_surficial_editText_to);
			editTextTo.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						earthmatSurficialEntity.setThickMin("");
					else
						earthmatSurficialEntity.setThickMin(s.toString());
				}
			});
			EditText editTextFrom = (EditText) convertView.findViewById(R.id.earthmat_surficial_editText_from);
			editTextFrom.addTextChangedListener(new TextWatcher() {
				public void onTextChanged(CharSequence s, int start, int before, int count) { }
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
				public void afterTextChanged(Editable s) {
					if (s.length() == 0)
						earthmatSurficialEntity.setThickMax("");
					else
						earthmatSurficialEntity.setThickMax(s.toString());
				}
			});
		
			Spinner spinnerLowContact = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_lowContact);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerLowContact.setAdapter(sp2);
			sp1.setElements(pldb.getCol1("lutSUREarthmatLwrcontact"));
			spinnerLowContact.setAdapter(sp2);
			spinnerLowContact.setSelection(sp1.getPosition(earthmatSurficialEntity.getLwrContact()));
			spinnerLowContact.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setLwrContact(parent.getItemAtPosition(position).toString());
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Spinner spinnerInterpretation = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_interpretation);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerInterpretation.setAdapter(sp3);
			sp3.setElements(pldb.getCol1("lutSUREarthmatIntcontact"));
			spinnerInterpretation.setAdapter(sp3);
			spinnerInterpretation.setSelection(sp3.getPosition(earthmatSurficialEntity.getIntContact()));
			spinnerInterpretation.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setIntContact(parent.getItemAtPosition(position).toString());
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			
			Spinner spinnerLatContact = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_latContact);
			SpinnerController sp4 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerLatContact.setAdapter(sp4);
			sp4.setElements(pldb.getCol1("lutSUREarthmatLatcontact"));
			spinnerLatContact.setAdapter(sp4);
			spinnerLatContact.setSelection(sp4.getPosition(earthmatSurficialEntity.getLatContact()));
			spinnerLatContact.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setLatContact(parent.getItemAtPosition(position).toString());
					System.out.println(parent.getItemAtPosition(position));
				}
			});

			
		} else if (tab == 4) {
			
			convertView = mInflater.inflate(R.layout.earthmat_surficial4, null);
			
			Spinner spinnerSorting = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_sorting);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerSorting.setAdapter(sp1);
			sp1.setElements(pldb.getCol1("lutSUREarthmatSorting"));
			spinnerSorting.setAdapter(sp1);
			spinnerSorting.setSelection(sp1.getPosition(earthmatSurficialEntity.getSorting()));
			spinnerSorting.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setSorting(parent.getItemAtPosition(position).toString());
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Spinner spinnerMatrix = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_matrix);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerMatrix.setAdapter(sp2);
			sp2.setElements(pldb.getCol1("lutSUREarthmatMatrix"));
			spinnerMatrix.setAdapter(sp2);
			spinnerMatrix.setSelection(sp2.getPosition(earthmatSurficialEntity.getMatrix()));
			spinnerMatrix.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setMatrix(parent.getItemAtPosition(position).toString());
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			
			Spinner spinnerModifier = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_modifier);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerModifier.setAdapter(sp3);
			sp3.setElements(pldb.getCol1("lutSUREarthmatMatrixMod"));
			spinnerModifier.setAdapter(sp3);
			spinnerModifier.setSelection(sp3.getPosition(earthmatSurficialEntity.getMatrixMod()));
			spinnerModifier.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setMatrixMod(parent.getItemAtPosition(position).toString());
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Button buttonMatrixClear = (Button) convertView.findViewById(R.id.earthmat_surficial_button_matrixMod_clear);
			EditText editTextMatrixMod = (EditText) convertView.findViewById(R.id.earthmat_surficial_editText_matrixMod);
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
			Spinner spinnerOxidation = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_oxidation);
			SpinnerController sp4 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerOxidation.setAdapter(sp4);
			sp4.setElements(pldb.getCol1("lutSUREarthmatOxidation"));
			spinnerOxidation.setAdapter(sp4);
			spinnerOxidation.setSelection(sp4.getPosition(earthmatSurficialEntity.getOxidation()));
			spinnerOxidation.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setOxidation(parent.getItemAtPosition(position).toString());
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Spinner spinnerCompact = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_compact);
			SpinnerController sp5 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerCompact.setAdapter(sp5);
			sp5.setElements(pldb.getCol1("lutSUREarthmatCompaction"));
			spinnerCompact.setAdapter(sp5);
			spinnerCompact.setSelection(sp5.getPosition(earthmatSurficialEntity.getCompaction()));
			spinnerCompact.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setCompaction(parent.getItemAtPosition(position).toString());
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			
			Spinner spinnerJointing = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_jointing);
			SpinnerController sp6 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerJointing.setAdapter(sp6);
			sp6.setElements(pldb.getCol1("lutSUREarthmatJointing"));
			spinnerJointing.setAdapter(sp6);
			spinnerJointing.setSelection(sp6.getPosition(earthmatSurficialEntity.getJointing()));
			spinnerJointing.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setJointing(parent.getItemAtPosition(position).toString());
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			
			Spinner spinnerh2oContent = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_h2oContent);
			SpinnerController sp7 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerh2oContent.setAdapter(sp7);
			sp7.setElements(pldb.getCol1("lutSUREarthmatH2OContent"));
			spinnerh2oContent.setAdapter(sp7);
			spinnerh2oContent.setSelection(sp7.getPosition(earthmatSurficialEntity.getH2oContent()));
			spinnerh2oContent.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setH2oContent(parent.getItemAtPosition(position).toString());
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Spinner spinnerHclReact = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_hclReact);
			SpinnerController sp8 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerHclReact.setAdapter(sp8);
			sp8.setElements(pldb.getCol1("lutSUREarthmatHCLReact"));
			spinnerHclReact.setAdapter(sp8);
			spinnerHclReact.setSelection(sp8.getPosition(earthmatSurficialEntity.getHclReact()));
			spinnerHclReact.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setHclReact(parent.getItemAtPosition(position).toString());
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			
			Spinner spinnerFissility = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_fissility);
			SpinnerController sp9 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerFissility.setAdapter(sp9);
			sp9.setElements(pldb.getCol1("lutSUREarthmatFissility"));
			spinnerFissility.setAdapter(sp9);
			spinnerFissility.setSelection(sp9.getPosition(earthmatSurficialEntity.getFissilty()));
			spinnerFissility.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setFissilty(parent.getItemAtPosition(position).toString());
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
		} else if (tab == 5) {
			
			convertView = mInflater.inflate(R.layout.earthmat_surficial5, null);
			Spinner spinnerMapUnit = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_mapUnit);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerMapUnit.setAdapter(sp1);
			sp1.setElements(pldb.getCol1("lutSUREarthmatMapunit"));
			spinnerMapUnit.setAdapter(sp1);
			spinnerMapUnit.setSelection(sp1.getPosition(earthmatSurficialEntity.getMapUnit()));
			spinnerMapUnit.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setMapUnit(parent.getItemAtPosition(position).toString());
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			
			Spinner spinnerSurficialOrigin = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_surficialOrigin);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerSurficialOrigin.setAdapter(sp2);
			sp2.setElements(pldb.getCol1("lutSUREarthmatSufform"));
			spinnerSurficialOrigin.setAdapter(sp2);
			spinnerSurficialOrigin.setSelection(sp2.getPosition(earthmatSurficialEntity.getSufform()));
			spinnerSurficialOrigin.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setSufform(parent.getItemAtPosition(position).toString());
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			

			
		} else if (tab == 6) {
			
			convertView = mInflater.inflate(R.layout.earthmat_surficial6, null);
			EditText editTextModal = (EditText) convertView
					.findViewById(R.id.earthmat_surficial_editText_clastModal);
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
			EditText editTextMax = (EditText) convertView
					.findViewById(R.id.earthmat_surficial_editText_clastMax);
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
			EditText editTextMin = (EditText) convertView
					.findViewById(R.id.earthmat_surficial_editText_clastMin);
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
			EditText editTextClastPer = (EditText) convertView
					.findViewById(R.id.earthmat_surficial_editText_clastPer);
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

			Spinner spinnerClastForms = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_clastForms);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerClastForms.setAdapter(sp1);
			sp1.setElements(pldb.getCol1("lutBEDEarthmatRocktype"));
			spinnerClastForms.setAdapter(sp1);
			spinnerClastForms.setSelection(sp1.getPosition(earthmatSurficialEntity.getClastForm()));
			spinnerClastForms.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setClastForm(parent.getItemAtPosition(position).toString());
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			
			Spinner spinnerAverageModal = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_averageModal);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerAverageModal.setAdapter(sp2);
			sp2.setElements(pldb.getCol1("lutSUREarthmatRoundness"));
			spinnerAverageModal.setAdapter(sp2);
			spinnerAverageModal.setSelection(sp2.getPosition(earthmatSurficialEntity.getModalRnd()));
			spinnerAverageModal.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setModalRnd(parent.getItemAtPosition(position).toString());
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Spinner spinnerMaximum = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_roundMax);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerMaximum.setAdapter(sp3);
			sp3.setElements(pldb.getCol1("lutSUREarthmatRoundness"));
			spinnerMaximum.setAdapter(sp3);
			spinnerMaximum.setSelection(sp3.getPosition(earthmatSurficialEntity.getMaxRound()));
			spinnerMaximum.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setMaxRound(parent.getItemAtPosition(position).toString());
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Spinner spinnerMinimum = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_roundMin);
			SpinnerController sp4 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerMinimum.setAdapter(sp4);
			sp4.setElements(pldb.getCol1("lutSUREarthmatRoundness"));
			spinnerMinimum.setAdapter(sp4);
			spinnerMinimum.setSelection(sp4.getPosition(earthmatSurficialEntity.getMinRound()));
			spinnerMinimum.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setMinRound(parent.getItemAtPosition(position).toString());
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			

			
		} else if (tab == 7) {
			
			convertView = mInflater.inflate(R.layout.earthmat_surficial7, null);

			Spinner spinnerErratic = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_erraticType);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerErratic.setAdapter(sp1);
			sp1.setElements(pldb.getCol1("lutSUREarthmatErratictyp"));
			spinnerErratic.setAdapter(sp1);
			spinnerErratic.setSelection(sp1.getPosition(earthmatSurficialEntity.getErraticTyp()));
			spinnerErratic.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setErraticTyp(parent.getItemAtPosition(position).toString());
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Spinner spinnerErraticPer = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_erraticPer);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerErraticPer.setAdapter(sp2);
			sp2.setElements(pldb.getCol1("lutSURGeneralPercent5incr"));
			spinnerErraticPer.setAdapter(sp2);
			spinnerErraticPer.setSelection(sp2.getPosition(earthmatSurficialEntity.getErraticPer()));
			spinnerErraticPer.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setErraticPer(parent.getItemAtPosition(position).toString());
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			EditText editTextErraticComp = (EditText) convertView
					.findViewById(R.id.earthmat_surficial_editText_erraticComp);
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
			EditText editTextInterpretation = (EditText) convertView
					.findViewById(R.id.earthmat_surficial_editText_interpretation);
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
			
			Spinner spinnerLandForm = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_landForm);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerLandForm.setAdapter(sp3);
			sp3.setElements(pldb.getCol1("lutSUREarthmatLandform"));
			spinnerLandForm.setSelection(sp3.getPosition(earthmatSurficialEntity.getLandForm()));
			spinnerLandForm.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialEntity.setErraticPer(parent.getItemAtPosition(position).toString());
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
		} else if (tab == 8) {
			
		
			convertView = mInflater.inflate(R.layout.earthmat_surficial8, null);
			EditText editTextNotes = (EditText) convertView
					.findViewById(R.id.earthmat_surficial_editText_notes);
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

	

}
