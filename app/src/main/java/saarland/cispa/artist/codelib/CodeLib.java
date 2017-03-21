package saarland.cispa.artist.codelib;

import android.util.Log;

public class CodeLib {

    // Instance variable for singleton usage ///////////////////////////////////////////////////////
    public static CodeLib INSTANCE = new CodeLib();

    // <Constants> /////////////////////////////////////////////////////////////////////////////////
    private static final String TAG = "ArtistCodeLib";
    private static final String VERSION = TAG + " # 1.0.0";

    final String MSG_NOT_FOUND = "<Not Found>";
    // </Constants> ////////////////////////////////////////////////////////////////////////////////

    /**
     * Static Class Constructor
     */
    static {
        // <Code>
    }

    /**
     * Private Class Constructor
     * => Forbidden Class Initialisation (Singleton)
      */
    private CodeLib() {
        Log.v(TAG, "CodeLib() " + VERSION);
    }

    /** Get the name of the calling method
     *
     * The name is probed from the current Thread's stacktrace.
     *
     * @return the name of the calling method
     */
    private String getCallingMethodName() {

        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String callingMethodName;
        try {
            StackTraceElement callingMethod = stackTrace[3];
            callingMethodName = callingMethod.toString();
        } catch (final NullPointerException e) {
            callingMethodName = MSG_NOT_FOUND;
        } catch (final ArrayIndexOutOfBoundsException e) {
            callingMethodName = MSG_NOT_FOUND;
        }
        return callingMethodName;
    }

    /**
     *  Tracelog method, prints the method name of the calling method.
     */
    public void traceLog() {
        final String callingMethodName = getCallingMethodName();
        Log.d(TAG, "Caller -> " + callingMethodName);
    }

    /**
     * Logs the paramenter to the android logger.
     *
     * @param value parameter which gets logged
     */
    public void logBoolean(final boolean value) {
        Log.d(TAG, "logBoolean() #1: " + value);
    }

    /**
     * Logs the paramenter to the android logger.
     *
     * @param value parameter which gets logged
     */
    public void logChar(final char value) {
        Log.d(TAG, "logChar()    #1: " + value);
    }

    /**
     * Logs the paramenter to the android logger.
     *
     * @param value parameter which gets logged
     */
    public void logInteger(final int value) {
        Log.d(TAG, "logInteger() #1: " + value);
    }

    /**
     *
     * @param value parameter which gets logged
     * @param value2 parameter which gets logged
     */
    public void logInteger(final int value, final int value2) {
        Log.d(TAG, "logInteger() #1: " + value + " #2: " + value2);
    }

    /**
     * Logs parameter to the console.
     *
     * It is selectable if the calling method's name should get logged.
     *
     * @param logWithTrace Set to true if calling method name should get logged
     * @param value parameter which gets logged
     */
    public void logIntegerTrace(final boolean logWithTrace, final int value) {
        if (logWithTrace) {
            Log.d(TAG, "logInteger() #1: " + value);
            Log.d(TAG, "> Caller -> " + getCallingMethodName());
        } else {
            Log.d(TAG, "logInteger() #1: " + value);
        }
    }

    /**
     * Logs the paramenter to the android logger.
     *
     * @param value parameter
     */
    public void logLong(final long value) {
        Log.d(TAG, "logLong()    #1: " + value);
    }
}
