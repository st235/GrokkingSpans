package github.com.st235.grokkingspans.spans;

import android.os.Parcel;
import android.support.annotation.ColorInt;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;

/**
 * Created by alexanderdadukin on 18.03.2018.
 */

public class MutableForegroundColorSpan extends ForegroundColorSpan {

    @ColorInt
    private int foregroundColor;

    public MutableForegroundColorSpan(@ColorInt int color) {
        super(color);
        foregroundColor = color;
    }

    public MutableForegroundColorSpan(Parcel src) {
        super(src);
        foregroundColor = src.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(foregroundColor);
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        ds.setColor(getForegroundColor());
    }

    @Override
    public int getForegroundColor() {
        return foregroundColor;
    }

    public void setForegroundColor(@ColorInt int foregroundColor) {
        this.foregroundColor = foregroundColor;
    }
}
