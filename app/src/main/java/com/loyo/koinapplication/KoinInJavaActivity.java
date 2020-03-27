package com.loyo.koinapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.loyo.koinapplication.model.Girl;
import org.jetbrains.annotations.NotNull;
import org.koin.core.qualifier.Qualifier;
import static org.koin.core.parameter.DefinitionParametersKt.parametersOf;
import static org.koin.java.KoinJavaComponent.get;

public class KoinInJavaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Qualifier qualifier = new Qualifier() {
            @NotNull
            @Override
            public String getValue() {
                return "1";
            }
        };
        Girl a = get(Girl.class, qualifier, (() -> parametersOf("kaylee", 23)));
        Log.i("Main4Activity", a.toString());


    }
}
