package era.com.augment;

import android.Manifest;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import gl.GL1Renderer;
import gl.GLFactory;
import system.ArActivity;
import system.DefaultARSetup;
import worldData.World;

public class MainActivity extends AppCompatActivity {

    int PERMISSION_ALL = 1;
    String[] PERMISSIONS = {
            Manifest.permission.CAMERA,


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        if(!ManifestPermistion.hasPermissions(this, PERMISSIONS)){
            ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL);
        }


       Button b = new Button(this);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArActivity.startWithSetup(MainActivity.this, new DefaultARSetup() {
                    @Override
                    public void addObjectsTo(GL1Renderer renderer, World world, GLFactory objectFactory) {
                        world.add(objectFactory.newHexGroupTest(null));
                    }
                });
            }
        });
        setContentView(b);



    }
}
