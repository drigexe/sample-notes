package com.vysocki.yuri.samplenotes;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class NewNoteFragment extends Fragment {

    public static NewNoteFragment newInstance() {
        return new NewNoteFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_note, container, false);

        ((MainActivity)getActivity()).setBottomNavigationSelectedItem(R.id.nav_new_note);

        return view;
    }
}
