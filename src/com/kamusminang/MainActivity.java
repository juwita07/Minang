package com.kamusminang;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


public class MainActivity extends Activity implements OnClickListener {
	DatabaseManager dm;
	EditText input;
	ImageButton bcari;
	Button bTambah;
	TextView output;
	ArrayList<EntitasKamus>isikamus=new ArrayList<EntitasKamus>();
	EntitasKamus komponenKamus;
		

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
     dm=new DatabaseManager(this);
       
    }
    
    protected void fungsiterjemah(){
    	// TODO Auto-generated method stub
    	ArrayList<Object> baris;
    	baris= dm.terjemahkan(input.getText().toString());
    	if(baris.size()>0){
    		output.setText((String)baris.get(2));
    		input.setText("");
    	}else{
    		output.setText("tidak ditemukan");
    	}
    }

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	} 
}