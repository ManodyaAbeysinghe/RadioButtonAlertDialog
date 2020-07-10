package com.example.radiobuttonalertdialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public class SingleChoiceDialog extends DialogFragment {

    int position = 0;

    public interface SingleChoiceListener{
       void onPositiveButtonClicked(String[] list, int position);
       void onNegativeButtonClicked();
    }


    SingleChoiceListener mListener;

    public void onAttach(Context context){
        super.onAttach(context);
        try{
            mListener = (SingleChoiceListener) context;
        }catch (Exception e){
            throw new ClassCastException(getActivity().toString()+"SingleChoiceListener must implemented");
        }
    }



    public Dialog onCreateDialog(Bundle savedInstanceState){

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        final String[] list = getActivity().getResources().getStringArray(R.array.choice_items);

        builder.setTitle("Select your Choice")
                .setSingleChoiceItems(list, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        position = 1;
                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       mListener.onPositiveButtonClicked(list, position);

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mListener.onNegativeButtonClicked();

                    }
                });

           return builder.create();

    }
}
