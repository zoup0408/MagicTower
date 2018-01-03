package com.example.alan.magictower.view;

import android.content.Context;
import android.support.v7.app.AppCompatDialog;
import android.support.v7.widget.AppCompatTextView;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.example.alan.magictower.R;
import com.example.alan.magictower.role.Role;
import com.example.alan.magictower.util.DimenUtil;

/**
 * Function :
 * Modify Date : 2018/1/3
 * @Author : Alan
 * Issue : TODO
 * Whether Solve :
 */

public class MagicLoader {

    private static final int LOADER_SIZE_SCALE = 2;
    private static AppCompatTextView tv_hero_life;
    private static AppCompatTextView tv_hero_attack;
    private static AppCompatTextView tv_hero_defense;
    private static AppCompatTextView tv_monster_life;
    private static AppCompatTextView tv_monster_attack;
    private static AppCompatTextView tv_monster_defense;
    private static AppCompatDialog dialogDuel;

    public static void initDialogDuel(Context context) {
        if (dialogDuel == null) {

            dialogDuel = new AppCompatDialog(context, R.style.loading_dialog);
            dialogDuel.setContentView(R.layout.dialog_loader);
            tv_hero_life = dialogDuel.findViewById(R.id.tv_hero_life);
            tv_hero_attack = dialogDuel.findViewById(R.id.tv_hero_attack);
            tv_hero_defense = dialogDuel.findViewById(R.id.tv_hero_defense);
            tv_monster_attack = dialogDuel.findViewById(R.id.tv_monster_attack);
            tv_monster_defense = dialogDuel.findViewById(R.id.tv_monster_defense);
            tv_monster_life =dialogDuel.findViewById(R.id.tv_monster_life);
            dialogDuel.setCanceledOnTouchOutside(false);
        }

        int screenWidth = DimenUtil.getScreenWidth(context);
        int screenHeight = DimenUtil.getScreenHeight(context);
        Window window = dialogDuel.getWindow();
        if (window != null) {
            WindowManager.LayoutParams layoutParams = window.getAttributes();
            layoutParams.gravity = Gravity.CENTER;
            layoutParams.width = screenWidth*3/4;
            layoutParams.height = screenHeight / LOADER_SIZE_SCALE;
            window.setAttributes(layoutParams);
        }
    }

    public static void showDialogDuel(Role hero, Role monster) {
        if (dialogDuel != null) {

            tv_hero_life.setText("Life:"+hero.getLife());
            tv_hero_attack.setText("Attack:"+hero.getmAttack());
            tv_hero_defense.setText("Defense:"+hero.getmDefense());

            tv_monster_life.setText("Life:"+monster.getLife());
            tv_monster_attack.setText("Attack:"+monster.getmAttack());
            tv_monster_defense.setText("Defense:"+monster.getmDefense());

            dialogDuel.show();
        }
    }


}
