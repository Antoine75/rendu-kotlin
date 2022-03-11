package fr.iim.mydummyapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class HelloFragmentBackup : Fragment() {

    private var firstName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            firstName = it.getString(ARG_FIRST_NAME)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hello_backup, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.helloTextView).text = firstName
    }

    companion object {
        private const val ARG_FIRST_NAME = "ARG_FIRST_NAME"

        @JvmStatic
        fun newInstance(firstName: String) =
            HelloFragmentBackup().apply {
                arguments = Bundle().apply {
                    putString(ARG_FIRST_NAME, firstName)
                }
            }
    }
}