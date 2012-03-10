package com.syndarin.preferencestest;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

public class PreferencesSampleActivity extends Activity {
    /** Called when the activity is first created. */
	
	Button buttonSettings;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        buttonSettings=(Button)findViewById(R.id.buttonSettings);
        buttonSettings.setOnClickListener(new ButtonHandler());
    }
    
    
    
    @Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		SharedPreferences appSettings=PreferenceManager.getDefaultSharedPreferences(this);
		String welcomeMessage=appSettings.getString("welcomeMessage", "none");
		buttonSettings.setText(welcomeMessage);
	}



	private class ButtonHandler implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i=new Intent(PreferencesSampleActivity.this, SettingsActivity.class);
			PreferencesSampleActivity.this.startActivity(i);
		}
    }
    
}