package l;

import android.app.*;
import android.os.*;
import android.content.*;

public class i extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		startActivity(new Intent().setClassName(this,"l.l"));
		finish();
	}

}
