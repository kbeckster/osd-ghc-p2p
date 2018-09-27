package org.womensp2p.candidatestories;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    final List<String> mMessages = new ArrayList();
    Activity mActivity;

    ListView mListView;
    ArrayAdapter<String> mArrayAdapter;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivity = this;

        setContentView(R.layout.activity_main);

        for (int i = 0; i < 5; i++) {
            mMessages.add("Story " + (i + 1));
        }

        mListView = findViewById(R.id.list_view);

        mArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mMessages);

        mListView.setAdapter(mArrayAdapter);

        final ImageButton imageButton = findViewById(R.id.message_button);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.message_dialog);
                dialog.show();

                final EditText messageTextView = dialog.findViewById(R.id.message_text_view);

                final Button submitButton = dialog.findViewById(R.id.btn_submit);

                submitButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(final View view) {
                        mMessages.add(messageTextView.getText().toString());
                        mArrayAdapter.notifyDataSetChanged();
                        dialog.dismiss();
                    }
                });

                final Button cancelButton = dialog.findViewById(R.id.btn_cancel);

                cancelButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(final View view) {
                        dialog.cancel();
                    }
                });

            }
        });
    }
}
