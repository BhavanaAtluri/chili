package info.chili.gwt.utils;

import java.util.Date;
import java.util.MissingResourceException;

import com.google.gwt.i18n.client.ConstantsWithLookup;
import com.google.gwt.i18n.client.DateTimeFormat;

// TODO: Auto-generated Javadoc
/**
 * The Class Utils.
 */
public class Utils {

    public static String getShortDate(Date date) {
        if (date == null) {
            return "";
        }
        return DateTimeFormat.getShortDateFormat().format(date);
    }

    public static String getClassSimpleName(String name) {
        return (name.substring(name.lastIndexOf(".") + 1));
    }

    // TODO rename to toString
    public static String entityToString(Object entity) {
        if (entity == null) {
            return "";
        } else {
            return entity.toString();
        }
    }

    /**
     * used to get UI display value from constants for the give attribute in a
     * class
     */
    public static String getAttributeLabel(String attribute, String classCanonicalName, ConstantsWithLookup constants) {
        if (constants == null) {
            return attribute;
        }
        String key = classCanonicalName + "_" + attribute;
        key = key.replace(".", "_");
        try {
            return constants.getString(key);
        } catch (MissingResourceException e) {
            return attribute;
        }
    }

    public static String getMoreInfoLabel(String attribute, String classCanonicalName, ConstantsWithLookup constants) {
        if (constants == null) {
            return attribute;
        }
        String key = classCanonicalName + "_" + attribute + "_info";
        try {
            return constants.getString(key);
        } catch (MissingResourceException e) {
            return attribute;
        }
    }

    /**
     * used to get UI display value from constants for the key
     */
    public static String getKeyValue(String id, ConstantsWithLookup constants) {
        if (constants == null) {
            return id;
        }
        String value = "";
        try {
            value = constants.getString(id);
        } catch (MissingResourceException e) {
            value = id;
        }
        return value;
    }

    public static String getExceptionInfo(Throwable e) {
        String result = "";
        StackTraceElement[] stackTraceElements = e.getStackTrace();
        result += e.toString() + "\n";
        for (int i = 0; i < stackTraceElements.length; i++) {
            result += "    at " + stackTraceElements[i] + "\n";
        }
        e = e.getCause();
        if (e != null) {
            result += "Caused by: ";
        }
        return result;
    }

    public static String getFileExtension(String filename) {
        return filename.substring(filename.lastIndexOf(".") + 1, filename.length());
    }

    public static boolean isImage(String filename) {
        String[] validImagesExtesions = {"JPG", "JPEG", "GIF", "PNG"};
        for (String ext : validImagesExtesions) {
            if (ext.equalsIgnoreCase(getFileExtension(filename))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isDocument(String filename) {
        String[] validImagesExtesions = {"PDF", "DOC", "DOCX", "TXT", "RTF"};
        for (String ext : validImagesExtesions) {
            if (ext.equalsIgnoreCase(getFileExtension(filename))) {
                return true;
            }
        }
        return false;
    }

    public static String getStringCamelCase(String string) {
        return string.substring(0, 1).toLowerCase() + string.substring(1);
    }

    public static String getFileNameFromUrl(String url) {
        return url.substring(url.lastIndexOf("_"));
    }
}
