package net.lzzy.algorithm;
import android.annotation.SuppressLint;
import android.net.sip.SipAudioCall;
import android.net.sip.SipSession;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import net.lzzy.algorithm.xdv.BaseSearch;
import net.lzzy.algorithm.xdv.BaseSort;
import net.lzzy.algorithm.xdv.SearchFactory;
import net.lzzy.algorithm.xdv.SortFactory;

import java.util.Locale;
import java.util.Objects;
import java.util.Random;
/**
 * @author Administrator
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Integer[] items;
    private EditText edtItems;
    private TextView tvResult;
    private  Spinner spinner;
    private LinearLayout container;
    private Spinner spSearch;
    private Button btnSort;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtItems = findViewById(R.id.activity_main_edt_items);
        initViews();
        initSpinner();
    }
    @SuppressLint("WrongViewCast")

    public void initSearch() {
        spinner=findViewById(R.id.activity_main_sp);
        spSearch.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,SortFactory.getSortNames()));
        container=findViewById(R.id.bt1);
        findViewById(R.id.bt1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetSearch();
            }
        });
       resetSearch();
    }
               private View.OnClickListener listener=new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        BaseSearch<Integer>search=SearchFactory.getInstance(spSearch.getSelectedItemPosition(),items);
        if (search!=null){
            int pos= (int) search.search(v.getId());
            tvResult.setText("该元素位于数组的第".concat(String.valueOf(pos+1))+"位");
        }
    }
};
    private void resetSearch(){
        container.removeAllViews();
        generateItems();
        btnSort.callOnClick();
        for (Integer i:items){
            Button btn=new Button(this);
            btn.setText(String.format(i.toString(), Locale.CHINA));
            btn.setId(i);
            btn.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,1));
            btn.setOnClickListener(listener);
            container.addView(btn);
        }

    }
    private void initSpinner(){
        spinner=findViewById(R.id.activity_main_sp);
        String[]names={"选择排序","直接选择排序","希尔排序"};
        spinner.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,names));

    }

    private void initViews() {
        edtItems =findViewById(R.id.activity_main_edt_items);
        findViewById(R.id.activity_main_btn_generate).setOnClickListener(this);
        findViewById(R.id.activity_main_btn_sort).setOnClickListener(this);
        tvResult = findViewById(R.id.activity_main_tv_result);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_main_btn_generate:
                generateItems();
                displayItems(edtItems);
                break;
            case R.id.activity_main_btn_sort:
                BaseSort<Integer>sort= SortFactory.getInstance(spinner.getSelectedItemPosition(),items);
                BaseSort<Integer>sortNotNull= Objects.requireNonNull(sort);
                sortNotNull.sortwithtime();
                String result=sort.getResult();
                tvResult.setText(result);
                Toast.makeText(this, "总时长："+sort.getDuration(), Toast.LENGTH_SHORT).show();
                break;



            default:
                break;
        }
    }
    private void displayItems(TextView tv) {
        String display = "";
        for (Integer i : items) {
            display = display.concat(i + ",");
        }
        display = display.substring(0, display.length() - 1);
        tv.setText(display);
    }

    private void directSort() {
        //分别有序区和无序区，每一趟排序都在无序区做次对比，记录对比区域的最小元素的位置
        //然后把无序区第一个元素和所有记录的最小元素进行交易，有区域多一个，循环往复直至无直区
        //元数数量为0
        //todo:直接选择排序的具体实现
        for (int i = 0; i < items.length - 1; i++) {
            int ninpos = i;
            for (int j = i + 1; j < items.length; j++) {
                if (items[ninpos].compareTo(items[j]) > 0) {
                    ninpos = j;
                    //dth
                }
            }
            swap(ninpos, i);
        }
    }
    private void swap(int i, int j){
        int temp;//定义临时变量变量
        temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    private void generateItems() {
        items = new Integer[10];
        Random generator = new Random();
        for (int i = 0; i < items.length; i++) {
            items[i] = generator.nextInt(99);
        }
    }
}