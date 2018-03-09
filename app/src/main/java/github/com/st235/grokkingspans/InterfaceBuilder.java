package github.com.st235.grokkingspans;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import static github.com.st235.grokkingspans.Utils.toPx;

/**
 * Created by alexanderdadukin on 09.03.2018.
 */

class InterfaceBuilder {

    @NonNull
    private final LinearLayout rootContext;

    InterfaceBuilder(@NonNull Context context) {
        rootContext = new LinearLayout(context);
        rootContext.setOrientation(LinearLayout.VERTICAL);
    }

    InterfaceBuilder addButton(@NonNull CharSequence text,
                               @NonNull View.OnClickListener listener) {
        AppCompatButton button = new AppCompatButton(rootContext.getContext());
        button.setText(text);
        button.setOnClickListener(listener);
        rootContext.addView(button, layout());
        return this;
    }

    InterfaceBuilder margins(@NonNull Rect margins) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
        );
        params.setMargins(margins.left, margins.top, margins.right, margins.bottom);
        rootContext.setLayoutParams(params);
        return this;
    }

    InterfaceBuilder addText(@NonNull CharSequence text) {
        return addText(text, Gravity.LEFT);
    }

    InterfaceBuilder addText(@NonNull CharSequence text,
                             int gravity) {
        AppCompatTextView textView = new AppCompatTextView(rootContext.getContext());
        textView.setText(text);
        textView.setGravity(gravity);
        rootContext.addView(textView, layout());
        return this;
    }

    LinearLayout build() {
        return rootContext;
    }

    private LinearLayout.LayoutParams layout() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER;
        return params;
    }
}
