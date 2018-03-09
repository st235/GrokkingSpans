package github.com.st235.grokkingspans;

import android.content.res.Resources;
import android.support.annotation.Px;
import android.util.TypedValue;

/**
 * Created by alexanderdadukin on 09.03.2018.
 */

public class Utils {

    private Utils() {
    }

    @Px
    public static int toPx(int dp) {
        return (int)
                TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                        dp, Resources.getSystem().getDisplayMetrics());
    }
}
