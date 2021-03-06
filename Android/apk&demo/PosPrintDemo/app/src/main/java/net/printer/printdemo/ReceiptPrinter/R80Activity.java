package net.printer.printdemo.ReceiptPrinter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import net.posprinter.posprinterface.ProcessData;
import net.posprinter.posprinterface.TaskCallback;
import net.posprinter.utils.BitmapProcess;
import net.posprinter.utils.BitmapToByteData;
import net.posprinter.utils.DataForSendToPrinterPos80;
import net.posprinter.utils.StringUtils;
import net.printer.printdemo.MainActivity;
import net.printer.printdemo.R;
import net.printer.printdemo.databinding.ActivityMainBinding;
import net.printer.printdemo.databinding.ActivityR80Binding;

import java.util.ArrayList;
import java.util.List;

public class R80Activity extends AppCompatActivity implements View.OnClickListener {
    private ActivityR80Binding binding;
    private Button sample,text,barcode,qrcode,bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_r80);
        binding = ActivityR80Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initview();
    }

    private void initview(){
        sample = findViewById(R.id.bt_rcp);
        text = findViewById(R.id.bt_80text);
        barcode = findViewById(R.id.bt_80barcode);
        qrcode = findViewById(R.id.bt_80qr);
        bitmap = findViewById(R.id.bt_80bitmap);

        sample.setOnClickListener(this);
        text.setOnClickListener(this);
        barcode.setOnClickListener(this);
        qrcode.setOnClickListener(this);
        bitmap.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        int id = view.getId();
        for(int i=0;i<Integer.parseInt(binding.rep.getText().toString());i++) {
            if (id == R.id.bt_rcp) {
//            printSample();
                printText();
                printBarcode();
                printqr();
                printBitmap();
//                printCut();
            }

            if (id == R.id.bt_80text) {
                printText();
            }

            if (id == R.id.bt_80barcode) {
                printBarcode();
            }

            if (id == R.id.bt_80qr) {
                printqr();
            }

            if (id == R.id.bt_80bitmap) {
                printBitmap();

            }
        }
    }

    /**
     * ????????????
     */
    private void printSample(){
        if (MainActivity.ISCONNECT){
            MainActivity.myBinder.WriteSendData(new TaskCallback() {
                @Override
                public void OnSucceed() {
                    Toast.makeText(getApplicationContext(),getString(R.string.send_success),Toast.LENGTH_SHORT).show();

                }

                @Override
                public void OnFailed() {
                    Toast.makeText(getApplicationContext(),getString(R.string.send_failed),Toast.LENGTH_SHORT).show();
                }
            }, new ProcessData() {
                @Override
                public List<byte[]> processDataBeforeSend() {
                    List<byte[]> list = new ArrayList<>();
                    list.add(DataForSendToPrinterPos80.initializePrinter());
                    list.add(DataForSendToPrinterPos80.setAbsolutePrintPosition(60,00));//??????????????????
                    list.add(DataForSendToPrinterPos80.selectCharacterSize(17));//??????????????????
                    list.add(StringUtils.strTobytes("printer"));
                    list.add(DataForSendToPrinterPos80.setAbsolutePrintPosition(100,01));
                    list.add(StringUtils.strTobytes("printer"));
                    list.add(DataForSendToPrinterPos80.printAndFeedLine());
                    list.add(DataForSendToPrinterPos80.printAndFeedLine());

                    list.add(DataForSendToPrinterPos80.initializePrinter());
                    list.add(DataForSendToPrinterPos80.setAbsolutePrintPosition(60,00));
                    list.add(StringUtils.strTobytes("printer"));
                    list.add(DataForSendToPrinterPos80.setAbsolutePrintPosition(100,01));
                    list.add(StringUtils.strTobytes("printer"));
                    list.add(DataForSendToPrinterPos80.printAndFeedLine());

                    list.add(DataForSendToPrinterPos80.initializePrinter());
                    list.add(DataForSendToPrinterPos80.setAbsolutePrintPosition(60,00));
                    list.add(StringUtils.strTobytes("printer"));
                    list.add(DataForSendToPrinterPos80.setAbsolutePrintPosition(100,01));
                    list.add(StringUtils.strTobytes("printer"));
                    list.add(DataForSendToPrinterPos80.printAndFeedLine());

                    list.add(DataForSendToPrinterPos80.initializePrinter());
                    list.add(DataForSendToPrinterPos80.setAbsolutePrintPosition(60,00));
                    list.add(StringUtils.strTobytes("printer"));
                    list.add(DataForSendToPrinterPos80.setAbsolutePrintPosition(100,01));
                    list.add(StringUtils.strTobytes("printer"));
                    list.add(DataForSendToPrinterPos80.printAndFeedLine());

                    list.add(DataForSendToPrinterPos80.initializePrinter());
                    list.add(DataForSendToPrinterPos80.setAbsolutePrintPosition(60,00));
                    list.add(StringUtils.strTobytes("printer"));
                    list.add(DataForSendToPrinterPos80.setAbsolutePrintPosition(100,01));
                    list.add(StringUtils.strTobytes("printer"));
                    list.add(DataForSendToPrinterPos80.printAndFeedLine());

                    list.add(DataForSendToPrinterPos80.initializePrinter());
                    list.add(DataForSendToPrinterPos80.setAbsolutePrintPosition(60,00));
                    list.add(StringUtils.strTobytes("printer"));
                    list.add(DataForSendToPrinterPos80.setAbsolutePrintPosition(100,01));
                    list.add(StringUtils.strTobytes("printer"));
                    list.add(DataForSendToPrinterPos80.printAndFeedLine());

                    list.add(DataForSendToPrinterPos80.initializePrinter());
                    list.add(DataForSendToPrinterPos80.setAbsolutePrintPosition(60,00));
                    list.add(StringUtils.strTobytes("printer"));
                    list.add(DataForSendToPrinterPos80.setAbsolutePrintPosition(100,01));
                    list.add(StringUtils.strTobytes("printer"));
                    list.add(DataForSendToPrinterPos80.printAndFeedLine());

                    return list;
                }
            });
        }else {
            Toast.makeText(getApplicationContext(),getString(R.string.connect_first),Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * ????????????
     */
    private void printText(){

        if (MainActivity.ISCONNECT){
            MainActivity.myBinder.WriteSendData(new TaskCallback() {
                @Override
                public void OnSucceed() {
                    Toast.makeText(getApplicationContext(),getString(R.string.send_success),Toast.LENGTH_SHORT).show();

                }

                @Override
                public void OnFailed() {
                    Toast.makeText(getApplicationContext(),getString(R.string.send_failed),Toast.LENGTH_SHORT).show();
                }
            }, new ProcessData() {
                @Override
                public List<byte[]> processDataBeforeSend() {
                    List<byte[]> list = new ArrayList<>();
                    list.add(DataForSendToPrinterPos80.initializePrinter());
                    list.add(StringUtils.strTobytes("1234567890qwertyuiopakjbdscm nkjdv mcdskjb"));
                    list.add(DataForSendToPrinterPos80.printAndFeedLine());
                    return list;
                }
            });
        }else {
            Toast.makeText(getApplicationContext(),getString(R.string.connect_first),Toast.LENGTH_SHORT).show();
        }

    }

    /**
     ??????????????????
     */
    private void printBarcode(){
        if (MainActivity.ISCONNECT){
            MainActivity.myBinder.WriteSendData(new TaskCallback() {
                @Override
                public void OnSucceed() {
                    Toast.makeText(getApplicationContext(),getString(R.string.send_success),Toast.LENGTH_SHORT).show();

                }

                @Override
                public void OnFailed() {
                    Toast.makeText(getApplicationContext(),getString(R.string.send_failed),Toast.LENGTH_SHORT).show();
                }
            }, new ProcessData() {
                @Override
                public List<byte[]> processDataBeforeSend() {
                    List<byte[]> list = new ArrayList<>();
                    //?????????????????????????????????
                    list.add(DataForSendToPrinterPos80.initializePrinter());
                    //??????????????????
                    list.add(DataForSendToPrinterPos80.selectAlignment(1));
                    //??????HRI????????????
                    list.add(DataForSendToPrinterPos80.selectHRICharacterPrintPosition(02));
                    //??????????????????
                    list.add(DataForSendToPrinterPos80.setBarcodeWidth(2));
                    //????????????
                    list.add(DataForSendToPrinterPos80.setBarcodeHeight(80));
                    //???????????????????????????73???code128??????????????????????????????????????????????????????
                    list.add(DataForSendToPrinterPos80.printBarcode(73,10,"{B12345678"));
                    //????????????
                    list.add(DataForSendToPrinterPos80.printAndFeedLine());
                    return list;
                }
            });
        }else {
            Toast.makeText(getApplicationContext(),getString(R.string.connect_first),Toast.LENGTH_SHORT).show();
        }
    }
    /**
     * ??????????????????
     */
    private void printqr(){
        if (MainActivity.ISCONNECT){
            MainActivity.myBinder.WriteSendData(new TaskCallback() {
                @Override
                public void OnSucceed() {
                    Toast.makeText(getApplicationContext(),getString(R.string.send_success),Toast.LENGTH_SHORT).show();

                }

                @Override
                public void OnFailed() {
                    Toast.makeText(getApplicationContext(),getString(R.string.send_failed),Toast.LENGTH_SHORT).show();
                }
            }, new ProcessData() {
                @Override
                public List<byte[]> processDataBeforeSend() {
                    List<byte[]> list = new ArrayList<>();
                    //?????????????????????????????????
                    list.add(DataForSendToPrinterPos80.initializePrinter());
                    //??????????????????
                    list.add(DataForSendToPrinterPos80.selectAlignment(1));
                    list.add(DataForSendToPrinterPos80.printQRcode(3,48,"www.zywell.net"));
                    list.add(DataForSendToPrinterPos80.printAndFeedLine());
                    return list;
                }
            });
        }else {
            Toast.makeText(getApplicationContext(),getString(R.string.connect_first),Toast.LENGTH_SHORT).show();
        }
    }

    private void printBitmap(){
//        final Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.test);
        final Bitmap bitmap1 =  BitmapProcess.compressBmpByYourWidth
                (BitmapFactory.decodeResource(getResources(), R.drawable.test),300);

        if (MainActivity.ISCONNECT){
            MainActivity.myBinder.WriteSendData(new TaskCallback() {
                @Override
                public void OnSucceed() {
                    Toast.makeText(getApplicationContext(),getString(R.string.send_success),Toast.LENGTH_SHORT).show();

                }

                @Override
                public void OnFailed() {
                    Toast.makeText(getApplicationContext(),getString(R.string.send_failed),Toast.LENGTH_SHORT).show();
                }
            }, new ProcessData() {
                @Override
                public List<byte[]> processDataBeforeSend() {
                    List<byte[]> list = new ArrayList<>();
                    list.add(DataForSendToPrinterPos80.initializePrinter());
                    List<Bitmap> blist= new ArrayList<>();
                    blist = BitmapProcess.cutBitmap(150,bitmap1);
                    for (int i= 0 ;i<blist.size();i++){
                        list.add(DataForSendToPrinterPos80.printRasterBmp(0,blist.get(i), BitmapToByteData.BmpType.Dithering, BitmapToByteData.AlignType.Center,576));
                    }
//                    list.add(StringUtils.strTobytes("1234567890qwertyuiopakjbdscm nkjdv mcdskjb"));
                    list.add(DataForSendToPrinterPos80.printAndFeedLine());
                    return list;
                }
            });
        }else {
            Toast.makeText(getApplicationContext(),getString(R.string.connect_first),Toast.LENGTH_SHORT).show();
        }
    }
    private void printCut(){
        if (MainActivity.ISCONNECT){
            MainActivity.myBinder.WriteSendData(new TaskCallback() {
                @Override
                public void OnSucceed() {
                    Toast.makeText(getApplicationContext(),getString(R.string.send_success),Toast.LENGTH_SHORT).show();

                }

                @Override
                public void OnFailed() {
                    Toast.makeText(getApplicationContext(),getString(R.string.send_failed),Toast.LENGTH_SHORT).show();
                }
            }, new ProcessData() {
                @Override
                public List<byte[]> processDataBeforeSend() {
                    List<byte[]> list = new ArrayList<>();
                    //?????????????????????????????????
                    list.add(DataForSendToPrinterPos80.initializePrinter());
                    //????????????
//                    list.add(DataForSendToPrinterPos80.selectCutPagerModerAndCutPager(0));
                    //??????????????????
                    list.add(DataForSendToPrinterPos80.selectCutPagerModerAndCutPager(0x42,0x66));
                    return list;
                }
            });
        }else {
            Toast.makeText(getApplicationContext(),getString(R.string.connect_first),Toast.LENGTH_SHORT).show();
        }
    }
}
