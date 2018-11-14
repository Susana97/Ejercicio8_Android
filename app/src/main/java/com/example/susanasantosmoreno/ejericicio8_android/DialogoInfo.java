package com.example.susanasantosmoreno.ejericicio8_android;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class DialogoInfo extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setMessage("Creado por Susana Santos Moreno \nNov-2018")
                .setTitle("Información")
                .setIcon(R.drawable.ic_launcher)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        return builder.create();
    }
}
