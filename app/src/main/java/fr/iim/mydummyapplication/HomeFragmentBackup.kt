package fr.iim.mydummyapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class HomeFragmentBackup : Fragment() {

    private lateinit var listener: OnHelloFragmentInteractionListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_backup, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editTextFirstName: EditText = view.findViewById(R.id.editTextFirstName)
        val editTextButton: Button = view.findViewById(R.id.editTextButton)

        editTextButton.setOnClickListener {
            // callback
            listener.onHelloSent(editTextFirstName.text.toString())
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is OnHelloFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement LoginFragment.OnFragmentInteractionListener")
        }
    }

    interface OnHelloFragmentInteractionListener {
        fun onHelloSent(firstName: String)
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragmentBackup()
    }
}