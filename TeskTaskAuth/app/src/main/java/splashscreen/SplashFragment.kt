package splashscreen

import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.tesktaskauth.R
import com.example.tesktaskauth.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint
import splashscree.SplashViewModel



@AndroidEntryPoint
class SplashFragment : Fragment() {
    lateinit var binding: FragmentSplashBinding
private val viewmodel by viewModels<SplashViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
binding = FragmentSplashBinding.inflate(inflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // if Internet is not working == splash screen without logo
        if(!isDeviceOnline(requireContext())){
            binding.noInternetLayout.visibility = VISIBLE
            binding.internetLayout.visibility = INVISIBLE
        }else{
            viewmodel.initResponse()
            viewmodel.state.observe(viewLifecycleOwner){
                    resp->
                if(resp.isSuccessful){
                    binding.internetLayout.visibility = VISIBLE
                    Navigation.findNavController(view).navigate(R.id.action_splashFragment_to_authFragment)
                } else{
                    isDeviceOnline(requireContext())
                    resp.errorBody()?.string()
                    binding.internetLayout.visibility = INVISIBLE
                    binding.noInternetLayout.visibility = VISIBLE
                }

            }
        }


    }

    private fun isDeviceOnline(context: Context): Boolean {
        val connManager = context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val networkCapabilities = connManager.getNetworkCapabilities(connManager.activeNetwork)
            if (networkCapabilities == null) {
                Log.d("TAG", "Device Offline")
                return false
            } else {
                Log.d("TAG", "Device Online")
                if (networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) &&
                    networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED) &&
                    networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_NOT_SUSPENDED)
                ) {
                    Log.d("TAG", "Connected to Internet")
                    return true
                } else {
                    Log.d("TAG", "Not connected to Internet")
                    return false
                }
            }
        } else {
            val activeNetwork = connManager.activeNetworkInfo
            if (activeNetwork?.isConnectedOrConnecting == true && activeNetwork.isAvailable) {
                Log.d("TAG", "Device Online")
                when (activeNetwork.state) {
                    NetworkInfo.State.CONNECTED -> {
                        Log.d("TAG", " CONNECTED ")
                        return true
                    }
                    NetworkInfo.State.CONNECTING -> {
                        Log.d("TAG", " CONNECTING ")
                        return true
                    }
                    else -> {
                        Log.d("TAG", "NO Connection")
                        return false
                    }
                }
            } else {
                Log.d("TAG", "Device Offline")
                return false
            }
        }
    }
}