package github.com.st235.grokkingspans.activities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.util.Pair;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static github.com.st235.grokkingspans.Utils.toPx;

/**
 * Created by alexanderdadukin on 09.03.2018.
 */

class SpanRecyclerAdapter extends RecyclerView.Adapter<SpanRecyclerAdapter.SpanViewHolder> {

    private final List<Pair<String, SpannableString>> strings = new ArrayList<>();

    @NonNull
    private final String template;

    static class SpanViewHolder extends RecyclerView.ViewHolder {
        private TextView titleView;
        private TextView textView;

        SpanViewHolder(View itemView) {
            super(itemView);
            titleView = itemView.findViewWithTag("span_title_view");
            textView = itemView.findViewWithTag("span_text_view");
        }

        void setSpan(Pair<String, SpannableString> span) {
            titleView.setText(span.first);
            textView.setText(span.second);
        }
    }

    SpanRecyclerAdapter(@NonNull String template) {
        this.template = template;
    }

    SpanRecyclerAdapter add(@NonNull Object span) {
        return add(span, 0, template.length());
    }

    SpanRecyclerAdapter add(@NonNull Object span, int start, int finish) {
        SpannableString spannable = new SpannableString(template);
        spannable.setSpan(span, start, finish, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        strings.add(new Pair<>(
                span.getClass().getSimpleName(), spannable
        ));
        notifyItemInserted(getItemCount() - 1);
        return this;
    }

    @NonNull
    @Override
    public SpanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LinearLayout root = new LinearLayout(context);
        root.setOrientation(LinearLayout.VERTICAL);

        TextView titleView = new TextView(context);
        titleView.setTag("span_title_view");
        titleView.setPadding(toPx(8), toPx(8), toPx(8), 0);
        titleView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        titleView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        TextView textView = new TextView(context);
        textView.setTag("span_text_view");
        textView.setPadding(toPx(8), toPx(8), toPx(8), toPx(8));
        textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        root.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        root.addView(titleView);
        root.addView(textView);
        return new SpanViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull SpanViewHolder holder, int position) {
        holder.setSpan(strings.get(position));
    }

    @Override
    public int getItemCount() {
        return strings.size();
    }
}
