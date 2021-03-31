/**
 * 
 * @author vCleen
 *
 */

package rahul.thorat.android.demoprojects.ConstantsClass;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class IOUtils {

	public static final String DATE_TIME_FORMATE = "dd/MM/yyyy HH:mm";
	private static ProgressDialog proDialog = null;
	static Dialog dialogGoogleLoading=null;
	public static int generateRandomNumber(int length) {
		Random r = new Random();
		String number = "";
		int counter = 0;
		while (counter++ < length)
			number += r.nextInt(9);
		
		return Integer.parseInt(number);

	}
	

	public static int getHieghtOfScreen(Activity mContext)
	 {
	  DisplayMetrics displaymetrics = new DisplayMetrics();
	  (mContext).getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
	  int height = displaymetrics.heightPixels;
	  int width = displaymetrics.widthPixels;

	  return width;

	 }
	public static void printLogError(String msg) {
		try {
			Log.e("Beeride", msg);
		} catch (Exception e) {

		}
	}

	public static void printLogDebug(String msg) {
		try {
			Log.d("Beeride", msg);
		} catch (Exception e) {

		}
	}



	public static void printLogInfo(String msg) {
		try {
			Log.i("Beeride", msg);
		} catch (Exception e) {

		}
	}

	public static void startLoadingPleaseWait(Context mContext) {
		try {

			if (mContext != null) {
				if (proDialog == null)
					proDialog = ProgressDialog.show(mContext, null, "Please wait...");
				proDialog.setCancelable(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void startLoading(Context context, String message) {
		try {
			if (context != null) {
				if (proDialog == null)
					proDialog = ProgressDialog.show(context, null, message);
				proDialog.setCancelable(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void stopLoading() {
		try {
			if (proDialog != null)
				proDialog.dismiss();
			proDialog = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}




	public static void hideKeyBoard(Context context, EditText myEditText){
		InputMethodManager imm = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(myEditText.getWindowToken(), 0);
	}

	public static void hideKeyBoard(Context context) {
		InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(((Activity) context).getCurrentFocus().getWindowToken(), 0);
	}

	public static boolean checkCameraHardware(Context context) {
		if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
			// this device has a camera
			return true;
		} else {
			// no camera on this device
			return false;
		}
	}




	public static void myToast(String msg, Context context) {
		Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
	}

	public static void myToastLong(String msg, Context context) {
		Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
	}

	public static void CopyStream(InputStream is, OutputStream os) {
		final int buffer_size = 1024;
		try {
			byte[] bytes = new byte[buffer_size];
			for (;;) {
				int count = is.read(bytes, 0, buffer_size);
				if (count == -1)
					break;
				os.write(bytes, 0, count);
			}
		} catch (Exception ex) {
		}
	}



	public static void cancelDialogLoading() {
		try {
			if (dialogGoogleLoading != null) {
				dialogGoogleLoading.dismiss();
				dialogGoogleLoading = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static  void showAlert(final Context mContext, String msg) {

		AlertDialog.Builder al = new AlertDialog.Builder(mContext);
		al.setCancelable(false);
		al.setTitle("Offeriez");
		al.setMessage(msg);

		al.setPositiveButton("OK",new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				//startActivity(new Intent(BASE_CONTEXT,MyAccount.class));

				((Activity) mContext).finish();

			}
		});


		al.show();

	}

    public static boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

	public static boolean isValidpass(String pass) {

		 String PASSWORD_PATTERN =
				"((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,15})";
		Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
		Matcher matcher = pattern.matcher(pass);
		return matcher.matches();
	}

	public static boolean validateLetters(String txt) {

		String regx = "[a-zA-Z]+\\.?";
		Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(txt);
		return matcher.find();

	}

}
