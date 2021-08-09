package com.example.runnerapp.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.runnerapp.R
import com.example.runnerapp.other.Constants.ACTION_START_OR_RESUME_SERVICE
import com.example.runnerapp.services.TrackingService
import com.example.runnerapp.ui.viewmodels.MainViewModel
import com.google.android.gms.maps.GoogleMap
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_tracking.*
import kotlinx.android.synthetic.main.fragment_tracking.view.*

@AndroidEntryPoint
class TrackingFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()
    private var map: GoogleMap? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_tracking, container, false)
        view.mapView.onCreate(savedInstanceState)

        view.btnToggleRun.setOnClickListener {
            sendCommandToService(ACTION_START_OR_RESUME_SERVICE)
        }
        view.mapView.getMapAsync {
            map = it
        }
        return view
    }

    private fun sendCommandToService(action: String) =
        Intent(requireContext(), TrackingService::class.java).also {
            it.action = action
            requireContext().startService(it)
        }

    override fun onResume() {
        super.onResume()
        view?.mapView?.onResume()
    }

    override fun onStart() {
        super.onStart()
        view?.mapView?.onStart()
    }

    override fun onStop() {
        super.onStop()
        view?.mapView?.onStop()
    }

    override fun onPause() {
        super.onPause()
        view?.mapView?.onPause()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        view?.mapView?.onLowMemory()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        view?.mapView?.onSaveInstanceState(outState)
    }
}