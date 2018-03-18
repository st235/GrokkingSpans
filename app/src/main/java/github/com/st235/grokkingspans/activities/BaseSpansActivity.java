package github.com.st235.grokkingspans.activities;

import android.graphics.BlurMaskFilter;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.BulletSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.MaskFilterSpan;
import android.text.style.QuoteSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;

import github.com.st235.grokkingspans.R;

import static github.com.st235.grokkingspans.Utils.toPx;

public class BaseSpansActivity extends AppCompatActivity {

    private RecyclerView spanRecyclerView;
    private SpanRecyclerAdapter spanRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        spanRecyclerView = new RecyclerView(getApplicationContext());
        spanRecyclerAdapter = new SpanRecyclerAdapter(getString(R.string.text));
        spanRecyclerView.setAdapter(spanRecyclerAdapter);
        spanRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        setContentView(spanRecyclerView);

        spanRecyclerAdapter
                .add(new BulletSpan(toPx(8), Color.CYAN))
                .add(new QuoteSpan(Color.CYAN))
                .add(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_OPPOSITE))
                .add(new UnderlineSpan())
                .add(new StrikethroughSpan())
                .add(new SubscriptSpan(), 10, 35)
                .add(new SuperscriptSpan(), 10, 35)
                .add(new BackgroundColorSpan(Color.CYAN), 10, 35)
                .add(new ForegroundColorSpan(Color.CYAN), 10, 35)
                .add(new ImageSpan(getApplicationContext(), R.drawable.cat), 10, 35)
                .add(new StyleSpan(Typeface.BOLD))
                .add(new TypefaceSpan("serif"))
                .add(new AbsoluteSizeSpan(toPx(8)), 10, 35)
                .add(new RelativeSizeSpan(2), 10, 35)
                .add(new ScaleXSpan(2), 10, 35)
                .add(new MaskFilterSpan(new BlurMaskFilter(toPx(4), BlurMaskFilter.Blur.NORMAL)), 10, 35)
                .add(new MaskFilterSpan(new EmbossMaskFilter(new float[] { 1, 1, 1 }, 0.4f, 6, 3.5f)), 10, 35);
    }
}
