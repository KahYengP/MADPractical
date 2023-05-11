package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.content.DialogInterface;
import android.app.AlertDialog.Builder;

import java.util.Random;

public class ListActivity extends AppCompatActivity {

    private ImageView imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        imageButton = (ImageView) findViewById(R.id.imageButton);

        imageButton.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Profile");
            builder.setMessage("MADness");
            builder.setPositiveButton("VIEW", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    Random r = new Random();
                    int randomNumber = r.nextInt(1000000000);
                    Intent activity = new Intent(ListActivity.this, MainActivity.class);
                    activity.putExtra("Key", String.valueOf(randomNumber));
                    startActivity(activity);

                }
            });
            builder.setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int id) {
                    dialog.dismiss();
                }
            });
            AlertDialog alert = builder.create();
            alert.show();



        });
        }

    }
