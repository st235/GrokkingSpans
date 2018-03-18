package github.com.st235.grokkingspans.activities;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;

import github.com.st235.grokkingspans.spans.OutlineSpan;
import github.com.st235.grokkingspans.R;
import github.com.st235.grokkingspans.spans.RoundBackgroundSpan;

import static github.com.st235.grokkingspans.Utils.toPx;

/**
 * Created by alexanderdadukin on 09.03.2018.
 */

public class CustomSpansActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String text = getString(R.string.text);

        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new RoundBackgroundSpan(), 0,
                text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        SpannableString frameString = new SpannableString(text);
        frameString.setSpan(new OutlineSpan(), 10,
                25, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        setContentView(
                new InterfaceBuilder(getApplicationContext())
                        .addText(spannableString)
                        .addText(frameString)
                        .margins(new Rect(toPx(8), toPx(8), toPx(8), toPx(8)))
                        .build()
        );
    }
}
