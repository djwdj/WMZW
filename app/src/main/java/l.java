import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;
import android.app.*;

public class l extends Application implements IXposedHookLoadPackage 
{
    public void handleLoadPackage(LoadPackageParam lp) throws Throwable 
	{
        if (lp.packageName.equals("com.android.systemui"))
		{
            String className = "com.android.keyguard.KeyguardUpdateMonitor";
            String methodName = "isUnlockingWithFingerprintAllowed";
            try {
                XposedHelpers.findAndHookMethod(className, lp.classLoader, methodName, new Object[]{XC_MethodReplacement.returnConstant(true)});
            } catch (Throwable e) {
            }
            methodName = "isUnlockWithFingerPrintPossible";
            try {
                XposedHelpers.findAndHookMethod(className, lp.classLoader, methodName, new Object[]{Integer.TYPE, XC_MethodReplacement.returnConstant(true)});
            } catch (Throwable e) {
            }
            methodName = "isFingerprintDisabled";
            try {
                XposedHelpers.findAndHookMethod(className, lp.classLoader, methodName, new Object[]{Integer.TYPE, XC_MethodReplacement.returnConstant(false)});
            } catch (Throwable e) {
            }
            methodName = "isUnlockCompleted";
            try {
                XposedHelpers.findAndHookMethod(className, lp.classLoader, methodName, new Object[]{XC_MethodReplacement.returnConstant(true)});
            } catch (Throwable e) {
            }
            className = "com.android.keyguard.KeyguardUpdateMonitor$StrongAuthTracker";
            methodName = "isUnlockingWithFingerprintAllowed";
            try {
                XposedHelpers.findAndHookMethod(className, lp.classLoader, methodName, new Object[]{XC_MethodReplacement.returnConstant(true)});
            } catch (Throwable e) {
            }
            className = "com.android.internal.widget.LockPatternUtils$StrongAuthTracker";
            methodName = "isFingerprintAllowedForUser";
            try {
                XposedHelpers.findAndHookMethod(className, lp.classLoader, methodName, new Object[]{Integer.TYPE, XC_MethodReplacement.returnConstant(true)});
            } catch (Throwable e) {
            }
        }
    }
}
