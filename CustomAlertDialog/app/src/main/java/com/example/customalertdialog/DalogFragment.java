package com.example.customalertdialog;

import android.os.Bundle;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class DalogFragment extends DialogFragment {


    private static final String ARG_TITLE = "title";
    private static final String ARG_MESSAGE = "message";
    private static final String ARG_ICON = "icon";

    private String title;
    private String message;
    private int icon;

    private OnPositiveClickListener positveClickListener;
    private OnNegativeClickListener negativeClickListener;
    private OnNeutralClickListener neutralClickListener;

    public DalogFragment() {
        // Erforderlicher leerer öffentlicher Konstruktor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        //Erster Interface code
        if (context instanceof OnPositiveClickListener){
            positveClickListener = (OnPositiveClickListener) context;
        }else {
            throw new RuntimeException("please implement Listener : OnPositiveClickListener");
        }


        //Zweiter Interface code
        if (context instanceof OnNegativeClickListener){
            negativeClickListener = (OnNegativeClickListener) context;
        }else {
            throw new RuntimeException("please implement Listener : OnNegativeClickListener");
        }


        //dritter Interface code
        if (context instanceof OnNeutralClickListener){
            neutralClickListener = (OnNeutralClickListener) context;
        }else {
            throw new RuntimeException("please implement Listener : OnNeutralClickListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        positveClickListener = null;
        negativeClickListener = null;
        neutralClickListener = null;
    }

    public static DalogFragment newInstance(String title, String message, int icon) {

        // Daten mit Bundle übertragen

        DalogFragment fragment = new DalogFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_TITLE,title);
        bundle.putString(ARG_MESSAGE,message);
        bundle.putInt(ARG_ICON,icon);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.custom_dialog_layout,container,false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tv_title = view.findViewById(R.id.dialog_tv_title);
        TextView tv_message = view.findViewById(R.id.dialog_tv_message);
        EditText et_content = view.findViewById(R.id.dialog_et_content);
        Button btn_ok = view.findViewById(R.id.dialog_btn_ok);
        Button btn_no = view.findViewById(R.id.dialog_btn_No);
        Button btn_Neutral = view.findViewById(R.id.dialog_btn_Neutral);

        tv_title.setText(title);
        tv_message.setText(message);

        //Yes Schaltfläche
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                positveClickListener.onPositiveClickListener(et_content.getText().toString());
                dismiss();
            }
        });

        // No Schaltfläche
        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                negativeClickListener.onNegativeClickListener();
            }
        });

        //Neutrale Schaltfläche
        btn_Neutral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                neutralClickListener.onNeutralClickListener();
            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        if (args != null) {
            title = args.getString(ARG_TITLE);
            message = args.getString(ARG_MESSAGE);
            icon = args.getInt(ARG_ICON);
        }
    }

    // interfaces von Schaltflächen . sie werden in MainActivity implementiert
    // onPositiveClickListener = Yes Oder OK
    // OnNegativeClickListener = No
    // OnNeutralClickListener = Neutral
    public interface OnPositiveClickListener {
        void onPositiveClickListener(String text);
    }

    public interface OnNegativeClickListener{
        void onNegativeClickListener();
    }

    public interface OnNeutralClickListener{
        void onNeutralClickListener();
    }
}
