package screens.authscreen

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.tesktaskauth.R
import com.example.tesktaskauth.databinding.FragmentAuthBinding
import dagger.hilt.android.AndroidEntryPoint
import logindata
import passworddata


@AndroidEntryPoint
class AuthFragment : Fragment() {
    private val viewmodel by viewModels<AuthViewModel>()
    lateinit var binding : FragmentAuthBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =  FragmentAuthBinding.inflate(inflater)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewmodel.checkVersionInitialization()
        viewmodel.versionstate.observe(viewLifecycleOwner){
                versionresponse->
            if(versionresponse.isSuccessful){
                binding.updateapp.visibility = VISIBLE
            }else{
                binding.versionistooold.visibility = VISIBLE
            }
        }
        setupUI(view)
        binding.loginButton.setOnClickListener{

            if(binding.phoneedtext.length() == 0 || binding.passwordedtext.length() ==0){
                Toast.makeText(requireContext(),"Телефон або пароль  порожній, будь ласка, заповніть ці строки!",Toast.LENGTH_SHORT).show()
            }else{
                sendpostrequest(view)

            }
        }
    }

    private fun sendpostrequest(view: View) {
        val login = binding.phoneedtext.text.toString()
        val password = binding.passwordedtext.text.toString()
        if(login == logindata || password == passworddata){
            viewmodel.sendLoginAndpassdata(login, password)
        }else{
            Toast.makeText(requireContext(),"Данні введені не вірно",Toast.LENGTH_SHORT).show()
        }
        if(login != logindata || password != passworddata){
            Toast.makeText(requireContext(),"Телефон, або пароль не вірний",Toast.LENGTH_SHORT).show()
        }else{
            Navigation.findNavController(view).navigate(R.id.action_authFragment_to_homeFragment)
        }

    }
    private fun closeKeyBoard(view:View) {
        if (view != null) {
            val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
    fun setupUI(view: View) {

        // Set up touch listener for non-text box views to hide keyboard.
        if (view !is EditText) {
            view.setOnClickListener {
                closeKeyBoard(view)
            }
        }


        if (view is ViewGroup) {
            for (i in 0 until view.childCount) {
                val innerView = view.getChildAt(i)
                setupUI(innerView)
            }
        }
    }

}