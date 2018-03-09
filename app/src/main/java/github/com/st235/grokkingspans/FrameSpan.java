package github.com.st235.grokkingspans;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.style.ReplacementSpan;

/**
 * Created by alexanderdadukin on 09.03.2018.
 */

public class FrameSpan extends ReplacementSpan {

    private int width;

    @Override
    public int getSize(@NonNull Paint paint, CharSequence text, int start, int end, @Nullable Paint.FontMetricsInt fm) {
        return  (int) paint.measureText(text, start, end);
    }

    @Override
    public void draw(@NonNull Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, @NonNull Paint paint) {
        int color = paint.getColor();
        paint.setColor(Color.YELLOW);
        width = (int) paint.measureText(text, start, end);
        canvas.drawRect(x, top, x + width, bottom, paint);
        paint.setColor(color);
    }
}
