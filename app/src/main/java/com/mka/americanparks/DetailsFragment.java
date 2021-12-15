package com.mka.americanparks;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import android.text.TextUtils;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mka.americanparks.adapter.ViewPagerAdapter;
import com.mka.americanparks.databinding.FragmentDetailsBinding;
import com.mka.americanparks.model.Park;
import com.mka.americanparks.model.ParkViewModel;

public class DetailsFragment extends Fragment {

    private FragmentDetailsBinding binding;
    private ParkViewModel parkViewModel;
    private ViewPagerAdapter viewPagerAdapter;

    public DetailsFragment() {
        // Required empty public constructor
    }

    public static DetailsFragment newInstance() {
        return new DetailsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        parkViewModel = new ViewModelProvider(requireActivity()).get(ParkViewModel.class);
        parkViewModel.getSelectedPark().observe(getViewLifecycleOwner(), park -> {
            binding.detailsParkName.setText(park.getFullName());
            binding.detailsParkDesignation.setText(park.getDesignation());
            // Activities
            StringBuilder activityString = new StringBuilder();
            for (int i = 0; i < park.getActivities().size(); i++) {
                activityString.append(i+1).append(". ").append(park.getActivities().get(i).getName()).append(". ");
            }
            binding.detailsActivities.setText(activityString);

            // Topics
            StringBuilder topicsString = new StringBuilder();
            for (int i = 0; i < park.getTopics().size(); i++) {
                topicsString.append(i+1).append(". ").append(park.getTopics().get(i).getName()).append(". ");
            }
            binding.detailsTopics.setText(topicsString);

            // Entrance Fees
            StringBuilder entranceFeesString = new StringBuilder();
            for (int i = 0; i < park.getEntranceFees().size(); i++) {
                entranceFeesString.append(park.getEntranceFees().get(i).getTitle()).append(": ")
                        .append(park.getEntranceFees().get(i).getCost()).append("\n").append(park.getEntranceFees().get(i).getDescription());
            }
            binding.detailsEntrancefees.setText(entranceFeesString);
            // Operating Hours
            StringBuilder opHoursString = new StringBuilder();
            for (int i = 0; i < park.getOperatingHours().size(); i++) {
                opHoursString.append(park.getOperatingHours().get(i).getName())
                        .append("\n=>").append(park.getOperatingHours().get(i).getDescription())
                        .append("\n\n").append(park.getOperatingHours().get(i).getStandardHours().toString()).append("\n\n");
            }
            binding.detailsOperatinghours.setText(opHoursString);

            if (!TextUtils.isEmpty(park.getDirectionsInfo()) && (!TextUtils.isEmpty(park.getDirectionsUrl())) ) {
                binding.detailsDirections.setText(String.format("%s\n%s", park.getDirectionsInfo(), park.getDirectionsUrl()));
            }

            else if (TextUtils.isEmpty(park.getDirectionsInfo()) || TextUtils.isEmpty(park.getDirectionsUrl())) {
                if (TextUtils.isEmpty(park.getDirectionsInfo())) {
                    binding.detailsDirections.setText(String.format("Info Not Available\n%s", park.getDirectionsUrl()));
                }

                else if (TextUtils.isEmpty(park.getDirectionsUrl())) {
                    binding.detailsDirections.setText(String.format("%s\nURL Not Available", park.getDirectionsInfo()));
                }
            }
            else {
                binding.detailsDirections.setText("Direction info and url are not available");
            }

            binding.detailsDescription.setText(park.getDescription());


            // Images
            viewPagerAdapter = new ViewPagerAdapter(park.getImages());
            binding.detailsViewpager.setAdapter(viewPagerAdapter);


        });

    }
}