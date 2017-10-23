package uk.ac.hud.u1166830.quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener  {
	
	private Button gallery;
	
	//private Button skip;
	
	
	//private static final String MYTAG = "MYTAG";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		gallery = (Button) findViewById(R.id.gallery_button);
		gallery.setOnClickListener(this);
		
		
		
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			Intent intent = new Intent(this, AboutActivity.class);
			startActivity(intent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View view) {
		if(view.getId() == R.id.gallery_button){
			Intent intent = new Intent(this, GalleryActivity.class);
			startActivity(intent);
//			int number = group.getCheckedRadioButtonId();
//			boolean correct = false;
//			int display = 999;
//			if(number == R.id.answer_one){
//				display = 1;
//				correct = true;
//			}
//			else if(number == R.id.answer_two){
//				display = 2;
//			}
//			else if(number == R.id.answer_three){
//				display = 3;
//			}
//			else if(number == R.id.answer_four){
//				display = 4;
//			}
//			else {
//				display = -1;
//			}
			
//			ProgressMonitor progressMonitorInstance = ProgressMonitor.getProgressMonitorInstance();
//			if (progressMonitorInstance.hasBeenAttempted(1) == true) {
//				Toast.makeText( MainActivity.this,
//						"Answer already attempted", display);
//			
//			}
//			else {
//				//check answer and update
//				progressMonitorInstance.recordAttempt(1);
//				if ( correct == true) {
//					progressMonitorInstance.setScore(10);
//				}
//			}
			
		
//			Toast.makeText(this, "The Button ID is: " + display, display).show();
			
//			Log.i(MYTAG, "The Button" + display);
//			if (display == 1){
//				Toast.makeText(this, "Answer Correct ", display).show();
//				Intent intent = new Intent(this, GalleryActivity.class);
//				startActivity(intent);
//				
//			}
//			else {
//				Toast.makeText(this, "Answer Incorrect ", display).show();
//			}
			
			
		}
		// TODO Auto-generated method stub
		
	}
}
