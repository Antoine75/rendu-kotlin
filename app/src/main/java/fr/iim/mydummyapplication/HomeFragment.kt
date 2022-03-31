package fr.iim.mydummyapplication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText



class HomeFragment : Fragment() {

    private lateinit var listener: HomeFragmentListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        view.findViewById<Button>(R.id.editTextButton).setOnClickListener {

            val email = view.findViewById<EditText>(R.id.editTextTextEmailAddress).toto()
            val password = view.findViewById<EditText>(R.id.editTextTextPassword).toto()




            listener.onHelloClickListener(email, password)
        }

    }


    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is HomeFragmentListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement HomeFragment.HomeFragmentListener")
        }


    }


    interface HomeFragmentListener {
        fun onHelloClickListener(email: String, password: String)
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}