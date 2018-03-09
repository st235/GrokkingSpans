package github.com.st235.grokkingspans;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by alexanderdadukin on 09.03.2018.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(
                new InterfaceBuilder(this)
                        .addButton("base spans", v -> startActivity(new Intent(this, BaseSpansActivity.class)))
                        .addButton("custom spans", v -> startActivity(new Intent(this, CustomSpansActivity.class)))
                        .build()
        );
    }
}
