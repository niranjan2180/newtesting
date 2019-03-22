package com.eisedo.eisedo.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.widget.EditText;
import android.widget.Toast;

import com.eisedo.eisedo.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    public static final String dateFormat = "yyyy-MM-dd HH:mm:ssZ";

    public static final String displayFormat = "dd/MM/yyyy";

    public static final String displayTimeFormat = "dd/MM/yyyy HH:mm";

    public static String changeToDateFormat(String dateString) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(displayFormat);

        try {
            Date date = simpleDateFormat.parse(dateString);
            String formatedDate = new SimpleDateFormat(displayFormat).format(date);
//            Date save = new SimpleDateFormat(dateFormat).parse(formatedDate);
            return formatedDate;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Date stringToDate(String stringDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(displayFormat);
        try {
            Date date = simpleDateFormat.parse(stringDate);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

//    public  static String convertToDisplayDate(Date date){
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(displayFormat);
//        String displaDate  = simpleDateFormat.format(date);
//    }

    public static String displayDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(displayFormat);
        String datae = simpleDateFormat.format(date);
        return datae;
    }

    public static String displayDateTime(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(displayTimeFormat);
        String datae = simpleDateFormat.format(date);
        return datae;
    }



    public static String displayDate(String displayDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        return simpleDateFormat.format(displayDate);
    }

    public static void showValidationString(String s, Context context) {
        Toast.makeText(context, "Enter Task Name", Toast.LENGTH_SHORT).show();
    }

    public static String diaplayDateMon(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMM");
        return simpleDateFormat.format(date);
    }

    public static String getEditTextValue(EditText editTextValue){
        if (editTextValue.getText().length() ==0){
            return "";
        }
        return editTextValue.getText().toString();
    }

    public static ColorStateList getColorList(int bucket, Context context) {

        ColorStateList myColorStateList = new ColorStateList(
                new int[][]{
                        new int[]{android.R.attr.state_window_focused},
                },
                new int[]{
                        context.getResources().getColor(R.color.green),
                }
        );

        switch (bucket) {
            case 0:
                myColorStateList = new ColorStateList(
                        new int[][]{
                                new int[]{android.R.attr.state_window_focused},
                        },
                        new int[]{
                                context.getResources().getColor(R.color.green),
                        }
                );

                break;
            case 1:
                myColorStateList = new ColorStateList(
                        new int[][]{
                                new int[]{android.R.attr.state_window_focused},
                        },
                        new int[]{
                                context.getResources().getColor(R.color.blue_light),
                        }
                );
                break;
            case 2:
                myColorStateList = new ColorStateList(
                        new int[][]{
                                new int[]{android.R.attr.state_window_focused},
                        },
                        new int[]{
                                context.getResources().getColor(R.color.orange),
                        }
                );
                break;
            case 3:
                myColorStateList = new ColorStateList(
                        new int[][]{
                                new int[]{android.R.attr.state_window_focused},
                        },
                        new int[]{
                                context.getResources().getColor(R.color.red_light),
                        }
                );
                break;
            default:
                break;
        }
        return myColorStateList;
    }

//    public static void setDateSelection(TextView dateandTime, InverseBindingListener inverseBindingListener) {
//
//        final Calendar c = Calendar.getInstance();
//        int mYear = c.get(Calendar.YEAR);
//        int mMonth = c.get(Calendar.MONTH);
//        int mDay = c.get(Calendar.DAY_OF_MONTH);
//
//        if (context != null) {
//            DatePickerDialog datePickerDialog = new DatePickerDialog(context, ((view, year, month, dayOfMonth) -> {
//
//                dateandTime.setText(Util.changeToDateFormat(dayOfMonth + "/" + (month + 1) + "/" + year));
//                inverseBindingListener.onChange();
////                setTimeSelection(dateandTime, inverseBindingListener);
//            }), mYear, mMonth, mDay);
//            datePickerDialog.show();
//        }
//    }
}