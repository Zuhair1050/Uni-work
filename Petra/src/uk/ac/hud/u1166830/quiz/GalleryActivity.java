package uk.ac.hud.u1166830.quiz;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

public class GalleryActivity extends Activity {

	
	
	ImageView selectedImage; 
    private Integer[] mImageIds = {
               R.drawable.monastery,
               R.drawable.monastery_2,
               R.drawable.petra_icon,
               
               
       };
    private ImageView imageView;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gallery_main_activity);

		
		
		Gallery gallery = (Gallery) findViewById(R.id.gallery1);
        
        //gallery.setSpacing(1);
        gallery.setAdapter(new ImageAdapter(this));
        imageView = (ImageView) findViewById(R.id.imageView1);
        
        gallery.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Toast.makeText(getApplicationContext(), "pic = " + arg2, Toast.LENGTH_SHORT).show();
                // show the selected Image
                imageView.setImageResource(mImageIds[arg2]);
            }
        });
    }

		
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.gallery, menu);
		return true;
	}
	
	public class ImageAdapter extends BaseAdapter {
		private Context context;
		int imageBackground;
		
		public ImageAdapter(Context context) {
			this.context = context;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			// TODO Auto-generated method stub
			ImageView imageView = new ImageView(context);
			imageView.setImageResource(mImageIds[arg0]);
			return imageView;
		}
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

//	@Override
//	public void onClick(View v) {
		// TODO Auto-generated method stub
//		if(v.getId() == R.id.submit_button){
//
//			int number = group.getCheckedRadioButtonId();
//
//			int display = 999;
//			if(number == R.id.ans_1){
//				display = 1;
//			}
//			else if(number == R.id.ans_2){
//				display = 2;
//			}
//			else if(number == R.id.ans_3){
//				display = 3;
//			}
//			else if(number == R.id.ans_4){
//				display = 4;
//			}
//			else {
//				display = -1;
//			}


//			Toast.makeText(this, "The Button ID is: " + display, display).show();
			
//			if (display == 4){
//
//			Toast.makeText(this, "Answer Correct ", display).show();
//			Intent intent = new Intent(this, MainActivity3.class);
//			startActivity(intent);
//			
//			}
//			else {
//				Toast.makeText(this, "Answer Incorrect ", display).show();
//			}
//		}
//	}
}
