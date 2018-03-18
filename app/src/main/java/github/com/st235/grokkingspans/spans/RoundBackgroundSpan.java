package github.com.st235.grokkingspans.spans;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.LineBackgroundSpan;

import static github.com.st235.grokkingspans.Utils.toPx;

/**
 * Created by alexanderdadukin on 09.03.2018.
 */

public class RoundBackgroundSpan implements LineBackgroundSpan {

    private final int padding = 0;
    private final RectF backgroundRect = new RectF();

    @Override
    public void drawBackground(Canvas c,
                               Paint p,
                               int left,
                               int right,
                               int top,
                               int baseline,
                               int bottom,
                               CharSequence text,
                               int start, int end, int lnum) {
        if(text == null) return;
        int textWidth = Math.round(p.measureText(text, start, end));
        int paintColor = p.getColor();
        backgroundRect.set(left - padding, top - lnum == 0 ?  padding / 2  :  -(padding / 2),
        left + textWidth + padding, bottom + (padding / 2));
        p.setColor(Color.CYAN);
        c.drawRoundRect(backgroundRect, toPx(4), toPx(4), p);
        p.setColor(paintColor);
    }
}
