package uk.ac.hud.u1166830.quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity3 extends Activity implements OnClickListener {

	private Button submit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity3);

		submit = (Button) findViewById(R.id.submit_button);
		submit.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity3, menu);
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

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
//		ProgressMonitor progressMonitorInstance = ProgressMonitor.getProgressMonitorInstance();
//				int score = progressMonitorInstance.getScore();
//				Toast.makeText( MainActivity3.this, "Score is: ", + score).show();
		if(v.getId() == R.id.submit_button){
			Intent intent = new Intent(this, AboutActivity.class);
			startActivity(intent);
			
		}
	}
}
