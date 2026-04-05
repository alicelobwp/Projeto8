package com.example.projeto8.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.projeto8.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class LgpdPopUpScreen extends BottomSheetDialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.layout_lgpd_bottom_sheet, container, false);

        Button btnAccept = view.findViewById(R.id.btn_accept_lgpd);

        btnAccept.setOnClickListener(v -> {

            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);

            dismiss();
            if (getActivity() != null) {
                getActivity().finish();
            }
        });

        return view;
    }
}