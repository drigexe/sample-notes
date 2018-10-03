package com.vysocki.yuri.samplenotes;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class NotesListFragment extends Fragment {

    public static NotesListFragment newInstance() {
        return new NotesListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notes_list, container, false);

        ((MainActivity)getActivity()).setBottomNavigationSelectedItem(R.id.nav_notes_list);

        Button button = view.findViewById(R.id.buttonTest);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NoteDetailFragment noteDetailFragment = NoteDetailFragment.newInstance("Some string in bundle");
                ((MainActivity)getActivity()).setFragment(noteDetailFragment, MainActivity.FRAGMENT_CONTAINER_ID, true);
            }
        });

        return view;
    }

}
