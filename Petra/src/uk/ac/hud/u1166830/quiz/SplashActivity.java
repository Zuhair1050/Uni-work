package uk.ac.hud.u1166830.quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;


public class SplashActivity extends Activity implements Runnable {

	
	@Override
	public void run() {

		
		Intent intent = new Intent(this, MainActivity.class);
		
		this.startActivity(intent);
		finish();
		
		
		

		
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
      //  setContentView(R.layout.activity_about);
        Handler handler = new Handler();
        handler.postDelayed(this, 1000);
        
        
        
    }

    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.splash, menu);
        getMenuInflater().inflate(R.menu.main, menu);
        getMenuInflater().inflate(R.menu.about, menu);
        return true;
    }
    
    

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
