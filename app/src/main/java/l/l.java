package l;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;
import android.view.View.*;
import android.content.*;
import android.net.*;
import android.content.pm.*;
import android.widget.LinearLayout.*;
import android.util.*;
import android.graphics.drawable.*;
import android.text.*;
import android.text.style.*;
import android.graphics.*;
import djwdj.wmzw.*;
import android.view.animation.*;

public class l extends Activity implements OnClickListener
{
	ScrollView sc;
	LinearLayout l,lo,ll;
	LayoutParams lp=new LayoutParams(-1,-2);

	AlphaAnimation a;
	Button b;
	TextView t;
	
	int w,m,p;
	float d,z;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		DisplayMetrics dm = getResources().getDisplayMetrics();
		d = dm.density;
		w=dm.widthPixels;
		m=w/60;
		p=w/36;
		z=w/d/20;
		
		lp.setMargins(m,m,m,m);
		
		l=new LinearLayout(this);
		//l.setOrientation(1);
		l.setPadding(p,p,p,p);
		l.setGravity(Gravity.CENTER);
		l.setOnClickListener(this);
		
		a=new AlphaAnimation(0,1);
		a.setDuration(300);
		l.startAnimation(a);
		
		lo=new LinearLayout(this);
		lo.setPadding(p,p,p,p);
		lo.setClickable(true);
		lo.setOrientation(1);
		lo.setBackgroundDrawable(d(w/10,0xbbcccccc));
		lo.setLayoutParams(lp);
		l.addView(lo);

		sc=new ScrollView(this);
		lo.addView(sc);

		ll=new LinearLayout(this);
		ll.setOrientation(LinearLayout.VERTICAL);
		sc.addView(ll);
		
		t(sb(getString(R.string.l),getString(R.string.i)));
		
		b(0,"★模块开关★");
		b(1,s());
		b(31,"作品主页");
		b(32,"基友交流");
		b(33,"打赏支持");
		setContentView(l);
	}

	@Override
	public void onClick(View v)
	{
		switch(v.getId())
		{
			case 0:
				startActivity(new Intent().setClassName("de.robv.android.xposed.installer","de.robv.android.xposed.installer.WelcomeActivity"));
				break;
			case 1:
				if(getPackageManager().getComponentEnabledSetting(c())==0)
					getPackageManager().setComponentEnabledSetting(c(),2,1);
				else
					getPackageManager().setComponentEnabledSetting(c(),0,1);
				((Button)v).setText(s());
				break;
			case 31:
				cool(getPackageName());

				break;
			case 32:
				try
				{
					String s;
					//s="mqqopensdkapi://bizAgent/qm/qr?url=http%3A%2F%2Fqm.qq.com%2Fcgi-bin%2Fqm%2Fqr%3Ffrom%3Dapp%26p%3Dandroid%26k%3DIibhDCO5YTffQ9Cw-fRzWl-fO0y_Qjdp";
					s="bXFxb3BlbnNka2FwaTovL2JpekFnZW50L3FtL3FyP3VybD1odHRwJTNBJTJGJTJGcW0ucXEuY29tJTJGY2dpLWJpbiUyRnFtJTJGcXIlM0Zmcm9tJTNEYXBwJTI2cCUzRGFuZHJvaWQlMjZrJTNESWliaERDTzVZVGZmUTlDdy1mUnpXbC1mTzB5X1FqZHA";
					s=new String(android.util.Base64.decode(s,android.util.Base64.DEFAULT));
					startActivity(new Intent(null,Uri.parse(s)));

				}
				catch(Exception e)
				{
					Toast("打开QQ失败");
				}
				startActivity(new Intent(null,Uri.parse("mqqopensdkapi://bizAgent/qm/qr?url=http%3A%2F%2Fqm.qq.com%2Fcgi-bin%2Fqm%2Fqr%3Ffrom%3Dapp%26p%3Dandroid%26k%3D4XmeCQPt9NhyQhm8kE7UQ2gIfxf3eO7g")));
				break;
			case 33:
				try
				{
					String s;
					//s="alipays://platformapi/startapp?saId=10000007&clientVersion=3.7.0.0718&qrcode=https://qr.alipay.com/tsx03791nki4qabwu92vi97";
					s="YWxpcGF5czovL3BsYXRmb3JtYXBpL3N0YXJ0YXBwP3NhSWQ9MTAwMDAwMDcmY2xpZW50VmVyc2lvbj0zLjcuMC4wNzE4JnFyY29kZT1odHRwczovL3FyLmFsaXBheS5jb20vdHN4MDM3OTFua2k0cWFid3U5MnZpOTc";
					s=new String(android.util.Base64.decode(s,android.util.Base64.DEFAULT));
					startActivity(new Intent(null,Uri.parse(s)));
					Toast("请留言加上：指纹");
				}
				catch(Exception e)
				{
					Toast("打开支付宝失败");
				}
				break;
			default:finish();
		}
	}

	String s()
	{
		if(getPackageManager().getComponentEnabledSetting(c())==0)
			return "★隐藏图标★";
		else
			return "★显示图标★";
	}
	
	SpannableStringBuilder sb(String b,String s)
	{
		SpannableStringBuilder sb = new SpannableStringBuilder();
		sb.append(b);
		sb.append("\n");
		sb.append(s);
		sb.setSpan(new RelativeSizeSpan(2),0,b.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		sb.setSpan(new StyleSpan(Typeface.BOLD_ITALIC), 0, b.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		sb.setSpan(new RelativeSizeSpan(0.8f),b.length()+1,b.length()+1+s.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		sb.setSpan(new StyleSpan(Typeface.ITALIC), b.length()+1,b.length()+1+s.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		return sb;
	}
	
	void t(CharSequence s)
	{
		t = new TextView(this);
		t.setText(s); 
		t.setTextSize(z);
		t.setTextColor(0xffff5555);
		t.setGravity(Gravity.CENTER);
		ll.addView(t);
	}
	void b(int i,CharSequence s)
	{
		b=new Button(this);
		b.setId(i);
		b.setText(s);
		b.setTextColor(0xffffffff);
		b.setTextSize(z);
		b.setBackgroundDrawable(d(w/16,0xffff5556));
		b.setPadding(p,p,p,p);
		b.setLayoutParams(lp);
		b.setOnClickListener(this);
		ll.addView(b);
	}
	
    ComponentName c()
	{
		return new ComponentName(this, i.class);
	}
	
	Drawable d(int r,int c)
	{
		GradientDrawable d=new GradientDrawable();
		d.setColor(c);
		d.setCornerRadius(r);
		d.setStroke(2, 0xffeeeeee);
		return d;
	}
	
	void Toast(CharSequence s)
	{
		Toast.makeText(this,s,50).show();
	}
	
	void cool(String s)
	{
		Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse(String.format("https://www.coolapk.com/apk/%s",s)));
		try
		{
			startActivity(i.setPackage("com.coolapk.market"));
		}
		catch (Exception e)
		{
			startActivity(i.setPackage(null));
		}
	}
}
