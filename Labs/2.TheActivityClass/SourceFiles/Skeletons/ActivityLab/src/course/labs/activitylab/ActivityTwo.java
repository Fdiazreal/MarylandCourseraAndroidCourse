package course.labs.activitylab;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTwo extends Activity {

	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";

	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityTwo";

	// Lifecycle counters
	public int mCreate;
	public int mRestart;
	public int mStart;
	public int mResume;


	// Create variables for each of the TextViews, called
    // mTvCreate, etc. 
	public TextView mTvCreate;
	public TextView mTvRestart;
	public TextView mTvStart;
	public TextView mTvResume;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two);

		// Assign the appropriate TextViews to the TextView variables
		// Hint: Access the TextView by calling Activity's findViewById()
		// textView1 = (TextView) findViewById(R.id.textView1);
		mTvCreate = (TextView) findViewById(R.id.create);
		mTvRestart = (TextView) findViewById(R.id.restart);
		mTvStart = (TextView) findViewById(R.id.start);
		mTvResume = (TextView) findViewById(R.id.resume);

		Button closeButton = (Button) findViewById(R.id.bClose); 
		closeButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// This function closes Activity Two
				// Hint: use Context's finish() method
				ActivityTwo.this.finish();
			}
		});

		// Check for previously saved state
		if (savedInstanceState != null) {
			// Restore value of counters from saved state
			// Only need 4 lines of code, one for every count variable
			mCreate = savedInstanceState.getInt(CREATE_KEY);
			mRestart = savedInstanceState.getInt(RESTART_KEY);
			mStart = savedInstanceState.getInt(START_KEY);
			mResume = savedInstanceState.getInt(RESUME_KEY);
		}

		// Emit LogCat message
		Log.i(TAG, "Entered the onCreate() method");

		// Update the appropriate count variable
		// Update the user interface via the displayCounts() method
		mCreate++;
		displayCounts();
	}

	// Lifecycle callback methods overrides

	@Override
	public void onStart() {
		super.onStart();

		// Emit LogCat message
		Log.i(TAG, "Entered the onStart() method");

		// Update the appropriate count variable
		// Update the user interface
		mStart++;
		displayCounts();
	}

	@Override
	public void onResume() {
		super.onResume();

		// Emit LogCat message
		Log.i(TAG, "Entered the onResume() method");

		// Update the appropriate count variable
		// Update the user interface
		mResume++;
		displayCounts();
	}

	@Override
	public void onPause() {
		super.onPause();

		// Emit LogCat message
		Log.i(TAG, "Entered the onPause() method");
	}

	@Override
	public void onStop() {
		super.onStop();

		// Emit LogCat message
		Log.i(TAG, "Entered the onStop() method");
	}

	@Override
	public void onRestart() {
		super.onRestart();

		// Emit LogCat message
		Log.i(TAG, "Entered the onRestart() method");

		// Update the appropriate count variable
		// Update the user interface
		mRestart++;
		displayCounts();
		
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		// Emit LogCat message
		Log.i(TAG, "Entered the onDestroy() method");

	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {

		// Save counter state information with a collection of key-value pairs
		// 4 lines of code, one for every count variable
		savedInstanceState.putInt(RESTART_KEY, mRestart);
		savedInstanceState.putInt(RESUME_KEY, mResume);
		savedInstanceState.putInt(START_KEY, mStart);
		savedInstanceState.putInt(CREATE_KEY, mCreate);
	}

	// Updates the displayed counters
	public void displayCounts() {

		mTvCreate.setText("onCreate() calls: " + mCreate);
		mTvStart.setText("onStart() calls: " + mStart);
		mTvResume.setText("onResume() calls: " + mResume);
		mTvRestart.setText("onRestart() calls: " + mRestart);
	
	}
}
