package github.com.st235.grokkingspans.activities;

import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.view.Gravity;

import static github.com.st235.grokkingspans.Utils.toPx;

/**
 * Created by alexanderdadukin on 31.03.2018.
 */

public class FlagsSpansActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(
                new InterfaceBuilder(getApplicationContext())
                .addText(createWithInsertion(SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE), 25, Gravity.CENTER)
                .addText(createWithInsertion(SpannableString.SPAN_EXCLUSIVE_INCLUSIVE), 25, Gravity.CENTER)
                .addText(createWithInsertion(SpannableString.SPAN_INCLUSIVE_EXCLUSIVE), 25, Gravity.CENTER)
                .addText(createWithInsertion(SpannableString.SPAN_INCLUSIVE_INCLUSIVE), 25, Gravity.CENTER)
                .margins(new Rect(toPx(8), toPx(8), toPx(8), toPx(8)))
                .build()
        );
    }

    private SpannableStringBuilder createWithInsertion(int flag) {
        SpannableStringBuilder spannableString = new SpannableStringBuilder("abcd");
        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(Color.RED);
        spannableString.setSpan(backgroundColorSpan, 1, 3, flag);
        spannableString.insert(3, "x");
        spannableString.insert(1, "x");
        return spannableString;
    }
}
