package com.example.manishchoudhary.formbuilder.CustomForm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.manishchoudhary.formbuilder.Helper.Validation;
import com.example.manishchoudhary.formbuilder.Helper.ViewType;
import com.example.manishchoudhary.formbuilder.InterFace.GetAttachView;
import com.example.manishchoudhary.formbuilder.InterFace.GetResultBack;
import com.example.manishchoudhary.formbuilder.InterFace.RemoveViewFromForm;
import com.example.manishchoudhary.formbuilder.R;

import java.util.HashMap;

/**
 * Created by manish.choudhary on 2/11/17.
 */
public final class MyForm extends MyRelativeLayout implements View.OnClickListener, GetAttachView, RemoveViewFromForm {
    /*
    *
    *
    *
    *
    * */
    private MyTextView textView;
    private MyEdittext firstName, lastName, emailAddress, telephone;
    private MyEdittext fax, company, address1, address2, city, zip;
    private MyLinearLayout linearLayout;
    private MyEdittext password, confirmPassword;
    private MyCheckbox agree;
    private MyButton submit;
    private MySpinner countrySpinner, stateSpinner;
    private Context mContext;
    private static HashMap<ViewType, View> viewIDMap;
    private MyScrollView scrollView;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public MyForm(Context context) {
        super(context);
        initializeCustomView(context);
    }

    /*
    *
    *  initializeCustomView method initialize all the view of the layout
    *
    *
    * */

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void initializeCustomView(Context context) {
        mContext = context;
        viewIDMap = new HashMap<>();
        firstName = new MyEdittext(mContext);
        lastName = new MyEdittext(mContext);
        telephone = new MyEdittext(mContext);
        fax = new MyEdittext(mContext);
        company = new MyEdittext(mContext);
        address1 = new MyEdittext(mContext);
        address2 = new MyEdittext(mContext);
        city = new MyEdittext(mContext);
        zip = new MyEdittext(mContext);
        confirmPassword = new MyEdittext(mContext);
        agree = new MyCheckbox(mContext);
        countrySpinner = new MySpinner(mContext);
        stateSpinner = new MySpinner(mContext);
        textView = new MyTextView(mContext);
        emailAddress = new MyEdittext(mContext);
        password = new MyEdittext(mContext);
        submit = new MyButton(mContext);
        linearLayout = new MyLinearLayout(mContext);
        scrollView = new MyScrollView(mContext);
        scrollView.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));
        submit.setOnClickListener(this);
        setOrientation();
        addAllView();
        setInputType();
        setHintInView();
    }


    /*
        *
        *
        *  setInputType method set the validation for inputType
        *
        * */
    private void setInputType() {
        emailAddress.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        password.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
        password.setTransformationMethod(PasswordTransformationMethod.getInstance());
        confirmPassword.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
        confirmPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
        telephone.setInputType(InputType.TYPE_CLASS_NUMBER);
        fax.setInputType(InputType.TYPE_CLASS_NUMBER);
        zip.setInputType(InputType.TYPE_CLASS_NUMBER);
    }

    /*
    *
    * setHintInView method where you can set hint to the specific view
    *
    *
    * */
    private void setHintInView() {
        firstName.setHint(mContext.getResources().getString(R.string.first_name));
        lastName.setHint(mContext.getResources().getString(R.string.last_name));
        emailAddress.setHint(mContext.getResources().getString(R.string.email_address));
        telephone.setHint(mContext.getResources().getString(R.string.telephone));
        fax.setHint(mContext.getResources().getString(R.string.fax));
        company.setHint(mContext.getResources().getString(R.string.company));
        address1.setHint(mContext.getResources().getString(R.string.address1));
        address2.setHint(mContext.getResources().getString(R.string.address2));
        city.setHint(mContext.getResources().getString(R.string.city));
        zip.setHint(mContext.getResources().getString(R.string.zip));
        confirmPassword.setHint(mContext.getResources().getString(R.string.confirm_password));
        password.setHint(mContext.getResources().getString(R.string.password));
        agree.setHint(mContext.getResources().getString(R.string.agree_text));
    }

    /*
    * addAllView method add each form view to the layout
    *
    *
    * */
    @SuppressLint("NewApi")
    private void addAllView() {
        linearLayout.addView(firstName, 0);
        linearLayout.addView(lastName, 1);
        linearLayout.addView(emailAddress, 2);
        linearLayout.addView(telephone, 3);
        linearLayout.addView(fax, 4);
        linearLayout.addView(company, 5);
        linearLayout.addView(address1, 6);
        linearLayout.addView(address2, 7);
        linearLayout.addView(city, 8);
        linearLayout.addView(zip, 9);
        linearLayout.addView(countrySpinner, 10);
        linearLayout.addView(stateSpinner, 11);
        linearLayout.addView(password, 12);
        linearLayout.addView(confirmPassword, 13);
        linearLayout.addView(agree, 14);
        linearLayout.setDefaultLayoutPadding(20);
        addViewInMap();
        scrollView.addView(linearLayout);
        submit.setId(View.generateViewId());
        scrollView.setId(View.generateViewId());
        submit.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) submit.getLayoutParams();
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) scrollView.getLayoutParams();
        params1.addRule(ABOVE, submit.getId());
        this.addView(submit);
        this.addView(scrollView);
    }

    /*
    *
    *   addViewInMap method put each view of the HashMap
    *
    * */
    private void addViewInMap() {
        viewIDMap.put(ViewType.FIRSTNAME, firstName);
        viewIDMap.put(ViewType.LASTNAME, lastName);
        viewIDMap.put(ViewType.EMAILADDRESS, emailAddress);
        viewIDMap.put(ViewType.TELEPHONE, telephone);
        viewIDMap.put(ViewType.FAX, fax);
        viewIDMap.put(ViewType.COMPANY, company);
        viewIDMap.put(ViewType.ADDRESS1, address1);
        viewIDMap.put(ViewType.ADDRESS2, address2);
        viewIDMap.put(ViewType.CITY, city);
        viewIDMap.put(ViewType.ZIP, zip);
        viewIDMap.put(ViewType.COUNTRYSPINNER, countrySpinner);
        viewIDMap.put(ViewType.STATESPINNER, stateSpinner);
        viewIDMap.put(ViewType.PASSWORD, password);
        viewIDMap.put(ViewType.CONFIRMPASSWORD, confirmPassword);
        viewIDMap.put(ViewType.AGREE, agree);
        viewIDMap.put(ViewType.SUBMIT, submit);
    }

    /*
    * setOrientation of the Layout by default it's Vertical
    *
    *
    * */
    private void setOrientation() {
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        textView.setGravity(Gravity.CENTER);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public MyForm(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initializeCustomView(context);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public MyForm(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeCustomView(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyForm(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initializeCustomView(context);
    }

    /*
     *
     *
     *
     *
      */
    @Override
    public void onClick(View view) {
        checkValidation();
    }

    /*
    *
    * All Validations are performed here
    *
    *
    * */
    private void checkValidation() {
        boolean validation = false;
        if (firstName.getText().toString().equals("")) {
            firstName.requestFocus();
            firstName.setError(mContext.getString(R.string.first_name_required));
        } else if (lastName.getText().toString().equals("")) {
            lastName.setError(mContext.getString(R.string.last_name_required));
            lastName.requestFocus();
        } else if (emailAddress.getText().toString().equals("")) {
            emailAddress.setError(mContext.getString(R.string.email_name_required));
            emailAddress.requestFocus();
        } else if (!Validation.isEmailValid(emailAddress.getText().toString())) {
            emailAddress.setError(mContext.getString(R.string.enter_valid_email_address));
            emailAddress.requestFocus();
        } else if (telephone.getText().toString().length() <= 4) {
            telephone.requestFocus();
            telephone.setError(mContext.getString(R.string.telephone_name_required));
        } else if (address1.getText().toString().equals("")) {
            address1.setError(mContext.getString(R.string.address_name_required));
            address1.requestFocus();
        } else if (city.getText().toString().equals("")) {
            city.setError(mContext.getString(R.string.city_is_required));
            city.requestFocus();
        } else if (zip.getText().toString().equals("")) {
            zip.setError(mContext.getString(R.string.zip_is_required));
            zip.requestFocus();
        } else if (password.getText().toString().equals("")) {
            password.requestFocus();
            password.setError(mContext.getString(R.string.password_is_required));
        } else if (confirmPassword.getText().toString().equals("")) {
            confirmPassword.requestFocus();
            confirmPassword.setError(mContext.getString(R.string.confirm_password_is_required));
        } else if (!password.getText().toString().equals(confirmPassword.getText().toString())) {
            confirmPassword.requestFocus();
            confirmPassword.setError(mContext.getString(R.string.confirm_and_password_should_same));
        } else if (!agree.isChecked()) {
            agree.requestFocus();
            Toast.makeText(getContext(), "Please check the agree to procced further", Toast.LENGTH_LONG).show();
        } else {
            validation = true;
        }
        if (validation) {
            returnDataToActivity();
        }
    }

    /*
    *  returnDataToActivity method return Hashmap to the parent activity
    *
    *
    * */
    private void returnDataToActivity() {
        HashMap<ViewType, String> returnData = new HashMap<>();
        returnData.put(ViewType.FIRSTNAME, firstName.getText().toString());
        returnData.put(ViewType.LASTNAME, lastName.getText().toString());
        returnData.put(ViewType.EMAILADDRESS, emailAddress.getText().toString());
        returnData.put(ViewType.TELEPHONE, telephone.getText().toString());
        returnData.put(ViewType.FAX, fax.getText().toString());
        returnData.put(ViewType.COMPANY, company.getText().toString());
        returnData.put(ViewType.ADDRESS1, address1.getText().toString());
        returnData.put(ViewType.ADDRESS2, address2.getText().toString());
        returnData.put(ViewType.CITY, city.getText().toString());
        returnData.put(ViewType.PASSWORD, password.getText().toString());
        returnData.put(ViewType.ZIP, zip.getText().toString());
        try {
            ((GetResultBack) mContext).getResultBack(returnData);
        } catch (Exception e) {
            try {
                throw new Exception("Implement GetResultBack interface in your class");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    /*
    *
    * getAttachView method return View to the Activity
    * which implemented Interface GetAttachView
    *
    * */
    @Override
    public View getAttachView(ViewType type) {
        return viewIDMap.get(type);
    }

    /*
     *
     * removeViewById remove view from the form
     *
     *
     */
    @Override
    public void removeViewById(ViewType type) {
        viewIDMap.get(type).setVisibility(GONE);
    }
}
