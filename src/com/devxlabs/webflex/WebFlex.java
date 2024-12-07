package com.devxlabs.webflex;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.webkit.WebView;

import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.AndroidViewComponent;

public class WebFlex extends AndroidNonvisibleComponent {

    private Context context;
    private Activity activity;

    public WebFlex(ComponentContainer container) {
        super(container.$form());
        this.activity = container.$context();
        this.context = container.$context();
    }

    /**
     * Loads the HTML and CSS content into the given WebViewer.
     *
     * @param webViewer   The WebViewer component where content will be loaded.
     * @param htmlContent The HTML content to be displayed.
     * @param cssContent  The CSS styles to be applied.
     */
    @SimpleFunction(description = "Loads the HTML and CSS content into the given WebViewer.")
    public void LoadHtmlContent(AndroidViewComponent webViewer, String htmlContent, String cssContent) {
        if (webViewer == null || htmlContent == null) {
            return; // Avoid null pointer exceptions
        }

        View view = webViewer.getView();
        if (view instanceof WebView) {
            WebView webView = (WebView) view;
            final String mimeType = "text/html";
            final String encoding = "UTF-8";

            // Building the full HTML content with CSS
            String fullContent = buildFullContent(htmlContent, cssContent);
            webView.loadDataWithBaseURL("", fullContent, mimeType, encoding, "");
        }
    }

    /**
     * Clears the content loaded in the given WebViewer.
     *
     * @param webViewer The WebViewer component to clear content from.
     */
    @SimpleFunction(description = "Clears the content loaded in the given WebViewer.")
    public void ClearHtmlContent(AndroidViewComponent webViewer) {
        LoadHtmlContent(webViewer, "", ""); // Clear by loading empty content
    }

    /**
     * Builds the full HTML content string with embedded CSS.
     *
     * @param htmlContent The HTML content.
     * @param cssContent  The CSS styles.
     * @return A complete HTML string ready for rendering.
     */
    private String buildFullContent(String htmlContent, String cssContent) {
        StringBuilder contentBuilder = new StringBuilder();
        contentBuilder.append("<html><head>")
                .append("<style>").append(cssContent).append("</style>")
                .append("</head><body>")
                .append(htmlContent)
                .append("</body></html>");
        return contentBuilder.toString();
    }
}
