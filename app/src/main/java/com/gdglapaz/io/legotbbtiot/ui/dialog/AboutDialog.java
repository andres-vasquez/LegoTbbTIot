package com.gdglapaz.io.legotbbtiot.ui.dialog;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;

import com.gdglapaz.io.legotbbtiot.R;
import com.gdglapaz.io.legotbbtiot.model.Developer;
import com.gdglapaz.io.legotbbtiot.ui.adapters.DevelopersAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andresvasquez on 4/6/16.
 */
public class AboutDialog extends DialogFragment {

    private ListView lvDevelopers;
    private DevelopersAdapter adapter;
    private List<Developer> lstDevelopers;

    /**
     * Public static constructor that creates fragment and
     * passes a bundle with data into it when adapter is created
     */
    public static AboutDialog newInstance() {
        AboutDialog aboutDialog = new AboutDialog();
        Bundle bundle = new Bundle();
        aboutDialog.setArguments(bundle);
        return aboutDialog;
    }

    /**
     * Initialize instance variables with data from bundle
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Open the keyboard automatically when the dialog fragment is opened
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        // Initialize Developers List
        lstDevelopers=new ArrayList<Developer>();

        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.CustomTheme_Dialog);

        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View rootView = inflater.inflate(R.layout.dialog_fragment_about, null);
        lvDevelopers =(ListView)rootView.findViewById(R.id.lvDevelopers);
        adapter=new DevelopersAdapter(getActivity(),lstDevelopers);
        lvDevelopers.setAdapter(adapter);

        /* Add developers info */
        lstDevelopers.add(new Developer(1,
                getString(R.string.dev_name),
                getString(R.string.dev_email),
                getString(R.string.dev_organization)));

        //TODO Please feel free to Add your Contact info before contribute on the project

        /* Update developers info */
        adapter.notifyDataSetChanged();

        /* Inflate and set the layout for the dialog */
        /* Pass null as the parent view because its going in the dialog layout*/
        builder.setView(rootView)
                /* Add action buttons */
                .setPositiveButton(R.string.accept, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });

        return builder.create();
    }
}
