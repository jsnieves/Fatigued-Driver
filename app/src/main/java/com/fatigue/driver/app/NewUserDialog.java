package com.fatigue.driver.app;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Eric on 2/13/2017.
 */

public class NewUserDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        builder.setTitle("New User");

        View mView = inflater.inflate(R.layout.dialog_newuser, null);
        final EditText view_username = (EditText) mView.findViewById(R.id.username);
        builder.setView(mView);

        // Add action buttons
        builder.setPositiveButton("Enter", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String username = view_username.getText().toString();

                        User.newUser(username, getActivity());
                        Toast.makeText(getActivity().getApplicationContext(), "New User Created", Toast.LENGTH_SHORT).show();
                        ((LoginActivity)getActivity()).loadMainActivity();
                    }
                });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        NewUserDialog.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }
}