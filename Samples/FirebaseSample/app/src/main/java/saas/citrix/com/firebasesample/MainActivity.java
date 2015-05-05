package saas.citrix.com.firebasesample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private Firebase _sampleMessageReference;
    private EditText _messageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Firebase.setAndroidContext(getApplicationContext());

        _messageEditText = (EditText)findViewById(R.id.message_edit_text);
        findViewById(R.id.send_message_button).setOnClickListener(this);

        _sampleMessageReference = new Firebase("https://mabu-hackweek-2015.firebaseio.com").child("sampleMessage");
        _sampleMessageReference.addValueEventListener(new SampleMessageListener());
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.send_message_button:
                String message = _messageEditText.getText().toString();
                _sampleMessageReference.setValue(message);
        }
    }

    private class SampleMessageListener implements ValueEventListener {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            String message = dataSnapshot.getValue(String.class);
            Log.d("findme", dataSnapshot.getRef().getPath().toString());
            Toast.makeText(MainActivity.this, "Got message: " + message, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancelled(FirebaseError firebaseError) {

        }
    }
}