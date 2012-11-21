package com.nrcan.controllers;

import java.util.ArrayList;

import com.nrcan.main.PicklistDatabaseHandler;
import com.nrcan.main.R;
import com.nrcan.models.EarthmatBedrockModel;

import android.app.Activity;
import android.content.Context;
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
	private Activity activity;
	private Context context;
	private int tab;
	private EarthmatBedrockModel earthmatbedrockModel;
	private PicklistDatabaseHandler pldb;
	private ArrayList<String> e = new ArrayList<String>();

	public EarthmatBedrockController(Context context, Activity activity, EarthmatBedrockModel earthmatbedrockModel, PicklistDatabaseHandler pldb) {
		this.mInflater = LayoutInflater.from(context);
		this.activity = activity;
		this.context = context;
		this.tab = 1;
		this.earthmatbedrockModel = earthmatbedrockModel;
		this.pldb = pldb;
		e.add("1");
		e.add("2");
		e.add("3");
		e.add("4");
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

			Spinner spinnerGroup = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_group);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp1.setElements(e);//(pldb.getCol1("lutBEDEarthmatRocktype"));
			spinnerGroup.setAdapter(sp1);
			spinnerGroup.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatbedrockModel.getEntity().setLithGroup("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Spinner spinnerType = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_type);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			
			sp2.setElements(e);//(pldb.getCol2("lutBEDEarthmatRocktype"));
			spinnerType.setAdapter(sp2);
			spinnerType.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatbedrockModel.getEntity().setLithType("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Spinner spinnerDetail = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_detail);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			sp3.setElements(e);//(pldb.getCol3("lutBEDEarthmatRocktype"));
			spinnerDetail.setAdapter(sp3);
			spinnerDetail.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatbedrockModel.getEntity().setLithDetail("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Spinner spinnerUnit = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_unit);
			SpinnerController sp4 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			
			//sp4.setElementsCol1();
			sp4.setElements(e);//(pldb.getCol1("lutBEDEarthmatRocktype"));
			spinnerUnit.setAdapter(sp4);
			spinnerUnit.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatbedrockModel.getEntity().setMapUnit("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Spinner spinnerOccurs = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_occursAs);
			SpinnerController sp5 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			//sp5.setElementsCol2("");  // NEEDS INPUT
			spinnerOccurs.setAdapter(sp5);
			sp5.setElements(e);//(pldb.getCol2("lutBEDEarthmatRocktype"));
			spinnerOccurs.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatbedrockModel.getEntity().setOccurAs("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			
		} else if (tab == 2) {
			
			convertView = mInflater.inflate(R.layout.earthmat_bedrock2, null);
			
			Spinner spinnerStructure = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_structure);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerStructure.setAdapter(sp1);
			sp1.setElements(e);//(pldb.getCol2("lutBEDEarthmatStructural"));
			spinnerStructure.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatbedrockModel.getEntity().setModStruc("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
		
			
			
			
			Button buttonStructure = (Button) convertView.findViewById(R.id.earthmat_bedrock_button_structure);
			EditText editTextStructure = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_structure);

			Spinner spinnerTexture = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_texture);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerTexture.setAdapter(sp2);
			sp2.setElements(e);//(pldb.getCol2("lutBEDEarthmatTextural"));
			spinnerTexture.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatbedrockModel.getEntity().setModTexture("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			
			
			Button buttonTexture = (Button) convertView.findViewById(R.id.earthmat_bedrock_button_texture);
			EditText editTextTexture = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_texture);

			Spinner spinnerComposition = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_composition);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerComposition.setAdapter(sp3);
			sp3.setElements(e);//(pldb.getCol2("lutBEDEarthmatComposition"));
			spinnerComposition.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatbedrockModel.getEntity().setModComp("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			
			
			
			Button buttonComposition = (Button) convertView.findViewById(R.id.earthmat_bedrock_button_composition);
			EditText editTextComposition = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_composition);
			
		} else if (tab == 3) {
			
			convertView = mInflater.inflate(R.layout.earthmat_bedrock3, null);
			
			Spinner spinnerGrnCry = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_grnCry);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerGrnCry.setAdapter(sp1);
			sp1.setElements(e);//(pldb.getCol1("lutBEDEarthmatGCSize"));
			spinnerGrnCry.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatbedrockModel.getEntity().setGrcrySize("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			
			Button buttonGrnCry = (Button) convertView.findViewById(R.id.earthmat_bedrock_button_grnCry);
			EditText editTextGrnCry = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_grnCry);

			Spinner spinnerDefFabric = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_defFabric);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerDefFabric.setAdapter(sp2);
			 
			sp2.setElements(e);//(pldb.getCol1("lutBEDEarthmatDeffabric"));
			spinnerDefFabric.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatbedrockModel.getEntity().setDefFabric("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			
			Button buttonDefFabric = (Button) convertView.findViewById(R.id.earthmat_bedrock_button_defFabric);
			EditText editTextDefFabric = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_defFabric);

			Spinner spinnerBedThick = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_bedThick);
			SpinnerController sp3 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerBedThick.setAdapter(sp3);
			
			sp3.setElements(e);//(pldb.getCol1("lutBEDEarthmatBedthick"));
			spinnerBedThick.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatbedrockModel.getEntity().setBedThick("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			
			Button buttonBedThick = (Button) convertView.findViewById(R.id.earthmat_bedrock_button_bedThick);
			EditText editTextBedThick = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_bedThick);
			
		} else if (tab == 4) {
			
			convertView = mInflater.inflate(R.layout.earthmat_bedrock4, null);

			Spinner spinnerMineral = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_mineral);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerMineral.setAdapter(sp1);
			sp1.setElements(e);//(pldb.getCol1("lutBEDEarthmatMineral"));
			spinnerMineral.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatbedrockModel.getEntity().setMineral("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			
			Button buttonClear = (Button) convertView.findViewById(R.id.earthmat_bedrock_button_mineral);
			EditText editTextMineral = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_mineral);
			EditText editTextRockDescription = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_rockDescription);
			
		} else if (tab == 5) {
			
			convertView = mInflater.inflate(R.layout.earthmat_bedrock5, null);
			
			Spinner spinnerFresh = (Spinner) convertView.findViewById(R.id.earthmat_spinner_fresh);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerFresh.setAdapter(sp1);
			sp1.setElements(e);//(pldb.getCol1("lutBEDEarthmatColour"));
			spinnerFresh.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatbedrockModel.getEntity().setColourF("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			
			Spinner spinnerWeathered = (Spinner) convertView.findViewById(R.id.earthmat_spinner_weathered);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerWeathered.setAdapter(sp2);
			sp2.setElements(e);//(pldb.getCol1("lutBEDEarthmatColour"));
			spinnerWeathered.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatbedrockModel.getEntity().setColourW("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			
			EditText editTextIndex = (EditText) convertView.findViewById(R.id.earthmat_editText_index);
			EditText editTextMagSus = (EditText) convertView.findViewById(R.id.earthmat_editText_magSusceptibility);

		} else if (tab == 6) {
			
			convertView = mInflater.inflate(R.layout.earthmat_bedrock6, null);
			
			Spinner spinnerFossil = (Spinner) convertView.findViewById(R.id.earthmat_bedrock_spinner_fossil);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerFossil.setAdapter(sp1);
			sp1.setElements(e);//(pldb.getCol1("lutBEDEarthmatFossil"));
			spinnerFossil.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					//earthmatbedrockModel.getEntity().setFossils("");
					//editTextFossil.setText();
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			Button buttonFossil = (Button) convertView.findViewById(R.id.earthmat_bedrock_button_fossil);
			EditText editTextFossil = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_fossil);
			EditText editTextFossilDescription = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_rockDescription);
			
		} else if (tab == 7) {
			
			convertView = mInflater.inflate(R.layout.earthmat_bedrock7, null);
			
			Spinner spinnerContactUpper = (Spinner) convertView.findViewById(R.id.earthmat_spinner_upper);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerContactUpper.setAdapter(sp1);
			sp1.setElements(e);//(pldb.getCol1("lutBEDEarthmatContact"));
			spinnerContactUpper.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatbedrockModel.getEntity().setContactUp("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});
			
			
			Spinner spinnerContactLower = (Spinner) convertView.findViewById(R.id.earthmat_spinner_lower);
			SpinnerController sp2 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerContactLower.setAdapter(sp2);
			sp1.setElements(e);//(pldb.getCol1("lutBEDEarthmatContact"));
			spinnerContactLower.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatbedrockModel.getEntity().setContactLow("");
					System.out.println(parent.getItemAtPosition(position));
				}
			});

			EditText editTextContactDescription = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_contactDescription);
			
		} else if (tab == 8) {
			
			convertView = mInflater.inflate(R.layout.earthmat_bedrock8, null);
			
			EditText editTextLithDescription = (EditText) convertView.findViewById(R.id.earthmat_bedrock_editText_lithInterpretation);
			Spinner spinnerLithInterp = (Spinner) convertView.findViewById(R.id.earthmat_spinner_lithInterpConfidence);
			SpinnerController sp1 = new SpinnerController(context, android.R.layout.simple_spinner_item);
			spinnerLithInterp.setAdapter(sp1);
			sp1.setElements(e);//(pldb.getCol1("lutBEDInterpconf"));
			spinnerLithInterp.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}

				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					earthmatbedrockModel.getEntity().setInterpConf("");
					System.out.println(parent.getItemAtPosition(position));
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
