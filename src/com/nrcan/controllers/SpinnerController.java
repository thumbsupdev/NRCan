package com.nrcan.controllers;

import java.util.ArrayList;

import com.nrcan.main.*;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.view.inputmethod.InputMethodManager;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.View.OnClickListener; 
import android.graphics.Color;

public class SpinnerController extends ArrayAdapter<String> implements Filterable {
	private LayoutInflater mInflater;
	private ArrayList<String> elements = new ArrayList<String>();
    private Context context;
    private boolean dataUpdated;

	public SpinnerController(Context context, int resource) {
		super(context, resource);
        this.context = context;
		this.mInflater = LayoutInflater.from(context);
        dataUpdated = false;
	}

	public int getCount() {
		return elements.size() + 1;
	}

	public String getItem(int position) {
		return elements.get(position);
	}

	public long getItemId(int arg0) {
		return 0;
	}

    public void newSpinnerElementDialog() {

        View view = mInflater.inflate(R.layout.cell_spinner_new, null);
        final EditText textEdit = (EditText)view.findViewById(R.id.textInput);

        AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
        alert.setTitle("Add New Element");
        alert.setView(view);

        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // put the value from the edittext into the data list
                String text = textEdit.getText().toString();

                if(text != null) {
                    // Add text to the spinner
                    elements.add(text);
                    setDataUpdated(true);
                }

                dialog.dismiss();
            }
        });

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = alert.create();
        dialog.setOnShowListener(new OnShowListener() { 
            public void onShow(DialogInterface dialog) {
                InputMethodManager im = (InputMethodManager)getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                im.showSoftInput(textEdit, InputMethodManager.SHOW_IMPLICIT);
            }
        });

        dialog.show();
    }

	public View getDropDownView(int position, View convertView, ViewGroup parent) {

        if(position == elements.size()) {

			//convertView = mInflater.inflate(R.layout.cell_spinner_new, null);
			
            /*
			EditText editText = (EditText) convertView.findViewById(R.id.cell_spinner_new_edit_text);
			editText.setHint("New Element");
            editText.setFocusable(false);*/
            //ImageButton button = (ImageButton)convertView.findViewById(R.id.button1);
            /*
                    InputMethodManager m = (InputMethodManager)getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    parent.requestFocus();
                    m.toggleSoftInputFromWindow(convertView.getWindowToken(), InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);*/
           /* editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                
                public void onFocusChange(View v, boolean hasFocus) {
                    //InputMethodManager m = (InputMethodManager)getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    //m.toggleSoftInputFromWindow(v.getWindowToken(), InputMethodManager.SHOW_FORCED, 0);
                    if(hasFocus) {
                        buildDialog();
                        System.out.println("this edittext has focus.");
                    }
                }
            });*/
            /*
            button.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    System.out.println("push da button");
                    newSpinnerElementDialog();
                }
            });*/


			convertView = mInflater.inflate(R.layout.cell_new, null);
            
            TextView newText = (TextView)convertView.findViewById(R.id.cell_new_textView1);
			TextView elementText = (TextView)convertView.findViewById(R.id.cell_new_textView2);
            elementText.setTextColor(Color.BLACK);
            newText.setTextColor(Color.BLACK);
			elementText.setText("ELEMENT");
			
			convertView.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					newSpinnerElementDialog();
				}
			});
		}
		else
		{
			convertView = mInflater.inflate(R.layout.cell_spinner_list, null);
			
			TextView textView = (TextView) convertView.findViewById(R.id.list_title);
			textView.setText(elements.get(position));
		}
		
		return convertView;
	}

	public Filter getFilter() {
		return null;
	}
	
	public int getPosition(String item) {
		int size = elements.size();
		
		for(int i = 0; i < size; i++)
			if(elements.get(i).equalsIgnoreCase(item))
				return i;
		
		return -1;
	}
	
	public void setElements(ArrayList<String> elements) {
		this.elements = elements;
		notifyDataSetChanged();
	}

    public void setDataUpdated(boolean dataUpdated) {
        this.dataUpdated = dataUpdated;
    }

    public boolean isDataUpdated() {
        return dataUpdated = !dataUpdated;
    }
}
