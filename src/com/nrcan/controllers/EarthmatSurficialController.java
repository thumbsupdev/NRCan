package com.nrcan.controllers;

import java.util.ArrayList;

import com.nrcan.main.PicklistDatabaseHandler;
import com.nrcan.main.R;
import com.nrcan.models.EarthmatSurficialModel;

import android.app.Activity;
import android.content.Context;
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

public class EarthmatSurficialController extends BaseAdapter implements
		Filterable {
	private LayoutInflater mInflater;
	private Activity activity;
	private Context context;
	private int tab;
	private EarthmatSurficialModel earthmatSurficialModel;
	private PicklistDatabaseHandler pldb;
	private ArrayList<String> e = new ArrayList<String>();

	public EarthmatSurficialController(Context context, Activity activity,EarthmatSurficialModel earthmatSurficialModel,PicklistDatabaseHandler pldb) {
		this.mInflater = LayoutInflater.from(context);
		this.activity = activity;
		this.context = context;
		this.earthmatSurficialModel = earthmatSurficialModel;
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
			sp1.setElements(e);//(pldb.getCol1("lutSUREarthmatLith2"));
			spinnerGroup.setAdapter(sp1);
			spinnerGroup.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					earthmatSurficialModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			
			Spinner spinnerType = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_type);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerType.setAdapter(sp2);
			
			sp2.setElements(e);//(pldb.getCol2("lutSUREarthmatLith2"));
			spinnerType.setAdapter(sp2);
			spinnerType.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					earthmatSurficialModel.getEntity().setLithType("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Spinner spinnerDetail = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_detail);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerDetail.setAdapter(sp3);
			sp3.setElements(e);//(pldb.getCol3("lutSUREarthmatLith2"));
			spinnerDetail.setAdapter(sp3);
			spinnerDetail.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					earthmatSurficialModel.getEntity().setLithDetail("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Spinner spinnerColour = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_colour);
			SpinnerController sp4 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerColour.setAdapter(sp4);
			sp4.setElements(e);//(pldb.getCol1("lutSUREarthmatColour"));
			spinnerColour.setAdapter(sp4);
			spinnerColour.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					earthmatSurficialModel.getEntity().setColour("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});

			
		} else if (tab == 2) {
			
			convertView = mInflater.inflate(R.layout.earthmat_surficial2, null);

			Spinner spinnerPrimary = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_primary);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerPrimary.setAdapter(sp1);
			sp1.setElements(e);//(pldb.getCol1("lutSUREarthmatPrimestruct"));
			spinnerPrimary.setAdapter(sp1);
			spinnerPrimary.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialModel.getEntity().setPrimeStruc("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Button buttonPrimary = (Button) convertView.findViewById(R.id.earthmat_surficial_button_primary_clear);
			EditText editTextPrimary = (EditText) convertView.findViewById(R.id.earthmat_surficial_editText_primary);
			
			
			Spinner spinnerWayUp = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_wayup);
			SpinnerController sp2= new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerWayUp.setAdapter(sp2);
			sp2.setElements(e);//(pldb.getCol1("lutSUREarthmatWayup"));
			spinnerWayUp.setAdapter(sp2);
			spinnerWayUp.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialModel.getEntity().setWayUp("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			
			Spinner spinnerSecondary = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_secondary);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerSecondary.setAdapter(sp3);
			sp3.setElements(e);//(pldb.getCol1("lutSUREarthmatScndstruct"));
			spinnerSecondary.setAdapter(sp3);
			spinnerSecondary.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialModel.getEntity().setScndStruc("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Button buttonSecondary = (Button) convertView.findViewById(R.id.earthmat_surficial_button_secondary_clear);
			EditText editTextSecondary = (EditText) convertView.findViewById(R.id.earthmat_surficial_editText_secondary);
			
		} else if (tab == 3) {
			
			
			convertView = mInflater.inflate(R.layout.earthmat_surficial3, null);
			Spinner spinnerIntThickness = (Spinner) convertView	.findViewById(R.id.earthmat_surficial_spinner_intThickness);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerIntThickness.setAdapter(sp1);
			sp1.setElements(e);//(pldb.getCol1("lutSUREarthmatThickType"));
			spinnerIntThickness.setAdapter(sp1);
			spinnerIntThickness.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					earthmatSurficialModel.getEntity().setThickType("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			
			EditText editTextTo = (EditText) convertView.findViewById(R.id.earthmat_surficial_editText_to);
			EditText editTextFrom = (EditText) convertView.findViewById(R.id.earthmat_surficial_editText_from);
		
			Spinner spinnerLowContact = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_lowContact);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerLowContact.setAdapter(sp2);
			sp1.setElements(e);//(pldb.getCol1("lutSUREarthmatLwrcontact"));
			spinnerLowContact.setAdapter(sp2);
			spinnerLowContact.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialModel.getEntity().setLwrContact("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Spinner spinnerInterpretation = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_interpretation);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerInterpretation.setAdapter(sp3);
			sp3.setElements(e);//(pldb.getCol1("lutSUREarthmatIntcontact"));
			spinnerInterpretation.setAdapter(sp3);
			spinnerInterpretation.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialModel.getEntity().setIntContact("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			
			Spinner spinnerLatContact = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_latContact);
			SpinnerController sp4 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerLatContact.setAdapter(sp4);
			sp4.setElements(e);//(pldb.getCol1("lutSUREarthmatLatcontact"));
			spinnerLatContact.setAdapter(sp4);
			spinnerLatContact.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatSurficialModel.getEntity().setLatContact("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});

			
		} else if (tab == 4) {
			
			convertView = mInflater.inflate(R.layout.earthmat_surficial4, null);
			
			Spinner spinnerSorting = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_sorting);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerSorting.setAdapter(sp1);
			sp1.setElements(e);//(pldb.getCol1("lutSUREarthmatSorting"));
			spinnerSorting.setAdapter(sp1);
			spinnerSorting.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Spinner spinnerMatrix = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_matrix);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerMatrix.setAdapter(sp2);
			sp2.setElements(e);//(pldb.getCol1("lutSUREarthmatMatrix"));
			spinnerMatrix.setAdapter(sp2);
			spinnerMatrix.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			
			Spinner spinnerModifier = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_modifier);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerModifier.setAdapter(sp3);
			sp3.setElements(e);//(pldb.getCol1("lutSUREarthmatMatrixMod"));
			spinnerModifier.setAdapter(sp3);
			spinnerModifier.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Button buttonMatrixClear = (Button) convertView.findViewById(R.id.earthmat_surficial_button_matrixMod_clear);
			EditText editTextMatrixMod = (EditText) convertView.findViewById(R.id.earthmat_surficial_editText_matrixMod);
			Spinner spinnerOxidation = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_oxidation);
			SpinnerController sp4 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerOxidation.setAdapter(sp4);
			sp4.setElements(e);//(pldb.getCol1("lutSUREarthmatOxidation"));
			spinnerOxidation.setAdapter(sp4);
			spinnerOxidation.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Spinner spinnerCompact = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_compact);
			SpinnerController sp5 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerCompact.setAdapter(sp5);
			sp5.setElements(e);//(pldb.getCol1("lutSUREarthmatCompaction"));
			spinnerCompact.setAdapter(sp5);
			spinnerCompact.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			
			Spinner spinnerJointing = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_jointing);
			SpinnerController sp6 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerJointing.setAdapter(sp6);
			sp6.setElements(e);//(pldb.getCol1("lutSUREarthmatJointing"));
			spinnerJointing.setAdapter(sp6);
			spinnerJointing.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			
			Spinner spinnerh2oContent = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_h2oContent);
			SpinnerController sp7 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerh2oContent.setAdapter(sp7);
			sp7.setElements(e);//(pldb.getCol1("lutSUREarthmatH2OContent"));
			spinnerh2oContent.setAdapter(sp7);
			spinnerh2oContent.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Spinner spinnerHclReact = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_hclReact);
			SpinnerController sp8 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerHclReact.setAdapter(sp8);
			sp8.setElements(e);//(pldb.getCol1("lutSUREarthmatHCLReact"));
			spinnerHclReact.setAdapter(sp8);
			spinnerHclReact.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			
			Spinner spinnerFissility = (Spinner) convertView.findViewById(R.id.earthmat_surficial_spinner_fissility);
			SpinnerController sp9 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerFissility.setAdapter(sp9);
			sp9.setElements(e);//(pldb.getCol1("lutSUREarthmatFissility"));
			spinnerFissility.setAdapter(sp9);
			spinnerFissility.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
		} else if (tab == 5) {
			
			convertView = mInflater.inflate(R.layout.earthmat_surficial5, null);
			Spinner spinnerMapUnit = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_mapUnit);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerMapUnit.setAdapter(sp1);
			sp1.setElements(e);//(pldb.getCol1("lutSUREarthmatMapunit"));
			spinnerMapUnit.setAdapter(sp1);
			spinnerMapUnit.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			
			Spinner spinnerSurficialOrigin = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_surficialOrigin);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerSurficialOrigin.setAdapter(sp2);
			sp2.setElements(e);//(pldb.getCol1("lutSUREarthmatSufform"));
			spinnerSurficialOrigin.setAdapter(sp2);
			spinnerSurficialOrigin.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			

			
		} else if (tab == 6) {
			
			convertView = mInflater.inflate(R.layout.earthmat_surficial6, null);
			EditText editTextModal = (EditText) convertView
					.findViewById(R.id.earthmat_surficial_editText_clastModal);
			EditText editTextMax = (EditText) convertView
					.findViewById(R.id.earthmat_surficial_editText_clastMax);
			EditText editTextMin = (EditText) convertView
					.findViewById(R.id.earthmat_surficial_editText_clastMin);
			EditText editTextClastPer = (EditText) convertView
					.findViewById(R.id.earthmat_surficial_editText_clastPer);

			Spinner spinnerClastForms = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_clastForms);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerClastForms.setAdapter(sp1);
			sp1.setElements(e);//(pldb.getCol1("lutBEDEarthmatRocktype"));
			spinnerClastForms.setAdapter(sp1);
			spinnerClastForms.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			
			Spinner spinnerAverageModal = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_averageModal);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerAverageModal.setAdapter(sp2);
			sp2.setElements(e);//(pldb.getCol1("lutSUREarthmatRoundness"));
			spinnerAverageModal.setAdapter(sp2);
			spinnerAverageModal.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Spinner spinnerMaximum = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_roundMax);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerMaximum.setAdapter(sp3);
			sp3.setElements(e);//(pldb.getCol1("lutSUREarthmatRoundness"));
			spinnerMaximum.setAdapter(sp3);
			spinnerMaximum.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Spinner spinnerMinimum = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_roundMin);
			SpinnerController sp4 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerMinimum.setAdapter(sp4);
			sp4.setElements(e);//(pldb.getCol1("lutSUREarthmatRoundness"));
			spinnerMinimum.setAdapter(sp4);
			spinnerMinimum.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			

			
		} else if (tab == 7) {
			
			convertView = mInflater.inflate(R.layout.earthmat_surficial7, null);

			Spinner spinnerErratic = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_erraticType);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerErratic.setAdapter(sp1);
			sp1.setElements(e);//(pldb.getCol1("lutSUREarthmatErratictyp"));
			spinnerErratic.setAdapter(sp1);
			spinnerErratic.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Spinner spinnerErraticPer = (Spinner) convertView
					.findViewById(R.id.earthmat_surficial_spinner_erraticPer);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerErraticPer.setAdapter(sp2);
			sp2.setElements(e);//(pldb.getCol1("lutBEDEarthmatRocktype"));
			spinnerErraticPer.setAdapter(sp2);
			spinnerErraticPer.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			EditText editTextErraticComp = (EditText) convertView
					.findViewById(R.id.earthmat_surficial_editText_erraticComp);
			EditText editTextInterpretation = (EditText) convertView
					.findViewById(R.id.earthmat_surficial_editText_interpretation);
			
		} else if (tab == 8) {
			
		
			convertView = mInflater.inflate(R.layout.earthmat_surficial8, null);
			EditText editTextNotes = (EditText) convertView
					.findViewById(R.id.earthmat_surficial_editText_notes);
			
		}

		return convertView;
	}

	public Filter getFilter() {
		return null;
	}

	public boolean setTab(int tabNum) {
		if(this.tab == 1){
			if(earthmatSurficialModel.getEntity().getLithGroup().equalsIgnoreCase("")){
				return false;
			}
			
		}
		this.tab = tabNum;
		notifyDataSetChanged();
		return true;
	}

	

}
