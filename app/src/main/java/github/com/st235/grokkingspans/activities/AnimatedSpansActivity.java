package github.com.st235.grokkingspans.activities;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.util.Property;
import android.view.ViewGroup;
import android.widget.TextView;

import github.com.st235.grokkingspans.R;
import github.com.st235.grokkingspans.spans.MutableForegroundColorSpan;

/**
 * Created by alexanderdadukin on 18.03.2018.
 */

public class AnimatedSpansActivity extends AppCompatActivity {

    private final Property<MutableForegroundColorSpan, Integer> MUTABLE_FOREGROUND_COLOR_PROPERTY =
            new Property<MutableForegroundColorSpan, Integer>(Integer.class, "MUTABLE_FOREGROUND_COLOR_PROPERTY") {
                @Override
                public Integer get(MutableForegroundColorSpan object) {
                    return object.getForegroundColor();
                }

                @Override
                public void set(MutableForegroundColorSpan object, Integer value) {
                    object.setForegroundColor(value);
                }
            };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView animatedTextView = new TextView(this);
        addContentView(animatedTextView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        SpannableString text = new SpannableString(getString(R.string.text));
        MutableForegroundColorSpan span = new MutableForegroundColorSpan(Color.BLACK);
        text.setSpan(span, 0, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        animatedTextView.setText(text);

        ObjectAnimator animator = ObjectAnimator.ofInt(span, MUTABLE_FOREGROUND_COLOR_PROPERTY, Color.BLACK, Color.CYAN, Color.DKGRAY);
        animator.setEvaluator(new ArgbEvaluator());
        animator.addUpdateListener(animation -> {
            animatedTextView.invalidate();
        });
        animator.setDuration(3500L);
        animator.start();
    }
}
