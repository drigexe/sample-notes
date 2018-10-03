package com.vysocki.yuri.samplenotes;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class NoteDetailFragment extends Fragment {

    private static final String NOTE_KEY = "NOTE_KEY";

    public static NoteDetailFragment newInstance(String noteInfo) {
        NoteDetailFragment noteDetailFragment = new NoteDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString(NOTE_KEY, noteInfo);
        noteDetailFragment.setArguments(bundle);
        return noteDetailFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note_detail, container, false);
        return view;
    }
}
