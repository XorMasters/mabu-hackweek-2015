package saas.citrix.com.viewpagerexample;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentA extends android.support.v4.app.Fragment {

    public FragmentA() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        WebView webView = (WebView)view.findViewById(R.id.webview);
        webView.loadUrl("https://www.linkedin.com/in/allanknight");
        return view;
    }
}
