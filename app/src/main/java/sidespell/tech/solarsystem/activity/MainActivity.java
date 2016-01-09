package sidespell.tech.solarsystem.activity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import sidespell.tech.solarsystem.R;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ImageView mImgPlanet;

    private TypedArray mPlanetDescriptions;
    private TypedArray mPlanetImages;
    private TextView   mTvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //region Find views by Id and set appropriate listeners

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Spinner spnrPlanets = (Spinner) findViewById(R.id.spnrPlanets);
        mImgPlanet = (ImageView) findViewById(R.id.imgPlanet);
        mTvDescription = (TextView) findViewById(R.id.tvDescription);

        spnrPlanets.setOnItemSelectedListener(this);

        //endregion

        //region Setup the Adapter

        // Create the adapter used for the spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planet_names, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spnrPlanets.setAdapter(adapter);

        //endregion

        //region Get array values

        mPlanetImages = getResources().obtainTypedArray(R.array.planet_images);
        mPlanetDescriptions = getResources().obtainTypedArray(R.array.planet_descriptions);

        //endregion
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        mImgPlanet.setImageResource(mPlanetImages.getResourceId(position, R.mipmap.ic_launcher));
        mTvDescription.setText(mPlanetDescriptions.getString(position));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Do nothing..
    }
}
