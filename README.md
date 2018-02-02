# MobikulFormBuilder
MobikulForm Builder library to create sign up page 

Add MyForm view in your xml.

        <com.example.manishchoudhary.formbuilder.CustomForm.MyForm
            android:id="@+id/mform"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content" />
            
           
Implement GetResultBack interface in your class.

public class MainActivity extends AppCompatActivity implements GetResultBack {
    private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
				EditText firstName= (EditText) mainBinding.mform.getAttachView(ViewType.FIRSTNAME);
        mainBinding.mform.removeViewById(ViewType.LASTNAME);
    }

    @Override
    public void getResultBack(HashMap<ViewType, String> map) {
        if (map.get(ViewType.ERROR) != null) {
            Toast.makeText(MainActivity.this, "Error-Here", Toast.LENGTH_SHORT).show();
        } else {
            String firstName = map.get(ViewType.FIRSTNAME);
            String lastName = map.get(ViewType.LASTNAME);
            String email = map.get(ViewType.EMAILADDRESS);
        }
    }
}

