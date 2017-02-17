package moe.feng.alipay.zerosdk;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AboutMeActivity extends AppCompatActivity {

    private TextView tv_about_msg;
    private Button btn_donate_alipay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);
        tv_about_msg = (TextView) findViewById(R.id.tv_about_msg);
        tv_about_msg.setAutoLinkMask(Linkify.ALL);
        tv_about_msg.setMovementMethod(LinkMovementMethod
                                         .getInstance());

        btn_donate_alipay = (Button) findViewById(R.id.btn_donate_alipay);
        boolean hasInstalledAlipayClient = AlipayZeroSdk.hasInstalledAlipayClient(this);
        if(hasInstalledAlipayClient){
            btn_donate_alipay.setEnabled(true);
            btn_donate_alipay.setClickable(true);
        }else{
            btn_donate_alipay.setEnabled(false);
            btn_donate_alipay.setClickable(false);
        }
        btn_donate_alipay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlipayZeroSdk.startAlipayClient(AboutMeActivity.this,"aex03674qm0prhhrtepjcbb");
            }
        });
    }

    public void paypalMe(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.paypal.me/yejg"));
        startActivity(intent);
    }


}
