package com.mka.americanparks;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mka.americanparks.adapter.OnParkClickListener;
import com.mka.americanparks.adapter.ParkRecyclerAdapter;
import com.mka.americanparks.data.AsyncResponse;
import com.mka.americanparks.data.Repository;
import com.mka.americanparks.model.Park;
import com.mka.americanparks.model.ParkViewModel;

import java.util.ArrayList;
import java.util.List;

public class ParksFragment extends Fragment implements OnParkClickListener {

    private RecyclerView recyclerView;
    private ParkRecyclerAdapter adapter;
    private List<Park> parks;
    private ParkViewModel parkViewModel;



    // TODO: Rename and change types and number of parameters
    public static ParksFragment newInstance() {
        return new ParksFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        parks = new ArrayList<>();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_parks, container, false);
        recyclerView = view.findViewById(R.id.park_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        parkViewModel = new ViewModelProvider(requireActivity()).get(ParkViewModel.class);

        if (parkViewModel.getParks().getValue() != null) {
            parks = parkViewModel.getParks().getValue();
            adapter = new ParkRecyclerAdapter(parks, this);
            recyclerView.setAdapter(adapter);
        }

    }

    @Override
    public void onParkClicked(Park park) {
        Log.d("Park/t", "onParkClicked: " + park.getFullName());
        parkViewModel.selectPark(park);
        getChildFragmentManager().beginTransaction()
                .replace(R.id.park_fragment, DetailsFragment.newInstance())
                .commit();
    }
}