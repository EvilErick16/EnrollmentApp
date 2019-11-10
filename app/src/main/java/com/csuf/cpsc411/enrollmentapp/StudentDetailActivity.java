package com.csuf.cpsc411.enrollmentapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.csuf.cpsc411.enrollmentapp.Adapter.VehicleAdapter;
import com.csuf.cpsc411.enrollmentapp.Model.Student;
import com.csuf.cpsc411.enrollmentapp.Model.StudentEnrollments;
import com.csuf.cpsc411.enrollmentapp.Model.Vehicle;

import java.util.ArrayList;

public class StudentDetailActivity extends AppCompatActivity {

    protected Menu detailMenu;
    protected int studentIndex;

    protected ListView vehicleView;
    protected VehicleAdapter va;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_detail_layout);

        studentIndex = getIntent().getIntExtra("studentIndex", 0);
        Student studentObject = StudentEnrollments.getInstance().getStudents().get(studentIndex);
        EditText fName = findViewById(R.id.f_name_id);
        EditText lName = findViewById(R.id.l_name_id);
        EditText cwid = findViewById(R.id.cwid_id);
        fName.setText(studentObject.getFirstName());
        lName.setText(studentObject.getLastName());
        String id = Integer.toString(studentObject.getCwid());
        cwid.setText(id);

        fName.setEnabled(false);
        lName.setEnabled(false);
        cwid.setEnabled(false);

        if (StudentEnrollments.getInstance().getStudents().get(studentIndex).getVehicles() != null){
            vehicleView = findViewById(R.id.vehicle_list_id);
            va = new VehicleAdapter(studentIndex);
            vehicleView.setAdapter(va);
        }

        final Button addVehicle = findViewById(R.id.add_vehicle_id);
        addVehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Vehicle v1 = new Vehicle("", "", 0);
                TextView makeView = findViewById(R.id.make_id);
                TextView modelView = findViewById(R.id.model_id);
                TextView yearView = findViewById(R.id.year_id);

                if (addVehicle.getText().toString().equals("Add Vehicle")){
                    addVehicle.setText("Done");

                    makeView.setText(v1.getMake());
                    modelView.setText(v1.getModel());
                    String year = Integer.toString(v1.getYear());
                    yearView.setText(year);

                    makeView.setEnabled(true);
                    modelView.setEnabled(true);
                    yearView.setEnabled(true);

                }
                else {
                    addVehicle.setText("Add Vehicle");
                    StudentEnrollments.getInstance().getStudents().get(studentIndex).addVehicle(v1);
                    va.notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        detailMenu = menu;
        getMenuInflater().inflate(R.menu.detail_menu_layout, detailMenu);
        detailMenu.findItem(R.id.action_edit).setVisible(true);
        detailMenu.findItem(R.id.action_done).setVisible(false);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_edit){
            EditText fName = findViewById(R.id.f_name_id);
            EditText lName = findViewById(R.id.l_name_id);
            EditText cwid = findViewById(R.id.cwid_id);

            fName.setEnabled(true);
            lName.setEnabled(true);
            cwid.setEnabled(true);

            detailMenu.findItem(R.id.action_edit).setVisible(false);
            detailMenu.findItem(R.id.action_done).setVisible(true);
        }
        else if (item.getItemId() == R.id.action_done){
            EditText fName = findViewById(R.id.f_name_id);
            EditText lName = findViewById(R.id.l_name_id);
            EditText cwid = findViewById(R.id.cwid_id);

            StudentEnrollments.getInstance().getStudents().get(studentIndex).setFirstName(fName.getText().toString());
            StudentEnrollments.getInstance().getStudents().get(studentIndex).setLastName(lName.getText().toString());
            int id = Integer.valueOf(cwid.getText().toString());
            StudentEnrollments.getInstance().getStudents().get(studentIndex).setCwid(id);

            fName.setEnabled(false);
            lName.setEnabled(false);
            cwid.setEnabled(false);

            detailMenu.findItem(R.id.action_edit).setVisible(true);
            detailMenu.findItem(R.id.action_done).setVisible(false);
        }
        return super.onOptionsItemSelected(item);
    }
}
