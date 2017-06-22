package nhatto.com;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private FloatingActionButton fabMenu, fabAdd, fabSearch;
    Animation Move_trai, Move_tren, Back_trai, Back_tren;
    boolean moveBack = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidget();
    }

    private void initWidget() {
        fabMenu = (FloatingActionButton) findViewById(R.id.fab_menu);
        fabAdd = (FloatingActionButton) findViewById(R.id.fab_add);
        fabSearch = (FloatingActionButton) findViewById(R.id.fab_search);

        Move_trai = AnimationUtils.loadAnimation(this,R.anim.move_trai);
        Move_tren = AnimationUtils.loadAnimation(this,R.anim.move_tren);

        Back_trai = AnimationUtils.loadAnimation(this,R.anim.back_trai);
        Back_tren = AnimationUtils.loadAnimation(this,R.anim.back_tren);

        fabMenu.setOnClickListener(this);
        fabAdd.setOnClickListener(this);
        fabSearch.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fab_menu:
                ////// TODO: 17/06/2017
                if (moveBack == false){
                    hienFab();
                    moveBack = true;
                }else {
                    anFab();
                    moveBack = false;
                }

                break;
            case R.id.fab_add:
                ////// TODO: 17/06/2017
                Toast.makeText(this, "Bạn đã chọn add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fab_search:
                ////// TODO: 17/06/2017
                Toast.makeText(this, "Bạn đã chọn search", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void anFab() {
        FrameLayout.LayoutParams paramsTrai = (FrameLayout.LayoutParams) fabAdd.getLayoutParams();
        paramsTrai.rightMargin -= (int) (fabAdd.getWidth() * 1.7);
        fabAdd.setLayoutParams(paramsTrai);
        fabAdd.startAnimation(Back_trai);

        FrameLayout.LayoutParams paramsTren = (FrameLayout.LayoutParams) fabSearch.getLayoutParams();
        paramsTren.bottomMargin -= (int) (fabSearch.getWidth() * 1.7);
        fabSearch.setLayoutParams(paramsTren);
        fabSearch.startAnimation(Back_tren);
    }

    private void hienFab() {
        FrameLayout.LayoutParams paramsTrai = (FrameLayout.LayoutParams) fabAdd.getLayoutParams();
        paramsTrai.rightMargin = (int) (fabAdd.getWidth() * 2.5);
        fabAdd.setLayoutParams(paramsTrai);
        fabAdd.startAnimation(Move_trai);

        FrameLayout.LayoutParams paramsTren = (FrameLayout.LayoutParams) fabSearch.getLayoutParams();
        paramsTren.bottomMargin = (int) (fabSearch.getWidth() * 2.5);
        fabSearch.setLayoutParams(paramsTren);
        fabSearch.startAnimation(Move_tren);
    }

}
