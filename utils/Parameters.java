package org.scanblox.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.Window;

import androidx.core.content.ContextCompat;

import com.githang.statusbar.StatusBarCompat;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parameters implements Serializable {
    public final static String SP_NAME = "userSP";

    public static String parseDate(int year, int month, int day) {
        String[] monthStrings = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec"};
        return monthStrings[month] + " " + (day < 10 ? "0" + day : day) + ", " + year;
    }

    public static void setStatusbarColor(Activity activity, Context context, int color) {
        StatusBarCompat.setStatusBarColor(activity, ContextCompat.getColor(context, color));
    }

    public static int getStatusbarHeight(Window window) {
        Rect rectangle = new Rect();
        window.getDecorView().getWindowVisibleDisplayFrame(rectangle);
        return rectangle.top;
    }

    public static boolean isEmailValid(String email) {
        final Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
    }
}
