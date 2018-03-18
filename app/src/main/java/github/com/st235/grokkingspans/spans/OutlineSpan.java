package github.com.st235.grokkingspans.spans;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.style.LineBackgroundSpan;

import static github.com.st235.grokkingspans.Utils.toPx;

/**
 * Created by alexanderdadukin on 09.03.2018.
 */

public class OutlineSpan implements LineBackgroundSpan {

    @Override
    public void drawBackground(Canvas c, Paint p, int left, int right, int top, int baseline, int bottom, CharSequence text, int start, int end, int lnum) {
        int color = p.getColor();
        Paint.Style style = p.getStyle();

        p.setColor(Color.RED);
        p.setStrokeWidth(toPx(2));
        p.setStyle(Paint.Style.STROKE);

        c.drawText(text, start, end, left, baseline, p);

        p.setColor(color);
        p.setStyle(style);
    }
}
