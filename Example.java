package org.d3ifcool.utang;

import android.text.TextUtils;
import android.widget.DatePicker;

import org.d3ifcool.utang.FormActivity;
import org.d3ifcool.utang.MainActivity;
import org.d3ifcool.utang.R;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import androidx.test.espresso.contrib.PickerActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class DataDriven {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void dataDriven() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openFile("data.csv")));
        String line = "";

        while ((line = bufferedReader.readLine()) != null) {
            String[] str = line.split(",");

            String create = str[0].toString();
            String nama = str[1].toString();
            String jumlah = str[2].toString();
            String phone = str[3].toString();
            String deadline = str[4].toString();
            String keterangan = str[5].toString();
            String kategori = str[6].toString();

            onView(withId(R.id.floatingbutton_main_utang)).perform(click());

            if (!TextUtils.isEmpty(create)) {
                String year = create.substring(0,4);
                String month = create.substring(4,6);
                String day = create.substring(6);

                onView(withId(R.id.edittext_form_tanggal_peminjaman)).perform(click());
                onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).perform(PickerActions.setDate(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day)));
                onView(withId(android.R.id.button1)).perform(click());
            }

            onView(withId(R.id.edittext_form_nama)).perform(typeText(nama), closeSoftKeyboard());

            onView(withId(R.id.edittext_form_jumlah)).perform(typeText(jumlah), closeSoftKeyboard());

            onView(withId(R.id.editText_form_phone)).perform(typeText(phone), closeSoftKeyboard());

            if (!TextUtils.isEmpty(deadline)) {
                String year = deadline.substring(0,4);
                String month = deadline.substring(4,6);
                String day = deadline.substring(6);

                onView(withId(R.id.edittext_form_jatuh_tempo)).perform(click());
                onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).perform(PickerActions.setDate(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day)));
                onView(withId(android.R.id.button1)).perform(click());
            }

            onView(withId(R.id.edittext_form_keterangan)).perform(typeText(keterangan), closeSoftKeyboard());

            if (kategori == "1") {
                onView(withId(R.id.radiobutton_form_dipinjam)).perform(click());
            } else if (kategori == "1") {
                onView(withId(R.id.radioButton_form_meminjam)).perform(click());
            }

            onView(withId(R.id.button_form_tambah)).perform(click());

        }
    }

    private InputStream openFile(String filename) throws IOException {
        return getClass().getClassLoader().getResourceAsStream(filename);
    }
}
